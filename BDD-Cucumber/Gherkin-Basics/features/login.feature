Feature: User Login

  Scenario: Successful login with valid credentials
    Given the user is on the login page
    When the user enters valid login credentials
    Then the user should be redirected to the HomePage

  Scenario: Login with invalid password
    Given the user is on the login page
    When the user enters a valid username
    But enters an invalid password
    Then an error message should be displayed


