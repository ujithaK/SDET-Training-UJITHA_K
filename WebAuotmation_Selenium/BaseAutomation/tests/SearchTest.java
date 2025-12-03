package tests;

import base.Utilities;
import org.testng.annotations.Test;
import pages.SearchPage;
import base.BaseTest;

public class SearchTest extends BaseTest {

    @Test
    public void searchProduct() {
        driver.get("https://www.amazon.in/");
        SearchPage search = new SearchPage(driver);

        search.searchItem("Laptop");
        Utilities.takeScreenshot(driver,"products");
    }
}

