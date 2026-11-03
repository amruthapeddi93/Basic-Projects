package lib;

import java.util.ArrayList;

public class Library {

    ArrayList<Book> books = new ArrayList<>();

    // Add Book
    public void addBook(Book book) {

        for (Book b : books) {
            if (b.bookId == book.bookId || b.isbn.equals(book.isbn)) {
                System.out.println("Book ID or ISBN already exists!");
                return;
            }
        }

        books.add(book);
        System.out.println("\nBook added successfully!");
    }

    // View All Books
    public void viewBooks() {

        if (books.isEmpty()) {
            System.out.println("\nNo books available in the library.");
            return;
        }

        System.out.println("\n========== ALL LIBRARY BOOKS ==========");

        for (Book book : books) {
            book.displayBook();
        }
    }

    // Search Book by ID
    public void searchBook(int id) {

        for (Book book : books) {
            if (book.bookId == id) {
                System.out.println("\nBook found successfully!");
                book.displayBook();
                return;
            }
        }

        System.out.println("\nNo book found with ID: " + id);
    }

    // Search Book by Title
    public void searchByTitle(String title) {

        boolean found = false;

        for (Book book : books) {
            if (book.title.toLowerCase().contains(title.toLowerCase())) {
                book.displayBook();
                found = true;
            }
        }

        if (!found) {
            System.out.println("\nNo book found with title: " + title);
        }
    }

    // Search Book by Author
    public void searchByAuthor(String author) {

        boolean found = false;

        for (Book book : books) {
            if (book.author.toLowerCase().contains(author.toLowerCase())) {
                book.displayBook();
                found = true;
            }
        }

        if (!found) {
            System.out.println("\nNo books found for author: " + author);
        }
    }

    // Issue Book
    public void issueBook(int id) {

        for (Book book : books) {

            if (book.bookId == id) {

                if (!book.isIssued) {
                    book.isIssued = true;
                    System.out.println("\nBook issued successfully!");
                    System.out.println("Book Title: " + book.title);
                } else {
                    System.out.println("\nThis book is already issued.");
                }

                return;
            }
        }

        System.out.println("\nBook not found with ID: " + id);
    }

    // Return Book
    public void returnBook(int id) {

        for (Book book : books) {

            if (book.bookId == id) {

                if (book.isIssued) {
                    book.isIssued = false;
                    System.out.println("\nBook returned successfully!");
                    System.out.println("Book Title: " + book.title);
                } else {
                    System.out.println("\nThis book was not issued.");
                }

                return;
            }
        }

        System.out.println("\nBook not found with ID: " + id);
    }
}
