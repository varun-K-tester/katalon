Feature: Login to site

  @smoke
  Scenario Outline: Login with valid credentials
    Given User is navigated to login page
    When User is navigated to login page
    When User enters <1username> and <1password>
    And Clicks on login button
    Then User is navigated to homepage

    @valid
    Examples: 
      | 1username     | 1password                |
      | standard_user | qcu24s4901FyWDTwXGr6XA== |

    @invalid
    Examples: 
      | username | password |
      | def      | xyz      |
