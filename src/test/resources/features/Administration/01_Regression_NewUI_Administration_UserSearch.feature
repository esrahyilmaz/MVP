Feature: Regression NewUI Administration User Search

#*****************************************************************************************************************************************
###################### NewUI Administration User Search#####################
@NewUI-Administration     
@NewUI-Administration-UserSearch
  Scenario: NewUI_SC01-Administration-User Search
    Given I initialize Browser
    And I am executing "NewUI_SC01-Administration-User Search"
    And I navigate to "Autoqcs" application
   
    When I log in to "autoqcs" New UI application with "valid" Credentials
    And I click on "button-NewUI" "Login" on "Login" Page
    And I click on "button-NewUI" "I Certify" on "notice" Page

    And I should see "menubutton-newui" named as "Administration" on "HOME" Page
	Then I click on "MenuButton-NewUI" "Administration" on "HOME" Page
	When I should see "menubutton-newui" named as "User Management" on "HOME" Page
    Then I click on "MenuButton-NewUI" "User Management" on "HOME" Page

    Then I should see the sponsor logo in the header "VendorLogo"
    And I should see Customer support "number" in the header
    And I should see Customer support "email" in the header
    Then I should click "SupportLink" in the footer
    And I should click "FactActLink" in the footer
    And I should click "LegalLink" in the footer
    And I should click "PrivacyPolice" in the footer
    And I should see "FadvTrademark" in the footer of the page
    
    And I should see element "pagination"
    When I click on "pagination" "next" on "Administration" Page
    And I should see element "class disabled" for "next button"
    When I click on "pagination" "previous" on "Administration" Page
    And I should see element "class disabled" for "previous button"

	When I get details of "User" from UI
	
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
    And I should see "element" named as "Role" on "Administration" Page
    And I should see "element" named as "Status" on "Administration" Page
        
    And Refresh The Page
	
    And I should see element "search"
    When Search table By "invalid search" in "Administration" page
    And I click on "button-newui" "search" on "Administration" Page
    Then I should see Text "No Results Found"
    
    And I close browser