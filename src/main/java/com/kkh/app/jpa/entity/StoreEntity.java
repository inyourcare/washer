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
@Table(name = "store")
@Data
public class StoreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int storeId;

    // 지점 명
    @Size(max = 400)
    private String storeName;

    // 직영 / 가맹
    @Size(max = 1)
    private String contractType;

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
    public StoreEntity(int storeId, @Size(max = 400) String storeName, @Size(max = 1) String contractType, UserEntity creator, UserEntity modifier, Date regDate, Date modDate) {
        this.storeId = storeId;
        this.storeName = storeName;
        this.contractType = contractType;
        this.creator = creator;
        this.modifier = modifier;
        this.regDate = regDate;
        this.modDate = modDate;
    }
}
