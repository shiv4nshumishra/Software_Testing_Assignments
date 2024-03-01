#Author: iamalexanderwho@gmail.com
Feature: To Test DemoWebShop Login functionality
@LoginTest
  Scenario Outline: User login with different credentials
    Given user navigates to the login page
    When user enters '<email>' and '<password>'
    And clicks the login button
    Then Message Should Be Displayed '<loginResult>'

  Examples:
    | email                         	 | password       			| loginResult           			|
    | iamalexanderwho@gmail.com        | 12345678 			      | logged_in_successfully			|
    | shahrukhkhan@gmail.com           | shahrukhkhan@12345		| incorrect email or Password |
    | dhanushraja@gmail.com    		 	   | 1234       					| incorrect email or Password |
    |                              		 |               			  | incorrect email or Password |
    