Feature: Automated End2End tests

  Scenario: Customer place an order by purchasing an item from search
    Given User is on Home Page
    When He searches for "dress"
    When Choose to buy the first item
    And Moves to checkout from mini cart
    And Enter personal details on checkout page
    And place the order