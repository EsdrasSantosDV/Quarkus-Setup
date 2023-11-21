package org.esdras.quarkus.starting;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.List;
import java.util.Optional;

//SINGLETON
@ApplicationScoped
public class BookRepository {

    @ConfigProperty(name = "books.genre", defaultValue = "Fantasy")
    String genre;

    public List<Book> getBooks() {
        return List.of(
                new Book(1, "The Fellowship of the Ring", "J. R. R. Tolkien", 1954, genre),
                new Book(2, "The Two Towers", "J. R. R. Tolkien", 1954, genre),
                new Book(3, "The Return of the King", "J. R. R. Tolkien", 1955, genre)
        );
    }

    public Optional<Book> getBook(int id) {
        return this.getBooks().stream().filter(book -> book.id == id).findFirst();
    }

    public int countBooks() {
        return this.getBooks().size();
    }

}
