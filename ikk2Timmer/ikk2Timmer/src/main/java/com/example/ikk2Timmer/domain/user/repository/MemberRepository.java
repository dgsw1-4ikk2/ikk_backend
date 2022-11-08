package com.example.ikk2Timmer.domain.user.repository;

import com.example.ikk2Timmer.domain.user.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long> {
    Optional<Member> findByName(String name);

}
