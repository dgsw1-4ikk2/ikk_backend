package com.example.ikk2Timmer.contoroller;

import com.example.ikk2Timmer.Domain.User;
import com.example.ikk2Timmer.Service.Impl.UserServiceImpl;
import com.example.ikk2Timmer.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/SignUp")
    public String signUp() {
        return "sign";
    }

    @PostMapping("/SignUp")
    public String signUp(User user, Model model) {
        userService.signUpUser(user);
        model.addAttribute("name",user.getName());
        return "success";
    }


    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

}
