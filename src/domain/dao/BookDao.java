package domain.dao;

import domain.dto.book.BookInfoDetailResponseDto;
import domain.dto.book.BookListItemDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class BookDao extends ParentDao{
    public List<BookListItemDto> selectBookList(String keyword) {
        List list = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String selectSQL = "SELECT * FROM BOOK_INFO WHERE TITLE LIKE ?";
        ResultSet rset = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setString(1, "%" + keyword + "%");
            rset = preparedStatement.executeQuery();
            while (rset.next()) {
                BookListItemDto bookListItemResponseDto = BookListItemDto.builder()
                        .bookId(rset.getLong("book_id"))
                        .title(rset.getString("title"))
                        .author(rset.getString("author"))
                        .perdate(rset.getDate("perdate"))
                        .priceStandard(rset.getInt("price_standard"))
                        .priceSales(rset.getInt("price_sales"))
                        .isbn(rset.getString("isbn"))
                        .customerReviewRank(rset.getInt("customer_review_rank"))
                        .description(rset.getString("description"))
                        .link(rset.getString("link"))
                        .bookType(rset.getString("book_type"))
                        .displayType(rset.getString("display_type"))
                        .coverImg(rset.getString("coverImg"))
                        .salesPoint(rset.getInt("sales_point"))
                        .categoryId(rset.getLong("category_id"))
                        .build();
                list.add(bookListItemResponseDto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return list;
    }

    public List<BookListItemDto> selectBookListInBest(String keyword) {
        List list = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String selectSQL = "SELECT * FROM BOOK_INFO bi FULL JOIN BOOK_ITEM bi2 ON(bi.BOOK_ID = bi2.BOOK_ID) WHERE DISPLAY_TYPE = 'BEST' AND TITLE LIKE ?";
        
        ResultSet rset = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setString(1, "%" + keyword + "%");
            rset = preparedStatement.executeQuery();
            while (rset.next()) {
                BookListItemDto bookListItemResponseDto = BookListItemDto.builder()
                        .bookId(rset.getLong("book_id"))
                        .title(rset.getString("title"))
                        .author(rset.getString("author"))
                        .perdate(rset.getDate("perdate"))
                        .priceStandard(rset.getInt("price_standard"))
                        .priceSales(rset.getInt("price_sales"))
                        .isbn(rset.getString("isbn"))
                        .customerReviewRank(rset.getInt("customer_review_rank"))
                        .description(rset.getString("description"))
                        .link(rset.getString("link"))
                        .bookType(rset.getString("book_type"))
                        .displayType(rset.getString("display_type"))
                        .coverImg(rset.getString("coverImg"))
                        .salesPoint(rset.getInt("sales_point"))
                        .categoryId(rset.getLong("category_id"))
                        .build();
                list.add(bookListItemResponseDto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return list;
    }

    public List<BookListItemDto> selectBookListInNew(String keyword) {
        List list = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String selectSQL = "SELECT * FROM BOOK_INFO WHERE DISPLAY_TYPE = 'NEW' AND TITLE LIKE ?";
        ResultSet rset = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setString(1, "%" + keyword + "%");
            rset = preparedStatement.executeQuery();
            while (rset.next()) {
                BookListItemDto bookListItemResponseDto = BookListItemDto.builder()
                        .bookId(rset.getLong("book_id"))
                        .title(rset.getString("title"))
                        .author(rset.getString("author"))
                        .perdate(rset.getDate("perdate"))
                        .priceStandard(rset.getInt("price_standard"))
                        .priceSales(rset.getInt("price_sales"))
                        .isbn(rset.getString("isbn"))
                        .customerReviewRank(rset.getInt("customer_review_rank"))
                        .description(rset.getString("description"))
                        .link(rset.getString("link"))
                        .bookType(rset.getString("book_type"))
                        .displayType(rset.getString("display_type"))
                        .coverImg(rset.getString("coverImg"))
                        .salesPoint(rset.getInt("sales_point"))
                        .categoryId(rset.getLong("category_id"))
                        .build();
                list.add(bookListItemResponseDto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return list;
    }


    public Optional<BookInfoDetailResponseDto> selectBookDetail(int bookId) {
        Optional<BookInfoDetailResponseDto> dto = Optional.empty();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String selectSQL = "SELECT * FROM BOOK_INFO WHERE BOOK_ID = ?";
        ResultSet rset = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setInt(1, bookId);
            rset = preparedStatement.executeQuery();
            while (rset.next()) {
                dto = Optional.of(BookInfoDetailResponseDto.builder()
                        .bookId(rset.getLong("book_id"))
                        .title(rset.getString("title"))
                        .author(rset.getString("author"))
                        .perdate(rset.getDate("perdate"))
                        .priceStandard(rset.getInt("price_standard"))
                        .priceSales(rset.getInt("price_sales"))
                        .isbn(rset.getString("isbn"))
                        .customerReviewRank(rset.getInt("customer_review_rank"))
                        .description(rset.getString("description"))
                        .link(rset.getString("link"))
                        .bookType(rset.getString("book_type"))
                        .displayType(rset.getString("display_type"))
                        .coverImg(rset.getString("coverImg"))
                        .salesPoint(rset.getInt("sales_point"))
                        .categoryId(rset.getLong("category_id"))
                        .build());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return dto;
    }
}
