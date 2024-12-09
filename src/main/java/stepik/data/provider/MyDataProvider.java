package stepik.data.provider;

import org.testng.annotations.DataProvider;

public class MyDataProvider {

    @DataProvider(name = "dataProvider")
    public static Object[][] myDataProvider() {
        return new Object[][]{
                {1, "one"},
                {10, "ten"}
        };
    }
}