package domain.dao;

import domain.dto.order.OrderHistoryListItemResponseDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class OrderDao extends ParentDao {
    int orderId = 1;
    public int insertOrder(Date orderDate, int orderTotalPrice, int userId, int cartId, String orderAddress) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        // Oracle 시퀀스 사용 시 (시퀀스명: order_seq)
        String insertSQL = "INSERT INTO Orders (order_id, order_date, order_total_price, user_id, cart_id, order_address) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            preparedStatement = connection.prepareStatement(insertSQL);

            preparedStatement.setInt(1, orderId++);
            preparedStatement.setTimestamp(2, new java.sql.Timestamp(orderDate.getTime()));  // 날짜+시간 처리
            preparedStatement.setInt(3, orderTotalPrice);
            preparedStatement.setInt(4, userId);
            preparedStatement.setInt(5, cartId);
            preparedStatement.setString(6, orderAddress);

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(preparedStatement != null) preparedStatement.close();  // [개선] 리소스 누수 방지
                if(connection != null) connection.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return orderId;
    }

    public int insertOrderItem(Date orderDate, int orderTotalPrice, int userId, int cartId, String orderAddress) {
        int flag = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        // Oracle 시퀀스 사용 시 (시퀀스명: order_seq)
        String insertSQL = "INSERT INTO Orders (order_id, order_date, order_total_price, user_id, cart_id, order_address) "
                + "VALUES (order_seq.NEXTVAL, ?, ?, ?, ?, ?)";

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            preparedStatement = connection.prepareStatement(insertSQL);

            preparedStatement.setTimestamp(1, new java.sql.Timestamp(orderDate.getTime()));  // 날짜+시간 처리
            preparedStatement.setInt(2, orderTotalPrice);
            preparedStatement.setInt(3, userId);
            preparedStatement.setInt(4, cartId);
            preparedStatement.setString(5, orderAddress);

            flag = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(preparedStatement != null) preparedStatement.close();  // [개선] 리소스 누수 방지
                if(connection != null) connection.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return flag;
    }

    public int insertBookOrder(String status, int bookId, int orderId, int cartQty) {
        int flag = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        // SQL INSERT 문
        String insertSQL = "INSERT INTO book_order (order_id, status, book_id, order_qty) VALUES (?, ?, ?, ?)";

        try {
            // 데이터베이스 연결
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            preparedStatement = connection.prepareStatement(insertSQL);

            // PreparedStatement에 값 설정
            preparedStatement.setInt(1, orderId);  // status는 문자열
            preparedStatement.setString(2, status);     // book_id는 숫자
            preparedStatement.setInt(3, bookId);     // cart_id는 숫자
            preparedStatement.setInt(4, cartQty);    // cart_qty는 숫자

            // INSERT 실행
            flag = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();  // 예외 발생 시 스택 트레이스 출력
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();  // PreparedStatement 닫기
                if (connection != null) connection.close();                // Connection 닫기
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        return flag;  // 성공적으로 INSERT된 행 수 반환
    }


    public List<OrderHistoryListItemResponseDto> selectRow() {

        List<OrderHistoryListItemResponseDto> list = new ArrayList<>();


        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String selectSQL = "SELECT * FROM orders";
        ResultSet rset = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            preparedStatement = connection.prepareStatement(selectSQL);
            rset = preparedStatement.executeQuery();
            while (rset.next()) {
                OrderHistoryListItemResponseDto dto = OrderHistoryListItemResponseDto.builder()
                        .orderId(rset.getLong(1))                     // 주문 ID 설정
                        .orderDate(rset.getDate(2))              // 주문 날짜 설정
                        .orderTotalPrice(rset.getInt(3))             // 주문 총 가격 설정
                        .userId(rset.getLong(4))                       // 사용자 ID 설정
                        .cartId(rset.getLong(5))                       // 카트 ID 설정
                        .orderAddress(rset.getString(6))       // 주문 주소 설정
                        .build();
                list.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return list;
    }

}
