package com.example.ikk2Timmer.domain.user.service;

import com.example.ikk2Timmer.domain.user.Entity.dto.SignUpDto;

import java.util.Map;

public interface MemberService {
    public Long signUp(SignUpDto signUpDto) throws Exception;

    public String login(Map<String,String> members);

}
