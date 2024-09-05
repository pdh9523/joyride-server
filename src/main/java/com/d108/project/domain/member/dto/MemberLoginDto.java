package com.d108.project.domain.member.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberLoginDto {
    private String username;
    private String password;
}
