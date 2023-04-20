Feature: Sanity_Prod_NewUI_PGO_Search

  @PGO-Search
  Scenario: SanityNewUI_ProgramOwner Provider Search
    Given I initialize Browser
    When I Execute "Validate People Search - TC-ID"

    And I am executing "SanityNewUI_ProgramOwner Provider Search"
    And I navigate to "SanityNewUI" application

    When I log in to "automation sponsor" New UI application with "valid" Credentials
    And I click on "button-newui" "Login" on "Login" Page
    And I click on "button-newui" "I Certify" on "NOTICE" Page

    And I click on "MenuButton-NewUI" "Providers" on "HOME" Page
    And I should see element "Providers"

    When I Execute "Validate Provider Search"
    And Search table By "Provider" in "Program Owner" page
    And I click on "button-newui" "search" on "Program Owner" Page
    Then I should see element "by search"
    Then I should see element "Active" for "searched provider"
    And I should see element "Provider Name" for "filter pill"

    And Validate "Program Owner" Search Table columns
    And I validate "Active People Number" for "Program Owner" Page
#    Validation of Location Accordion - comment part for location validation - NOT ON PROD yet!!!
    And I validate "Accordion" for "Program Owner" Page

#    Ask which user on PROD can use for status updating --> TESTVENDORPROD or SANITYNEWVENDOR
    When I Execute "Validate Provider - changing status of Provider "
    And I set "Provider Status" to "Inactive" for "Program Owner" Page
    And Search table By "Provider" in "Program Owner" page
    And I click on "button-newui" "search" on "Program Owner" Page
    Then I should see element "by search"
    Then I should see element "Inactive" for "searched provider"

    And I set "Provider Status" to "Applicant" for "Program Owner" Page
    And Search table By "Provider" in "Program Owner" page
    And I click on "button-newui" "search" on "Program Owner" Page
    Then I should see element "by search"
    Then I should see element "Applicant" for "searched provider"

    And I set "Provider Status" to "Terminated" for "Program Owner" Page
    And Search table By "Provider" in "Program Owner" page
    And I click on "button-newui" "search" on "Program Owner" Page
    Then I should see element "by search"
    Then I should see element "Terminated" for "searched provider"

    And I set "Provider Status" to "Active" for "Program Owner" Page
    And Search table By "Provider" in "Program Owner" page
    And I click on "button-newui" "search" on "Program Owner" Page
    Then I should see element "by search"
    Then I should see element "Active" for "searched provider"

    And I close browser