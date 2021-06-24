package com.example.demo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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
        var user = model.getAttribute("user");
        if (user == null) {
            user = new User();
            model.addAttribute("user", user);
        }
        return "login";
    }

    @PostMapping(path = "/validateLogin")
    public String validateLogin(@ModelAttribute("user") User user, RedirectAttributes redir) {
        var loginUser = userService.login(user.getUserName(), user.getPassword());
        redir.addFlashAttribute("user", user);
        if (loginUser == null) {
            redir.addFlashAttribute("error", "Invalid Username or password");
            return "redirect:/user/login";
        } else {
            if (loginUser.getType() == 1) {
                return "redirect:/shop/home";
            } else {
                return "index"; // return admin dashboard
            }
        }
    }

    @GetMapping("/register")
    public String showRegistrationPage(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        user.setType(1);
        var isRegestered = userService.register(user);
        if (isRegestered) {
            return "index";
        } else {
            return "register";
        }
    }

}
