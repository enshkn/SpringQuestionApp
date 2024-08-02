package com.enes.question.services;
import com.enes.question.entities.Like;
import com.enes.question.entities.User;
import com.enes.question.entities.Post;
import com.enes.question.repos.LikeRepository;
import com.enes.question.repos.PostRepository;
import com.enes.question.repos.UserRepository;
import com.enes.question.requests.LikeCreateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LikeService {

    LikeRepository likeRepository;
    UserRepository userRepository;
    PostRepository postRepository;

    public LikeService(LikeRepository likeRepository,
                       UserRepository userRepository,
                       PostRepository postRepository) {
        this.likeRepository = likeRepository;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }


    public List<Like> getAllLikesWithParams(Long userId, Long postId) {
        if (userId != null && postId != null) {
            return likeRepository.findAllLikesByUserIdAndPostId(userId, postId);
        } else if (userId != null) {
            return likeRepository.findAllLikesByUserId(userId);
        } else if (postId != null) {
            return likeRepository.findAllLikesByPostId(postId);
        } else {
            return likeRepository.findAll();
        }

    }

    public Like getOneLikeById(Long likeId) {
        return likeRepository.findById(likeId).orElse(null);
    }


    public Like createOneLike(LikeCreateRequest likeCreateRequest) {
        Optional <Post> post = postRepository.findById(likeCreateRequest.getPostId());
        Optional <User> user = userRepository.findById(likeCreateRequest.getUserId());
        if (user.isPresent() && post.isPresent()) {
            Like likeToSave = new Like();
            likeToSave.setUser(user.get());
            likeToSave.setPost(post.get());
            return likeRepository.save(likeToSave);
        } else {
            return null;
        }

    }

    public void deleteOneLike(Long likeId) {
        likeRepository.deleteById(likeId);
    }

    /*

    * not using for now
    public Like updateOneLike(Long likeId, LikeUpdateRequest likeUpdateRequest) {
        Optional <Like> like = likeRepository.findById(likeId);
        Optional <User> user = userRepository.findById(likeUpdateRequest.getUserId());
        Optional <Post> post = postRepository.findById(likeUpdateRequest.getPostId());
        if (like.isPresent() && user != null && post !=null) {
            Like likeToUpdate = like.get();
            likeToUpdate.setUser(likeToUpdate.setUser(user));
            likeToUpdate.setPost(likeToUpdate.setPost(post));
            return likeRepository.save(likeToUpdate);
        } else {
            return null;
        }
    }
    */
}
