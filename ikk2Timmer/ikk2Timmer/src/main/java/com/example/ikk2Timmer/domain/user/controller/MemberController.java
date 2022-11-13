package com.example.ikk2Timmer.domain.user.controller;

import com.example.ikk2Timmer.domain.user.Entity.dto.SignUpDto;
import com.example.ikk2Timmer.domain.user.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signUp")
    public Long signUp(@RequestBody SignUpDto signUpDto) throws Exception {
       return memberService.signUp(signUpDto);
    }

    @PostMapping("/login")
    public String login(@RequestBody Map<String, String>member) {
        return memberService.login(member);
    }
}
