@regression
Feature: Login and Dashboard functionality

  Background:
    Given the user launches the application
    And the user is on the login page

  @smoke
  Scenario: Successful login
    When the user logs in with valid credentials
    Then the dashboard should be displayed

  @login
  Scenario Outline: Login with multiple credentials
    When the user logs in with "<username>" and "<password>"
    Then the login status should be "<status>"

    Examples:
      | username | password  | status  |
      | ujitha   | ujitha123 | success |
      | manasa   | wrongpwd  | failure |

  @profile
  Scenario: Update user profile using data table
    Given the user is logged in
    When the user updates profile details:
      | name  | ujitha       |
      | email | uji@test.com |
    Then the profile should be updated successfully
