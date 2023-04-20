Feature: Regression NewUI Administration - User Creation

#*****************************************************************************************************************************************
###################### NewUI Administration User Creation ######################
@NewUI-Administration
@NewUI-Administration-UserCreation
Scenario: NewUI_SC02-Administration-User Creation
    Given I initialize Browser
    And I am executing "NewUI_SC02-Administration-User Creation"
    And I navigate to "Autoqcs" application
   
    When I log in to "autoqcs" New UI application with "valid" Credentials
    And I click on "button-NewUI" "Login" on "Login" Page
    And I click on "button-NewUI" "I Certify" on "notice" Page
    When I click on "MenuButton-NewUI" "Administration" on "HOME" Page
    And I click on "MenuButton-NewUI" "User Management" on "HOME" Page
    
    And I click on "button-NewUI" "New User" on "Administration" Page
    
    And Verify PlaceHolder Value for "First Name *" on "Administration" Page
    And Verify PlaceHolder Value for "Last Name *" on "Administration" Page
    And Verify PlaceHolder Value for "User ID *" on "Administration" Page
    And Verify PlaceHolder Value for "Email *" on "Administration" Page
    And Verify PlaceHolder Value for "Status *" on "Administration" Page
    And Verify PlaceHolder Value for "Role *" on "Administration" Page
    And Verify PlaceHolder Value for "Password *" on "Administration" Page
    And Verify PlaceHolder Value for "Confirm Password *" on "Administration" Page
    And I hover over "role" on "Role Info" and should see "Info regarding role usage"
        
    And I fill details in "New User" page
    And I hover over "role" on "New User" and should see "Full site access with ability to create and modify users. Manage payments if credit card enabled program."
    And I click on "button-NewUI" "SAVE" on "Administration" Page
    Then I should see element "success message"
    And I search for Provider on Admin Page
    And I should see "row" named as "createdUser" on "administration" Page
    
    And I close browser
    
    
###################### NewUI Administration User Creation - Update, View, Summary role #####################
@NewUI-Administration
@NewUI-Administration-UserCreation-Roles
Scenario Outline: <Scenario>
    Given I initialize Browser
    And I am executing "<Scenario>"
    And I navigate to "Autoqcs" application

    When I log in to "autoqcs" New UI application with "valid" Credentials

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
    And I search for Provider on Admin Page
    And I should see "row" named as "createdUser" on "administration" Page
    And Click Logout NewUI
    
    When I log in to "newuirole" New UI application with "valid" Credentials
    And I click on "button-NewUI" "Login" on "Login" Page
    And I click on "button-NewUI" "i certify" on "notice" Page

    Then I should not see "menubutton" named as "Administration" on "newui" Page

    And Click Logout NewUI
    And I close browser

    Examples:
        | Scenario                                        | role    | description                                                                                                                                     |
        | NewUI_SC03-Administration-User Creation-SUMMARY | SUMMARY | Create orders and view people. No access to detailed screening results. Ability to manage people status.                                        |
        | NewUI_SC03-Administration-User Creation-VIEW    | VIEW    | View people status and detailed screening results. Ability to manage people status.                                                             |
        | NewUI_SC03-Administration-User Creation-UPDATE  | UPDATE  | Create orders and view people. Ability to access detailed screening results. Ability to manage people status and update people details section. |
    
    
###################### NewUI Administration User Creation - Password Validation ######################
@NewUI-Administration
@NewUI-Administration-UserCreation-Password
Scenario: NewUI_SC04-Administration-User Creation-PasswordValidation
    Given I initialize Browser
    And I am executing "NewUI_SC04-Administration-User Creation-PasswordValidation"
    And I navigate to "Autoqcs" application
   
    When I log in to "autoqcs" New UI application with "valid" Credentials
    And I click on "button-NewUI" "Login" on "Login" Page
    And I click on "button-NewUI" "I Certify" on "notice" Page
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

    And I click on "button-NewUI" "SAVE" on "Administration" Page
    Then I should see element "success message"

    And Click Logout NewUI
    And I close browser
    
###################### NewUI Administration User Creation - Error Messages ######################
@NewUI-Administration
@NewUI-Administration-UserCreation-Error
Scenario: NewUI_SC05-Administration-User Creation-ErrorMsg
    Given I initialize Browser
    And I am executing "NewUI_SC05-Administration-User Creation-ErrorMsg"
    And I navigate to "Autoqcs" application
   
    When I log in to "autoqcs" New UI application with "valid" Credentials
    And I click on "button-NewUI" "Login" on "Login" Page
    And I click on "button-NewUI" "I Certify" on "notice" Page
    When I click on "MenuButton-NewUI" "Administration" on "HOME" Page
    And I click on "MenuButton-NewUI" "User Management" on "HOME" Page
    
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