/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.security;

import com.example.demo.services.UserDetailsServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 *
 * @author taoltech
 */
public class TokenAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JWTUtils jwtUtil;
    
    @Autowired
    private UserDetailsServiceImpl serviceImpl;
    
    // 1. Extract the token
    // 2. Use token to get userdetails
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = getToken(request);
        if(token != null) {
            String username = jwtUtil.getSubject(token); // Extract the Username
            
            UserDetails userDetails = serviceImpl.loadUserByUsername(username); // Get User Details Obj
            
            // Create Token Obj
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null);
            authenticationToken.setDetails(userDetails);
            
            // Update the Security context
            SecurityContext sc = SecurityContextHolder.getContext();
            sc.setAuthentication(authenticationToken);
        }
        
        //
        doFilter(request, response, filterChain);
    }
    
    private String getToken(HttpServletRequest request) {
        String token = null;
        String header = request.getHeader("Authorization");
        if(header != null) {
            token = header.substring("Bearer ".length());
        }
        
        return token;
    }
}
