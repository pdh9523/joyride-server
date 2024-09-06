package com.d108.project.domain.evaluation.businessareaevaluation.domain;

import com.d108.project.domain.common.enums.AgeGroup;
import com.d108.project.domain.businessarea.BusinessArea;
import com.d108.project.domain.member.domain.Member;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Table(name = "business_area_evaluations")
@Getter
public class BusinessAreaEvaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_area_id")
    private BusinessArea businessArea;

    // 여기 타입 뭐씀?
    @Enumerated(EnumType.STRING)
    private AgeGroup ageGroup;

    // FIXME: 여기 평가 점수 같은거 있어야 하는거 아님?

}
