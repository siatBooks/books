package service.cart;

import domain.dto.cart.CartInsertRequestDto;
import domain.dto.cart.CartSelectResponseDto;
import domain.dto.cart.CartUpdateRequestDto;
import domain.dto.order.OrderSheetUpdateDto;
import domain.dto.user.UserInfoUpdateRequestDto;

import java.util.List;

public interface CartService {
    // 장바구니
    int insertCart(int userId);

    // 장바구니 보기
    CartSelectResponseDto selectCart(int userId);

    // 장바구니에 담기
    int insertItemInCart(int userId, String status, int BookId, int qty);

    // 장바구니 수정
    int updateCart(CartUpdateRequestDto dto);

    // 장바구니 비우기
    int deleteCart(int userId);

}
