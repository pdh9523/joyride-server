package com.d108.project.domain.businessarea;

import com.d108.project.domain.member.Member;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "business_areas")
public class BusinessArea {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "business_area_id")
    private Long id;
    
    // 주소
    private String address;
    
    // 설명
    private String description;

    // 다대다
    @ManyToMany(mappedBy = "business_areas")
    private Set<Member> members = new HashSet<>();
}
