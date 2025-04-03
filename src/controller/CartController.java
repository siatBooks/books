package controller;

import domain.dto.cart.CartInsertRequestDto;
import domain.dto.cart.CartSelectResponseDto;
import domain.dto.cart.CartUpdateRequestDto;
import service.cart.CartService;

import java.util.List;

public class CartController {
    private CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    // 장바구니 생성
    public int insertCart(int userId){
        return cartService.insertCart(userId);
    };

    // 장바구니 보기
    public CartSelectResponseDto selectCart(int userId){
        System.out.println(cartService.selectCart(userId));
        return cartService.selectCart(userId);
    };

    // 장바구니에 담기
    public int insertItemInCart(int bookId, int qty){
        return cartService.insertItemInCart(bookId, qty);
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
