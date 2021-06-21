package com.example.demo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequestMapping(path = "/user")

public class UserCont {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLoginPage(Model model) {
User user = new User();
        model.addAttribute("user", user);
        return "login";
    }

    @PostMapping(path =  "/validateLogin")
    public String validateLogin(@ModelAttribute("user") User user) {
        var loginUser = userService.login(user.getUser_name(), user.getPassword());
        if (loginUser.equals(null)) {
            return "/login";
        } else {
            return "index";
        }
    }

}
