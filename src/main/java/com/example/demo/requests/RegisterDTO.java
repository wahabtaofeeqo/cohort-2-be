/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.requests;

import com.example.demo.models.User;
import lombok.Data;

/**
 *
 * @author taoltech
 */

@Data
public class RegisterDTO {
    private String name;
    private String email;
    private String password;
    
    public User toUser() {
        return new User(name, email, password);
    }
}
