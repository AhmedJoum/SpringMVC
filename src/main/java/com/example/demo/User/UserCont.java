package com.example.demo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
    public String validateLogin(@ModelAttribute("user") User user, RedirectAttributes redir, 
    HttpServletRequest request) {
        var loginUser = userService.login(user.getUserName(), user.getPassword());
        redir.addFlashAttribute("user", user);
        if (loginUser == null) {
            redir.addFlashAttribute("error", "Invalid Username or password");
            return "redirect:/user/login";
        } else {
            request.getSession().setAttribute("user", loginUser);
            if (loginUser.getType() == 1) {
                return "redirect:/shop/home";
            } else {
                return "redirect:/shop/home"; // return admin dashboard
            }
        }
    }

    @GetMapping("/register")
    public String showRegistrationPage(Model model) {
        User user = new User();
        user.setType(1);
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user, RedirectAttributes redir) {
        user.setType(1);
        var isRegestered = userService.register(user);
        if (isRegestered) {
            return "redirect:/user/login";
        } else {
            redir.addFlashAttribute("error", "User Name already exists, try other one");
            return "redirect:/user/register";
        }
    }

}
