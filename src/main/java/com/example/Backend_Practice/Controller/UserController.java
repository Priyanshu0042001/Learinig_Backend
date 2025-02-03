package com.example.Backend_Practice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Backend_Practice.Model.User;
import com.example.Backend_Practice.Repository.UserRepository;
import com.example.Backend_Practice.Services.UserService;



import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/Login")
public class UserController {
         @Autowired
         private UserService userService;
         @Autowired
         private UserRepository userRepository;
         @Async
         @PostMapping
         public ResponseEntity<User>addUser(@RequestBody User user)
         {  
               try {
                      
                      User ans=userService.saveUser(user); 
                      return new ResponseEntity<>(ans,HttpStatus.CREATED);
                      
                      
               } catch (Exception e) {
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
               }
         }
         @GetMapping
         public List<User>getAllUser()
         {
               try {
                  
                  List<User>ans=userRepository.findSelected();
                  if(ans.isEmpty())
                  {
                     System.out.println("I AM INSIDE THE IF CONDITION");
                      return null;
                  }
                  return ans;
                                    
               } catch (Exception e) {
                  return null;
               }
         }
         @GetMapping("{id}")
         public User FindUser(@PathVariable UUID id)
         {
                 try {
                      return userRepository.findbyUserId(id);
                 } catch (Exception e) {
                     return null;
                 }
         }
         @DeleteMapping("{id}")
         public void deleteUser(@PathVariable UUID id)
         {
                try {
                    userRepository.deleteById(id);
                } catch (Exception e) {
                     return;
                }
         }
       
         
}
