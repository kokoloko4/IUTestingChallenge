Feature: Shopping process
  As an user I want to buy products

  Scenario: Add a product to the shopping cart
    Given I am in a product page
    When I add the product to the cart
    Then I should see a pop up with the confirmation

  Scenario: Add a product to the shopping cart
    Given I have a product in my shopping cart
    When I delete the product
    Then I should see a message saying that my cart is empty