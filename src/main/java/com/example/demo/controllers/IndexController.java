/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controllers;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author taoltech
 */

@RestController
public class IndexController {
    
    @GetMapping("/")
    public ResponseEntity<?> index() {
        Map<String, Object> data = new HashMap<>();
        data.put("status", true);
        data.put("message", "Welcome to the APIs. Let's get started");
        return ResponseEntity.ok(data);
    }
}
