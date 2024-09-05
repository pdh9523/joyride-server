package com.d108.project.domain.board;

import jakarta.persistence.*;

@Entity
@Table(name = "boards")
public class Board {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    // FIXME: 상권 (하나의 상권에 해당하는 하나의 게시판이 생기는 거 아님?)

    // FIXME: 프랜차이즈 (이하 동일)

    // 제목
    private String subject;

    // 내용
    private String content;
}
