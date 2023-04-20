Feature: Program Owner Workflow - FCRA Page
#*****************************************************************************************************************************************
###################### NewUI Program Owner Workflow - FCRA page ######################
@NewUIProgramOwnerWorkflow-FCRA @NewUIProgramOwnerWorkflow
   Scenario: NewUI_Program Owner Workflow FCRA
    Given I initialize Browser
    And I am executing "NewUI_Program Owner Workflow FCRA"
    And I navigate to "NewUI" application
   
    And I should see element "login page"
		
	When I log in to "automation sponsor" New UI application with "valid" Credentials 
	And I click on "button-newui" "Login" on "Login" Page
    
   	And I should see Text "NOTICE"
   	And I should see Text "Please read through the below language before clicking and acknowledging below"
   	When I should see "button-newui" named as "I Certify" on "FCRA" Page 
    And I click on "button-newui" "I Certify" on "NOTICE" Page
	And I click on "MenuButton-NewUI" "Providers" on "HOME" Page
    And I should see element "Providers"
        
    Then I should see the sponsor logo in the header "VendorLogo"
    And I should see Customer support "number" in the header
    And I should see Customer support "email" in the header
    Then I should click "SupportLink" in the footer
    And I should click "FactActLink" in the footer
    And I should click "LegalLink" in the footer
    And I should click "PrivacyPolice" in the footer
    And I should see "FadvTrademark" in the footer of the page 
    
    And Click Logout NewUI
    
	When I log in to "automation sponsor" New UI application with "valid" Credentials
	And I click on "button-newui" "Login" on "Login" Page
 	And I should see Text "NOTICE"
 	When I should see "button-newui" named as "I Certify" on "FCRA" Page
 	And I click on "button-newui" "I Certify" on "NOTICE" Page
 	And I click on "MenuButton-NewUI" "Providers" on "HOME" Page
 	And I should see element "Providers"
	
	And Click Logout NewUI
    When I log in to "automation sponsor view" New UI application with "valid" Credentials
    And I click on "button-newui" "Login" on "Login" Page
 	And I should see Text "NOTICE"
 	When I should see "button-newui" named as "I Certify" on "FCRA" Page
 	And I click on "button-newui" "I Certify" on "NOTICE" Page
 	And I click on "MenuButton-NewUI" "Providers" on "HOME" Page
 	And I should see element "Providers"
 	And Click Logout NewUI
    When I log in to "automation sponsor view" New UI application with "valid" Credentials
    And I click on "button-newui" "Login" on "Login" Page
 	And I should see Text "NOTICE"
 	When I should see "button-newui" named as "I Certify" on "FCRA" Page
 	And I click on "button-newui" "I Certify" on "NOTICE" Page
 	And I click on "MenuButton-NewUI" "Providers" on "HOME" Page
 	And I should see element "Providers"
 	
 	And Click Logout NewUI
    When I log in to "automation sponsor summary" New UI application with "valid" Credentials
    And I click on "button-newui" "Login" on "Login" Page
 	And I should see Text "NOTICE"
 	When I should see "button-newui" named as "I Certify" on "FCRA" Page
 	And I click on "button-newui" "I Certify" on "NOTICE" Page
 	And I click on "MenuButton-NewUI" "Providers" on "HOME" Page
 	And I should see element "Providers"
 	And Click Logout NewUI
    When I log in to "automation sponsor summary" New UI application with "valid" Credentials
    And I click on "button-newui" "Login" on "Login" Page
 	And I should see Text "NOTICE"
 	When I should see "button-newui" named as "I Certify" on "FCRA" Page
 	And I click on "button-newui" "I Certify" on "NOTICE" Page
 	And I click on "MenuButton-NewUI" "Providers" on "HOME" Page
 	And I should see element "Providers"
 	
 	And Click Logout NewUI
    When I log in to "automation sponsor update" New UI application with "valid" Credentials
    And I click on "button-newui" "Login" on "Login" Page
 	And I should see Text "NOTICE"
 	When I should see "button-newui" named as "I Certify" on "FCRA" Page
 	And I click on "button-newui" "I Certify" on "NOTICE" Page
 	And I click on "MenuButton-NewUI" "Providers" on "HOME" Page
 	And I should see element "Providers"
 	And Click Logout NewUI
    When I log in to "automation sponsor update" New UI application with "valid" Credentials
    And I click on "button-newui" "Login" on "Login" Page
 	And I should see Text "NOTICE"
 	When I should see "button-newui" named as "I Certify" on "FCRA" Page
 	And I click on "button-newui" "I Certify" on "NOTICE" Page
 	And I click on "MenuButton-NewUI" "Providers" on "HOME" Page
 	And I should see element "Providers"
 	
 	And Click Logout NewUI
 	And I close browser
 
 	 
      
      