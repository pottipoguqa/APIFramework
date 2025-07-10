Feature: Validate create contacts

  Background: User generate token for Authorization
    Given I am an authorized user
  Scenario: Authorized user add contact into contactList
    Given A list of contacts are available
    When I add contact into contactList
    Then Verify the contact is added