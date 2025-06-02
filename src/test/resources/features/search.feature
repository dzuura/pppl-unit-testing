Feature: user search
  pengujian halaman pencarian
  Background:
    Given User is on the search page

  Scenario Outline: search with valid query
    When User search for a "<query>"
    Then User redirected to the result page

    Examples:
      | query |
      | divi  |
      | ubi   |
      | sara  |

  Scenario: search with other valid query
    When User write a query
    And User click search
    Then User redirected to the result page
