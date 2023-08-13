Feature: Adding product to cart

  Scenario Outline: Adding product to cart
    Given User is on PDP
    And User enters quantity:<quantity>
    Then User clicks on add to cart button

    Examples: 
      | quantity |
      |        5 |
