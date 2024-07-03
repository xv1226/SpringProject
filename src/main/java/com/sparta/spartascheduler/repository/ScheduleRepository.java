package com.sparta.spartascheduler.repository;

import com.sparta.spartascheduler.entity.Schedule;
import com.sparta.spartascheduler.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule,Long> {
    List<Schedule> findAllByUserIdOrderByCreatedAtDesc(Long user_id);

    List<Schedule> deleteAllByUserId(Long user_id);
}
