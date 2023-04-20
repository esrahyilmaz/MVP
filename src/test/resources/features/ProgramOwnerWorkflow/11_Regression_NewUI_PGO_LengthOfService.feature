Feature: NewUI Program Owner Workflow Length of Service

  @LengthOfService @US59138 @NewUIProgramOwnerWorkflow2
  Scenario: NewUI_ProgramOwnerLengthOfService
    Given I initialize Browser
    And I am executing "NewUI_ProgramOwnerLengthOfService"
    And I navigate to "NewUI" application
    When I log in to "automation sponsor" New UI application with "valid" Credentials
    And I click on "button-NewUI" "Login" on "Login" Page
    And I click on "button-NewUI" "i certify" on "notice" Page
    And I click on "MenuButton-NewUI" "Providers" on "HOME" Page
    And I get a unique provider from Customer "1364"
    And I search for Provider "unique"
    And I change Provider Status to "Active"
    And I search for Provider "unique"
    And I set Provider Length of Service
    And I change Provider Status to "Applicant"
    And I search for Provider "unique"
    And I verify Provider Length of Service "Calculation Active to Applicant"
    And I set Provider Length of Service
    And I change Provider Status to "Inactive"
    And I search for Provider "unique"
    And I verify Provider Length of Service "calculation has stopped"
    And I set Provider Length of Service
    And I change Provider Status to "Terminated"
    And I search for Provider "unique"
    And I verify Provider Length of Service "calculation is the same"
    And I set Provider Length of Service
    And I change Provider Status to "Active"
    And I verify Provider Length of Service "calculation has started from null"
    And I close browser

