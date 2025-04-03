package service.cart;

import domain.dto.cart.CartInsertRequestDto;
import domain.dto.cart.CartUpdateRequestDto;
import domain.dto.order.OrderSheetUpdateDto;
import domain.dto.user.UserInfoUpdateRequestDto;

import java.util.List;

public interface CartService {
    // 장바구니

    // 장바구니 보기
    List selectCart(int userId);
    
    // 장바구니에 담기
    int insertCart(CartInsertRequestDto dto);

    // 장바구니 수정
    int updateCart(CartUpdateRequestDto dto);

    // 장바구니 비우기
    int deleteCart(int userId);
}
