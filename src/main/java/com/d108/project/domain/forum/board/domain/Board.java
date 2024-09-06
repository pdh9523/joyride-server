package com.d108.project.domain.forum.board.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "boards")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // FIXME: 상권 (하나의 상권에 해당하는 하나의 게시판이 생기는 거 아님?)
    private Integer businessAreaId;
    // FIXME: 프랜차이즈 (이하 동일)

    private Integer franchiseId;

    // 제목
    private String title;

    // 내용
    private String content;
}
