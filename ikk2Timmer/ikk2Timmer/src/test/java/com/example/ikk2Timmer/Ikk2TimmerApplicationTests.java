package com.example.ikk2Timmer;

import com.example.ikk2Timmer.Domain.User;

import com.example.ikk2Timmer.Service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
class Ikk2TimmerApplicationTests {

	@Test
	void contextLoads() {
	}

}
