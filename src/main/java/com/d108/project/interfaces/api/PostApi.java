package com.d108.project.interfaces.api;

import com.d108.project.domain.post.dto.PostCreateDto;
import com.d108.project.domain.post.dto.PostResponseDto;
import com.d108.project.domain.post.dto.PostUpdateDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/post")
public interface PostApi {

    @GetMapping
    ResponseEntity<List<PostResponseDto>> getAllPosts();

    @GetMapping("/{boardId}")
    ResponseEntity<PostResponseDto> getPostById(@PathVariable("boardId") Long boardId);

    @PostMapping
    ResponseEntity<Void> createPost(@RequestBody PostCreateDto postCreateDto);

    @PutMapping("/{boardId}")
    ResponseEntity<Void> updatePost(@PathVariable("boardId") Long boardId, @RequestBody PostUpdateDto postUpdateDto);

    @DeleteMapping("/{boardId}")
    ResponseEntity<Void> deletePost(@PathVariable("boardId") Long boardId);
}
