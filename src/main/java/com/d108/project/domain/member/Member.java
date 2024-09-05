package com.d108.project.domain.member;

import com.d108.project.domain.businessarea.BusinessArea;
import com.d108.project.domain.franchise.Franchise;
import com.d108.project.domain.logincredential.LoginCredential;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "members")
@Getter
@NoArgsConstructor
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;
    // loginCredentials 가져옴
    @OneToOne(mappedBy = "members", cascade = CascadeType.ALL, orphanRemoval = true)
    private LoginCredential loginCredential;

    private String nickname;

    // 관심 상권
    @ManyToMany
    @JoinTable(
            name = "favorite_business_areas",
            joinColumns = @JoinColumn(name = "member_id"),
            inverseJoinColumns = @JoinColumn(name = "business_area_id")
    )
    private Set<BusinessArea> businessAreas = new HashSet<>();

    // 관심 프랜차이즈
    @ManyToMany
    @JoinTable(
            name = "favorite_franchises",
            joinColumns = @JoinColumn(name = "member_id"),
            inverseJoinColumns = @JoinColumn(name = "franchise_id")
    )
    private Set<Franchise> franchises = new HashSet<>();

    @Builder
    public Member(String nickname, LoginCredential loginCredential) {
        this.nickname = nickname;
        this.loginCredential = loginCredential;
    }
}
