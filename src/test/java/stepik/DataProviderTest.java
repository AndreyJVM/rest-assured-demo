package stepik;

import org.testng.annotations.DataProvider;

public class DataProviderTest {

    @DataProvider(name = "dataProvider")
    public Object[][] dataProviderMethods() {
        return new Object[][]{
                {1, "one"},
                {2, "two"}
        };
    }
}
