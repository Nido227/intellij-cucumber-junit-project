Feature: Web table user order feature

  @webtableAppOrder1
  Scenario: User should be able to place order and order seen in web table
    Given user is already logged in and on order page
    When user selects product type "Familybea"
    And user enters quantity 2
    And user enters customer name "Sherlock Holmes"
    And user enters street "221B Baker Street"
    And user enters city "London"
    And user enters State "England"
    And user enters zipcode "50505"
    And user selects credit card type "visa"
    And user enters credit card number "1111222233334444"
    And user enters expiry date "12/23"
    And user enters process order button
    Then user should see "Sherlock Holmes" in first row of the web table

  @webtableAppOrder
  Scenario Template: User should be able to place order and order seen in web table with using DDT
    Given user is already logged in and on order page
    When user selects product type "<productType>"
    And user enters quantity <quantity>
    And user enters customer name "<customerName>"
    And user enters street "<street>"
    And user enters city "<city>"
    And user enters State "<state>"
    And user enters zipcode "<zipCode>"
    And user selects credit card type "<cardType>"
    And user enters credit card number "<cardNumber>"
    And user enters expiry date "<expiryDate>"
    And user enters process order button
    Then user should see "<expectedName>" in first row of the web table

    @maleScientist
    Examples:
      | productType | quantity | customerName | street            | city   | state   | zipCode | cardType | cardNumber       | expiryDate | expectedName |
      | Familybae   | 2        | Mesut Ozil   | 221B Baker Street | London | England | 50505   | visa     | 1111222233334444 | 12/23      | Mesut Ozil   |
      | MoneyCog    | 4        | C.Ronaldo    | 221B Baker Street | London | England | 50505   | visa     | 1111222233334444 | 12/23      | C. Ronaldo   |
      | Screenable  | 3        | Messi        | 221B Baker Street | London | England | 50505   | visa     | 1111222233334444 | 12/23      | Messi        |
      | MoneyCog    | 1        | Ronaldinho   | 221B Baker Street | London | England | 50505   | visa     | 1111222233334444 | 12/23      | Ronaldinho   |
      | Familybae   | 2        | Nido         | 221B Baker Street | London | England | 50505   | visa     | 1111222233334444 | 12/23      | Nido         |