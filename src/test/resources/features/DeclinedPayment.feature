Feature: Declined payment
  
  Background:
    * Basic booking on env: sit
    * Booking Constraint: INSURANCE

  Scenario: Declined payment
    Given I am on Payment page for selected trip
    When I pay with invalid card data
    Then Declined pop-up is displayed

