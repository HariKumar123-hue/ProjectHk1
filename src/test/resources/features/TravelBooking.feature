@Test
Feature: Travel booking flow

  Scenario: Search and book the cheapest flight
    Given user opens travel booking application
    When user searches flights from "Boston" to "London"
    And user selects the cheapest flight
    And user completes purchase with:
      | name        | John Tester        |
      | address     | 10 Main Street     |
      | city        | Dallas             |
      | state       | Texas              |
      | zipCode     | 75001              |
      | cardType    | Visa               |
      | cardNumber  | 4111111111111111   |
      | cardMonth   | 12                 |
      | cardYear    | 2028               |
      | nameOnCard  | John Tester        |
    Then booking should be confirmed
    And confirmation id should be saved to file
