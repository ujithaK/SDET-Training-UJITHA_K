
package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.*;

import java.time.Duration;

public class DynamicElementsRealWebsiteTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testDynamicElements() {

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
        waitForPageLoad();

        //1) Click Start Button (Dynamic Element)
        WebElement startBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@id='start']/button")
        ));

        System.out.println("Clicking Start button...");
        startBtn.click();

        // 2) Wait for AJAX Loading to finish
        waitForAjax();

        // 3) Wait for dynamic text to appear  (using starts-with)
        WebElement helloText = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[starts-with(@id,'finish')]/h4")
        ));

        //using contains()
        WebElement helloText2 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(@id,'finish')]/h4")
        ));


        System.out.println("Dynamic text: " + helloText2.getText());

        //  4) Using cssSelector
        WebElement loader = driver.findElement(By.cssSelector("#loading"));
        System.out.println("Loader displayed initially: " + loader.isDisplayed());
    }


    // Methods for verifying and ajax

    //document.readyState == complete. method
    public void waitForPageLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(
                webDriver -> ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState")
                        .equals("complete")
        );
    }

    //AJAX methods
    public void waitForAjax() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(15)).until(
                    webDriver -> (Boolean) ((JavascriptExecutor) webDriver)
                            .executeScript("return jQuery.active == 0")
            );
        } catch (Exception e) {
            System.out.println("jQuery not present");
        }
    }
}
