#Author: iamalexanderwho@gmail.com
Feature: To Test DemoWebshop Community Poll Functionality
  Background: 
    Given User navigate to Url
@PollTest
  Scenario: User to poll without selecting anything
    Then Click on vote button directly
@PollTest
  Scenario: User to poll without Login
    Then User select one option from given poll
    Then Click on vote button
@PollTest
  Scenario Outline: User to poll with login
    Then User performs Login '<email>' '<password>'
    Then User select one option from poll and vote

  Examples: 
      | email                     | password |
      | iamalexanderwho@gmail.com | 12345678 |
      | fsdgdshfkbetyvcwexqtqdxeqw@gmail.com   | 12345678 |
      