Feature: Choosing product to order

  Scenario Outline: Navigating till PDP and choosing product
    Given User has selected occasion
    When User navigate to menupage
    And User chooses <category L1> category L1
    And User chooses <category L2> category L2
    Then verify if product is available
    And User chooses <product> product

    Examples: 
      | category L1 | category L2    | product      |
      | Drinks      | Pepsi Products | Mtn Dew 20oz |
  #   | Pizza       | Single Topping | Sausage Pizza |
