@loginsuite @smoke
Feature: login test suit

  Background: Navigate to the home page
    Given I am on the home page
    When I click on my account
    And I click on login

  @loginok
  Scenario Outline: Successful login
    Given I will be taken to the login screen
    And I enter the E-mail "<email>"
    And I enter the password "<password>"
    And I click on login button
    # TODO: MEJORAR ESTA COMPROBACION
    Then I will be on the screen confirming successful login

    Examples:
      | email             | password |
      | gabiqa1@email.com | password |

  @loginko
  Scenario Outline: Incorrect login
    Given I will be taken to the login screen
    And I enter the E-mail "<email>"
    And I enter the password "<password>"
    And I click on login button
    Then an error message will appear saying "<errorMessages>"

    Examples:
      | email             | password    | errorMessages                                         |
      | bad@email.com     | password    | Warning: No match for E-Mail Address and/or Password. |
      | gabiqa1@email.com | badpassword | Warning: No match for E-Mail Address and/or Password. |
      |                   |             | Warning: No match for E-Mail Address and/or Password. |