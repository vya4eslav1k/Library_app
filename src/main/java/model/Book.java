package model;

import enums.Genre;

import java.util.Objects;

public record Book(
        String title,
        String author,
        Genre genre,
        int year
) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year &&
                title.equalsIgnoreCase(book.title) &&
                author.equalsIgnoreCase(book.author) &&
                genre.equals(book.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, genre, year);
    }
}