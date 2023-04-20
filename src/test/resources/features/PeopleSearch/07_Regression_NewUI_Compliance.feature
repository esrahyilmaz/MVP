Feature: Regression NewUI Compliance Status Hyperlink
    
#*****************************************************************************************************************************************

######################NewUI Compliance Status Hyperlink###################################################################################     
@NewUI-PeopleSearch
@NewUI 
@NewUICompliance
Scenario: NewUI_SC15-Compliance Hyperlink
	Given I initialize Browser
	And I am executing "NewUI_SC15-Compliance Hyperlink" 
    And I navigate to "NewUI" application
    Then I open only a new tab
    Then I switch between tabs "child"
    And I navigate to "Admin tool" application
    And I log in to admin tool select customer "XTDAUTOQCSA" for "QCSA"
    And I update Property "XTDFORCE_COMPLIANCE_SUPPRESSION" to "N"
    Then I switch between tabs "parent"
    And I should see element "login page" 
    
    When I log in to "autoqcs" New UI application with "valid" Credentials
    And I click on "button-newui" "Login" on "Login" Page
    And I click on "button-newui" "I Certify" on "NOTICE" Page
    And I click on "MenuButton-NewUI" "People" on "HOME" Page
    And I should see element "People"

    And Verify Complianace Hyperlink with input value "UserName" for "Pending-error" status
    And Search table By "FN & LN" in "People" page
    And I click on "button-newui" "search" on "People" Page
    And I click on "order status" "no hyperlink" on "People" Page
    And I should not see element "compliance hyperlink"

    And Verify Complianace Hyperlink with input value "UserName" for "Compliant" status
    And Search table By "FN & LN" in "People" page
    And I click on "button-newui" "search" on "People" Page
    And I click on "order status" "hyperlink" on "People" Page
    And I click on "button-newui" "continue" on "People" Page
    And I should see element "hyperlink"

    And Verify Complianace Hyperlink with input value "UserName" for "Not-Compliant" status
    And Search table By "FN & LN" in "People" page
    And I click on "button-newui" "search" on "People" Page
    And I click on "order status" "hyperlink" on "People" Page
    And I click on "button-newui" "continue" on "People" Page
    And I should see element "hyperlink"

    And Verify Complianace Hyperlink with input value "UserName" for "Pending" status
    And Search table By "FN & LN" in "People" page
    And I click on "button-newui" "search" on "People" Page
    And I click on "order status" "hyperlink" on "People" Page
    And I click on "button-newui" "continue" on "People" Page
    And I should see element "hyperlink"
    Then Click Logout NewUI
    
############################################ View Vendor User #####################################################################################   
  	
  	When I log in to "newuiview" New UI application with "valid" Credentials
    And I click on "button-NewUI" "Login" on "Login" Page
    And I click on "button-NewUI" "i certify" on "notice" Page

    And I click on "MenuButton-NewUI" "People" on "HOME" Page
    And I should see element "People"

    And Verify Complianace Hyperlink with input value "UserName" for "Pending-error" status
    And Search table By "FN & LN" in "People" page
    And I click on "button-newui" "search" on "People" Page
    And I click on "order status" "no hyperlink" on "People" Page
    And I should not see element "compliance hyperlink"

    And Verify Complianace Hyperlink with input value "UserName" for "Compliant" status
    And Search table By "FN & LN" in "People" page
    And I click on "button-newui" "search" on "People" Page
    And I click on "order status" "hyperlink" on "People" Page
    And I click on "button-newui" "continue" on "People" Page
    And I should see element "compliance hyperlink"

    And Verify Complianace Hyperlink with input value "UserName" for "Not-Compliant" status
    And Search table By "FN & LN" in "People" page
    And I click on "button-newui" "search" on "People" Page
    And I click on "order status" "hyperlink" on "People" Page
    And I click on "button-newui" "continue" on "People" Page
    And I should see element "compliance hyperlink"

    And Verify Complianace Hyperlink with input value "UserName" for "Pending" status
    And Search table By "FN & LN" in "People" page
    And I click on "button-newui" "search" on "People" Page
    And I click on "order status" "hyperlink" on "People" Page
    And I click on "button-newui" "continue" on "People" Page
    And I should see element "compliance hyperlink"
    Then Click Logout NewUI
    
    ###################################### Summary Vendor User #####################################################################################
   
    When I log in to "newuisummary" New UI application with "valid" Credentials
    And I click on "button-NewUI" "Login" on "Login" Page
    And I click on "button-NewUI" "i certify" on "notice" Page 
   
    And I click on "MenuButton-NewUI" "People" on "HOME" Page
    And I should see element "People"
   
    And Verify Complianace Hyperlink with input value "UserName" for "Pending-error" status
    And Search table By "FN & LN" in "People" page
    And I click on "button-newui" "search" on "People" Page
    And I click on "order status" "no hyperlink" on "People" Page
    And I should not see element "compliance hyperlink"
    
    And Verify Complianace Hyperlink with input value "UserName" for "Compliant" status
    And Search table By "FN & LN" in "People" page
    And I click on "button-newui" "search" on "People" Page
    And I click on "order status" "no hyperlink" on "People" Page
    And I should not see element "compliance hyperlink"
    
    And Verify Complianace Hyperlink with input value "UserName" for "Not-Compliant" status
    And Search table By "FN & LN" in "People" page
    And I click on "button-newui" "search" on "People" Page
    And I click on "order status" "no hyperlink" on "People" Page
    And I should not see element "compliance hyperlink"
    
    And Verify Complianace Hyperlink with input value "UserName" for "Pending" status
    And Search table By "FN & LN" in "People" page
    And I click on "button-newui" "search" on "People" Page
    #And I click on "order status" "no hyperlink" on "People" Page
    #And I should not see element "compliance hyperlink"
    Then Click Logout NewUI
    
    
    ###################################### Update Vendor User  #####################################################################################
    
    When I log in to "newuiupadte" New UI application with "valid" Credentials
    And I click on "button-NewUI" "Login" on "Login" Page
    And I click on "button-NewUI" "i certify" on "notice" Page 
   
    And I click on "MenuButton-NewUI" "People" on "HOME" Page
    And I should see element "People"
   
    And Verify Complianace Hyperlink with input value "UserName" for "Pending-error" status
    And Search table By "FN & LN" in "People" page
    And I click on "button-newui" "search" on "People" Page
    And I click on "order status" "no hyperlink" on "People" Page
    And I should not see element "compliance hyperlink"
    
    And Verify Complianace Hyperlink with input value "UserName" for "Compliant" status
    And Search table By "FN & LN" in "People" page
    And I click on "button-newui" "search" on "People" Page
    And I click on "order status" "hyperlink" on "People" Page
    And I click on "button-newui" "continue" on "People" Page
    #And I should see element "hyperlink"
    
    And Verify Complianace Hyperlink with input value "UserName" for "Not-Compliant" status
    And Search table By "FN & LN" in "People" page
    And I click on "button-newui" "search" on "People" Page
    And I click on "order status" "hyperlink" on "People" Page
    And I click on "button-newui" "continue" on "People" Page
    And I should see element "hyperlink"
    
    And Verify Complianace Hyperlink with input value "UserName" for "Pending" status
    And Search table By "FN & LN" in "People" page
    And I click on "button-newui" "search" on "People" Page
    And I click on "order status" "hyperlink" on "People" Page
    And I click on "button-newui" "continue" on "People" Page
    And I should see element "hyperlink"
    
    Then Click Logout NewUI
    
    And I close browser
