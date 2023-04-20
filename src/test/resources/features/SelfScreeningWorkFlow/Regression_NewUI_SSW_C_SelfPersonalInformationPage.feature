Feature: Regression NewUI Self Screening Registration Workflow - Personal Information page 

	#^^^^^^^^^^^^^^^^^^^^^^^^^^^^^Personal Information^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
@301SelfRegression @SelfPersonalInfoPage @SelfPersolan
Scenario: NewUISelfScreeningWorkflow_SC02-SelfScreeningWorkflow Personal Information page 
	Given I initialize Browser 
	And I am executing "NewUISelfScreeningWorkflow_SC02-SelfScreeningWorkflow Personal Information page" 
	And I navigate to "SelfScreeningWorkflow" application 
	And I click on "signupbutton" "Sign up" on "login page" Page 
	#And I should see "text" named as "Self Screening" on "Initial" Page 
	And I click on "button" "Next" on "Initial" Page 
	Then I should see "title" named as "User Profile" on "User Profile" Page 
	When I should fill details in "User Profile" page 
	And I click on "button" "NEXT" on "User Profile" Page 
	
	Then I should see "title" named as "Personal Information" on "Personal Information" Page 
	Then I should see the sponsor logo in the header "VendorLogo" 
	And I should see Customer support "number" in the header 
	And I should see Customer support "email" in the header 
	Then I should click "SupportLink" in the footer 
	And I should click "FactActLink" in the footer 
	And I should click "LegalLink" in the footer 
	And I should click "PrivacyPolice" in the footer 
	And I should see "FadvTrademark" in the footer of the page 
	When I should fill details in "Personal Information" page 
	And I click on "button" "NEXT" on "Personal Information" Page 
	Then I close browser 
	
	#******************Validation of Error Messages  Personal Information Page*******************************************
@SelferrorMessageReg @SelfPersonalPageErorrMessage @SelfPersolan
Scenario: NewUISelfScreeningWorkflow_SC02-SelfScreeningWorkflow Personal Information page error message validation 
	Given I initialize Browser 
	And I am executing "NewUISelfScreeningWorkflow_SC02-SelfScreeningWorkflow Personal Information page error message validation" 
	And I navigate to "SelfScreeningWorkflow" application 
	And I click on "signupbutton" "Sign up" on "login page" Page 
	And I should see "text" named as "Self Screening" on "Initial" Page 
	And I click on "button" "Next" on "Initial" Page 
	
	Then I should see "title" named as "User Profile" on "User Profile" Page 
	When I should fill details in "User Profile" page 
	And I click on "button" "NEXT" on "User Profile" Page 
	
	When I clear all fields in "Personal Information" Page 
	And I click on "button" "NEXT" on "Personal Information" Page 
	And I should see "text" named as "First Name is required" on "Personal Information" Page 
	And I should see "text" named as "Last Name is required" on "Personal Information" Page 
	#And I should see "text" named as "Date of Birth is required" on "Personal Information" Page 
	#	And I should see "text" named as "Email is required" on "Personal Information" Page 
	And I should see "text" named as "Confirm Email Address is required" on "Personal Information" Page 
	And I should see "text" named as "Country is required" on "Personal Information" Page 
	And I should see "text" named as "Address Line 1 is required" on "Personal Information" Page 
	And I should see "text" named as "State / Region is required" on "Personal Information" Page 
	
	And I should see "text" named as "City / Town is required" on "Personal Information" Page 
	And I should see "text" named as "Postal Code is required" on "Personal Information" Page 
	And I should see "text" named as "Country is required" on "Personal Information" Page 
	And I should see "text" named as "Document Type is required" on "Personal Information" Page 
	
	And I should see "text" named as "Document Number is required" on "Personal Information" Page 
	And I should see "text" named as "Confirm Document Number is required" on "Personal Information" Page 
	Then I close browser 
	
	
 