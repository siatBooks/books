package service.book;

import domain.dto.cart.CartInsertRequestDto;
import domain.dto.cart.CartUpdateRequestDto;
import domain.dto.order.OrderSheetUpdateDto;
import domain.dto.user.UserInfoUpdateRequestDto;

import java.util.List;

public interface BookService {
    // 계정

    // 로그인
    int login(String loginId, int password);

    // 유저 정보 조회
    List selectUserInfo(int userId);

    // 유저 정보 수정
    int updateUserInfo(int userId, UserInfoUpdateRequestDto dto);

    // 검색

    // 전체 검색
    List selectBookList(String keyword);

    // 베스트셀러 검색
    List selectBookListInBest(String keyword);

    // 신작 검색
    List selectBookListInNew(String keyword);

    // 상세보기
    List selectBookDetail(int bookId);

    // 장바구니

    // 장바구니 보기
    List selectCart(int userId);

    // 장바구니에 담기
    int insertCart(CartInsertRequestDto dto);

    // 장바구니 수정
    int updateCart(CartUpdateRequestDto dto);

    // 장바구니 비우기
    int deleteCart(int userId);

    // 주문

    // 이전 주문 내역 확인
    List selectOrder(int userId);

    // 주문서 수정
    int updateOrder(OrderSheetUpdateDto dto);
}
