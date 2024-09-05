package com.d108.project.domain.post;

import com.d108.project.domain.board.Board;
import com.d108.project.domain.member.Member;
import com.d108.project.domain.salestorepost.SaleStorePost;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "posts")
@NoArgsConstructor
public class Post {
    // 게시글 PK
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    // 게시판 PK - FK
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

    // 회원 PK - FK
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", updatable = false)
    private Member member;

    // 제목
    private String subject;

    // 내용
    private String content;

    // 조회수
    private Long view;

    // 판매 글
    // OrphanRemoval: 연결이 끊어지면 제거
    @OneToOne(mappedBy = "posts", cascade = CascadeType.ALL, orphanRemoval = true)
    private SaleStorePost saleStorePost;

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

    @Builder
    public Post(Board board, Member member, String subject, String content) {
        this.board = board;
        this.member = member;
        this.subject = subject;
        this.content = content;
        this.view = 0L;
    }
}
