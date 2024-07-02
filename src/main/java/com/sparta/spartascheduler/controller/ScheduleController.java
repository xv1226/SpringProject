package com.sparta.spartascheduler.controller;


import com.sparta.spartascheduler.Security.UserDetailsImpl;
import com.sparta.spartascheduler.dto.ScheduleRequestDto;
import com.sparta.spartascheduler.dto.ScheduleResponseDto;
import com.sparta.spartascheduler.service.ScheduleService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping("/Scheduler/create")
    public ScheduleResponseDto createSchedule(@AuthenticationPrincipal UserDetailsImpl userDetails,@RequestBody ScheduleRequestDto requestDto){
        return scheduleService.createSchedule(userDetails.getUser(),requestDto);
    }

}
