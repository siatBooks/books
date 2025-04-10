package domain.dto.book;

public class BookListItemResponseDto {
    private String title;
    private String author;

    public BookListItemResponseDto(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Getter
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    // (선택) toString()
    @Override
    public String toString() {
        return "📘 " + title + " | 저자: " + author;
    }
}
