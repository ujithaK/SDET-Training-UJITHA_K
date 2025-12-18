Feature: User Login

  Scenario: Successful login with valid credentials
    Given the user is on the login page
    When the user enters valid login credentials
    Then the user should be redirected to the HomePage




