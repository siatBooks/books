package domain.dto.order;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@Builder
public class OrderDetailByCartRequestDto {
    // Orders 테이블 관련 필드
    private Date orderDate;          // 주문 날짜
    private int orderTotalPrice;     // 주문 총 가격
    private int userId;              // 사용자 ID
    private int cartId;              // 카트 ID
    private String orderAddress;     // 주문 주소

    // Book_Order 테이블 관련 필드
    private String status;           // 주문 상태
    private int bookId;              // 책 ID
    private int cartQty;             // 카트 수량
}
