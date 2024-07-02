package com.sparta.spartascheduler.dto;

import com.sparta.spartascheduler.entity.User;
import com.sparta.spartascheduler.entity.UserRoleEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupResponseDto {
    private String username;
    private String nickname;
    private UserRoleEnum role;

    public SignupResponseDto(User user){
        this.username=user.getUsername();
        this.nickname=user.getNickname();
        this.role=user.getRole();
    }
}
