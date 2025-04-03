package domain.dto.book;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@ToString
@Builder
@Data
public class BookListItemResponseDto {
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
