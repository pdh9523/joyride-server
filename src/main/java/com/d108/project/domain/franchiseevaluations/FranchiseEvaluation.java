package com.d108.project.domain.franchiseevaluations;

import com.d108.project.config.enums.MainAgeArea;
import com.d108.project.domain.member.Member;
import com.d108.project.domain.franchise.Franchise;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

@Entity
@Table(name = "franchise_evalutions")
@Getter
@ToString(exclude = {"member", "franchise"})
public class FranchiseEvaluation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "franchise_evaluation_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "franchise_id")
    private Franchise franchise;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "login_credential_id")
    private Member member;

    @Enumerated(EnumType.STRING)
    private MainAgeArea mainAgeArea;

    private Long floatingPopulation;

    private String atmosphere;

    private Long localPriceLevel;
}
