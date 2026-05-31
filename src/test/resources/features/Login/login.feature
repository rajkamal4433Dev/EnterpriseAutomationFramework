
@Regression
Feature: Login Functionality

  @smoke
  Scenario: Successful login with valid credentials
    Given I am on the login page
    When I enter valid username and password
    And I click the login button
    Then I should be redirected to the dashboard page

  Scenario Outline: Unsuccessful login with invalid credentials
    Given I am on the login page
    When I enter username "<username>" and password "<password>"
    And I click the login button
    Then I should see an error message indicating invalid credentials

  Examples:
    |username  |password |
    |Admin1234 |admin    |
    |$$$$      |******   |