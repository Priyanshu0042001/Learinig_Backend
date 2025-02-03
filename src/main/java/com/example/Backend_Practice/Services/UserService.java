package com.example.Backend_Practice.Services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Backend_Practice.Model.User;
import com.example.Backend_Practice.Repository.UserRepository;
@Service
public class UserService {
       @Autowired
       private UserRepository userRepository;
       public User saveUser(User user)
       {
                  try {
                         if(userRepository.findbyemail(user.getEmail().toString())==null)
                         {
                              System.out.println("I AM HERE IN IF CONDITION");
                              String ans=BCrypt.gensalt(10);
                              String y=BCrypt.hashpw(user.getPassword(), ans);
                              user.setPassword(y);                         
                              userRepository.save(user);                        
                              return user;
                         }
                         System.out.println("I AM HERE");
                        return null;
                        
                        
                  } catch (Exception e) {
                        return null;
                  }
       }
       
      
}
