package com.example.Backend_Practice.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.Backend_Practice.Model.Post;

import jakarta.transaction.Transactional;
import java.util.List;
public interface PostRepository extends JpaRepository<Post,UUID> {
       @Transactional
       @Query(value = "select *from follower_db",nativeQuery = true)
       public List<Post>findall();
       @Transactional
       @Query(value = "Select *from follower_db where user_id=?1",nativeQuery = true)
       public List<Post>findbyUserid(UUID  id);
       @Transactional
       @Modifying
       @Query(value = "Delete from follower_db where post_id=?1",nativeQuery = true)
       public void deletebyNotesId(UUID notes_id);  
}
