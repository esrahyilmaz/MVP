Feature: Regression NewUI Vendor Onboarding Registration - Vendor Payment Information Page 

#***************************Vendor Payment**********************************************

Scenario: NewUIVendorRegistration_SC06-VendorRegistration-NewUI Vendor Payment Information Page 
	Given I initialize Browser 
	And I am executing "NewUIVendorRegistration_SC06-VendorRegistration-NewUI Vendor Payment Information Page" 
	And I navigate to "NewUI Vendor Registration - Sing Up" application 
	
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
	
	When I wait for "2" Seconds 
	Then I should see "title" named as "Almost Done" on "Business Confirmation" Page 
	And I click on "button" "NEXT" on "Business Confirmation" Page 
	
	Then I should see the sponsor logo in the header "VendorLogo" 
	And I should see Customer support "number" in the header 
	And I should see Customer support "email" in the header 
	Then I should click "SupportLink" in the footer 
	And I should click "FactActLink" in the footer 
	And I should click "LegalLink" in the footer 
	And I should click "PrivacyPolice" in the footer 
	And I should see "FadvTrademark" in the footer of the page 
	
	#*************Payment without fee**********************
	Then I should see "title" named as "Payment Method" on "Vendor Payment Information" Page 
	And I should see "text" named as "Please chose one of the save credit cards or enter your Card details below." on "Vendor Payment Information" Page 
	And I should see "text" named as "Credit Card Payment" on "Vendor Payment Information" Page 
	And I should see Text "Previously used Credit Cards" 
	And I should see "text" named as "Use a new payment method" on "Vendor Payment Information" Page 
	And I should see Text "Credit Card Details" 
	
	And I click on "icon" "CSS Information" on "Payment Method" Page 
	And I should see Text "3-4 Digits on the back of your Credit Card" 
	
	And I enter "valid" value for "CardNumberMaster" textbox on "Add People" Page NewUI 
	And I should see "element" named as "master" on "Payment method" Page 
	And I enter "valid" value for "CardNumberAmex" textbox on "Add People" Page NewUI 
	And I should see "element" named as "amex" on "Payment method" Page 
	And I enter "valid" value for "CardNumberVisa" textbox on "Add People" Page NewUI 
	And I should see "element" named as "visa" on "Payment method" Page 
	
	And I clear all fields in "Payment Method" Page 
	
	When I fill details in "Vendor Payment Information" page 
	And I should see "text" named as "Save this card for future purchases" on "Vendor Payment Information" Page 
	
	#************************Payment with fee**********
	Then verify the tax details on "Vendor Payment Information" Page 
	And I click on "button" "NEXT" on "Vendor Payment Information" Page 
	Then I close browser 
	
	
	#****************Error message validation on Vendor Payment page***************************

Scenario: NewUIVendorRegistration_SC05-VendorRegistration-NewUI Vendor Payment Information Page Invalid 
	Given I initialize Browser 
	And I am executing "NewUIVendorRegistration_SC05-VendorRegistration-NewUI Vendor Payment Information Page Invalid" 
	#	And I navigate to "NewUI Vendor Registration" application 
	
	And I navigate to "NewUI Vendor Registration - Sing Up" application 
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
	
	When I wait for "2" Seconds 
	Then I should see "title" named as "Almost Done" on "Business Confirmation" Page 
	And I click on "button" "NEXT" on "Business Confirmation" Page 
	
	When I wait for "2" Seconds 
	And I click on "button" "NEXT" on "Vendor Payment Information" Page 
	
	And I should see "errormsg-newui" named as "First Name is required" for "First Name" on "Payment method" Page 
	And I should see "errormsg-newui" named as "Last Name is required" for "Last Name" on "Payment method" Page 
	And I should see "errormsg-newui" named as "Required Field" for "CC Number" on "Payment method" Page 
	And I should see "errormsg-newui" named as "Required Field" for "MM" on "Payment method" Page 
	And I should see "errormsg-newui" named as "Required Field" for "YY" on "Payment method" Page 
	And I should see "errormsg-newui" named as "Required Field" for "CSC" on "Payment method" Page 
	
	And I enter "max" value for "FN" textbox on "Your Payments" Page NewUI 
	And I should see "errormsg-newui" named as "Max length (50) exceeded" for "First Name" on "Payment method" Page 
	And I clear "FN" in "Your Payments" Page 
	And I enter "empty" value for "LN" textbox on "Add People" Page NewUI 
	And I should see "errormsg-newui" named as "Leading white-space characters not allowed" for "First Name" on "Payment method" Page 
	And I clear "FN" in "Your Payments" Page 
	
	And I enter "max" value for "LN" textbox on "Your Payments" Page NewUI 
	And I should see "errormsg-newui" named as "Max length (50) exceeded" for "Last Name" on "Payment method" Page 
	And I clear "LN" in "Your Payments" Page 
	And I enter "empty" value for "LN" textbox on "Add People" Page NewUI 
	And I should see "errormsg-newui" named as "Leading white-space characters not allowed" for "Last Name" on "Payment method" Page 
	And I clear "LN" in "Your Payments" Page 
	
	And I enter "valid" value for "CardNumberAmex" textbox on "Add People" Page NewUI 
	And I should see "element" named as "amex" on "Payment method" Page 
	And I should see "errormsg-newui" named as "Invalid security code" for "CSC" on "Payment method" Page 
	
	And I enter "invalidsupporter" value for "CardNumberVisa" textbox on "Add People" Page NewUI 
	And I should see "errormsg-newui" named as "Unsupported Credit Card Issuer" for "CC Number" on "Payment method" Page 
	And I enter "invalidlength" value for "CardNumberVisa" textbox on "Add People" Page NewUI 
	And I should see "errormsg-newui" named as "Invalid credit card number length" for "CC Number" on "Payment method" Page 
	And I enter "invalidCC" value for "CardNumberVisa" textbox on "Add People" Page NewUI 
	And I should see "errormsg-newui" named as "Invalid credit card number" for "CC Number" on "Payment method" Page 
	
	Then I close browser 
	
	#	And I should see "text" named as "First Name is required" on "Vendor Payment Information" Page 
	#	And I should see "text" named as "Last Name is required" on "Vendor Payment Information" Page 
	#	And I should see "text" named as "Required Field" on "Vendor Payment Information" Page 
	#	And I should see "text" named as "Required Field" on "Vendor Payment Information" Page 
	#	And I should see "text" named as "Required Field" on "Vendor Payment Information" Page 
	#	Then I should see "text" named as "Required Field" on "Vendor Payment Information" Page 
	#
	##	And I enter "InvalidCardNumber" value for "CardNumber" textbox on "Vendor Payment Information" Page NewUI 
	##	And I should see "text" named as "Invalid credit card number length" on "Vendor Payment Information" Page 
	#	And I enter "InvalidCSCNumber" value for "CSC" textbox on "Vendor Payment Information" Page NewUI 
	#	#And I should see "text" named as "Invalid security code" on "Vendor Payment Information" Page 
	
	
	
	
	
	#***************UI Tie Reusable Credit Card Component to Vendor Registration*************

Scenario: NewUIVendorRegistration_SC100-VendorRegistration-Tie Reusable Credit Card Component 
	Given I initialize Browser 
	And I am executing "NewUIVendorRegistration_SC100-VendorRegistration-Tie Reusable Credit Card Component" 
	And I navigate to "NewUI Vendor Registration" application 
	
	Then I open only a new tab
Then I switch between tabs "child"
And I navigate to "Admin tool-QCSA" application
And I log in to admin tool select customer "QCSAAUTOVC" for "QCSA"
And I update Property "XTDFORCE_API_PROGRAM" to "null"
And I update Property "PROGRAM_PAYMENT_METHOD" to "Credit Card"
Then I close open tabs "child"
And I clear the cache

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
	
	Then I should see "title" named as "Payment Method" on "Credit Card" Page
	
	And Verify Element "exist" with data-xf-qa-id "CCP-INPUT-FN" for "First Name"
	And Verify Element "exist" with data-xf-qa-id "CCP-INPUT-LN" for "Last Name"
	And Verify Element "exist" with data-xf-qa-id "CCC-INPUT-CN" for "Credit Card Number"
	And Verify Element "exist" with data-xf-qa-id "CCC-SELECT-EXP-M" for "Expiry Month"
	And Verify Element "exist" with data-xf-qa-id "CCC-SELECT-EXP-Y" for "Expiry Year"
	And Verify Element "exist" with data-xf-qa-id "CCC-INPUT-CSC" for "CSC"
	
	And I click on "icon" "CSS Information" on "Payment Method" Page
	And I should see Text "3-4 Digits on the back of your Credit Card"
	
	And I click on "button" "NEXT" on "Vendor Payment Information" Page
	And I should see "errormsg-newui" named as "First Name is required" for "First Name" on "Payment Method" Page
	And I should see "errormsg-newui" named as "Last Name is required" for "Last Name" on "Payment Method" Page
	And I should see "errormsg-newui" named as "Required Field" for "CC Number" on "Payment Method" Page
	And I should see "errormsg-newui" named as "Required Field" for "MM" on "Payment Method" Page
	And I should see "errormsg-newui" named as "Required Field" for "YY" on "Payment Method" Page
	And I should see "errormsg-newui" named as "Required Field" for "CSC" on "Payment Method" Page
	
	And I enter "valid" value for "FN" textbox on "pow" Page NewUI
  	And I enter "valid" value for "LN" textbox on "pow" Page NewUI
	And I enter "valid" value for "CardNumberVisa" textbox on "Add People" Page NewUI
	And I enter "valid" value for "MM" textbox on "Add People" Page NewUI
	And I enter "valid" value for "YY" textbox on "Add People" Page NewUI
	And I enter "valid" value for "CSC" textbox on "Add People" Page NewUI
	And I should see "text" named as "Save this card for future purchases" on "Vendor Payment Information" Page
	#Then I click on "checkbox" "Save CC" on "payment method" Page
	
	And I should see element "Summary" for "POW"
	And I should see element "Subtotal" for "POW"
	And I should see element "Tax" for "POW"
	And I should see element "Order Total" for "POW"
	And I should see element "Warning" for "POW"
	And I should see element "If you logout, all of the items in the cart will be lost" for "POW"
  And I should see "text-newui" named as "Subtotal" on "Shopping Cart" Page
   And Verify value "Tax" on "Payment Method" Page for DB "QCSA"
  And I should see "text-newui" named as "Tax" on "Shopping Cart" Page
  And I should see "text-newui" named as "Order Total" on "Shopping Cart" Page

	
	
	And I click on "button" "NEXT" on "Vendor Payment Information" Page
	And I should not see "button-newui" named as "Previews" on "People" Page
	
	When I should fill details in "Business Signature" page 
	And I click on "button" "Submit" on "Business Signature" Page 
	And I should see "text" named as "Welcome to First Advantage," on "Registration Complete" Page
	And I click on "linktext" "Login" on "Registration Complete" Page 
	Then I close browser 
	
	
	
#**************************API Tie Reusable Credit Card Component to Vendor Registration*****************
#******** For Api Push get the url from Soupui or postman and paste it on navigation application********

@VendorOnboardingAPI
@APITieReusableCC 
@USA17163 
Scenario: NewUIVendorRegistration_SC100-VendorRegistration-Tie Reusable Credit Card Component 
	Given I initialize Browser 
	And I am executing "NewUIVendorRegistration_SC100-VendorRegistration-Tie Reusable Credit Card Component" 
	And I navigate to "NewUI API Vendor Registration" application 
	
#	And I set "XTDFORCE_API_PROGRAM" to "Registration" where Customer "Amazon"
#	And I set "PROGRAM_PAYMENT_METHOD" to "Credit Card" where Customer "Amazon"
#	And I set "VENDOR REGISTRATION COST:" to "29" where Customer "Amazon"
	
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
	
	Then I should see "title" named as "Payment Method" on "Credit Card" Page
	
	And Verify Element "exist" with data-xf-qa-id "CCP-INPUT-FN" for "First Name"
	And Verify Element "exist" with data-xf-qa-id "CCP-INPUT-LN" for "Last Name"
	And Verify Element "exist" with data-xf-qa-id "CCC-INPUT-CN" for "Credit Card Number"
	And Verify Element "exist" with data-xf-qa-id "CCC-SELECT-EXP-M" for "Expiry Month"
	And Verify Element "exist" with data-xf-qa-id "CCC-SELECT-EXP-Y" for "Expiry Year"
	And Verify Element "exist" with data-xf-qa-id "CCC-INPUT-CSC" for "CSC"
	
	And I click on "icon" "CSS Information" on "Payment Method" Page
	And I should see Text "3-4 Digits on the back of your Credit Card"
	
	And I click on "button" "NEXT" on "Vendor Payment Information" Page
	And I should see "errormsg-newui" named as "First Name is required" for "First Name" on "Payment Method" Page
	And I should see "errormsg-newui" named as "Last Name is required" for "Last Name" on "Payment Method" Page
	And I should see "errormsg-newui" named as "Required Field" for "CC Number" on "Payment Method" Page
	And I should see "errormsg-newui" named as "Required Field" for "MM" on "Payment Method" Page
	And I should see "errormsg-newui" named as "Required Field" for "YY" on "Payment Method" Page
	And I should see "errormsg-newui" named as "Required Field" for "CSC" on "Payment Method" Page
	
	And I enter "present" value for "FN" textbox on "pow" Page NewUI
  	And I enter "present" value for "LN" textbox on "pow" Page NewUI
	And I enter "valid" value for "CardNumberVisa" textbox on "Add People" Page NewUI
	And I enter "valid" value for "MM" textbox on "Add People" Page NewUI
	And I enter "valid" value for "YY" textbox on "Add People" Page NewUI
	And I enter "valid" value for "CSC" textbox on "Add People" Page NewUI
	And I should see "text" named as "Save this card for future purchases" on "Vendor Payment Information" Page
	#Then I click on "checkbox" "Save CC" on "payment method" Page
	
	And I should see element "Summary" for "POW"
	And I should see element "Subtotal" for "POW"
	And I should see element "Tax" for "POW"
	And I should see element "Order Total" for "POW"
	And I should see element "Warning" for "POW"
	And I should see element "If you logout, all of the items in the cart will be lost" for "POW"
	
	And I click on "button" "NEXT" on "Vendor Payment Information" Page
	And I should not see "button-newui" named as "Previews" on "People" Page
	
	When I should fill details in "Business Signature" page 
	And I click on "button" "Submit" on "Business Signature" Page 
	And I should see "text" named as "Welcome to First Advantage," on "Registration Complete" Page
	And I click on "linktext" "Login" on "Registration Complete" Page 
	Then I close browser 
	
	
#***************UI Vendor Onboarding-Implement Incremental*************
@VendorOnboarding
@VOImplementIncremental  
@USU3208 
	Scenario: NewUIVendorRegistration_SC101-VendorRegistration-Implement Incremental 
	Given I initialize Browser 
	And I am executing "NewUIVendorRegistration_SC101-VendorRegistration-Implement Incremental" 
	
    Then I open only a new tab
	Then I switch between tabs "child"
	And I navigate to "Admin tool-QCSA" application
	And I log in to admin tool select customer "QCSAAUTOVC" for "QCSA"
	And I update Property "PROGRAM_PAYMENT_METHOD" to "Credit Card"
	And I update Property "TAX_CALCULATION_ENABLE" to "Y"
	And I update Property "XTDFORCE_API_PROGRAM" to "Null"
	Then I close open tabs "child"
	And I clear the cache

    And I navigate to "NewUI Vendor Registration-with Fee" application
	And I should see "text" named as "Have you signed up?" on "login page" Page
	And I click on "signupbutton" "Sign up" on "login page" Page
	When I wait for "3" Seconds 
	And I click on "button" "Let's Begin! " on "User Profile" Page 
	When I should fill details in "User Profile" page 
	And I click on "button" "NEXT" on "User Profile" Page
	Then I should see "title" named as "Business Information" on "Business Information" Page
	And I click on "button-newui" "Go Back" on "Business Information" Page
	Then I should see "title" named as "User Profile" on "User Profile" Page
	
	#And Verify Information on "User Profile" Page
	
	When I should fill details in "User Profile" page 
	And I click on "button" "NEXT" on "User Profile" Page
	Then I should see "title" named as "Business Information" on "Business Information" Page
	When I should fill details in "Business Information" page
	And I click on "button" "NEXT" on "Business Information" Page 
	Then I should see "title" named as "Business Contact" on "Business Contact" Page 
	
	And I click on "button-newui" "Go Back" on "Business Contact" Page
	Then I should see "title" named as "Business Information" on "Business Information" Page
	
	And Verify Information on "Business Information" Page
	
	And I click on "button" "NEXT" on "Business Information" Page 
	Then I should see "title" named as "Business Contact" on "Business Contact" Page
	When I should fill details in "Business Contact" page 
	And I click on "button" "NEXT" on "Business Contact" Page
	Then I should see "title" named as "Business Billing" on "Business Billing" Page 
	And I click on "button-newui" "Go Back" on "Business Billing" Page
	Then I should see "title" named as "Business Contact" on "Business Contact" Page 
	
	#And Verify Information on "Business Contact" Page
	
	And I click on "button" "NEXT" on "Business Contact" Page
	Then I should see "title" named as "Business Billing" on "Business Billing" Page
	When I should fill details in "Business Billing" page 
	And I click on "button" "NEXT" on "Business Billing" Page 
	
	Then I should see "title" named as "Almost Done" on "Business Confirmation" Page 
	And I click on "button-newui" "Go Back" on "Business Confirmation" Page
	
	#And Verify Information on "Business Billing" Page
	#And I should see element "Disabled Primary Contact Radiobutton"
	
	And I click on "button" "NEXT" on "Business Billing" Page 
	Then I should see "title" named as "Almost Done" on "Business Confirmation" Page 
	And I should see "text-newui" named as "Business Information-Name" on "Business Confirmation" Page
	And I click on "button" "NEXT" on "Business Confirmation" Page
	
	Then I should see "title" named as "Payment Method" on "Credit Card" Page
	And I enter "valid" value for "FN" textbox on "pow" Page NewUI
  	And I enter "valid" value for "LN" textbox on "pow" Page NewUI
	And I enter "valid" value for "CardNumberVisa" textbox on "Add People" Page NewUI
	And I enter "valid" value for "MM" textbox on "Add People" Page NewUI
	And I enter "valid" value for "YY" textbox on "Add People" Page NewUI
	And I enter "valid" value for "CSC" textbox on "Add People" Page NewUI
	And I should see "text" named as "Save this card for future purchases" on "Vendor Payment Information" Page
	Then I click on "checkbox" "Save CC" on "payment method" Page	
	And I click on "button" "NEXT" on "Vendor Payment Information" Page
	
	When I should fill details in "Business Signature" page 
	And I should see element "Today's Date"
	And I click on "button" "Submit" on "Business Signature" Page 
	When I wait for "3" Seconds
	Then I should see the sponsor logo in the header "congratulationsLogo" 
	And I should see "text-newui" named as "Welcome" on "Registration Complete" Page
	And I should see "button-newui" named as "Login" on "Registration Complete" Page 
	And I click on "linktext" "Login" on "Registration Complete" Page	
	
	And I close browser	
