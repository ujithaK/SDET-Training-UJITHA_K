package stepdefinitions;

import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class LoginSteps {

    @Given("the user is on the login page")
    public void user_is_on_login_page() {
        System.out.println("User navigates to login page");
    }

    @When("the user enters valid login credentials")
    public void user_enters_valid_login_credentials() {
        System.out.println("User enters valid credentials");
    }

    @Then("the user should be redirected to the HomePage")
    public void user_redirected_to_dashboard() {
        System.out.println("User is redirected to HomePage");
    }
}
