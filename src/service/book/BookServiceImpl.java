package service.book;

import domain.dao.BookDao;
import domain.dto.book.BookListItemResponseDto;
import domain.dto.book.BookInfoDetailResponseDto;
import domain.dto.book.BookListItemDto;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookServiceImpl implements BookService {
    private BookDao bookDao;

    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public List<BookListItemDto> selectBookList(String keyword) {
        return bookDao.selectBookList(keyword);
    }

    @Override
    public List<BookListItemDto> selectBookListInBest(String keyword) {
        return bookDao.selectBookListInBest(keyword);
    }

    @Override
    public List<BookListItemDto> selectBookListInNew(String keyword) {
        return bookDao.selectBookListInNew(keyword);
    }

    @Override
    public Optional<BookInfoDetailResponseDto> selectBookDetail(int bookId) {
        return bookDao.selectBookDetail(bookId);
    }

    @Override
    public List<BookListItemDto> sortList(String type, List<BookListItemDto> requestDtos) {
        return requestDtos.stream()
                .sorted(switch (type) {
                    case "perdateAsc" -> Comparator.comparing(BookListItemDto::getPerdate);
                    case "perdateDesc" -> Comparator.comparing(BookListItemDto::getPerdate).reversed();
                    case "priceStandardAsc" -> Comparator.comparing(BookListItemDto::getPriceStandard);
                    case "priceStandardDesc" -> Comparator.comparing(BookListItemDto::getPriceStandard).reversed();
                    default -> Comparator.comparing(BookListItemDto::getBookId); // 기본 정렬 (bookId 기준)
                })
                .collect(Collectors.toList());
    }
}
