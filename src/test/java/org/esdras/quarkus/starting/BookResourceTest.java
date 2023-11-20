package org.esdras.quarkus.starting;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class BookResourceTest {

    @Test
    public void shouldGetAllBooks() {
        given()
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON).
                when()
                .get("/api/books").
                then()
                .statusCode(Response.Status.OK.getStatusCode())
                .body("size()", is(3));
    }



    @Test
    public void shouldCountAllBooks() {
        given()
                .header(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN).
                when()
                .get("/api/books/count").
                then()
                .statusCode(Response.Status.OK.getStatusCode())
                .body(is("3"));
    }


    @Test
    public void shouldGetABook() {
        given()
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
                .pathParam("id", 1).
                when()
                .get("/api/books/{id}").
                then()
                .statusCode(Response.Status.OK.getStatusCode())
                .body("title", is("The Fellowship of the Ring"))
                .body("author", is("J. R. R. Tolkien"))
                .body("yearOfPublication", is(1954))
                .body("genre", is("Fantasy"));
    }


}