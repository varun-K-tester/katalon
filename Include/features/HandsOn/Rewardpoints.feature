Feature: rewards points in points history and transaction page

  Scenario: To validate rewards points in ordersummary page and FE
    Given User has placed the order
    When User earned rewards points
    Then Navigate to rewards page points history
    And Get reward points
    Then Navigate to transaction page 
    And Get order number and reward points
