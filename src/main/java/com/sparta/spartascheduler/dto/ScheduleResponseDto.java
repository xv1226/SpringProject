package com.sparta.spartascheduler.dto;

import com.sparta.spartascheduler.entity.Schedule;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScheduleResponseDto {
    private Long id;
    private Long userId;
    private String scheduleTitle;
    private String scheduleInfo;

    public ScheduleResponseDto(Schedule schedule){
        this.id=schedule.getId();
        this.userId=schedule.getUser().getId();
        this.scheduleTitle=schedule.getScheduleTitle();
        this.scheduleInfo=schedule.getScheduleInfo();
    }
}
