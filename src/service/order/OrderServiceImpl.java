package service.order;

import domain.dao.CartDao;
import domain.dao.OrderDao;
import domain.dto.order.*;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao;

    public OrderServiceImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public List<OrderHistoryListItemResponseDto> selectOrderHistory(int userId) {
        return List.of();
    }

    @Override
    public OrderDetailByDirectResponseDto selectOrderDetailByDirect(OrderDetailByDirectRequestDto requestDto) {
        return null;
    }

    @Override
    public OrderDetailByCartResponseDto selectOrderDetailByCart(OrderDetailByCartRequestDto requestDto) {
        return null;
    }

    @Override
    public int updateOrder(OrderSheetUpdateDto dto) {
        return 0;
    }
}
