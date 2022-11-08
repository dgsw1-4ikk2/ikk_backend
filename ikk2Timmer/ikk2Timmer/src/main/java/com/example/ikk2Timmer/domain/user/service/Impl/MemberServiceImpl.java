package com.example.ikk2Timmer.domain.user.service.Impl;

import com.example.ikk2Timmer.domain.user.Entity.Member;
import com.example.ikk2Timmer.domain.user.Entity.dto.SignUpDto;
import com.example.ikk2Timmer.domain.user.repository.MemberRepository;
import com.example.ikk2Timmer.domain.user.service.MemberService;
import com.example.ikk2Timmer.global.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    @Override
    public Long signUp(SignUpDto signUpDto) throws Exception {
        Member member = memberRepository.save(signUpDto.toEntity());
        member.encodePassword(passwordEncoder);

        member.addUserAuthority();
        return member.getId();
    }

    @Override
    public String login(Map<String, String> members) {
        Member member = memberRepository.findByName(members.get("name"))
                .orElseThrow(() -> new IllegalArgumentException("가입 되지 않은 아이디"));
       /* String password = members.get("password");
        if (passwordEncoder.matches(password,e)) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }*/

        List<String> roles = new ArrayList<>();
        roles.add(member.getRole().name());

        return jwtTokenProvider.createToken(member.getName(), roles);
    }
}
