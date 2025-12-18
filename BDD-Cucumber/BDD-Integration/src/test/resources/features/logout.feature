Feature: Logout functionality

  Background:
    Given the user is logged into the application

  Scenario: Successful logout
    When the user clicks on logout
    Then the user should be redirected to the login page
