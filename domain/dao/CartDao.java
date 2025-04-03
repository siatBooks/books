package domain.dao;

import domain.dto.cart.CartInsertRequestDto;
import domain.dto.cart.CartUpdateRequestDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartDao extends ParentDao {

    public List<String> selectCart(int userId) {
        List<String> cartItems = new ArrayList<>();
        String sql = "SELECT item_name FROM cart WHERE user_id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                cartItems.add(rs.getString("item_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cartItems;
    }

    public int insertCart(CartInsertRequestDto dto) {
        String sql = "INSERT INTO cart (user_id, item_name, quantity) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, dto.getUserId());
            pstmt.setString(2, dto.getItemName());
            pstmt.setInt(3, dto.getQuantity());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int updateCart(CartUpdateRequestDto dto) {
        String sql = "UPDATE cart SET quantity = ? WHERE user_id = ? AND item_name = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, dto.getQuantity());
            pstmt.setInt(2, dto.getUserId());
            pstmt.setString(3, dto.getItemName());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int deleteCart(int userId) {
        String sql = "DELETE FROM cart WHERE user_id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}