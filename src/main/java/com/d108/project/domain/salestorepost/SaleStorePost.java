package com.d108.project.domain.salestorepost;

import com.d108.project.config.enums.MainAgeArea;
import com.d108.project.domain.post.Post;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "sale_store_posts")
@Getter
public class SaleStorePost {
    @Id
    private Long id;
    // 게시글 PK - FK
    @OneToOne
    @MapsId
    @JoinColumn(name = "post_id")
    private Post post;

    // 임대 가격
    private Long rentalPrice;
    // 매출
    private Long sales;

    // 주 연령층 (여기 타입 뭐씀?)
    @Enumerated(EnumType.STRING)
    private MainAgeArea mainAgeGroup;

    // 유동 인구
    private Long floatingPopulation;
    // 분위기 (여기 타입 뭐씀?)
    private String atmosphere;
    // 주변 물가
    private Long localPriceLevel;
    // 업종 (여기 타입 뭐씀?)
    private String leaseType;
    // 원하는 판매 가격
    private Long desiredSalePrice;
}
