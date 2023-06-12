@logoutsuite
Feature: Logout test suit

  Background: Navigate to the home page
    Given I am on the home page in logout
    And I click on my account in logout
    And I click on login in logout
    And I will be taken to the login screen in logout
    And I enter the E-mail "gabiqa1@email.com" in logout
    And I enter the password "password" in logout
    And I click on login button in logout

  @logout
  Scenario: Successful logout
    When I will be on the screen confirming successful login in logout
    And I click on my account in logout
    And I click on logout
    Then I will be on the screen confirming successful logout
