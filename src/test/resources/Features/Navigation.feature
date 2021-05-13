Feature: Navigate through pages feature

  Scenario: Navigate through all pages feature
    Given user is in login page
    When User clicks profile button to login
    And User enters the username and clicks the Next button
    And User enters the password and clicks the Sign In button
    And User clicks Sign in with your phone or token device
    When user is in Dashboard
    Then click on the Nominate Link
    And click on the Approvals Link
    And click on the My Nomination Link
    And click on the Workshop Eligibility Link
    Then LogOut
