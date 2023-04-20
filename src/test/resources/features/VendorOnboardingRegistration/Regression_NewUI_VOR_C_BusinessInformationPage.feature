Feature: Regression NewUI Vendor Onboarding Registration - Business Information Page 

#^^^^^^^^^^^^^^^^^^^^^^^^^^^^^Business Information^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
@VendorOnboarding
@301Regression
@BusinessInfoPage
Scenario: NewUIVendorRegistration_SC02-VendorRegistration-NewUI Business Info Page 
	Given I initialize Browser 
	And I am executing "NewUIVendorRegistration_SC02-VendorRegistration-NewUI Business Info Page" 
	And I navigate to "NewUI Vendor Registration" application 
	
	And I should see "text" named as "Have you signed up?" on "login page" Page 
	And I click on "signupbutton" "Sign up" on "login page" Page 
	When I wait for "5" Seconds 
	And I click on "button" "Let's Begin! " on "User Profile" Page 
	When I should fill details in "User Profile" page 
	And I click on "button" "NEXT" on "User Profile" Page 
	
	Then I should see "title" named as "Business Information" on "Business Information" Page 
	Then I should see the sponsor logo in the header "VendorLogo" 
	And I should see Customer support "number" in the header 
	And I should see Customer support "email" in the header 
	Then I should click "SupportLink" in the footer 
	And I should click "FactActLink" in the footer 
	And I should click "LegalLink" in the footer 
	And I should click "PrivacyPolice" in the footer 
	And I should see "FadvTrademark" in the footer of the page 
	When I should fill details in "Business Information" page 
	And I click on "button" "NEXT" on "Business Information" Page 
	Then I close browser 
	
#******************Error Message OnBusinessInfoPage*******************************************
@VendorOnboardingErrorMessages
@errorMessageReg 
@ErrorMessagesValidationOnBusinessInfoPage 
Scenario: NewUIVendorRegistration_SC02-VendorRegistration-NewUI Business Info Page Invalid 
	Given I initialize Browser 
	And I am executing "NewUIVendorRegistration_SC02-VendorRegistration-NewUI Business Info Page Invalid" 
	And I navigate to "NewUI Vendor Registration" application 
	
	And I should see "text" named as "Have you signed up?" on "login page" Page 
	And I click on "signupbutton" "Sign up" on "login page" Page 

	And I click on "button" "Let's Begin! " on "User Profile" Page 
	When I should fill details in "User Profile" page 
	And I click on "button" "NEXT" on "User Profile" Page 
	
	When I clear all fields in "Business Information" Page 
	And I click on "button" "NEXT" on "Business Information" Page 
	
	 And Verify PlaceHolder Value for "Business Name *" on "Business Information" Page
   # And Verify PlaceHolder Value for "Doing Business as ("DBA") Name" on "Business Information" Page
    And Verify PlaceHolder Value for "Ownership Info" on "Business Information" Page
	
	And I should see "text" named as "Business Name is required" on "Business Information" Page 
	And I should see "text" named as "Business Type is required" on "Business Information" Page 
	
	And I should see "text" named as "Employment Purpose is required" on "Business Information" Page 
	And I should see "text" named as "Volunteer" on "Business Information" Page
	And I should see "text" named as "Contractor" on "Business Information" Page
	And I should see "text" named as "Business Description is required" on "Business Information" Page 
	
	And I should see "text" named as "Country is required" on "Business Information" Page 
	And I should see "text" named as "Address Line 1 is required" on "Business Information" Page
	And I should see "text" named as "State is required" on "Business Information" Page
	And I should see "text" named as "City is required" on "Business Information" Page 
	
	And I select "United States" on "Business Information" page
	And I should see "text" named as "Zip Code is required" on "Business Information" Page 
#	And Verify PlaceHolder Value for "Social Security Number" on "Business Information" Page
#	And I enter ">9<" value for "SNN" textbox on "Business Information" Page NewUI 
#	And I should see "text" named as "Must be 9 digits" on "Business Information" Page 
	
	Then I close browser 
	