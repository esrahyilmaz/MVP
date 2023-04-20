Feature: Program Owner Workflow - Provider Login 
#*****************************************************************************************************************************************
###################### NewUI Program Owner Workflow - Login ######################
@NewUIProgramOwnerWorkflow-Login @NewUIProgramOwnerWorkflow
  Scenario: NewUI_Program Owner Workflow Login
    Given I initialize Browser
    And I am executing "NewUI_Program Owner Workflow Login"
    And I navigate to "NewUI" application
   
    And I should see element "login page"
	And I should see Text "Work With Exceptional People"
	And I should see Text "You already know the value and safety that background checks deliver you and the organization you serve."
	And I should see Text "Sign Up now and follow the step-by-step guidance to quick and easy background screening."
	Then I should see element "Logo"
	
	When I log in to "automation sponsor" New UI application with "valid" Credentials 
	And I click on "button-newui" "Login" on "Login" Page
    
    When I should see "button-newui" named as "I Certify" on "FCRA" Page 
    
    Then I should see the sponsor logo in the header "VendorLogo"
    And I should see Customer support "number" in the header
    And I should see Customer support "email" in the header
    Then I should click "SupportLink" in the footer
    And I should click "FactActLink" in the footer
    And I should click "LegalLink" in the footer
    And I should click "PrivacyPolice" in the footer
    And I should see "FadvTrademark" in the footer of the page 
	
	And I close browser	

###################### NewUI Program Owner Workflow - Invalid Login - ######################
@NewUIProgramOwnerWorkflow-Login
@NewUIProgramOwnerWorkflow-Login-Invalid  @NewUIProgramOwnerWorkflow
  Scenario: NewUI_Program Owner Workflow Invalid Login
    Given I initialize Browser
    And I am executing "NewUI_Program Owner Workflow Invalid Login"
    And I navigate to "NewUI" application
    And I should see element "login page"
    
    When I Execute "Validate User Name and Password are required"
	When I click on "button-newui" "Login" on "Login" Page
	And I should see "errormsg-newui" named as "Username is required" on "Login" Page 
	And I should see "errormsg-newui" named as "Password is required" on "Login" Page 
	
	When I Execute "Validate Password is required"
	When I log in to "automation sponsor" New UI application with "onlyUser" Credentials
	And I click on "button-newui" "Login" on "Login" Page
	And I should see "errormsg-newui" named as "Password is required" on "Login" Page 
	
	When I Execute "Validate User Name is required"
	When I log in to "automation sponsor" New UI application with "onlyPassword" Credentials
	And I click on "button-newui" "Login" on "Login" Page
	And I should see "errormsg-newui" named as "Username is required" on "Login" Page 
    
    When I Execute "Validate valid Username and invalid password"
	When I log in to "automation sponsor" New UI application with "Random" Credentials
	And I click on "button-newui" "Login" on "Login" Page
	And I should see "errormsg-newui" named as "Username or password is incorrect. If this issue persists, please use the forgot password link below." on "Login" Page 
	And I close browser
	
	
#    When I Execute "Validate Login when NewUI is set to Legacy" 
#	Then I open only a new tab
#	Then I switch between tabs "child"
#	And I navigate to "Admin tool" application
#	And I log in to admin tool select customer "XTDAUTOQCSA" for "QCSA"
#	And I update Property "XTDFORCE_REGISTRATION_UI" to "N" 
#	Then I switch between tabs "parent"
#	And I clear the cache
#		
#	And I log in to "automation sponsor" New UI application with "Sponsor not set to NewUI" Credentials
#	And I click on "button-newui" "Login" on "Login" Page 
#	And I should see "errormsg-newui" named as "You are not allowed to log in. Please contact support at 1.866.237.2135 or XtdForceCustomerCare@fadv.com." on "Login" Page
#	
#	Then I switch between tabs "child"
#	And I update Property "XTDFORCE_REGISTRATION_UI" to "Y"
#	And I clear the cache
	
