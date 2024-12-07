package stepik;

import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateBookTest {

    @Test
    public void createBookTest() {

        Book book = new Book("The Adventures of Tom Sawyer",
                "The story about Tom Sawyer.",
                "Mark Twain", 350, 10, Category.Adventures);

        given().baseUri(TestConfig.BaseURI.value).
                basePath(TestConfig.BasePath.value).
                contentType(ContentType.JSON).
                body(book).
                log().all().
        when().post("books").
        then().assertThat().
                statusCode(201).
                body("id", Matchers.notNullValue()).
                body("title", Matchers.equalTo("The Adventures of Tom Sawyer")).
                body("description", Matchers.equalTo("The story about Tom Sawyer.")).
                body("author", Matchers.equalTo("Mark Twain")).
                body("price", Matchers.equalTo(350)).
                body("count", Matchers.equalTo(10)).
                log().all();
    }
}