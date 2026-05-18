@Test
Feature: Add and remove items, then verify order completion message

  Scenario Outline:Add and remove items, then verify order completion message for user
    Given User navigate to SauceDemo Application
    When user logs in with "<username>" and "<password>"
    And user adds 2 products to the cart
    And user proceeds to checkout
    And user enters checkout details "<firstName>", "<lastName>", "<zipCode>"
    And user completes the purchase
    Then order completion message should be "Thank you for your order!"
    And cart should be empty after purchase

    Examples:
      | username                  | password      | firstName | lastName | zipCode |
      | standard_user             | secret_sauce  | John      | Doe      | 12345   |
      | performance_glitch_user   | secret_sauce  | Jane      | Smith    | 67890   |