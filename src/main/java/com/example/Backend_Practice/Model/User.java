package com.example.Backend_Practice.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "User_db")
public class User {
        @Id
       @GeneratedValue(strategy = GenerationType.AUTO)
        private UUID user_id;
       @Column(nullable = false)
       private String name;
       @Column(nullable = false,unique = true)
       private String email;
       @Column(nullable = false)
       private String password;     
       @Column(name = "user_image")
       private String  image;
       @CreationTimestamp
       private Date created_date;
}
