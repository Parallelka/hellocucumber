Feature: Check web pages

  Scenario: Check that user open promo page
    Given user opens start page
    When user clicks on button Promo
    Then expected web element is present

  Scenario: Check that user gets error creating account existing
    Given user opens start page
    When user clicks on button Create account
    Then expected title and web element are present
    When user fill fields
    And user clicks on button Create
    Then expected error message creating account existing

  Scenario: Check that user gets error creating account with empty fields
    Given user opens start page
    When user clicks on button Create account
    Then expected title and web element are present
    When user clicks on button Create New Customer Account
    Then expected error message creating account with empty fields

  Scenario Outline: Check that user search results
    Given user opens start page
    When user adds some <text>
    And user clicks button Search
    Then expected search result
    Examples:
      | text |
      | top  |

  Scenario: Check that user can adds product in the cart and checks price
    Given user opens start page
    When user goes to Jackets
    Then expected web element Jackets on the page
    When user selects Jackets
    And user adds to the cart
    Then expected message adding product is present
    When user clicks on buttons Cart
    Then expected price matches
