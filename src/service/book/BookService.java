package service.book;
import domain.dto.book.BookListItemResponseDto;
import domain.dto.book.BookInfoDetailResponseDto;
import domain.dto.book.BookSortListItemRequestDto;
import domain.dto.book.BookSortListItemResponseDto;

import java.util.List;

public interface BookService {
    // 검색

    // 전체 검색
    List<BookListItemResponseDto> selectBookList(String keyword);

    // 베스트셀러 검색
    List<BookListItemResponseDto> selectBookListInBest(String keyword);

    // 신작 검색
    List<BookListItemResponseDto> selectBookListInNew(String keyword);

    // 상세보기
    BookInfoDetailResponseDto selectBookDetail(int bookId);

    List<BookSortListItemResponseDto> sortList(List<BookSortListItemRequestDto> requestDtos);
}
