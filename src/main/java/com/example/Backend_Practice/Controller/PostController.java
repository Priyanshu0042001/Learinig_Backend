package com.example.Backend_Practice.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.example.Backend_Practice.Model.Post;
import com.example.Backend_Practice.Repository.PostRepository;


import java.util.UUID;
@RestController
@RequestMapping("/api/create")
public class PostController {
    @Autowired
         private PostRepository followeRepository;
       @PostMapping
       public ResponseEntity<Post>addPost(@RequestBody Post value)
       {
           try {
                followeRepository.save(value);
                return new ResponseEntity<>(HttpStatus.CREATED);
           } catch (Exception e) {
              System.out.println(e);
              return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
           }
       }
       @GetMapping
       public ResponseEntity<List<Post>>Findall()
       {
            try {
                List<Post>ans=followeRepository.findAll();
                System.out.println(ans);
                return  new ResponseEntity<>(ans,HttpStatus.FOUND);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);  
        }

       }
       @GetMapping("{id}")
       @ResponseBody
       public ResponseEntity<List<Post>>getbyUser_id(@PathVariable UUID id)
       {
             try {
                  List<Post>answer=followeRepository.findbyUserid(id);
                  if(answer.isEmpty()&&answer.size()==0)
                  {
                      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                  }
                  System.out.println("ANSWER WE FOUND IS "+answer);
                  return new ResponseEntity<>(answer,HttpStatus.FOUND);
             } catch (Exception e) {
                 return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
             }
       }   
       @DeleteMapping("{id}")
       public void deleteById(@PathVariable UUID user_id)
       {
            try {
                followeRepository.deleteById(user_id);
            } catch (Exception e) {
                return;
            }
       }
       @DeleteMapping("/notes/{id}")
       public  void deletbyNote_id(@PathVariable UUID id)
       {
             try {
                followeRepository.deletebyNotesId(id);

             } catch (Exception e) {
                System.out.println(e);
                 return;
             }
       }
}
