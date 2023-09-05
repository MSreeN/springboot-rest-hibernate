package com.learn.rest.websevices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    public HelloWorld helloWorldBean(){
        return new HelloWorld("Hello");
    }

    @GetMapping("/path/{name}")
    public HelloWorld helloWorldPath(@PathVariable String name){
        return new HelloWorld(name);
    }
}
