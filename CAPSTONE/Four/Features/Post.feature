@smoketest
Feature: Add Shoes To the Cart

  @Restfull @smoketest @post
  Scenario Outline: Add Shoe to cart
    Given I am on HomePage
    When I add a shoe to the list
    Then a shoe will be added to the cart