/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controllers;

import com.example.demo.models.Post;
import com.example.demo.repositories.PostRepository;
import com.example.demo.requests.PostDTO;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author taoltech
 */
@RestController
@RequestMapping("posts")
public class PostController {
    
    @Autowired
    private PostRepository repository;
    
    @GetMapping("")
    public ResponseEntity<?> listPosts() {
        
        List<Post> posts = repository.findAll();
        System.out.println("ALL: " + posts.size());
        
        Map<String, Object> data = new HashMap<>();
        data.put("status", true);
        data.put("message", "Post list");
        data.put("data", posts);
        
        return ResponseEntity.ok().body(data);
    }
    
    @PostMapping("")
    public ResponseEntity<?> createPost(@RequestBody PostDTO dto) {
        
        Post createdModel = repository.save(dto.toPost());
        
        Map<String, Object> data = new HashMap<>();
        data.put("status", true);
        data.put("message", "Created");
        data.put("data", createdModel);
        
        return ResponseEntity.ok().body(data);
    }
}
