package com.kkh.app.service;

import com.kkh.app.dto.request.store.*;
import com.kkh.app.exception.ExpectableException;
import com.kkh.app.exception.message.StoreExceptionMessage;
import com.kkh.app.exception.message.UserExceptionMessage;
import com.kkh.app.jpa.entity.StoreEntity;
import com.kkh.app.jpa.entity.UserEntity;
import com.kkh.app.jpa.repository.StoreRepository;
import com.kkh.app.jpa.repository.UserRepository;
import com.kkh.app.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class StoreService {

    @Autowired
    StoreRepository storeRepository;
    @Autowired
    UserRepository userRepository;

    @Transactional(rollbackFor = Exception.class)
    public void create(CustomUserDetails user, StoreCreateRequest request) {
        UserEntity userEntity = userRepository.findById(Long.parseLong(user.getUserId())).orElseThrow(() -> new ExpectableException(UserExceptionMessage.USER_NOT_FOUND.getMessage()));
        Date now = new Date();
        StoreEntity storeEntity = StoreEntity.builder()
                .contractType(request.getContractType())
                .creator(userEntity)
                .modifier(userEntity)
                .modDate(now)
                .regDate(now)
                .storeName(request.getStoreName())
                .build();
        storeRepository.save(storeEntity);
    }

    @Transactional(rollbackFor = Exception.class)
    public void update(CustomUserDetails user, StoreUpdateRequest request) {
        UserEntity userEntity = userRepository.findById(Long.parseLong(user.getUserId())).orElseThrow(() -> new ExpectableException(UserExceptionMessage.USER_NOT_FOUND.getMessage()));
        Date now = new Date();
        StoreEntity storeEntity = storeRepository.findById(request.getStoreId()).orElseThrow(() -> new ExpectableException(StoreExceptionMessage.STORE_NOT_FOUND.getMessage()));
        storeEntity.setContractType(request.getContractType());
        storeEntity.setStoreName(request.getStoreName());
        storeEntity.setModifier(userEntity);
        storeEntity.setModDate(now);
        storeRepository.save(storeEntity);
    }

    public void readList(CustomUserDetails user, StoreReadListRequest request) {

    }

    public void readDetails(CustomUserDetails user, StoreReadDetailsRequest request) {

    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(CustomUserDetails user, StoreDeleteRequest request) {
        storeRepository.deleteById(request.getStoreId());
    }
}
