package com.sparta.spartascheduler.controller;


import com.sparta.spartascheduler.Security.UserDetailsImpl;
import com.sparta.spartascheduler.dto.ScheduleRequestDto;
import com.sparta.spartascheduler.dto.ScheduleResponseDto;
import com.sparta.spartascheduler.service.ScheduleService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping("/scheduler/create")
    public ScheduleResponseDto createSchedule(@AuthenticationPrincipal UserDetailsImpl userDetails,@RequestBody ScheduleRequestDto requestDto){
        return scheduleService.createSchedule(userDetails.getUser(),requestDto);
    }

    @GetMapping("/scheduler/selectId")
    public ScheduleResponseDto getSchedule(@AuthenticationPrincipal UserDetailsImpl userDetails,@RequestParam Long id){
        return scheduleService.findBySchedule(userDetails.getUser(),id);
    }

    @GetMapping("/scheduler/select")
    public List<ScheduleResponseDto> getAllSchedule(@AuthenticationPrincipal UserDetailsImpl userDetails){
        return scheduleService.findByAllSchedule(userDetails.getUser());
    }

    @PostMapping("/scheduler/update")
    public ScheduleResponseDto updateSchedule(@AuthenticationPrincipal UserDetailsImpl userDetails,@RequestParam Long id,@RequestBody ScheduleRequestDto requestDto){
        return scheduleService.updateSchedule(userDetails.getUser(),id,requestDto);
    }

    @DeleteMapping("/scheduler/delete")
    public ScheduleResponseDto deleteSchedule(@AuthenticationPrincipal UserDetailsImpl userDetails,@RequestParam Long id){
        return scheduleService.deleteSchedule(userDetails.getUser(),id);
    }

}
