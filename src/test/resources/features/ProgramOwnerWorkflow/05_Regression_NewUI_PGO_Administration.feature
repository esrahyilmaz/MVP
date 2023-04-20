Feature: NewUI Program Owner Workflow Administration(User Creation)

#*********************NewUI Program Owner Workflow Administration(User Creation)************
 @NewUIProgramWorkFlowRegression @NewUIProgramWorkFLowAdministrationUserCreation @NewUIProgramFirst34475  @NewUIProgramOwnerWorkflow
  Scenario: NewUI_ProgramOwnerWorkflowAdministrationUserCreation
    Given I initialize Browser
    And I am executing "NewUI_ProgramOwnerWorkflowAdministrationUserCreation"
    And I navigate to "NewUI" application
#	And I navigate to "UAT" application
    When I log in to "automation sponsor" New UI application with "valid" Credentials
#    When I log in to "newuiuat" New UI application with "valid" Credentials
    And I click on "button-NewUI" "Login" on "Login" Page
    And I click on "button-NewUI" "i certify" on "notice" Page
    When I click on "MenuButton-NewUI" "Administration" on "HOME" Page
    And I click on "MenuButton-NewUI" "User Management" on "HOME" Page
    And I click on "button-NewUI" "New User" on "Administration" Page
    And I enter "valid" value for "FN" textbox on "Administration" Page NewUI
    And I enter "valid" value for "LN" textbox on "Administration" Page NewUI
    And I enter "valid" value for "UserID" textbox on "Administration" Page NewUI
    And I enter "valid" value for "email" textbox on "Administration" Page NewUI
    And I enter "valid" value for "role" textbox on "Administration" Page NewUI
    And I enter "valid" value for "status" textbox on "Administration" Page NewUI
    And I enter "A" value for "password" textbox on "Administration" Page NewUI
    
    And I should see element "At least 1 upper case" for "password messages"
    And I should see "password bar" named as "Very Weak" on "Administration" Page
    And I enter "a" value for "password" textbox on "Administration" Page NewUI
    And I should see element "At least 1 lower case" for "password messages"
    And I should see "password bar" named as "Weak" on "Administration" Page
    And I enter "@" value for "password" textbox on "Administration" Page NewUI
    And I should see element "At least 1 special character" for "password messages"
    And I should see "password bar" named as "Moderate" on "Administration" Page
    And I enter "1" value for "password" textbox on "Administration" Page NewUI
    And I should see element "At least 1 numerical character" for "password messages"
    And I should see "password bar" named as "Strong" on "Administration" Page
    And I should see "errormsg-newui" named as "Password must meet all criteria" on "Administration" Page
    And I enter "valid" value for "password" textbox on "Administration" Page NewUI
    And I should see element "At least 8 characters" for "password messages"
    And I should see "password bar" named as "Very Strong" on "Administration" Page
    And I enter "same" value for "confirm password" textbox on "Administration" Page NewUI

    And I hover over "role" on "New User" and should see "Full site access with ability to create and modify users."

    And I click on "button-NewUI" "SAVE" on "Administration" Page
    Then I should see element "success message"
    And Click Logout NewUI
    And I close browser
    

 #*********************NewUI Program Owner Workflow Administration(User Creation) Error Validation************
 @NewUIProgramWorkFlowRegression @NewUIProgramAdministrationUserErrorValidation @NewUIProgramSecond34475 @NewUIProgramOwnerWorkflow
  Scenario: NewUI_ProgramOwnerWorkflowAdministrationUserErrorValidation
    Given I initialize Browser
    And I am executing "NewUI_ProgramOwnerWorkflowAdministrationUserErrorValidation"
    And I navigate to "NewUI" application
#	And I navigate to "UAT" application
    When I log in to "automation sponsor" New UI application with "valid" Credentials
#    When I log in to "newuiuat" New UI application with "valid" Credentials
    And I click on "button-NewUI" "Login" on "Login" Page
    And I click on "button-NewUI" "i certify" on "notice" Page
    When I click on "MenuButton-NewUI" "Administration" on "HOME" Page
    And I click on "MenuButton-NewUI" "User Management" on "HOME" Page
    And I should see element "New User button"
    And I click on "button-NewUI" "New User" on "Administration" Page
    Then I should see Text "New User"
    And I should see "button-newui" named as "Add New User" on "Administration" Page
    And I should see "button-newui" named as "Cancel" on "Administration" Page
    And I click on "button-NewUI" "SAVE" on "Administration" Page
    Then I should see element "error message"

    And I should see "errormsg-newui" named as "First Name is required" on "Administration" Page
    And I should see "errormsg-newui" named as "Last Name is required" on "Administration" Page
    And I should see "errormsg-newui" named as "User ID is required" on "Administration" Page
    And I should see "errormsg-newui" named as "A valid email is required" on "Administration" Page
    And I should see "errormsg-newui" named as "User status is required" on "Administration" Page
    And I should see "errormsg-newui" named as "User role is required" on "Administration" Page
    And I should see "errormsg-newui" named as "Password must meet all criteria" on "Administration" Page
    And I should see "errormsg-newui" named as "Confirm password is required" on "Administration" Page

    And I enter "min" value for "UserID" textbox on "Administration" Page NewUI
    And I should see "errormsg-newui" named as "Min length of (8) not met" on "Administration" Page
    And I enter "existing" value for "UserID" textbox on "Administration" Page NewUI
    And I should see "errormsg-newui" named as "User ID is already used" on "Administration" Page
    And I enter "max" value for "UserID" textbox on "Administration" Page NewUI
    And I should see "errormsg-newui" named as "Max length (30) exceeded" on "Administration" Page
    And I enter "invalid" value for "email" textbox on "Administration" Page NewUI
    And I should see "errormsg-newui" named as "A valid email is required" on "Administration" Page
    And I enter "max" value for "FN" textbox on "Administration" Page NewUI
    And I should see "errormsg-newui" named as "Max length (50) exceeded" on "Administration" Page
    And I enter "max" value for "LN" textbox on "Administration" Page NewUI
    And I should see "errormsg-newui" named as "Max length (50) exceeded" on "Administration" Page
    And I enter "valid" value for "password" textbox on "Administration" Page NewUI
    And I enter "invalid" value for "confirm password" textbox on "Administration" Page NewUI
    And I should see "errormsg-newui" named as "Passwords do not match" on "Administration" Page
    And I should see "errormsg-newui" named as "Min length (8) not met" on "Administration" Page

    And I fill details in "New User" page
    And I click on "button-newui" "Cancel" on "Administration" Page

    And Click Logout NewUI
    And I close browser
    
    
#*********************NewUI Program Owner Workflow Administration(User Creation) Update, View, Summary************    
     @NewUIProgramWorkFlowRegression @NewUIProgramAdministrationUserCreationRoles @NewUIProgramThird34475 @NewUIProgramOwnerWorkflow
  Scenario Outline: NewUI_ProgramOwnerWorkflowAdministrationUserCreationRoles
    Given I initialize Browser
    And I am executing "NewUI_ProgramOwnerWorkflowAdministrationUserCreationRoles"
    And I navigate to "NewUI" application
#	And I navigate to "UAT" application
    When I log in to "automation sponsor" New UI application with "valid" Credentials
#    When I log in to "newuiuat" New UI application with "valid" Credentials
    And I click on "button-NewUI" "Login" on "Login" Page
    And I click on "button-NewUI" "i certify" on "notice" Page

    When I click on "MenuButton-NewUI" "Administration" on "HOME" Page
    And I click on "MenuButton-NewUI" "User Management" on "HOME" Page
    And I click on "button-NewUI" "New User" on "Administration" Page
    And I enter "valid" value for "FN" textbox on "Administration" Page NewUI
    And I enter "valid" value for "LN" textbox on "Administration" Page NewUI
    And I enter "valid" value for "UserID" textbox on "Administration" Page NewUI
    And I enter "valid" value for "email" textbox on "Administration" Page NewUI
    And I enter "<role>" value for "role" textbox on "Administration" Page NewUI
    And I enter "valid" value for "status" textbox on "Administration" Page NewUI
    And I enter "valid" value for "password" textbox on "Administration" Page NewUI
    And I enter "valid" value for "confirm password" textbox on "Administration" Page NewUI
    And I hover over "role" on "New User" and should see "<description>"
    And I click on "button-NewUI" "SAVE" on "Administration" Page
    Then I should see element "success message"
    And I should see "row" named as "createdUser" on "administration" Page
    And Click Logout NewUI
    When I log in to "newuirole" New UI application with "valid" Credentials
    And I click on "button-NewUI" "Login" on "Login" Page
    And I click on "button-NewUI" "i certify" on "notice" Page

    Then I should not see "menubutton" named as "Administration" on "newui" Page

    And Click Logout NewUI
    And I close browser

    Examples:
      | role 	  | description   																																							|
      | SUMMARY   | View people. No access to detailed screening results. Ability to manage provider and people status.	                                          |
      | VIEW      | View people status and detailed screening results. Ability to manage provider and people status.				                              |
      | UPDATE    | View people. Ability to access detailed screening results. Ability to manage provider and people status and update people details section.	  |
    