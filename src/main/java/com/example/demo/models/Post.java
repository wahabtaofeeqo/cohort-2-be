/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 *
 * @author taoltech
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "posts")
public class Post implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column
    private String title;
    
    @Column
    private String desciption;
    
    @UpdateTimestamp
    private Date updated_at;
    
    @CreationTimestamp
    private Date created_at;

    public Post(String title, String desciption) {
        this.title = title;
        this.desciption = desciption;
    }
}
