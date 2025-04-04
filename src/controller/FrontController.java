package controller;

import domain.dto.book.BookInfoDetailResponseDto;
import domain.dto.book.BookListItemDto;
import domain.dto.cart.CartSelectResponseDto;
import domain.dto.order.OrderDetailByCartRequestDto;
import domain.dto.order.OrderHistoryListItemResponseDto;
import factory.BeanFactory;

import java.util.List;
import java.util.Optional;

public class FrontController {
    private BeanFactory factory;

    public FrontController() {
        factory = BeanFactory.getInstance();
    }

    // book

    public List<BookListItemDto> selectBookListInBest(String keyword){
        BookController bookController = (BookController) factory.getController("book");
        for (BookListItemDto dto : bookController.selectBookListInBest(keyword)) {
            System.out.println("dto = " + dto);
        }
        return bookController.selectBookListInBest(keyword);
    }
    public List<BookListItemDto> selectBookListInNew(String keyword){
        BookController bookController = (BookController) factory.getController("book");
        for (BookListItemDto dto : bookController.selectBookListInBest(keyword)) {
            System.out.println("dto = " + dto);
        }
        return bookController.selectBookListInNew(keyword);
    }
    public List<BookListItemDto> selectBookList(String keyword){
        BookController bookController = (BookController) factory.getController("book");
        for (BookListItemDto dto : bookController.selectBookListInBest(keyword)) {
            System.out.println("dto = " + dto);
        }
        return bookController.selectBookList(keyword);
    }

    public List sortList(String type, List<BookListItemDto> requestDtos){
        BookController bookController = (BookController) factory.getController("book");
        for (BookListItemDto dto : bookController.sortList(type, requestDtos)) {
            System.out.println("dto = " + dto);
        }
        return bookController.sortList(type, requestDtos);
    }

    public Optional<BookInfoDetailResponseDto> selectBookDetail(int bookId) {
        BookController bookController = (BookController) factory.getController("book");
        System.out.println(bookController.selectBookDetail(bookId).get());

        return bookController.selectBookDetail(bookId);
    }

    // cart

    public CartSelectResponseDto selectCart(int userId) {
        CartController cartController = (CartController) factory.getController("cart");

        return cartController.selectCart(userId);
    }

    public int insertItemInCart(double total, int userId, String status, int bookId, int qty){
        CartController cartController = (CartController) factory.getController("cart");

        return cartController.insertItemInCart(total, userId, status, bookId, qty);
    }

    public int insertOrderByCart(OrderDetailByCartRequestDto dto) {
        OrderController orderController = (OrderController) factory.getController("order");
        return orderController.insertOrderByCart(dto);
    }



    public List<OrderHistoryListItemResponseDto> selectOrderHistory(int userId) {
        OrderController orderController = (OrderController) factory.getController("order");
        return orderController.selectOrderHistory(userId);

    }


}
