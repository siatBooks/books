package service.order;

import domain.dto.cart.CartInsertRequestDto;
import domain.dto.cart.CartUpdateRequestDto;
import domain.dto.order.OrderSheetUpdateDto;
import domain.dto.user.UserInfoUpdateRequestDto;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    @Override
    public List selectOrder(int userId) {
        return List.of();
    }

    @Override
    public int updateOrder(OrderSheetUpdateDto dto) {
        return 0;
    }
}
