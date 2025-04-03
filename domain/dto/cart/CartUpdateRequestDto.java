package domain.dto.cart;

public class CartUpdateRequestDto {
    private int userId;       // 사용자 ID
    private String itemName;  // 수정할 항목 이름
    private int quantity;     // 수정할 수량

    // 기본 생성자
    public CartUpdateRequestDto() {
    }

    // 모든 필드를 초기화하는 생성자
    public CartUpdateRequestDto(int userId, String itemName, int quantity) {
        this.userId = userId;
        this.itemName = itemName;
        this.quantity = quantity;
    }

    // Getter와 Setter
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartUpdateRequestDto{" +
                "userId=" + userId +
                ", itemName='" + itemName + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}