Feature: Regression NewUI Self Screening Registration Workflow - Review Information page

  	#***************************Self Screening Review Information Page**********************************************
@301SelfRegression   @SelfReviewInformationPage 
Scenario: NewUISelfScreeningWorkflow_SC03-SelfScreeningWorkflow Review Information page 
	Given I initialize Browser 
	And I am executing "NewUISelfScreeningWorkflow_SC03-SelfScreeningWorkflow Review Information page" 
	And I navigate to "SelfScreeningWorkflow" application
	And I click on "signupbutton" "Sign up" on "login page" Page
	And I should see "text" named as "Self Screening" on "Initial" Page
	And I click on "button" "Next" on "Initial" Page
	Then I should see "title" named as "User Profile" on "User Profile" Page
	When I should fill details in "User Profile" page 
	And I click on "button" "NEXT" on "User Profile" Page 
	
	Then I should see "title" named as "Personal Information" on "Personal Information" Page 
	When I should fill details in "Personal Information" page 
	And I click on "button" "NEXT" on "Personal Information" Page 
	
	Then I should see "title" named as "Review Information" on "Review Information" Page 
	And I should see "text" named as "We just need to confirm your information. Does the information below look correct?" on "Review Information" Page
	
	And I should see "text" named as "Personal Information" on "Review Information" Page 
	And I should see "text" named as "Name" on "Review Information" Page 
	And I should see "text" named as "Address" on "Review Information" Page 
	And I should see "text" named as "UNITED STATES" on "Review Information" Page
	And I should see "button" named as "Edit" on "Review Information" Page 
	When I click on "button-edit" "Edit" on "Review Information" Page 
	When I wait for "3" Seconds 
	Then I should see "title" named as "Personal Information" on "Personal Information" Page
	And I click on "button" "NEXT" on "Personal Information" Page 

    And I should see "text" named as "Personal Information" on "Review Information" Page
    And I should see "text" named as "User ID" on "Review Information" Page 
	And I should see "text" named as "Password" on "Review Information" Page
	And I should see "text" named as "Secret Question" on "Review Information" Page 
	And I should see "text" named as "Secret Answer" on "Review Information" Page
	When I click on "button-edits" "Edit" on "Review Information" Page
	When I wait for "3" Seconds
	Then I should see "title" named as "User Profile" on "User Profile" Page
	And I click on "button" "NEXT" on "User Profile" Page
	And I click on "button" "NEXT" on "Personal Information" Page
	
	And I should see "text" named as "Identification Documents" on "Review Information" Page
	And I should see "text" named as "Country" on "Review Information" Page 
	And I should see "text" named as "Document Type" on "Review Information" Page
	And I should see "text" named as "Document Number" on "Review Information" Page
	And I should see "text" named as "SSN" on "Review Information" Page
	When I click on "button-editc" "Edit" on "Review Information" Page
	Then I should see "title" named as "Personal Information" on "Personal Information" Page
	And I click on "button" "NEXT" on "Personal Information" Page 
	Then I should see "title" named as "Review Information" on "Review Information" Page
	And I click on "button" "NEXT" on "Review Information" Page 
    Then I close browser 
    
    
    