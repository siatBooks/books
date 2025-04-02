package service;

import java.util.List;
import java.util.Map;

public class BookServiceImpl implements BookService {
    @Override
    public int login() {
        return 0;
    }

    @Override
    public List selectUserInfo(int userId) {
        return List.of();
    }

    @Override
    public int updateUserInfo(int userId, Map fieldMap) {
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
    public int insertCart(Map dto) {
        return 0;
    }

    @Override
    public int updateCart(Map dto) {
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
    public int updateOrder(Map dto) {
        return 0;
    }
}
