package com.sparta.spartascheduler.service;

import com.sparta.spartascheduler.entity.Schedule;
import com.sparta.spartascheduler.entity.ScheduleGood;
import com.sparta.spartascheduler.entity.User;
import com.sparta.spartascheduler.repository.ScheduleGoodRepository;
import com.sparta.spartascheduler.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

@Service
public class ScheduleGoodService {

    private final ScheduleGoodRepository scheduleGoodRepository;
    private final ScheduleRepository scheduleRepository;

    public ScheduleGoodService(ScheduleGoodRepository scheduleGoodRepository, ScheduleRepository scheduleRepository) {
        this.scheduleGoodRepository = scheduleGoodRepository;
        this.scheduleRepository = scheduleRepository;
    }

    public void ScheduleGood(User user, Long scheduleId){
        Schedule schedule=scheduleRepository.findById(scheduleId).orElseThrow();
        ScheduleGood scheduleGood=new ScheduleGood(user,schedule);
        if(!(user.getId().equals(schedule.getUser().getId()))){
            if(scheduleGoodRepository.existsByUserAndSchedule(user,schedule)){
                scheduleGoodRepository.delete(scheduleGood);
            }
            else{
                scheduleGoodRepository.save(scheduleGood);
            }
        }

    }
}
