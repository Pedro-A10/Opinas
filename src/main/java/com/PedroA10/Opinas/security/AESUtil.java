package com.PedroA10.Opinas.security;

import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;

@Component
public class AESUtil {

        private final String secretKey;

        private static final int IV_SIZE = 16;

        public AESUtil(String secretKey) {
            if (secretKey == null || secretKey.length() != 16) {
                throw new IllegalArgumentException("Secret Key must be exactly 16 characters long.");
            }
            this.secretKey = secretKey;
        }

        public String encrypt(String plaintext) {
            try {
                byte[] iv = new byte[IV_SIZE];
                SecureRandom random = new SecureRandom();
                random.nextBytes(iv);
                IvParameterSpec ivSpec = new IvParameterSpec(iv);

                SecretKeySpec keySpec = new SecretKeySpec(secretKey.getBytes(), "AES");
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

                cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
                byte[] encrypted = cipher.doFinal(plaintext.getBytes());

                byte[] encryptedIvAndText = new byte[IV_SIZE + encrypted.length];
                System.arraycopy(iv, 0, encryptedIvAndText, 0, IV_SIZE);
                System.arraycopy(encrypted, 0, encryptedIvAndText, IV_SIZE, encrypted.length);

                return Base64.getEncoder().encodeToString(encryptedIvAndText);
            }catch (Exception e) {
                throw new RuntimeException("Error encrypting: " + e.getMessage(), e);
            }
        }

        public String decrypt(String encryptBase64) {
            try {
                byte[] encryptedIvTextBytes = Base64.getDecoder().decode(encryptBase64);

                byte[] iv = new byte[IV_SIZE];
                System.arraycopy(encryptedIvTextBytes, 0, iv, 0, IV_SIZE);
                IvParameterSpec ivSpec = new IvParameterSpec(iv);

                int encryptedSize = encryptedIvTextBytes.length - IV_SIZE;
                byte[] encryptedBytes = new byte[encryptedSize];
                System.arraycopy(encryptedIvTextBytes, IV_SIZE, encryptedBytes, 0, encryptedSize);

                SecretKeySpec keySpec = new SecretKeySpec(secretKey.getBytes(), "AES");
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

                cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
                byte[] decrypted = cipher.doFinal(encryptedBytes);

                return new String(decrypted, StandardCharsets.UTF_8);
            }catch (Exception e){
                throw new RuntimeException("Error decrypting: " + e.getMessage(), e);
            }
        }
}