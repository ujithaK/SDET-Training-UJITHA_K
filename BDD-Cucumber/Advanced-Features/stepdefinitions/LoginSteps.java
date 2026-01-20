package stepdefinitions;

import io.cucumber.java.en.*;
import io.cucumber.datatable.DataTable;

import java.util.Map;

public class LoginSteps {

    @Given("the user launches the application")
    public void launchApp() {
        System.out.println("Application launched");
    }

    @Given("the user is on the login page")
    public void loginPage() {
        System.out.println("User is on login page");
    }

    @When("the user logs in with valid credentials")
    public void validLogin() {
        System.out.println("User logged in successfully");
    }

    @When("the user logs in with {string} and {string}")
    public void loginWithCredentials(String username, String password) {
        System.out.println("Username: " + username + " | Password: " + password);
    }

    @Then("the login status should be {string}")
    public void loginStatus(String status) {
        System.out.println("Login status: " + status);
    }

    @Then("the dashboard should be displayed")
    public void dashboardDisplayed() {
        System.out.println("Dashboard displayed");
    }

    @Given("the user is logged in")
    public void userLoggedIn() {
        System.out.println("User already logged in");
    }

    @When("the user updates profile details:")
    public void updateProfile(DataTable table) {
        Map<String, String> data = table.asMap(String.class, String.class);
        System.out.println("Name: " + data.get("name"));
        System.out.println("Email: " + data.get("email"));
    }

    @Then("the profile should be updated successfully")
    public void profileUpdated() {
        System.out.println("Profile updated successfully");
    }
}
