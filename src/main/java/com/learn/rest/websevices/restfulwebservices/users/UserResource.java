package com.learn.rest.websevices.restfulwebservices.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public User addNewUser(@RequestBody User user){
        return userDaoService.save(user);
    }

}
