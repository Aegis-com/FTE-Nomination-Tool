Feature: Nominate customer

  Scenario: Partner Nominating Customer
    Given user is in login page
    When User clicks profile button to login
    And User enters the username and clicks the Next button
    And User enters the password and clicks the Sign In button
    And User clicks Sign in with your phone or token device
    When user is in Dashboard
    Then user click on the Nominate customer link directs to Nominate page
    And User fills the Partner information details
    And User fills the Customer nomination details
    And User fills the engagement details
    Then Submit the Nomination
    Then LogOut
