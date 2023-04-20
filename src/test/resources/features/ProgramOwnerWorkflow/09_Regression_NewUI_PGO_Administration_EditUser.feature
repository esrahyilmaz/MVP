Feature: NewUI Program Owner Workflow Administration(Edit User)

#*********************NewUI Program Owner Workflow Administration(Edit User)************
 @NewUIProgramWorkFlowRegression @NewUIProgramWorkFLowAdministrationEditUser @NewUIProgramFirst39195 @NewUIProgramOwnerWorkflow
  Scenario Outline: NewUI_ProgramOwnerWorkflowAdministrationEditUser
    Given I initialize Browser
    And I am executing "NewUI_ProgramOwnerWorkflowAdministrationEditUser"
    And I navigate to "NewUI" application
#	And I navigate to "UAT" application
    When I log in to "automation sponsor" New UI application with "valid" Credentials
#    When I log in to "newuiuat" New UI application with "valid" Credentials
    And I click on "button-NewUI" "Login" on "Login" Page
    And I click on "button-NewUI" "i certify" on "notice" Page
    When I click on "MenuButton-NewUI" "Administration" on "HOME" Page
    And I click on "MenuButton-NewUI" "User Management" on "HOME" Page
    
     And I click on "button-NewUI" "New User" on "Administration" Page

    And I fill details in "New User" page
    And I click on "button-NewUI" "SAVE" on "Administration" Page
    Then I should see element "success message"
    #And I should see "row" named as "createdUser" on "administration" Page
    
    When Search table By "FN & LN & Email" in "Administration" page
    And I click on "button-newui" "search" on "Administration" Page
    When I get details of "User" from UI
    
    When I should see element "disabled" for "Action button"
    When I click on "checkbox" "in table" on "Administration" Page
    When I should see "button-newui" named as "Action" on "Administration" Page
    
    And I click on "button-NewUI" "Edit User" on "Administration" Page
    Then I should see Text "Edit User"
    When I should see Text "Personal Information"
    Then I check User Details with all entries are pre-filled in "Edit User" Page
    Then I compare value in "Edit User" with picked up value from table
    When I should see element "disabled" for "UserID field"
    
    And I fill details in "Edit User" page
    And I enter "<role>" value for "role" textbox on "Administration" Page NewUI
    And I hover over "role" on "Edit User" and should see "<description>"
    And I click on "button-NewUI" "update user" on "Administration" Page
    Then I should see element "success message"
   And I search for Provider on Admin Page
    Then I should see "row" named as "editUser" on "administration" Page
    
    And I close browser
    
    Examples:
      | role 	  | description   																			                |
      | SUMMARY   | View people. No access to detailed screening results. Ability to manage provider and people status. 	|
 	  | VIEW      | View people status and detailed screening results. Ability to manage provider and people status. 				        |
      | UPDATE    | View people. Ability to access detailed screening results. Ability to manage provider and people status and update people details section. |
      | ADMIN     | Full site access with ability to create and modify users. 	|   
    
    ###################### NewUI Program Owner Workflow Administration(Edit User) - Error messages ######################
@NewUIPGOAdministration
@NewUIPGOAdministration-EditUser 
@NewUIPGOAdministrationEditUserError @NewUIProgramOwnerWorkflow
Scenario: NewUI_ProgramOwnerWorkflowAdministrationEditUserErrorMessage
    Given I initialize Browser
    And I am executing "NewUI_ProgramOwnerWorkflowAdministrationEditUserErrorMessage"
   And I navigate to "NewUI" application
#	And I navigate to "UAT" application
    When I log in to "automation sponsor" New UI application with "valid" Credentials
#    When I log in to "newuiuat" New UI application with "valid" Credentials
    And I click on "button-NewUI" "Login" on "Login" Page
    And I click on "button-NewUI" "i certify" on "notice" Page
    When I click on "MenuButton-NewUI" "Administration" on "HOME" Page
    And I click on "MenuButton-NewUI" "User Management" on "HOME" Page

    When I click on "checkbox" "in table" on "Administration" Page
    And I click on "button-NewUI" "Edit User" on "Administration" Page
    
    Then I clear all fields in "Edit User" Page
    And I should see "errormsg-newui" named as "First Name is required" on "Administration" Page
    And I should see "errormsg-newui" named as "Last Name is required" on "Administration" Page
    And I should see "errormsg-newui" named as "A valid email is required" on "Administration" Page
    And I click on "button-NewUI" "update" on "Administration" Page
    Then I should see element "error message"
    And Wait until Element Present "No modal"
    And I click on "button-newui" "Cancel" on "Administration" Page

    And I close browser