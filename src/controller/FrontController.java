package controller;

import domain.dto.book.BookListItemResponseDto;
import factory.BeanFactory;

import java.util.List;

public class FrontController {
    private BeanFactory factory;

    public FrontController() {
        factory = BeanFactory.getInstance();
    }

    public List<BookListItemResponseDto> selectBookListInBest(String keyword){
        BookController bookController = (BookController) factory.getController("book");
        for (BookListItemResponseDto dto : bookController.selectBookListInBest(keyword)) {
            System.out.println("dto = " + dto);
        }
        return bookController.selectBookListInBest(keyword);
    }
    public List<BookListItemResponseDto> selectBookListInNew(String keyword){
        BookController bookController = (BookController) factory.getController("book");
        for (BookListItemResponseDto dto : bookController.selectBookListInBest(keyword)) {
            System.out.println("dto = " + dto);
        }
        return bookController.selectBookListInNew(keyword);
    }
    public List<BookListItemResponseDto> selectBookList(String keyword){
        BookController bookController = (BookController) factory.getController("book");
        for (BookListItemResponseDto dto : bookController.selectBookListInBest(keyword)) {
            System.out.println("dto = " + dto);
        }
        return bookController.selectBookList(keyword);
    }





}
