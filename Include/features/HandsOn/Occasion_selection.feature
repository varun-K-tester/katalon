Feature: Selecting occasion

  Scenario Outline: Selecting occasion
  	Given User is on homepage
  	And User has logged into site
    Then User selects <date> <occasion>

    Examples: 
      | date        | occasion |
      | later_today | delivery |
