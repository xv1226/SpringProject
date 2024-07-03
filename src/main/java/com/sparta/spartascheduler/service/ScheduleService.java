package com.sparta.spartascheduler.service;


import com.sparta.spartascheduler.dto.ScheduleRequestDto;
import com.sparta.spartascheduler.dto.ScheduleResponseDto;
import com.sparta.spartascheduler.entity.Schedule;
import com.sparta.spartascheduler.entity.User;
import com.sparta.spartascheduler.repository.ScheduleRepository;
import org.hibernate.query.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public ScheduleResponseDto createSchedule(User user, ScheduleRequestDto requestDto) {
        String scheduleTitle = requestDto.getScheduleTitle();
        String scheduleInfo = requestDto.getScheduleInfo();


        Schedule schedule = new Schedule(scheduleTitle, scheduleInfo, user);
        scheduleRepository.save(schedule);
        return new ScheduleResponseDto(schedule);
    }

    public ScheduleResponseDto findBySchedule(User user, Long id) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow();
        if (!(user.getId().equals(schedule.getUser().getId()))) {
            throw new IllegalArgumentException("userId가 일치하지 않습니다");
        }
        return new ScheduleResponseDto(schedule);
    }

    public List<ScheduleResponseDto> findByAllSchedule(User user) {
        return scheduleRepository.findAllByUserIdOrderByCreatedAtDesc(user.getId()).stream().map(ScheduleResponseDto::new).toList();
    }

    public ScheduleResponseDto updateSchedule(User user, Long id, ScheduleRequestDto requestDto) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow();
        if (!(user.getId().equals(schedule.getUser().getId()))) {
            throw new IllegalArgumentException("userId가 일치하지 않습니다");
        }

        schedule.updateSchedule(requestDto);

        scheduleRepository.save(schedule);
        return new ScheduleResponseDto(schedule);
    }

    public ScheduleResponseDto deleteSchedule(User user, Long id){
        Schedule schedule = scheduleRepository.findById(id).orElseThrow();
        if (!(user.getId().equals(schedule.getUser().getId()))) {
            throw new IllegalArgumentException("userId가 일치하지 않습니다");
        }

        scheduleRepository.delete(schedule);
        return new ScheduleResponseDto(schedule);
    }

    public List<ScheduleResponseDto> deleteAllSchedule(User user){
        return scheduleRepository.deleteAllByUserId(user.getId()).stream().map(ScheduleResponseDto::new).toList();
    }

}
