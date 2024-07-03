package com.sparta.spartascheduler.controller;

import com.sparta.spartascheduler.Security.UserDetailsImpl;
import com.sparta.spartascheduler.dto.CommentRequestDto;
import com.sparta.spartascheduler.dto.CommentResponseDto;
import com.sparta.spartascheduler.dto.ScheduleRequestDto;
import com.sparta.spartascheduler.dto.ScheduleResponseDto;
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
    public CommentResponseDto createComment(@AuthenticationPrincipal UserDetailsImpl userDetails, @RequestParam Long scheduleId, @RequestBody CommentRequestDto requestDto) {
        return commentService.createComment(userDetails.getUser(), scheduleId, requestDto);
    }

    @GetMapping("/comment/select")
    public CommentResponseDto selectComment(@RequestParam Long id) {
        return commentService.selectComment(id);
    }

    @PutMapping("/comment/update")
    public CommentResponseDto updateComment(@AuthenticationPrincipal UserDetailsImpl userDetails, @RequestParam Long id, @RequestBody CommentRequestDto requestDto) {
        return commentService.updateComment(userDetails.getUser(), id, requestDto);
    }

    @DeleteMapping("/comment/delete")
    public CommentResponseDto deleteComment(@AuthenticationPrincipal UserDetailsImpl userDetails, @RequestParam Long id) {
        return commentService.deleteComment(userDetails.getUser(), id);
    }
}
