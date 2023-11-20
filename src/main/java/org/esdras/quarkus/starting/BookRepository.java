package org.esdras.quarkus.starting;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;

//SINGLETON
@ApplicationScoped
public class BookRepository {

    public List<Book> getBooks() {
        return List.of(
                new Book(1, "The Fellowship of the Ring", "J. R. R. Tolkien", 1954, "Fantasy"),
                new Book(2, "The Two Towers", "J. R. R. Tolkien", 1954, "Fantasy"),
                new Book(3, "The Return of the King", "J. R. R. Tolkien", 1955, "Fantasy")
        );
    }

    public Optional<Book> getBook(int id) {
        return this.getBooks().stream().filter(book -> book.id == id).findFirst();
    }

    public int countBooks() {
        return this.getBooks().size();
    }

}
