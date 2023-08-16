Feature: User Account Maintenance Page Navigation

  Scenario: As a User, I should be able to navigate to User Account Maintenance page
    Given I login as Admin user
    And I navigate to "User Account Maintenance" page
    Then I should be able to see User Account Maintenance page details