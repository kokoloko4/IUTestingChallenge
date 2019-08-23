Feature: Users account
  In order to perform actions in Falabella page
  I have to create an user account to login or logout

  Background:
    Given I am in Falabella homepage

  @Execute
  Scenario: Invalid registration
    When I enter to register page
    And I complete "name" with "Andres"
    And I complete "fathersLastName" with "Cocunubo"
    And I complete "mothersLastName" with "Quintero"
    And I complete "email" with "example@example.com"
    And I complete "password" with "clave123"
    And I complete "confirmPassword" with "clave123"
    And I complete "id" with "123456789"
    And I complete "gender" with "Hombre"
    And I complete birthday, day with "2", month with "05", year with "1998"
    And I try to save my data
    Then I should see an error message

  Scenario:Successful sign in
    When I enter in login form
    And I complete "email" with "challengecorreo@gmail.com"
    And I complete "password" with "clavechallenge"
    Then I should be signed in

  Scenario: Unsuccessful sign in
    When I sign in with invalid credentials
    Then I should see a sign in error

  Scenario: Successful sign out
    When I sign out
    Then I should be signed out


