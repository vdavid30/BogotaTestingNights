Feature:  Basic flow on Trello
  As a Trello API user and Pokemon Trainer
  I  want to create my Pokemon team on Trello
  So that I can manage all my teams and Pokemon's information

  Scenario: Get Pokemon information from API
    Given The user wants to consult "eevee" information on the Pokemon API
    When The user request the pokemon information to the Pokemon API
    Then The Pokemon API will return the correct information about the Pokemon

  Scenario: Create my personal Board with a list of my favorite Pokemon
    Given The user wants to create his personal Pokemon team on Trello
    When The user creates a board called "Pokemon Information" on Trello
    And The user creates a list named "Pokemon Fight Team" on the created board
    And The user add a Pokemon called "eevee" to the list
    Then The user can see on his list his favorite Pokemon "eevee"



