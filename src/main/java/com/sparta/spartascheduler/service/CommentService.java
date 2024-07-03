package com.sparta.spartascheduler.service;

import com.sparta.spartascheduler.dto.CommentRequestDto;
import com.sparta.spartascheduler.dto.CommentResponseDto;
import com.sparta.spartascheduler.entity.Comment;
import com.sparta.spartascheduler.entity.Schedule;
import com.sparta.spartascheduler.entity.User;
import com.sparta.spartascheduler.repository.CommentRepository;
import com.sparta.spartascheduler.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

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
}
