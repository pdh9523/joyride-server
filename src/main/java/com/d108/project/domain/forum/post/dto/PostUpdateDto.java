package com.d108.project.domain.forum.post.dto;

import lombok.Getter;

@Getter
public class PostUpdateDto {
    private Integer memberId;
    private String title;
    private String content;
}
