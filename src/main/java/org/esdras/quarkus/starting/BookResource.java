package org.esdras.quarkus.starting;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.Optional;

@Path("/api/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {


    @GET
    public List<Book> getBooks() {
        return List.of(
                new Book(1, "The Fellowship of the Ring", "J. R. R. Tolkien", 1954, "Fantasy"),
                new Book(2, "The Two Towers", "J. R. R. Tolkien", 1954, "Fantasy"),
                new Book(3, "The Return of the King", "J. R. R. Tolkien", 1955, "Fantasy")
        );
    }


    @GET
    @Path("{id}")
    public Optional<Book> getBook(@PathParam("id") int id) {
        return this.getBooks().stream().filter(book -> book.id == id).findFirst();
    }

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public int countBooks() {
        return this.getBooks().size();
    }





}
