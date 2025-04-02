package service.user;

import domain.dto.cart.CartInsertRequestDto;
import domain.dto.cart.CartUpdateRequestDto;
import domain.dto.order.OrderSheetUpdateDto;
import domain.dto.user.UserInfoUpdateRequestDto;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public int login(String loginId, int password) {
        return 0;
    }

    @Override
    public List selectUserInfo(int userId) {
        return List.of();
    }

    @Override
    public int updateUserInfo(int userId, UserInfoUpdateRequestDto dto) {
        return 0;
    }
}
