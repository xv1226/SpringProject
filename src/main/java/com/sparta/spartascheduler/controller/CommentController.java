package com.sparta.spartascheduler.controller;

import com.sparta.spartascheduler.Security.UserDetailsImpl;
import com.sparta.spartascheduler.dto.CommentRequestDto;
import com.sparta.spartascheduler.dto.CommentResponseDto;
import com.sparta.spartascheduler.service.CommentService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/comment/create")
    public CommentResponseDto createComment(@AuthenticationPrincipal UserDetailsImpl userDetails, @RequestParam Long scheduleId, @RequestBody CommentRequestDto commentRequestDto) {
        return commentService.createComment(userDetails.getUser(), scheduleId, commentRequestDto);
    }
}
