package stepik;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import stepik.data.provider.MyDataProvider;
import stepik.properties.Book;
import stepik.properties.BookStoreTestCase;

public class UpdateBookTest extends BookStoreTestCase {

    private Integer id;

    @BeforeClass
    public void setUp() {
        id = testClient
                .createBook(Book.defaultOf())
                .checkStatusCode(201)
                .getId();
    }

    @Test(dataProvider = "dataProviderCreateBook", dataProviderClass = MyDataProvider.class)
    public void testUpdateBook(Book book) {
        testClient.update(id, book)
                .checkStatusCode(200)
                .checkId(id)
                .checkLastUpdated()
                .checkBook(book);

        testClient.read(id)
                .checkStatusCode(200)
                .checkId(id)
                .checkLastUpdated()
                .checkBook(book);
    }
}