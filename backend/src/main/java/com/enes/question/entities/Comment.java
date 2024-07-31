package com.enes.question.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "comments")
@Data
public class Comment {
    @Id
    Long id;
    String text;
    Long userId;
    Long postId;
}
