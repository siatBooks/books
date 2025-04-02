package service.book;

import domain.dto.book.BookListItemResponseDto;
import domain.dto.book.BookInfoDetailResponseDto;
import domain.dto.book.BookSortListItemRequestDto;
import domain.dto.book.BookSortListItemResponseDto;

import java.util.List;

public class BookServiceImpl implements BookService {
    @Override
    public List<BookListItemResponseDto> selectBookList(String keyword) {
        return List.of();
    }

    @Override
    public List<BookListItemResponseDto> selectBookListInBest(String keyword) {
        return List.of();
    }

    @Override
    public List<BookListItemResponseDto> selectBookListInNew(String keyword) {
        return List.of();
    }

    @Override
    public BookInfoDetailResponseDto selectBookDetail(int bookId) {
        return BookInfoDetailResponseDto.builder().build();
    }

    @Override
    public List<BookSortListItemResponseDto> sortList(List<BookSortListItemRequestDto> requestDtos) {
        return List.of();
    }
}
