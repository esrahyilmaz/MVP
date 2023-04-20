Feature: Sanity_Prod_NewUI

@VendorOnboardingSanityTestingPROD @SanityTestingPROD3
Scenario: SanityNewUI_VendorOnboarding Sanity Testing

	Given I initialize Browser 
	When I Execute "Validate the Vendor Onboarding Flow with Invoice - TC-ID 28659"
	
	And I am executing "SanityNewUI_VendorOnboarding Sanity Testing" 
	And I navigate to "SanityNewUI" application 
	And I should see element "login page"	

	When I log in to "newuiproductionadmin" New UI application with "onlyUser" Credentials
	And I click on "button-newui" "Login" on "Login" Page
	And I should see "errormsg-newui" named as "Password is required" on "Login" Page 
	
	And I should see "button-newui" named as "Sign up" on "Login" Page
	And I should see "text" named as "Have you signed up?" on "Login" Page
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
	
	And I should see "button-newui" named as "Previous" on "User Profile" Page
	And I should see "button-newui" named as "Let's Begin!" on "User Profile" Page
	
	And I click on "button" "Let's Begin! " on "User Profile" Page 

	Then I should see the sponsor logo in the header "VendorLogo" 
	And I should see Customer support "number" in the header 
	And I should see Customer support "email" in the header 
	Then I should click "SupportLink" in the footer 
	And I should click "FactActLink" in the footer 
	And I should click "LegalLink" in the footer 
	And I should click "PrivacyPolice" in the footer 
	And I should see "FadvTrademark" in the footer of the page 

	When I clear all fields in "User Profile" Page 
	And I click on "button" "NEXT" on "User Profile" Page 
	
	And I should see "text" named as "First Name is required" on "User Profile" Page 
	And I should see "text" named as "Last Name is required" on "User Profile" Page 
	And I should see "text" named as "A valid email is required" on "User Profile" Page 
	And I should see "text" named as "Password must meet all criteria" on "User Profile" Page 
	And I should see "text" named as "Confirm password is required" on "User Profile" Page 
	Then I should see "text" named as "User ID is required" on "User Profile" Page 
	And I should see "text" named as "Secret question is required" on "User Profile" Page 
	And I should see "text" named as "Secret answer is required" on "User Profile" Page 
	
	And I enter "min" value for "FN" textbox on "User Profile" Page NewUI 
	And I should see "text" named as "Min length (2) not met" on "User Profile" Page 
	And I enter "max" value for "FN" textbox on "User Profile" Page NewUI 
	And I should see "text" named as "Max length (50) exceeded" on "User Profile" Page 
	
	And I enter "min" value for "LN" textbox on "User Profile" Page NewUI 
	And I should see "text" named as "Min length (2) not met" on "User Profile" Page 
	And I enter "max" value for "LN" textbox on "User Profile" Page NewUI 
	And I should see "text" named as "Max length (50) exceeded" on "User Profile" Page 
	
	And I enter "min" value for "UserID" textbox on "User Profile" Page NewUI 
	And I should see "text" named as "Min length (8) not met" on "User Profile" Page 
	And I enter "existingprod" value for "UserID" textbox on "User Profile" Page NewUI 
	And I should see "text" named as "User ID is Taken" on "User Profile" Page 
	And I enter "max" value for "UserID" textbox on "User Profile" Page NewUI 
	And I should see "text" named as "Max length (30) exceeded" on "User Profile" Page 
	
	And I enter "valid" value for "password" textbox on "User Profile" Page NewUI 
	And I enter "invalid" value for "confirm password" textbox on "User Profile" Page NewUI 
	And I should see "text" named as "Passwords do not match" on "User Profile" Page 
	And I should see "text" named as "Min length (8) not met" on "User Profile" Page 
	
	Then I should see "title" named as "User Profile" on "User Profile" Page
	When I should fill details in "User Profile" page 
	
	And I should see "button-newui" named as "Next" on "User Profile" Page
	And I click on "button" "NEXT" on "User Profile" Page
	
	Then I should see the sponsor logo in the header "VendorLogo" 
	And I should see Customer support "number" in the header 
	And I should see Customer support "email" in the header 
	Then I should click "SupportLink" in the footer 
	And I should click "FactActLink" in the footer 
	And I should click "LegalLink" in the footer 
	And I should click "PrivacyPolice" in the footer 
	And I should see "FadvTrademark" in the footer of the page 
	
	When I clear all fields in "Business Information" Page 
	And I click on "button" "NEXT" on "Business Information" Page 
	And I should see "text" named as "Business Name is required" on "Business Information" Page 
	And I should see "text" named as "Business Type is required" on "Business Information" Page 
	
	And I should see "text" named as "Employment Purpose is required" on "Business Information" Page 
	And I should see "text" named as "Business Description is required" on "Business Information" Page 
	And I enter "valid" value for "country" textbox on "Business Information" Page NewUI 
	And I enter ">9<" value for "SNN" textbox on "Business Information" Page NewUI 
	And I should see "text" named as "Must be 9 digits" on "Business Information" Page 
	
	Then I should see "title" named as "Business Information" on "Business Information" Page
	When I should fill details in "Business Information" page 
	
	And I should see "button-newui" named as "Go Back" on "Business Information" Page
	And I should see "button-newui" named as "Next" on "Business Information" Page
	And I click on "button" "NEXT" on "Business Information" Page
	
	Then I should see the sponsor logo in the header "VendorLogo" 
	And I should see Customer support "number" in the header 
	And I should see Customer support "email" in the header 
	Then I should click "SupportLink" in the footer 
	And I should click "FactActLink" in the footer 
	And I should click "LegalLink" in the footer 
	And I should click "PrivacyPolice" in the footer 
	And I should see "FadvTrademark" in the footer of the page 
	
	When I clear all fields in "Business Contact" Page 
	And I click on "button" "NEXT" on "Business Contact" Page 
	And I should see "text" named as "First Name is required" on "Business Contact" Page 
	And I should see "text" named as "Last Name is required" on "Business Contact" Page 
	And I should see "text" named as "Title is required" on "Business Contact" Page 
	And I should see "text" named as "A valid email is required" on "Business Contact" Page 
	And I should see "text" named as "Country is required" on "Business Contact" Page 
	And I should see "text" named as "Calling Code is required" on "Business Contact" Page 
	And I should see "text" named as "Phone Number is required" on "Business Contact" Page 
	
	And I enter "max" value for "FirstName" textbox on "Business Contact" Page NewUI 
	And I should see "text" named as "Max length (50) exceeded" on "Business Contact" Page 
	And I enter "max" value for "lastName" textbox on "Business Contact" Page NewUI 
	And I should see "text" named as "Max length (50) exceeded" on "Business Contact" Page 
	And I enter "max" value for "Title" textbox on "Business Contact" Page NewUI 
	And I should see "text" named as "Max length (20) exceeded" on "Business Contact" Page 
	
	Then I should see "title" named as "Business Contact" on "Business Contact" Page
	When I should fill details in "Business Contact" page
	
	And I should see "button-newui" named as "Go Back" on "Business Contact" Page
	And I should see "button-newui" named as "Next" on "Business Contact" Page 
	And I click on "button" "NEXT" on "Business Contact" Page
	
	Then I should see the sponsor logo in the header "VendorLogo" 
	And I should see Customer support "number" in the header 
	And I should see Customer support "email" in the header 
	Then I should click "SupportLink" in the footer 
	And I should click "FactActLink" in the footer 
	And I should click "LegalLink" in the footer 
	And I should click "PrivacyPolice" in the footer 
	And I should see "FadvTrademark" in the footer of the page 
	
	When I clear all fields in "Business Billing" Page 
	And I click on "button" "NEXT" on "Business Billing" Page 
	And I should see "text" named as "First Name is required" on "Business Billing" Page 
	And I should see "text" named as "Last Name is required" on "Business Billing" Page 
	And I should see "text" named as "Title is required" on "Business Billing" Page 
	And I should see "text" named as "A valid email is required" on "Business Billing" Page 	
	
	Then I should see "title" named as "Business Billing" on "Business Billing" Page
	When I should fill details in "Business Billing" page 
	
	And I should see "button-newui" named as "Go Back" on "Business Billing" Page
	And I should see "button-newui" named as "Next" on "Business Billing" Page 
	And I click on "button" "NEXT" on "Business Billing" Page

	Then I should see "title" named as "Almost Done" on "Business Confirmation" Page 
	Then I should see the sponsor logo in the header "VendorLogo" 
	And I should see Customer support "number" in the header 
	And I should see Customer support "email" in the header 
	Then I should click "SupportLink" in the footer 
	And I should click "FactActLink" in the footer 
	And I should click "LegalLink" in the footer 
	And I should click "PrivacyPolice" in the footer 
	And I should see "FadvTrademark" in the footer of the page 
	
	And I should see "text" named as "Business Information" on "Business Confirmation" Page 
	And I should see "text" named as "Name" on "Business Confirmation" Page 
	And I should see "text" named as "Doing Business As" on "Business Confirmation" Page 
	And I should see "text" named as "Address" on "Business Confirmation" Page
 
	And I should see "button-newui" named as "business-info Edit" on "Business Confirmation" Page 
	
	And I should see "text-newui" named as "Business Information-Name" on "Business Confirmation" Page
	And I should see "text-newui" named as "Business Information-Doing Business As" on "Business Confirmation" Page
	And I should see "text-newui" named as "Business Information-Address" on "Business Confirmation" Page
	
	When I click on "button-edit" "Edit" on "Business Confirmation" Page 
	When I wait for "2" Seconds 
	Then I should see "title" named as "Business Information" on "Business Information" Page 
	And I click on "button" "NEXT" on "Business Information" Page 
	And I click on "button" "NEXT" on "Business Contact" Page 
	And I click on "button" "NEXT" on "Business Billing" Page 
	
	And I should see "text" named as "Contacts" on "Business Confirmation" Page 

	And I should see "text-newui" named as "Contacts-Name" on "Business Confirmation" Page
	And I should see "text-newui" named as "Contacts-Email" on "Business Confirmation" Page
	
	And I should see "button-newui" named as "business-contact Edit" on "Business Confirmation" Page 
	When I click on "button-editb" "Edit" on "Business Confirmation" Page 
	Then I should see "title" named as "Business Contact" on "Business Contact" Page 
	And I click on "button" "NEXT" on "Business Contact" Page 
	And I click on "button" "NEXT" on "Business Billing" Page 
	
	And I should see "text" named as "Billing Contact Information" on "Business Confirmation" Page 
	
	And I should see "button-newui" named as "business-billing Edit" on "Business Confirmation" Page
	
	And I should see "text-newui" named as "Billing Contact Information-Name" on "Business Confirmation" Page
	And I should see "text-newui" named as "Billing Contact Information-Email" on "Business Confirmation" Page
	And I should see "text-newui" named as "Billing Contact Information-Address" on "Business Confirmation" Page
	  
	When I click on "button-editc" "Edit" on "Business Confirmation" Page 
	Then I should see "title" named as "Business Billing" on "Business Billing" Page 
	And I click on "button" "NEXT" on "Business Billing" Page 
	Then I should see "title" named as "Almost Done" on "Business Confirmation" Page 
	
	And I should see "button-newui" named as "Go Back" on "Business Confirmation" Page
	And I should see "button-newui" named as "Next" on "Business Confirmation" Page 
	And I click on "button" "NEXT" on "Business Confirmation" Page
	
	Then I should see the sponsor logo in the header "VendorLogo" 
	And I should see Customer support "number" in the header 
	And I should see Customer support "email" in the header 
	Then I should click "SupportLink" in the footer 
	And I should click "FactActLink" in the footer 
	And I should click "LegalLink" in the footer 
	And I should click "PrivacyPolice" in the footer 
	And I should see "FadvTrademark" in the footer of the page 
	
	And I should see "text-newui" named as "Business Description" on "Business Signature" Page
	And I should see "text-newui" named as "Employment Purpose" on "Business Signature" Page
	And I should see "text-newui" named as "Name" on "Business Signature" Page
	And I should see "text-newui" named as "Title" on "Business Signature" Page
	And I should see "text-newui" named as "Date" on "Business Signature" Page
	And I should see "text-newui" named as "Client" on "Business Signature" Page
	And I should see "text-newui" named as "Address" on "Business Signature" Page
	And I should see "text-newui" named as "Sponsor" on "Business Signature" Page
	And I should see "text-newui" named as "Service Provider" on "Business Signature" Page
	And I should see "text-newui" named as "Provider Name" on "Business Signature" Page
	And I should see "text-newui" named as "Provider Title" on "Business Signature" Page
		
	And I should see element "Today's Date"
	And I should see element "Adopt and Sign unselected"
	And I should see "text" named as "You must agree to use of electronic signature agreement." on "Business Signature" Page

	And I should see "button-newui" named as "Go Back" on "Business Signature" Page 
	And I should see "button-newui" named as "Submit" on "Business Signature" Page 
	And I should see element "Submit" for "disabled"
	
	And I Sign in Signature box
	And I should see element "Submit" for "disabled"
	And I click on "button-newui" "Clear Signature" on "Business Signature" Page
	And I Sign in Signature box
	And I should see element "Submit" for "disabled"	
	And I click on "tickbox" "adopAndSign" on "Business Signature" Page 
	When I should see element "5 completed sections" for "green tick mark"
	#NOTE: For Sanity Testing on Prod we should not click Submit button. I uncommented bellow line. 
	
	And I click on "button" "Submit" on "Business Signature" Page
	
	Then I should see the sponsor logo in the header "VendorLogo" 
	And I should see Customer support "number" in the header 
	And I should see Customer support "email" in the header 
	Then I should click "SupportLink" in the footer 
	And I should click "FactActLink" in the footer 
	And I should click "LegalLink" in the footer 
	And I should click "PrivacyPolice" in the footer 
	And I should see "FadvTrademark" in the footer of the page 
	
	Then I should see the sponsor logo in the header "congratulationsLogo" 
	And I should see "text" named as "Congratulations!" on "Registration Complete" Page 
	And I should see "text" named as "Your registration is complete. You can now login." on "Registration Complete" Page 
	And I should see "button-newui" named as "Login" on "Registration Complete" Page 
	And I click on "linktext" "Login" on "Registration Complete" Page
    
	When I log in to "newuionboardedvendor" New UI application with "valid" Credentials 
	And I click on "button-newui" "Login" on "Login" Page 
	
	Then I should see the sponsor logo in the header "VendorLogo"
    And I should see Customer support "number" in the header
    And I should see Customer support "email" in the header
    Then I should click "SupportLink" in the footer
    And I should click "FactActLink" in the footer
    And I should click "LegalLink" in the footer
    And I should click "PrivacyPolice" in the footer
    And I should see "FadvTrademark" in the footer of the page
    
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
	
@LoginSanityTestingPROD @SanityTestingPROD
Scenario: SanityNewUI_Login Sanity Testing

	Given I initialize Browser 
	When I Execute "Validate Login Functional - TC-ID 28662"
	
	And I am executing "SanityNewUI_Login Sanity Testing" 
	And I navigate to "SanityNewUI" application 
		
	And I should see element "login page"
	Then I should see element "Logo"
    
    When I should see "button-newui" named as "Login" on "Login" Page	
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
	
	And I log in to "newuiproductionadmin" New UI application with "validUserName" Credentials
	And I click on "button-newui" "Login" on "Login" Page
	And I should see "errormsg-newui" named as "Bad credentials. You only have 4 attempts remaining before your account is locked." on "Login" Page  
	
	When I log in to "newuiproductionadmin" New UI application with "valid" Credentials 
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

	And I should see Text "Needs Review"
	And I should see Text "Non-Compliant"
	And I should see Text "Pending"
	When I click on "button-newui" "Needs Review" on "Dashboard" Page
	And I should see element "Needs Review" for "link url"
	And I should see element "Active" for "filter pill"
	Then I should not see "People" column "Person Status" value "Inactive" on "NewUI" Page
	Then I should not see "People" column "Person Status" value "Terminated" on "NewUI" Page
	
	And I should see "menubutton-newui" named as "Administration" on "HOME" Page
	And I should see "button-newui" named as "Add People" on "People" Page
	
	And I should see element "profile icon"
	When I click on "profile-icon"
	And I should see element "logout"
	When I click on "logout"
		
	Then I close browser
	
@AppErrorMsgSanityTestingPROD	@SanityTestingPROD
Scenario: SanityNewUI_Application Error Messages

	Given I initialize Browser 	

	And I am executing "SanityNewUI_Application Error Messages" 
	
	And I navigate to "SanityNewUI" application 
	
	And I should see element "login page"
	Then I should see element "Logo"
	
	When I log in to "newuiproductionadmin" New UI application with "valid" Credentials 
	And I click on "button-newui" "Login" on "Login" Page
	
	And I click on "button-newui" "I Certify" on "NOTICE" Page
	
	And I click on "MenuButton-NewUI" "People" on "HOME" Page  
	And I should see element "People"
	
	######################################################################################################################### 
	
	When I Execute "Validate People Ordering Flow - error message" 
	#########################################################################################################################
    
    And I should see element "add people icon" for "POW icon"
    And I should see element "add people icon Section" for "POW icon"
    When I click on "button-newui" " Create Order " on "People" Page
    
    And I click on "button-newui" "Next" on "Personal Information" Page
    
    And I should see "errormsg-newui" named as "First Name is required" on "Personal Information" Page
    And I should see "errormsg-newui" named as "Last Name is required" on "Personal Information" Page
    And I should see "errormsg-newui" named as "Email is required" on "Personal Information" Page
    And I should see "errormsg-newui" named as "Confirm Email Address is required" on "Personal Information" Page

    When I click on "button-newui" "Middle Name Yes" on "add people" Page
    And I should see "errormsg-newui" named as "Middle Name is required" on "Personal Information" Page
    
    And I enter "max" value for "FN" textbox on "Add People" Page NewUI
    And I should see "errormsg-newui" named as "Max length (50) exceeded" on "Personal Information" Page
    And I clear "FN" in "pow" Page
        
    And I enter "max" value for "MN" textbox on "Add People" Page NewUI
    And I should see "errormsg-newui" named as "Max length (50) exceeded" on "Personal Information" Page
    And I clear "MN" in "pow" Page
    
    And I enter "max" value for "LN" textbox on "Add People" Page NewUI
    And I should see "errormsg-newui" named as "Max length (50) exceeded" on "Personal Information" Page
    And I clear "LN" in "pow" Page
        
    And I enter "invalid" value for "email" textbox on "Add People" Page NewUI
    And I should see "errormsg-newui" named as "A valid email is required" on "Personal Information" Page
    
    And I enter "min" value for "email" textbox on "Add People" Page NewUI
    And I should see "errormsg-newui" named as "Min length (3) not met" on "Personal Information" Page
	
	And I enter "valid" value for "FN" textbox on "Add People" Page NewUI
	And I click on "button-newui" "Middle Name Yes" on "add people" Page
	And I enter "valid" value for "MN" textbox on "Add People" Page NewUI
	And I enter "valid" value for "LN" textbox on "Add People" Page NewUI
    And I enter "random" value for "email" textbox on "Add People" Page NewUI
    And I enter "valid" value for "re-enter email" textbox on "Add People" Page NewUI  
   
    And I click on "button-newui" "Next" on "Personal Information" Page
	When Search table By "Package" in "Package Selection" page
	And I click on "button-newui" "search" on "Add People" Page
	And I click on "radiobutton-newui" "first pkg" on "Add People" Page
	And I should see element "Package select checkbox" for "POW"
	And I click on "button-NewUI" "Add to Cart" on "add people" Page
	
	And I click on "button-newui" "delete" on "Add People" Page
	And I should see "text-newui" named as "Are you sure you want to remove:" on "Add People" Page
	And I should see "text-newui" named as "XTDForce Package for PA" on "Add People" Page
	And I should see "text-newui" named as "Don`t ask me again" on "Add People" Page
	And I click on "button-newui" "Yes" on "Add People" Page
	And I should see Text "No items in the shopping cart."
	
	When I should see "button-newui" named as "Add Another Package" on "Add People" Page
	And I click on "button-newui" "Add Another Package" on "Add People" Page
	
	And I should see element "add people icon" for "POW icon"
    And I should see element "add people icon Section" for "POW icon"
    
	And I click on "button-newui" "Cancel" on "Personal Information" Page
	And I should see element "People"
	
	######################################################################################################################### 
	
	When I Execute "Validate Edit User Actions - error message"
	#########################################################################################################################
     
	When I click on "MenuButton-NewUI" "Administration" on "HOME" Page
    And I click on "MenuButton-NewUI" "User Management" on "HOME" Page
	
	When I click on "checkbox" "in table" on "Administration" Page
   
    And I click on "button-NewUI" "Action" on "Administration" Page
	And I click on "button-NewUI" "Edit User" on "Administration" Page
	
	Then I clear all fields in "Edit User" Page
	And I should see "errormsg-newui" named as "First Name is required" on "Administration" Page 
	And I should see "errormsg-newui" named as "Last Name is required" on "Administration" Page 
	And I should see "errormsg-newui" named as "A valid email is required" on "Administration" Page 
	And I click on "button-NewUI" "update" on "Administration" Page
	Then I should see element "error message"
	And Wait until Element Present "No modal"
	And I click on "button-newui" "Cancel" on "Administration" Page
	
	#########################################################################################################################
	
	When I Execute "Validate Adding New user - error messages"
	#########################################################################################################################
	
	Then Get the UserId from UI
	And I should see element "New User button"
    
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
	And I enter "existingprod" value for "UserID" textbox on "Administration" Page NewUI
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
	
	And I click on "button-newui" "Cancel" on "Administration" Page
	
    And Click Logout NewUI
	
    And I close browser

@PeopleOrderingCompletedSanityTestingPROD	@SanityTestingPROD1
Scenario: SanityNewUI_People Ordering using PA with Invoice - Completed

	Given I initialize Browser 
	When I Execute "Validate Profile status and Background tile is functional (EMAIL SENT, REGISTRATED, CONSENT ACCEPTED, COMPLETED)"
	
	And I am executing "SanityNewUI_People Ordering using PA with Invoice - Completed" 
	
	And I navigate to "SanityNewUI" application 
	
	And I should see element "login page"
    And I should see "button-newui" named as "Login" on "Login" Page	
	
	When I log in to "newuiproductionadmin" New UI application with "valid" Credentials 
	And I click on "button-newui" "Login" on "Login" Page
	
	When I should see "button-newui" named as "I Certify" on "FCRA" Page
	And I click on "button-newui" "I Certify" on "NOTICE" Page

	And I should see Text "Needs Review"
	And I should see Text "Non-Compliant"
	And I should see Text "Pending"

	When I click on "button-newui" "Needs Review" on "Dashboard" Page
	And I should see element "Needs Review" for "link url"
	And I should see element "Active" for "filter pill"
	Then I should not see "People" column "Person Status" value "Inactive" on "NewUI" Page
	Then I should not see "People" column "Person Status" value "Terminated" on "NewUI" Page

	Then I should see the sponsor logo in the header "VendorLogo"
    And I should see Customer support "number" in the header
    And I should see Customer support "email" in the header
    Then I should click "SupportLink" in the footer
    And I should click "FactActLink" in the footer
    And I should click "LegalLink" in the footer
    And I should click "PrivacyPolice" in the footer
    And I should see "FadvTrademark" in the footer of the page

	Then I set existing data of "Completed Profile Person-clear"		
	
    And I should see "button-newui" named as "Add People" on "People" Page
    
    When I click on "button-newui" " Create Order " on "People" Page
    
    Then I should see the sponsor logo in the header "VendorLogo"
    And I should see Customer support "number" in the header
    And I should see Customer support "email" in the header
    Then I should click "SupportLink" in the footer
    And I should click "FactActLink" in the footer
    And I should click "LegalLink" in the footer
    And I should click "PrivacyPolice" in the footer
    And I should see "FadvTrademark" in the footer of the page
    
    And I should see "button-newui" named as "Cancel" on "Personal Information" Page
	And I should see "button-newui" named as "Next" on "Personal Information" Page
    
    And I should see element "add people icon" for "POW icon"
    And I should see element "add people icon Section" for "POW icon"
    
	And I enter "valid" value for "FN" textbox on "Add People" Page NewUI
	And I click on "button-newui" "Middle Name Yes" on "add people" Page
	And I enter "valid" value for "MN" textbox on "Add People" Page NewUI
	And I enter "valid" value for "LN" textbox on "Add People" Page NewUI
    And I enter "random" value for "email" textbox on "Add People" Page NewUI
    And I enter "valid" value for "re-enter email" textbox on "Add People" Page NewUI  
   
    And I click on "button-newui" "Next" on "Personal Information" Page
    
    Then I should see the sponsor logo in the header "VendorLogo"
    And I should see Customer support "number" in the header
    And I should see Customer support "email" in the header
    Then I should click "SupportLink" in the footer
    And I should click "FactActLink" in the footer
    And I should click "LegalLink" in the footer
    And I should click "PrivacyPolice" in the footer
    And I should see "FadvTrademark" in the footer of the page
    
    And I should see "button-newui" named as "Previous" on "Package Selection" Page
	And I should see "button-newui" named as "Add to Cart" on "Package Selection" Page
	And I should see element "Add to Cart" for "disabled"
    And I should see element "price" for "displayed"
       
    And I should see element "package icon" for "POW icon"
	And I should see element "package icon Section" for "POW icon"
	And I should see Text "Package Selection"
	
	When Search table By "invalid Package" in "Package Selection" page
	And I click on "button-newui" "search" on "add people" Page
	Then I should see Text "No packages found."

	When Search table By "Package" in "Package Selection" page
	And I click on "button-newui" "search" on "add people" Page
	And I click on "radiobutton-newui" "first pkg" on "Add People" Page
	
	And Verify value "Price" on "Package Selection" Page for DB "PROD"
	And I should see element "Package select checkbox" for "POW"
	And I click on "button-NewUI" "Add to Cart" on "add people" Page	
	
	Then I should see the sponsor logo in the header "VendorLogo"
    And I should see Customer support "number" in the header
    And I should see Customer support "email" in the header
    Then I should click "SupportLink" in the footer
    And I should click "FactActLink" in the footer
    And I should click "LegalLink" in the footer
    And I should click "PrivacyPolice" in the footer
    And I should see "FadvTrademark" in the footer of the page
    
	And I should see Text "Shopping cart"
	And I should see element "shopping cart icon" for "POW icon"
	And I should see element "shopping cart icon Section" for "POW icon"
	
	And I should see "text-newui" named as "existing Person" on "Shopping Cart" Page
	And I should see "text-newui" named as "existing Package" on "Shopping Cart" Page	
	
	And Verify value "Price" on "Shopping Cart" Page for DB "PROD"
	And I should see "text-newui" named as "Subtotal" on "Shopping Cart" Page
#	And Verify value "Tax" on "Shopping Cart" Page for DB "PROD"
	
	And I should see "text-newui" named as "Order Total" on "Shopping Cart" Page
	
	When Search table By "invalid search" in "Shopping Cart" page
	And I click on "button-newui" "search" on "Shopping Cart" Page
	Then I should see Text "No items in the shopping cart."

	When Search table By "Package" in "Shopping Cart" page
	And I click on "button-newui" "search" on "Shopping Cart" Page
	
	And I click on "button-newui" "delete" on "Add People" Page
	
	And I should see "button-newui" named as "Yes" on "Shopping Cart" Page
	And I should see "button-newui" named as "No" on "Shopping Cart" Page
	And I should see "text-newui" named as "Are you sure you want to remove:" on "Add People" Page
	And I should see "text-newui" named as "XTDForce Package for PA" on "Add People" Page
	And I should see "text-newui" named as "Don`t ask me again" on "Add People" Page
	And I click on "button-newui" "No" on "Add People" Page
	
	And I should see "button-newui" named as "Checkout" on "Shopping Cart" Page	
	And I click on "button-NewUI" "Checkout" on "Add People" Page
	
	Then I should see the sponsor logo in the header "VendorLogo"
    And I should see Customer support "number" in the header
    And I should see Customer support "email" in the header
    Then I should click "SupportLink" in the footer
    And I should click "FactActLink" in the footer
    And I should click "LegalLink" in the footer
    And I should click "PrivacyPolice" in the footer
    And I should see "FadvTrademark" in the footer of the page
    	
	Then I should see Text "Order complete!"
  	And I should see element "order icon" for "POW icon"
	And I should see element "order icon Section" for "POW icon"
	And I should see Text "Order Confirmation"
	
	And I should see Text "Here is your transaction number:"
	And I should see "element" named as "Transaction Number" on "Order Confirmation" Page
	And I should see Text "Paid via:"

	And I should see "text-newui" named as "Invoice" on "Order Confirmation" Page
	And I should see Text "A confirmation notice with the order details will be sent to your email at"

	And Verify value "Vendor email" on "Order Confirmation" Page for DB "PROD"

	And I should see Text "Choose an action below to continue"
	
	When I should see "button-newui" named as "Return to People" on "Add People" Page
	When I should see "button-newui" named as "Create a New Order" on "Add People" Page
	
	Then I click on "button-newui" "Return to People Page" on "add people" Page
	And I should see element "People"
	
	Then wait Until Profile Status is "Email Sent"

	Then I should see element "Profile ID"
	Then I should not see element "Background Tile"
	Then I should not see element "Screening Status"
	Then I should see element "Status" for "Compliance"
	Then I should see element "Compliance Status" for "Pending"
	And I click on "order status" "no hyperlink" on "People" Page
    And I should not see element "compliance hyperlink"
	
	Then Get the ProfileId from UI
	Then I open only a new tab
	Then I switch between tabs "child"

	And I navigate to "PAInviteLanuchUrlPROD" application
	
	Then Wait until Element Present "Sign Up Page"
    And I fill details in PA "SignUp" page
    
    Then Wait until Element Present "Country Page"
     
    Then I switch between tabs "parent"
    Then wait Until Profile Status is "Registered"

    Then I should not see element "Background Tile"
    And I click on "order status" "no hyperlink" on "People" Page
    And I should not see element "compliance hyperlink"
    
    Then I switch between tabs "child"
    And I navigate to "PAInviteLanuchUrlPROD" application

    Then Wait until Element Present "Sign In Page"
    And I fill details in PA "SignIn" page
    
    Then Wait until Element Present "Country Page" 
    And I fill details in PA "Country" page
    
	Then Wait until Element Present "ESign Page"      
    And I fill details in PA "ESign" page

	Then Wait until Element Present "FCRA Notice"
	And I fill details in PA "Notice-PROD&CT" page
	Then Wait until Element Present "Profile Page"

    Then I switch between tabs "parent"
    
    Then wait Until Profile Status is "Consent Accepted"

    Then I should not see element "Background Tile"
    And I click on "order status" "no hyperlink" on "People" Page
    And I should not see element "compliance hyperlink"
    
    Then I switch between tabs "child"

    And I fill details in PA "Profile" page 

    Then Wait until Element Present "Current Residence Page"
    And I fill details in PA "Residence" page    
   
    Then Wait until Element Present "Employment Page"
    And I fill details in PA "Employment" page
    
    Then Wait until Element Present "Education Page"
    And I fill details in PA "Education" page
    
    Then Wait until Element Present "License Page"
    And I fill details in PA "License" page
    
    Then Wait until Element Present "Identity Page"
    And I fill details in PA "Identity" page
    
    Then Wait until Element Present "AdditionalInfomartion Page"
    And I fill details in PA "AdditionalInfomartion" page

    Then Wait until Element Present "Review Page"
    And I fill details in PA "Review" page
    
    Then Wait until Element Present "DocumentUpload Page"
    And I fill details in PA "DocumentUpload" page
    
    Then Wait until Element Present "ProfileDashboard Page"
    Then I close open tabs "child"

	Then wait Until Profile Status is "Completed"

    Then I should see element "Background Tile"
    Then I should see element "Background Tile" for "Pending"
    
    Then I should not see element "Screening Status"
	Then I should see element "Status" for "Compliance"
	Then I should see element "Compliance Status" for "Pending"
	And I click on "order status" "no hyperlink" on "People" Page
    And I click on "button-newui" "continue" on "People" Page
    And I should see element "hyperlink"
  
  	Then I set existing data of "Completed Profile Person"
  
    Then Click Logout NewUI

    And I close browser

@PeopleOrderingConsentRejectedSanityTestingPROD @SanityTestingPROD1
Scenario: SanityNewUI_People Ordering using PA with Invoice - Consent Rejected

	Given I initialize Browser 
	When I Execute "Validate Profile status and Background tile is functional (EMAIL SENT, REGISTRATED, CONSENT REJECTED)"
	
	And I am executing "SanityNewUI_People Ordering using PA with Invoice - Consent Rejected" 
	
	And I navigate to "SanityNewUI" application 
	
	And I should see element "login page"
    And I should see "button-newui" named as "Login" on "Login" Page	
	
	When I log in to "newuiproductionadmin" New UI application with "valid" Credentials 
	And I click on "button-newui" "Login" on "Login" Page
	
	When I should see "button-newui" named as "I Certify" on "FCRA" Page
	And I click on "button-newui" "I Certify" on "NOTICE" Page

	And I should see Text "Needs Review"
	And I should see Text "Non-Compliant"
	And I should see Text "Pending"
	When I click on "button-newui" "Needs Review" on "Dashboard" Page
	And I should see element "Needs Review" for "link url"
	And I should see element "Active" for "filter pill"
	Then I should not see "People" column "Person Status" value "Inactive" on "NewUI" Page
	Then I should not see "People" column "Person Status" value "Terminated" on "NewUI" Page
    
    And I should see "button-newui" named as "Add People" on "People" Page
    
    When I click on "button-newui" " Create Order " on "People" Page
    
    And I should see "button-newui" named as "Cancel" on "Personal Information" Page
	And I should see "button-newui" named as "Next" on "Personal Information" Page
    
    And I should see element "add people icon" for "POW icon"
    And I should see element "add people icon Section" for "POW icon"
	And I enter "valid" value for "FN" textbox on "Add People" Page NewUI
	And I click on "button-newui" "Middle Name Yes" on "add people" Page
	And I enter "valid" value for "MN" textbox on "Add People" Page NewUI
	And I enter "valid" value for "LN" textbox on "Add People" Page NewUI
    And I enter "random" value for "email" textbox on "Add People" Page NewUI
    And I enter "valid" value for "re-enter email" textbox on "Add People" Page NewUI  
   
    And I click on "button-newui" "Next" on "Personal Information" Page
    
    And I should see "button-newui" named as "Previous" on "Package Selection" Page
	And I should see "button-newui" named as "Add to Cart" on "Package Selection" Page
	And I should see element "Add to Cart" for "disabled"
    And I should see element "price" for "displayed"
       
    And I should see element "package icon" for "POW icon"
	And I should see element "package icon Section" for "POW icon"
	And I should see Text "Package Selection"
	
	When Search table By "Package" in "Package Selection" page
	And I click on "button-newui" "search" on "add people" Page
	And I click on "radiobutton-newui" "first pkg" on "Add People" Page
	And I should see element "Package select checkbox" for "POW"
	
	And I should see "text-newui" named as "Price" on "Package Selection" Page
#	And Verify value "Price" on "Package Selection" Page for DB "PROD"
	
	And I click on "button-NewUI" "Add to Cart" on "add people" Page	
	And I should see Text "Shopping cart"
	And I should see element "shopping cart icon" for "POW icon"
	And I should see element "shopping cart icon Section" for "POW icon"
	
	And I should see "text-newui" named as "existing Person" on "Shopping Cart" Page
	And I should see "text-newui" named as "existing Package" on "Shopping Cart" Page
	
	And I should see "text-newui" named as "Price" on "Shopping Cart" Page
#	And Verify value "Price" on "Shopping Cart" Page for DB "PROD"

	And I should see "text-newui" named as "Subtotal" on "Shopping Cart" Page
	
	And I should see "text-newui" named as "Tax" on "Shopping Cart" Page
#	And Verify value "Tax" on "Shopping Cart" Page for DB "PROD"

	And I should see "text-newui" named as "Order Total" on "Shopping Cart" Page

	When Search table By "Package" in "Shopping Cart" page
	And I click on "button-newui" "search" on "Shopping Cart" Page
	
	And I should see "button-newui" named as "Checkout" on "Shopping Cart" Page	
	And I click on "button-NewUI" "Checkout" on "Add People" Page

	Then I should see Text "Order complete!"
  	And I should see element "order icon" for "POW icon"
	And I should see element "order icon Section" for "POW icon"
	And I should see Text "Order Confirmation"
	And I should see Text "Here is your transaction number:"
	And I should see "element" named as "Transaction Number" on "Order Confirmation" Page
	And I should see Text "Paid via:"
	And I should see "text-newui" named as "Invoice" on "Order Confirmation" Page
	And I should see Text "A confirmation notice with the order details will be sent to your email at"
	And Verify value "Vendor email" on "Order Confirmation" Page for DB "PROD"

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
	Then I should see element "Profile ID"
	Then I should not see element "Background Tile"
	Then I should not see element "Screening Status"
	Then I should see element "Status" for "Compliance"
	Then I should see element "Compliance Status" for "Pending"
	And I click on "order status" "no hyperlink" on "People" Page
    And I should not see element "compliance hyperlink"
	
	Then Get the ProfileId from UI
	Then I open only a new tab
	Then I switch between tabs "child"

	And I navigate to "PAInviteLanuchUrlPROD" application
	
	Then Wait until Element Present "Sign Up Page"
    And I fill details in PA "SignUp" page
    
    Then Wait until Element Present "Country Page"
     
    Then I switch between tabs "parent"
    And wait for "5" Seconds
    When Search table By "FN & LN" in "People" page
    And I click on "button-newui" "search" on "People" Page
    And wait for "3" Seconds
    And I click on Accordion
    Then I should see Text "Registered"
    Then I should not see element "Background Tile"
    And I click on "order status" "no hyperlink" on "People" Page
    And I should not see element "compliance hyperlink"
    
    Then I switch between tabs "child"
    And I navigate to "PAInviteLanuchUrlPROD" application
 
    Then Wait until Element Present "Sign In Page"
    And I fill details in PA "SignIn" page
    
    Then Wait until Element Present "Country Page"
    And I fill details in PA "Country" page

    Then Wait until Element Present "ESign Page"
    And I fill details in PA "ESign" page
    
    Then Wait until Element Present "FCRA Notice"
	And I fill details in PA "NoticeDecline-PROD&CT" page
    Then Wait until Element Present "Profile Decline Page"
    
    Then I switch between tabs "parent"
    
    Then wait Until Profile Status is "Consent Rejected"
    
	Then I should not see element "Background Tile"
	Then I should not see element "Screening Status"
	Then I should see element "Status" for "Compliance"
	Then I should see element "Compliance Status" for "Pending"
	And I click on "order status" "no hyperlink" on "People" Page
    And I should not see element "compliance hyperlink"

	Then I set existing data of "Non-Completed Profile Person"
	
    Then Click Logout NewUI

    And I close browser
       
@PeopleSearchSanityTestingPROD @SanityTestingPROD
Scenario: SanityNewUI_People Search Sanity Testing

	Given I initialize Browser 
	When I Execute "Validate People Search using FN, LN, SSN - TC-ID 28666"
	
	And I am executing "SanityNewUI_People Search Sanity Testing" 
	And I navigate to "SanityNewUI" application 
	
	And I should see element "login page"
    And I should see "button-newui" named as "Login" on "Login" Page	
	
	When I log in to "newuiproductionadmin" New UI application with "valid" Credentials 
	And I click on "button-newui" "Login" on "Login" Page
	
	When I should see "button-newui" named as "I Certify" on "FCRA" Page
	And I click on "button-newui" "I Certify" on "NOTICE" Page

	And I should see Text "Needs Review"
	And I should see Text "Non-Compliant"
	And I should see Text "Pending"

	When I click on "button-newui" "Needs Review" on "Dashboard" Page
	And I should see element "Needs Review" for "link url"
	And I should see element "Active" for "filter pill"
	Then I should not see "People" column "Person Status" value "Inactive" on "NewUI" Page
	Then I should not see "People" column "Person Status" value "Terminated" on "NewUI" Page
	
	When I get details of "Person" from UI
	
	And I should see element "search"
	And I should see "textbox" named as "First Name" on "People" Page
    And Search table By "FN" in "People" page
    And I click on "button-newui" "search" on "People" Page
    Then I should see element "by search"
    And Refresh The Page
    
    And I should see "textbox" named as "Last Name" on "People" Page
    When Search table By "LN" in "People" page
    And I click on "button-newui" "search" on "People" Page
    Then I should see element "by search"
    And Refresh The Page
    
    And I should see "textbox" named as "Social Security Number" on "People" Page
    When Search table By "SSN" in "People" page
    And I click on "button-newui" "search" on "People" Page
    Then I should see element "by search"
    And Refresh The Page
    
    When Search table By "FN & LN & SSN" in "People" page
    And I click on "button-newui" "search" on "People" Page
    And I should see element "by multi search"
    And Refresh The Page
	
	
    When Search table By "invalid search" in "People" page
    And I click on "button-newui" "search" on "People" Page
    Then I should see Text "No Results Found"
    
	And Click Logout NewUI
	
	Then I close browser
	
@NewOrderSanityTestingPROD  @SanityTestingPROD
Scenario: SanityNewUI_People New Order Sanity Testing

	Given I initialize Browser 
	When I Execute "Validate New Order Action - TC-ID 28670"
	
	And I am executing "SanityNewUI_People New Order Sanity Testing" 
	And I navigate to "SanityNewUI" application 
	
	And I should see element "login page"
    And I should see "button-newui" named as "Login" on "Login" Page	
	
	When I log in to "newuiproductionadmin" New UI application with "valid" Credentials 
	And I click on "button-newui" "Login" on "Login" Page
	
	When I should see "button-newui" named as "I Certify" on "FCRA" Page
	And I click on "button-newui" "I Certify" on "NOTICE" Page

	And I should see Text "Needs Review"
	And I should see Text "Non-Compliant"
	And I should see Text "Pending"
	When I click on "button-newui" "Needs Review" on "Dashboard" Page
	And I should see element "Needs Review" for "link url"
	And I should see element "Active" for "filter pill"
	Then I should not see "People" column "Person Status" value "Inactive" on "NewUI" Page
	Then I should not see "People" column "Person Status" value "Terminated" on "NewUI" Page
	
	When I get details of "Person" from UI
	
    When Search table By "FN & LN & SSN" in "People" page
    And I click on "button-newui" "search" on "People" Page
    And I should see element "by multi search"
    
    When I click on "checkbox" "first" on "People" Page

	When I should see "button-newui" named as "New Order" on "People" Page
    And I click on "button-NewUI" "New Order PROD" on "People" Page

    And I should see "button-newui" named as "Cancel" on "Personal Information" Page
	And I should see "button-newui" named as "Next" on "Personal Information" Page
	
	And I click on "button-NewUI" "Cancel" on "Add People" Page
	
	And Click Logout NewUI
	
	Then I close browser
	
@PeopleSetStatusSanityTestingPROD @SanityTestingPROD
Scenario: SanityNewUI_People Set Status Sanity Testing

	Given I initialize Browser 
	When I Execute "Validate Set Status Action such as Active, Inactive, Terminated - TC-ID 28671"
	
	And I am executing "SanityNewUI_People Set Status Sanity Testing" 
	And I navigate to "SanityNewUI" application 
	
	And I should see element "login page"
    And I should see "button-newui" named as "Login" on "Login" Page	
	
	When I log in to "newuiproductionadmin" New UI application with "valid" Credentials 
	And I click on "button-newui" "Login" on "Login" Page
	
	When I should see "button-newui" named as "I Certify" on "FCRA" Page
	And I click on "button-newui" "I Certify" on "NOTICE" Page

	And I should see Text "Needs Review"
	And I should see Text "Non-Compliant"
	And I should see Text "Pending"

	When I click on "button-newui" "Needs Review" on "Dashboard" Page
	And I should see element "Needs Review" for "link url"
	And I should see element "Active" for "filter pill"
	Then I should not see "People" column "Person Status" value "Inactive" on "NewUI" Page
	Then I should not see "People" column "Person Status" value "Terminated" on "NewUI" Page
	
	When I get details of "Person" from UI
	
	And Search table By "FN & LN & SSN" in "People" page
 	And I click on "button-newui" "search" on "People" Page
    When I click on "checkbox" "first" on "People" Page
    And I click on "button-newui" "Set Status" on "People" Page
    And I click on "button-newui" "Inactive" on "People" Page
	
	And Search table By "FN & LN & SSN" in "People" page
 	And I click on "button-newui" "search" on "People" Page
 	Then I should see Text "No Results Found"
 	
 	And I click on "button-newui" "filter" on "People" Page
 	And I click on "checkbox" "filter Active" on "People" Page
 	And I click on "checkbox" "filter Inactive" on "People" Page
 	And I click on "button-newui" "filter complete" on "People" Page
 	
 	And Search table By "FN & LN & SSN" in "People" page
 	And I click on "button-newui" "search" on "People" Page
 	Then I should see element "Inactive" for "searched person"

 	And Refresh The Page
 	
 	And I should see element "Active" for "filter pill"
 	Then I should not see "People" column "Person Status" value "Inactive" on "NewUI" Page
	Then I should not see "People" column "Person Status" value "Terminated" on "NewUI" Page
	
	And I click on "button-newui" "filter" on "People" Page
 	And I click on "checkbox" "filter Active" on "People" Page
 	And I click on "checkbox" "filter Inactive" on "People" Page
 	And I click on "button-newui" "filter complete" on "People" Page
	
	And Search table By "FN & LN & SSN" in "People" page
 	And I click on "button-newui" "search" on "People" Page
 	When I click on "checkbox" "first" on "People" Page
 	And I click on "button-newui" "Set Status" on "People" Page
	And I click on "button-newui" "Terminated" on "People" Page
	
	And Search table By "FN & LN & SSN" in "People" page
 	And I click on "button-newui" "search" on "People" Page
 	Then I should see Text "No Results Found"
 	
 	And I click on "button-newui" "filter" on "People" Page
 	And I click on "checkbox" "filter Inactive" on "People" Page
 	And I click on "checkbox" "filter Terminated" on "People" Page
 	And I click on "button-newui" "filter complete" on "People" Page
 	
 	And Search table By "FN & LN & SSN" in "People" page
 	And I click on "button-newui" "search" on "People" Page
 	Then I should see element "Terminated" for "searched person"

 	And Refresh The Page
 	
 	And I should see element "Active" for "filter pill"
	Then I should not see "People" column "Person Status" value "Inactive" on "NewUI" Page
	Then I should not see "People" column "Person Status" value "Terminated" on "NewUI" Page
		
	And I click on "button-newui" "filter" on "People" Page
 	And I click on "checkbox" "filter Active" on "People" Page
 	And I click on "checkbox" "filter Terminated" on "People" Page
 	And I click on "button-newui" "filter complete" on "People" Page
 	
	And Search table By "FN & LN & SSN" in "People" page
 	And I click on "button-newui" "search" on "People" Page
 	When I click on "checkbox" "first" on "People" Page
 	And I click on "button-newui" "Set Status" on "People" Page
	And I click on "button-newui" "Active" on "People" Page
 	
 	And Search table By "FN & LN & SSN" in "People" page
 	And I click on "button-newui" "search" on "People" Page
 	Then I should see Text "No Results Found"
 	
 	And I click on "button-newui" "filter" on "People" Page
 	And I click on "checkbox" "filter Terminated" on "People" Page
 	And I click on "checkbox" "filter Active" on "People" Page
 	And I click on "button-newui" "filter complete" on "People" Page
 	
 	And Search table By "FN & LN & SSN" in "People" page
 	And I click on "button-newui" "search" on "People" Page
 	Then I should see element "Active" for "searched person"

 	And Refresh The Page
 	
	And Click Logout NewUI
	
	Then I close browser

@AddNewUserSaniyTestingPROD @SanityTestingPROD
Scenario: SanityNewUI_Add New User Sanity Testing

	Given I initialize Browser 
	When I Execute "Validate Adding New user - TC-ID 286786"
	
	And I am executing "SanityNewUI_Add New User Sanity Testing" 
	And I navigate to "SanityNewUI" application 
	
	And I should see element "login page"
    And I should see "button-newui" named as "Login" on "Login" Page	
	
	When I log in to "newuiproductionadmin" New UI application with "valid" Credentials 
	And I click on "button-newui" "Login" on "Login" Page
	
	When I should see "button-newui" named as "I Certify" on "FCRA" Page
	And I click on "button-newui" "I Certify" on "NOTICE" Page

	And I should see Text "Needs Review"
	And I should see Text "Non-Compliant"
	And I should see Text "Pending"
	When I click on "button-newui" "Needs Review" on "Dashboard" Page
	And I should see element "Needs Review" for "link url"
	And I should see element "Active" for "filter pill"
	Then I should not see "People" column "Person Status" value "Inactive" on "NewUI" Page
	Then I should not see "People" column "Person Status" value "Terminated" on "NewUI" Page
	
	Then I click on "MenuButton-NewUI" "Administration" on "HOME" Page
    Then I click on "MenuButton-NewUI" "User Management" on "HOME" Page
    
    When I should see "button-newui" named as "New User" on "Administration" Page
    And I click on "button-NewUI" "New User" on "Administration" Page
    When I should see "button-newui" named as "Add New User" on "Administration" Page
    When I should see "button-newui" named as "Cancel" on "Administration" Page
    
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
	
	When Search table By "FN & LN & Email" in "Administration" page
    And I click on "button-newui" "search" on "Administration" Page
    And I should see element "by multi search" 
    
    And Click Logout NewUI
	
    And I close browser
  
@EditUserSaniyTestingPROD  @SanityTestingPROD
Scenario: SanityNewUI_Edit User Sanity Testing

	Given I initialize Browser 
	When I Execute "Validate Edit User Actions - TC-ID 28679"
	
	And I am executing "SanityNewUI_Edit User Sanity Testing" 
	And I navigate to "SanityNewUI" application 
	
	And I should see element "login page"
    And I should see "button-newui" named as "Login" on "Login" Page	
	
	When I log in to "newuiproductionadmin" New UI application with "valid" Credentials 
	And I click on "button-newui" "Login" on "Login" Page
	
	When I should see "button-newui" named as "I Certify" on "FCRA" Page
	And I click on "button-newui" "I Certify" on "NOTICE" Page

	And I should see Text "Needs Review"
	And I should see Text "Non-Compliant"
	And I should see Text "Pending"
	When I click on "button-newui" "Needs Review" on "Dashboard" Page
	And I should see element "Needs Review" for "link url"
	And I should see element "Active" for "filter pill"
	Then I should not see "People" column "Person Status" value "Inactive" on "NewUI" Page
	Then I should not see "People" column "Person Status" value "Terminated" on "NewUI" Page
	
	Then I click on "MenuButton-NewUI" "Administration" on "HOME" Page
    Then I click on "MenuButton-NewUI" "User Management" on "HOME" Page
    
    When I should see "button-newui" named as "New User" on "Administration" Page
    And I click on "button-NewUI" "New User" on "Administration" Page
    When I should see "button-newui" named as "Add New User" on "Administration" Page
    When I should see "button-newui" named as "Cancel" on "Administration" Page
    
    And I fill details in "New User" page
    And I click on "button-NewUI" "SAVE" on "Administration" Page
    Then I should see element "success message"
	
	When Search table By "FN & LN & Email" in "Administration" page
    And I click on "button-newui" "search" on "Administration" Page
    And I should see element "by multi search" 
    
    When I click on "checkbox" "first" on "Administration" Page
    And I click on "button-NewUI" "Action" on "Administration" Page
    When I should see "button-newui" named as "Edit User" on "Administration" Page
	And I click on "button-NewUI" "Edit User" on "Administration" Page
	Then I should see Text "Edit User"
	Then I should see Text "Personal Information"
	Then I check User Details with all entries are pre-filled in "Edit User" Page
	Then I compare value in "Edit User" with picked up value from table
	When I should not see element "Password"
	When I should not see element "Confirm Password"
	When I should see element "disabled" for "UserID field"
	When I should see "button-newui" named as "Update user" on "Administration" Page
	When I should see "button-newui" named as "Cancel" on "Administration" Page
	
	And I fill details in "Edit User" page
	And I click on "button-NewUI" "update" on "Administration" Page
	Then I should see element "success message"
	When Search table By "FN & LN & Email" in "Administration" page
    And I click on "button-newui" "search" on "Administration" Page
    And I should see element "by multi search"
    
    And Click Logout NewUI
	
    And I close browser

@UserSearchSanityTestingPROD @SanityTestingPROD
Scenario: SanityNewUI_User Search Sanity Testing

	Given I initialize Browser 
	When I Execute "Validate User Search using FN, LN, Email - TC-ID 28676"
	
	And I am executing "SanityNewUI_User Search Sanity Testing" 
	And I navigate to "SanityNewUI" application 
	
	And I should see element "login page"
    And I should see "button-newui" named as "Login" on "Login" Page	
	
	When I log in to "newuiproductionadmin" New UI application with "valid" Credentials 
	And I click on "button-newui" "Login" on "Login" Page
	
	When I should see "button-newui" named as "I Certify" on "FCRA" Page
	And I click on "button-newui" "I Certify" on "NOTICE" Page

	And I should see Text "Needs Review"
	And I should see Text "Non-Compliant"
	And I should see Text "Pending"
	When I click on "button-newui" "Needs Review" on "Dashboard" Page
	And I should see element "Needs Review" for "link url"
	And I should see element "Active" for "filter pill"
	Then I should not see "People" column "Person Status" value "Inactive" on "NewUI" Page
	Then I should not see "People" column "Person Status" value "Terminated" on "NewUI" Page
	
	And I should see "menubutton-newui" named as "Administration" on "HOME" Page
	Then I click on "MenuButton-NewUI" "Administration" on "HOME" Page
	Then I should not see "menubutton-newui" named as "Your Payments" on "HOME" Page 
	When I should see "menubutton-newui" named as "User Management" on "HOME" Page
    Then I click on "MenuButton-NewUI" "User Management" on "HOME" Page
    
	When I get details of "User" from UI
	
	Then Verify PlaceHolder Value for "First Name" on "Administration" Page
	When Search table By "FN" in "Administration" page
    And I click on "button-newui" "search" on "Administration" Page
    Then I should see element "by search"
    And Refresh The Page
   
   	Then Verify PlaceHolder Value for "Last Name" on "Administration" Page
    When Search table By "LN" in "Administration" page
    And I click on "button-newui" "search" on "Administration" Page
	Then I should see element "by search"
	And Refresh The Page
   
   	Then Verify PlaceHolder Value for "Email" on "Administration" Page
    When Search table By "email" in "Administration" page
    And I click on "button-newui" "search" on "Administration" Page
    Then I should see element "by search"
    And Refresh The Page
    
    When Search table By "FN & LN & Email" in "Administration" page
    And I click on "button-newui" "search" on "Administration" Page
    And I should see element "by multi search" 
    And Refresh The Page
    
    And I should see element "search"
    When Search table By "invalid search" in "Administration" page
    And I click on "button-newui" "search" on "Administration" Page
    Then I should see Text "No Results Found"
    
	And Click Logout NewUI
	
	Then I close browser
  
@UserStatusSanityTestingPROD  @SanityTestingPROD
Scenario: SanityNewUI_User Status Sanity Testing

	Given I initialize Browser 
	When I Execute "Validate User Status such as Active and Inactive - TC-ID 28680"
	
	And I am executing "SanityNewUI_User Status Sanity Testing" 
	And I navigate to "SanityNewUI" application 
	
	And I should see element "login page"
    And I should see "button-newui" named as "Login" on "Login" Page	
	
	When I log in to "newuiproductionadmin" New UI application with "valid" Credentials 
	And I click on "button-newui" "Login" on "Login" Page
	
	When I should see "button-newui" named as "I Certify" on "FCRA" Page
	And I click on "button-newui" "I Certify" on "NOTICE" Page

	And I should see Text "Needs Review"
	And I should see Text "Non-Compliant"
	And I should see Text "Pending"
	When I click on "button-newui" "Needs Review" on "Dashboard" Page
	And I should see element "Needs Review" for "link url"
	And I should see element "Active" for "filter pill"
	Then I should not see "People" column "Person Status" value "Inactive" on "NewUI" Page
	Then I should not see "People" column "Person Status" value "Terminated" on "NewUI" Page
	
	Then I click on "MenuButton-NewUI" "Administration" on "HOME" Page
    Then I click on "MenuButton-NewUI" "User Management" on "HOME" Page
    
    When I should see "button-newui" named as "New User" on "Administration" Page
    And I click on "button-NewUI" "New User" on "Administration" Page
    When I should see "button-newui" named as "Add New User" on "Administration" Page
    When I should see "button-newui" named as "Cancel" on "Administration" Page
    
    And I fill details in "New User" page
    And I click on "button-NewUI" "SAVE" on "Administration" Page
    Then I should see element "success message"
	
	When Search table By "FN & LN & Email" in "Administration" page
    And I click on "button-newui" "search" on "Administration" Page
    And I should see element "by multi search" 
    
    Then I should see "Users" column "Status" value "Active" on "NewUI" Page
    
    When I click on "checkbox" "first" on "Administration" Page
    And I click on "button-NewUI" "Action" on "Administration" Page
    When I should see "button-newui" named as "Edit User" on "Administration" Page
	And I click on "button-NewUI" "Edit User" on "Administration" Page
	Then I should see Text "Edit User"
	Then I should see Text "Personal Information"
	Then I check User Details with all entries are pre-filled in "Edit User" Page
	Then I compare value in "Edit User" with picked up value from table
	When I should not see element "Password"
	When I should not see element "Confirm Password"
	When I should see element "disabled" for "UserID field"
	When I should see "button-newui" named as "Update user" on "Administration" Page
	When I should see "button-newui" named as "Cancel" on "Administration" Page
	
	And I enter "Inactive" value for "Status" textbox on "Administration" Page NewUI
	And I click on "button-NewUI" "update" on "Administration" Page
	Then I should see element "success message"
	When Search table By "FN & LN & Email" in "Administration" page
    And I click on "button-newui" "search" on "Administration" Page
    And I should see element "by multi search"
    
    Then I should see "Users" column "Status" value "Inactive" on "NewUI" Page
    
    And Click Logout NewUI
    
    ######################################################################################################################### 

	When I Execute "Validate Inactive User Login - TC-ID 28683"
	#########################################################################################################################
    
    When I log in to "newuirole" New UI application with "valid" Credentials
    And I click on "button-NewUI" "Login" on "Login" Page
	And I should see "errormsg-newui" named as "Your account is disabled. Please contact support at 1.844.718.0087 or XtdForceCustomerCare@fadv.com." on "Login" Page
	
    And I close browser

@UpdateUserLoginSanityTestingPROD    @SanityTestingPROD2
Scenario: SanityNewUI_Update User Login Sanity Testing

	Given I initialize Browser 
	When I Execute "Validate Update User Login - TC-ID 28684"
	
	And I am executing "SanityNewUI_Update User Login Sanity Testing" 
	And I navigate to "SanityNewUI" application 
	
	And I should see element "login page"
    And I should see "button-newui" named as "Login" on "Login" Page	
	
	When I log in to "newuiproductionadmin" New UI application with "valid" Credentials 
	And I click on "button-newui" "Login" on "Login" Page
	
	When I should see "button-newui" named as "I Certify" on "FCRA" Page
	And I click on "button-newui" "I Certify" on "NOTICE" Page

	Then I click on "MenuButton-NewUI" "Administration" on "HOME" Page
    Then I click on "MenuButton-NewUI" "User Management" on "HOME" Page
    
    When I should see "button-newui" named as "New User" on "Administration" Page
    And I click on "button-NewUI" "New User" on "Administration" Page
    
    And I enter "valid" value for "FN" textbox on "Administration" Page NewUI
    And I enter "valid" value for "LN" textbox on "Administration" Page NewUI
    And I enter "valid" value for "UserID" textbox on "Administration" Page NewUI
	And I enter "valid" value for "email" textbox on "Administration" Page NewUI
	And I enter "UPDATE" value for "role" textbox on "Administration" Page NewUI
	And I enter "valid" value for "status" textbox on "Administration" Page NewUI
	And I enter "valid" value for "password" textbox on "Administration" Page NewUI
    And I enter "same" value for "confirm password" textbox on "Administration" Page NewUI
    
    And I click on "button-NewUI" "SAVE" on "Administration" Page
    Then I should see element "success message"
    And I should see "row" named as "createdUser" on "administration" Page
	
	When Search table By "FN & LN & Email" in "Administration" page
    And I click on "button-newui" "search" on "Administration" Page
    And I should see element "by multi search" 
    
    Then I should see "Users" column "Role" value "Update" on "NewUI" Page
    
    And Click Logout NewUI
    
   	When I log in to "newuirole" New UI application with "valid" Credentials
    And I click on "button-NewUI" "Login" on "Login" Page
    And I click on "button-NewUI" "i certify" on "notice" Page
    
    And I should see Text "Needs Review"
	And I should see Text "Non-Compliant"
	And I should see Text "Pending"
	When I click on "button-newui" "Needs Review" on "Dashboard" Page
	And I should see element "Needs Review" for "link url"
	And I should see element "Active" for "filter pill"
	Then I should not see "People" column "Person Status" value "Inactive" on "NewUI" Page
	Then I should not see "People" column "Person Status" value "Terminated" on "NewUI" Page
	
    Then I should not see "menubutton-newui" named as "Administration" on "newui" Page
    Then I should see "menubutton-newui" named as "People" on "newui" Page
    Then I should see "menubutton-newui" named as "Dashboard" on "newui" Page
    
    Then I should see "button-newui" named as "Add People" on "People" Page
    When I click on "button-newui" "Add People" on "People" Page
    And I should see element "add people icon" for "POW icon"
    And I should see element "add people icon Section" for "POW icon"
    When I click on "button-newui" "Cancel" on "Personal Information" Page
    And I should see Text "People"
    
    When I get existing data of "Completed Profile Person"
    And Search table By "FN & LN" in "People" page
    And I click on "button-newui" "search" on "People" Page
    And I get details of "Person" from UI
    And I should see element "by multi search" 
	And I click on Accordion
	Then I should see Text "Completed"
	Then I should see element "Profile ID"
	Then I should see element "Background Tile"
	Then I should not see element "Screening Status"
	Then I should see element "Status" for "Compliance"
	Then I should see element "Compliance Status" for "Pending"
	And I click on "order status" "hyperlink" on "People" Page
    And I click on "button-newui" "continue" on "People" Page
    And I should see element "hyperlink"
       
    When I get existing data of "Non-Completed Profile Person"
    And Search table By "FN & LN" in "People" page
    And I click on "button-newui" "search" on "People" Page
    And I get details of "Person" from UI
    And I should see element "by multi search" 
	And I click on Accordion
	Then I should see Text "Consent Rejected"
	Then I should see element "Profile ID"
	Then I should not see element "Background Tile"
	Then I should not see element "Screening Status"
	Then I should see element "Status" for "Compliance"
	Then I should see element "Compliance Status" for "Pending"
	And I click on "order status" "no hyperlink" on "People" Page
    And I should not see element "compliance hyperlink"
    
    And Click Logout NewUI
    
    And I close browser

@SummaryUserLoginSanityTestingPROD @SanityTestingPROD2
Scenario: SanityNewUI_Summary User Login Sanity Testing

	Given I initialize Browser 
	When I Execute "Validate Summary User Login - TC-ID 28685"
	
	And I am executing "SanityNewUI_Summary User Login Sanity Testing" 
	And I navigate to "SanityNewUI" application 
	
	And I should see element "login page"
    And I should see "button-newui" named as "Login" on "Login" Page	
	
	When I log in to "newuiproductionadmin" New UI application with "valid" Credentials 
	And I click on "button-newui" "Login" on "Login" Page
	
	When I should see "button-newui" named as "I Certify" on "FCRA" Page
	And I click on "button-newui" "I Certify" on "NOTICE" Page

	Then I click on "MenuButton-NewUI" "Administration" on "HOME" Page
    Then I click on "MenuButton-NewUI" "User Management" on "HOME" Page
    
    When I should see "button-newui" named as "New User" on "Administration" Page
    And I click on "button-NewUI" "New User" on "Administration" Page
    
    And I enter "valid" value for "FN" textbox on "Administration" Page NewUI
    And I enter "valid" value for "LN" textbox on "Administration" Page NewUI
    And I enter "valid" value for "UserID" textbox on "Administration" Page NewUI
	And I enter "valid" value for "email" textbox on "Administration" Page NewUI
	And I enter "SUMMARY" value for "role" textbox on "Administration" Page NewUI
	And I enter "valid" value for "status" textbox on "Administration" Page NewUI
	And I enter "valid" value for "password" textbox on "Administration" Page NewUI
    And I enter "same" value for "confirm password" textbox on "Administration" Page NewUI
    
    And I click on "button-NewUI" "SAVE" on "Administration" Page
    Then I should see element "success message"
    And I should see "row" named as "createdUser" on "administration" Page
	
	When Search table By "FN & LN & Email" in "Administration" page
    And I click on "button-newui" "search" on "Administration" Page
    And I should see element "by multi search" 
    
    Then I should see "Users" column "Role" value "Summary" on "NewUI" Page
    
    And Click Logout NewUI
    
   	When I log in to "newuirole" New UI application with "valid" Credentials
    And I click on "button-NewUI" "Login" on "Login" Page
    And I click on "button-NewUI" "i certify" on "notice" Page
    
    And I should see Text "Needs Review"
	And I should see Text "Non-Compliant"
	And I should see Text "Pending"

	When I click on "button-newui" "Needs Review" on "Dashboard" Page
	And I should see element "Needs Review" for "link url"
	And I should see element "Active" for "filter pill"
	Then I should not see "People" column "Person Status" value "Inactive" on "NewUI" Page
	Then I should not see "People" column "Person Status" value "Terminated" on "NewUI" Page
	
    Then I should not see "menubutton-newui" named as "Administration" on "newui" Page
    Then I should see "menubutton-newui" named as "People" on "newui" Page
    Then I should see "menubutton-newui" named as "Dashboard" on "newui" Page
    
    Then I should see "button-newui" named as "Add People" on "People" Page
    When I click on "button-newui" "Add People" on "People" Page
    And I should see element "add people icon" for "POW icon"
    And I should see element "add people icon Section" for "POW icon"
    When I click on "button-newui" "Cancel" on "Personal Information" Page
    And I should see Text "People"
    
    When I get existing data of "Completed Profile Person"
    And Search table By "FN & LN" in "People" page
    And I click on "button-newui" "search" on "People" Page
    And I get details of "Person" from UI
    And I should see element "by multi search" 
	And I click on Accordion
	Then I should see Text "Completed"
	Then I should see element "Profile ID"
	Then I should see element "Background Tile"
	Then I should not see element "Screening Status"
	Then I should see element "Status" for "Compliance"
	Then I should see element "Compliance Status" for "Pending"
	And I click on "order status" "no hyperlink" on "People" Page
    And I should not see element "compliance hyperlink"
       
    When I get existing data of "Non-Completed Profile Person"
    And Search table By "FN & LN" in "People" page
    And I click on "button-newui" "search" on "People" Page
    And I get details of "Person" from UI
    And I should see element "by multi search" 
	And I click on Accordion
	Then I should see Text "Consent Rejected"
	Then I should see element "Profile ID"
	Then I should not see element "Background Tile"
	Then I should not see element "Screening Status"
	Then I should see element "Status" for "Compliance"
	Then I should see element "Compliance Status" for "Pending"
	And I click on "order status" "no hyperlink" on "People" Page
    And I should not see element "compliance hyperlink"
        
    And Click Logout NewUI
    
    And I close browser

@ViewUserLoginSanityTestingPROD @SanityTestingPROD2
Scenario: SanityNewUI_View User Login Sanity Testing

	Given I initialize Browser 
	When I Execute "Validate View User Login - TC-ID 28686"
	
	And I am executing "SanityNewUI_View User Login Sanity Testing" 
	And I navigate to "SanityNewUI" application 
	
	And I should see element "login page"
    And I should see "button-newui" named as "Login" on "Login" Page	
	
	When I log in to "newuiproductionadmin" New UI application with "valid" Credentials 
	And I click on "button-newui" "Login" on "Login" Page
	
	When I should see "button-newui" named as "I Certify" on "FCRA" Page
	And I click on "button-newui" "I Certify" on "NOTICE" Page

	Then I click on "MenuButton-NewUI" "Administration" on "HOME" Page
    Then I click on "MenuButton-NewUI" "User Management" on "HOME" Page
    
    When I should see "button-newui" named as "New User" on "Administration" Page
    And I click on "button-NewUI" "New User" on "Administration" Page
    
    And I enter "valid" value for "FN" textbox on "Administration" Page NewUI
    And I enter "valid" value for "LN" textbox on "Administration" Page NewUI
    And I enter "valid" value for "UserID" textbox on "Administration" Page NewUI
	And I enter "valid" value for "email" textbox on "Administration" Page NewUI
	And I enter "VIEW" value for "role" textbox on "Administration" Page NewUI
	And I enter "valid" value for "status" textbox on "Administration" Page NewUI
	And I enter "valid" value for "password" textbox on "Administration" Page NewUI
    And I enter "same" value for "confirm password" textbox on "Administration" Page NewUI
    
    And I click on "button-NewUI" "SAVE" on "Administration" Page
    Then I should see element "success message"
    And I should see "row" named as "createdUser" on "administration" Page
	
	When Search table By "FN & LN & Email" in "Administration" page
    And I click on "button-newui" "search" on "Administration" Page
    And I should see element "by multi search" 
    
    Then I should see "Users" column "Role" value "View" on "NewUI" Page
    
    And Click Logout NewUI
    
   	When I log in to "newuirole" New UI application with "valid" Credentials
    And I click on "button-NewUI" "Login" on "Login" Page
    And I click on "button-NewUI" "i certify" on "notice" Page
    
    And I should see Text "Needs Review"
	And I should see Text "Non-Compliant"
	And I should see Text "Pending"
	When I click on "button-newui" "Needs Review" on "Dashboard" Page
	And I should see element "Needs Review" for "link url"
	And I should see element "Active" for "filter pill"
	Then I should not see "People" column "Person Status" value "Inactive" on "NewUI" Page
	Then I should not see "People" column "Person Status" value "Terminated" on "NewUI" Page
	
    Then I should not see "menubutton-newui" named as "Administration" on "newui" Page
    Then I should see "menubutton-newui" named as "People" on "newui" Page
    Then I should see "menubutton-newui" named as "Dashboard" on "newui" Page
    
    Then I should not see "button-newui" named as "Add People" on "People" Page
    And I should see Text "People"
     
    When I get existing data of "Completed Profile Person"
    And Search table By "FN & LN" in "People" page
    And I click on "button-newui" "search" on "People" Page
    And I get details of "Person" from UI
    And I should see element "by multi search" 
	And I click on Accordion
	Then I should see Text "Completed"
	Then I should see element "Profile ID"
	Then I should see element "Background Tile"
	Then I should not see element "Screening Status"
	Then I should see element "Status" for "Compliance"
	Then I should see element "Compliance Status" for "Pending"
	And I click on "order status" "no hyperlink" on "People" Page
    And I should not see element "compliance hyperlink"
       
    When I get existing data of "Non-Completed Profile Person"
    And Search table By "FN & LN" in "People" page
    And I click on "button-newui" "search" on "People" Page
    And I get details of "Person" from UI
    And I should see element "by multi search" 
	And I click on Accordion
	Then I should see Text "Consent Rejected"
	Then I should see element "Profile ID"
	Then I should not see element "Background Tile"
	Then I should not see element "Screening Status"
	Then I should see element "Status" for "Compliance"
	Then I should see element "Compliance Status" for "Pending"
	And I click on "order status" "no hyperlink" on "People" Page
    And I should not see element "compliance hyperlink"

    And Click Logout NewUI
    
    And I close browser

@PaginationSanityTestingPROD  @SanityTestingPROD      
Scenario: SanityNewUI_Pagination Sanity Testing

	Given I initialize Browser 
	When I Execute "Validate Pagination for screens - TC-ID 28717"
	
	And I am executing "SanityNewUI_Pagination Sanity Testing" 
	And I navigate to "SanityNewUI" application
		
	And I should see element "login page"
    And I should see "button-newui" named as "Login" on "Login" Page	
	
	When I log in to "newuiproductionadmin" New UI application with "valid" Credentials 
	And I click on "button-newui" "Login" on "Login" Page
	
	When I should see "button-newui" named as "I Certify" on "FCRA" Page
	And I click on "button-newui" "I Certify" on "NOTICE" Page

    Then I should see "menubutton-newui" named as "Dashboard" on "newui" Page
    Then I should see "menubutton-newui" named as "People" on "newui" Page
    
    And I click on "MenuButton-NewUI" "People" on "HOME" Page
    
    And I should see element "pagination"
    When I click on "pagination" "next" on "People" Page
    And I should see element "class disabled" for "next button"
    When I click on "pagination" "previous" on "People" Page
    And I should see element "class disabled" for "previous button"
    When I click on "pagination" "GoToLast" on "People" Page
    And I should see element "class disabled" for "next button"
    When I click on "pagination" "GoToFirst" on "People" Page
    And I should see element "class disabled" for "previous button"
    
    When I should see "button-newui" named as "Add People" on "People" Page
     
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
	
	And I should see element "pagination"
    When I click on "pagination" "next" on "Search Package" Page
    And I should see element "class disabled" for "next button"
    When I click on "pagination" "previous" on "Search Package" Page
    And I should see element "class disabled" for "previous button"
    When I click on "pagination" "GoToLast" on "Search Package" Page
    And I should see element "class disabled" for "next button"
    When I click on "pagination" "GoToFirst" on "Search Package" Page
    And I should see element "class disabled" for "previous button"
 
    When I should see "menubutton-newui" named as "Administration" on "HOME" Page 
    When I click on "MenuButton-NewUI" "Administration" on "HOME" Page
    Then I click on "MenuButton-NewUI" "User Management" on "HOME" Page
    
    And I should see element "pagination"
    When I click on "pagination" "next" on "Administration" Page
    And I should see element "class disabled" for "next button"
    When I click on "pagination" "previous" on "Administration" Page
    And I should see element "class disabled" for "previous button"
    When I click on "pagination" "GoToLast" on "Administration" Page
    And I should see element "class disabled" for "next button"
    When I click on "pagination" "GoToFirst" on "Administration" Page
    And I should see element "class disabled" for "previous button"
    
    And Click Logout NewUI
	
    And I close browser
    
