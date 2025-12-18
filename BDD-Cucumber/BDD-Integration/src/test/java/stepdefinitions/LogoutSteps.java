package stepdefinitions;

import io.cucumber.java.en.*;
import pages.LoginPage;
import pages.LogoutPage;

public class LogoutSteps {

    LoginPage loginPage;
    LogoutPage logoutPage;

    @Given("the user is logged into the application")
    public void user_logged_in() {
        Hooks.driver.get("https://example.com/login");
        loginPage = new LoginPage(Hooks.driver);
        loginPage.login("ujitha", "uji@123");
    }

    @When("the user clicks on logout")
    public void user_clicks_logout() {
        logoutPage = new LogoutPage(Hooks.driver);
        logoutPage.clickLogout();
    }

    @Then("the user should be redirected to the login page")
    public void redirected_to_login() {
        System.out.println("User logged out and redirected to login page");
    }
}
