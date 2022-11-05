package com.example.ikk2Timmer.domain.user.service;

import com.example.ikk2Timmer.domain.record.Dto.RecordDto;
import com.example.ikk2Timmer.domain.user.Entity.User;

import java.security.Principal;

public interface UserService {
    void signUpUser(User user);

    void saveRecord(Principal principal, RecordDto recordDto);

}
