package com.example.ikk2Timmer.global.Security;

import com.example.ikk2Timmer.domain.user.Entity.User;
import com.example.ikk2Timmer.domain.user.repository.MemberRepository;
import com.example.ikk2Timmer.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class UserDetailServiceImpl implements UserDetailsService  {
    private final MemberRepository memberRepository;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return (UserDetails) memberRepository.findByName(username)
                .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없아요"));
    }
}
