package com.example.ikk2Timmer.domain.user.service.Impl;

import com.example.ikk2Timmer.domain.record.Dto.RecordDto;
import com.example.ikk2Timmer.domain.record.Entity.Record;
import com.example.ikk2Timmer.domain.user.Entity.Member;
import com.example.ikk2Timmer.domain.user.Entity.dto.SignUpDto;
import com.example.ikk2Timmer.domain.user.repository.MemberRepository;
import com.example.ikk2Timmer.domain.user.service.MemberService;
import com.example.ikk2Timmer.global.jwt.JwtTokenProvider;
import com.example.ikk2Timmer.global.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    private final JwtTokenProvider jwtTokenProvider;

    private final UserDetailsService userDetailsService;

    List<String> roles = new ArrayList<>();

    public List<String> getRoles() {
        return roles;
    }

    @Transactional
    @Override
    public Long signUp(SignUpDto signUpDto) {
        Member member = memberRepository.save(signUpDto.toEntity());
        member.encodePassword(passwordEncoder);
        member.addUserAuthority();
        return member.getId();
    }

    @Override
    public String login(Map<String, String> members) {
        Member member = memberRepository.findByUsername(members.get("name"))
                .orElseThrow(() -> new IllegalArgumentException("가입 되지 않은 아이디"));
        if (!passwordEncoder.matches(members.get("password"), member.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }
        roles.add(member.getRole().name());
        return jwtTokenProvider.createToken(member.getUsername(), roles);
    }

    @Override
    @Transactional
    public void saveRecord(Principal principal, RecordDto recordDto) {
        UserDetails userDetails = findUserDetails(principal.getName());
        if (!(userDetails instanceof UserDetailsImpl)) {
            throw new IllegalArgumentException();
        }

        Member member = ((UserDetailsImpl) userDetails).getMember();
        Record record = recordDto.toEntity();
        member.addRecord(record);
        memberRepository.save(member);
    }

    @Transactional(readOnly = true)
    protected UserDetails findUserDetails(String name) {
        return userDetailsService.loadUserByUsername(name);
    }
}
