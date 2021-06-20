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

    public boolean login(String userName, String password) {
        var users = userRep.findAll();
        for (User user : users) {
            var user_name = user.getUser_name();
            var pass = user.getPassword();
            if (user_name.equals(userName.trim().toLowerCase()) && pass.equals(password)) {
                return true;
            }
        }
        return false;
    }

}