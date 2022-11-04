package com.example.ikk2Timmer.Service;

import com.example.ikk2Timmer.Domain.User;
import com.example.ikk2Timmer.Dto.RecordDto;
import com.example.ikk2Timmer.Security.UserDetailsImpl;

import java.security.Principal;

public interface UserService {
    void signUpUser(User user);

    void saveRecord(Principal principal, RecordDto recordDto);

}
