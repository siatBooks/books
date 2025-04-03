package service.order;

import domain.dto.order.*;

import java.util.List;

public interface OrderService {
    // 주문

    // 이전 주문 내역 확인
    List<OrderHistoryListItemResponseDto> selectOrderHistory(int userId);

    // 바로 구매하기
    OrderDetailByDirectResponseDto selectOrderDetailByDirect(OrderDetailByDirectRequestDto requestDto);

    // 장바구니로 부터 구매하기
    OrderDetailByCartResponseDto selectOrderDetailByCart(OrderDetailByCartRequestDto requestDto);

    // 주문서 수정
    int updateOrder(OrderSheetUpdateDto dto);
}
