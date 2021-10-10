@testQuoteApi
Feature: Zopa quote check API

  @positive
  Scenario Outline: Verify the quote decisions for a registered Qanat member
    Given I wanted to register as a new Qanat member
    And I am a registered Qanat member
    When I request a quote with currentSalary: <CurrSal>, amountBorr: <AmtBrrw>, termLenght: <TrmLen>
    Then I receive the quoteoffered "<quoteOff>"

    Examples: 
      | CurrSal | AmtBrrw | TrmLen | quoteOff |
      |   30000 |    3000 |     12 | true     |
      |     300 |    3000 |     12 | false    |

  @negitive
  Scenario: Verify the statusCode for wrong zopaQuoteUrl
    Given I wanted to register as a new Qanat member
    And I am a registered Qanat member
    When I request a quote with currentSalary: 30000, amountBorr: 3000, termLenght: 12 from wrong zopaQuoteUrl
    Then I receive the statusCode 404
