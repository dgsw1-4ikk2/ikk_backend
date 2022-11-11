package com.example.ikk2Timmer.domain.user.Entity.dto;

import com.example.ikk2Timmer.domain.user.Entity.Member;
import com.example.ikk2Timmer.domain.user.Entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class SignUpDto {
    private String name;

    private String password;

    private Role role;

    @Builder
    public Member toEntity() {
        //System.out.println(password);
        return Member.builder()
                .username(name)
                .password(password)
                .role(role)
                .build();
    }
}
