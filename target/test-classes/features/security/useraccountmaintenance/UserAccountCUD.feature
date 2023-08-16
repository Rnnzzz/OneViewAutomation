Feature: User Account Maintenance CUD

  Background: Admin user is on User Account Maintenance page
    Given I login as Admin user
    And I navigate to "User Account Maintenance" page

  Scenario: As an Admin user, I should be able to create new user account
    Given I clean-up user account data in the data-base
    When I create a new user "AT_Create_Scenario_01"
    Then I should be able to see new user in the user table
    And I enable created user
    Then User status should be enabled

  Scenario: As an Admin user I should be able to delete account
    Given I create a new user "AT_Delete_Scenario_01"
    When I delete user "AT_Delete_Scenario_01"
    Then user details should not be visible in the user table
