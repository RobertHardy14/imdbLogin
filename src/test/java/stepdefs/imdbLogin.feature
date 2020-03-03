Feature: imdbLogin

  Scenario: Correct imdb login
    When I open the IMDB webpage
    Then I click on the Login button
    And I enter my credentials
    Then I search for a movie
    And I log out
