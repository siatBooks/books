package service.cart;

import domain.dao.CartDao;
import domain.dto.cart.CartInsertRequestDto;
import domain.dto.cart.CartUpdateRequestDto;

import java.util.List;

public class CartServiceImpl implements CartService {

    private final CartDao cartDao;

    public CartServiceImpl(CartDao cartDao) {
        this.cartDao = cartDao;
    }

    @Override
    public List<String> selectCart(int userId) {
        return cartDao.selectCart(userId);
    }

    @Override
    public int insertCart(CartInsertRequestDto dto) {
        return cartDao.insertCart(dto);
    }

    @Override
    public int updateCart(CartUpdateRequestDto dto) {
        return cartDao.updateCart(dto);
    }

    @Override
    public int deleteCart(int userId) {
        return cartDao.deleteCart(userId);
    }
}