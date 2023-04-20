Feature: NewUI Program Owner Workflow Logout Functionality

#*********************NewUI Program Owner Workflow Logout Functionality************
 @NewUIProgramWorkLogout    @ProgramOwerLogout34478 @NewUIProgramOwnerWorkflow
  Scenario: NewUI_Program Owner Workflow Logout Functionality
    Given I initialize Browser
    And I am executing "NewUI_Program Owner Workflow Logout Functionality"
    And I navigate to "NewUI" application
    When I log in to "automation sponsor" New UI application with "valid" Credentials
    And I click on "button-NewUI" "Login" on "Login" Page
    And I click on "button-NewUI" "i certify" on "notice" Page
    
    And I click on "MenuButton-NewUI" "People" on "People" Page  
	And I should see element "People"
	
	And I should see element "profile icon"
	When I click on "profile-icon"
	And I should see element "User Name" for "profile icon"
	And I should see element "logout"
	When I click on "logout"
	
	And I should see element "login page"
	When I log in to "automation sponsor" New UI application with "valid" Credentials 
	And I click on "button-newui" "Login" on "Login" Page 
	When I should see "button-newui" named as "I Certify" on "FCRA" Page
	And I click on "button-newui" "I Certify" on "NOTICE" Page
	
	And I close browser	