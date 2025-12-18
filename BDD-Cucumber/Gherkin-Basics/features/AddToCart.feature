Feature: Add product to cart

  Background:
    Given the user is logged into the application
    And the user is on the product listing page

  Scenario: Add a single product to the cart
    When the user clicks on "Add to Cart" for a product
    Then the product should be added to the cart
    And the cart item count should increase by 1

  Scenario: Add multiple quantities of the same product
    Given the user selects quantity as 2 for a product
    When the user clicks on "Add to Cart"
    Then the cart should display the product with quantity 2