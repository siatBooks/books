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
        return orderDao.selectRow();
    }

    @Override
    public OrderDetailByDirectResponseDto selectOrderDetailByDirect(OrderDetailByDirectRequestDto requestDto) {
        return null;
    }

    @Override
    public int insertOrderByCart(OrderDetailByCartRequestDto requestDto) {
        int i = orderDao.insertOrder(requestDto.getOrderDate(), requestDto.getOrderTotalPrice(), requestDto.getUserId(), requestDto.getCartId(), requestDto.getOrderAddress());
        return orderDao.insertBookOrder(requestDto.getStatus(), requestDto.getBookId(), i, requestDto.getCartQty());
    }

    @Override
    public int updateOrder(OrderSheetUpdateDto dto) {
        return 0;
    }
}
