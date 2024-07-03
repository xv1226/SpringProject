package com.sparta.spartascheduler.repository;

import com.sparta.spartascheduler.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {

}
