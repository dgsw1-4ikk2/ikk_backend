package com.example.ikk2Timmer.domain.user.controller;

import com.example.ikk2Timmer.domain.user.Entity.User;
import com.example.ikk2Timmer.domain.user.service.Impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
public class UserController {


    private final UserServiceImpl userService;


    @RequestMapping("/")
    public String home(Principal principal ,Model model) {
        String user = principal.getName();
        model.addAttribute("test", user +"님 환영합니다");
        return "index";
    }

    @GetMapping("/SignUp")
    public String signUp() {
        return "sign";
    }

    @PostMapping("/SignUp")
    public String signUp(@RequestBody User user, Model model) {
        System.out.println("request");
        System.out.println(user);
        userService.signUpUser(user);
        System.out.println("signUp");
        model.addAttribute("name",user.getName());
        model.addAttribute("idx",user.getId());
        return "success";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }


}
