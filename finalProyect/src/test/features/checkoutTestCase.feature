@checkoutsuite @smoke
Feature: Checkout test suit

  Background: Navigate to the home page
    Given The user is on the home page on checkout page
    When I should be redirected to my account page on checkout page
    And I go to login checkout page
    And I enter the email "gabiqa1@email.com" checkout page
    And I enter the password on product page "password" checkout page
    And I click on the login button on product page checkout page

  @checkoutko
  Scenario: Login user checkout
    And I am back on the home page
    And add to cart product
    When I click on Checkout
    And I am taken to the Checkout page
    When I fill in the information in the form for Step2
    And I click on Continue Step2
    When I fill in the information in the form for Step3
    And I accept the terms
    And I click on Continue Step3
#    When I fill in the information in the form for Step4
    And I click on Confirm Order
#    Then I verify that the amount is correct
#    And I click on Continue
    Then I verify that I am on the successful purchase page