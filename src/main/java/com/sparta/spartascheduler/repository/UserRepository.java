package com.sparta.spartascheduler.repository;

import com.sparta.spartascheduler.entity.User;
import com.sparta.spartascheduler.entity.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    //signup
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    Optional<User> findByStatus(UserStatus status);

    //profile
    boolean existsUserByUseridAndStatus(String requestUserid, UserStatus userStatus);
    Optional<User>findByUserid(String UserId);

}
