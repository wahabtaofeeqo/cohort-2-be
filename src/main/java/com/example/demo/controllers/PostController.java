/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author taoltech
 */
@RestController
@RequestMapping("posts")
public class PostController {
    
    @GetMapping("")
    public ResponseEntity<?> listPosts() {
        return ResponseEntity.ok("This is a Test");
    }
}
