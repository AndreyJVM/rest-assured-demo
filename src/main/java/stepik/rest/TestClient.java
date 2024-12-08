package stepik.rest;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import lombok.AllArgsConstructor;
import stepik.properties.Book;
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

    public ValidatableResponse createBook(Book book) {
        return getRequestSpecification(book)
                .when()
                .post("/books")
                .then()
                .log().all();
    }
}