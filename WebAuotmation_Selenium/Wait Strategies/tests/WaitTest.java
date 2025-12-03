package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import utils.WaitUtils;

public class WaitTest {

    WebDriver driver;
    WaitUtils wait;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WaitUtils(driver);
    }

    @Test
    public void testWaits() {

        driver.get("https://www.flipkart.com/account/login?ret=/");

        try {

            // Enter something invalid to trigger error
            driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[2]/div/form/div[1]/input")).sendKeys("6309807971");

            // clickable (otp button)
            wait.waitForClickable(By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[2]/div/form/div[3]/button")).click();

            // visible
            WebElement msg = wait.waitForVisible(
                    By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[2]/div/form/div[3]/button")
            );
            System.out.println("The text: " + msg.getText());

            // invisible Elements
            wait.waitForInvisible(
                    By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[2]/div/form/div[1]/input")
            );

            // Custom wait for text(Invisible text)
            wait.waitForText(
                    By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[2]/div/form/div[1]/input"),
                    "Please enter valid Email ID/Mobile number"
            );

            Thread.sleep(3000);

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Waits executed successfully.");
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
