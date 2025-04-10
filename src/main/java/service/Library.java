package service;

import model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private final List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
            books.add(book);
    }

    public void removeBook(String title) {
        books.removeIf(book -> book.getTitle().equals(title));
    }

    public List<Book> searchByTitle(String title) {
        return books.stream()
                .filter(book -> book.getTitle().contains(title))
                .collect(Collectors.toList());
    }

    public List<Book> listBooks() {
        return new ArrayList<>(books);
    }
}