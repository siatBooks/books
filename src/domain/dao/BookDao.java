package domain.dao;

// public class BookDao extends ParentDao{

// }


import domain.dto.book.BookListItemResponseDto;
import domain.dto.book.BookInfoDetailResponseDto;

import java.util.ArrayList;
import java.util.List;

public class BookDao extends ParentDao {

    public List<BookListItemResponseDto> findAllByKeyword(String keyword) {
        // 실제 DB 연동 전에 임시 데이터 반환
        List<BookListItemResponseDto> list = new ArrayList<>();
        list.add(new BookListItemResponseDto("자바의 정석", "남궁성"));
        list.add(new BookListItemResponseDto("Effective Java", "조슈아 블로흐"));
        return list;
    }

    public List<BookListItemResponseDto> findBestByKeyword(String keyword) {
        List<BookListItemResponseDto> list = new ArrayList<>();
        list.add(new BookListItemResponseDto("이것이 자바다", "신용권"));
        return list;
    }

    public List<BookListItemResponseDto> findNewByKeyword(String keyword) {
        List<BookListItemResponseDto> list = new ArrayList<>();
        list.add(new BookListItemResponseDto("모던 자바 인 액션", "라울-게이브리얼 우르마"));
        return list;
    }

    public BookInfoDetailResponseDto findById(int bookId) {
        return BookInfoDetailResponseDto.builder()
                .title("자바 프로그래밍")
                .author("홍길동")
                .publisher("코딩출판사")
                .publishedDate("2023-01-01")
                .build();
    }
}