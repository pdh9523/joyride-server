package com.d108.project.domain.businessarea;

import com.d108.project.domain.favorite.favoriteBusinessArea.domain.FavoriteBusinessArea;
import com.d108.project.domain.member.domain.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Getter
@Setter(value = AccessLevel.PROTECTED)
@Entity
@Table(name = "business_areas")
public class BusinessArea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    // 주소
    private String name;
    
    // 설명
    private String description;

    @OneToMany(mappedBy = "businessArea")
    private List<FavoriteBusinessArea> FavoriteBusinessAreas = new ArrayList<>();
}
