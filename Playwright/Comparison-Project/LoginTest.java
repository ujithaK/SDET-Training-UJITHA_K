import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void loginTest() {

        // 1. Navigate
        driver.get("https://demoqa.com/login");

        // 2.credentials
        driver.findElement(By.id("userName")).sendKeys("ujitha");
        driver.findElement(By.id("password")).sendKeys("uji@123");

        // 3. Click Login
        driver.findElement(By.id("login")).click();

        // 4. Assertion
        String loggedUser =
                driver.findElement(By.id("userName-value")).getText();

        Assert.assertTrue(loggedUser.contains("testuser"));
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
