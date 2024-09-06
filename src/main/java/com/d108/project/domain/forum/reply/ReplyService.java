package com.d108.project.domain.forum.reply;


import com.d108.project.domain.forum.reply.dto.ReplyByMemberIdResponseDto;
import com.d108.project.domain.forum.reply.dto.ReplyByPostIdResponseDto;
import com.d108.project.domain.forum.reply.dto.ReplyCreateDto;
import com.d108.project.domain.forum.reply.dto.ReplyUpdateDto;

import java.util.List;

public interface ReplyService {

    void createReply(ReplyCreateDto replyCreateDto);

    List<ReplyByPostIdResponseDto> getReplyByPostId(Integer postId);

    List<ReplyByMemberIdResponseDto> getReplyByMemberId(Integer memberId);

    void updateReply(Integer replyId, ReplyUpdateDto replyUpdateDto);

    void deleteReply(Integer replyId);
}
