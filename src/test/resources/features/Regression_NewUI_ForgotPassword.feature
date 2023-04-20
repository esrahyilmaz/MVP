Feature: Regression for Login forgot Password Validation

#@VendorOnboarding
@forgotpassword 
Scenario: NewUI_CA-New: Forgot Password
	Given I initialize Browser 
	And I am executing "NewUI_CA-New: Forgot Password" 
	And I navigate to "NewUI" application 
	And I should see element "Login Page"
	
	When I click on "button-newui" "Login" on "Login" Page
	And I should see Text "Username is required"
	And I should see Text "Password is required"
	When I log in to "newuiamazon1" New UI application with "onlyUser" Credentials
	And I click on "button-newui" "Login" on "Login" Page
	And I should see Text "Password is required"
	
	Then I should click on "Forgot password link"
	Then I should see the sponsor logo in the header "VendorLogo"
	And I should see "text" named as "Forgot your password?" on "forgot password" Page
	And I should see "text" named as "Enter your email address and we will send you a link to reset your password" on "forgot password" Page
	And I enter "invalid" value for "email" textbox on "Forgot password" Page NewUI
	And I should see "errormsg-newui" named as "A valid email is required" on "Forgot password" Page

	And I enter "valid" value for "email" textbox on "Forgot password" Page NewUI
	And I click on "button" "Reset" on "Forgot password" Page
	And I should see "text" named as "If the given email id is valid, then an email has been sent to your email id." on "forgot password" Page
    Then I should click on "Return to login"
    
    
    And I close browser	
    
	 
	 
	 
	 
	 