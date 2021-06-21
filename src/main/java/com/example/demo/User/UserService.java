package com.example.demo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRep userRep;

    public List<User> getUser() {
        return userRep.findAll();
    }

    public User login(String userName, String password) {
        var user = userRep.login(userName, password);
        return user;
    }

    public boolean register(User user) {
        try {
            userRep.save(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}