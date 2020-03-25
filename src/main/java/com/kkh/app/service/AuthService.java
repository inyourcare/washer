package com.kkh.app.service;

import com.kkh.app.jpa.entity.UserEntity;
import com.kkh.app.jpa.repository.UserRepository;
import com.kkh.app.dto.request.SignUpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class AuthService {
    @Autowired
    UserRepository userRepository;

    @Transactional(rollbackFor = Exception.class)
    public void signUp(SignUpRequest signUpRequest) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String userId = String.valueOf(Thread.currentThread().getId()) + new Date().getTime();
        UserEntity userEntity = UserEntity.builder()
                .userId(Long.parseLong(userId))
                .loginId(signUpRequest.getLoginId())
                .password(passwordEncoder.encode(signUpRequest.getPassword()))
                .build();
        userEntity.setEmail(signUpRequest.getEmail());
        userEntity.setPhoneNo(signUpRequest.getPhoneNo());
        userEntity.setName(signUpRequest.getName());
        userRepository.save(userEntity);
    }
}
