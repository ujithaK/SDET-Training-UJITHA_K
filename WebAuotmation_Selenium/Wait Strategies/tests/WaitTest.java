package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitTest {

    public static void main(String[] args) {

        // ---------- 1. Setup ChromeDriver ----------
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe"); // <-- Replace with your path

        // ChromeOptions to avoid errors with latest ChromeDriver versions
        ChromeOptions options = new ChromeOptions();

        WebDriver driver = new ChromeDriver(options);

        try {
            // ---------- 2. Implicit Wait ----------
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            // ---------- 3. Navigate to SauceDemo ----------
            driver.get("https://www.saucedemo.com/");

            // ---------- 4. Explicit Wait ----------
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

            // Login elements
            WebElement username = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("user-name"))
            );
            username.sendKeys("standard_user");

            WebElement password = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("password"))
            );
            password.sendKeys("secret_sauce");

            WebElement loginButton = wait.until(
                    ExpectedConditions.elementToBeClickable(By.id("login-button"))
            );
            loginButton.click();

            // ---------- 5. Products Page ----------
            WebElement productsTitle = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.className("title"))
            );
            System.out.println("Page Title: " + productsTitle.getText());

            // Custom wait: wait until first product contains "Sauce Labs"
            WebElement firstProduct = wait.until(driverInstance -> {
                WebElement product = driverInstance.findElement(By.className("inventory_item_name"));
                if (product.isDisplayed() && product.getText().contains("Sauce Labs")) {
                    return product;
                }
                return null; 
            });
            System.out.println("First Product: " + firstProduct.getText());

            // Click on first product
            firstProduct.click();

            // Product details page
            WebElement productDetailTitle = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.className("inventory_details_name"))
            );
            System.out.println("Product Detail: " + productDetailTitle.getText());

            // ---------- 6. Add to Cart ----------
            WebElement addToCartButton = wait.until(
                    ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn_inventory"))
            );
            addToCartButton.click();
            System.out.println("Product added to cart!");

            // Go to Cart
            WebElement cartButton = wait.until(
                    ExpectedConditions.elementToBeClickable(By.id("shopping_cart_container"))
            );
            cartButton.click();

            // Cart page title
            WebElement cartTitle = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.className("title"))
            );
            System.out.println("Cart Page Title: " + cartTitle.getText());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // ---------- 7. Cleanup ----------
            driver.quit();
        }
    }
}
