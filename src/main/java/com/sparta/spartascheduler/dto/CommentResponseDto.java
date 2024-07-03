package com.sparta.spartascheduler.dto;

import com.sparta.spartascheduler.entity.Comment;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CommentResponseDto {
    private Long id;
    private Long scheduleId;
    private String username;
    private String commentInfo;
    private LocalDateTime createdAt;

    public CommentResponseDto(Comment comment){
        this.id=comment.getId();
        this.scheduleId=comment.getSchedule().getId();
        this.username=comment.getUser().getUsername();
        this.commentInfo=comment.getCommentInfo();
        this.createdAt=comment.getCreatedAt();
    }
}
