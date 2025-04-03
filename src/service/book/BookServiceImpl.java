package service.book;

import domain.dao.BookDao;
import domain.dto.book.BookListItemResponseDto;
import domain.dto.book.BookInfoDetailResponseDto;
import domain.dto.book.BookSortListItemRequestDto;
import domain.dto.book.BookSortListItemResponseDto;

import java.util.List;

public class BookServiceImpl implements BookService {
    private BookDao bookDao;

    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public List<BookListItemResponseDto> selectBookList(String keyword) {
        return bookDao.selectBookList(keyword);
    }

    @Override
    public List<BookListItemResponseDto> selectBookListInBest(String keyword) {
        return bookDao.selectBookListInBest(keyword);
    }

    @Override
    public List<BookListItemResponseDto> selectBookListInNew(String keyword) {
        return bookDao.selectBookListInNew(keyword);
    }

    @Override
    public BookInfoDetailResponseDto selectBookDetail(int bookId) {
        return null;
    }

    @Override
    public List<BookSortListItemResponseDto> sortList(List<BookSortListItemRequestDto> requestDtos) {
        return List.of();
    }

//    @Override
//    public BookInfoDetailResponseDto selectBookDetail(int bookId) {
//        return bookDao.selectBookDetail(bookId);
//    }
//
//    @Override
//    public List<BookSortListItemResponseDto> sortList(List<BookSortListItemRequestDto> requestDtos) {
//        return bookDao.sortList(requestDtos);
//    }
}
