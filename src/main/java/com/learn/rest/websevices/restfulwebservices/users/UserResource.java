package com.learn.rest.websevices.restfulwebservices.users;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    @Autowired
    private UserDaoService userDaoService;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userDaoService.findAll();
    }

    @GetMapping("users/{id}")
    public User findUserById(@PathVariable int id){
        return userDaoService.findById(id);
    }

    @PostMapping("/users")
    public ResponseEntity<User> addNewUser(@Valid @RequestBody User user){
        User savedUser = userDaoService.save(user);
//        System.out.println("--------------" +
//                ServletUriComponentsBuilder.fromCurrentRequestUri().toString());
        URI uri = ServletUriComponentsBuilder
                //getting path of the current request
                .fromCurrentRequestUri()
                //appending or replacing id with user id
                .path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/users/{id}")
    public  void deleteUser(@PathVariable int id){
        userDaoService.deleteUserById(id);
    }

}
