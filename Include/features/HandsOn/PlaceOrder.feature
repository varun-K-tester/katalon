Feature: Navigating till checkout and placing order

  Scenario Outline: Placing order
    Given User has selected the products
    When User navigates to cart page
    And User clicks on checkout
    Then Users places order<paymentType>
    Then Get order details

    Examples: 
      | paymentType |
      | creditCard  |
