Feature: Sanity_Prod_NewUI_PGO_Search

  @PGO-Search-PS
  Scenario: SanityNewUI_ProgramOwner People Search
    Given I initialize Browser
    When I Execute "Validate People Search - TC-ID"

    And I am executing "SanityNewUI_ProgramOwner People Search"
    And I navigate to "Autoqcs" application
#    When Set "PROGRAM_PAYMENT_METHOD" to "Vendor Invoice" for "1364" Customer
#
#    When I log in to "autoqcs" New UI application with "valid" Credentials
#    And I click on "button-newui" "Login" on "Login" Page
#    And I click on "button-newui" "I Certify" on "NOTICE" Page
#    And I click on "MenuButton-NewUI" "People" on "HOME" Page
#    And  I click on "button-newui" " Create Order " on "People" Page
#
##    Creating new order for Vendor
#
#    Then I place a new people order with "Vendor Invoice"
#    And Search table By "FN & LN" in "pow" page
#    And I click on "button-newui" "search" on "People" Page
#    And I should see element "by multi search"
#
#    And Click Logout NewUI

    When I log in to "automation sponsor" New UI application with "valid" Credentials
    And I click on "button-newui" "Login" on "Login" Page
    And I click on "button-newui" "I Certify" on "NOTICE" Page

    And I click on "MenuButton-NewUI" "Providers" on "HOME" Page
    And I should see element "Providers"

#    Search for same Vendor on Provider search
    And Search table By "Provider" in "Program Owner" page
    And I click on "button-newui" "search" on "Program Owner" Page
    Then I should see element "by search"
    And I validate "Active People Number" for "Program Owner" Page
    And I click on "link" "Active People" on "Program Owner" Page
    And I should see element "People"
    And I should see element "Vendor Name" for "filter pill"
    And I should see element "Active" for "filter pill"
#   click on filter icon and validate filters are marked as selected
    And I click on "button-newui" "filter" on "People" Page
    And I should see element "Active" for "checkbox checked" for People
#    validation for ProviderName filter - correct Vendor name is in filter pill
    And I should see element "Provider Name" for "provider name filter" for People

    And I click on "button-newui" "ActiveCheck" on "People" Page
    And I click on "button-newui" "filter complete" on "People" Page
    And I should see element "Vendor Name" for "filter pill"

    And I GET total number of People for "Provider Name" filter for "Program Owner"
    And I Validate "Provider Name" Filter for "Program Owner" Page

    And Validate "Program Owner - People Search" Search Table columns

    And Search table By "FN & LN" in "pow" page
    And I click on "button-newui" "search" on "People" Page
    And I should see element "by multi search"
    Then I should see element "Provider Name" for "searched person"

   And I should see valid tile cards in accordion

   And I close browser

















