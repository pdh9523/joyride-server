package com.d108.project.domain.post;

import com.d108.project.domain.board.Board;
import com.d108.project.domain.board.BoardRepository;
import com.d108.project.domain.member.Member;
import com.d108.project.domain.member.MemberRepository;
import com.d108.project.domain.post.dto.PostCreateDto;
import com.d108.project.domain.post.dto.PostResponseDto;
import com.d108.project.domain.post.dto.PostUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, BoardRepository boardRepository, MemberRepository memberRepository) {
        this.postRepository = postRepository;
        this.boardRepository = boardRepository;
        this.memberRepository = memberRepository;
    }

    @Override
    public void createPost(PostCreateDto postCreateDto) {
        Board board = boardRepository.findById(postCreateDto.getBoardId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시판입니다."));

        Member member = memberRepository.findById(postCreateDto.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));

        Post post = Post.builder()
                .board(board)
                .member(member)
                .subject(postCreateDto.getSubject())
                .content(postCreateDto.getContent())
                .build();

        postRepository.save(post);
    }

    // 전체 글 조회
    @Override
    public List<PostResponseDto> getAllPosts() {
        List<Post> posts = postRepository.findAll();

        return posts.stream()
                .map(this::convertToPostResponseDto)
                .collect(Collectors.toList());
    }

    // 단일 글 조회
    @Override
    public PostResponseDto getPostById(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 글 번호 입니다."));
        return convertToPostResponseDto(post);
    }

    // 글 수정
    @Override
    public void updatePostById(Long id, PostUpdateDto postUpdateDto) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 글 번호 입니다."));

        post.setSubject(postUpdateDto.getSubject());
        post.setContent(postUpdateDto.getContent());

        postRepository.save(post);
    }
    
    // 글 삭제
    @Override
    public void deletePostById(Long id) {
        postRepository.deleteById(id);
    }

    private PostResponseDto convertToPostResponseDto(Post post) {
        return PostResponseDto.builder()
                .id(post.getId())
                .subject(post.getSubject())
                .content(post.getContent())
                .view(post.getView())
                .build();
    }
}
