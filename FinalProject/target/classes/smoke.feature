Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

  Scenario Outline: Check change amount of phones in cart
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks on the phone
    And User change the quantity
    And User click add to cart button
    And User goes to cart
    Then User check amount of products in cart '<quantity>'


    Examples:
      | homePage  | keyword | quantity  |
      | https://www.amazon.com | iPhone | 2 |

  Scenario Outline: Check url contains keyword
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    Then User checks that url contains keyword '<keyword>'

    Examples:
      | homePage               | keyword |
      | https://www.amazon.com | laptop  |

    Scenario Outline: Check sort product button
      Given User opens '<homePage>' page
      And User checks search field visibility
      When User makes search by keyword '<keyword>'
      And User clicks search button
      And User check feature visibility
      And User click 'Featured' button
      And User click sortByPrice button
      And User check is sort was enabled
      Then User checks if goods was sorted correctly

      Examples:
      | homePage | keyword |
      | https://www.amazon.com | laptop |

      Scenario Outline:
        Given User opens '<homePage>' page
        And User click signIn button
        And User enters email '<email>'
        And User enters password '<password>'
        Then User checks if he is loggined

        Examples:
        | homePage | email | password |
        | https://www.amazon.com | лпанглналгaанлkналнлil.налн | 56рере |

        Scenario Outline: Check add to cart
          Given User opens '<homePage>' page
          And User checks search field visibility
          When User makes search by keyword '<keyword>'
          And User clicks search button
          And User clicks on the phone
          And User click add to cart button
          And User goes to cart
          Then User check amount of products in cart '<quantity>'

          Examples:
          | homePage  | keyword |  quantity   |
          | https://www.amazon.com | iPhone | 1 |

  Scenario Outline: Check non-correct password while log in
    Given User opens '<homePage>' page
    And User click signIn button
    And User enters email '<email>'
    And User enters password '<password>'
    And User gets error message
    Then User check that he have got errorMessage

    Examples:
      | homePage | email | password |
      | https://www.amazon.com |анлнлнланланл | nonCorrect |
