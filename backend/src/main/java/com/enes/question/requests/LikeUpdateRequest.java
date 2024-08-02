package com.enes.question.requests;

import lombok.Data;

@Data
public class LikeUpdateRequest {
    Long userId;
    Long postId;
}
