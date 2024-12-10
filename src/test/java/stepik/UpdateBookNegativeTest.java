package stepik;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import stepik.data.provider.MyDataProvider;
import stepik.properties.Book;
import stepik.properties.BookResponse;
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

    @Test(dataProvider = "createBooksNegative", dataProviderClass = MyDataProvider.class)
    public void updateBookNegative(Book book) {
        testClient.update(id, book)
                .checkStatusCode(400)
                .checkErrorResponse(BookResponse.updateError400(id));

        testClient.read(id)
                .checkStatusCode(200)
                .checkLastUpdated()
                .checkBook(Book.defaultOf());
    }
}