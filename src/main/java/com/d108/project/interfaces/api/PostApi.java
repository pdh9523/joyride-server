package com.d108.project.interfaces.api;

import com.d108.project.domain.forum.post.dto.PostCreateDto;
import com.d108.project.domain.forum.post.dto.PostResponseDto;
import com.d108.project.domain.forum.post.dto.PostUpdateDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/posts")
public interface PostApi {

    @GetMapping
    ResponseEntity<List<PostResponseDto>> getAllPosts();

    @GetMapping("/{boardId}")
    ResponseEntity<PostResponseDto> getPostById(@PathVariable("boardId") Integer boardId);

    @PostMapping
    ResponseEntity<Void> createPost(@RequestBody PostCreateDto postCreateDto);

    @PutMapping("/{boardId}")
    ResponseEntity<Void> updatePost(@PathVariable("boardId") Integer boardId, @RequestBody PostUpdateDto postUpdateDto);

    @DeleteMapping("/{boardId}")
    ResponseEntity<Void> deletePost(@PathVariable("boardId") Integer boardId);
}
