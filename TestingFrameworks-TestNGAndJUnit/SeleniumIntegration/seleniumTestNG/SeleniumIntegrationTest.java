package seleniumTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumIntegrationTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Automatically download and setup ChromeDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void testGoogleTitle() {
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        System.out.println("Page Title: " + title);

        // Use TestNG assertion
        Assert.assertEquals(title, "Google", "Page title should be Google");
    }

    @Test
    public void testGoogleURL() {
        driver.get("https://www.google.com");
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("google"), "URL should contain google");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
