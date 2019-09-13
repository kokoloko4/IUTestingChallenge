Feature: Users account
  In order to perform actions in Falabella page
  I have to create an user account to login or logout

  Scenario: Invalid registration without fill phone number
    Given I am in Falabella registration page
    When I complete the registration form
    |name           |Andres             |
    |fathersLastName|Cocunubo           |
    |mothersLastName|Quintero           |
    |email          |example@example.com|
    |password       |clave123           |
    |confirmPassword|clave123           |
    |id             |123456789          |
    |gender         |Hombre             |
    |dayBirthday    |2                  |
    |monthBirthday  |05                 |
    |yearBirthday   |1998               |
    And I try to save my data
    Then I should see an error message "Debes ingresar un celular"

  Scenario:Successful sign in
    Given I am in Falabella homepage
    When I enter in login form
    And I complete "email" with "challengecorreo@gmail.com"
    And I complete "password" with "clavechallenge"
    And I click hover login button
    Then I should be see "David" in the homepage

  Scenario: Unsuccessful sign in
    Given I am in Falabella homepage
    When I enter in login form
    And I complete "email" with "challengecorreo@gmail.com"
    And I complete "password" with "claveincorrecta"
    And I click hover login button
    Then I should see a sign in error "E-mail o clave incorrecta. Por favor inténtalo nuevamente."

  Scenario: Successful sign out
    Given I am in Falabella homepage
    When I enter in login form
    And I complete "email" with "challengecorreo@gmail.com"
    And I complete "password" with "clavechallenge"
    And I click hover login button
    And I sign out
    Then I should be signed out


