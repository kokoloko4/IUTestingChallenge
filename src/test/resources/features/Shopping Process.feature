Feature: Shopping process
  As an user I want to buy products

  Background:
    Given I am in a product page

  Scenario: Add a product to the shopping bag
    When I add the product to the bag
    Then I should see a pop up with the confirmation

  Scenario: Delete a product from the shopping bag
    When I have a product in my shopping bag
    And I delete the product
    Then I should see a message saying that my bag is empty