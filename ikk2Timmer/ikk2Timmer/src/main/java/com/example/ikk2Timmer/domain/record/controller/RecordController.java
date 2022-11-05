package com.example.ikk2Timmer.domain.record.controller;

import com.example.ikk2Timmer.domain.record.Dto.RecordDto;
import com.example.ikk2Timmer.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping(value = "/api/record")
@RequiredArgsConstructor
public class RecordController {
    private final UserService userService;

    @GetMapping("/record")
    public String record()
    {
        return "";
    }

    @PostMapping("/record")
    public String record(RecordDto recordDto, Principal principal) {
        userService.saveRecord(principal, recordDto);
        return "success";
    }
}
