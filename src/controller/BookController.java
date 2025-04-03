package controller;

import domain.dto.book.BookListItemResponseDto;
import domain.dto.book.BookInfoDetailResponseDto;
import domain.dto.book.BookListItemDto;
import service.book.BookService;

import java.util.List;
import java.util.Optional;

public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // 전체 검색
    public List<BookListItemDto> selectBookList(String keyword){
        return bookService.selectBookList(keyword);
    }

    // 베스트셀러 검색
    public List<BookListItemDto> selectBookListInBest(String keyword){
        return bookService.selectBookListInBest(keyword);
    }

    // 신작 검색
    public List<BookListItemDto> selectBookListInNew(String keyword){
        return bookService.selectBookListInNew(keyword);
    }

    // 상세보기
    public Optional<BookInfoDetailResponseDto> selectBookDetail(int bookId){
        return bookService.selectBookDetail(bookId);
    }

    // 리스트 정렬
    public List<BookListItemDto> sortList(String type, List<BookListItemDto> requestDtos) {
        return bookService.sortList(type, requestDtos);
    }

}


