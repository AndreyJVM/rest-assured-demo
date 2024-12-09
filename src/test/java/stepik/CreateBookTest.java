package stepik;

import org.testng.annotations.Test;
import stepik.data.provider.MyDataProvider;
import stepik.properties.Book;
import stepik.properties.BookValidateResponse;
import stepik.rest.TestClient;

public class CreateBookTest {

    @Test(dataProvider = "dataProviderCreateBook", dataProviderClass = MyDataProvider.class)
    public void createBookTest(Book book) {

        TestClient testClient = new TestClient();

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