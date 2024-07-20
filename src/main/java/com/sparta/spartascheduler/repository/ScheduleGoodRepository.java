package com.sparta.spartascheduler.repository;

import com.sparta.spartascheduler.entity.Schedule;
import com.sparta.spartascheduler.entity.ScheduleGood;
import com.sparta.spartascheduler.entity.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleGoodRepository extends JpaRepository<ScheduleGood,Long> {

    Boolean existsByUserAndSchedule(User user, Schedule schedule);
    Long countByScheduleId(Long scheduleId);
}
