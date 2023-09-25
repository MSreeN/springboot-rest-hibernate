package com.learn.rest.websevices.restfulwebservices.jpa;

import com.learn.rest.websevices.restfulwebservices.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
