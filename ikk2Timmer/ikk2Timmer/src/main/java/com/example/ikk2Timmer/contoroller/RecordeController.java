package com.example.ikk2Timmer.contoroller;

import com.example.ikk2Timmer.Domain.Record;
import com.example.ikk2Timmer.Service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class RecordeController {
    @Autowired
    private RecordService recordService;

    @GetMapping("/record")
    public String record()
    {
        return "record";
    }

    @PostMapping("/record")
        public String record(Record record , Principal principal){
        String username  = principal.getName();
        record.setUsername(username);
        recordService.record(record);
    return "success";
    }
}

//
