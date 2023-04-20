Feature: Sanity_NewUI_ForgotPassword

Scenario: SanityNewUI_Forgot Password Sanity Testing

	Given I initialize Browser 
	When I Execute "Validate Forgot Password Functional - TC-ID 28661"
	
	And I am executing "SanityNewUI_Forgot Password Sanity Testing" 
	And I navigate to "SanityNewUI" application 
    
    Then I should see element "Logo"
	And I should see element "login page"
    When I log in to "newuiproductionadmin" New UI application with "onlyUser" Credentials
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
	
#	And I enter "valid" value for "Password" textbox on "Outlook" Page NewUI
#	Then I click on "Sign In"
#	Then I click on "Do not stay login"

	Then Wait until Element Present "Outlook Home Page"
	
	And I click on "expand Inbox"
	And I click on "CA FADV Folder"

	Then Wait until Element Present "Unread email Password Reset"
	And I click on "Unread email Password Reset"
	And Get the "Name" From DB in "PROD"
#	And I should see Text "Name"
#	And I should see Text "UserID"

	And I should see element "forgot password link"
	And I click on "link from mail"
	Then I switch between tabs "child"
	
    And I should see Customer support "number" in the header
    And I should see Customer support "email" in the header
    Then I should click "SupportLink" in the footer
    And I should click "FactActLink" in the footer
    And I should click "LegalLink" in the footer
    And I should click "PrivacyPolice" in the footer
    And I should see "FadvTrademark" in the footer of the page
    
	And I should see element "Submit" for "disabled"
	Then I should see element "Logo - forgot password" 
	
	And I enter "valid" value for "password reset" textbox on "Password Reset" Page NewUI
	And I enter "same" value for "confirm password reset" textbox on "Password Reset" Page NewUI
	
	And I click on "button-newui" "Submit" on "Password Reset" Page
	And I should see Text "Password updated"
	When I should see "button-newui" named as "Return to Login" on "Password Reset" Page
	Then I should click on "Return to login"
	
	When I log in to "newuiproductionadmin" New UI application with "Reseted" Credentials 
	And I click on "button-newui" "Login" on "Login" Page 
    
	And I click on "button-newui" "I Certify" on "NOTICE" Page
	 
	When I should see "menubutton-newui" named as "Dashboard" on "HOME" Page
	Then I should see "title" named as "Here is your dashboard." on "Dashboard" Page
	
	Then I should see the sponsor logo in the header "VendorLogo"
    And I should see Customer support "number" in the header
    And I should see Customer support "email" in the header
    Then I should click "SupportLink" in the footer
    And I should click "FactActLink" in the footer
    And I should click "LegalLink" in the footer
    And I should click "PrivacyPolice" in the footer
    And I should see "FadvTrademark" in the footer of the page
    
	And I should see Text "Needs Review"
	And I should see Text "Non-Compliant"
	And I should see Text "Pending"
	When I click on "button-newui" "Needs Review" on "Dashboard" Page
	And I should see element "Needs Review" for "link url"
	Then I should see Text "No Results Found"
	
	And I should see element "profile icon"
	When I click on "profile-icon"
	And I should see element "logout"
	When I click on "logout"
	
	Then I close browser


Scenario: SanityCTNewUI_Forgot Password Sanity Testing

	Given I initialize Browser 
	When I Execute "Validate Forgot Password Functional - TC-ID 28661"
	
	And I am executing "SanityCTNewUI_Forgot Password Sanity Testing" 
	And I navigate to "SanityCTNewUI" application 
    
    Then I should see element "Logo"
	And I should see element "login page"
    When I log in to "newuictadmin" New UI application with "onlyUser" Credentials
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
	
#	And I enter "valid" value for "Password" textbox on "Outlook" Page NewUI
#	Then I click on "Sign In"
#	Then I click on "Do not stay login"

	Then Wait until Element Present "Outlook Home Page"
	
	And I click on "expand Inbox"
	And I click on "CA FADV Folder"

	Then Wait until Element Present "Unread email Password Reset"
	And I click on "Unread email Password Reset"
	And Get the "Name" From DB in "CT"
	
#	And I should see Text "Name"
#	And I should see Text "UserID"

	And I should see element "forgot password link"
	And I click on "link from mail"
	Then I switch between tabs "child"
	
    And I should see Customer support "number" in the header
    And I should see Customer support "email" in the header
    Then I should click "SupportLink" in the footer
    And I should click "FactActLink" in the footer
    And I should click "LegalLink" in the footer
    And I should click "PrivacyPolice" in the footer
    And I should see "FadvTrademark" in the footer of the page
    
	And I should see element "Submit" for "disabled"
	Then I should see element "Logo - forgot password" 
	
	And I enter "valid" value for "password reset" textbox on "Password Reset" Page NewUI
	And I enter "same" value for "confirm password reset" textbox on "Password Reset" Page NewUI
	
	And I click on "button-newui" "Submit" on "Password Reset" Page
	And I should see Text "Password updated"
	When I should see "button-newui" named as "Return to Login" on "Password Reset" Page
	Then I should click on "Return to login"
	
	When I log in to "newuictadmin" New UI application with "Reseted" Credentials 
	And I click on "button-newui" "Login" on "Login" Page 
    
	And I click on "button-newui" "I Certify" on "NOTICE" Page
	 
	When I should see "menubutton-newui" named as "Dashboard" on "HOME" Page
	Then I should see "title" named as "Here is your dashboard." on "Dashboard" Page
	
	Then I should see the sponsor logo in the header "VendorLogo"
    And I should see Customer support "number" in the header
    And I should see Customer support "email" in the header
    Then I should click "SupportLink" in the footer
    And I should click "FactActLink" in the footer
    And I should click "LegalLink" in the footer
    And I should click "PrivacyPolice" in the footer
    And I should see "FadvTrademark" in the footer of the page
    
	And I should see Text "Needs Review"
	And I should see Text "Non-Compliant"
	And I should see Text "Pending"
	When I click on "button-newui" "Needs Review" on "Dashboard" Page
	And I should see element "Needs Review" for "link url"
	Then I should see Text "No Results Found"
	
	And I should see element "profile icon"
	When I click on "profile-icon"
	And I should see element "logout"
	When I click on "logout"
	
	Then I close browser