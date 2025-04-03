package controller;

import domain.dto.book.BookListItemResponseDto;
import domain.dto.book.BookInfoDetailResponseDto;
import domain.dto.book.BookSortListItemRequestDto;
import domain.dto.book.BookSortListItemResponseDto;
import service.book.BookService;

import java.util.List;

public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // 전체 검색
    public List<BookListItemResponseDto> selectBookList(String keyword){
        return bookService.selectBookList(keyword);
    }

    // 베스트셀러 검색
    public List<BookListItemResponseDto> selectBookListInBest(String keyword){
        return bookService.selectBookListInBest(keyword);
    }

    // 신작 검색
    public List<BookListItemResponseDto> selectBookListInNew(String keyword){
        return bookService.selectBookListInNew(keyword);
    }

    // 상세보기
    public BookInfoDetailResponseDto selectBookDetail(int bookId){
        return bookService.selectBookDetail(bookId);
    }

    // 리스트 정렬
    public List<BookSortListItemResponseDto> sortList(List<BookSortListItemRequestDto> requestDtos) {
        return bookService.sortList(requestDtos);
    }

}


