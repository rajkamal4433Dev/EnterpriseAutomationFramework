package com.framework.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;

/**
 * Step definitions for Login.feature (basic simulation).
 */
public class LoginSteps {

    private String username;
    private String password;
    private boolean loginSuccess;

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        // In a real test this would navigate to the login URL.
        System.out.println("[STEP] On the login page");
    }

    @When("I enter valid username and password")
    public void i_enter_valid_username_and_password() {
        // Set known-good credentials for the happy path
        this.username = "Admin";
        this.password = "admin1234";
        System.out.println("[STEP] Entered valid credentials: " + username + "/" + password);
    }

    @When("I enter invalid username and password")
    public void i_enter_invalid_username_and_password() {
        // Use deterministic invalid credentials for negative scenarios
        this.username = "invalidUser";
        this.password = "invalidPass";
        System.out.println("[STEP] Entered invalid credentials: " + username + "/" + password);
    }

    @When("I enter username {string} and password {string}")
    public void i_enter_username_and_password(String username, String password) {
        // Parameterized step used by Scenario Outline examples
        this.username = username;
        this.password = password;
        System.out.println("[STEP] Entered credentials from examples: " + username + "/" + password);
    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        // Simple in-memory check to simulate authentication
        this.loginSuccess = "Admin".equals(this.username) && "admin1234".equals(this.password);
        System.out.println("[STEP] Clicked login button -> success=" + loginSuccess);
    }

    @Then("I should be redirected to the dashboard page")
    public void i_should_be_redirected_to_the_dashboard_page() {
        Assert.assertTrue(loginSuccess, "Expected successful login and redirect to dashboard");
        System.out.println("[STEP] Verified redirect to dashboard");
    }

    @Then("I should see an error message indicating invalid credentials")
    public void i_should_see_an_error_message_indicating_invalid_credentials() {
        Assert.assertFalse(loginSuccess, "Expected login to fail for invalid credentials");
        System.out.println("[STEP] Verified invalid credentials error shown");
    }
}