package com.d108.project.domain.forum.reply.dto;

import lombok.Getter;

@Getter
public class ReplyCreateDto {
    private Integer memberId;
    private Integer postId;
    private String content;
}
