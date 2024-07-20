package com.sparta.spartascheduler.controller;

import com.sparta.spartascheduler.Security.UserDetailsImpl;
import com.sparta.spartascheduler.entity.Schedule;
import com.sparta.spartascheduler.service.ScheduleGoodService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ScheduleGoodController {

    private final ScheduleGoodService scheduleGoodService;

    public ScheduleGoodController(ScheduleGoodService scheduleGoodService) {
        this.scheduleGoodService = scheduleGoodService;
    }

    @PostMapping("/schedulegood")
    public void ScheduleGood(@AuthenticationPrincipal UserDetailsImpl userDetails, @RequestParam Long scheduleId){
        scheduleGoodService.ScheduleGood(userDetails.getUser(),scheduleId);
    }
}
