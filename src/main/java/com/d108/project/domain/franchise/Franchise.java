package com.d108.project.domain.franchise;

import com.d108.project.domain.member.Member;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "franchises")
@Getter
public class Franchise {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "franchise_id")
    private Long id;

    // 이름
    private String name;

    // 다대다
    @ManyToMany(mappedBy = "franchises")
    private Set<Member> members = new HashSet<>();
}
