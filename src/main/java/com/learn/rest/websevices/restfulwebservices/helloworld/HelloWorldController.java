package com.learn.rest.websevices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    public HelloWorld helloWorldBean(){
        return new HelloWorld("Hello");
    }
}
