/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.config;

import com.example.demo.security.AuthEntryPoint;
import com.example.demo.security.TokenAuthenticationFilter;
import jakarta.servlet.FilterChain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 *
 * @author taoltech
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    @Autowired
    AuthEntryPoint authEntry;
    
    @Bean
    TokenAuthenticationFilter tokenFilter() {
        return new TokenAuthenticationFilter();
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public SecurityFilterChain filter(HttpSecurity hs) throws Exception {
        
        hs.cors(c -> c.disable());
        hs.csrf(c -> c.disable());
        
        hs.authorizeHttpRequests(auth -> 
                auth.requestMatchers("auth/**", "/").permitAll()
                .anyRequest().authenticated()
                
        );
        
        hs.exceptionHandling(eh -> eh.authenticationEntryPoint(authEntry));
        
        hs.addFilterBefore(tokenFilter(), UsernamePasswordAuthenticationFilter.class);
        
        //
        return hs.build();
    }
}
