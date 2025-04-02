package service.book;
import domain.dto.book.BookInfoDetailResponseDto;

import java.util.List;

public interface BookService {
    // 검색

    // 전체 검색
    List selectBookList(String keyword);

    // 베스트셀러 검색
    List selectBookListInBest(String keyword);

    // 신작 검색
    List selectBookListInNew(String keyword);

    // 상세보기
    BookInfoDetailResponseDto selectBookDetail(int bookId);
}
