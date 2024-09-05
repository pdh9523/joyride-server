package com.d108.project.domain.post.dto;

import lombok.Getter;

@Getter
public class PostCreateDto {
    private Long boardId;
    private Long memberId;
    private String subject;
    private String content;
}
