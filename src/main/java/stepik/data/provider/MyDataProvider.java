package stepik.data.provider;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;
import stepik.properties.Book;
import stepik.properties.Category;

public class MyDataProvider {

    @DataProvider(name = "dataProvider")
    public static Object[][] dataProviderMethods() {
        return new Object[][]{
                {1, "one"},
                {10, "ten"}
        };
    }

    @DataProvider(name = "dataProviderCreateBook")
    public static Object[][] dataProviderCreateBookMethods() {

        return new Object[][] {
                { Book.defaultOf() },
                // title min = 3
                {Book.defaultOf().setTitle(RandomStringUtils.randomAlphabetic(3))},
                // title max = 256
                {Book.defaultOf().setTitle(RandomStringUtils.randomAlphabetic(256))},
                // description min = 3
                {Book.defaultOf().setDescription(RandomStringUtils.randomAlphabetic(3))},
                // description max = 512
                {Book.defaultOf().setDescription(RandomStringUtils.randomAlphabetic(512))},
                // author min = 3
                {Book.defaultOf().setAuthor(RandomStringUtils.randomAlphabetic(3))},
                // author max = 100
                {Book.defaultOf().setAuthor(RandomStringUtils.randomAlphabetic(100))},
                // price >= 0
                {Book.defaultOf().setPrice(0)},
                // count >= 0
                {Book.defaultOf().setCount(0)},
                // categories from enum : [ Adventures, Detective, Fiction, Horror, Thriller ]
                {Book.defaultOf().setCategory(Category.Detective)},
                {Book.defaultOf().setCategory(Category.Fiction)},
                {Book.defaultOf().setCategory(Category.Horror)},
                {Book.defaultOf().setCategory(Category.Thriller)},
        };
    }
}