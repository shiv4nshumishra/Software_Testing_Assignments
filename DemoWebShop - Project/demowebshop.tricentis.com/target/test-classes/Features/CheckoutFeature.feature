#Author: iamalexanderwho@gmail.com
Feature: To Test DemoWebshop Checkout Functionality
  Background:
    Given User navigates to the URL demowebshop tricentis
 @CheckoutTest
  Scenario: User completes the successful checkout using COD
    When User performs the login process in demowebshop
    Then Validate the login is successful or not in demowebshop
    
    Given User clicks on book menu in demowebshop
    And User add third book to cart in demowebshop
    When User clicks on the checkbox in demowebshop
    Then User should able to checkout in demowebshop
  
    And billing information
    And enters valid shipping
    And select shipping type
    And selects a payment method
    And completes the purchase cod
   Then the user should see order confirmation 
 