package com.example.Backend_Practice.Model;

import java.sql.Date;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="follower_db")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID post_id;
    private String post_description;
    private String post_content;
    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "user_id")
    private User user;
    @CreationTimestamp
    private Date accepDate;
}

