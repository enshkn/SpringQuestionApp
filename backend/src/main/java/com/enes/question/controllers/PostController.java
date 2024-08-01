package com.enes.question.controllers;

import com.enes.question.entities.Post;
import com.enes.question.requests.PostCreateRequest;
import com.enes.question.requests.PostUpdateRequest;
import com.enes.question.services.PostService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")

public class PostController {

    PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getAllPosts(@RequestParam Optional<Long> userId) {
        return postService.getAllPosts(userId);
    }

    @GetMapping("/{postId}")
    public Post getOnePost(@PathVariable Long postId) {
        return postService.getOnePostById(postId);
    }

    @PostMapping
    public Post createOnePost (@RequestBody PostCreateRequest newPostRequest) {
        return postService.createOnePost(newPostRequest);
    }

    @PutMapping("/{postId}")
    public Post updateOnePost(@PathVariable Long postId, @RequestBody PostUpdateRequest newPostUpdateRequest) {
        return postService.updateOnePostById(postId, newPostUpdateRequest);
    }

    @DeleteMapping("/{postId}")
    public void deleteOnePost(@PathVariable Long postId) {
        postService.deleteOnePost(postId);
    }


}
