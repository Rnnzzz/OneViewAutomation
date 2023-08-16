@ON-865
Feature: Valid Credential

  #As user a valid account, I should be able to access dashboard page
  @ON-841 @ON-848 @ON-850 @ValidCredentials
  Scenario Outline: Login with valid credentials
    Given I open OneView page
    When User enters username as "<username>" and password as "<password>"
    Then User should be able to login successfully and new page open

    Examples: sample valid accounts
      | username | password |
      | admin    | P@ssw0rd |
#      | ph_admin | WrongPass |
#      | user     | P@ssw0rd  |