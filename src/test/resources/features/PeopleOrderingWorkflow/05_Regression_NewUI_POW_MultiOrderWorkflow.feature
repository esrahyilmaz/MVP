Feature: Regression NewUI Multi Order Workflow
#************************************************************************************************************

################################ Multi Ordering Workflow#############################################     
@NewUI-PeopleOrderingWorkflow
@NewUI-MultiOrderingWorkflow
@NewUI-MultiOrderingCreditCard
Scenario: NewUI_SC00-Multi Ordering With Credit Card Workflow
	Given I initialize Browser
	When I am executing "NewUI_SC00-Multi Ordering With Credit Card Workflow" 
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
    And I should see element "shopping cart menu button icon with Count Zero" for "POW icon"
   	And I click on "MenuButton-NewUI" "People" on "HOME" Page
    And I should see element "People"
    And I should see Text "Create Order"
    
    #1th order
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
    
    #And I enter "valid" value for "User Defined Field1" textbox on "Add People" Page NewUI
    #And I enter "valid" value for "User Defined Field2" textbox on "Add People" Page NewUI
    
    And I click on "button-newui" "Next" on "create person" Page 
    
    And wait for "3" Seconds
    And I should see Text "Package Selection"
	When Search table By "package" in "Package Selection" page
	And I click on "button-newui" "search" on "package selection" Page
	And I click on "radiobutton-newui" "first pkg" on "package selection" Page
	And Verify value "Price" on "Package Selection" Page for DB "QCSA"
	And I click on "button-NewUI" "Add to Cart" on "package selection" Page
	
	And wait for "3" Seconds
	And I should see Text "Shopping cart"
	And I should see element "shopping cart icon" for "POW icon"
	And I should see element "shopping cart icon Section" for "POW icon"
	And I should see Text "Place your order or add more packages to your cart." 
	And I should see element "Legalize language" for "Shopping cart"
	And I should see Text "Selected packages"
	And Verify Element "exist" with data-xf-qa-id "VW-POSC-PCKG-SEARCHFIELD" for "Search for Package"
	And Verify Element "exist" with data-xf-qa-id "VW-POSC-PCKG-SEARCHICON" for "Search for Package Icon"
	And I should see element "Accordion Shopping Cart" for "POW"
	
	When I Execute "Validate Package search in Shopping cart"
	When Search table By "package" in "shopping cart" page
	And I click on "button-newui" "search" on "shopping cart" Page
		
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
    
    # And I enter "valid" value for "User Defined Field1" textbox on "Add People" Page NewUI
    #And I enter "valid" value for "User Defined Field2" textbox on "Add People" Page NewUI
    
    And I click on "button-newui" "Next" on "create person" Page 
    
    And wait for "3" Seconds
    And I should see Text "Package Selection"
	When Search table By "package" in "Package Selection" page
	And I click on "button-newui" "search" on "package selection" Page
	And I click on "radiobutton-newui" "first pkg" on "package selection" Page
	And Verify value "Price" on "Package Selection" Page for DB "QCSA"
	And I click on "button-NewUI" "Add to Cart" on "package selection" Page
	
	And wait for "3" Seconds
	And I should see Text "Shopping cart"
	And I should see element "shopping cart icon" for "POW icon"
	And I should see element "shopping cart icon Section" for "POW icon"
	And I should see Text "Place your order or add more packages to your cart." 
	And I should see element "Legalize language" for "Shopping cart"
	And I should see Text "Selected packages"
	And Verify Element "exist" with data-xf-qa-id "VW-POSC-PCKG-SEARCHFIELD" for "Search for Package"
	And Verify Element "exist" with data-xf-qa-id "VW-POSC-PCKG-SEARCHICON" for "Search for Package Icon"
	And I should see element "Accordion Shopping Cart" for "POW"
	
	When I Execute "Validate Package search in Shopping cart"
	When Search table By "package" in "shopping cart" page
	And I click on "button-newui" "search" on "shopping cart" Page
	
	And I should see element "shopping cart menu button count two" for "POW icon"
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
    
   #  And I enter "valid" value for "User Defined Field1" textbox on "Add People" Page NewUI
   # And I enter "valid" value for "User Defined Field2" textbox on "Add People" Page NewUI
       
    And I click on "button-newui" "Next" on "create person" Page 
    
    And wait for "3" Seconds
    And I should see Text "Package Selection"
	When Search table By "package" in "Package Selection" page
	And I click on "button-newui" "search" on "package selection" Page
	And I click on "radiobutton-newui" "first pkg" on "package selection" Page
	And Verify value "Price" on "Package Selection" Page for DB "QCSA"
	And I click on "button-NewUI" "Add to Cart" on "package selection" Page
	
	And wait for "3" Seconds
	And I should see Text "Shopping cart"
	And I should see element "shopping cart icon" for "POW icon"
	And I should see element "shopping cart icon Section" for "POW icon"
	And I should see Text "Place your order or add more packages to your cart." 
	And I should see element "Legalize language" for "Shopping cart"
	And I should see Text "Selected packages"
	And Verify Element "exist" with data-xf-qa-id "VW-POSC-PCKG-SEARCHFIELD" for "Search for Package"
	And Verify Element "exist" with data-xf-qa-id "VW-POSC-PCKG-SEARCHICON" for "Search for Package Icon"
	And I should see element "Accordion Shopping Cart" for "POW"
	
	When I Execute "Validate Package search in Shopping cart"
	When Search table By "package" in "shopping cart" page
	And I click on "button-newui" "search" on "shopping cart" Page
	
	#common for all order:	
	When I Execute "Validate Price is displayed when PPM is Credit Card"
	
	And wait for "3" Seconds
	And I should see Text "Shopping cart"
	#And I should see element "Person Name Label"
	And I should see "text-newui" named as "person" on "Shopping Cart" Page
	#And I should see element "Package Name Label"
	#And I should see element "Package Price Label"
	And I should see "text-newui" named as "Price" on "Shopping Cart" Page
	And I should see element "Summary"
	And I should see element "Subtotal"
	And I should see "text-newui" named as "Subtotal:" on "Shopping Cart" Page
	And I should see element "Tax"
	And I should see "text-newui" named as "Tax:" on "Shopping Cart" Page
	And I should see element "Order Total"
	And I should see "text-newui" named as "Order Total:" on "Shopping Cart" Page

	
	When I Execute "Validate item isn't deleted from shopping cart by clicking on No button"
	And I click on "button-newui" "delete" on "Shopping cart" Page
	And I should see "text-newui" named as "Are you sure you want to remove:" on "Shopping cart" Page
	And I should see "text-newui" named as "XTDForce Package for PA" on "Shopping cart" Page
	And I should see "text-newui" named as "Don`t ask me again" on "Shopping cart" Page
	And I click on "button-newui" "No" on "Shopping cart" Page
	  #And I should see "text-newui" named as "Package Name" on "Shopping Cart" Page
	
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
	#And I should see "text-newui" named as "Subtotal:" on "Shopping Cart" Page
	And I should see element "Tax"
	#And I should see "text-newui" named as "Tax:" on "Shopping Cart" Page
	And I should see element "Order Total"
	#And I should see "text-newui" named as "Order Total:" on "Shopping Cart" Page
	#And I should see element "If you logout, all of the items in the cart will be lost" for "POW"
	
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
	
    And I click on "button-newui" "Next" on "payment method" Page 
	
	
	
	And I should see element "order icon" for "POW icon"
	And I should see element "order icon Section" for "POW icon"
	And I should see Text "Order Confirmation"
	And I should see Text "Here is your transaction number:"
	And I should see "element" named as "transaction number" on "order confirmation" Page
	And I should see Text "Paid via:"
	And I should see "text-newui" named as "Credit Card" on "Order Confirmation" Page
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
    
    
#******************************************************************************************************************************

################################ Multi Ordering Vendor Invoice Workflow#########################################     
@NewUI-PeopleOrderingWorkflow
@NewUI-MultiOrderingWorkflow
@NewUI-MultiOrderingVendorInvoice
Scenario: NewUI_SC01-Multi Ordering With Vendor Invoice Workflow
	Given I initialize Browser
	When I am executing "NewUI_SC01-Multi Ordering With Vendor Invoice Workflow" 
    And I navigate to "NewUI" application 
    
   Then I open only a new tab
	Then I switch between tabs "child"
	And I navigate to "Admin tool" application
	And I log in to admin tool select customer "XTDAUTOQCSA" for "QCSA"
    And I update Property "PROGRAM_PAYMENT_METHOD" to "Vendor Invoice"
    And I update Property "ENABLE_PA_INTEGRATION" to "Y"
	And I update Property "ENABLE_MULTIPLE_ORDERING" to "Y"
	Then I close open tabs "child"
	And I clear the cache
	
	And I should see element "login page"
    When I log in to "autoqcs" New UI application with "valid" Credentials
    And I click on "button-newui" "Login" on "Login" Page 
    And I click on "button-newui" "I Certify" on "NOTICE" Page 
   	And I click on "MenuButton-NewUI" "People" on "HOME" Page
    And I should see element "People"
    And I should see Text "Create Order"
    
    #1th order
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
    
    #And I enter "valid" value for "User Defined Field1" textbox on "Add People" Page NewUI
    #And I enter "valid" value for "User Defined Field2" textbox on "Add People" Page NewUI
    
    And I click on "button-newui" "Next" on "create person" Page 
    
    And wait for "3" Seconds
    And I should see Text "Package Selection"
	When Search table By "package" in "Package Selection" page
	And I click on "button-newui" "search" on "package selection" Page
	And I click on "radiobutton-newui" "first pkg" on "package selection" Page
	And Verify value "Price" on "Package Selection" Page for DB "QCSA"
	And I click on "button-NewUI" "Add to Cart" on "package selection" Page
	
	And wait for "3" Seconds
	And I should see Text "Shopping cart"
	And I should see element "shopping cart icon" for "POW icon"
	And I should see element "shopping cart icon Section" for "POW icon"
	And I should see Text "Place your order or add more packages to your cart." 
	And I should see element "Legalize language" for "Shopping cart"
	And I should see Text "Selected packages"
	And Verify Element "exist" with data-xf-qa-id "VW-POSC-PCKG-SEARCHFIELD" for "Search for Package"
	And Verify Element "exist" with data-xf-qa-id "VW-POSC-PCKG-SEARCHICON" for "Search for Package Icon"
	And I should see element "Accordion Shopping Cart" for "POW"
	
	When I Execute "Validate Package search in Shopping cart"
	When Search table By "package" in "shopping cart" page
	And I click on "button-newui" "search" on "shopping cart" Page
		
	And I click on "button-newui" "delete" on "Shopping cart" Page
	And I should see "text-newui" named as "Are you sure you want to remove:" on "Shopping cart" Page
	And I should see "text-newui" named as "XTDForce Package for PA" on "Shopping cart" Page
	And I should see "text-newui" named as "Don`t ask me again" on "Shopping cart" Page
	And I click on "button-newui" "Yes" on "Shopping cart" Page
	And I should see element "Checkout" for "Disabled"
	
	
	#2rd order
	And I click on "button-NewUI" "Add Another Package" on "Shopping Cart" Page
	    
    #And I click on "button-newui" "Middle Name Yes" on "create person" Page
	And I enter "valid" value for "FN" textbox on "create person" Page NewUI
	#And I enter "valid" value for "MN" textbox on "create person" Page NewUI
	And I enter "valid" value for "LN" textbox on "create person" Page NewUI
    And I enter "valid" value for "email" textbox on "create person" Page NewUI
    And I enter "valid" value for "re-enter email" textbox on "create person" Page NewUI  
	And I enter "valid" value for "Country" textbox on "create person" Page NewUI     
    And I enter "valid" value for "City" textbox on "create person" Page NewUI 
    And I enter "valid" value for "State" textbox on "create person" Page NewUI     
    
    # And I enter "valid" value for "User Defined Field1" textbox on "Add People" Page NewUI
    #And I enter "valid" value for "User Defined Field2" textbox on "Add People" Page NewUI
    
    And I click on "button-newui" "Next" on "create person" Page 
    
    And wait for "3" Seconds
    And I should see Text "Package Selection"
	When Search table By "package" in "Package Selection" page
	And I click on "button-newui" "search" on "package selection" Page
	And I click on "radiobutton-newui" "first pkg" on "package selection" Page
	And Verify value "Price" on "Package Selection" Page for DB "QCSA"
	And I click on "button-NewUI" "Add to Cart" on "package selection" Page
	
	And wait for "3" Seconds
	And I should see Text "Shopping cart"
	And I should see element "shopping cart icon" for "POW icon"
	And I should see element "shopping cart icon Section" for "POW icon"
	And I should see Text "Place your order or add more packages to your cart." 
	And I should see element "Legalize language" for "Shopping cart"
	And I should see Text "Selected packages"
	And Verify Element "exist" with data-xf-qa-id "VW-POSC-PCKG-SEARCHFIELD" for "Search for Package"
	And Verify Element "exist" with data-xf-qa-id "VW-POSC-PCKG-SEARCHICON" for "Search for Package Icon"
	And I should see element "Accordion Shopping Cart" for "POW"
	
	When I Execute "Validate Package search in Shopping cart"
	When Search table By "package" in "shopping cart" page
	And I click on "button-newui" "search" on "shopping cart" Page
	
	#3rd order
	And I click on "button-NewUI" "Add Another Package" on "Shopping Cart" Page
    
    #And I click on "button-newui" "Middle Name Yes" on "create person" Page
	And I enter "valid" value for "FN" textbox on "create person" Page NewUI
	#And I enter "valid" value for "MN" textbox on "create person" Page NewUI
	And I enter "valid" value for "LN" textbox on "create person" Page NewUI
    And I enter "valid" value for "email" textbox on "create person" Page NewUI
    And I enter "valid" value for "re-enter email" textbox on "create person" Page NewUI  
	And I enter "valid" value for "Country" textbox on "create person" Page NewUI     
    And I enter "valid" value for "City" textbox on "create person" Page NewUI 
    And I enter "valid" value for "State" textbox on "create person" Page NewUI  
    
   #  And I enter "valid" value for "User Defined Field1" textbox on "Add People" Page NewUI
   # And I enter "valid" value for "User Defined Field2" textbox on "Add People" Page NewUI
       
    And I click on "button-newui" "Next" on "create person" Page 
    
    And wait for "3" Seconds
    And I should see Text "Package Selection"
	When Search table By "package" in "Package Selection" page
	And I click on "button-newui" "search" on "package selection" Page
	And I click on "radiobutton-newui" "first pkg" on "package selection" Page
	And Verify value "Price" on "Package Selection" Page for DB "QCSA"
	And I click on "button-NewUI" "Add to Cart" on "package selection" Page
	
	And wait for "3" Seconds
	And I should see Text "Shopping cart"
	And I should see element "shopping cart icon" for "POW icon"
	And I should see element "shopping cart icon Section" for "POW icon"
	And I should see Text "Place your order or add more packages to your cart." 
	And I should see element "Legalize language" for "Shopping cart"
	And I should see Text "Selected packages"
	And Verify Element "exist" with data-xf-qa-id "VW-POSC-PCKG-SEARCHFIELD" for "Search for Package"
	And Verify Element "exist" with data-xf-qa-id "VW-POSC-PCKG-SEARCHICON" for "Search for Package Icon"
	And I should see element "Accordion Shopping Cart" for "POW"
	
	When I Execute "Validate Package search in Shopping cart"
	When Search table By "package" in "shopping cart" page
	And I click on "button-newui" "search" on "shopping cart" Page
	
	#common for all order:	
	When I Execute "Validate Price is displayed when PPM is Credit Card"
	
	And wait for "3" Seconds
	And I should see Text "Shopping cart"
	#And I should see element "Person Name Label"
	And I should see "text-newui" named as "person" on "Shopping Cart" Page
	#And I should see element "Package Name Label"
	#And I should see element "Package Price Label"
	And I should see "text-newui" named as "Price" on "Shopping Cart" Page
	And I should see element "Summary"
	And I should see element "Subtotal"
	And I should see "text-newui" named as "Subtotal:" on "Shopping Cart" Page
	And I should see element "Tax"
	And I should see "text-newui" named as "Tax:" on "Shopping Cart" Page
	And I should see element "Order Total"
	And I should see "text-newui" named as "Order Total:" on "Shopping Cart" Page

	
	When I Execute "Validate item isn't deleted from shopping cart by clicking on No button"
	And I click on "button-newui" "delete" on "Shopping cart" Page
	And I should see "text-newui" named as "Are you sure you want to remove:" on "Shopping cart" Page
	And I should see "text-newui" named as "XTDForce Package for PA" on "Shopping cart" Page
	And I should see "text-newui" named as "Don`t ask me again" on "Shopping cart" Page
	And I click on "button-newui" "No" on "Shopping cart" Page
	  #And I should see "text-newui" named as "Package Name" on "Shopping Cart" Page
	
	And I click on "button-NewUI" "Checkout" on "Shopping Cart" Page
	And wait for "3" Seconds

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
	
	When I should see "button-newui" named as "Return to People" on "Add People" Page
	
	Then I click on "button-newui" "Return to People Page" on "order submission" Page
	And I should see element "People"
	And Search table By "FN & LN" in "pow" page
	And I click on "button-newui" "search" on "People" Page
 	
	#And I should see element "by multi search"
    And I close browser
    
    #############################################Multi EA Customer Order With Credit Card Workflow####################################################
 @NewUI-PeopleOrderingWorkflow
 @NewUI-MultiOrderingWorkflow
@NewUI-MultiOrderingCreditCardEACustomerOrderWorkflow
Scenario: NewUI_SC02-Multi Customer Order With Credit Card Workflow
	Given I initialize Browser
	When I am executing "NewUI_SC02-Multi Customer Order With Credit Card Workflow" 
    And I navigate to "NewUI" application 
    
   Then I open only a new tab
	Then I switch between tabs "child"
	And I navigate to "Admin tool" application
	And I log in to admin tool select customer "QCSAAUTOVC" for "QCSA"
    And I update Property "PROGRAM_PAYMENT_METHOD" to "Credit Card"
    And I update Property "ENABLE_PA_INTEGRATION" to "Both"
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
    
    #1th order
    Then I click on "button-newui" " Create Order " on "People" Page
    
    And I should see element "Select Options Modal"
    And I should see Text "Email to Applicant"
    And I should see Text "Customer Order"
    And I click on "button-newui" "Select Option for Customer Order" on "customer order" Page
    
    And I should see Text "Personal information"
    And I click on "button-newui" "Middle Name Yes" on "create person" Page
	And I enter "valid" value for "FN" textbox on "create person" Page NewUI
	And I enter "valid" value for "MN" textbox on "create person" Page NewUI
	And I enter "valid" value for "LN" textbox on "create person" Page NewUI
	
	And I enter "CompliantOrder" value for "Date Of Birth" textbox on "create person" Page NewUI
    And I enter "valid" value for "email" textbox on "create person" Page NewUI
    And I enter "valid" value for "re-enter email" textbox on "create person" Page NewUI  
    
    And I enter "valid" value for "calling code" textbox on "create person" Page NewUI
    And I enter "valid" value for "phone number" textbox on "create person" Page NewUI
    
    And I enter "valid" value for "eaCountry" textbox on "create person" Page NewUI
    And I enter "valid" value for "eaAddress1" textbox on "create person" Page NewUI
   
    And I enter "valid" value for "eaState" textbox on "create person" Page NewUI
    And I enter "valid" value for "eaCity" textbox on "create person" Page NewUI 
    And I enter "valid" value for "eaZipCode" textbox on "create person" Page NewUI 
    
	And I enter "valid" value for "Country" textbox on "create person" Page NewUI     
    And I enter "valid" value for "City" textbox on "create person" Page NewUI 
    And I enter "valid" value for "State" textbox on "create person" Page NewUI     
    
    And I enter "valid" value for "eaCountry" textbox on "identification form" Page NewUI
    And I enter "valid" value for "Document Type" textbox on "identification form" Page NewUI
    And I enter "CompliantOrder" value for "Document Number" textbox on "identification form" Page NewUI
    And I enter "CompliantOrder" value for "re-enter Document Number" textbox on "identification form" Page NewUI
    
    
    And I click on "button-newui" "Next" on "create person" Page 
    
    And wait for "3" Seconds
    And I should see Text "Package Selection"
	When Search table By "package" in "Package Selection" page
	And I click on "button-newui" "search" on "package selection" Page
	And I click on "radiobutton-newui" "first pkg" on "package selection" Page
	And Verify value "Price" on "Package Selection" Page for DB "QCSA"
	And I click on "button-NewUI" "Add to Cart" on "package selection" Page
	
	And wait for "3" Seconds
	And I should see Text "Shopping cart"
	And I should see element "shopping cart icon" for "POW icon"
	And I should see element "shopping cart icon Section" for "POW icon"
	And I should see Text "Place your order or add more packages to your cart." 
	And I should see element "Legalize language" for "Shopping cart"
	And I should see Text "Selected packages"
	And Verify Element "exist" with data-xf-qa-id "VW-POSC-PCKG-SEARCHFIELD" for "Search for Package"
	And Verify Element "exist" with data-xf-qa-id "VW-POSC-PCKG-SEARCHICON" for "Search for Package Icon"
	And I should see element "Accordion Shopping Cart" for "POW"
	
	When I Execute "Validate Package search in Shopping cart"
	When Search table By "package" in "shopping cart" page
	And I click on "button-newui" "search" on "shopping cart" Page
		
	#2rd order
	And I click on "button-NewUI" "Add Another Package" on "Shopping Cart" Page
	    
	    And I should see element "Select Options Modal"
    And I should see Text "Email to Applicant"
    And I should see Text "Customer Order"
    And I click on "button-newui" "Select Option for Customer Order" on "Customer Order" Page
    
    And I should see Text "Personal information"
    And I click on "button-newui" "Middle Name Yes" on "create person" Page
	And I enter "valid" value for "FN" textbox on "create person" Page NewUI
	And I enter "valid" value for "MN" textbox on "create person" Page NewUI
	And I enter "valid" value for "LN" textbox on "create person" Page NewUI
	
	And I enter "CompliantOrder" value for "Date Of Birth" textbox on "create person" Page NewUI
    And I enter "valid" value for "email" textbox on "create person" Page NewUI
    And I enter "valid" value for "re-enter email" textbox on "create person" Page NewUI  
    
    And I enter "valid" value for "calling code" textbox on "create person" Page NewUI
    And I enter "valid" value for "phone number" textbox on "create person" Page NewUI
    
    And I enter "valid" value for "eaCountry" textbox on "create person" Page NewUI
    And I enter "valid" value for "eaAddress1" textbox on "create person" Page NewUI
   
    And I enter "valid" value for "eaState" textbox on "create person" Page NewUI
    And I enter "valid" value for "eaCity" textbox on "create person" Page NewUI 
    And I enter "valid" value for "eaZipCode" textbox on "create person" Page NewUI 
    
	And I enter "valid" value for "Country" textbox on "create person" Page NewUI     
    And I enter "valid" value for "City" textbox on "create person" Page NewUI 
    And I enter "valid" value for "State" textbox on "create person" Page NewUI     
    
    And I enter "valid" value for "eaCountry" textbox on "identification form" Page NewUI
    And I enter "valid" value for "Document Type" textbox on "identification form" Page NewUI
    And I enter "CompliantOrder" value for "Document Number" textbox on "identification form" Page NewUI
    And I enter "CompliantOrder" value for "re-enter Document Number" textbox on "identification form" Page NewUI
    
    And I click on "button-newui" "Next" on "create person" Page 
    
    And wait for "3" Seconds
    And I should see Text "Package Selection"
	When Search table By "package" in "Package Selection" page
	And I click on "button-newui" "search" on "package selection" Page
	And I click on "radiobutton-newui" "first pkg" on "package selection" Page
	And Verify value "Price" on "Package Selection" Page for DB "QCSA"
	And I click on "button-NewUI" "Add to Cart" on "package selection" Page
	
	And wait for "3" Seconds
	And I should see Text "Shopping cart"
	And I should see element "shopping cart icon" for "POW icon"
	And I should see element "shopping cart icon Section" for "POW icon"
	And I should see Text "Place your order or add more packages to your cart." 
	And I should see element "Legalize language" for "Shopping cart"
	And I should see Text "Selected packages"
	And Verify Element "exist" with data-xf-qa-id "VW-POSC-PCKG-SEARCHFIELD" for "Search for Package"
	And Verify Element "exist" with data-xf-qa-id "VW-POSC-PCKG-SEARCHICON" for "Search for Package Icon"
	And I should see element "Accordion Shopping Cart" for "POW"
	
	When I Execute "Validate Package search in Shopping cart"
	When Search table By "package" in "shopping cart" page
	And I click on "button-newui" "search" on "shopping cart" Page
	
	#3rd order
	And I click on "button-NewUI" "Add Another Package" on "Shopping Cart" Page
    And I should see element "Select Options Modal"
    And I should see Text "Email to Applicant"
    And I should see Text "Customer Order"
    And I click on "button-newui" "Select Option for Customer Order" on "Customer Order" Page
    
    And I should see Text "Personal information"
    And I click on "button-newui" "Middle Name Yes" on "create person" Page
	And I enter "valid" value for "FN" textbox on "create person" Page NewUI
	And I enter "valid" value for "MN" textbox on "create person" Page NewUI
	And I enter "valid" value for "LN" textbox on "create person" Page NewUI
	
	And I enter "CompliantOrder" value for "Date Of Birth" textbox on "create person" Page NewUI
    And I enter "valid" value for "email" textbox on "create person" Page NewUI
    And I enter "valid" value for "re-enter email" textbox on "create person" Page NewUI  
    
    And I enter "valid" value for "calling code" textbox on "create person" Page NewUI
    And I enter "valid" value for "phone number" textbox on "create person" Page NewUI
    
    And I enter "valid" value for "eaCountry" textbox on "create person" Page NewUI
    And I enter "valid" value for "eaAddress1" textbox on "create person" Page NewUI
   
    And I enter "valid" value for "eaState" textbox on "create person" Page NewUI
    And I enter "valid" value for "eaCity" textbox on "create person" Page NewUI 
    And I enter "valid" value for "eaZipCode" textbox on "create person" Page NewUI 
    
	And I enter "valid" value for "Country" textbox on "create person" Page NewUI     
    And I enter "valid" value for "City" textbox on "create person" Page NewUI 
    And I enter "valid" value for "State" textbox on "create person" Page NewUI     
    
    And I enter "valid" value for "eaCountry" textbox on "identification form" Page NewUI
    And I enter "valid" value for "Document Type" textbox on "identification form" Page NewUI
    And I enter "CompliantOrder" value for "Document Number" textbox on "identification form" Page NewUI
    And I enter "CompliantOrder" value for "re-enter Document Number" textbox on "identification form" Page NewUI
    
    And I click on "button-newui" "Next" on "create person" Page 
    
    And wait for "3" Seconds
    And I should see Text "Package Selection"
	When Search table By "package" in "Package Selection" page
	And I click on "button-newui" "search" on "package selection" Page
	And I click on "radiobutton-newui" "first pkg" on "package selection" Page
	And Verify value "Price" on "Package Selection" Page for DB "QCSA"
	And I click on "button-NewUI" "Add to Cart" on "package selection" Page
	
	And wait for "3" Seconds
	And I should see Text "Shopping cart"
	And I should see element "shopping cart icon" for "POW icon"
	And I should see element "shopping cart icon Section" for "POW icon"
	And I should see Text "Place your order or add more packages to your cart." 
	And I should see element "Legalize language" for "Shopping cart"
	And I should see Text "Selected packages"
	And Verify Element "exist" with data-xf-qa-id "VW-POSC-PCKG-SEARCHFIELD" for "Search for Package"
	And Verify Element "exist" with data-xf-qa-id "VW-POSC-PCKG-SEARCHICON" for "Search for Package Icon"
	And I should see element "Accordion Shopping Cart" for "POW"
	
	When I Execute "Validate Package search in Shopping cart"
	When Search table By "package" in "shopping cart" page
	And I click on "button-newui" "search" on "shopping cart" Page
	
	#common for all order:	
	When I Execute "Validate Price is displayed when PPM is Credit Card"
	
	And wait for "3" Seconds
	And I should see Text "Shopping cart"
	#And I should see element "Person Name Label"
	And I should see "text-newui" named as "person" on "Shopping Cart" Page
	#And I should see element "Package Name Label"
	#And I should see element "Package Price Label"
	And I should see "text-newui" named as "Price" on "Shopping Cart" Page
	And I should see element "Summary"
	And I should see element "Subtotal"
	And I should see "text-newui" named as "Subtotal:" on "Shopping Cart" Page
	And I should see element "Tax"
	And I should see "text-newui" named as "Tax:" on "Shopping Cart" Page
	And I should see element "Order Total"
	And I should see "text-newui" named as "Order Total:" on "Shopping Cart" Page

	
	When I Execute "Validate item isn't deleted from shopping cart by clicking on No button"
	And I click on "button-newui" "delete" on "Shopping cart" Page
	And I should see "text-newui" named as "Are you sure you want to remove:" on "Shopping cart" Page
	And I should see "text-newui" named as "XTDForce Package for PA" on "Shopping cart" Page
	And I should see "text-newui" named as "Don`t ask me again" on "Shopping cart" Page
	And I click on "button-newui" "No" on "Shopping cart" Page
	  #And I should see "text-newui" named as "Package Name" on "Shopping Cart" Page
	
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
	#And I should see "text-newui" named as "Subtotal:" on "Shopping Cart" Page
	And I should see element "Tax"
	#And I should see "text-newui" named as "Tax:" on "Shopping Cart" Page
	And I should see element "Order Total"
	#And I should see "text-newui" named as "Order Total:" on "Shopping Cart" Page
	#And I should see element "If you logout, all of the items in the cart will be lost" for "POW"
	
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
	And I should see "text-newui" named as "Credit Card" on "Order Confirmation" Page
	And I should see Text "A confirmation notice with the order details will be sent to your email at"
	And Verify value "Vendor email" on "Order Confirmation" Page for DB "QCSA"
	And I should see Text "Choose an action below to continue"
	
	When I should see "button-newui" named as "Return to People" on "Add People" Page
	
	Then I click on "button-newui" "Return to People Page" on "order submission" Page
	And I should see element "People"
	And Search table By "FN & LN" in "create person" page
	And I click on "button-newui" "search" on "People" Page
 	And Get the "NewProfileId" From DB in "QCSA"
	#And I should see element "by multi search"
    And I close browser
    