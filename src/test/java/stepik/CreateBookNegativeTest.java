package stepik;

import org.testng.annotations.Test;
import stepik.properties.Book;
import stepik.properties.BookStoreTestCase;

public class CreateBookNegativeTest extends BookStoreTestCase {

    @Test(dataProvider = "createBooksNegative")
    public void testCreateBookNegative(Book book) {
        testClient.createBook(book)
                .checkStatusCode(400);
    }
}
