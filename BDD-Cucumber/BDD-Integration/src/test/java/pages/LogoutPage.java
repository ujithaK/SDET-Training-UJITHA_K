package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage {

    WebDriver driver;

    By profileMenu = By.id("profileMenu");
    By logoutBtn = By.id("logoutBtn");

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLogout() {
        driver.findElement(profileMenu).click();
        driver.findElement(logoutBtn).click();
    }
}
