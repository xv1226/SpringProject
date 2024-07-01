package com.sparta.spartascheduler.controller;

import com.sparta.spartascheduler.dto.LoginResponseDto;
import com.sparta.spartascheduler.dto.SignupResponseDto;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import com.sparta.spartascheduler.Security.UserDetailsImpl;
import com.sparta.spartascheduler.dto.LoginRequestDto;
import com.sparta.spartascheduler.dto.SignupRequestDto;
import com.sparta.spartascheduler.entity.User;
import com.sparta.spartascheduler.jwt.JwtUtil;
import com.sparta.spartascheduler.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    private final JwtUtil jwtUtil;
    private final UserService userService;

    public UserController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }


    @PostMapping("/users/signup")
    public ResponseEntity<SignupResponseDto> signup(@RequestBody @Valid SignupRequestDto requestDto) {
        return userService.signup(requestDto);
    }

    @PostMapping("/users/login")
    public ResponseEntity<LoginResponseDto> login(LoginRequestDto requestDto, HttpServletResponse res) {

        return userService.login(requestDto, res);
    }

    @PostMapping("/users/logout")
    public ResponseEntity<String> logout(HttpServletRequest request, HttpServletResponse response) {
        // 현재 사용자의 세션 무효화
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        // 쿠키 삭제
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }

        return ResponseEntity.ok("로그아웃 완료");
    }

    @PostMapping("/users/refresh")
    public ResponseEntity<String> refresh(@RequestHeader("RefreshToken") String refreshToken) {
        if (jwtUtil.validateToken(refreshToken)) {
            String username = jwtUtil.getUserInfoFromToken(refreshToken).getSubject();
            return ResponseEntity.ok(jwtUtil.createAccessToken(username, userService.getUserByUsername(username).getRole()));
        } else {
            throw new IllegalArgumentException("유효하지 않은 리프레시 토큰입니다.");
        }
    }

    @DeleteMapping("/users/delete")
    public ResponseEntity<String> userDelete(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        User user = userDetails.getUser();
        userService.deleteById(user.getId());

        return ResponseEntity.ok("회원탈퇴 완료");
    }
}