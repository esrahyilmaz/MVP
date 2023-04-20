Feature: NewUI Program Owner Workflow Administration(User Management Search)

#*********************NewUI Program Owner Workflow Administration(User Management Search)************
 @NewUIProgramWorkFlowRegression @NewUIPGOAdministrationUserSearch @NewUIProgramFirst39194 @NewUIProgramOwnerWorkflow2
  Scenario: NewUI_ProgramOwnerWorkflowAdministrationUserManagementSearch
    Given I initialize Browser
    And I am executing "NewUI_ProgramOwnerWorkflowAdministrationUserManagementSearch"
    And I navigate to "NewUI" application
    When I log in to "automation sponsor" New UI application with "valid" Credentials
    And I click on "button-NewUI" "Login" on "Login" Page
    And I click on "button-NewUI" "i certify" on "notice" Page
    When I click on "MenuButton-NewUI" "Administration" on "HOME" Page
    And I click on "MenuButton-NewUI" "User Management" on "HOME" Page
    
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
    And I should see element "Role"
    And I should see "element" named as "Status" on "Administration" Page
    And I should see element "Status"
        
    And Refresh The Page
	
    And I should see element "search"
    When Search table By "invalid search" in "Administration" page
    And I click on "button-newui" "search" on "Administration" Page
    Then I should see Text "No Results Found"
    
    #***********Update user role login****************
    
    When I click on "pgo-profile-icon"
	And I should see element "User Name" for "profile icon"
	And I should see element "logout"
	When I click on "pgo-logout"
	And I should see element "login page"
	When I log in to "automation sponsor update" New UI application with "valid" Credentials 
	And I click on "button-newui" "Login" on "Login" Page 
	When I should see "button-newui" named as "I Certify" on "FCRA" Page
	And I click on "button-newui" "I Certify" on "NOTICE" Page
	Then I should not see "menubutton" named as "Administration" on "newui" Page
	
	#***********Summary user role login *************************
	
	When I click on "pgo-profile-icon"
	And I should see element "User Name" for "profile icon"
	And I should see element "logout"
	When I click on "pgo-logout"
	And I should see element "login page"
	When I log in to "automation sponsor summary" New UI application with "valid" Credentials 
	And I click on "button-newui" "Login" on "Login" Page 
	When I should see "button-newui" named as "I Certify" on "FCRA" Page
	And I click on "button-newui" "I Certify" on "NOTICE" Page
	Then I should not see "menubutton" named as "Administration" on "newui" Page
	
	#***********View user role login *************************
	
	When I click on "pgo-profile-icon"
	And I should see element "User Name" for "profile icon"
	And I should see element "logout"
	When I click on "pgo-logout"
	And I should see element "login page"
	When I log in to "automation sponsor view" New UI application with "valid" Credentials 
	And I click on "button-newui" "Login" on "Login" Page 
	When I should see "button-newui" named as "I Certify" on "FCRA" Page
	And I click on "button-newui" "I Certify" on "NOTICE" Page
    Then I should not see "menubutton" named as "Administration" on "newui" Page
    
    And I close browser
    