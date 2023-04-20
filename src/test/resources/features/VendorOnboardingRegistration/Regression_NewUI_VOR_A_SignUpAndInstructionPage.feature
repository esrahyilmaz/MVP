Feature: Regression NewUI Vendor Onboarding Registration - Sign Up And Instruction Page 

#******************Verify the sign-up option is not available when API Program set to Registration*******************************************
@VendorOnboarding
@loginNoSignupApiRegis 
@US1954 
@ID19760 
@TC3791 
Scenario: NewUIVendorRegistration_SC00-VendorRegistration-NewUI Sign Up should not appear 
	Given I initialize Browser 
	And I am executing "NewUIVendorRegistration_SC00-VendorRegistration-NewUI Sign Up should not appear" 
	And I navigate to "NewUI Vendor Registration" application 
	
	Then I open only a new tab 
	Then I switch between tabs "child" 
	And I navigate to "Admin tool-QCSA" application 
	And I log in to admin tool select customer "XTDAUTOQCSA" for "QCSA" 
	And I update Property "XTDFORCE_API_PROGRAM" to "Registration" 
	Then I close open tabs "child" 
	And I clear the cache 
	And Refresh The Page 
	And I should not see Text "Have you signed up?" 
	And I should not see "button-newui" named as " Sign up " on "login page" Page 
	Then I close browser 
	
	
#******************Verify the sign-up option is not available when API Program set to Both*******************************************
@VendorOnboarding
@loginNoSignupApiBoth 
@US1954 
@ID19760 
@TC3793 
Scenario: NewUIVendorRegistration_SC00-VendorRegistration-NewUI Sign Up should not appear Api Both 
	Given I initialize Browser 
	And I am executing "NewUIVendorRegistration_SC00-VendorRegistration-NewUI Sign Up should not appear Api Both" 
	And I navigate to "NewUI Vendor Registration" application 
	
	Then I open only a new tab 
	Then I switch between tabs "child" 
	And I navigate to "Admin tool-QCSA" application 
	And I log in to admin tool select customer "XTDAUTOQCSA" for "QCSA" 
	And I update Property "XTDFORCE_API_PROGRAM" to "Both" 
	Then I close open tabs "child" 
	And I clear the cache 
	And Refresh The Page 
	And I should not see Text "Have you signed up?" 
	And I should not see "button-newui" named as " Sign up " on "login page" Page 
	Then I close browser 
	
#******************Verify the sign-up option is available when API Program set to Null*******************************************
@VendorOnboarding
@loginNoSignupApiNull 
@US1954 
@ID19760 
@TC3795 
Scenario: NewUIVendorRegistration_SC00-VendorRegistration-NewUI Sign Up should not appear Api Null 
	Given I initialize Browser 
	And I am executing "NewUIVendorRegistration_SC00-VendorRegistration-NewUI Sign Up should not appear Api Null" 
	And I navigate to "NewUI Vendor Registration" application 
	
	Then I open only a new tab 
	Then I switch between tabs "child" 
	And I navigate to "Admin tool-QCSA" application 
	And I log in to admin tool select customer "XTDAUTOQCSA" for "QCSA" 
	And I update Property "XTDFORCE_API_PROGRAM" to "Null" 
	Then I close open tabs "child" 
	And I clear the cache 
	And Refresh The Page 
	And I should see "text" named as "Have you signed up?" on "login page" Page 
	And I should see element "Sign up" 
	Then I close browser 
	
#*********************************************************************************************************************************#		
@VendorOnboarding	
@301Regression 
@VendorSignUp 
Scenario: NewUIVendorRegistration_SC00-VendorRegistration-NewUI Sign Up UI
	Given I initialize Browser 
	And I am executing "NewUIVendorRegistration_SC00-VendorRegistration-NewUI Sign Up UI" 
	And I navigate to "NewUI Vendor Registration" application 
	
	Then I open only a new tab 
	Then I switch between tabs "child" 
	And I navigate to "Admin tool-QCSA" application 
	And I log in to admin tool select customer "XTDAUTOQCSA" for "QCSA" 
	And I update Property "XTDFORCE_API_PROGRAM" to "Null" 
	Then I close open tabs "child" 
	And I clear the cache 
	And Refresh The Page 
	
	And I should see element "login page" 
	And I should see "text" named as "Have you signed up?" on "login page" Page 
	#Note: If we want to execute through UI then we should uncommented all line'signupbutton' on every bellow scenarios.
	And I click on "signupbutton" "Sign up" on "login page" Page 
	
	And I should see "text" named as "Company" on "Initial" Page 
	And I should see "text" named as "I am signing up my company and screening my people" on "Initial" Page 
	#And I should see "text" named as "Great! Let�s get started " on "Initial" Page 
	And I should see "text" named as "Registering will take 5 minutes." on "Initial" Page 
	And I should see "text" named as "We recommend preparing the following, before you begin:" on "Initial" Page 
	And I should see "text" named as "Legal Business Information" on "Initial" Page 
	And I should see "text" named as "Primary Contact Information" on "Initial" Page 
	And I should see "text" named as "Billing Information" on "Initial" Page 
	And I should see "text" named as "Signatory Rights" on "Initial" Page 
	And I should see "text" named as "Please Note" on "Initial" Page 
	Then I should see "text" named as "Once your registration starts, you will not be able to end your session without losing your progress." on "Initial" Page
	

	And I should see Customer support "number" in the header 
	And I should see Customer support "email" in the header 
	Then I should click "SupportLink" in the footer 
	And I should click "FactActLink" in the footer 
	And I should click "LegalLink" in the footer 
	And I should click "PrivacyPolice" in the footer 
	And I should see "FadvTrademark" in the footer of the page 
	
	And I click on "button-newui" "Previous" on "Initial" Page
	And I should see element "login page" 
	And I should see "text" named as "Have you signed up?" on "login page" Page 
	And I click on "signupbutton" "Sign up" on "login page" Page 
	
	And I should see "text" named as "Company" on "Initial" Page 
	
	And I click on "button" "Let's Begin! " on "User Profile" Page 
	Then I close browser 
	
#*********************************************************************************************************************************#		
@VendorOnboardingAPI
@301APIRegression 
@APIVendorSignUp 
Scenario: NewUIVendorRegistration_SC00-VendorRegistration-NewUI Sign Up Api
	Given I initialize Browser 
	And I am executing "NewUIVendorRegistration_SC00-VendorRegistration-NewUI Sign Up Api" 
#	
#	Then I open only a new tab 
#	Then I switch between tabs "child" 
#	And I navigate to "Admin tool-QCSA" application 
#	And I log in to admin tool select customer "XTDAUTOQCSA" for "QCSA" 
#	And I update Property "XTDFORCE_API_PROGRAM" to "Registration" 
#	Then I close open tabs "child" 
#	And I clear the cache 
#	And Refresh The Page 

And ExecuteTestScenario 
		| ******* ^TC01:Post XML And Verify order request with Valid Pos Loc and 3 Quoteback Value ^ ******* |
	Then Set Position Hire Property Dynamic 
		|Value|CustId|
		|Y    |1364 |
		
		
		Then Update PA Order xml 
		|xmlPath                                         |FN  |LN  |DOB|EmailId|SSN|PosLoc|City|SSNFlag|NameType|Address1|City|State|Zipcode|
		|./src/test/resources/Xml/VendorRegistrationAutoQcsa.xml|Yes |Yes | |    | |  | |   |         |        |    |     |       |
	
#Then Update Auto Qcsa xml Order
#		|xmlPath                                         |FN  |LN  |	
#		|./src/test/resources/Xml/VendorRegistrationAutoQcsa.xml|Yes |Yes |
	Then POST xml 
		|XML                           							|URL                                                    |
		|./src/test/resources/Xml/VendorRegistrationAutoQcsa.xml|https://qcsa.fadv.net/CSServices/CScreening/PassService|
		
	Then Get URL Link from Api post
	And I navigate to "AutoQcsaVendorApi" application
	And I should see "text" named as "Company" on "Initial" Page 
	And I should see "text" named as "I am signing up my company and screening my people" on "Initial" Page 
	#And I should see "text" named as "Great! Let�s get started " on "Initial" Page 
	And I should see "text" named as "Registering will take 5 minutes." on "Initial" Page 
	And I should see "text" named as "We recommend preparing the following, before you begin:" on "Initial" Page 
	And I should see "text" named as "Legal Business Information" on "Initial" Page 
	And I should see "text" named as "Primary Contact Information" on "Initial" Page 
	And I should see "text" named as "Billing Information" on "Initial" Page 
	And I should see "text" named as "Signatory Rights" on "Initial" Page 
	And I should see "text" named as "Please Note" on "Initial" Page 
	Then I should see "text" named as "Once your registration starts, you will not be able to end your session without losing your progress." on "Initial" Page
	
	And I should see Customer support "number" in the header 
	And I should see Customer support "email" in the header 
	Then I should click "SupportLink" in the footer 
	And I should click "FactActLink" in the footer 
	And I should click "LegalLink" in the footer 
	And I should click "PrivacyPolice" in the footer 
	And I should see "FadvTrademark" in the footer of the page 
	
	And I should see element "Previous" for "Disabled"
	
	And I click on "button" "Let's Begin! " on "User Profile" Page 
	When I wait for "5" Seconds
	
	#Then I close browser 
	