package com.sparta.spartascheduler.service;

import com.sparta.spartascheduler.dto.CommentRequestDto;
import com.sparta.spartascheduler.dto.CommentResponseDto;
import com.sparta.spartascheduler.dto.ScheduleResponseDto;
import com.sparta.spartascheduler.entity.Comment;
import com.sparta.spartascheduler.entity.Schedule;
import com.sparta.spartascheduler.entity.User;
import com.sparta.spartascheduler.repository.CommentRepository;
import com.sparta.spartascheduler.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final ScheduleRepository scheduleRepository;

    public CommentService(CommentRepository commentRepository, ScheduleRepository scheduleRepository) {
        this.commentRepository = commentRepository;
        this.scheduleRepository = scheduleRepository;
    }

    public CommentResponseDto createComment(User user, Long scheduleId,CommentRequestDto RequestDto){
        Schedule schedule=scheduleRepository.findById(scheduleId).orElseThrow();
        String commentInfo=RequestDto.getCommentInfo();

        Comment comment=new Comment(commentInfo,schedule,user);
        commentRepository.save(comment);

        return new CommentResponseDto(comment);
    }

    public CommentResponseDto selectComment(Long id){
        Comment comment=commentRepository.findById(id).orElseThrow();
        return new CommentResponseDto(comment);
    }

    public CommentResponseDto updateComment(User user,Long id,CommentRequestDto RequestDto){
        Comment comment=commentRepository.findById(id).orElseThrow();
        if (!(user.getId().equals(comment.getUser().getId()))) {
            throw new IllegalArgumentException("userId가 일치하지 않습니다");
        }

        comment.updateComment(RequestDto);
        commentRepository.save(comment);

        return new CommentResponseDto(comment);
    }

    public CommentResponseDto deleteComment(User user,Long id){
        Comment comment=commentRepository.findById(id).orElseThrow();
        if (!(user.getId().equals(comment.getUser().getId()))) {
            throw new IllegalArgumentException("userId가 일치하지 않습니다");
        }

        commentRepository.delete(comment);

        return new CommentResponseDto(comment);
    }

}
