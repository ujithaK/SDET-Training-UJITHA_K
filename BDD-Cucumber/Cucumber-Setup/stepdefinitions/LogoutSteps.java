package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class LogoutSteps {

    @Given("the user is logged into the application")
    public void user_is_logged_in() {
        System.out.println("User is logged in");
    }

    @When("the user clicks on the logout option")
    public void user_clicks_logout() {
        System.out.println("User clicks logout");
    }

    @Then("the user should be logged out successfully")
    public void user_logged_out_successfully() {
        System.out.println("User logged out successfully");
    }

    @Then("the user should be redirected to the login page")
    public void user_redirected_to_login_page() {
        System.out.println("User redirected to login page");
    }
}
