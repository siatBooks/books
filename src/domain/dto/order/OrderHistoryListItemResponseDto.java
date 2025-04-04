package domain.dto.order;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@ToString
@Builder
@Data
public class OrderHistoryListItemResponseDto {
    private Long orderId;            // 주문 ID (Primary Key)
    private Date orderDate;          // 주문 날짜
    private int orderTotalPrice;     // 주문 총 가격
    private Long userId;             // 사용자 ID (Users 테이블의 Foreign Key)
    private Long cartId;             // 카트 ID (Cart 테이블의 Foreign Key)
    private String orderAddress;     // 주문 주소
}
