Feature: Regression NewUI People Order Workflow - Shopping Cart
#******************************************************************************************************************************

################################People Ordering Workflow -  Shopping Cart Screen - 3217 #########################################     
@NewUI-PeopleOrderingWorkflow
@NewUI-POW-ShoppingCart
@NewUI-POW-ShoppingCart-01
Scenario: NewUI_SC06-Shopping Cart
	Given I initialize Browser 
	And I am executing "NewUI_SC06-Shopping Cart" 
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
    
    And I should see Text "Package Selection"
	When Search table By "package" in "Package Selection" page
	And I click on "button-newui" "search" on "package selection" Page
	And I click on "radiobutton-newui" "first pkg" on "package selection" Page
	And Verify value "Price" on "Package Selection" Page for DB "QCSA"
	And I click on "button-NewUI" "Add to Cart" on "package selection" Page
	
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
		
	When I Execute "Validate Price is displayed when PPM is Credit Card"
	And I should see element "Person Name Label"
	And I should see "text-newui" named as "person" on "Shopping Cart" Page
	And I should see element "Package Name Label"
	And I should see element "Package Price Label"
	And I should see "text-newui" named as "Price" on "Shopping Cart" Page
	And I should see element "Summary"
	And I should see element "Subtotal"
	And I should see "text-newui" named as "Subtotal" on "Shopping Cart" Page
	And I should see element "Tax"
	And I should see "text-newui" named as "Tax:" on "Shopping Cart" Page
	And I should see element "Order Total"
	And I should see "text-newui" named as "Order Total" on "Shopping Cart" Page
	
	When I Execute "Validate item isn't deleted from shopping cart by clicking on No button"
	And I click on "button-newui" "delete" on "Shopping cart" Page
	And I should see "text-newui" named as "Are you sure you want to remove:" on "Shopping cart" Page
	And I should see "text-newui" named as "XTDForce Package for PA" on "Shopping cart" Page
	And I should see "text-newui" named as "Don`t ask me again" on "Shopping cart" Page
	And I click on "button-newui" "No" on "Shopping cart" Page
	#And I should see "text-newui" named as "existing Package" on "Shopping Cart" Page
	
	And I click on "button-newui" "Authorize" on "Shopping Cart" Page
	
	And I click on "button-NewUI" "Checkout" on "Shopping Cart" Page
	Then I should see Text "Payment method"
	And I close browser
			
################################People Ordering Workflow -  Shopping Cart Screen - 3217 #########################################     
@NewUI-PeopleOrderingWorkflow
@NewUI-POW-ShoppingCart 
@NewUI-POW-ShoppingCart-ProgramPaymentMethods
Scenario: NewUI_SC07-Shopping Cart-PaymentMethods
	Given I initialize Browser 
	And I am executing "NewUI_SC07-Shopping Cart-PaymentMethods" 
    And I navigate to "NewUI" application
  
#    Then I open only a new tab
#	Then I switch between tabs "child"
#	And I navigate to "Admin tool" application
#	And I log in to admin tool select customer "XTDAUTOQCSA" for "QCSA"
#	And I update Property "PROGRAM_PAYMENT_METHOD" to "Sponsor Invoice"
#	Then I switch between tabs "parent"
#	And I clear the cache
#
#	And I should see element "login page"
#    When I log in to "autoqcs" New UI application with "valid" Credentials
#    And I click on "button-newui" "Login" on "Login" Page
#    And I click on "button-newui" "I Certify" on "NOTICE" Page
#   	And I click on "MenuButton-NewUI" "People" on "HOME" Page
#    Then I click on "button-newui" " Create Order " on "People" Page
#
#    And I enter "valid" value for "FN" textbox on "create person" Page NewUI
#	And I enter "valid" value for "LN" textbox on "create person" Page NewUI
#    And I enter "valid" value for "email" textbox on "create person" Page NewUI
#    And I enter "valid" value for "re-enter email" textbox on "create person" Page NewUI
#	And I enter "valid" value for "Country" textbox on "create person" Page NewUI
#    And I enter "valid" value for "City" textbox on "create person" Page NewUI
#    And I enter "valid" value for "State" textbox on "create person" Page NewUI
#    And I click on "button-newui" "Next" on "create person" Page
#
#    And I should see Text "Package Selection"
#	When Search table By "package" in "Package Selection" page
#	And I click on "button-newui" "search" on "package selection" Page
#	And I click on "radiobutton-newui" "first pkg" on "package selection" Page
#	And I click on "button-NewUI" "Add to Cart" on "package selection" Page
#
#	When I Execute "Validate Price is not displayed when PPM is Sponsor Invoice"
#	And I should see Text "Shopping cart"
#	And I should see element "Accordion Shopping Cart" for "POW"
#	And I should see element "Person Name Label"
#	And I should see "text-newui" named as "existing Person" on "Shopping Cart" Page
#	And I should see element "Package Name Label"
#	And I should see "text-newui" named as "existing Package" on "Shopping Cart" Page
#	And I should not see element "Package Price Label" for "POW"
#	And I should not see element "Summary" for "POW"
#	And I should not see element "Subtotal:" for "POW"
#	And I should not see element "Tax:" for "POW"
#	And I should not see element "Order Total:" for "POW"
#
#	When I Execute "Validate deleting item from shopping cart with Don't ask me checked"
#	And I click on "button-newui" "delete" on "Shopping cart" Page
#	And I should see "text-newui" named as "Are you sure you want to remove:" on "Shopping cart" Page
#	And I should see "text-newui" named as "XTDForce Package for PA" on "Shopping cart" Page
#	And I should see "text-newui" named as "Don`t ask me again" on "Shopping cart" Page
#	And I click on "checkbox" "Don't ask" on "Shopping cart" Page
#	And I click on "button-newui" "Yes" on "Shopping cart" Page
#	And I should see Text "No items in the shopping cart."
#	And I should see element "Checkout" for "disabled"
#
	When I Execute "Validate Price is displayed when PPM is Vendor Invoice"
	Then I switch between tabs "child"
	And I navigate to "Admin tool" application
	And I log in to admin tool select customer "XTDAUTOQCSA" for "QCSA"
	And I update Property "PROGRAM_PAYMENT_METHOD" to "Vendor Invoice" 
	Then I close open tabs "child"
	And I clear the cache
	And Refresh The Page
	
	And I click on "button-newui" "Add Another Package" on "Shopping cart" Page 
	And I enter "valid" value for "FN" textbox on "create person" Page NewUI
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
	
	When I Execute "Validate Price is displayed when PPM is Vendor Invoice"
	And I should see element "Person Name Label"
	And I should see "text-newui" named as "existing Person" on "Shopping Cart" Page
	And I should see element "Package Name Label"
	And I should see "text-newui" named as "existing Package" on "Shopping Cart" Page
	And I should see element "Package Price Label"
	And I should see "text-newui" named as "existing Price" on "Shopping Cart" Page
	And I should see element "Summary"
	And I should see element "Subtotal:"
	And I should see "text-newui" named as "Subtotal" on "Shopping Cart" Page
	And I should see element "Tax:"
	And I should see "text-newui" named as "Tax" on "Shopping Cart" Page
	And I should see element "Order Total:"
	And I should see "text-newui" named as "Order Total" on "Shopping Cart" Page
	
	When I Execute "Validate deleting item from shopping cart without Don't ask me popup"
	And I click on "button-newui" "delete" on "Shopping cart" Page
	And I should see Text "No items in the shopping cart."
	And I should see element "Checkout" for "disabled"
	
	And I close browser