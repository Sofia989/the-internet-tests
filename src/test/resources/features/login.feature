Feature: Login
  Scenario:Successful login with valid dates

    Given user opens HomePage
    When user clicks on the Authentication link
    And user enters correct data
    And user clicks the login button
    Then User redirected to the secure area and verifies Success message is displayed

