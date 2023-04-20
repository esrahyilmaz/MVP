Feature: Regression NewUI Vendor Onboarding Registration - Business Signature Page 

#^^^^^^^^^^^^^^^^^^^^^^^^^^^^^Business Signature^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
@VendorOnboarding
@301Regression 
@BusinessSignPage
Scenario: NewUIVendorRegistration_SC07-VendorRegistration-NewUI Business Signature Page 
	Given I initialize Browser 
	And I am executing "NewUIVendorRegistration_SC07-VendorRegistration-NewUI Business Signature Page" 
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
	When I should fill details in "Business Billing" page 
	And I click on "button" "NEXT" on "Business Billing" Page 
	
	When I wait for "3" Seconds 
	Then I should see "title" named as "Almost Done" on "Business Confirmation" Page 
	And I click on "button" "NEXT" on "Business Confirmation" Page 
#	When I fill details in "Vendor Payment Information" page 
#	And I click on "button" "NEXT" on "Vendor Payment Information" Page 
	
	
	Then I should see the sponsor logo in the header "VendorLogo" 
	And I should see Customer support "number" in the header 
	And I should see Customer support "email" in the header 
	Then I should click "SupportLink" in the footer 
	And I should click "FactActLink" in the footer 
	And I should click "LegalLink" in the footer 
	And I should click "PrivacyPolice" in the footer 
	And I should see "FadvTrademark" in the footer of the page 
	
	When I should fill details in "Business Signature" page 
	And I click on "button" "Submit" on "Business Signature" Page 
	Then I close browser 
	
	
#***************************Business Signature**********************************************
@VendorOnboardingErrorMessages
@errorMessageReg 
@ErrorMessagesValidationOnBusinessSignaturePage 
Scenario: NewUIVendorRegistration_SC06-VendorRegistration-NewUI Business Signature Page Invalid 
	Given I initialize Browser 
	And I am executing "NewUIVendorRegistration_SC06-VendorRegistration-NewUI Business Signature Page Invalid" 
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
	When I should fill details in "Business Billing" page 
	And I click on "button" "NEXT" on "Business Billing" Page 
	
	When I wait for "3" Seconds 
	Then I should see "title" named as "Almost Done" on "Business Confirmation" Page 
	And I click on "button" "NEXT" on "Business Confirmation" Page 
#	When I fill details in "Vendor Payment Information" page 
#	And I click on "button" "NEXT" on "Vendor Payment Information" Page 
	
	And I should see "text" named as "You must agree to use of electronic signature agreement." on "Business Signature" Page 
	And I click on "tickbox" "adopAndSign" on "Business Signature" Page 
	And I click on "button" "Submit" on "Business Signature" Page 
	And I should see "text" named as "Signature is required" on "Business Signature" Page 
	Then I close browser 
	
