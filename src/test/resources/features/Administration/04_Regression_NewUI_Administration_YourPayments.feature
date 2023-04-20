Feature: Regression NewUI - Administration - Your Payments
    
#*****************************************************************************************************************************************
###################### NewUI - Administration - Your Payments ######################
@4NewUI-Administration
@NewUI-Administration-YourPayments
Scenario: NewUI_SC08-Administration-Your Payments
  Given I initialize Browser
  And I am executing "NewUI_SC08-Administration-Your Payments"
  When Set "PROGRAM_PAYMENT_METHOD" to "Credit Card" for "1364" Customer

  And I navigate to "Autoqcs" application
  And I should see element "login page"
  When I log in to "Autoqcs" New UI application with "valid" Credentials
  And I click on "button-newui" "Login" on "Login" Page
  And I click on "button-newui" "I Certify" on "NOTICE" Page

  When I click on "MenuButton-NewUI" "Administration" on "HOME" Page
  And I click on "MenuButton-NewUI" "Your Payments" on "HOME" Page

  Then I should see Text "Payment Method"
  And I should see element "credit card icon" for "POW icon"
  And I should see Text "Please choose one of the saved credit cards or enter your Card details below."
  And I should see Text "Credit Card Payment"
  And I should see Text "Previously used Credit Cards"
  And I should see Text "Use a new payment method"
  When I click on "radiobutton-newui" "new" on "Payment Method" Page
  And I should see Text "Credit Card Details"
  And I should see Text "Save this card for future purchases"

  And Verify Element "exist" with data-xf-qa-id "CCP-INPUT-FN" for "First Name"
  And Verify Element "exist" with data-xf-qa-id "CCP-INPUT-LN" for "Last Name"
  And Verify Element "exist" with data-xf-qa-id "CCC-INPUT-CN" for "Credit Card Number"
  And Verify Element "exist" with data-xf-qa-id "CCC-SELECT-EXP-M" for "Expiry Month"
  And Verify Element "exist" with data-xf-qa-id "CCC-SELECT-EXP-Y" for "Expiry Year"
  And Verify Element "exist" with data-xf-qa-id "CCC-INPUT-CSC" for "CSC"

  And I click on "icon" "CSS Information" on "Payment Method" Page
  And I should see Text "3-4 Digits on the back of your Credit Card"

  When I click on "radiobutton-newui" "new" on "Payment Method" Page
  And I should see Text "Save this card for future purchases"
  And I should see "button-newui" named as "Save Card" on "administration" Page

  And I click on "link" "remove" on "remove credit cards" Page
  And I enter "valid" value for "FN" textbox on "Your Payments" Page NewUI
  And I enter "valid" value for "LN" textbox on "Your Payments" Page NewUI
  And I enter "valid" value for "CardNumberVisa" textbox on "Your Payments" Page NewUI
  And I enter "valid" value for "MM" textbox on "Your Payments" Page NewUI
  And I enter "valid" value for "YY" textbox on "Your Payments" Page NewUI
  And I enter "valid" value for "CSC" textbox on "Your Payments" Page NewUI

  And I click on "button-newui" "Save Card" on "administration" Page

  And I should see element "credit card" for "payment method"
  And I should see element "primary cc radiobutton" for "payment method"

  And I click on "link" "remove" on "payment method" Page
  And I should not see element "new credit card"

  And I close browser

###################### NewUI - Administration - Your Payments - Error Messages ######################
@4NewUI-Administration
@NewUI-Administration-YourPayments-Errormsg
  Scenario: NewUI_SC09-Administration-Your Payments-Errormsg
    Given I initialize Browser
    And I am executing "NewUI_SC09-Administration-Your Payments-Errormsg"
    When Set "PROGRAM_PAYMENT_METHOD" to "Credit Card" for "1364" Customer
    And I navigate to "Autoqcs" application

    And I should see element "login page" 
    
    When I log in to "Autoqcs" New UI application with "valid" Credentials 
    And I click on "button-newui" "Login" on "Login" Page 
    And I click on "button-newui" "I Certify" on "NOTICE" Page 
   	
	When I click on "MenuButton-NewUI" "Administration" on "HOME" Page
    And I click on "MenuButton-NewUI" "Your Payments" on "HOME" Page

	And I click on "button-newui" "Save Card" on "administration" Page
	And I should see "errormsg-newui" named as "First Name is required" for "First Name" on "Payment method" Page
    And I should see "errormsg-newui" named as "Last Name is required" for "Last Name" on "Payment method" Page
    And I should see "errormsg-newui" named as "Required Field" for "CC Number" on "Payment method" Page
    And I should see "errormsg-newui" named as "Required Field" for "MM" on "Payment method" Page
    And I should see "errormsg-newui" named as "Required Field" for "YY" on "Payment method" Page
    And I should see "errormsg-newui" named as "Required Field" for "CSC" on "Payment method" Page

    And I enter "max" value for "FN" textbox on "Your Payments" Page NewUI
    And I should see "errormsg-newui" named as "Max length (50) exceeded" for "First Name" on "Payment method" Page
    And I clear "FN" in "Your Payments" Page
    And I enter "empty" value for "FN" textbox on "Your Payments" Page NewUI
    And I should see "errormsg-newui" named as "Leading white-space characters not allowed" for "First Name" on "Payment method" Page
    And I clear "FN" in "Your Payments" Page

    And I enter "max" value for "LN" textbox on "Your Payments" Page NewUI
    And I should see "errormsg-newui" named as "Max length (50) exceeded" for "Last Name" on "Payment method" Page
    And I clear "LN" in "Your Payments" Page
    And I enter "empty" value for "LN" textbox on "Your Payments" Page NewUI
    And I should see "errormsg-newui" named as "Leading white-space characters not allowed" for "Last Name" on "Payment method" Page
    And I clear "LN" in "Your Payments" Page

    And I enter "valid" value for "CardNumberAmex" textbox on "Your Payments" Page NewUI
    And I enter "valid" value for "CSC" textbox on "Your Payments" Page NewUI
    And I should see "element" named as "amex" on "Payment method" Page
    And I should see "errormsg-newui" named as "Invalid security code" for "CSC" on "Payment method" Page

    And I enter "invalidsupporter" value for "CardNumberVisa" textbox on "Your Payments" Page NewUI
    And I should see "errormsg-newui" named as "Unsupported Credit Card Issuer" for "CC Number" on "Payment method" Page
    And I enter "invalidlength" value for "CardNumberVisa" textbox on "Your Payments" Page NewUI
    And I should see "errormsg-newui" named as "Invalid credit card number length" for "CC Number" on "Payment method" Page
    And I enter "invalidCC" value for "CardNumberVisa" textbox on "Your Payments" Page NewUI
    And I should see "errormsg-newui" named as "Invalid credit card number" for "CC Number" on "Payment method" Page
    
    And I close browser

###################### NewUI - Administration - Your Payments - Roles and Invoice ######################
@4NewUI-Administration
@NewUI-Administration-YourPayments-RolesAndInvoice
  Scenario: NewUI_SC10-Administration-Your Payments-RolesAndInvoice
    Given I initialize Browser
    And I am executing "NewUI_SC10-Administration-Your Payments-RolesAndInvoice"
    And Set "PROGRAM_PAYMENT_METHOD" to "Credit Card" for "1364" Customer
    And I navigate to "Autoqcs" application
	And I should see element "login page"
		
    And I navigate to "Autoqcs" application
    And I should see element "login page" 
    When I log in to "newuiupadte" New UI application with "valid" Credentials
    And I click on "button-newui" "Login" on "Login" Page 
    And I click on "button-newui" "I Certify" on "NOTICE" Page 
   	And I should not see element "Administration"
	And Click Logout NewUI
	
	When I log in to "newuiview" New UI application with "valid" Credentials 
    And I click on "button-newui" "Login" on "Login" Page 
    And I click on "button-newui" "I Certify" on "NOTICE" Page 
   	And I should not see element "Administration"
	And Click Logout NewUI
	
	When I log in to "newuisummary" New UI application with "valid" Credentials 
    And I click on "button-newui" "Login" on "Login" Page 
    And I click on "button-newui" "I Certify" on "NOTICE" Page 
   	And I should not see element "Administration"
	And Click Logout NewUI

    And Set "PROGRAM_PAYMENT_METHOD" to "Sponsor Invoice" for "1364" Customer

	And I should see element "login page" 
    When I log in to "autoqcs" New UI application with "valid" Credentials
    And I click on "button-newui" "Login" on "Login" Page 
    And I click on "button-newui" "I Certify" on "NOTICE" Page 
   	When I click on "MenuButton-NewUI" "Administration" on "HOME" Page
   	Then I should not see element "Your Payments"
	
	And Click Logout NewUI

    And Set "PROGRAM_PAYMENT_METHOD" to "Vendor Invoice" for "1364" Customer

	And I should see element "login page"
    When I log in to "autoqcs" New UI application with "valid" Credentials
    And I click on "button-newui" "Login" on "Login" Page
    And I click on "button-newui" "I Certify" on "NOTICE" Page 
   	When I click on "MenuButton-NewUI" "Administration" on "HOME" Page
   	Then I should not see element "Your Payments"
	
	And I close browser