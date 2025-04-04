package service.cart;

import domain.dao.BookDao;
import domain.dao.CartDao;
import domain.dto.cart.CartInsertRequestDto;
import domain.dto.cart.CartSelectResponseDto;
import domain.dto.cart.CartUpdateRequestDto;
import domain.dto.order.OrderSheetUpdateDto;
import domain.dto.user.UserInfoUpdateRequestDto;

import java.util.List;

public class CartServiceImpl implements CartService {
    private CartDao cartDao;

    public CartServiceImpl(CartDao cartDao) {
        this.cartDao = cartDao;
    }

    @Override
    public CartSelectResponseDto selectCart(int userId) {
        return cartDao.selectCart(userId);
    }

    @Override
    public int insertItemInCart(double total, int userId, String status, int bookId, int qty) {
        cartDao.sumPrice(total);
        return cartDao.insertItemInCart(userId, status, bookId, qty);
    }

    @Override
    public int insertCart(int userId) {
        return cartDao.insertCart(userId);
    }

    @Override
    public int updateCart(CartUpdateRequestDto dto) {
        return 0;
    }

    @Override
    public int deleteCart(int userId) {
        return 0;
    }
}
