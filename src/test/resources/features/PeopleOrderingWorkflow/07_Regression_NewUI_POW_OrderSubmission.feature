Feature: Regression NewUI People Order Workflow - Order Submission
#******************************************************************************************************************************

################################ People Ordering Workflow - Order Submission Screen - 3218/11369 #########################################     
@NewUI-PeopleOrderingWorkflow
@NewUI-POW-OrderSubmission-01
Scenario: NewUI_SC11-Order Submission
	Given I initialize Browser
	When I am executing "NewUI_SC11-Order Submission" 
    And I navigate to "NewUI" application 
    
    Then I open only a new tab
	Then I switch between tabs "child"
	And I navigate to "Admin tool" application
	And I log in to admin tool select customer "XTDAUTOQCSA" for "QCSA"
	And I update Property "PROGRAM_PAYMENT_METHOD" to "Vendor Invoice"
	And I update Property "ENABLE_PA_INTEGRATION" to "Y"
	Then I close open tabs "child"
	And I clear the cache
	And I should see element "login page"

    When I log in to "autoqcs" New UI application with "valid" Credentials 
    And I click on "button-newui" "Login" on "Login" Page 
    And I click on "button-newui" "I Certify" on "NOTICE" Page 
   	And I click on "MenuButton-NewUI" "People" on "HOME" Page
    And I should see element "People"
    
    And I should see Text "Create Order"
    When I click on "button-newui" " Create Order " on "People" Page
    
    And I should see Text "Personal information"
    And I click on "button-newui" "Middle Name Yes" on "create person" Page
	And I enter "valid" value for "FN" textbox on "create person" Page NewUI
	And I enter "valid" value for "MN" textbox on "create person" Page NewUI
	And I enter "valid" value for "LN" textbox on "create person" Page NewUI
    And I enter "valid" value for "email" textbox on "create person" Page NewUI
    And I enter "valid" value for "re-enter email" textbox on "create person" Page NewUI  
	And I enter "valid" value for "Country" textbox on "create person" Page NewUI     
    And I enter "valid" value for "City" textbox on "create person" Page NewUI 
    And I enter "valid" value for "State" textbox on "create person" Page NewUI     
    And I click on "button-newui" "Next" on "create person" Page 

	And I should see Text "Package Selection"
	When Search table By "package" in "Package Selection" page
	And I click on "button-newui" "search" on "package selection" Page
	And I click on "radiobutton-newui" "first pkg" on "package selection" Page
	And I should see element "Package select checkbox" for "POW"
	And I should see element "Package Price Tag" for "POW"
	And Verify value "Price" on "Package Selection" Page for DB "QCSA"
	And I click on "button-NewUI" "Add to Cart" on "package selection" Page
	
	And I should see Text "Shopping cart"
	#And I should see element "Person Name Label"
	And I should see "text-newui" named as "person" on "Shopping Cart" Page
	#And I should see element "Package Name Label"
	#And I should see element "Package Price Label"
	And I should see "text-newui" named as "Price" on "Shopping Cart" Page
	And I should see element "Summary"
	And I should see element "Subtotal"
	And I should see "text-newui" named as "Subtotal" on "Shopping Cart" Page
	And I should see element "Tax"
	And I should see "text-newui" named as "Tax:" on "Shopping Cart" Page
	And I should see element "Order Total"
	#And I should see "text-newui" named as "Order Total" on "Shopping Cart" Page
	And I click on "button-NewUI" "Checkout" on "Shopping Cart" Page

	
	And I should see element "order icon" for "POW icon"
	And I should see element "order icon Section" for "POW icon"
	And I should see Text "Order Confirmation"
	And I should see Text "Here is your transaction number:"
	And I should see "element" named as "transaction number" on "order confirmation" Page
	And I should see Text "Paid via:"
	And I should see "text-newui" named as "Invoice" on "Order Confirmation" Page
	And I should see Text "A confirmation notice with the order details will be sent to your email at"
	And Verify value "Vendor email" on "Order Confirmation" Page for DB "QCSA"
	And I should see Text "Choose an action below to continue"
	
	Then I should see the sponsor logo in the header "VendorLogo"
    And I should see Customer support "number" in the header
    And I should see Customer support "email" in the header
    Then I should click "SupportLink" in the footer
    And I should click "FactActLink" in the footer
    And I should click "LegalLink" in the footer
    And I should click "PrivacyPolice" in the footer
    And I should see "FadvTrademark" in the footer of the page
	
	When I should see "button-newui" named as "Return to People" on "Add People" Page
	When I should see "button-newui" named as "Create a New Order" on "Add People" Page
	
 	Then I click on "button-newui" "Return to People Page" on "order submission" Page
	And I should see element "People"
	And Search table By "FN & LN" in "pow" page
 	And I click on "button-newui" "search" on "People" Page
 	And I should see element "by multi search"	
    And I close browser
    
    And I close browser
	
################################ People Ordering Workflow - Order Submission Screen - 3218/11369 #########################################     
@NewUI-PeopleOrderingWorkflow
@NewUI-POW-OrderSubmission
@NewUI-POW-OrderSubmission-CreditCard
Scenario: NewUI_SC12-Order Submission-CreditCard
	Given I initialize Browser
	When I am executing "NewUI_SC12-Order Submission-CreditCard" 
    And I navigate to "NewUI" application 
    
    Then I open only a new tab
	Then I switch between tabs "child"
	And I navigate to "Admin tool" application
	And I log in to admin tool select customer "XTDAUTOQCSA" for "QCSA"
	And I update Property "PROGRAM_PAYMENT_METHOD" to "Credit Card"
	Then I close open tabs "child"
	And I clear the cache
	And I should see element "login page"
    
    When I log in to "autoqcs" New UI application with "valid" Credentials 
    And I click on "button-newui" "Login" on "Login" Page 
    And I click on "button-newui" "I Certify" on "NOTICE" Page 
   	And I click on "MenuButton-NewUI" "People" on "HOME" Page
    And I should see element "People"
    
    And I should see Text "Create Order"
    When I click on "button-newui" " Create Order " on "People" Page
    
    And I should see Text "Personal information"
    And I click on "button-newui" "Middle Name Yes" on "create person" Page
	And I enter "valid" value for "FN" textbox on "create person" Page NewUI
	And I enter "valid" value for "MN" textbox on "create person" Page NewUI
	And I enter "valid" value for "LN" textbox on "create person" Page NewUI
    And I enter "valid" value for "email" textbox on "create person" Page NewUI
    And I enter "valid" value for "re-enter email" textbox on "create person" Page NewUI  
	And I enter "valid" value for "Country" textbox on "create person" Page NewUI     
    And I enter "valid" value for "City" textbox on "create person" Page NewUI 
    And I enter "valid" value for "State" textbox on "create person" Page NewUI     
    And I click on "button-newui" "Next" on "create person" Page 

	And I should see Text "Package Selection"
	When Search table By "package" in "Package Selection" page
	And I click on "button-newui" "search" on "package selection" Page
	And I click on "radiobutton-newui" "first pkg" on "package selection" Page
	And I should see element "Package select checkbox" for "POW"
	And I should see element "Package Price Tag" for "POW"
	And Verify value "Price" on "Package Selection" Page for DB "QCSA"
	And I click on "button-NewUI" "Add to Cart" on "package selection" Page
	
	And I should see Text "Shopping cart"
	#And I should see element "Person Name Label"
	And I should see "text-newui" named as "person" on "Shopping Cart" Page
	#And I should see element "Package Name Label"
	#And I should see element "Package Price Label"
	And I should see "text-newui" named as "Price" on "Shopping Cart" Page
	And I should see element "Summary"
	And I should see element "Subtotal"
	And I should see "text-newui" named as "Subtotal" on "Shopping Cart" Page
	And I should see element "Tax"
	And I should see "text-newui" named as "Tax:" on "Shopping Cart" Page
	And I should see element "Order Total"
	#And I should see "text-newui" named as "Order Total" on "Shopping Cart" Page
	And I click on "button-newui" "Authorize" on "Shopping Cart" Page
	And I click on "button-NewUI" "Checkout" on "Shopping Cart" Page
	
	Then I should see Text "Payment method"
	And I should see element "Subtotal:" for "POW"
	And I should see "text-newui" named as "Subtotal" on "Payment Method" Page
	#And I should see "text-newui" named as "Tax" on "Payment Method" Page
	#And I should see "text-newui" named as "Order Total" on "Payment Method" Page
		
	When I click on "radiobutton-newui" "new" on "Payment Method" Page
	And I enter "present" value for "FN" textbox on "pow" Page NewUI
  	And I enter "present" value for "LN" textbox on "pow" Page NewUI
	And I enter "valid" value for "CardNumberMaster" textbox on "Add People" Page NewUI
	And I should see "element" named as "master" on "Payment method" Page
	And I enter "valid" value for "CardNumberAmex" textbox on "Add People" Page NewUI
	And I should see "element" named as "amex" on "Payment method" Page
	And I enter "valid" value for "CardNumberVisa" textbox on "Add People" Page NewUI
	And I should see "element" named as "visa" on "Payment method" Page
	And I enter "valid" value for "MM" textbox on "Add People" Page NewUI
	And I enter "valid" value for "YY" textbox on "Add People" Page NewUI
	And I enter "valid" value for "CSC" textbox on "Add People" Page NewUI
	
	And I click on "button-newui" "Next button on PP" on "Payment Method" Page
    Then I should see Text "Order complete!"
  	And I should see element "order icon" for "POW icon"
	And I should see element "order icon Section" for "POW icon"
	And I should see Text "Order Confirmation"
	And I should see Text "Here is your transaction number:"
	And I should see "element" named as "transaction number" on "order confirmation" Page
	And I should see Text "Paid via:"
	And I should see "text-newui" named as "Credit Card" on "order confirmation" Page
	And I should see "text-newui" named as "Credit Card Number" on "order confirmation" Page
	And I should see Text "*Any outstanding balances related to services provided will be collected at the time of your next login."
	And I should see Text "A confirmation notice with the order details will be sent to your email at"
	And Verify value "Vendor email" on "Order Confirmation" Page for DB "QCSA"
	And I should see Text "Choose an action below to continue"
	
	When I should see "button-newui" named as "Return to People" on "Add People" Page
	When I should see "button-newui" named as "Create a New Order" on "Add People" Page
	
 	Then I click on "button-newui" "Return to People Page" on "order submission" Page
	And I should see element "People"
	And Search table By "FN & LN" in "pow" page
 	And I click on "button-newui" "search" on "People" Page
 	#And I should see element "by multi search"	
    
    And I close browser
