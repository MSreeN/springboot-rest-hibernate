package com.learn.rest.websevices.restfulwebservices.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Configuration
public class UserSecurity {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails userDetails = createUser("sree", "sree");
        UserDetails userDetails1 = createUser("nag", "nag");
        return new InMemoryUserDetailsManager(userDetails1, userDetails);
    }


    public UserDetails createUser(String username, String passwrod){
        Function<String, String> passwordEncoder = user -> passwordEncoder().encode(user);
        UserDetails userDetails = User.builder()
                .passwordEncoder(passwordEncoder)
                .username(username)
                .password(passwrod)
                .build();
        return userDetails;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
