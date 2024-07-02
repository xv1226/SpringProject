package com.sparta.spartascheduler.entity;

import com.sparta.spartascheduler.dto.ScheduleRequestDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Schedule")
public class Schedule extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Column(nullable = false)
    private String scheduleTitle;

    @Column
    private String scheduleInfo;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public Schedule(String scheduleTitle,String scheduleInfo,User user){
        this.scheduleTitle=scheduleTitle;
        this.scheduleInfo=scheduleInfo;
        this.user= user;
    }

    public void updateSchedule(ScheduleRequestDto requestDto){
        this.scheduleTitle=requestDto.getScheduleTitle();
        this.scheduleInfo=requestDto.getScheduleInfo();
    }
}
