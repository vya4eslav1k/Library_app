import model.Book;
import service.Library;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n1. Add Book\n2. Remove Book\n3. Search Book\n4. List All Books\n5. Exit");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter genre: ");
                    String genre = scanner.nextLine();
                    System.out.print("Enter year: ");
                    int year = Integer.parseInt(scanner.nextLine());
                    library.addBook(new Book(title, author, genre, year));
                    break;
                case "2":
                    System.out.print("Enter title: ");
                    String titleToRemove = scanner.nextLine();
                    library.removeBook(titleToRemove);
                    break;
                case "3":
                    System.out.print("Enter title to search: ");
                    String searchTitle = scanner.nextLine();
                    List<Book> results = library.searchByTitle(searchTitle);
                    results.forEach(System.out::println);
                    break;
                case "4":
                    library.listBooks().forEach(System.out::println);
                    break;
                case "5":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}