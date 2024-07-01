package com.sparta.spartascheduler.dto;

import com.sparta.spartascheduler.entity.User;
import com.sparta.spartascheduler.entity.UserRoleEnum;
import lombok.Getter;

@Getter
public class SignupResponseDto {
    private String username;
    private String nickname;
    private UserRoleEnum role;

    public SignupResponseDto(User user){
        this.username=getUsername();
        this.nickname=getNickname();
        this.role=getRole();
    }
}
