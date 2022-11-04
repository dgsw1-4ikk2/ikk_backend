package com.example.ikk2Timmer.contoroller;

import com.example.ikk2Timmer.Dto.RecordDto;
import com.example.ikk2Timmer.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class RecordController {
    private final UserService userService;

    @GetMapping("/record")
    public String record()
    {
        return "record";
    }

    @PostMapping("/record")
    public String record(RecordDto recordDto, Principal principal) {
        userService.saveRecord(principal, recordDto);
        return "success";
    }
}
