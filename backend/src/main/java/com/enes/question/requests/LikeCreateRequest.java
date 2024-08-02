package com.enes.question.requests;

import lombok.Data;

@Data
public class LikeCreateRequest {
    long id;
    long postId;
    long userId;
}
