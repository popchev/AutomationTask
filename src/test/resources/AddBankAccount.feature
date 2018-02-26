@smokeTest
Feature: Adding bank account
  As a Xero user
  In order to manage my business successfully
  I want to be able to add an “ANZ (NZ)” bank account inside any Xero Organisation

  Background:
    Given user is already on Login Page
    And user enters "andonpopchev@yahoo.com" and "Password123"
    And user clicks on login button

  Scenario Outline: Add new bank account
    Given  user choose to add new bank account
    When user select the correct bank
    And  user enters bank account details "<accountname>" "<accountnumber>"
    Then the new bank account is created

    Examples:
      | accountname  | accountnumber |
      | Test Account | 1234          |

