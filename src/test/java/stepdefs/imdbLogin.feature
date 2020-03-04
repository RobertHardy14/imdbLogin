Feature: imdbLogin

  Scenario: Correct imdb login
    When I open the IMDB webpage
    Then I click on the Login button
    And I enter my credentials
    Then I search for "American Sniper" movie from 2014 year
    And I log out
