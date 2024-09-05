package com.d108.project.domain.businessareaevaluation;

import com.d108.project.config.enums.MainAgeArea;
import com.d108.project.domain.businessarea.BusinessArea;
import com.d108.project.domain.member.Member;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Table(name = "business_area_evaluations")
@Getter
public class BusinessAreaEvaluation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "business_area_evaluation_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_area_id")
    private BusinessArea businessArea;

    // 여기 타입 뭐씀?
    @Enumerated(EnumType.STRING)
    private MainAgeArea mainAgeArea;

    // FIXME: 여기 평가 점수 같은거 있어야 하는거 아님?


    @Column(updatable = false)
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
