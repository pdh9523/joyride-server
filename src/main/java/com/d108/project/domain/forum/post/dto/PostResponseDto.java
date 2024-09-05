package com.d108.project.domain.forum.post.dto;

import lombok.Builder;

@Builder
public class PostResponseDto {
    private Integer id;
    private String title;

    private String content;
    private Integer view;
}