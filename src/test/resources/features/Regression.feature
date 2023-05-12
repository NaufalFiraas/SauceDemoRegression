@Regression
Feature: Regression
  As a user, I want to login on website sauce demo. Then I want to buy things from it.

  Scenario: Regression sauce demo
    Given User already on Login Page
    When User input "standard_user" as userName and input "secret_sauce" as password
    Then User already on Products page
    When User select filter "Name (Z to A)" as selectedValue
    And User click Add to cart button on the first and second product
    And User click on cart icon
    Then User already on Your Cart page
    And Verify the first product name is the same as first selected product name
    And Verify the first product price is the same as first selected product price
    And Verify the second product name is the same as second selected product
    And Verify the second product price is the same as second selected product price
    When User click on remove button inside the first product
    Then Verify that only second product left on Your Cart page
    When User click on Checkout button
    Then User already on Checkout: Your Information page
    When User input "Naufal" as firstName and "Firaas" as lastName and "66666" as postalCode
    And User click on Continue button
    Then User already on Checkout: Overview page
    And Verify product name is the same as product left from Cart Page
    And Verify product price is the same as product left from Cart Page
    And Verify item total is the same as product price
    And Verify total price is the same as item total plus "0.64" as tax
    When User click Finish button
    Then User already on Checkout: Complete! page
