package com.learn.rest.websevices.restfulwebservices.users;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();

    private static int userIdCount = 0;
    static{
        users.add(new User(++userIdCount, "Sree", LocalDate.now().minusYears(20)));
        users.add(new User(++userIdCount, "Mahesh", LocalDate.now().minusYears(25)));
        users.add(new User(++userIdCount, "Naga", LocalDate.now().minusYears(10)));
    }

    public List<User> findAll(){
        return users;
    }

    public User findById(int id){
        Predicate<User> findByIdPredicate = user -> user.getId() == id;
        User user = users.stream().filter(findByIdPredicate).findFirst().orElse(null);
        if(user == null){
            throw new UserNotFoundException("id: "+id);
        }
        return user;
    }

    public User save(User user){
        user.setId(++userIdCount);
        users.add(user);
        return user;
    }

}
