Feature: Search products in falabella page
  As an user I want to find products

  Scenario: Filter the price
    Given I am in the Falabella homepage
    And I search for "cremas"
    When I aply the filter for price between 5000 and 20000
    Then I should see just products with prices in this range