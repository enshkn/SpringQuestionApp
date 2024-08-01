package com.enes.question.services;

import com.enes.question.entities.Post;
import com.enes.question.entities.User;
import com.enes.question.repos.PostRepository;
import com.enes.question.requests.PostCreateRequest;
import com.enes.question.requests.PostUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private PostRepository postRepository;
    private UserService userService;

    public PostService(PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }


    public List<Post> getAllPosts(Optional<Long> userId) {
        if (userId.isPresent()) {
            return postRepository.findAllByUserId(userId.get());
        }
        return postRepository.findAll();
    }

    public Post getOnePostById(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }

    public Post createOnePost(PostCreateRequest newPostRequest) {
        User user = userService.getOneUserById(newPostRequest.getUserId());
        if (user == null) {
            return null;
        }
        Post toSave = new Post();
        toSave.setId(newPostRequest.getId());
        toSave.setTitle(newPostRequest.getTitle());
        toSave.setText(newPostRequest.getText());
        toSave.setUser(user);
        return postRepository.save(toSave);
    }

    public void deleteOnePost(Long postId) {
        postRepository.deleteById(postId);
    }

    public Post updateOnePostById(Long postId, PostUpdateRequest newPostUpdateRequest) {
        Optional<Post> post = postRepository.findById(postId);
        if (post.isPresent()) {
            Post postToUpdate = post.get();
            postToUpdate.setTitle(newPostUpdateRequest.getTitle());
            postToUpdate.setText(newPostUpdateRequest.getText());
            postRepository.save(postToUpdate);
            return postToUpdate;
        } else {
            return null;
        }
    }
}
