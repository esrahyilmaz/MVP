Feature: Regression NewUI Outstanding Balance
    
#*****************************************************************************************************************************************
######################NewUI Outstanding Balance######################
#@NewUI-PeopleOrderingWorkflow
@NewUIOutstandingBalance
Scenario: NewUI_SC13-Outstanding Balance
	Given I initialize Browser 
	And I am executing "NewUI_SC13-Outstanding Balance" 
	And I navigate to "NewUI" application 
	And I should see element "login page"
	
	Then I open only a new tab
	Then I switch between tabs "child"
	And I navigate to "Admin tool" application
	And I log in to admin tool select customer "XTDAUTOQCSA" for "QCSA"
	And I update Property "PROGRAM_PAYMENT_METHOD" to "Credit Card"
	And I update Property "ENABLE_PA_INTEGRATION" to "Y"
	And I update Property "TAX_CALCULATION_ENABLE" to "Y"
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
	And Verify value "Price" on "Package Selection" Page for DB "QCSA"
	And I click on "button-NewUI" "Add to Cart" on "package selection" Page
	
	And I should see Text "Shopping cart"
	And I click on "button-newui" "Authorize" on "Shopping Cart" Page
	And I click on "button-NewUI" "Checkout" on "Shopping Cart" Page
	
	Then I should see Text "Payment method"
		
	When I click on "radiobutton-newui" "new" on "Payment Method" Page
	And I enter "present" value for "FN" textbox on "pow" Page NewUI
  	And I enter "present" value for "LN" textbox on "pow" Page NewUI
	And I enter "declined" value for "CardNumberVisa" textbox on "Add People" Page NewUI
	And I should see "element" named as "visa" on "Payment method" Page
	And I enter "valid" value for "MM" textbox on "Add People" Page NewUI
	And I enter "valid" value for "YY" textbox on "Add People" Page NewUI
	And I enter "valid" value for "CSC" textbox on "Add People" Page NewUI
	Then I click on "checkbox" "Save CC" on "payment method" Page
	And I should see "text-newui" named as "Order Total" on "Payment Method" Page
	And I click on "button-newui" "Next button on PP" on "Payment Method" Page
    Then I should see Text "Order complete!"
    Then I click on "button-newui" "Return to People Page" on "order submission" Page
    
    And Click Logout NewUI
	
	And I should see element "login page"
	When I log in to "autoqcs" New UI application with "valid" Credentials 
	And I click on "button-newui" "Login" on "Login" Page 
	When I should see "button-newui" named as "I Certify" on "FCRA" Page
	And I click on "button-newui" "I Certify" on "NOTICE" Page
    
	And I should see Text "Notice"
	And I should see element "outstanding message" for "outstanding balance"
	And I should see Text " You have a remaining balance for services rendered on the orders below. These orders are placed on hold until you have cleared your balance.  Please proceed forward, confirm your payment information, and clear your balance. "
	And I should see Text "Name"
	And I should see "text-newui" named as "Name" on "Outstanding Balance" Page
	And I should see Text "Ordered"
	And I should see "text-newui" named as "Order Date" on "Outstanding Balance" Page
	And I should see Text "Additional Charge"
	And I should see "text-newui" named as "Additional Charge" on "Outstanding Balance" Page
	And I should see Text "Date Charged"
	And I should see "text-newui" named as "Date Charged" on "Outstanding Balance" Page
	And I should see Text "Balance Outstanding"
	And I should see "text-newui" named as "Balance Outstanding" on "Outstanding Balance" Page
	And I should see Text "Checkout"
	And I click on "button-newui" "Checkout Button" on "outstanding" Page
	And I should see Text "Previously used Credit Cards"
	And I should not see Text "People"
	
	And Refresh The Page
	And I should see Text "Notice"
	 	
	And I click on "button-newui" "Checkout Button" on "outstanding" Page
		
	Then I should see Text "Payment Method"
	And I should see element "credit card icon" for "POW icon"
	And I should see Text "Please choose one of the saved credit cards or enter a new one"
	And I should see Text "Credit Card Payment"
	And I should see Text "Previously used Credit Cards"
	And I should see Text "Use a new payment method"
	And I should see Text "Credit Card Details"
	And I click on "link" "remove" on "payment method" Page
		
	When I click on "radiobutton-newui" "new" on "Payment Method" Page
	And I enter "valid" value for "FN" textbox on "pow" Page NewUI
  	And I enter "valid" value for "LN" textbox on "pow" Page NewUI
	And I enter "valid" value for "CardNumberVisa" textbox on "Add People" Page NewUI
	And I enter "valid" value for "MM" textbox on "Add People" Page NewUI
	And I enter "valid" value for "YY" textbox on "Add People" Page NewUI
	And I enter "valid" value for "CSC" textbox on "Add People" Page NewUI
	
	And I click on "icon" "CSS Information" on "Payment Method" Page
	And I should see Text "3-4 Digits on the back of your Credit Card"
	And I should see Text "Save this card for future purchases"
    Then I click on "checkbox" "Save CC" on "payment method" Page
	
	And I should see element "Summary"
	#And I should see element "Subtotal"
	#And I should see "text-newui" named as "Subtotal" on "Payment Method" Page
	And I should see element "Tax"
	#And I should see "text-newui" named as "Tax" on "Payment Method" Page
	And I should see element "Order Total"
	#And I should see "text-newui" named as "Order Total" on "Payment Method" Page
	And I should see element "Warning"
	And I should see element "If you logout, all of the items in the cart will be lost" for "POW"

	Then I click on "button-newui" "Submit Payment" on "add people" Page
	And wait for "3" Seconds
	When I should see "menubutton-newui" named as "People" on "HOME" Page
	
	When I Execute "Validate new Credit Card is saved after clicking on Save CC"
	And I click on "MenuButton-NewUI" "Administration" on "HOME" Page
    And I click on "MenuButton-NewUI" "Your Payments" on "HOME" Page
    And I should see element "credit card" for "payment method"
	
	And I close browser