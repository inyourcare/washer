package com.kkh.app.jpa.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "washer")
@Data
public class WasherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int washerId;

    // 사용 가능 여부
    boolean isAvailable;

    @ManyToOne
    @JoinColumn(name = "store_id")
    StoreEntity store;

    // 세탁기 / 건조기
    @Size(max = 1)
    private String role;

    // 대형 / 중형 / 특대형 / 초대형
    @Size(max = 1)
    private String capacity;

    @Size(max = 80)
    private String washerName;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    UserEntity creator;

    @ManyToOne
    @JoinColumn(name = "modifier_id")
    UserEntity modifier;

    @Temporal(TemporalType.TIMESTAMP)
    Date regDate;

    @Temporal(TemporalType.TIMESTAMP)
    Date modDate;

    @Builder
    public WasherEntity(int washerId, boolean isAvailable, StoreEntity store, @Size(max = 1) String role, @Size(max = 1) String capacity, @Size(max = 80) String washerName, UserEntity creator, UserEntity modifier, Date regDate, Date modDate) {
        this.washerId = washerId;
        this.isAvailable = isAvailable;
        this.store = store;
        this.role = role;
        this.capacity = capacity;
        this.washerName = washerName;
        this.creator = creator;
        this.modifier = modifier;
        this.regDate = regDate;
        this.modDate = modDate;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }
}
