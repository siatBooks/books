package controller;

import domain.dto.cart.CartInsertRequestDto;
import domain.dto.cart.CartUpdateRequestDto;
import service.cart.CartService;

import java.util.List;

public class CartController {
    private CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    // 장바구니 보기
    public List selectCart(int userId){
        return cartService.selectCart(userId);
    };

    // 장바구니에 담기
    public int insertCart(CartInsertRequestDto dto){
        return cartService.insertCart(dto);
    };

    // 장바구니 수정
    public int updateCart(CartUpdateRequestDto dto){
        return cartService.updateCart(dto);
    };

    // 장바구니 비우기
    public int deleteCart(int userId){
        return cartService.deleteCart(userId);
    };
}
