package service.user;

import domain.dto.user.UserInfoUpdateRequestDto;

import java.util.List;

public interface UserService {
    // 계정

    // 로그인
    int login(String loginId, int password);

    // 유저 정보 조회
    List selectUserInfo(int userId);

    // 유저 정보 수정
    int updateUserInfo(int userId, UserInfoUpdateRequestDto dto);

}
