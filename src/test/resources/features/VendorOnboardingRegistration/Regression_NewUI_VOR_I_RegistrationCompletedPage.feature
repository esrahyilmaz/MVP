Feature: Regression NewUI Vendor Onboarding Registration - Registration Completed Page 

#^^^^^^^^^^^^^^^^^^^^^^^^^^^^^Vendor Registration Complete Page^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 
@VendorOnboarding
@301Regression 
@RegistrationComplete
Scenario: NewUIVendorRegistration_SC08-VendorRegistration-NewUI Registration Completed Page 
	Given I initialize Browser 
	And I am executing "NewUIVendorRegistration_SC08-VendorRegistration-NewUI Registration Completed Page" 
	And I navigate to "NewUI Vendor Registration" application 
	
	And I should see "text" named as "Have you signed up?" on "login page" Page 
	And I click on "signupbutton" "Sign up" on "login page" Page 
	
	When I wait for "5" Seconds 
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
	
	When I should fill details in "Business Signature" page 
	And I click on "button" "Submit" on "Business Signature" Page 
	
	Then I should see the sponsor logo in the header "VendorLogo" 
	And I should see Customer support "number" in the header 
	And I should see Customer support "email" in the header 
	Then I should click "SupportLink" in the footer 
	And I should click "FactActLink" in the footer 
	And I should click "LegalLink" in the footer 
	And I should click "PrivacyPolice" in the footer 
	And I should see "FadvTrademark" in the footer of the page 
	
	Then I should see icon "congratulationsIcon" on "Registration Complete" Page 
	And I should see "text" named as "Welcome to First Advantage," on "Registration Complete" Page 
	Then I should see icon "accountactivatedLogo" on "Registration Complete" Page 
	And I should see "text" named as "Your account is being activated. You may place orders within the next 3 business hours." on "Registration Complete" Page 
	And I should see "text" named as " Need to Access detailed results?" on "Registration Complete" Page 
	Then I should see icon "EmailCommunicationLogo" on "Registration Complete" Page 
	#And I should see "text" named as "Email communication will start the process. " on "Registration Complete" Page
	And I should see "text" named as " Check out our new " on "Registration Complete" Page 
	And I should see "text" named as "This wealth of information includes FAQs and step-by-step guides to help with any questions you may have." on "Registration Complete" Page 
	And I click on "linktext" "Login" on "Registration Complete" Page 
	Then I close browser 
	
     