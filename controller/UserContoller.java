package controller;

import domain.dto.user.UserInfoSelectResponseDto;
import domain.dto.user.UserInfoUpdateRequestDto;
import service.book.BookService;
import service.user.UserService;

import java.util.List;

public class UserContoller {
    private UserService userService;

    public UserContoller(UserService userService) {
        this.userService = userService;
    }

    // 유저 로그인
    public int login(String loginId, int password) {
        return userService.login(loginId, password);
    }

    // 유저 정보 조회
    public UserInfoSelectResponseDto selectUserInfo(int userId) {
        return userService.selectUserInfo(userId);
    }

    // 유저 정보 수정
    public int updateUserInfo(int userId, UserInfoUpdateRequestDto dto) {
        return userService.updateUserInfo(userId, dto);
    }
}
