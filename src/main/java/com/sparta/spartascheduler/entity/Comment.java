package com.sparta.spartascheduler.entity;


import com.sparta.spartascheduler.dto.CommentRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comment")
public class Comment extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String commentInfo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username",referencedColumnName = "username")
    private User user;


    public Comment(String commentInfo,Schedule schedule,User user){
        this.commentInfo=commentInfo;
        this.schedule=schedule;
        this.user=user;
    }

    public void updateComment(CommentRequestDto request) {
        this.commentInfo=request.getCommentInfo();
    }
}
