package org.esdras.quarkus.starting;


import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.Optional;
//LEMBRAR DESSE IMPORT E DO JBOSS NO TCC SE ESQUECEU
import org.jboss.logging.Logger;

@Path("/api/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

    //PRA USAR O  CDI DO QUARKUS
    @Inject
    BookRepository bookRepository;
    @Inject
    Logger logger;


    @GET
    public List<Book> getBooks() {
        logger.info("getBooks");
        return bookRepository.getBooks();
    }


    @GET
    @Path("{id}")
    public Optional<Book> getBook(@PathParam("id") int id) {
        logger.info("getBook");
        return bookRepository.getBook(id);
    }

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public int countBooks() {
        logger.info("countBooks");
        return bookRepository.countBooks();
    }





}
