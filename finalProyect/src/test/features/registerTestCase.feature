@registersuite @smoke
Feature: Register test suit

  Background: Navigate to the home page
    Given the user is on the registration confirmation page
    When I click on the My Account button on the registration page
    And I click on register

  @registerok
  Scenario Outline: Successful registration
    Given I am on the registration form screen
    And I will be enter First Name "<firstName>"
    And I will be enter Last Name "<lastName>"
    And I will be enter E-mail
    And I will be enter Telephone "<telephone>"
    And I will be enter Password "<password>"
    And I will be enter Password Confirm "<passwordConfirm>"
    And I accept the terms and click continue
    Then I will be on the screen confirming successful registration

    Examples:
      | firstName | lastName | telephone | password | passwordConfirm |
      | Gabi      | QA       | 123456    | password | password        |

  @registerko
  Scenario Outline: Failed registration
    Given I will be taken to the form screen
    And I will be enter First Name "<firstName>"
    And I will be enter Last Name "<lastName>"
    And I will be enter E-mail "<email>"
    And I will be enter Telephone "<telephone>"
    And I will be enter Password "<password>"
    And I will be enter Password Confirm "<passwordConfirm>"
    And I accept the terms and click continue
    Then The "<fieldName>" error message "<errorMessages>" should appear on the form field

    Examples:
      | firstName                         | lastName                          | email   | telephone                         | password              | passwordConfirm       | fieldName | errorMessages                                   |
      |                                   | QA                                | a@a.com | 123456                            | password              | password              | firstname | First Name must be between 1 and 32 characters! |
      | chqwhzwbnemuhufbpbbeqxttfleuxcppk | QA                                | a@a.com | 123456                            | password              | password              | firstname | First Name must be between 1 and 32 characters! |
      | Gabi                              |                                   | a@a.com | 123456                            | password              | password              | lastname  | Last Name must be between 1 and 32 characters!  |
      | Gabi                              | chqwhzwbnemuhufbpbbeqxttfleuxcppk | a@a.com | 123456                            | password              | password              | lastname  | Last Name must be between 1 and 32 characters!  |
      | Gabi                              | QA                                |         | 123456                            | password              | password              | email     | E-Mail Address does not appear to be valid!     |
#      | Gabi                              | QA                                | aa.com  | 123456                            | password              | password        | email     | E-Mail Address does not appear to be valid!     |
      | Gabi                              | QA                                | a@a.com | 12                                | password              | password              | telephone | Telephone must be between 3 and 32 characters!  |
      | Gabi                              | QA                                | a@a.com | 794746707034785323393255041553907 | password              | password              | telephone | Telephone must be between 3 and 32 characters!  |
      | Gabi                              | QA                                | a@a.com | 123456                            |                       | password              | password  | Password must be between 4 and 20 characters!   |
      | Gabi                              | QA                                | a@a.com | 123456                            | ACmvvtPi69xh83d6kEHzs | ACmvvtPi69xh83d6kEHzs | password  | Password must be between 4 and 20 characters!   |
      | Gabi                              | QA                                | a@a.com | 123456                            | password              | pass                  | confirm   | Password confirmation does not match password!  |
