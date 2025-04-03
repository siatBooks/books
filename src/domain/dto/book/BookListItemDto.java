package domain.dto.book;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@Builder
public class BookListItemDto {
    private Long bookId;
    private String title;
    private String author;
    private Date perdate;
    private Integer priceStandard;
    private Integer priceSales;
    private String isbn;
    private Integer customerReviewRank;
    private String description;
    private String link;
    private String bookType;
    private String displayType;
    private String coverImg;
    private Integer salesPoint;
    private Long categoryId;
}
