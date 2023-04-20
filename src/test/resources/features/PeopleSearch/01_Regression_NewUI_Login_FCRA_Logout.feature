Feature: Regression NewUI Login
    
#*****************************************************************************************************************************************

###################### Login Page (Login) - 1912 ################################
###################### FCRA - Legal Acknowledgement - 1962 ######################
###################### XtdForce 2.0™ - Logout Button - 3097 ##################### 
###################### Default Language Update on Login Page - 28363 ############
@NewUI-PeopleSearch
@NewUI-US-1912 
@NewUI-US-1962 
@NewUI-US-3097 
@NewUI-US-28363 
Scenario: NewUI_SC01-Valid Login
	Given I initialize Browser 
	When I Execute "Validate Valid Login Functionality - US-1912"
	When I Execute "Validate FCRA Page - US-1962"
	When I Execute "Validate Logout Functionality - US-3097"
	When I Execute "Validate Login Default Language - US-28363"
	
	And I am executing "NewUI_SC01-Valid Login" 
	And I navigate to "NewUI" application 
	And I should see element "login page"
	And I should see Text "Work With Exceptional People"
	And I should see Text "You already know the value and safety that background checks deliver you and the organization you serve."
	And I should see Text "Sign Up now and follow the step-by-step guidance to quick and easy background screening."
	Then I should see element "Logo"
	
	When I log in to "autoqcs" New UI application with "valid" Credentials 
	And I click on "button-newui" "Login" on "Login" Page
	
	Then I should see the sponsor logo in the header "VendorLogo"
    And I should see Customer support "number" in the header
    And I should see Customer support "email" in the header
    Then I should click "SupportLink" in the footer
    And I should click "FactActLink" in the footer
    And I should click "LegalLink" in the footer
    And I should click "PrivacyPolice" in the footer
    And I should see "FadvTrademark" in the footer of the page 
	
	When I should see "button-newui" named as "I Certify" on "FCRA" Page
	And I click on "button-newui" "I Certify" on "NOTICE" Page
	
	And I click on "MenuButton-NewUI" "People" on "People" Page  
	And I should see element "People"
	
	And I should see element "profile icon"
	When I click on "profile-icon"
	And I should see element "User Name" for "profile icon"
	And I should see element "logout"
	When I click on "logout"
	
	And I should see element "login page"
	When I log in to "autoqcs" New UI application with "valid" Credentials 
	And I click on "button-newui" "Login" on "Login" Page 
	When I should see "button-newui" named as "I Certify" on "FCRA" Page
	And I click on "button-newui" "I Certify" on "NOTICE" Page
	
	And I close browser	
	
###################### Re-Implement Login Failure Behavior/Functionality - 20182 ################################        
@NewUI-PeopleSearch
@NewUI-US-20182 
Scenario: NewUI_SC02-Invalid Login
	Given I initialize Browser 
	When I Execute "Validate Invalid Login Functionality - US-20182"
	And I am executing "NewUI_SC02-Invalid Login" 
	And I navigate to "NewUI" application 
	And I should see element "Login Page"

	When I Execute "Validate User Name and Password are required"
	When I click on "button-newui" "Login" on "Login" Page
	And I should see "errormsg-newui" named as "Username is required" on "Login" Page 
	And I should see "errormsg-newui" named as "Password is required" on "Login" Page 
	
	When I Execute "Validate Password is required"
	When I log in to "autoqcs" New UI application with "onlyUser" Credentials
	And I click on "button-newui" "Login" on "Login" Page
	And I should see "errormsg-newui" named as "Password is required" on "Login" Page 
	
	When I Execute "Validate User Name is required"
	When I log in to "autoqcs" New UI application with "onlyPassword" Credentials
	And I click on "button-newui" "Login" on "Login" Page
	And I should see "errormsg-newui" named as "Username is required" on "Login" Page 

#	When I Execute "Validate User has account for Sponsor"
#	When I log in to "autoqcs" New UI application with "validPassword" Credentials
#	And I click on "button-newui" "Login" on "Login" Page 
#	And I should see "errormsg-newui" named as "We couldn't find your account." on "Login" Page 

#	When I Execute "Validate Sponsor User Login to NewUI"		
#	When I log in to "newuiamazon1" New UI application with "Sponsor" Credentials
#	And I click on "button-newui" "Login" on "Login" Page
#	And I should see "errormsg-newui" named as "You are not allowed to login with these credentials. Please contact support at 1.844.718.0087 or support@AmazonFP.com." on "Login" Page

	When I Execute "Validate Inactive User tries to Login"
	When I log in to "autoqcs" New UI application with "Inactive" Credentials
	And I click on "button-newui" "Login" on "Login" Page 
	And I should see "errormsg-newui" named as "Username or password is incorrect. If this issue persists, please use the forgot password link below." on "Login" Page 
	#And I should see "errormsg-newui" named as "Your account is disabled. Please contact support at 1.844.718.0087 or support@AmazonFP.com." on "Login" Page

	When I Execute "Validate Bad attempts of User Login"
 	And I log in to "autoqcs" New UI application with "validUserName" Credentials
	And I click on "button-newui" "Login" on "Login" Page
	And I should see "errormsg-newui" named as "Username or password is incorrect. If this issue persists, please use the forgot password link below." on "Login" Page

#	And I should see "errormsg-newui" named as "Bad credentials. You only have 4 attempts remaining before your account is locked." on "Login" Page 
#	And I click on "button-newui" "Login" on "Login" Page 
#	And I should see "errormsg-newui" named as "Bad credentials. You only have 3 attempts remaining before your account is locked." on "Login" Page 
#	And I click on "button-newui" "Login" on "Login" Page 
#	And I should see "errormsg-newui" named as "Bad credentials. You only have 2 attempts remaining before your account is locked." on "Login" Page 
#	And I click on "button-newui" "Login" on "Login" Page 
#	And I should see "errormsg-newui" named as "Bad credentials. You only have 1 attempts remaining before your account is locked." on "Login" Page 
#	And I click on "button-newui" "Login" on "Login" Page 
#	And I should see "errormsg-newui" named as "Your account is locked. Please contact support at 1.844.718.0087 or support@AmazonFP.com." on "Login" Page 	
#	
#	And Set User to "N" locked for UserID "91516"
#	When I log in to "autoqcs" New UI application with "ValidLogin" Credentials 
#	And I click on "button-newui" "Login" on "Login" Page
#	And I click on "button-newui" "I Certify" on "NOTICE" Page
#	And I click on "MenuButton-NewUI" "People" on "People" Page  
#	And I click on "button-newui" "logout" on "People" Page
	
	When I Execute "Validate Login when NewUI is set to Legacy" 
	Then I open only a new tab
	Then I switch between tabs "child"
	And I navigate to "Admin tool" application
	And I log in to admin tool select customer "XTDAUTOQCSA" for "QCSA"
	And I update Property "XTDFORCE_REGISTRATION_UI" to "N" 
	Then I switch between tabs "parent"
	And I clear the cache
		
	And I log in to "autoqcs" New UI application with "Sponsor not set to NewUI" Credentials
	And I click on "button-newui" "Login" on "Login" Page 
	And I should see "errormsg-newui" named as "You are not allowed to log in. Please contact support at 1.844.718.0087 or XtdForceCustomerCare@fadv.com." on "Login" Page
	
	Then I switch between tabs "child"
	And I update Property "XTDFORCE_REGISTRATION_UI" to "Y"
	And I clear the cache
	And I close browser
	