Feature: Submitting a guess

  As a Player,

  I want submit a guess

  In order to solve the puzzle

Scenario: Start new game

  When I specify i want to start a new game

  Then A new game should start

Scenario Outline: Start a new round
  Given I am currently playing a game
  And the round was won
  And the last word had "<previous length>" letters
  When I start a new round
  Then the word to guess has "<next length>" letters

  Examples:
    | previous length | next length |
    | 5               | 6           |
    | 6               | 7           |
    | 7               | 5           |

  # Failure path
  Given I am playing a game
  And the round was lost
  Then I cannot start a new round

Scenario Outline: Guessing a word
  Given I am currently playing a game
  And the round has not yet finished
  And I am not out of guesses in this round
  When I submit "<guess>" as a guess
  And the word to is "<word>"
  Then I receive "<feedback>" as feedback

  # Feedback consists of a String with each letter representing the state of the character.
  # C: PRESENT and CORRECT
  # P: PRESENT but not CORRECT
  # A: not PRESENT and not CORRECT -> ABSENT
  Examples:
    | word       | guess      | feedback |
    | banana     | beacon     | CAPAAP   |
    | banana     | baking     | CCAACA   |
    | banana     | banana     | CCCCCC   |