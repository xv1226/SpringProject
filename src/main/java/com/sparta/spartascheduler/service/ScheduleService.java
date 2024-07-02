package com.sparta.spartascheduler.service;


import com.sparta.spartascheduler.dto.ScheduleRequestDto;
import com.sparta.spartascheduler.dto.ScheduleResponseDto;
import com.sparta.spartascheduler.entity.Schedule;
import com.sparta.spartascheduler.entity.User;
import com.sparta.spartascheduler.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public ScheduleResponseDto createSchedule(User user, ScheduleRequestDto requestDto){
        String scheduleTitle=requestDto.getScheduleTitle();
        String scheduleInfo=requestDto.getScheduleInfo();


        Schedule schedule=new Schedule(scheduleTitle,scheduleInfo,user);
        scheduleRepository.save(schedule);
        return new ScheduleResponseDto(schedule);
    }

    public void findBySchedule(Long id){
        Schedule schedule= scheduleRepository.findById(id).orElseThrow();
    }
}
