package com.sparta.spartascheduler.repository;

import com.sparta.spartascheduler.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ScheduleRepository extends JpaRepository<Schedule,Long> {

}
