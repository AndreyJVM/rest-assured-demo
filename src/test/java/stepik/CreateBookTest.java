package stepik;


import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import stepik.properties.Book;
import stepik.properties.Category;
import stepik.rest.TestClient;

public class CreateBookTest {

    @Test
    public void createBookTest() {

        TestClient testClient = new TestClient();

        Book book = new Book("The Adventures of Tom Sawyer",
                "The story about Tom Sawyer.",
                "Mark Twain", 350, 10, Category.Adventures);


        testClient.createBook(book)
                .assertThat()
                .statusCode(201)
                .body("id", Matchers.notNullValue())
                .body("title", Matchers.equalTo("The Adventures of Tom Sawyer"))
                .body("description", Matchers.equalTo("The story about Tom Sawyer."))
                .body("author", Matchers.equalTo("Mark Twain"))
                .body("price", Matchers.equalTo(350))
                .body("count", Matchers.equalTo(10))
                .log().all();
    }
}