package controller;

import service.book.BookService;

import java.util.List;

public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // 전체 검색
    public List selectBookList(String keyword){
        return bookService.selectBookList(keyword);
    };

    // 베스트셀러 검색
    public List selectBookListInBest(String keyword){
        return bookService.selectBookListInBest(keyword);

    };

    // 신작 검색
    public List selectBookListInNew(String keyword){
        return bookService.selectBookListInNew(keyword);
    };

    // 상세보기
    public
}


