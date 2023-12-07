/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.demo.models.User;
import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author taoltech
 */
@Component
public class JWTUtils {
   
    @Value("${jwt.secret}")
    private String secretKey;
    
    public String createToken(User user) {
        
        long aDay = (60 * 60 * 24) * 1000;
        JWTCreator.Builder builder = JWT.create();
        
        return builder.withSubject(user.getEmail())
                .withClaim("isLoggedIn", true)
                .withExpiresAt(new Date(System.currentTimeMillis() + aDay))
                .sign(Algorithm.HMAC256(secretKey));
        
    }
    
    public String getSubject(String token) {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secretKey)).build();
        DecodedJWT decodedJWT = verifier.verify(token);
        return decodedJWT.getSubject();
    }
    
    public boolean isExpired(String token) {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secretKey)).build();
        DecodedJWT decodedJWT = verifier.verify(token);
        return decodedJWT.getExpiresAt().after(new Date());
    }
    
}
