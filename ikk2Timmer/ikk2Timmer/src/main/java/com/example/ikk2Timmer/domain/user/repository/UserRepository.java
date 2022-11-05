package com.example.ikk2Timmer.domain.user.repository;

import com.example.ikk2Timmer.domain.user.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByName(String name);
}
