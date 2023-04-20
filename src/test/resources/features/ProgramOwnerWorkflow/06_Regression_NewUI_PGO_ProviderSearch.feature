Feature: Program Owner Workflow - Provider Search
#*****************************************************************************************************************************************
######################NewUI Program Owner Workflow -Validate User is given the default query of Active Individuals within the Program######################
  @ProgramOwnerWorkflow @NewUI-ProgramOwnerWorkflow-US36717 @TC43559 @TC43560 @TC43561 @TC43564 @NewUIProgramOwnerWorkflow
  @ProviderPage
  Scenario: NewUI_ProgramOwnerWorkflowProviderSearch-Provider
    Given I initialize Browser
    And I am executing "NewUI_ProgramOwnerWorkflowProviderSearch-Provider"
    And I navigate to "NewUI" application
    And I should see element "login page"
    When I log in to "automation sponsor" New UI application with "valid" Credentials
    And I click on "button-newui" "Login" on "Login" Page
    And I click on "button-newui" "I Certify" on "NOTICE" Page
    And I click on "MenuButton-NewUI" "Providers" on "HOME" Page
    And I should see element "Providers"
    And I should see element "Provider pagination"
    And I choose a random Providers page user to search and verify the query result is valid
    And I verify user not in Providers list returns No Results Found
    And I close browser