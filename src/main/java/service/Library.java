package service;

import enums.Genre;
import model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Library {
    private final List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        if (books.contains(book)) throw new IllegalArgumentException("Book already exists");
        books.add(book);
    }

    public void removeBook(String title) {
        final String lowerCaseTitle = title.toLowerCase();
        books.removeIf(book -> book.title().toLowerCase().equals(lowerCaseTitle));
    }

    public List<Book> searchByTitle(String title) {
        final String lowerCaseTitle = title.toLowerCase();
        return books.stream().filter(book -> book.title().toLowerCase().contains(lowerCaseTitle)).collect(Collectors.toList());
    }

    public List<Book> search(String title, String author, Genre genre, Integer year) {
        Stream<Book> bookStream = books.stream();
        if (title != null && !title.isEmpty()) {
            final String lowerCaseTitle = title.toLowerCase();
            bookStream = bookStream.filter(book -> book.title().toLowerCase().contains(lowerCaseTitle));
        }
        if (author != null && !author.isEmpty()) {
            final String lowerCaseAuthor = author.toLowerCase();
            bookStream = bookStream.filter(book -> book.author().toLowerCase().contains(lowerCaseAuthor));
        }
        if (genre != null) {
            bookStream = bookStream.filter(book -> book.genre() == genre);
        }
        if (year != null) {
            bookStream = bookStream.filter(book -> book.year() == year);
        }
        return bookStream.collect(Collectors.toList());
    }

    public List<Book> listBooks() {
        return new ArrayList<>(books);
    }

}