package controller;

import domain.dto.book.BookInfoDetailResponseDto;
import domain.dto.book.BookListItemResponseDto;
import domain.dto.book.BookListItemDto;
import factory.BeanFactory;

import java.util.List;
import java.util.Optional;

public class FrontController {
    private BeanFactory factory;

    public FrontController() {
        factory = BeanFactory.getInstance();
    }

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
        return bookController.selectBookDetail(bookId);
    }





}
