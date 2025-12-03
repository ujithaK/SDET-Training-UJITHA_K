package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.Test;

import java.time.Duration;

public class WaitUtils {

    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor
    public WaitUtils(WebDriver driver) {
        this.driver = driver;

        // Implicit Wait (it'll Set once when object is created)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Explicit Wait object
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    //EXPLICIT WAIT: Clickable
    public WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }


    // EXPLICIT WAIT: Visible
    public WebElement waitForVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    // EXPLICIT WAIT: Invisible
    public boolean waitForInvisible(By locator) {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }


    // CUSTOM WAIT: Text equals
    public void waitForText(By locator, String expectedText) {
        wait.until(d -> {
            WebElement element = d.findElement(locator);
            return element.getText().equals(expectedText);
        });
    }

}
