package service.book;
import domain.dto.book.BookListItemResponseDto;
import domain.dto.book.BookInfoDetailResponseDto;
import domain.dto.book.BookListItemDto;

import java.util.List;
import java.util.Optional;

public interface BookService {
    // 검색

    // 전체 검색
    List<BookListItemDto> selectBookList(String keyword);

    // 베스트셀러 검색
    List<BookListItemDto> selectBookListInBest(String keyword);

    // 신작 검색
    List<BookListItemDto> selectBookListInNew(String keyword);

    // 상세보기
    Optional<BookInfoDetailResponseDto> selectBookDetail(int bookId);

    List<BookListItemDto> sortList(String type, List<BookListItemDto> requestDtos);
}
