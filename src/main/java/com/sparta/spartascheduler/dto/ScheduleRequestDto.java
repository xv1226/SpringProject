package com.sparta.spartascheduler.dto;

import com.sparta.spartascheduler.entity.Schedule;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class ScheduleRequestDto {
    private String scheduleTitle;
    private String scheduleInfo;
}
