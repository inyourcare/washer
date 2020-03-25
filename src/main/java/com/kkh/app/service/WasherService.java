package com.kkh.app.service;

import com.kkh.app.dto.request.washer.*;
import com.kkh.app.exception.ExpectableException;
import com.kkh.app.exception.message.StoreExceptionMessage;
import com.kkh.app.exception.message.UserExceptionMessage;
import com.kkh.app.exception.message.WasherExceptionMessage;
import com.kkh.app.jpa.entity.StoreEntity;
import com.kkh.app.jpa.entity.UserEntity;
import com.kkh.app.jpa.entity.WasherEntity;
import com.kkh.app.jpa.repository.StoreRepository;
import com.kkh.app.jpa.repository.UserRepository;
import com.kkh.app.jpa.repository.WasherRepository;
import com.kkh.app.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.stream.Collectors;

@Service
public class WasherService {
    @Autowired
    WasherRepository washerRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    StoreRepository storeRepository;

    @Transactional(rollbackFor = Exception.class)
    public void create(CustomUserDetails user, WasherCreateRequest request) {
        UserEntity userEntity = userRepository.findById(Long.parseLong(user.getUserId())).orElseThrow(() -> new ExpectableException(UserExceptionMessage.USER_NOT_FOUND.getMessage()));
        Date now = new Date();
        StoreEntity storeEntity = storeRepository.findById(request.getStoreId()).orElseThrow(() -> new ExpectableException(StoreExceptionMessage.STORE_NOT_FOUND.getMessage()));
        WasherEntity washerEntity = WasherEntity.builder()
                .capacity(request.getCapacity())
                .isAvailable(false)
                .role(request.getRole())
                .store(storeEntity)
                .washerName(request.getWasherName())
                .creator(userEntity)
                .modifier(userEntity)
                .modDate(now)
                .regDate(now)
                .build();
        washerRepository.save(washerEntity);
    }

    @Transactional(rollbackFor = Exception.class)
    public void update(CustomUserDetails user, WasherUpdateRequest request) {
        UserEntity userEntity = userRepository.findById(Long.parseLong(user.getUserId())).orElseThrow(() -> new ExpectableException(UserExceptionMessage.USER_NOT_FOUND.getMessage()));
        Date now = new Date();
        WasherEntity washerEntity = washerRepository.findById(request.getWasherId()).orElseThrow(() -> new ExpectableException(WasherExceptionMessage.WASHER_NOT_FOUND.getMessage()));
        StoreEntity storeEntity = storeRepository.findById(request.getStoreId()).orElseThrow(() -> new ExpectableException(StoreExceptionMessage.STORE_NOT_FOUND.getMessage()));
        washerEntity.setCapacity(request.getCapacity());
        washerEntity.setRole(request.getRole());
        washerEntity.setStore(storeEntity);
        washerEntity.setWasherName(request.getWasherName());
        washerEntity.setModifier(userEntity);
        washerEntity.setModDate(now);
        washerRepository.save(washerEntity);
    }

    public void readList(CustomUserDetails user, WasherReadListRequest request) {
    }

    public void readDetails(CustomUserDetails user, WasherReadDetailsRequest request) {
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(CustomUserDetails user, WasherDeleteRequest request) {
        washerRepository.deleteById(request.getWasherId());
    }

    @Transactional(rollbackFor = Exception.class)
    public void setAvailable(CustomUserDetails user, WasherSetAvailableRequest request) {
        washerRepository.saveAll(request.getWasherAvailableInfoList().stream().map(washerAvailableInfo -> {
            WasherEntity washerEntity = washerRepository.findByStore_StoreIdAndWasherId(washerAvailableInfo.getStoreId(), washerAvailableInfo.getWasherId()).orElseThrow(() -> new ExpectableException(WasherExceptionMessage.WASHER_NOT_FOUND.getMessage()));
            washerEntity.setAvailable(washerAvailableInfo.getIsAvailable());
            return washerEntity;
        }).collect(Collectors.toList()));
    }
}
