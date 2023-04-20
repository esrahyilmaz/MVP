Feature: Regression NewUI Self Screening Registration Workflow - Sign Up And Instruction Page 

@SelfSignUp 
Scenario: NewUISelfScreeningWorkflow_SC00-SelfScreeningWorkflow Sign Up 
	Given I initialize Browser 
	And I am executing "NewUISelfScreeningWorkflow_SC00-SelfScreeningWorkflow Sign Up" 
	And I navigate to "SelfScreeningWorkflow" application 
	
	Then I open only a new tab 
	Then I switch between tabs "child" 
	And I navigate to "Admin tool-QCSA" application 
	And I log in to admin tool select customer "XTDAUTOQCSA" for "QCSA" 
	And I update Property "XTDFORCE_API_PROGRAM" to "Null" 
	And I update Property "VENDOR_REGISTRATION_WORKFLOW_ENABLED" to "SELF"
	Then I close open tabs "child" 
	And I clear the cache 
	And Refresh The Page 
	
	And I should see element "login page" 
	And I should see "text" named as "Have you signed up?" on "login page" Page 
	And I click on "signupbutton" "Sign up" on "login page" Page 
	
	And I should see Customer support "number" in the header 
	And I should see Customer support "email" in the header 
	Then I should click "SupportLink" in the footer 
	And I should click "FactActLink" in the footer 
	And I should click "LegalLink" in the footer 
	And I should click "PrivacyPolice" in the footer 
	And I should see "FadvTrademark" in the footer of the page 
	
	And I should see "text" named as "Self Screening" on "Initial" Page 
	And I should see "text" named as "I am screening myself" on "Initial" Page 
	#And I should see "text" named as "Awesome! Let's get started" on "Initial" Page 
	And I should see "text" named as "This process will take 5 minutes." on "Initial" Page 
	And I should see "text" named as "We recommend collecting the following information before you begin:" on "Initial" Page 
	And I should see "text" named as "Your Personal Information" on "Initial" Page 
	And I should see "text" named as "Legal Name" on "Initial" Page 
	And I should see "text" named as "Government ID" on "Initial" Page 
	And I should see "text" named as "Legal Address" on "Initial" Page 
	And I should see "text" named as "Method of Payment" on "Initial" Page 
	And I should see "text" named as "Please Note" on "Initial" Page 
	Then I should see "text" named as "Once your registration starts, you will not be able to end your session without losing your progress." on "Initial" Page 
	And I click on "button" "Next" on "Initial" Page 
	Then I close browser 