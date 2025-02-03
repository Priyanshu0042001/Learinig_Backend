package com.example.Backend_Practice.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import com.example.Backend_Practice.Model.User;
public interface UserRepository extends JpaRepository<User,UUID>{
      @Query(value ="Select email from user_db where email=?1",nativeQuery = true)
      public String findbyemail(String email);
      @Query(value = "Select * from user_db",nativeQuery = true)
      public List<User>findSelected();
      @Query(value="Select *from user_db where user_id=?1",nativeQuery = true)
      public User findbyUserId(UUID id);
}      
