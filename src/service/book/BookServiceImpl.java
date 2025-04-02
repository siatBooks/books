package service.book;

import domain.dto.cart.CartInsertRequestDto;
import domain.dto.cart.CartUpdateRequestDto;
import domain.dto.order.OrderSheetUpdateDto;
import domain.dto.user.UserInfoUpdateRequestDto;

import java.util.List;

public class BookServiceImpl implements BookService {

    @Override
    public int login(String loginId, int password) {
        return 0;
    }

    @Override
    public List selectUserInfo(int userId) {
        return List.of();
    }

    @Override
    public int updateUserInfo(int userId, UserInfoUpdateRequestDto dto) {
        return 0;
    }

    @Override
    public List selectBookList(String keyword) {
        return List.of();
    }

    @Override
    public List selectBookListInBest(String keyword) {
        return List.of();
    }

    @Override
    public List selectBookListInNew(String keyword) {
        return List.of();
    }

    @Override
    public List selectBookDetail(int bookId) {
        return List.of();
    }

    @Override
    public List selectCart(int userId) {
        return List.of();
    }

    @Override
    public int insertCart(CartInsertRequestDto dto) {
        return 0;
    }

    @Override
    public int updateCart(CartUpdateRequestDto dto) {
        return 0;
    }

    @Override
    public int deleteCart(int userId) {
        return 0;
    }

    @Override
    public List selectOrder(int userId) {
        return List.of();
    }

    @Override
    public int updateOrder(OrderSheetUpdateDto dto) {
        return 0;
    }
}
