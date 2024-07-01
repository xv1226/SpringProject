package com.sparta.spartascheduler.dto;

import com.sparta.spartascheduler.entity.User;
import lombok.Getter;

@Getter
public class LoginResponseDto {
    private String username;
    private String nickname;

    public LoginResponseDto(User user){
        this.username=getUsername();
        this.nickname=getNickname();
    }
}
