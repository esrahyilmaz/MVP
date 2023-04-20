Feature: Program Owner Workflow Forgot Password Functionality

@Deprecated @ToBeReimplemented
Scenario: NewUI_Program Owner Workflow Forgot Password Functionality
	Given I initialize Browser 
	And I am executing "NewUI_Program Owner Workflow Forgot Password Functionality" 
	And I navigate to "NewUI" application 
    
    Then I should see element "Logo"
	And I should see element "login page"
    When I log in to "automation sponsor" New UI application with "UserID" Credentials
	And I click on "button-newui" "Login" on "Login" Page
	And I should see Text "Password is required"
	
    When I should see "button-newui" named as "Forgot password" on "Login" Page
	Then I should click on "Forgot password link"
	
	Then I should see the sponsor logo in the header "VendorLogo"
    And I should see Customer support "number" in the header
    And I should see Customer support "email" in the header
    Then I should click "SupportLink" in the footer
    And I should click "FactActLink" in the footer
    And I should click "LegalLink" in the footer
    And I should click "PrivacyPolice" in the footer
    And I should see "FadvTrademark" in the footer of the page
    
	Then I should see element "Logo - forgot password"
	And I should see "text" named as "Forgot your password?" on "forgot password" Page
	And I should see "text" named as "Enter your email address and we will send you a link to reset your password" on "forgot password" Page
	When I should see "button-newui" named as "Reset" on "Forgot password" Page
	And I should see element "Reset" for "disabled"
	And I enter "valid" value for "email" textbox on "Forgot password" Page NewUI
	And I click on "button" "Reset" on "Forgot password" Page
	And I should see "text" named as "If the given email id is valid, then an email has been sent to your email id." on "forgot password" Page
    When I should see "button-newui" named as "Return to login" on "Forgot password" Page
    Then I should click on "Return to login" 
    
    Then I open only a new tab
	Then I switch between tabs "child"

	And I navigate to "Outlook" application
	Then I close open tabs "parent"
	And I enter "valid" value for "Email" textbox on "Outlook" Page NewUI
	Then I click on "Next"
	Then I close browser
	
	#^^^^^^^^^^^^^^^ The rest of Test Case for forgot password should perform manually.^^^^^^^^^^^^^^
	
	
	
##	And I enter "valid" value for "Password" textbox on "Outlook" Page NewUI
##	Then I click on "Sign In"
##	Then I click on "Do not stay login"
#
#	Then Wait until Element Present "Outlook Home Page"
#	
#	And I click on "expand Inbox"
#	And I click on "CA FADV Folder"
#
#	Then Wait until Element Present "Unread email Password Reset"
#	And I click on "Unread email Password Reset"
#	And Get the "Name" From DB in "QCS"
##	And I should see Text "Name"
##	And I should see Text "UserID"
#
#	And I should see element "forgot password link"
#	And I click on "link from mail"
#	Then I switch between tabs "child"
#	
#    And I should see Customer support "number" in the header
#    And I should see Customer support "email" in the header
#    Then I should click "SupportLink" in the footer
#    And I should click "FactActLink" in the footer
#    And I should click "LegalLink" in the footer
#    And I should click "PrivacyPolice" in the footer
#    And I should see "FadvTrademark" in the footer of the page
#    
#	And I should see element "Submit" for "disabled"
#	Then I should see element "Logo - forgot password" 
#	
#	And I enter "valid" value for "password reset" textbox on "Password Reset" Page NewUI
#	And I enter "same" value for "confirm password reset" textbox on "Password Reset" Page NewUI
#	
#	And I click on "button-newui" "Submit" on "Password Reset" Page
#	And I should see Text "Password updated"
#	When I should see "button-newui" named as "Return to Login" on "Password Reset" Page
#	Then I should click on "Return to login"
#	
#	When I log in to "automation sponsor" New UI application with "Reseted" Credentials 
#	And I click on "button-newui" "Login" on "Login" Page 
#    
#	And I click on "button-newui" "I Certify" on "NOTICE" Page
#	 
#	When I should see "menubutton-newui" named as "Providers" on "HOME" Page
#	#Then I should see "title" named as "Here is your dashboard." on "Dashboard" Page
#	
#	Then I should see the sponsor logo in the header "VendorLogo"
#    And I should see Customer support "number" in the header
#    And I should see Customer support "email" in the header
#    Then I should click "SupportLink" in the footer
#    And I should click "FactActLink" in the footer
#    And I should click "LegalLink" in the footer
#    And I should click "PrivacyPolice" in the footer
#    And I should see "FadvTrademark" in the footer of the page
#	
#	And I should see element "profile icon"
#	When I click on "profile-icon"
#	And I should see element "logout"
#	When I click on "logout"
#	
#	
#	Then I close browser
