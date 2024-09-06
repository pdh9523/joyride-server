package com.d108.project.domain.forum.reply;


import com.d108.project.domain.forum.reply.dto.ReplyByMemberIdResponseDto;
import com.d108.project.domain.forum.reply.dto.ReplyByPostIdResponseDto;
import com.d108.project.domain.forum.reply.dto.ReplyCreateDto;

import java.util.List;

public interface ReplyService {

    void createReply(ReplyCreateDto replyCreateDto);

    List<ReplyByPostIdResponseDto> getReplyByPostId(Integer postId);

    List<ReplyByMemberIdResponseDto> getReplyByMemberId(Integer memberId);
}
