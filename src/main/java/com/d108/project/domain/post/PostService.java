package com.d108.project.domain.post;

import com.d108.project.domain.post.dto.PostUpdateDto;
import com.d108.project.domain.post.dto.PostCreateDto;
import com.d108.project.domain.post.dto.PostResponseDto;

import java.util.List;

public interface PostService {

    void createPost(PostCreateDto postCreateDto);

    List<PostResponseDto> getAllPosts();

    PostResponseDto getPostById(Long id);

    void updatePostById(Long id, PostUpdateDto postUpdateDto);

    void deletePostById(Long id);
}
