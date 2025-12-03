package tests;
//import org.junit.*;
//import org.junit.runners.MethodSorters;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WindowsAndFramesTest {

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }



    @Test
    public void test1_windowHandling() {

        driver.get("https://demoqa.com/browser-windows");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement windowButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("windowButton")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", windowButton);


        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", windowButton);

        String parent = driver.getWindowHandle();

        //It'll  Switch to child window
        for (String win : driver.getWindowHandles()) {
            if (!win.equals(parent)) {
                driver.switchTo().window(win);
            }
        }

        WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sampleHeading")));
        Assert.assertEquals(text.getText(), "This is a sample page");

        driver.close();
        driver.switchTo().window(parent);
    }



    @Test
    public void test_frame_by_index() {
        driver.get("https://demoqa.com/frames");

        // index 3 for our required page
        driver.switchTo().frame(3);

        WebElement heading = driver.findElement(By.id("sampleHeading"));
        Assert.assertTrue(heading.isDisplayed());

        driver.switchTo().defaultContent();
    }





    @Test
    public void test3_iframeByName() {
        driver.get("https://demoqa.com/frames");

        // 'frame1' is the id of the iframe
        driver.switchTo().frame("frame1");

        String text = driver.findElement(By.id("sampleHeading")).getText();
        Assert.assertEquals("This is a sample page", text);

        // Go back to main page
        driver.switchTo().defaultContent();
    }


    @Test
    public void test4_iframeByWebElement() {
        driver.get("https://demoqa.com/frames");

        WebElement frameElement = driver.findElement(By.id("frame2"));
        driver.switchTo().frame(frameElement);

        String text = driver.findElement(By.id("sampleHeading")).getText();
        Assert.assertTrue(text.contains("sample"));

        driver.switchTo().defaultContent();
    }



    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}