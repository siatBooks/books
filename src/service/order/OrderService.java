package service.order;

import domain.dto.cart.CartInsertRequestDto;
import domain.dto.cart.CartUpdateRequestDto;
import domain.dto.order.OrderSheetUpdateDto;
import domain.dto.user.UserInfoUpdateRequestDto;

import java.util.List;

public interface OrderService {
    // 주문

    // 이전 주문 내역 확인
    List selectOrder(int userId);

    // 주문서 수정
    int updateOrder(OrderSheetUpdateDto dto);
}
