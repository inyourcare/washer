package com.kkh.app.jpa.repository;

import com.kkh.app.jpa.entity.WasherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WasherRepository extends JpaRepository<WasherEntity, Integer> {

    Optional<WasherEntity> findByStore_StoreIdAndWasherId(int storeId, int washerId);

    List<WasherEntity> findAllByCreator_UserId(long parseLong);
}
