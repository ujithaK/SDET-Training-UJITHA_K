//package base;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.*;
//
//
////this class for chromeDriver setup
//public class BaseTest {
//
//    protected WebDriver driver;
//    protected String url;
//
//    @BeforeMethod
//    public void setUp() {
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
////        driver.get("https://candymapper.com/m/create-account");
//        driver.get(url);
////        driver.get("https://candymapper.com/m/login");
//    }
//
//    @AfterMethod
//    public void tearDown() {
//        driver.quit();
//    }
//}

package base;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class BaseTest {

    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            Utilities.takeScreenshot(driver, result.getName());
        }
        driver.quit();
    }
}


