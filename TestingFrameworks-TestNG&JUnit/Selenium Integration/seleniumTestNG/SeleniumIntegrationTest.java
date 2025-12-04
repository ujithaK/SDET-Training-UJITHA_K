package seleniumTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class SeleniumIntegrationTest {

    WebDriver driver;

    //  SETUP

    @BeforeMethod
    public void setup() {
        System.out.println("Opening Browser...");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
    }

    // TESTS

    @Test(priority = 1)
    public void verifyGoogleTitle() {
        System.out.println("Running verifyGoogleTitle");

        String actual = driver.getTitle();
        String expected = "Google";

        Assert.assertEquals(actual, expected, "Title mismatch!");
    }

    @Test(priority = 2)
    public void searchTest() {
        System.out.println("Running searchTest");

        driver.findElement(By.name("q")).sendKeys("laptops new model");
        driver.findElement(By.name("q")).submit();

        Assert.assertTrue(driver.getTitle().contains("laptops"),
                "Search result title does not contain Selenium!");
    }

    // This method will execute after every method

    @AfterMethod
    public void teardown() {
        System.out.println("Closing Browser...\n");
        if (driver != null) {
            driver.quit();
        }
    }
}
