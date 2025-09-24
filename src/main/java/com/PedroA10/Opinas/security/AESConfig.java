package com.PedroA10.Opinas.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AESConfig {

    @Value("${aes.secret-key}")
    private String secretKey;

    @Bean
    public AESUtil aesUtil() {
        return new AESUtil(secretKey);
    }
}
