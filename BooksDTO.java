public class BooksDTO {
    private String title;
    private String author;
    private String publisher;
    private int yearPublished;

    public BooksDTO(String title, String author, String publisher, int yearPublished) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.yearPublished = yearPublished;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getYearPublished() {
        return yearPublished;
    }
}
