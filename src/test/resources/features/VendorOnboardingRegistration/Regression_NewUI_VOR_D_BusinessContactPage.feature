Feature: Regression NewUI Vendor Onboarding Registration - Business Contact Page 

#^^^^^^^^^^^^^^^^^^^^^^^^^^^^^Business Contact Page^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
@VendorOnboarding
@301Regression 
@BusinessContactPage 
Scenario: NewUIVendorRegistration_SC03-VendorRegistration-NewUI Business Contact Page 
	Given I initialize Browser 
	And I am executing "NewUIVendorRegistration_SC03-VendorRegistration-NewUI Business Contact Page" 
	And I navigate to "NewUI Vendor Registration" application 
	
	And I should see "text" named as "Have you signed up?" on "login page" Page 
	And I click on "signupbutton" "Sign up" on "login page" Page 
	When I wait for "5" Seconds 
	And I click on "button" "Let's Begin! " on "User Profile" Page 
	When I should fill details in "User Profile" page 
	And I click on "button" "NEXT" on "User Profile" Page 
	When I should fill details in "Business Information" page 
	And I click on "button" "NEXT" on "Business Information" Page 
	
	Then I should see "title" named as "Business Contact" on "Business Contact" Page 
	Then I should see the sponsor logo in the header "VendorLogo" 
	And I should see Customer support "number" in the header 
	And I should see Customer support "email" in the header 
	Then I should click "SupportLink" in the footer 
	And I should click "FactActLink" in the footer 
	And I should click "LegalLink" in the footer 
	And I should click "PrivacyPolice" in the footer 
	And I should see "FadvTrademark" in the footer of the page 
	
	When I should fill details in "Business Contact" page 
	When I should fill details in "Secondary Business Contact" page 
	And I click on "button" "NEXT" on "Business Contact" Page 
	Then I close browser 
	
#****************Error message on business contact***************************
@VendorOnboardingErrorMessages
@errorMessageReg 
@ErrorMessagesValidationOnBusinessContPage 
Scenario: NewUIVendorRegistration_SC03-VendorRegistration-NewUI Business Contact Page Invalid 
	Given I initialize Browser 
	And I am executing "NewUIVendorRegistration_SC03-VendorRegistration-NewUI Business Contact Page Invalid" 
	And I navigate to "NewUI Vendor Registration" application 
	
	And I should see "text" named as "Have you signed up?" on "login page" Page 
	And I click on "signupbutton" "Sign up" on "login page" Page 
	When I wait for "2" Seconds 
	And I click on "button" "Let's Begin! " on "User Profile" Page 
	
	When I should fill details in "User Profile" page 
	And I click on "button" "NEXT" on "User Profile" Page 
	When I should fill details in "Business Information" page 
	And I click on "button" "NEXT" on "Business Information" Page 
	When I wait for "2" Seconds 
	
	When I clear all fields in "Business Contact" Page 
	And I click on "button" "NEXT" on "Business Contact" Page 
	And I should see "text" named as "First Name is required" on "Business Contact" Page 
	And I should see "text" named as "Last Name is required" on "Business Contact" Page 
	And I should see "text" named as "Title is required" on "Business Contact" Page 
	And I should see "text" named as "A valid email is required" on "Business Contact" Page 
	And I should see "text" named as "Country is required" on "Business Contact" Page 
	And I should see "text" named as "Calling Code is required" on "Business Contact" Page 
	And I should see "text" named as "Phone Number is required" on "Business Contact" Page 
	
    And I enter "a" value for "FirstName" textbox on "Business Contact" Page NewUI
    And I should not see "errormsg-newui" named as "Min length required" on "Business Contact" Page 
	
	And I enter "max" value for "FirstName" textbox on "Business Contact" Page NewUI 
	And I should see "text" named as "Max length (50) exceeded" on "Business Contact" Page 
	And I enter "max" value for "lastName" textbox on "Business Contact" Page NewUI 
	And I should see "text" named as "Max length (50) exceeded" on "Business Contact" Page 
	And I enter "max" value for "Title" textbox on "Business Contact" Page NewUI 
	And I should see "text" named as "Max length (20) exceeded" on "Business Contact" Page 
	
	And I select "United States" on "Business Contact" page
	And I enter "invalidPhoneNumber" value for "PhoneNumber" textbox on "Business Contact" Page NewUI
	And I should see "errormsg-newui" named as "Phone number must be 10 digits" on "Business Contact" Page

	And I click on "button-newui" "expandSecondarypage" on "Business Contact" Page
	And I click on "button" "NEXT" on "Business Contact" Page 
	
	And I should see "text" named as "First Name is required" on "Secondary Business Contact" Page 
	And I should see "text" named as "Last Name is required" on "Secondary Business Contact" Page 
	And I should see "text" named as "Title is required" on "Secondary Business Contact" Page 
	And I should see "text" named as "A valid email is required" on "Secondary Business Contact" Page 
	And I should see "text" named as "Country is required" on "Secondary Business Contact" Page 
	And I should see "text" named as "Calling Code is required" on "Secondary Business Contact" Page 
	And I should see "text" named as "Phone Number is required" on "Secondary Business Contact" Page 
	
#	And I click on "button-newui" "SecondaryMiddleNameYes" on "Page Business Contact" Page
#    And I should see "errormsg-newui" named as "Middle name is required" on "Secondary Business Contact" Page
#    And I enter "max" value for "SecondaryMiddleName" textbox on "Secondary Business Contact" Page NewUI
#    And I should see "errormsg-newui" named as "Max length (50) exceeded" on "Secondary Business Contact" Page
   
    And I enter "b" value for "SecondaryFirstName" textbox on "Secondary Business Contact" Page NewUI
    And I should not see "errormsg-newui" named as "Min length required" on "Secondary Business Contact" Page 
	
	And I enter "max" value for "SecondaryFirstName" textbox on "Secondary Business Contact" Page NewUI 
	And I should see "text" named as "Max length (50) exceeded" on "Secondary Business Contact" Page 
	And I enter "max" value for "SecondarylastName" textbox on "Secondary Business Contact" Page NewUI 
	And I should see "text" named as "Max length (50) exceeded" on "Secondary Business Contact" Page 
	And I enter "max" value for "SecondaryTitle" textbox on "Secondary Business Contact" Page NewUI 
	And I should see "text" named as "Max length (20) exceeded" on "Secondary Business Contact" Page 
	
	And I select "United States" on "Secondary Business Contact" page
	And I enter "invalidSecondaryPhoneNumber" value for "SecondaryPhoneNumber" textbox on "Secondary Business Contact" Page NewUI
	And I should see "errormsg-newui" named as "Phone number must be 10 digits" on "Secondary Business Contact" Page
	Then I close browser 
	
