/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controllers;

import com.example.demo.repositories.UserRepository;
import com.example.demo.requests.LoginDTO;
import com.example.demo.requests.RegisterDTO;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author taoltech
 */
@RestController
@RequestMapping("auth")
public class RegisterController {
    
    @Autowired
    private UserRepository repository;
    
    @Autowired
    private PasswordEncoder PasswordEncoder;
    
    @PostMapping("register")
    public ResponseEntity<?> login(@RequestBody RegisterDTO dto) {
    
            
        Map<String, Object> data = new HashMap<>();
        data.put("status", true);
        data.put("message", "Welcome to the APIs. Let's get started");
        return ResponseEntity.ok(data);
    }
}
