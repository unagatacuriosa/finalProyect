@productsuite @smoke
Feature: Register test suit

  Background: Navigate to the home page
    Given The user is on the home page on product page
    When I should be redirected to my account page on register page
    And I go to login
    And I enter the email "gabiqa1@email.com"
    And I enter the password on product page "password"
    And I click on the login button on product page
    And I go to home page

  @addproduct
  Scenario Outline: Add to Cart
    Given I am on the form screen on register page
    When I click on Add to cart for the first product that appears
    And I click to Shopping Cart
    Then I verify that the cart count is "<numItem>"

    Examples:
      | numItem |
      | 1       |