package com.d108.project.domain.forum.post;

import com.d108.project.domain.forum.post.dto.PostUpdateDto;
import com.d108.project.domain.forum.post.dto.PostCreateDto;
import com.d108.project.domain.forum.post.dto.PostResponseDto;

import java.util.List;

public interface PostService {

    void createPost(PostCreateDto postCreateDto);

    List<PostResponseDto> getAllPosts();

    PostResponseDto getPostById(Integer id);

    void updatePostById(Integer id, PostUpdateDto postUpdateDto);

    void deletePostById(Integer id);
}
