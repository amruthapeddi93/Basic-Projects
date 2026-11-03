package lib;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        int choice;

        do {

            System.out.println("\n======================================");
            System.out.println("       LIBRARY MANAGEMENT SYSTEM");
            System.out.println("======================================");
            System.out.println("1. Add New Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book by ID");
            System.out.println("4. Search Book by Title");
            System.out.println("5. Search Book by Author");
            System.out.println("6. Issue Book");
            System.out.println("7. Return Book");
            System.out.println("8. Exit");
            System.out.println("======================================");

            System.out.print("Enter your choice (1-8): ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.println("\n========== ADD NEW BOOK ==========");

                    System.out.print("Enter Unique Book ID (e.g., 101): ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Book Title (e.g., Java Programming): ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author Name (e.g., James Gosling): ");
                    String author = sc.nextLine();

                    System.out.print("Enter Category (e.g., Programming): ");
                    String category = sc.nextLine();

                    System.out.print("Enter Publisher Name (e.g., McGraw Hill): ");
                    String publisher = sc.nextLine();

                    System.out.print("Enter ISBN Number (e.g., 9780134685991): ");
                    String isbn = sc.nextLine();

                    System.out.print("Enter Edition (e.g., 3rd Edition): ");
                    String edition = sc.nextLine();

                    System.out.print("Enter Publication Year (e.g., 2023): ");
                    int year = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Shelf Number (e.g., A-12): ");
                    String shelf = sc.nextLine();

                    Book book = new Book(
                        id, title, author, category,
                        publisher, isbn, edition, year, shelf
                    );

                    library.addBook(book);

                    break;

                case 2:

                    library.viewBooks();

                    break;

                case 3:

                    System.out.print("Enter Book ID to search (e.g., 101): ");
                    id = sc.nextInt();

                    library.searchBook(id);

                    break;

                case 4:

                    System.out.print("Enter Book Title to search: ");
                    title = sc.nextLine();

                    library.searchByTitle(title);

                    break;

                case 5:

                    System.out.print("Enter Author Name to search: ");
                    author = sc.nextLine();

                    library.searchByAuthor(author);

                    break;

                case 6:

                    System.out.print("Enter Book ID to issue (e.g., 101): ");
                    id = sc.nextInt();

                    library.issueBook(id);

                    break;

                case 7:

                    System.out.print("Enter Book ID to return (e.g., 101): ");
                    id = sc.nextInt();

                    library.returnBook(id);

                    break;

                case 8:

                    System.out.println("\nThank you for using Library Management System!");

                    break;

                default:

                    System.out.println("\nInvalid choice! Please enter a number between 1 and 8.");
            }

        } while (choice != 8);

        sc.close();
    }
}
