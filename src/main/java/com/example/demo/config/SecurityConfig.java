/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.config;

import jakarta.servlet.FilterChain;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 *
 * @author taoltech
 */
@Configuration
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain filter(HttpSecurity hs) throws Exception {
        
        hs.cors(c -> c.disable());
        hs.csrf(c -> c.disable());
        
        
        //
        return hs.build();
    }
}
