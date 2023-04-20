Feature: Regression NewUI Vendor Onboarding Registration - Business Billing Page 

#^^^^^^^^^^^^^^^^^^^^^^^^^^^^^Business Billing^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
@VendorOnboarding
@301Regression 
@BusinessBillingPage 
Scenario: NewUIVendorRegistration_SC04-VendorRegistration-NewUI Business Billing Page 
	Given I initialize Browser 
	And I am executing "NewUIVendorRegistration_SC04-VendorRegistration-NewUI Business Billing Page" 
	And I navigate to "NewUI Vendor Registration" application 
	
	And I should see "text" named as "Have you signed up?" on "login page" Page 
	And I click on "signupbutton" "Sign up" on "login page" Page 
	
	When I wait for "3" Seconds 
	And I click on "button" "Let's Begin! " on "User Profile" Page 
	When I should fill details in "User Profile" page 
	And I click on "button" "NEXT" on "User Profile" Page 
	When I should fill details in "Business Information" page 
	And I click on "button" "NEXT" on "Business Information" Page 
	When I should fill details in "Business Contact" page 
	And I click on "button" "NEXT" on "Business Contact" Page 
	
	Then I should see "title" named as "Business Billing" on "Business Billing" Page 
	Then I should see the sponsor logo in the header "VendorLogo" 
	And I should see Customer support "number" in the header 
	And I should see Customer support "email" in the header 
	Then I should click "SupportLink" in the footer 
	And I should click "FactActLink" in the footer 
	And I should click "LegalLink" in the footer 
	And I should click "PrivacyPolice" in the footer 
	And I should see "FadvTrademark" in the footer of the page 
	
	And I click on "button-newui" "primaryContactCheckbox" on "Business Billing" Page
	And I should see element "addBillingContact" for "element disabled"
	
	And I click on "button-newui" "CheckboxBillingAddress" on "Business Billing" Page
	And I should see element "bb-billing-address-checkbox" for "checkbox checked" for People
	And I should validate "PrePopulatedAddressOnBB" on "Business Billing" Page
	
	And I click on "button-newui" "primaryContactCheckbox" on "Business Billing" Page
	And I click on "button-newui" "CheckboxBillingAddress" on "Business Billing" Page
	And I should see element "bb-billing-address-checkbox" for "checkbox unchecked" for People	
	When I should fill details in "Business Billing" page
   And I click on "button" "NEXT" on "Business Billing" Page 
	Then I close browser
	
	
#****************Error message on Business Billing***************************
@VendorOnboardingErrorMessages
@errorMessageReg 
@ErrorMessagesValidationOnBusinessBillingPage 
Scenario: NewUIVendorRegistration_SC04-VendorRegistration-NewUI Business Billing Page Invalid 
	Given I initialize Browser 
	And I am executing "NewUIVendorRegistration_SC04-VendorRegistration-NewUI Business Billing Page Invalid" 
	And I navigate to "NewUI Vendor Registration" application 
	
	And I should see "text" named as "Have you signed up?" on "login page" Page 
	And I click on "signupbutton" "Sign up" on "login page" Page 
	
	When I wait for "3" Seconds 
	And I click on "button" "Let's Begin! " on "User Profile" Page 
	When I should fill details in "User Profile" page 
	And I click on "button" "NEXT" on "User Profile" Page 
	When I should fill details in "Business Information" page 
	And I click on "button" "NEXT" on "Business Information" Page 
	When I should fill details in "Business Contact" page 
	And I click on "button" "NEXT" on "Business Contact" Page 
	
	When I clear all fields in "Business Billing" Page 
	And I click on "button" "NEXT" on "Business Billing" Page 
	And I should see "errormsg-newui" named as "First Name is required" on "Business Billing" Page 
	And I should see "errormsg-newui" named as "Last Name is required" on "Business Billing" Page 
	And I should see "errormsg-newui" named as "Title is required" on "Business Billing" Page 
	And I should see "errormsg-newui" named as "A valid email is required" on "Business Billing" Page 
	And I should see "errormsg-newui" named as "Country is required" on "Business Billing" Page 
	And I should see "errormsg-newui" named as "Calling Code is required" on "Business Billing" Page 
	And I should see "errormsg-newui" named as "Phone Number is required" on "Business Billing" Page 
	And I should see "errormsg-newui" named as "Address Line 1 is required" on "Business Billing" Page 
	And I should see "errormsg-newui" named as "City is required is required" on "Business Billing" Page 
	And I should see "errormsg-newui" named as "Calling Code is required" on "Business Billing" Page 
	And I should see "errormsg-newui" named as "State is required" on "Business Billing" Page 
	And I should see "text" named as "My billing address is the same as my business address" on "Business Billing" Page 
	
	#And I click on "button-newui" "middleNameYes" on "Business Billing" Page
    #And I should see "errormsg-newui" named as "Middle name is required" on "Business Billing" Page
    #And I enter "max" value for "bbMiddleName" textbox on "Business Billing" Page NewUI
    #And I should see "errormsg-newui" named as "Max length (50) exceeded" on "Business Billing" Page
    And I enter "a" value for "bbFirstName" textbox on "Business Billing" Page NewUI
    And I should not see "errormsg-newui" named as "Min length required" on "Business Billing" Page 
	
	And I enter "max" value for "bbFirstName" textbox on "Business Billing" Page NewUI 
	And I should see "text" named as "Max length (50) exceeded" on "Business Billing" Page 
	And I enter "max" value for "bblastName" textbox on "Business Billing" Page NewUI 
	And I should see "text" named as "Max length (50) exceeded" on "Business Billing" Page 
	And I enter "max" value for "bbTitle" textbox on "Business Billing" Page NewUI 
	And I should see "text" named as "Max length (20) exceeded" on "Business Billing" Page 
	
	And I select "United States" on "Business Billing" page
	#And I should see "errormsg-newui" named as "Zip Code is required" on "Business Billing" Page
	Then I close browser 
	
