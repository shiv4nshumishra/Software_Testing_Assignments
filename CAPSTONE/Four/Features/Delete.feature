@tag
Feature: Delete Shoe
  delete a Shoe

  @Restfull @delete
  Scenario: Delete Shoe In Cart
    Given a item should exist for delete
    When an item deleted by name "NeoFlex Athletic Shoes"
    Then shoe deleted
