Feature: Regression NewUI People Order Workflow - Credit Card
#******************************************************************************************************************************

################################People Ordering Workflow - Credit Card Capture Screen - 6682#########################################     
@NewUI-PeopleOrderingWorkflow
@NewUI-POW-CreditCard
@NewUI-POW-CreditCard8
Scenario: NewUI_SC08-Credit Card
	Given I initialize Browser
	When I am executing "NewUI_SC08-Credit Card" 
    And I navigate to "NewUI" application 
    
   Then I open only a new tab
	Then I switch between tabs "child"
	And I navigate to "Admin tool" application
	And I log in to admin tool select customer "QCSAAUTOVC" for "QCSA"
	And I update Property "PROGRAM_PAYMENT_METHOD" to "Credit Card"
	Then I close open tabs "child"
	And I clear the cache

	And I should see element "login page"

    When I log in to "qcsavc" New UI application with "valid" Credentials 
    And I click on "button-newui" "Login" on "Login" Page
    And I click on "button-newui" "I Certify" on "NOTICE" Page

	When I click on "MenuButton-NewUI" "Administration" on "HOME" Page
	And I click on "MenuButton-NewUI" "Your Payments" on "HOME" Page
	And I click on "link" "remove" on "remove credit cards" Page

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
	And I should see element "credit card icon" for "POW icon"
	And I should see element "credit card icon Section" for "POW icon"
	And I should see Text "Please choose one of the saved credit cards or enter your Card details below."
	And I should see Text "Credit Card Payment"
	And I should see Text "Previously used Credit Cards"
	And I should see Text "Use a new payment method"
	And I should see Text "Save this card for future purchases"

	And Verify Element "exist" with data-xf-qa-id "CCP-INPUT-FN" for "First Name"
	And Verify Element "exist" with data-xf-qa-id "CCP-INPUT-LN" for "Last Name"
	And Verify Element "exist" with data-xf-qa-id "CCC-INPUT-CN" for "Credit Card Number"
	And Verify Element "exist" with data-xf-qa-id "CCC-SELECT-EXP-M" for "Expiry Month"
	And Verify Element "exist" with data-xf-qa-id "CCC-SELECT-EXP-Y" for "Expiry Year"
	And Verify Element "exist" with data-xf-qa-id "CCC-INPUT-CSC" for "CSC"

	And I click on "icon" "CSS Information" on "Payment Method" Page
	And I should see Text "3-4 Digits on the back of your Credit Card"

	And I should see "button-newui" named as "Use a new payment method" on "Payment Method" Page
	And I should see "button-newui" named as "Cancel" on "Payment Method" Page
	And I should see "button-newui" named as "Next" on "Payment Method" Page

	And I should see element "Summary" for "POW"
	And I should see element "Subtotal:" for "POW"
	And I should see "text-newui" named as "Subtotal" on "Payment Method" Page
	And I should see element "Tax:"
	And I should see "text-newui" named as "Tax" on "Payment Method" Page
	And I should see element "Order Total:"
	And I should see "text-newui" named as "Order Total" on "Payment Method" Page
	And I should see element "Warning"
	And I should see element "If you logout, all of the items in the cart will be lost" for "POW"

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

	When I Execute "Validate new Credit Card is saved after clicking on "
	Then I click on "checkbox" "Save CC" on "payment method" Page
	And I click on "button-newui" "Next button on PP" on "Payment Method" Page
	Then I should see Text "Order complete!"

	And I click on "MenuButton-NewUI" "Administration" on "HOME" Page
	And I click on "MenuButton-NewUI" "Your Payments" on "HOME" Page
	And I should see element "credit card" for "payment method"

	When I Execute "Validate new Credit Card is removed after click on remove link"
	And I click on "MenuButton-NewUI" "People" on "HOME" Page
	When I click on "checkbox" "first" on "People" Page
	And I click on "button-NewUI" "New Order" on "People" Page
	And I click on "button-newui" "Next" on "create person" Page
	And I click on "radiobutton-newui" "first pkg" on "package selection" Page
	And I click on "button-NewUI" "Add to Cart" on "package selection" Page
	And I click on "button-newui" "Authorize" on "Shopping Cart" Page
	And I click on "button-NewUI" "Checkout" on "Shopping Cart" Page
#	And I search for Credit card "Visa""1111""05/31"
#to do on remove link
	#And I click on "link" "remove" on "payment method" Page
	#When I click on "radiobutton-newui" "new" on "Payment Method" Page
	
	#And I should not see element "new credit card"

	And I close browser
	

############People Ordering Workflow - Credit Card Capture Screen - 6682##################
@NewUI-PeopleOrderingWorkflow
@NewUI-POW-CreditCard 
@NewUI-POW-CreditCard-ErrorMessages-WithoutSavingCC
Scenario: NewUI_SC09-Credit Card-ErrorMessages-WithoutSavingCC
	Given I initialize Browser
	When I am executing "NewUI_SC09-Credit Card-ErrorMessages-WithoutSavingCC" 
    And I navigate to "NewUI" application 
    
    Then I open only a new tab
	Then I switch between tabs "child"
	And I navigate to "Admin tool" application
	And I log in to admin tool select customer "XTDAUTOQCSA" for "QCSA"
	And I update Property "PROGRAM_PAYMENT_METHOD" to "Credit Card"  
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
	And I click on "button-newui" "Authorize" on "Shopping Cart" Page
	And I click on "button-NewUI" "Checkout" on "Shopping Cart" Page
	
	Then I should see Text "Payment method"
	When I click on "radiobutton-newui" "new" on "Payment Method" Page
	And I click on "button-newui" "Next button on PP" on "Payment Method" Page
	And I should see "errormsg-newui" named as "First Name is required" for "First Name" on "Payment Method" Page
	And I should see "errormsg-newui" named as "Last Name is required" for "Last Name" on "Payment Method" Page
	And I should see "errormsg-newui" named as "Required Field" for "CC Number" on "Payment Method" Page
	And I should see "errormsg-newui" named as "Required Field" for "MM" on "Payment Method" Page
	And I should see "errormsg-newui" named as "Required Field" for "YY" on "Payment Method" Page
	And I should see "errormsg-newui" named as "Required Field" for "CSC" on "Payment Method" Page
	
	And I enter "max" value for "FN" textbox on "payment method" Page NewUI
    And I should see "errormsg-newui" named as "Max length (50) exceeded" for "First Name" on "Payment method" Page
    And I clear "FN" in "pow" Page
    And I enter "empty" value for "FN" textbox on "Add People" Page NewUI
    And I should see "errormsg-newui" named as "Leading white-space characters not allowed" for "First Name" on "Payment method" Page
    And I clear "FN" in "pow" Page
   		
	And I enter "max" value for "LN" textbox on "payment method" Page NewUI
    And I should see "errormsg-newui" named as "Max length (50) exceeded" for "Last Name" on "Payment method" Page
    And I clear "LN" in "pow" Page
    And I enter "empty" value for "LN" textbox on "Add People" Page NewUI
    And I should see "errormsg-newui" named as "Leading white-space characters not allowed" for "Last Name" on "Payment method" Page
    And I clear "LN" in "pow" Page
	
	And I enter "valid" value for "CardNumberAmex" textbox on "Add People" Page NewUI
	And I should see "element" named as "amex" on "Payment method" Page
	And I enter "valid" value for "CSC" textbox on "Add People" Page NewUI
	And I should see "errormsg-newui" named as "Invalid security code" for "CSC" on "Payment method" Page
	
	And I enter "invalidsupporter" value for "CardNumberVisa" textbox on "Add People" Page NewUI
	And I should see "errormsg-newui" named as "Unsupported Credit Card Issuer" for "CC Number" on "Payment method" Page
	And I enter "invalidlength" value for "CardNumberVisa" textbox on "Add People" Page NewUI
	And I should see "errormsg-newui" named as "Invalid credit card number length" for "CC Number" on "Payment method" Page
	And I enter "invalidCC" value for "CardNumberVisa" textbox on "Add People" Page NewUI
	And I should see "errormsg-newui" named as "Invalid credit card number" for "CC Number" on "Payment method" Page
	
	And I enter "present" value for "FN" textbox on "pow" Page NewUI
	And I enter "present" value for "LN" textbox on "pow" Page NewUI
	And I enter "valid" value for "CardNumberVisa" textbox on "Add People" Page NewUI
	And I enter "valid" value for "CSC" textbox on "Add People" Page NewUI
	And I enter "valid" value for "MM" textbox on "Add People" Page NewUI
	And I enter "valid" value for "YY" textbox on "Add People" Page NewUI
	
	When I Execute "Validate new Credit Card is not saved after clicking not on Save this card"
 	And I click on "button-newui" "Next button on PP" on "Payment Method" Page
    Then I should see Text "Order complete!"
	And I click on "MenuButton-NewUI" "Administration" on "HOME" Page
    And I click on "MenuButton-NewUI" "Your Payments" on "HOME" Page
    And I should not see element "new credit card"
    
    And I close browser
	
################################People Ordering Workflow - Credit Card Capture Screen - 6682#########################################     
@NewUI-PeopleOrderingWorkflow
@NewUI-POW-CreditCard
@NewUI-POW-CreditCard-PreviouslyUsedCC
Scenario: NewUI_SC10-Credit Card-PreviouslyUsedCC
	Given I initialize Browser
	When I am executing "NewUI_SC10-Credit Card-PreviouslyUsedCC" 
    And I navigate to "NewUI" application 
    
    Then I open only a new tab
	Then I switch between tabs "child"
	And I navigate to "Admin tool" application
	And I log in to admin tool select customer "XTDAUTOQCSA" for "QCSA"
	And I update Property "PROGRAM_PAYMENT_METHOD" to "Credit Card"  
	And I update Property "ENABLE_PA_INTEGRATION" to "Y"
	
	Then I close open tabs "child"
	And I clear the cache
	And I should see element "login page"

    When I log in to "autoqcs" New UI application with "valid" Credentials 
    And I click on "button-newui" "Login" on "Login" Page 
    And I click on "button-newui" "I Certify" on "NOTICE" Page

	When I click on "MenuButton-NewUI" "Administration" on "HOME" Page
	And I click on "MenuButton-NewUI" "Your Payments" on "HOME" Page
	When I click on "radiobutton-newui" "new" on "Payment Method" Page
	And I enter "valid" value for "FN" textbox on "Your Payments" Page NewUI
	And I enter "valid" value for "LN" textbox on "Your Payments" Page NewUI
	And I enter "valid" value for "CardNumberVisa" textbox on "Your Payments" Page NewUI
	And I enter "valid" value for "MM" textbox on "Your Payments" Page NewUI
	And I enter "valid" value for "YY" textbox on "Your Payments" Page NewUI
	And I enter "valid" value for "CSC" textbox on "Your Payments" Page NewUI

	And I click on "button-newui" "Save Card" on "administration" Page
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
	And I click on "button-newui" "Authorize" on "Shopping Cart" Page
	And I click on "button-NewUI" "Checkout" on "Shopping Cart" Page
	
	Then I should see Text "Payment method"
	And I should see element "Summary" for "POW"
	And I should see "text-newui" named as "Subtotal" on "Payment Method" Page
	#And I should see "text-newui" named as "Tax" on "Payment Method" Page
	And I should see "text-newui" named as "Order Total" on "Payment Method" Page
		
	And I click on "radiobutton-newui" "first credit card" on "payment method" Page
	And I should see element "Credit Card Number" for "readonly"
	And I should see element "YY" for "readonly"
	And I should see element "MM" for "readonly" 
	And I enter "present" value for "FN" textbox on "pow" Page NewUI
	And I enter "present" value for "LN" textbox on "pow" Page NewUI
	And I enter "valid" value for "CSC" textbox on "Add People" Page NewUI
	
	And I click on "button-newui" "Next button on PP" on "Payment Method" Page
    Then I should see Text "Order complete!"
	
	And I close browser	