package domain.dao;

import domain.dto.book.BookListItemDto;
import domain.dto.cart.CartSelectResponseDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CartDao extends ParentDao {
    public int insertCart(int userId) {
        int flag = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String insertSQL = "INSERT INTO CART (CART_ID, USER_ID, CART_TOTAL_PRICE) VALUES (?,?,?)";

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            preparedStatement = connection.prepareStatement(insertSQL);
            flag = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        return flag;
    }

    public int insertItemInCart(int bookId, int qty) {
        int flag = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String insertSQL = "INSERT INTO BOOK_CART (STATUS, BOOK_ID, CART_ID, CART_QTY) VALUES (?,?,?,?)";

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            preparedStatement = connection.prepareStatement(insertSQL);
            preparedStatement.setString(1, "바랜 책");
            preparedStatement.setInt(2, bookId);
            preparedStatement.setInt(3, bookId);
            preparedStatement.setInt(4, qty);
            flag = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        return flag;
    }

    public CartSelectResponseDto selectCart(int userId) {
        CartSelectResponseDto cartSelectResponseDto = CartSelectResponseDto.builder().build();
        List<CartSelectResponseDto.BookCartDto> bookCartDtoList = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String selectSQL = "SELECT * FROM BOOK_CART WHERE CART_ID = 1";
        ResultSet rset = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            preparedStatement = connection.prepareStatement(selectSQL);
            rset = preparedStatement.executeQuery();
            while (rset.next()) {
                CartSelectResponseDto.BookCartDto bookCartDto = CartSelectResponseDto.BookCartDto.builder()
                        .status(rset.getString("status"))
                        .bookId(rset.getLong("book_id"))
                        .cartQty(rset.getInt("cart_qty"))
                        .build();
                bookCartDtoList.add(bookCartDto);
            }

            // CartSelectResponseDto 객체 생성
            cartSelectResponseDto = CartSelectResponseDto.builder()
                    .books(bookCartDtoList)
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return cartSelectResponseDto;
    }
}
