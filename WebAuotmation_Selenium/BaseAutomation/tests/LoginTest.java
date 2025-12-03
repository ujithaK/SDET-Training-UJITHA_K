package tests;

import base.Utilities;
import org.testng.annotations.Test;
import pages.LoginPage;
import base.BaseTest;

public class LoginTest extends BaseTest {

    @Test
    public void loginNegative() {
        driver.get("https://candymapper.com/m/login");
        LoginPage login = new LoginPage(driver);

        login.login("wrong@example.com", "wrongpass");
        Utilities.takeScreenshot(driver,"negative");
    }

    @Test
    public void loginPositive() {
        driver.get("https://candymapper.com/m/login");
        LoginPage login = new LoginPage(driver);

        login.login("ujitha.k@moolya.com", "Password666");
        Utilities.takeScreenshot(driver,"positive");
    }
}

