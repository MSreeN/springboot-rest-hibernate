package com.learn.rest.websevices.restfulwebservices.users;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserDaoService {

    private static List<User> users = new ArrayList<>();
    static{
        users.add(new User(1, "Sree", LocalDate.now().minusYears(20)));
        users.add(new User(2, "Mahesh", LocalDate.now().minusYears(25)));
        users.add(new User(3, "Naga", LocalDate.now().minusYears(10)));
    }
}
