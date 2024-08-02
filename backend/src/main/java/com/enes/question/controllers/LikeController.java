package com.enes.question.controllers;

import com.enes.question.entities.Like;
import com.enes.question.requests.LikeCreateRequest;
import com.enes.question.requests.LikeUpdateRequest;
import com.enes.question.services.LikeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/likes")
public class LikeController {

    LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @GetMapping
    public List<Like> getAlllikes(@RequestParam Long userId,
                                  @RequestParam Long postId)
    {
        return likeService.getAllLikesWithParams(userId, postId);
    }

    @GetMapping("/{likeId}")
    public Like getOneLike(@RequestParam Long likeId) {
        return likeService.getOneLikeById(likeId);
    }

    @PostMapping
    public Like createOneLike(@RequestBody LikeCreateRequest likeCreateRequest) {
        return likeService.createOneLike(likeCreateRequest);
    }

    @DeleteMapping("/{likeId}")
    public void deleteOneLike(@PathVariable Long likeId) {
        likeService.deleteOneLike(likeId);
    }

    /*
    * not using for now

    @PutMapping("/{likeId}")
    public Like updateOneLike(@PathVariable Long likeId, @RequestBody LikeUpdateRequest likeUpdateRequest) {
        return likeService.updateOneLike(likeId, likeUpdateRequest);
    }
     */

}
