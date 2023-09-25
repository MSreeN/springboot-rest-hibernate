package com.learn.rest.websevices.restfulwebservices.jpa;

import com.learn.rest.websevices.restfulwebservices.users.User;
import com.learn.rest.websevices.restfulwebservices.users.UserDaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.swing.text.html.Option;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserJpaResource {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDaoService userDaoService;

    @GetMapping("/jpa/users")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/jpa/users/{id}")
    public Optional<User> findUserById(@PathVariable int id){
        return userRepository.findById(id);
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<User> addNewUser(@Valid @RequestBody User user){
        User savedUser = userRepository.save(user);
//        System.out.println("--------------" +
//                ServletUriComponentsBuilder.fromCurrentRequestUri().toString());
        URI uri = ServletUriComponentsBuilder
                //getting path of the current request
                .fromCurrentRequestUri()
                //appending or replacing id with user id
                .path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/jpa/users/{id}")
    public  void deleteUser(@PathVariable int id){
        userRepository.deleteById(id);
    }

}
