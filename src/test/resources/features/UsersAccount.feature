Feature: Users account
  In order to perform actions in Falabella page
  I have to create an user account to login or logout

  Background:
    Given I am in Falabella homepage

  Scenario: Invalid registration
    When I enter to register page
    And I complete "name" with "Andres" in "register"
    And I complete "fathersLastName" with "Cocunubo" in "register"
    And I complete "mothersLastName" with "Quintero" in "register"
    And I complete "email" with "example@example.com" in "register"
    And I complete "password" with "clave123" in "register"
    And I complete "confirmPassword" with "clave123" in "register"
    And I complete "id" with "123456789" in "register"
    And I complete "gender" with "Hombre" in "register"
    And I complete birthday, day with "2", month with "05", year with "1998"
    And I try to save my data
    Then I should see an error message

  Scenario:Successful sign in
    When I enter in login form
    And I complete "email" with "challengecorreo@gmail.com" in "login"
    And I complete "password" with "clavechallenge" in "login"
    And I click hover login button
    Then I should be see "David" in the homepage

  Scenario: Unsuccessful sign in
    When I enter in login form
    And I complete "email" with "challengecorreo@gmail.com" in "login"
    And I complete "password" with "claveincorrecta" in "login"
    And I click hover login button
    Then I should see a sign in error

  Scenario: Successful sign out
    When I enter in login form
    And I complete "email" with "challengecorreo@gmail.com" in "login"
    And I complete "password" with "clavechallenge" in "login"
    And I click hover login button
    And I sign out
    Then I should be signed out


