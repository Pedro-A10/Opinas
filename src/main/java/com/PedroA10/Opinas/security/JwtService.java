package com.PedroA10.Opinas.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.*;

@Service
public class JwtService {

    private final SecretKey jwtKey;
    private final AESUtil aesUtil;

    public JwtService(AESUtil aesUtil, @Value("${jwt.secret}") String jwtSecret) {
      this.jwtKey = Keys.hmacShaKeyFor(Base64.getDecoder().decode(jwtSecret));
      this.aesUtil = aesUtil;
    }

    public String extractUsername(String token) {
      Claims claims = extractALLClaims(token);
      return claims.getSubject();
    }

    public Date extractExpiration(String token) {
      return extractALLClaims(token).getExpiration();
    }

    private Claims extractALLClaims(String token) {
      return Jwts.parser()
        .verifyWith(jwtKey)
        .build()
        .parseSignedClaims(token)
        .getPayload();
    }

    private Boolean isTokenExpired(String token){
      return extractExpiration(token).before(new Date());
    }

  public String generateToken(String username) {
    Map<String, Object> claims = new HashMap<>();
    return createToken(claims, username);
  }

    private String createToken(Map<String, Object> claims, String subject) {
      return Jwts.builder()
        .claims(claims)
        .subject(subject)
        .header().empty().add("typ","JWT")
        .and()
        .issuedAt(new Date(System.currentTimeMillis()))
        .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 50))
        .signWith(jwtKey)
        .compact();
    }
    
    public boolean validateToken(String token) {
      return !isTokenExpired(token);
    }
}
