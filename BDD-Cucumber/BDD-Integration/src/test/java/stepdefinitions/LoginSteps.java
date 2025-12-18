package stepdefinitions;

import io.cucumber.java.en.*;
import pages.LoginPage;

public class LoginSteps {

    LoginPage loginPage;

    @Given("the user is on the login page")
    public void user_on_login_page() {
        Hooks.driver.get("https://practicetestautomation.com/practice-test-login/");
        loginPage = new LoginPage(Hooks.driver);
    }

    @When("the user enters valid credentials")
    public void enter_valid_credentials() {
        loginPage.login("student ", "Password123 ");
    }

    @Then("the dashboard should be displayed")
    public void dashboard_displayed() {
        System.out.println("Dashboard displayed successfully");
    }
}
