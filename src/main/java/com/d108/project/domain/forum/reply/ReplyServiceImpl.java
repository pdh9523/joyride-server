package com.d108.project.domain.forum.reply;

import com.d108.project.domain.forum.post.domain.Post;
import com.d108.project.domain.forum.post.repository.PostRepository;
import com.d108.project.domain.forum.reply.domain.Reply;
import com.d108.project.domain.forum.reply.dto.ReplyByMemberIdResponseDto;
import com.d108.project.domain.forum.reply.dto.ReplyByPostIdResponseDto;
import com.d108.project.domain.forum.reply.dto.ReplyCreateDto;
import com.d108.project.domain.forum.reply.repository.ReplyRepository;
import com.d108.project.domain.member.domain.Member;
import com.d108.project.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {

    private final ReplyRepository replyRepository;
    private final MemberRepository memberRepository;
    private final PostRepository postRepository;

    @Override
    public void createReply(ReplyCreateDto replyCreateDto) {
        Member member = memberRepository.findById(replyCreateDto.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("존재 하지 않는 사용자 입니다."));

        Post post = postRepository.findById(replyCreateDto.getPostId())
                .orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다."));

        Reply reply = Reply.builder()
                .member(member)
                .post(post)
                .content(replyCreateDto.getContent())
                .build();

        replyRepository.save(reply);
    }

    @Override
    public List<ReplyByPostIdResponseDto> getReplyByPostId(Integer postId) {
        List<Reply> replyList = replyRepository.findAllByPostId(postId)
                .orElseThrow(() -> new IllegalArgumentException("댓글이 없습니다."));

        return replyList.stream()
                .map(ReplyByPostIdResponseDto::from)
                .collect(Collectors.toList());
    }

    @Override
    public List<ReplyByMemberIdResponseDto> getReplyByMemberId(Integer memberId) {
        List<Reply> replyList = replyRepository.findAllByMemberId(memberId)
                .orElseThrow(() -> new IllegalArgumentException("댓글이 없습니다."));

        return replyList.stream()
                .map(ReplyByMemberIdResponseDto::from)
                .collect(Collectors.toList());
    }
}
