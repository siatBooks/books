package domain.dao;

import domain.dto.book.BookListItemResponseDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookDao extends ParentDao{
    public List<BookListItemResponseDto> selectBookList(String keyword) {
        List list = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String selectSQL = "SELECT * FROM BOOK_INFO";
        ResultSet rset = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            preparedStatement = connection.prepareStatement(selectSQL);
            rset = preparedStatement.executeQuery();
            while (rset.next()) {
                BookListItemResponseDto bookListItemResponseDto = BookListItemResponseDto.builder()
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

    public List<BookListItemResponseDto> selectBookListInBest(String keyword) {
        List list = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String selectSQL = "SELECT * FROM BOOK_INFO WHERE DISPLAY_TYPE = '베스트셀러'";
        ResultSet rset = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            preparedStatement = connection.prepareStatement(selectSQL);
            rset = preparedStatement.executeQuery();
            while (rset.next()) {
                BookListItemResponseDto bookListItemResponseDto = BookListItemResponseDto.builder()
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

    public List<BookListItemResponseDto> selectBookListInNew(String keyword) {
        List list = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String selectSQL = "SELECT * FROM BOOK_INFO WHERE DISPLAY_TYPE = '신간'";
        ResultSet rset = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            preparedStatement = connection.prepareStatement(selectSQL);
            rset = preparedStatement.executeQuery();
            while (rset.next()) {
                BookListItemResponseDto bookListItemResponseDto = BookListItemResponseDto.builder()
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
}
