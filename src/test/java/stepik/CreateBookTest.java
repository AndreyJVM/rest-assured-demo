package stepik;

import org.testng.annotations.Test;
import stepik.properties.Book;
import stepik.properties.BookValidateResponse;
import stepik.properties.Category;
import stepik.rest.TestClient;

public class CreateBookTest {

    @Test
    public void createBookTest() {

        TestClient testClient = new TestClient();

        Book book = new Book("The Adventures of Tom Sawyer",
                "The story about Tom Sawyer.",
                "Mark Twain", 350, 10, Category.Adventures);


        BookValidateResponse response = testClient.createBook(book)
                        .checkStatusCode(201)
                        .checkIdNotNull()
                        .checkLastUpdated()
                        .checkBook(book);

        testClient.read(response.getId())
                .checkStatusCode(200)
                .checkId(response.getId())
                .checkLastUpdated()
                .checkBook(book);

    }
}