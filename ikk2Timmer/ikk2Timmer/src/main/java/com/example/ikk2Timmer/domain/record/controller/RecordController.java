package com.example.ikk2Timmer.domain.record.controller;

import com.example.ikk2Timmer.domain.record.Dto.RecordDto;
import com.example.ikk2Timmer.domain.user.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Slf4j
@RestController
@RequestMapping(value = "/api/record")
@RequiredArgsConstructor
public class RecordController {
    private final MemberService memberService;
    @PostMapping("/")
    public String record(@RequestBody RecordDto recordDto){
        Principal principal = SecurityContextHolder.getContext().getAuthentication();
        memberService.saveRecord(principal, recordDto);
        return "success";
    }


}
