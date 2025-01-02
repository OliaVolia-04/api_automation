Feature: teat log in functionality

  Scenario: check log in is successful with valid credentials
    Given user is on sauce demo login page
    When user provides a valid username
    And user provides valid password
    And user clicks on login button
    Then verify user successfully logged in