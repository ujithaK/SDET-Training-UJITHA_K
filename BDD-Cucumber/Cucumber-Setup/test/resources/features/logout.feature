Feature: User Logout

  Scenario: Successful logout from the application
    Given the user is logged into the application
    When the user clicks on the logout option
    Then the user should be logged out successfully
    And the user should be redirected to the login page
