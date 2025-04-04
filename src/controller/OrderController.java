package controller;

import domain.dto.order.*;
import service.order.OrderService;

import java.util.List;

public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // 이전 주문 내역 확인
    public List<OrderHistoryListItemResponseDto> selectOrderHistory(int userId){
        return orderService.selectOrderHistory(userId);
    };

    // 바로 구매하기 주문
    public OrderDetailByDirectResponseDto selectOrderDetailByDirect(OrderDetailByDirectRequestDto requestDto){
        return orderService.selectOrderDetailByDirect(requestDto);
    };

    // 장바구니로부터 구매하기 주문
    public int insertOrderByCart(OrderDetailByCartRequestDto requestDto){
        return orderService.insertOrderByCart(requestDto);
    };

}
