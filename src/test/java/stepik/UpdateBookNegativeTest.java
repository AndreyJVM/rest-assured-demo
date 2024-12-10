package stepik;

import org.testng.annotations.BeforeClass;
import stepik.properties.Book;
import stepik.properties.BookStoreTestCase;

public class UpdateBookNegativeTest extends BookStoreTestCase {
    private Integer id;

    @BeforeClass
    public void setUp() {
        id = testClient
                .createBook(Book.defaultOf())
                .checkStatusCode(201)
                .getId();
    }
}