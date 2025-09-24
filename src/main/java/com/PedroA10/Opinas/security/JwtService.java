package com.PedroA10.Opinas.security;

import org.springframework.stereotype.Service;

@Service
public class JwtService {

    private final AESUtil aesUtil;

    public JwtService(AESUtil aesUtil) {
        this.aesUtil = aesUtil;
    }


}
