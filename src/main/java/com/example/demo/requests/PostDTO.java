/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.requests;

import com.example.demo.models.Post;
import lombok.Data;

/**
 *
 * @author taoltech
 */
@Data
public class PostDTO {
    
    private String title;
    
    private String description;
    
    public Post toPost() {
        return new Post(title, description);
    }
}
