package com.d108.project.domain.post.dto;

import lombok.Builder;

@Builder
public class PostResponseDto {
    private Long id;
    private String subject;
    private String content;
    private Long view;
}