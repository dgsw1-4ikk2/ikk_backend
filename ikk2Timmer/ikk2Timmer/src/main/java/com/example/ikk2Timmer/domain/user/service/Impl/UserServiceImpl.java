package com.example.ikk2Timmer.domain.user.service.Impl;

import com.example.ikk2Timmer.domain.record.Entity.Record;
import com.example.ikk2Timmer.domain.record.Dto.RecordDto;
import com.example.ikk2Timmer.domain.user.Entity.User;
import com.example.ikk2Timmer.domain.user.repository.UserRepository;
import com.example.ikk2Timmer.domain.user.service.UserService;
import com.example.ikk2Timmer.global.Security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public void signUpUser(User user) {
        System.out.println("SignUp service " + user);
        String encodedPassword =  passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
    }

    @Override
    public void saveRecord(Principal principal, final RecordDto recordDto) {
        UserDetails userDetails = findUserDetails(principal.getName());
        if (!(userDetails instanceof UserDetailsImpl)) {
            throw new IllegalArgumentException();
        }

        User user = ((UserDetailsImpl) userDetails).getUser();
        Record record = recordDto.toEntity();
        user.addRecord(record);
        userRepository.save(user);
    }

    @Transactional(readOnly = true)
    protected UserDetails findUserDetails(String name) {
        return userDetailsService.loadUserByUsername(name);
    }
}
