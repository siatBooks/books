package service.book;

import domain.dto.book.BookInfoDetailResponseDto;

import java.util.List;

public class BookServiceImpl implements BookService {
    @Override
    public List selectBookList(String keyword) {
        return List.of();
    }

    @Override
    public List selectBookListInBest(String keyword) {
        return List.of();
    }

    @Override
    public List selectBookListInNew(String keyword) {
        return List.of();
    }

    @Override
    public BookInfoDetailResponseDto selectBookDetail(int bookId) {
        return BookInfoDetailResponseDto.builder().build();
    }
}
