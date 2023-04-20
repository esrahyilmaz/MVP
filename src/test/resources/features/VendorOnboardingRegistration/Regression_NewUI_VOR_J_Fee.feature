Feature: Regression NewUI Vendor Onboarding Registration - Vendor Payment Information Page 

#*************************** NewUI Vendor Onboarding Registration - Vendor Payment Information Page **********************************************
@VendorOnboarding
@NewUI-Fee-TaxableState
Scenario: NewUIVendorRegistration_SC102-VendorRegistration-Fee Taxable State
	Given I initialize Browser 
	And I am executing "NewUIVendorRegistration_SC102-VendorRegistration-Fee Taxable State" 
	
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
	And I click on "button-newui" "Sign up" on "signup" Page 
	And I click on "button-newui" "Let's Begin!" on "signup" Page 
	When I should fill details in "User Profile" page 
	And I click on "button-newui" "NEXT" on "vendor onboarding" Page 
	When I Execute "Validate Tax is rendering for Taxable state when Tax is enabled and Payment Method is CC"
	When I should fill details in "Business Information-taxable" page 
	And I click on "button-newui" "NEXT" on "vendor onboarding" Page 
	When I should fill details in "Business Contact" page 
	And I click on "button-newui" "NEXT" on "vendor onboarding" Page 
	And I click on "radiobutton-newui" "Primary Contact" on "Business Billing" Page 
	And I click on "checkbox" "My billing address" on "Business Billing" Page
	And I click on "button-newui" "NEXT" on "vendor onboarding" Page 
	When I wait for "2" Seconds 
	Then I should see "title" named as "Almost Done" on "Business Confirmation" Page 
	And I click on "button-newui" "NEXT" on "vendor onboarding" Page 
	
	Then I should see the sponsor logo in the header "VendorLogo" 
	And I should see Customer support "number" in the header 
	And I should see Customer support "email" in the header 
	Then I should click "SupportLink" in the footer 
	And I should click "FactActLink" in the footer 
	And I should click "LegalLink" in the footer 
	And I should click "PrivacyPolice" in the footer 
	And I should see "FadvTrademark" in the footer of the page 
	
	Then I should see "title" named as "Payment Method" on "Vendor Payment Information" Page
	And I should see "text" named as "Please chose one of the save credit cards or enter your Card details below." on "Vendor Payment Information" Page 
	And I should see "text" named as "Credit Card Payment" on "Vendor Payment Information" Page 
	And I should see Text "Previously used Credit Cards" 
	And I should see "text" named as "Use a new payment method" on "Vendor Payment Information" Page 
	And I should see Text "Credit Card Details" 
	
	And Verify Element "exist" with data-xf-qa-id "CCP-INPUT-FN" for "First Name"
	And Verify Element "exist" with data-xf-qa-id "CCP-INPUT-LN" for "Last Name"
	And Verify Element "exist" with data-xf-qa-id "CCC-INPUT-CN" for "Credit Card Number"
	And Verify Element "exist" with data-xf-qa-id "CCC-SELECT-EXP-M" for "Expiry Month"
	And Verify Element "exist" with data-xf-qa-id "CCC-SELECT-EXP-Y" for "Expiry Year"
	And Verify Element "exist" with data-xf-qa-id "CCC-INPUT-CSC" for "CSC"	
	
	And I enter "random" value for "FN" textbox on "Your Payments" Page NewUI
	And I enter "random" value for "LN" textbox on "Your Payments" Page NewUI 
	And I enter "valid" value for "CardNumberMaster" textbox on "Add People" Page NewUI 
	And I should see "element" named as "master" on "Payment method" Page 
	And I enter "valid" value for "CardNumberAmex" textbox on "Add People" Page NewUI 
	And I should see "element" named as "amex" on "Payment method" Page 
	And I enter "valid" value for "CardNumberVisa" textbox on "Add People" Page NewUI 
	And I should see "element" named as "visa" on "Payment method" Page 
	And I enter "valid" value for "MM" textbox on "Add People" Page NewUI
	And I enter "valid" value for "YY" textbox on "Add People" Page NewUI
	And I enter "valid" value for "CSC" textbox on "Add People" Page NewUI	
	Then I click on "checkbox" "Save CC" on "payment method" Page
	And I should see "text" named as "Save this card for future purchases" on "Vendor Payment Information" Page
	
	And I should see element "Summary" for "POW"
	And I should see element "Subtotal:" for "POW"
	#And I should see "text-newui" named as "Subtotal-VO" on "Payment Method" Page
	And I should see element "Tax:" for "POW"
	And Verify value "Tax" on "Vendor Registration" Page for DB "QCSA"
	#And I should see "text-newui" named as "Tax-VO" on "Payment Method" Page
	And I should see element "Order Total:" for "POW"
	And I should see "text-newui" named as "Order Total" on "Payment Method" Page
	And I should see element "Warning" for "POW"
	And I should see element "If you logout, all of the items in the cart will be lost" for "POW"
	
	And I click on "button-newui" "NEXT" on "vendor onboarding" Page
	And I should not see "button-newui" named as "Previews" on "People" Page
	
	When I should fill details in "Business Signature" page 
	And I click on "button-newui" "Submit" on "vendor onboarding" Page 
	
	And I should see "text-newui" named as "Welcome" on "Registration Complete" Page
	And I click on "linktext" "Login" on "Registration Complete" Page	
	
	When I log in to "newuionboardedvendor" New UI application with "valid" Credentials 
	And I click on "button-newui" "Login" on "Login" Page 
	And I click on "button-newui" "I Certify" on "NOTICE" Page
	
	And I click on "MenuButton-NewUI" "Administration" on "HOME" Page
    And I click on "MenuButton-NewUI" "Your Payments" on "HOME" Page
    And I should see element "credit card" for "payment method"
    
    And I close browser

#*************************** NewUI Vendor Onboarding Registration - Vendor Payment Information Page **********************************************
@VendorOnboarding
@NewUI-Fee-NonTaxableState
Scenario: NewUIVendorRegistration_SC103-VendorRegistration-Fee Non Taxable State
	Given I initialize Browser 
	And I am executing "NewUIVendorRegistration_SC103-VendorRegistration-Fee Non Taxable State" 
	
	Then I open only a new tab
	Then I switch between tabs "child"
	And I navigate to "Admin tool-QCSA" application
	And I log in to admin tool select customer "QCSAAUTOVC" for "QCSA"
	And I update Property "PROGRAM_PAYMENT_METHOD" to "Credit Card"
	And I update Property "TAX_CALCULATION_ENABLE" to "Y"
	And I update Property "XTDFORCE_API_PROGRAM" to "Order"
	Then I close open tabs "child"
	And I navigate to "NewUI Vendor Registration-with Fee" application 
	And I clear the cache
			
	And I should see "text" named as "Have you signed up?" on "login page" Page 
	And I click on "button-newui" "Sign up" on "signup" Page 
	And I click on "button-newui" "Let's Begin!" on "signup" Page 
	When I should fill details in "User Profile" page 
	And I click on "button-newui" "NEXT" on "vendor onboarding" Page 
	When I Execute "Validate Tax is not rendering for Non-Taxable state when Tax is enabled and Payment Method is CC"
	When I should fill details in "Business Information-non-taxable" page 
	And I click on "button-newui" "NEXT" on "vendor onboarding" Page 
	When I should fill details in "Business Contact" page 
	And I click on "button-newui" "NEXT" on "vendor onboarding" Page 
	And I click on "radiobutton-newui" "Primary Contact" on "Business Billing" Page 
	And I click on "checkbox" "My billing address" on "Business Billing" Page
	And I click on "button-newui" "NEXT" on "vendor onboarding" Page 
	 
	Then I should see "title" named as "Almost Done" on "Business Confirmation" Page 
	And I click on "button-newui" "NEXT" on "vendor onboarding" Page 
	
	Then I should see "title" named as "Payment Method" on "Vendor Payment Information" Page
	And I enter "random" value for "FN" textbox on "Your Payments" Page NewUI
	And I enter "random" value for "LN" textbox on "Your Payments" Page NewUI 
	And I enter "valid" value for "CardNumberVisa" textbox on "Add People" Page NewUI 
	And I should see "element" named as "visa" on "Payment method" Page 
	And I enter "valid" value for "MM" textbox on "Add People" Page NewUI
	And I enter "valid" value for "YY" textbox on "Add People" Page NewUI
	And I enter "valid" value for "CSC" textbox on "Add People" Page NewUI	
	And I should see "text" named as "Save this card for future purchases" on "Vendor Payment Information" Page
	
	And I should see element "Summary" for "POW"
	And I should see element "Subtotal:" for "POW"
	#And I should see "text-newui" named as "Subtotal-VO" on "Payment Method" Page
	And I should see element "Tax:" for "POW"
	And Verify value "Tax" on "Vendor Registration" Page for DB "QCSA"
	#And I should see "text-newui" named as "Tax-VO" on "Payment Method" Page
	And I should see element "Order Total:" for "POW"
	And I should see "text-newui" named as "Order Total" on "Payment Method" Page
	And I should see element "Warning" for "POW"
	And I should see element "If you logout, all of the items in the cart will be lost" for "POW"
	
	And I click on "button-newui" "NEXT" on "vendor onboarding" Page
	And I should not see "button-newui" named as "Previews" on "People" Page
	
	When I should fill details in "Business Signature" page 
	And I click on "button-newui" "Submit" on "vendor onboarding" Page 
	
	And I should see "text-newui" named as "Welcome" on "Registration Complete" Page
	And I click on "linktext" "Login" on "Registration Complete" Page	
	
	When I log in to "newuionboardedvendor" New UI application with "valid" Credentials 
	And I click on "button-newui" "Login" on "Login" Page 
	And I click on "button-newui" "I Certify" on "NOTICE" Page
	
	And I click on "MenuButton-NewUI" "Administration" on "HOME" Page
    And I click on "MenuButton-NewUI" "Your Payments" on "HOME" Page
    And I should not see element "new credit card"
    
    And I close browser

#*************************** NewUI Vendor Onboarding Registration - Vendor Payment Information Page **********************************************
#@VendorOnboardingErrorMessages
@NewUI-Fee-Error
Scenario: NewUIVendorRegistration_SC104-VendorRegistration-Fee Error Messages
	Given I initialize Browser 
	And I am executing "NewUIVendorRegistration_SC104-VendorRegistration-Fee Error Messages" 
	
	Then I open only a new tab
	Then I switch between tabs "child"
	And I navigate to "Admin tool-QCSA" application
	And I log in to admin tool select customer "QCSAAUTOVC" for "QCSA"
	And I update Property "PROGRAM_PAYMENT_METHOD" to "Credit Card"
	And I update Property "TAX_CALCULATION_ENABLE" to "N"
	And I update Property "XTDFORCE_API_PROGRAM" to "Null"
	Then I close open tabs "child"
	And I navigate to "NewUI Vendor Registration-with Fee" application 
	And I clear the cache
			
	And I should see "text" named as "Have you signed up?" on "login page" Page 
	And I click on "button-newui" "Sign up" on "signup" Page 
	And I click on "button-newui" "Let's Begin!" on "signup" Page 
	When I should fill details in "User Profile" page 
	And I click on "button-newui" "NEXT" on "vendor onboarding" Page 
	When I Execute "Validate Tax is not rendering for Taxable state when Tax is disabled and Payment Method is CC"
	When I should fill details in "Business Information-taxable" page 
	And I click on "button-newui" "NEXT" on "vendor onboarding" Page 
	When I should fill details in "Business Contact" page 
	And I click on "button-newui" "NEXT" on "vendor onboarding" Page 
	And I click on "radiobutton-newui" "Primary Contact" on "Business Billing" Page 
	And I click on "checkbox" "My billing address" on "Business Billing" Page
	And I click on "button-newui" "NEXT" on "vendor onboarding" Page 
	
	Then I should see "title" named as "Almost Done" on "Business Confirmation" Page 
	And I click on "button-newui" "NEXT" on "vendor onboarding" Page 
	
	Then I should see "title" named as "Payment Method" on "Vendor Payment Information" Page
	
	And I click on "button" "NEXT" on "Vendor Payment Information" Page
	And I should see "errormsg-newui" named as "First Name is required" for "First Name" on "Payment Method" Page
	And I should see "errormsg-newui" named as "Last Name is required" for "Last Name" on "Payment Method" Page
	And I should see "errormsg-newui" named as "Required Field" for "CC Number" on "Payment Method" Page
	And I should see "errormsg-newui" named as "Required Field" for "MM" on "Payment Method" Page
	And I should see "errormsg-newui" named as "Required Field" for "YY" on "Payment Method" Page
	And I should see "errormsg-newui" named as "Required Field" for "CSC" on "Payment Method" Page
	
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
	
	And I enter "random" value for "FN" textbox on "Your Payments" Page NewUI
	And I enter "random" value for "LN" textbox on "Your Payments" Page NewUI 
	And I enter "valid" value for "CardNumberVisa" textbox on "Add People" Page NewUI 
	And I should see "element" named as "visa" on "Payment method" Page 
	And I enter "valid" value for "MM" textbox on "Add People" Page NewUI
	And I enter "valid" value for "YY" textbox on "Add People" Page NewUI
	And I enter "valid" value for "CSC" textbox on "Add People" Page NewUI	
	And I should see "text" named as "Save this card for future purchases" on "Vendor Payment Information" Page
	
	And I should see element "Summary" for "POW"
	And I should see element "Subtotal:" for "POW"
	#And I should see "text-newui" named as "Subtotal-VO" on "Payment Method" Page
	And I should see element "Tax:" for "POW"
	And Verify value "Tax" on "Vendor Registration" Page for DB "QCSA"
	#And I should see "text-newui" named as "Tax-VO" on "Payment Method" Page
	And I should see element "Order Total:" for "POW"
	And I should see "text-newui" named as "Order Total" on "Payment Method" Page
	And I should see element "Warning" for "POW"
	And I should see element "If you logout, all of the items in the cart will be lost" for "POW"
	
	And I click on "button-newui" "NEXT" on "vendor onboarding" Page
	And I should not see "button-newui" named as "Previews" on "People" Page
	
	When I should fill details in "Business Signature" page 
	And I click on "button-newui" "Submit" on "vendor onboarding" Page 
	
	And I should see "text-newui" named as "Welcome" on "Registration Complete" Page
	And I click on "linktext" "Login" on "Registration Complete" Page	
	   
    And I close browser

	