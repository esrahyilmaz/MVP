Feature: Regression NewUI Self Screening Registration Workflow - User Profile Page 

	#^^^^^^^^^^^^^^^^^^^^^^^^^^^^^Self Screening User Profile^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
@301SelfRegression @SelfUserProfilePage @SelfUserProfile
Scenario: NewUISelfScreeningWorkflow_SC01-SelfScreeningWorkflow-NewUI User Profile Page 
	Given I initialize Browser 
	And I am executing "NewUISelfScreeningWorkflow_SC01-SelfScreeningWorkflow-NewUI User Profile Page" 
	And I navigate to "SelfScreeningWorkflow" application 
	
	And I click on "signupbutton" "Sign up" on "login page" Page 
	And I should see "text" named as "Self Screening" on "Initial" Page 
	And I click on "button" "Next" on "Initial" Page 
	
	Then I should see "title" named as "User Profile" on "User Profile" Page 
	Then I should see the sponsor logo in the header "VendorLogo" 
	And I should see Customer support "number" in the header 
	And I should see Customer support "email" in the header 
	Then I should click "SupportLink" in the footer 
	And I should click "FactActLink" in the footer 
	And I should click "LegalLink" in the footer 
	And I should click "PrivacyPolice" in the footer 
	And I should see "FadvTrademark" in the footer of the page 
	When I should fill details in "User Profile" page 
	And I click on "button" "NEXT" on "User Profile" Page 
	Then I close browser 
	
	
	#******************Validation of Error Message UserProfile Page*******************************************
@SelferrorMessageReg @selferrorTextMessageOnUserProfilePage @SelfUserProfile
Scenario: NewUISelfScreeningWorkflow_SC01-SelfScreeningWorkflow User Profile Page error message validation 
	Given I initialize Browser 
	And I am executing "NewUISelfScreeningWorkflow_SC01-SelfScreeningWorkflow User Profile Page error message validation" 
	And I navigate to "SelfScreeningWorkflow" application 
	And I click on "signupbutton" "Sign up" on "login page" Page 
	And I should see "text" named as "Self Screening" on "Initial" Page 
	And I click on "button" "Next" on "Initial" Page 
	
	When I wait for "3" Seconds 
	When I clear all fields in "User Profile" Page 
	And I click on "button" "NEXT" on "User Profile" Page 
	
	And I should see "text" named as "First Name is required" on "User Profile" Page 
	And I should see "text" named as "Last Name is required" on "User Profile" Page 
	And I should see "text" named as "Email is required" on "User Profile" Page 
	And I should see "text" named as "Password must meet all criteria" on "User Profile" Page 
	And I should see "text" named as "Confirm password is required" on "User Profile" Page 
	Then I should see "text" named as "User ID is required" on "User Profile" Page 
	And I should see "text" named as "Secret Question is required" on "User Profile" Page 
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
	And I enter "existing" value for "UserID" textbox on "User Profile" Page NewUI 
	And I should see "text" named as "User ID is Taken" on "User Profile" Page 
	And I enter "max" value for "UserID" textbox on "User Profile" Page NewUI 
	And I should see "text" named as "Max length (30) exceeded" on "User Profile" Page 
	
	And I enter "valid" value for "password" textbox on "User Profile" Page NewUI 
	And I enter "invalid" value for "confirm password" textbox on "User Profile" Page NewUI 
	And I should see "text" named as "Passwords do not match" on "User Profile" Page 
	And I should see "text" named as "Min length (8) not met" on "User Profile" Page 
	Then I close browser 
	
