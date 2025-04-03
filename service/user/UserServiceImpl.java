package service.user;

import domain.dao.OrderDao;
import domain.dao.UserDao;
import domain.dto.cart.CartInsertRequestDto;
import domain.dto.cart.CartUpdateRequestDto;
import domain.dto.order.OrderSheetUpdateDto;
import domain.dto.user.UserInfoSelectResponseDto;
import domain.dto.user.UserInfoUpdateRequestDto;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public int login(String loginId, int password) {
        return 0;
    }

    @Override
    public UserInfoSelectResponseDto selectUserInfo(int userId) {
        return null;
    }

    @Override
    public int updateUserInfo(int userId, UserInfoUpdateRequestDto dto) {
        return 0;
    }
}
