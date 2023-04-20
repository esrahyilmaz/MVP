Feature: Smoke_NewUI

@xtdforceProductionSmoke
Scenario: SmokeNewUI_xtdForce Production Smoke

	Given I initialize Browser
	#########################################################################################################################
	
	When I Execute "Launch the New UI Sponsor URL - TC-ID 28656"
	#########################################################################################################################
	
	And I am executing "SmokeNewUI_xtdForce Production Smoke"
	And I navigate to "SmokeNewUI" application
	#########################################################################################################################
	
	When I Execute "Validate Logo"
	#########################################################################################################################
	
	Then I should see element "Logo"
	#########################################################################################################################
	
	When I Execute "Validate Sign up Button Functional - TC-ID 28658"
	#########################################################################################################################
	
	Then I should see "button-newui" named as "Sign up" on "Login" Page
	And I click on "signupbutton" "Sign up" on "login page" Page
	And I should see "text" named as "Company" on "Initial" Page
	And I should see "text" named as "I am signing up my company and screening my people" on "Initial" Page
	And I should see "text" named as "Registering will take 5 minutes." on "Initial" Page
	And I should see "text" named as "We recommend preparing the following, before you begin:" on "Initial" Page
	And I should see "text" named as "Legal Business Information" on "Initial" Page
	And I should see "text" named as "Primary Contact Information" on "Initial" Page
	And I should see "text" named as "Billing Information" on "Initial" Page
	And I should see "text" named as "Signatory Rights" on "Initial" Page
	And I should see "text" named as "Please Note" on "Initial" Page
	Then I should see "text" named as "Once your registration starts, you will not be able to end your session without losing your progress." on "Initial" Page
	And I click on "button-newui" "Previous" on "User Profile" Page

	And I should see element "login page"
	#########################################################################################################################
	
	When I Execute "Validate Forgot Password Functional - TC-ID 28661"
	#########################################################################################################################
	
	Then I should click on "Forgot password link"
	And I should see "text" named as "Forgot your password?" on "forgot password" Page
	And I should see "text" named as "Enter your email address and we will send you a link to reset your password" on "forgot password" Page
	And I enter "valid" value for "email" textbox on "Forgot password" Page NewUI
	And I click on "button" "Reset" on "Forgot password" Page
	And I should see "text" named as "If the given email id is valid, then an email has been sent to your email id." on "forgot password" Page
	Then I should click on "Return to login"
	#########################################################################################################################
	
	When I Execute "Validate Login Functional - TC-ID 28662"
	#########################################################################################################################
	
	And I should see element "login page"
	When I click on "button-newui" "Login" on "Login" Page
	And I should see "errormsg-newui" named as "Username is required" on "Login" Page
	And I should see "errormsg-newui" named as "Password is required" on "Login" Page
	When I log in to "newuiproductionadmin" New UI application with "onlyUser" Credentials
	And I click on "button-newui" "Login" on "Login" Page
	And I should see "errormsg-newui" named as "Password is required" on "Login" Page
	When I log in to "newuiproductionadmin" New UI application with "onlyPassword" Credentials
	And I click on "button-newui" "Login" on "Login" Page
	And I should see "errormsg-newui" named as "Username is required" on "Login" Page

 	When I log in to "newuiproductionadmin" New UI application with "validPassword" Credentials
	And I click on "button-newui" "Login" on "Login" Page
	And I should see "errormsg-newui" named as "We couldn't find your account." on "Login" Page
	And I log in to "automation" New UI application with "validUserName" Credentials
	And I click on "button-newui" "Login" on "Login" Page
	And I should see "errormsg-newui" named as "Bad credentials. You only have 4 attempts remaining before your account is locked." on "Login" Page
	#########################################################################################################################
	
	When I Execute "Validate New Ui Login Page loaded - TC-ID 28657"
	#########################################################################################################################
	
	When I log in to "automation" New UI application with "valid" Credentials
	And I click on "button-newui" "Login" on "Login" Page

 	And I click on "button-newui" "I Certify" on "NOTICE" Page
	#########################################################################################################################
	
	When I Execute "Validate People screen is rendering and Functional - TC-ID 28665"
	#########################################################################################################################
	
	When I should see "menubutton-newui" named as "People" on "HOME" Page
	And I click on "MenuButton-NewUI" "People" on "HOME" Page
	And I should see element "People"
	Then I should see the sponsor logo in the header "VendorLogo"
	And I should see Customer support "number" in the header
	And I should see Customer support "email" in the header
	Then I should click "SupportLink" in the footer
	And I should click "FactActLink" in the footer
	And I should click "LegalLink" in the footer
	And I should click "PrivacyPolice" in the footer
	And I should see "FadvTrademark" in the footer of the page

 	#########################################################################################################################
 	
	When I Execute "Validate Add People button is displayed and Functional - TC-ID 28667"
	#########################################################################################################################
	
	When I should see "button-newui" named as "Add People" on "People" Page
	#########################################################################################################################
	
	When I Execute "Validate People Ordering Flow using PA Pkg with Invoice - TC-ID 28668"
	#########################################################################################################################
	
	When I click on "button-newui" " Create Order " on "People" Page
	And I should see element "add people icon" for "POW icon"
	And I should see element "add people icon Section" for "POW icon"
	And I enter "valid" value for "FN" textbox on "Add People" Page NewUI
	And I click on "button-newui" "Middle Name Yes" on "add people" Page
	And I enter "valid" value for "MN" textbox on "Add People" Page NewUI
	And I enter "valid" value for "LN" textbox on "Add People" Page NewUI
	And I enter "random" value for "email" textbox on "Add People" Page NewUI
	And I enter "valid" value for "re-enter email" textbox on "Add People" Page NewUI
	And I click on "button-newui" "Next" on "Personal Information" Page
	And I should see element "package icon" for "POW icon"
	And I should see element "package icon Section" for "POW icon"
	And I should see Text "Package Selection"
	And I should see element "Add to Cart" for "disabled"
	When Search table By "Package" in "Package Selection" page
	And I click on "button-newui" "search" on "Add People" Page
	And I click on "radiobutton-newui" "first pkg" on "Add People" Page
	And I should see element "Package select checkbox" for "POW"
	And I should see "text-newui" named as "Price" on "Package Selection" Page
	And I click on "button-NewUI" "Add to Cart" on "add people" Page
	And I should see Text "Shopping cart"
	And I should see element "shopping cart icon" for "POW icon"
	And I should see element "shopping cart icon Section" for "POW icon"
	And I should see "text-newui" named as "existing Person" on "Shopping Cart" Page
	And I should see "text-newui" named as "existing Package" on "Shopping Cart" Page
	And I should see "text-newui" named as "existing Price" on "Shopping Cart" Page
	And I should see "text-newui" named as "Subtotal" on "Shopping Cart" Page
 	And I should see "text-newui" named as "Tax" on "Shopping Cart" Page
	And I should see "text-newui" named as "Order Total" on "Shopping Cart" Page
	
	And I click on "button-NewUI" "Checkout" on "Add People" Page
	Then I should see Text "Order complete!"
	And I should see element "order icon" for "POW icon"
	And I should see element "order icon Section" for "POW icon"
	And I should see Text "Order Confirmation"
	And I should see Text "Here is your transaction number:"
	And I should see "element" named as "Transaction Number" on "Order Confirmation" Page
	And I should see Text "Paid via:"
	And I should see "text-newui" named as "Paid via" on "Order Confirmation" Page
	And I should see Text "A confirmation notice with the order details will be sent to your email at"
	And I should see "text-newui" named as "Vendor email" on "Order Confirmation" Page
	And I should see Text "Choose an action below to continue"
	When I should see "button-newui" named as "Return to People" on "Add People" Page
	When I should see "button-newui" named as "Create a New Order" on "Add People" Page
	Then I click on "button-newui" "Return to People Page" on "add people" Page
	And I should see element "People"
	And Search table By "FN & LN" in "People" page
	And I click on "button-newui" "search" on "People" Page
	And I should see element "by multi search"
	And I click on Accordion
	Then I should see Text "Email Sent"
	Then I should not see element "Background Tile"

 	#########################################################################################################################
 	
	When I Execute "Validate Logout - TC-ID 28682"
	#########################################################################################################################

	And Click Logout NewUI
	And I close browser
	
	#########################################################################################################################
	
	Given I initialize Browser
	Then Send an Email NewUI
	And I close browser