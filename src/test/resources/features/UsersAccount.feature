Feature: Users account
  In order to perform actions in Falabella page
  I have to create an user account to login or logout

  Background:
    Given I am in Falabella homepage

  @Execute
  Scenario: Invalid registration
    When I enter to register page
    And I fill all the fields except for "celular"
    And I try to save my data
    Then I should see an error message

  Scenario:Successful sign in
    When I sign in with valid credentials
    Then I should be signed in

  Scenario: Unsuccessful sign in
    When I sign in with invalid credentials
    Then I should see a sign in error

  Scenario: Successful sign out
    When I sign out
    Then I should be signed out


