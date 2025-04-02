package service.cart;

import domain.dto.cart.CartInsertRequestDto;
import domain.dto.cart.CartUpdateRequestDto;
import domain.dto.order.OrderSheetUpdateDto;
import domain.dto.user.UserInfoUpdateRequestDto;

import java.util.List;

public class CartServiceImpl implements CartService {

    @Override
    public List selectCart(int userId) {
        return List.of();
    }

    @Override
    public int insertCart(CartInsertRequestDto dto) {
        return 0;
    }

    @Override
    public int updateCart(CartUpdateRequestDto dto) {
        return 0;
    }

    @Override
    public int deleteCart(int userId) {
        return 0;
    }
}
