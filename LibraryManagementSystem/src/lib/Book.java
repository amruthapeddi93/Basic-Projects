package lib;
public class Book {

    int bookId;
    String title;
    String author;
    String category;
    String publisher;
    String isbn;
    String edition;
    int publicationYear;
    String shelfNumber;
    boolean isIssued;

    // Constructor
    public Book(int bookId, String title, String author,
                String category, String publisher, String isbn,
                String edition, int publicationYear,
                String shelfNumber) {

        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.category = category;
        this.publisher = publisher;
        this.isbn = isbn;
        this.edition = edition;
        this.publicationYear = publicationYear;
        this.shelfNumber = shelfNumber;
        this.isIssued = false;
    }

    // Display Book Details
    public void displayBook() {

        System.out.println("\n========== BOOK DETAILS ==========");
        System.out.println("Book ID          : " + bookId);
        System.out.println("Book Title       : " + title);
        System.out.println("Author Name      : " + author);
        System.out.println("Category         : " + category);
        System.out.println("Publisher        : " + publisher);
        System.out.println("ISBN             : " + isbn);
        System.out.println("Edition          : " + edition);
        System.out.println("Publication Year : " + publicationYear);
        System.out.println("Shelf Number     : " + shelfNumber);
        System.out.println("Status           : " +
                (isIssued ? "Issued" : "Available"));
        System.out.println("==================================");
    }
}
