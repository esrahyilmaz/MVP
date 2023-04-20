Feature: Sanity_Prod_NewUI_PGO_Administration

  @PGO_UserCreation
  Scenario: SanityNewUI_ProgramOwner Administration
    Given I initialize Browser
    When I Execute "Validate Program Owmner Administration - TC-ID 54400"

    And I am executing "SanityNewUI_ProgramOwner Administration"
    And I navigate to "SanityNewUI" application

    And I should see element "login page"
    And I should see "button-newui" named as "Login" on "Login" Page

    When I log in to "automation sponsor" New UI application with "valid" Credentials
    And I click on "button-newui" "Login" on "Login" Page

    When I should see "button-newui" named as "I Certify" on "FCRA" Page
    And I click on "button-newui" "I Certify" on "NOTICE" Page

    And I should see Text "Non-Compliant"
    And I should see Text "Pending"
    And I should see Text "Active Providers"

    Then I click on "MenuButton-NewUI" "Administration" on "HOME" Page
    Then I click on "MenuButton-NewUI" "User Management" on "HOME" Page

    When I should see "button-newui" named as "New User" on "Administration" Page
    And I click on "button-NewUI" "New User" on "Administration" Page
    When I should see "button-newui" named as "Add New User" on "Administration" Page
    When I should see "button-newui" named as "Cancel" on "Administration" Page

    And I validate "required fields" for "Administration" Page
    And I validate "password" for "Administration" Page
    And I fill details in "Administration - New User" page for "Program Owner"

    And I click on "button-NewUI" "SAVE" on "Administration" Page
    Then I should see element "success message"

    When I Execute "Validate User Search using FN, LN, Email"
    And I should see element "search"
    When Search table By "invalid search" in "Administration" page
    And I click on "button-newui" "search" on "Administration" Page
    Then I should see Text "No Results Found"

    When Search table By "FN" in "Administration" page
    And I click on "button-newui" "search" on "Administration" Page
    Then I should see element "by search"
    And Refresh The Page

    When Search table By "LN" in "Administration" page
    And I click on "button-newui" "search" on "Administration" Page
    Then I should see element "by search"
    And Refresh The Page

    When Search table By "email" in "Administration" page
    And I click on "button-newui" "search" on "Administration" Page
    Then I should see element "by search"
    And Refresh The Page

    When Search table By "FN & LN & Email" in "Administration" page
    And I click on "button-newui" "search" on "Administration" Page
    And I should see element "by multi search"

    When I click on "checkbox" "first" on "Administration" Page
    When I should see "button-newui" named as "Edit User" on "Administration" Page
    And I click on "button-NewUI" "Edit User" on "Administration" Page
    Then I should see Text "Edit User"
    Then I should see Text "Personal Information"
    Then I check User Details with all entries are pre-filled in "Edit User" Page
    Then I compare value in "Edit User" with picked up value from table
    When I should not see element "Password"
    When I should not see element "Confirm Password"
    When I should see element "disabled" for "UserID field"
    When I should see "button-newui" named as "Update user" on "Administration" Page
    When I should see "button-newui" named as "Cancel" on "Administration" Page

    And I fill details in "Edit User" page
    And I click on "button-NewUI" "update" on "Administration" Page
    Then I should see element "success message"
    When Search table By "FN & LN & Email" in "Administration" page
    And I click on "button-newui" "search" on "Administration" Page
    And I should see element "by multi search"

    And Click Logout NewUI

    When I Execute "Validate Login with newly created User"
    And I should see element "login page"
    When I log in to "newuirole" New UI application with "valid" Credentials
    And I click on "button-newui" "Login" on "Login" Page
    And I click on "button-newui" "I Certify" on "NOTICE" Page

    And I should see Text "Non-Compliant"
    And I should see Text "Pending"
    And I should see Text "Active Providers"

    And I close browser