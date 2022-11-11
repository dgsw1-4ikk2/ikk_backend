package com.example.ikk2Timmer.domain.record.controller;

import com.example.ikk2Timmer.domain.record.Dto.RecordDto;
import com.example.ikk2Timmer.domain.user.service.UserService;
import com.example.ikk2Timmer.global.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Slf4j
@RestController
@RequestMapping(value = "/api/record")
@RequiredArgsConstructor
public class RecordController {
    private final UserService userService;

    private final JwtTokenProvider jwtTokenProvider;
    @PostMapping("/")
    public String record(@RequestBody RecordDto recordDto){
        Principal principal = SecurityContextHolder.getContext().getAuthentication();
        userService.saveRecord(principal, recordDto);
        return "success";
    }


}
