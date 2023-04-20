Feature: Regression NewUI Vendor Onboarding Registration - Business Confirmation Page 

#***************************Business Confirmation Page**********************************************
@VendorOnboarding
@301Regression 
@BusinessConfirmationPage
Scenario: NewUIVendorRegistration_SC05-VendorRegistration-NewUI Business Confirmation Page 
	Given I initialize Browser 
	And I am executing "NewUIVendorRegistration_SC05-VendorRegistration-NewUI Business Confirmation Page" 
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
	When I wait for "5" Seconds 
	And I click on "button" "NEXT" on "Business Billing" Page 
	
	When I wait for "3" Seconds 
	Then I should see "title" named as "Almost Done" on "Business Confirmation" Page 
	And I should see "text" named as "Business Information" on "Business Confirmation" Page 
	And I should see "text" named as "Name" on "Business Confirmation" Page 
	And I should see "text" named as "Doing Business As" on "Business Confirmation" Page 
	And I should see "text" named as "Address" on "Business Confirmation" Page 
	And I should see "button" named as "Edit" on "Business Confirmation" Page 
	When I click on "button-edit" "Edit" on "Business Confirmation" Page 
	When I wait for "3" Seconds 
	Then I should see "title" named as "Business Information" on "Business Information" Page 
	And I click on "button" "NEXT" on "Business Information" Page 
	And I click on "button" "NEXT" on "Business Contact" Page 
	And I click on "button" "NEXT" on "Business Billing" Page 
	
	And I should see "text" named as "Contacts" on "Business Confirmation" Page 
	And I should see "text" named as "Name" on "Business Confirmation" Page 
	And I should see "button" named as "Edit" on "Business Confirmation" Page 
	When I click on "button-editb" "Edit" on "Business Confirmation" Page 
	Then I should see "title" named as "Business Contact" on "Business Contact" Page 
	And I click on "button" "NEXT" on "Business Contact" Page 
	And I click on "button" "NEXT" on "Business Billing" Page 
	
	And I should see "text" named as "Billing Contact Information" on "Business Confirmation" Page 
	And I should see "text" named as "Name" on "Business Confirmation" Page 
	And I should see "button" named as "Edit" on "Business Confirmation" Page 
	When I click on "button-editc" "Edit" on "Business Confirmation" Page 
	Then I should see "title" named as "Business Billing" on "Business Billing" Page 
	And I click on "button" "NEXT" on "Business Billing" Page 
	Then I should see "title" named as "Almost Done" on "Business Confirmation" Page 
	And I click on "button" "NEXT" on "Business Confirmation" Page 
	#Then I close browser 