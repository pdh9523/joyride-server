package com.d108.project.interfaces.controller;

import com.d108.project.domain.forum.post.PostService;
import com.d108.project.domain.forum.post.dto.PostCreateDto;
import com.d108.project.domain.forum.post.dto.PostResponseDto;
import com.d108.project.domain.forum.post.dto.PostUpdateDto;
import com.d108.project.interfaces.api.PostApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController implements PostApi {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @Override
    public ResponseEntity<Void> createPost(PostCreateDto postCreateDto) {
        postService.createPost(postCreateDto);
        // TODO: createPost 에서 글 번호 받아서, 글 번호로 redirect URL 전달하기
        return ResponseEntity.ok().build();
    }
    @Override
    public ResponseEntity<Void> updatePost(Integer boardId, PostUpdateDto postUpdateDto) {
        postService.updatePostById(boardId, postUpdateDto);
        // TODO: 위와 동일
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<PostResponseDto> getPostById(Integer boardId) {
        return ResponseEntity.ok(postService.getPostById(boardId));
    }

    @Override
    public ResponseEntity<List<PostResponseDto>> getAllPosts() {
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @Override
    public ResponseEntity<Void> deletePost(Integer boardId) {
        postService.deletePostById(boardId);
        return ResponseEntity.noContent().build();
    }
}
