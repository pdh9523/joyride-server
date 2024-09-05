package com.d108.project.domain.member.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberResponseDto {
    private Integer id;
    private String username;
    private String nickname;
}
