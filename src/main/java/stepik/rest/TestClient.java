package stepik.rest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.AllArgsConstructor;
import stepik.properties.Book;
import stepik.properties.BookValidateResponse;
import stepik.properties.TestConfig;

import static io.restassured.RestAssured.given;

@AllArgsConstructor
public class TestClient {

    private final String baseURI;
    private final String basePath;

    public TestClient() {
        this(TestConfig.BaseURI.value, TestConfig.BasePath.value);
    }

    public RequestSpecification getRequestSpecification() {
        return given().baseUri(baseURI)
                .basePath(basePath)
                .contentType(ContentType.JSON)
                .log().all();
    }

    public RequestSpecification getRequestSpecification(Object book) {
        return getRequestSpecification()
                .body(book);
    }

    public BookValidateResponse createBook(Book book) {
        Response response = getRequestSpecification(book).when()
                .post("/books");

        response.then().log().all();

        return new BookValidateResponse(response);
    }

    public BookValidateResponse read(Integer id) {
        Response response = getRequestSpecification().when()
                .get("/books/{id}", id);

        response.then().log().all();

        return new BookValidateResponse(response);
    }

}