@smoketest
Feature: GetAll Product
  List all Product

  @Restfull @smoketest @get
  Scenario: Get all Product
    Given I want to get a list of all Product
    When I got the list of all shoes on homepage
    Then Listed all Shoes
