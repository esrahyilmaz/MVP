Feature: Regression NewUI Site Credit Workflow
#************************************************************************************************************

################################ Site Credit Workflow#############################################
#pre-requistie for Sit Credit.
@NewUI-PeopleOrderingWorkflow
@NewUI-siteCreditworkflow
@SiteCreditPrerequisiteON
  Scenario: NewUI_SiteCreditPrerequiste
    Given I initialize Browser
    When I am executing "NewUI_SiteCreditPrerequiste"
    And I navigate to "NewUI" application
    And I log in to "qcsavc" New UI application with "valid" Credentials
    And Get "Cust_ID" from API
    And Get "Vendor_ID" from API
    Then Set Site Credit "ON"
    And I close browser
         
@NewUI-PeopleOrderingWorkflow
@NewUI-siteCreditworkflow
@NewUI-siteCreditSingleOrder
Scenario: NewUI_SC03-Site Credit Greater than Package Price Single Order Workflow
	Given I initialize Browser
	When I am executing "NewUI_SC03-Site Credit Greater than Package Price Single Order Workflow" 
	
    And I navigate to "NewUI" application

   Then I open only a new tab
	Then I switch between tabs "child"
	And I navigate to "Admin tool" application
    And I log in to admin tool select customer "QCSAAUTOVC" for "QCSA"
    And I update Property "XTDFORCE_API_PROGRAM" to "Null"
    And I update Property "PROGRAM_PAYMENT_METHOD" to "Credit Card"
    And I update Property "ENABLE_PA_INTEGRATION" to "Y"
	And I update Property "ENABLE_MULTIPLE_ORDERING" to "N"
	Then I close open tabs "child"
	And I clear the cache
	
	And I should see element "login page"
    When I log in to "qcsavc" New UI application with "valid" Credentials 
    And I click on "button-newui" "Login" on "Login" Page 
    And I click on "button-newui" "I Certify" on "NOTICE" Page 
   	And I click on "MenuButton-NewUI" "People" on "HOME" Page
    And I should see element "People"
    And I should see Text "Create Order"
    
    Then I click on "button-newui" " Create Order " on "People" Page
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
    
    And wait for "3" Seconds
    And I should see Text "Package Selection"
	When Search table By "package" in "Package Selection" page
	And I click on "button-newui" "search" on "package selection" Page
	And I click on "radiobutton-newui" "first pkg" on "package selection" Page
	And Verify value "Price" on "Package Selection" Page for DB "QCSA"
	And I click on "button-NewUI" "Add to Cart" on "package selection" Page
	
	And I should see Text "Shopping cart"
	And Verify Element "exist" with data-xf-qa-id "VW-POSC-PCKG-SEARCHFIELD" for "Search for Package"
	And Verify Element "exist" with data-xf-qa-id "VW-POSC-PCKG-SEARCHICON" for "Search for Package Icon"
	And I should see element "Accordion Shopping Cart" for "POW"
		
   And I should see element "shopping cart menu button count One" for "POW icon"
		
	#common	
	And I should see "text-newui" named as "person" on "Shopping Cart" Page
	And I should see "text-newui" named as "Price" on "Shopping Cart" Page
	And I should see element "Summary"
	And I should see element "Subtotal"
	And I should see "text-newui" named as "Subtotal:" on "Shopping Cart" Page
	And I should see element "Tax"
	And I should see "text-newui" named as "Tax:" on "Shopping Cart" Page
	And I should see element "Applied Credit"
	
	And I should see element "Order Total"
	And I should see "text-newui" named as "Order Total:" on "Shopping Cart" Page
	
	And I click on "button-NewUI" "Checkout" on "Shopping Cart" Page
	
	And I should see element "order icon" for "POW icon"
	And I should see element "order icon Section" for "POW icon"
	And I should see Text "Order Confirmation"
	And I should see Text "Here is your transaction number:"
	And I should see "element" named as "transaction number" on "order confirmation" Page
	And I should see Text "Paid via:"
	And I should see "text-newui" named as "Account Credit" on "Order Confirmation" Page
	And I should see Text "A confirmation notice with the order details will be sent to your email at"
	And Verify value "Vendor email" on "Order Confirmation" Page for DB "QCSA"
	And I should see Text "Choose an action below to continue"
	
	When I should see "button-newui" named as "Return to People" on "Add People" Page
	
	Then I click on "button-newui" "Return to People Page" on "order submission" Page
	And I should see element "shopping cart menu button icon" for "POW icon"
	And I should see element "People"
	And Search table By "FN & LN" in "pow" page
	And I click on "button-newui" "search" on "People" Page
 	
	And I should see element "by multi search"
    And I close browser
    
    
############################################Site Credit Multi Order Workflow#################
@NewUI-PeopleOrderingWorkflow
@NewUI-siteCreditworkflow
@NewUI-siteCreditMultiOrder
Scenario: NewUI_SC04-Site Credit Greater than Package Price Multi Order Workflow
	Given I initialize Browser
	When I am executing "NewUI_SC04-Site Credit Greater than Package Price Multi Order Workflow" 
    And I navigate to "NewUI" application
   
   Then I open only a new tab
	Then I switch between tabs "child"
	And I navigate to "Admin tool" application
    And I log in to admin tool select customer "QCSAAUTOVC" for "QCSA"
    And I update Property "XTDFORCE_API_PROGRAM" to "Null"
    And I update Property "PROGRAM_PAYMENT_METHOD" to "Credit Card"
    And I update Property "ENABLE_PA_INTEGRATION" to "Y"
	And I update Property "ENABLE_MULTIPLE_ORDERING" to "Y"
	Then I close open tabs "child"
	And I clear the cache
	
	And I should see element "login page"
    When I log in to "qcsavc" New UI application with "valid" Credentials 
    And I click on "button-newui" "Login" on "Login" Page 
    And I click on "button-newui" "I Certify" on "NOTICE" Page 
   	And I click on "MenuButton-NewUI" "People" on "HOME" Page
    And I should see element "People"
    And I should see Text "Create Order"
    
    #1 Order
    Then I click on "button-newui" " Create Order " on "People" Page
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
    
    And wait for "3" Seconds
    And I should see Text "Package Selection"
	When Search table By "package" in "Package Selection" page
	And I click on "button-newui" "search" on "package selection" Page
	And I click on "radiobutton-newui" "first pkg" on "package selection" Page
	And Verify value "Price" on "Package Selection" Page for DB "QCSA"
	And I click on "button-NewUI" "Add to Cart" on "package selection" Page
	
	And I should see Text "Shopping cart"
	And Verify Element "exist" with data-xf-qa-id "VW-POSC-PCKG-SEARCHFIELD" for "Search for Package"
	And Verify Element "exist" with data-xf-qa-id "VW-POSC-PCKG-SEARCHICON" for "Search for Package Icon"
	And I should see element "Accordion Shopping Cart" for "POW"
		
   And I should see element "shopping cart menu button count One" for "POW icon"
	
	#2rd order
	And I click on "button-NewUI" "Add Another Package" on "Shopping Cart" Page
	    
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
    
    And wait for "3" Seconds
    And I should see Text "Package Selection"
	When Search table By "package" in "Package Selection" page
	And I click on "button-newui" "search" on "package selection" Page
	And I click on "radiobutton-newui" "first pkg" on "package selection" Page
	And Verify value "Price" on "Package Selection" Page for DB "QCSA"
	And I click on "button-NewUI" "Add to Cart" on "package selection" Page
	
	And I should see Text "Shopping cart"
	And Verify Element "exist" with data-xf-qa-id "VW-POSC-PCKG-SEARCHFIELD" for "Search for Package"
	And Verify Element "exist" with data-xf-qa-id "VW-POSC-PCKG-SEARCHICON" for "Search for Package Icon"
	And I should see element "Accordion Shopping Cart" for "POW"
		
   And I should see element "shopping cart menu button count One" for "POW icon"
	
	#3rd order
	And I click on "button-NewUI" "Add Another Package" on "Shopping Cart" Page
    
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
    
    And wait for "3" Seconds
    And I should see Text "Package Selection"
	When Search table By "package" in "Package Selection" page
	And I click on "button-newui" "search" on "package selection" Page
	And I click on "radiobutton-newui" "first pkg" on "package selection" Page
	And Verify value "Price" on "Package Selection" Page for DB "QCSA"
	And I click on "button-NewUI" "Add to Cart" on "package selection" Page
	
	And I should see Text "Shopping cart"
	And Verify Element "exist" with data-xf-qa-id "VW-POSC-PCKG-SEARCHFIELD" for "Search for Package"
	And Verify Element "exist" with data-xf-qa-id "VW-POSC-PCKG-SEARCHICON" for "Search for Package Icon"
	And I should see element "Accordion Shopping Cart" for "POW"
		
   And I should see element "shopping cart menu button count One" for "POW icon"
	
	#common for all order:	
	And I should see "text-newui" named as "person" on "Shopping Cart" Page
	And I should see "text-newui" named as "Price" on "Shopping Cart" Page
	And I should see element "Summary"
	And I should see element "Subtotal"
	And I should see "text-newui" named as "Subtotal:" on "Shopping Cart" Page
	And I should see element "Tax"
	And I should see "text-newui" named as "Tax:" on "Shopping Cart" Page
	And I should see element "Applied Credit"
	And I should see element "Order Total"
	And I should see "text-newui" named as "Order Total:" on "Shopping Cart" Page
	
	And I click on "button-NewUI" "Checkout" on "Shopping Cart" Page
	
	And I should see element "order icon" for "POW icon"
	And I should see element "order icon Section" for "POW icon"
	And I should see Text "Order Confirmation"
	And I should see Text "Here is your transaction number:"
	And I should see "element" named as "transaction number" on "order confirmation" Page
	And I should see Text "Paid via:"
	And I should see "text-newui" named as "Account Credit" on "Order Confirmation" Page
	And I should see Text "A confirmation notice with the order details will be sent to your email at"
	And Verify value "Vendor email" on "Order Confirmation" Page for DB "QCSA"
	And I should see Text "Choose an action below to continue"
	
	When I should see "button-newui" named as "Return to People" on "Add People" Page	
	Then I click on "button-newui" "Return to People Page" on "order submission" Page
	And I should see element "shopping cart menu button icon" for "POW icon"
	And I should see element "People"
	And Search table By "FN & LN" in "pow" page
	And I click on "button-newui" "search" on "People" Page
 	
	And I should see element "by multi search"
    And I close browser
    
    
    ###########################################################################################################
 @NewUI-PeopleOrderingWorkflow
@NewUI-siteCreditworkflow
@SiteCreditPrerequisiteSetToPartialAmountPre
  Scenario: NewUI_SiteCreditPrerequiste
    Given I initialize Browser
    When I am executing "NewUI_SiteCreditPrerequiste"
    And I navigate to "NewUI" application
    And I log in to "qcsavc" New UI application with "valid" Credentials
    And Get "Cust_ID" from API
    And Get "Vendor_ID" from API
    Then Set Site Credit "PartialAmount"
    And I close browser
    
@NewUI-PeopleOrderingWorkflow
@NewUI-siteCreditworkflow
@NewUI-siteCreditMultiOrder
Scenario: NewUI_SC05-Site Credit partial amount for Multi Order Workflow
	Given I initialize Browser
	When I am executing "NewUI_SC05-Site Credit partial amount for Multi Order Workflow" 
    And I navigate to "NewUI" application
   
   Then I open only a new tab
	Then I switch between tabs "child"
	And I navigate to "Admin tool" application
    And I log in to admin tool select customer "QCSAAUTOVC" for "QCSA"
    And I update Property "XTDFORCE_API_PROGRAM" to "Null"
    And I update Property "PROGRAM_PAYMENT_METHOD" to "Credit Card"
    And I update Property "ENABLE_PA_INTEGRATION" to "Y"
	And I update Property "ENABLE_MULTIPLE_ORDERING" to "Y"
	Then I close open tabs "child"
	And I clear the cache
	
	And I should see element "login page"
    When I log in to "qcsavc" New UI application with "valid" Credentials 
    And I click on "button-newui" "Login" on "Login" Page 
    And I click on "button-newui" "I Certify" on "NOTICE" Page 
   	And I click on "MenuButton-NewUI" "People" on "HOME" Page
    And I should see element "People"
    And I should see Text "Create Order"
    
    #1 Order
    Then I click on "button-newui" " Create Order " on "People" Page
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
    
    And wait for "3" Seconds
    And I should see Text "Package Selection"
	When Search table By "package" in "Package Selection" page
	And I click on "button-newui" "search" on "package selection" Page
	And I click on "radiobutton-newui" "first pkg" on "package selection" Page
	And Verify value "Price" on "Package Selection" Page for DB "QCSA"
	And I click on "button-NewUI" "Add to Cart" on "package selection" Page
	
	And I should see Text "Shopping cart"
	And Verify Element "exist" with data-xf-qa-id "VW-POSC-PCKG-SEARCHFIELD" for "Search for Package"
	And Verify Element "exist" with data-xf-qa-id "VW-POSC-PCKG-SEARCHICON" for "Search for Package Icon"
	And I should see element "Accordion Shopping Cart" for "POW"
		
   And I should see element "shopping cart menu button count One" for "POW icon"
	
	#2rd order
	And I click on "button-NewUI" "Add Another Package" on "Shopping Cart" Page
	    
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
    
    And wait for "3" Seconds
    And I should see Text "Package Selection"
	When Search table By "package" in "Package Selection" page
	And I click on "button-newui" "search" on "package selection" Page
	And I click on "radiobutton-newui" "first pkg" on "package selection" Page
	And Verify value "Price" on "Package Selection" Page for DB "QCSA"
	And I click on "button-NewUI" "Add to Cart" on "package selection" Page
	
	And I should see Text "Shopping cart"
	And Verify Element "exist" with data-xf-qa-id "VW-POSC-PCKG-SEARCHFIELD" for "Search for Package"
	And Verify Element "exist" with data-xf-qa-id "VW-POSC-PCKG-SEARCHICON" for "Search for Package Icon"
	And I should see element "Accordion Shopping Cart" for "POW"
		
   And I should see element "shopping cart menu button count One" for "POW icon"
	
	#3rd order
	And I click on "button-NewUI" "Add Another Package" on "Shopping Cart" Page
    
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
    
    And wait for "3" Seconds
    And I should see Text "Package Selection"
	When Search table By "package" in "Package Selection" page
	And I click on "button-newui" "search" on "package selection" Page
	And I click on "radiobutton-newui" "first pkg" on "package selection" Page
	And Verify value "Price" on "Package Selection" Page for DB "QCSA"
	And I click on "button-NewUI" "Add to Cart" on "package selection" Page
	
	And I should see Text "Shopping cart"
	And Verify Element "exist" with data-xf-qa-id "VW-POSC-PCKG-SEARCHFIELD" for "Search for Package"
	And Verify Element "exist" with data-xf-qa-id "VW-POSC-PCKG-SEARCHICON" for "Search for Package Icon"
	And I should see element "Accordion Shopping Cart" for "POW"
		
   And I should see element "shopping cart menu button count One" for "POW icon"
	
	#common for all order:	
	And I should see "text-newui" named as "person" on "Shopping Cart" Page
	And I should see "text-newui" named as "Price" on "Shopping Cart" Page
	And I should see element "Summary"
	And I should see element "Subtotal"
	And I should see "text-newui" named as "Subtotal:" on "Shopping Cart" Page
	And I should see element "Tax"
	And I should see "text-newui" named as "Tax:" on "Shopping Cart" Page
	And I should see element "Applied Credit"
	And I should see element "Order Total"
	And I should see "text-newui" named as "Order Total:" on "Shopping Cart" Page
	
	And I click on "button-newui" "Authorize" on "Shopping Cart" Page	
	And I click on "button-NewUI" "Checkout" on "Shopping Cart" Page
	
	And wait for "3" Seconds
	Then I should see Text "Payment method"
	And I should see element "credit card icon" for "POW icon"
	And I should see element "credit card icon Section" for "POW icon"
	And I should see Text "Please choose one of the saved credit cards or enter your Card details below."
	And I should see Text "Credit Card Payment"
	And I should see Text "Previously used Credit Cards"
	And I should see Text "Use a new payment method"
	
	And I should see element "Summary"
	And I should see element "Subtotal"
	And I should see element "Tax"
	And I should see element "Applied Credit"
	And I should see element "Order Total"
	When I click on "radiobutton-newui" "new" on "Payment Method" Page
	And I enter "present" value for "FN" textbox on "pow" Page NewUI
  	And I enter "present" value for "LN" textbox on "pow" Page NewUI
	And I enter "valid" value for "CardNumberVisa" textbox on "Add People" Page NewUI
	And I enter "valid" value for "MM" textbox on "Add People" Page NewUI
	And I enter "valid" value for "YY" textbox on "Add People" Page NewUI
	And I enter "valid" value for "CSC" textbox on "Add People" Page NewUI
	
	And I click on "icon" "CSS Information" on "Payment Method" Page
	And I should see Text "3-4 Digits on the back of your Credit Card"
	And I should see Text "Save this card for future purchases"
    Then I click on "checkbox" "Save CC" on "payment method" Page
	
    And I click on "button-newui" "Next" on "payment method" Page 
	
	And I should see element "order icon" for "POW icon"
	And I should see element "order icon Section" for "POW icon"
	And I should see Text "Order Confirmation"
	And I should see Text "Here is your transaction number:"
	And I should see "element" named as "transaction number" on "order confirmation" Page
	And I should see Text "Paid via:"
	And I should see "text-newui" named as "Credit Card:" on "Order Confirmation" Page
	And I should see Text "A confirmation notice with the order details will be sent to your email at"
	And Verify value "Vendor email" on "Order Confirmation" Page for DB "QCSA"
	And I should see Text "Choose an action below to continue"
	
	When I should see "button-newui" named as "Return to People" on "Add People" Page	
	Then I click on "button-newui" "Return to People Page" on "order submission" Page
	And I should see element "shopping cart menu button icon" for "POW icon"
	And I should see element "People"
	And Search table By "FN & LN" in "pow" page
	And I click on "button-newui" "search" on "People" Page
 	
	#And I should see element "by multi search"
    And I close browser
    
    
    
    
    ###############################################################################################################
 @NewUI-PeopleOrderingWorkflow
@NewUI-siteCreditworkflow
@SiteCreditPrerequisiteConsumed
  Scenario: NewUI_SiteCreditPrerequiste
    Given I initialize Browser
    When I am executing "NewUI_SiteCreditPrerequiste"
    And I navigate to "NewUI" application
    And I log in to "qcsavc" New UI application with "valid" Credentials
    And Get "Cust_ID" from API
    And Get "Vendor_ID" from API
    Then Set Site Credit "PartialAmount"
    And I close browser
    
@NewUI-PeopleOrderingWorkflow
@NewUI-siteCreditworkflow
@NewUI-siteCreditMultiOrderConsumed
Scenario: NewUI_SC06-Site Credit consumed amount for Multi Order Workflow
	Given I initialize Browser
	When I am executing "NewUI_SC06-Site Credit consumed amount for Multi Order Workflow" 
    And I navigate to "NewUI" application
   
   Then I open only a new tab
	Then I switch between tabs "child"
	And I navigate to "Admin tool" application
    And I log in to admin tool select customer "QCSAAUTOVC" for "QCSA"
    And I update Property "XTDFORCE_API_PROGRAM" to "Null"
    And I update Property "PROGRAM_PAYMENT_METHOD" to "Credit Card"
    And I update Property "ENABLE_PA_INTEGRATION" to "Y"
	And I update Property "ENABLE_MULTIPLE_ORDERING" to "Y"
	Then I close open tabs "child"
	And I clear the cache
		
	And I should see element "login page"
    When I log in to "qcsavc" New UI application with "valid" Credentials 
    And I click on "button-newui" "Login" on "Login" Page 
    And I click on "button-newui" "I Certify" on "NOTICE" Page 
   	And I click on "MenuButton-NewUI" "People" on "HOME" Page
    And I should see element "People"
    And I should see Text "Create Order"
    
    #1 Order
    Then I click on "button-newui" " Create Order " on "People" Page
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
    
    And wait for "3" Seconds
    And I should see Text "Package Selection"
	When Search table By "package" in "Package Selection" page
	And I click on "button-newui" "search" on "package selection" Page
	And I click on "radiobutton-newui" "first pkg" on "package selection" Page
	And Verify value "Price" on "Package Selection" Page for DB "QCSA"
	And I click on "button-NewUI" "Add to Cart" on "package selection" Page
	
	And I should see Text "Shopping cart"
	And Verify Element "exist" with data-xf-qa-id "VW-POSC-PCKG-SEARCHFIELD" for "Search for Package"
	And Verify Element "exist" with data-xf-qa-id "VW-POSC-PCKG-SEARCHICON" for "Search for Package Icon"
	And I should see element "Accordion Shopping Cart" for "POW"
		
   And I should see element "shopping cart menu button count One" for "POW icon"
	
	#2rd order
	And I click on "button-NewUI" "Add Another Package" on "Shopping Cart" Page
	    
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
    
    And wait for "3" Seconds
    And I should see Text "Package Selection"
	When Search table By "package" in "Package Selection" page
	And I click on "button-newui" "search" on "package selection" Page
	And I click on "radiobutton-newui" "first pkg" on "package selection" Page
	And Verify value "Price" on "Package Selection" Page for DB "QCSA"
	And I click on "button-NewUI" "Add to Cart" on "package selection" Page
	
	And I should see Text "Shopping cart"
	And Verify Element "exist" with data-xf-qa-id "VW-POSC-PCKG-SEARCHFIELD" for "Search for Package"
	And Verify Element "exist" with data-xf-qa-id "VW-POSC-PCKG-SEARCHICON" for "Search for Package Icon"
	And I should see element "Accordion Shopping Cart" for "POW"
		
   And I should see element "shopping cart menu button count One" for "POW icon"
	
	#3rd order
	And I click on "button-NewUI" "Add Another Package" on "Shopping Cart" Page
    
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
    
    And wait for "3" Seconds
    And I should see Text "Package Selection"
	When Search table By "package" in "Package Selection" page
	And I click on "button-newui" "search" on "package selection" Page
	And I click on "radiobutton-newui" "first pkg" on "package selection" Page
	And Verify value "Price" on "Package Selection" Page for DB "QCSA"
	And I click on "button-NewUI" "Add to Cart" on "package selection" Page
	
	And I should see Text "Shopping cart"
	And Verify Element "exist" with data-xf-qa-id "VW-POSC-PCKG-SEARCHFIELD" for "Search for Package"
	And Verify Element "exist" with data-xf-qa-id "VW-POSC-PCKG-SEARCHICON" for "Search for Package Icon"
	And I should see element "Accordion Shopping Cart" for "POW"
		
   And I should see element "shopping cart menu button count One" for "POW icon"
	
	#common for all order:	
	And I should see "text-newui" named as "person" on "Shopping Cart" Page
	And I should see "text-newui" named as "Price" on "Shopping Cart" Page
	And I should see element "Summary"
	And I should see element "Subtotal"
	And I should see "text-newui" named as "Subtotal:" on "Shopping Cart" Page
	And I should see element "Tax"
	And I should see "text-newui" named as "Tax:" on "Shopping Cart" Page
	And I should see element "Applied Card"
	And I should see element "Order Total"
	And I should see "text-newui" named as "Order Total:" on "Shopping Cart" Page
	
	
	Then I open only a new tab
	Then I switch between tabs "child"
	And I navigate to "NewUI" application
    And I log in to "qcsavc" New UI application with "valid" Credentials
    And Get "Cust_ID" from API
    And Get "Vendor_ID" from API
    Then Set Site Credit "OFF"
	Then I close open tabs "child"
	
	And I click on "button-newui" "Authorize" on "Shopping Cart" Page	
	And I click on "button-NewUI" "Checkout" on "Shopping Cart" Page
	
	And wait for "3" Seconds
	Then I should see Text "Payment method"
	And I should see element "credit card icon" for "POW icon"
	And I should see element "credit card icon Section" for "POW icon"
	And I should see Text "Please choose one of the saved credit cards or enter your Card details below."
	And I should see Text "Credit Card Payment"
	And I should see Text "Previously used Credit Cards"
	And I should see Text "Use a new payment method"
	
	And I should see element "Summary"
	And I should see element "Subtotal"
	And I should see element "Tax"
	And I should see element "Applied Credit"
	And I should see element "Order Total"
	When I click on "radiobutton-newui" "new" on "Payment Method" Page
	And I enter "present" value for "FN" textbox on "pow" Page NewUI
  	And I enter "present" value for "LN" textbox on "pow" Page NewUI
	And I enter "valid" value for "CardNumberVisa" textbox on "Add People" Page NewUI
	And I enter "valid" value for "MM" textbox on "Add People" Page NewUI
	And I enter "valid" value for "YY" textbox on "Add People" Page NewUI
	And I enter "valid" value for "CSC" textbox on "Add People" Page NewUI
	
	And I click on "icon" "CSS Information" on "Payment Method" Page
	And I should see Text "3-4 Digits on the back of your Credit Card"
	And I should see Text "Save this card for future purchases"
    Then I click on "checkbox" "Save CC" on "payment method" Page
	
    And I click on "button-newui" "Next" on "payment method" Page 
    
    And I should see element "Order Total Revised Modal"
		And I should see Text "Order Total Revised"
		And I should see Text " The applied credit on your account has been consumed by another user.  Please review your cart and checkout. "
	  And I click on "button-newui" "Close" on "payment method" Page 
	
	
	#And I should see element "Summary"
	And I should see element "Subtotal"
	And I should see element "Tax"
	#And I should see element "Order Total"
	When I click on "radiobutton-newui" "first credit card" on "Payment Method" Page
	When I click on "radiobutton-newui" "new" on "Payment Method" Page
	And I enter "present" value for "FN" textbox on "pow" Page NewUI
  	And I enter "present" value for "LN" textbox on "pow" Page NewUI
	And I enter "valid" value for "CardNumberVisa" textbox on "Add People" Page NewUI
	And I enter "valid" value for "MM" textbox on "Add People" Page NewUI
	And I enter "valid" value for "YY" textbox on "Add People" Page NewUI
	And I enter "valid" value for "CSC" textbox on "Add People" Page NewUI
	
	And I click on "icon" "CSS Information" on "Payment Method" Page
	And I should see Text "3-4 Digits on the back of your Credit Card"
	And I should see Text "Save this card for future purchases"
    Then I click on "checkbox" "Save CC" on "payment method" Page
	
    And I click on "button-newui" "Next" on "payment method" Page 
    
    
	And I should see element "order icon" for "POW icon"
	And I should see element "order icon Section" for "POW icon"
	And I should see Text "Order Confirmation"
	And I should see Text "Here is your transaction number:"
	And I should see "element" named as "transaction number" on "order confirmation" Page
	And I should see Text "Paid via:"
	And I should see "text-newui" named as "Credit Card:" on "Order Confirmation" Page
	And I should see Text "A confirmation notice with the order details will be sent to your email at"
	And Verify value "Vendor email" on "Order Confirmation" Page for DB "QCSA"
	And I should see Text "Choose an action below to continue"
	
	When I should see "button-newui" named as "Return to People" on "Add People" Page	
	Then I click on "button-newui" "Return to People Page" on "order submission" Page
	And I should see element "shopping cart menu button icon" for "POW icon"
	And I should see element "People"
	And Search table By "FN & LN" in "pow" page
	And I click on "button-newui" "search" on "People" Page
    And I close browser