package domain.dto.cart;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Builder
@ToString
public class CartSelectResponseDto {
    private Long cartId;
    private Integer cartTotalPrice;
    private List<BookCartDto> books; // 여러 개의 책을 담을 리스트

    @Data
    @Builder
    @ToString
    public static class BookCartDto {
        private String status;
        private int bookId;
        private Integer cartQty;
    }
}
