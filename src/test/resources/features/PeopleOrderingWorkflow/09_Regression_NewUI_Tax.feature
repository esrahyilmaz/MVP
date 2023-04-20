Feature: Regression NewUI Tax Integration
    
#*****************************************************************************************************************************************

######################NewUI POW - Tax Integration######################     
#@NewUI-PeopleOrderingWorkflow
@NewUITaxIntegration 
@NewUITaxIntegration-Y
Scenario: NewUI_SC14-Tax IntegrationY
	Given I initialize Browser
	When I am executing "NewUI_SC14-Tax IntegrationY" 
    And I navigate to "NewUI" application 
    
    Then I open only a new tab
    Then I switch between tabs "child"
    And I navigate to "Admin tool" application
    And I log in to admin tool select customer "XTDAUTOQCSA" for "QCSA"
    And I update Property "TAX_CALCULATION_ENABLE" to "Y"
    And I update Property "PROGRAM_PAYMENT_METHOD" to "Credit Card"
    And I update Property "POSITION_HIRE_LOCATION" to "N"
    Then I switch between tabs "parent"
   
   	## FOR QCSAAUTOVC VENDOR_ID = 66364 
    And I set address for "taxable" state for Vendor "66244"
    And I set Program Payment Method to "null" where Vendor "66244"
      
    And I should see element "login page" 
    And I log in to "autoqcs" New UI application with "valid" Credentials 
    And I click on "button-newui" "Login" on "Login" Page 
    And I click on "button-newui" "I Certify" on "NOTICE" Page 
    And I click on "MenuButton-newui" "People" on "HOME" Page
    And I should see element "People"
    And I should see Text "Create Order"
         
    When I click on "checkbox" "first" on "People" Page
	And I click on "button-newui" "New Order" on "People" Page
    And I click on "button-newui" "Next" on "create person" Page
	And I should see Text "Package Selection"
    And I click on "radiobutton-newui" "first pkg" on "package selection" Page
	And I click on "button-newui" "Add to Cart" on "package selection" Page

	And I should see Text "Shopping cart"
	And verify the tax details on "people ordering taxable" Page
	And I click on "button-newui" "Authorize" on "Shopping Cart" Page
	And I click on "button-newui" "Checkout" on "tax integration taxable" Page

	And I click on "MenuButton-newui" "People" on "HOME" Page

#	Then I switch between tabs "child"
#	And I update Property "PROGRAM_PAYMENT_METHOD" to "Sponsor Invoice"
#	Then I switch between tabs "parent"
#	And I clear the cache
#
#	And I click on "checkbox" "first" on "People" Page
#	And I click on "button-newui" "New Order" on "People" Page
#    And I click on "button-newui" "Next" on "create person" Page
#    And I click on "radiobutton-newui" "first pkg" on "package selection" Page
#	And I click on "button-newui" "Add to Cart" on "package selection" Page
#	And I should see Text "Shopping cart"
#	And verify the tax details on "people ordering taxable" Page
#	And I click on "button-newui" "Checkout" on "tax integration taxable" Page
#
#	And I click on "MenuButton-newui" "People" on "HOME" Page

	Then I switch between tabs "child"
	And I update Property "PROGRAM_PAYMENT_METHOD" to "Vendor Invoice"
	Then I switch between tabs "parent"
	And I clear the cache

	And I click on "checkbox" "first" on "People" Page
	And I click on "button-newui" "New Order" on "People" Page
    And I click on "button-newui" "Next" on "create person" Page
    And I click on "radiobutton-newui" "first pkg" on "package selection" Page
	And I click on "button-newui" "Add to Cart" on "package selection" Page
	And I should see Text "Shopping cart"
	And verify the tax details on "people ordering taxable" Page
	And I click on "button-newui" "Checkout" on "tax integration taxable" Page

	And I click on "MenuButton-newui" "People" on "HOME" Page
	And I set Program Payment Method to "Sponsor Invoice" where Vendor "66244"
	And I click on "checkbox" "first" on "People" Page
	And I click on "button-newui" "New Order" on "People" Page
    And I click on "button-newui" "Next" on "create person" Page
    And I click on "radiobutton-newui" "first pkg" on "package selection" Page
	And I click on "button-newui" "Add to Cart" on "package selection" Page
	And I should see Text "Shopping cart"
	And verify the tax details on "people ordering taxable" Page
	And I click on "button-newui" "Checkout" on "tax integration taxable" Page

	And I click on "MenuButton-newui" "People" on "HOME" Page
	And I set Program Payment Method to "Credit Card" where Vendor "66244"
	And I click on "checkbox" "first" on "People" Page
	And I click on "button-newui" "New Order" on "People" Page
    And I click on "button-newui" "Next" on "create person" Page
    And I click on "radiobutton-newui" "first pkg" on "package selection" Page
	And I click on "button-newui" "Add to Cart" on "package selection" Page
	And I should see Text "Shopping cart"
	And verify the tax details on "people ordering taxable" Page
	And I click on "button-newui" "Authorize" on "Shopping Cart" Page
	And I click on "button-newui" "Checkout" on "tax integration taxable" Page

	And I set address for "non-taxable" state for Vendor "66244"

	And I click on "MenuButton-newui" "People" on "HOME" Page

	Then I switch between tabs "child"
	And I update Property "PROGRAM_PAYMENT_METHOD" to "Credit Card"
	Then I switch between tabs "parent"
	And I clear the cache

	And I set Program Payment Method to "null" where Vendor "66244"
	And I click on "checkbox" "first" on "People" Page
	And I click on "button-newui" "New Order" on "People" Page
    And I click on "button-newui" "Next" on "create person" Page
   	And I click on "radiobutton-newui" "first pkg" on "package selection" Page
	And I click on "button-newui" "Add to Cart" on "package selection" Page
	And I should see Text "Shopping cart"
	And verify the tax details on "people ordering taxable" Page
	And I click on "button-newui" "Authorize" on "Shopping Cart" Page
	And I click on "button-newui" "Checkout" on "tax integration taxable" Page

#	And I click on "MenuButton-newui" "People" on "HOME" Page
#
#	Then I switch between tabs "child"
#	And I update Property "PROGRAM_PAYMENT_METHOD" to "Sponsor Invoice"
#	Then I switch between tabs "parent"
#	And I clear the cache
#
#	And I click on "checkbox" "first" on "People" Page
#	And I click on "button-newui" "New Order" on "People" Page
#    And I click on "button-newui" "Next" on "create person" Page
#   	And I click on "radiobutton-newui" "first pkg" on "package selection" Page
#	And I click on "button-newui" "Add to Cart" on "package selection" Page
#	And I should see Text "Shopping cart"
#	And verify the tax details on "people ordering taxable" Page
#	And I click on "button-newui" "Checkout" on "tax integration taxable" Page

	And I click on "MenuButton-newui" "People" on "HOME" Page

	Then I switch between tabs "child"
	And I update Property "PROGRAM_PAYMENT_METHOD" to "Vendor Invoice"
	Then I close open tabs "child"
	And I clear the cache

	And I click on "checkbox" "first" on "People" Page
	And I click on "button-newui" "New Order" on "People" Page
    And I click on "button-newui" "Next" on "create person" Page
   	And I click on "radiobutton-newui" "first pkg" on "package selection" Page
	And I click on "button-newui" "Add to Cart" on "package selection" Page
	And I should see Text "Shopping cart"
	And verify the tax details on "people ordering taxable" Page
	And I click on "button-newui" "Checkout" on "tax integration taxable" Page

#	And I click on "MenuButton-newui" "People" on "HOME" Page
#	And I set Program Payment Method to "Sponsor Invoice" where Vendor "66244"
#	And I click on "checkbox" "first" on "People" Page
#	And I click on "button-newui" "New Order" on "People" Page
#    And I click on "button-newui" "Next" on "create person" Page
#   	And I click on "radiobutton-newui" "first pkg" on "package selection" Page
#	And I click on "button-newui" "Add to Cart" on "package selection" Page
#	And I should see Text "Shopping cart"
#	And verify the tax details on "people ordering taxable" Page
#	And I click on "button-newui" "Checkout" on "tax integration taxable" Page

	And I click on "MenuButton-NewUI" "People" on "HOME" Page
	And I set Program Payment Method to "Credit Card" where Vendor "66244"
	And I click on "checkbox" "first" on "People" Page
	And I click on "button-newui" "New Order" on "People" Page
    And I click on "button-newui" "Next" on "create person" Page
    And I click on "radiobutton-newui" "first pkg" on "package selection" Page
	And I click on "button-newui" "Add to Cart" on "package selection" Page
	And I should see Text "Shopping cart"
	And verify the tax details on "people ordering taxable" Page
	And I click on "button-newui" "Authorize" on "Shopping Cart" Page
	And I click on "button-newui" "Checkout" on "tax integration taxable" Page

	And I close browser

######################NewUI POW - Tax Integration######################
#@NewUI-PeopleOrderingWorkflow
@NewUITaxIntegration
@NewUITaxIntegration-N
Scenario: NewUI_SC15-Tax IntegrationN
	Given I initialize Browser
	When I am executing "NewUI_SC15-Tax IntegrationN"
    And I navigate to "NewUI" application

    Then I open only a new tab
    Then I switch between tabs "child"
    And I navigate to "Admin tool" application
    And I log in to admin tool select customer "XTDAUTOQCSA" for "QCSA"
    And I update Property "TAX_CALCULATION_ENABLE" to "N"
    And I update Property "PROGRAM_PAYMENT_METHOD" to "Credit Card"
    Then I switch between tabs "parent"
    And I set address for "non-taxable" state for Vendor "66244"
    And I set Program Payment Method to "null" where Vendor "66244"

    And I should see element "login page"
    And I log in to "autoqcs" New UI application with "valid" Credentials
    And I click on "button-newui" "Login" on "Login" Page
    And I click on "button-newui" "I Certify" on "NOTICE" Page
    And I click on "MenuButton-newui" "People" on "HOME" Page
    And I should see element "People"
    And I should see Text "Create Order"

    When I click on "checkbox" "first" on "People" Page
	And I click on "button-newui" "New Order" on "People" Page
    And I click on "button-newui" "Next" on "create person" Page
	And I should see Text "Package Selection"
    And I click on "radiobutton-newui" "first pkg" on "package selection" Page
	And I click on "button-newui" "Add to Cart" on "package selection" Page
	And I should see Text "Shopping cart"
	And verify the tax details on "people ordering non-taxable" Page
	And I click on "button-newui" "Authorize" on "Shopping Cart" Page
	And I click on "button-newui" "Checkout" on "tax integration non-taxable" Page

	And I click on "MenuButton-newui" "People" on "HOME" Page

	Then I switch between tabs "child"
	And I update Property "PROGRAM_PAYMENT_METHOD" to "Sponsor Invoice"
	Then I switch between tabs "parent"
	And I clear the cache

	And I click on "checkbox" "first" on "People" Page
	And I click on "button-newui" "New Order" on "People" Page
    And I click on "button-newui" "Next" on "create person" Page
    And I click on "radiobutton-newui" "first pkg" on "package selection" Page
	And I click on "button-newui" "Add to Cart" on "package selection" Page
	And I should see Text "Shopping cart"
	And verify the tax details on "people ordering non-taxable" Page
	And I click on "button-newui" "Checkout" on "tax integration non-taxable" Page

	And I click on "MenuButton-newui" "People" on "HOME" Page

	Then I switch between tabs "child"
	And I update Property "PROGRAM_PAYMENT_METHOD" to "Vendor Invoice"
	Then I switch between tabs "parent"
	And I clear the cache

	And I click on "checkbox" "first" on "People" Page
	And I click on "button-newui" "New Order" on "People" Page
    And I click on "button-newui" "Next" on "create person" Page
    And I click on "radiobutton-newui" "first pkg" on "package selection" Page
	And I click on "button-newui" "Add to Cart" on "package selection" Page
	And I should see Text "Shopping cart"
	And verify the tax details on "people ordering non-taxable" Page
	And I click on "button-newui" "Checkout" on "tax integration non-taxable" Page

	And I click on "MenuButton-newui" "People" on "HOME" Page
	And I set Program Payment Method to "Sponsor Invoice" where Vendor "66244"
	And I click on "checkbox" "first" on "People" Page
	And I click on "button-newui" "New Order" on "People" Page
    And I click on "button-newui" "Next" on "create person" Page
    And I click on "radiobutton-newui" "first pkg" on "package selection" Page
	And I click on "button-newui" "Add to Cart" on "package selection" Page
	And I should see Text "Shopping cart"
	And verify the tax details on "people ordering non-taxable" Page
	And I click on "button-newui" "Checkout" on "tax integration non-taxable" Page

	And I click on "MenuButton-newui" "People" on "HOME" Page
	And I set Program Payment Method to "Credit Card" where Vendor "66244"
	And I click on "checkbox" "first" on "People" Page
	And I click on "button-newui" "New Order" on "People" Page
    And I click on "button-newui" "Next" on "create person" Page
    And I click on "radiobutton-newui" "first pkg" on "package selection" Page
	And I click on "button-newui" "Add to Cart" on "package selection" Page
	And I should see Text "Shopping cart"
	And verify the tax details on "people ordering non-taxable" Page
	And I click on "button-newui" "Authorize" on "Shopping Cart" Page
	And I click on "button-newui" "Checkout" on "tax integration non-taxable" Page

	And I set address for "taxable" state for Vendor "66244"

	And I click on "MenuButton-newui" "People" on "HOME" Page

	Then I switch between tabs "child"
	And I update Property "PROGRAM_PAYMENT_METHOD" to "Credit Card"
	Then I switch between tabs "parent"
	And I clear the cache

	And I set Program Payment Method to "null" where Vendor "66244"
	And I click on "checkbox" "first" on "People" Page
	And I click on "button-newui" "New Order" on "People" Page
    And I click on "button-newui" "Next" on "create person" Page
   	And I click on "radiobutton-newui" "first pkg" on "package selection" Page
	And I click on "button-newui" "Add to Cart" on "package selection" Page
	And I should see Text "Shopping cart"
	And verify the tax details on "people ordering non-taxable" Page
	And I click on "button-newui" "Authorize" on "Shopping Cart" Page
	And I click on "button-newui" "Checkout" on "tax integration non-taxable" Page

	And I click on "MenuButton-newui" "People" on "HOME" Page

	Then I switch between tabs "child"
	And I update Property "PROGRAM_PAYMENT_METHOD" to "Sponsor Invoice"
	Then I switch between tabs "parent"
	And I clear the cache

	And I click on "checkbox" "first" on "People" Page
	And I click on "button-newui" "New Order" on "People" Page
    And I click on "button-newui" "Next" on "create person" Page
   	And I click on "radiobutton-newui" "first pkg" on "package selection" Page
	And I click on "button-newui" "Add to Cart" on "package selection" Page
	And I should see Text "Shopping cart"
	And verify the tax details on "people ordering non-taxable" Page
	And I click on "button-newui" "Checkout" on "tax integration non-taxable" Page

	And I click on "MenuButton-newui" "People" on "HOME" Page

	Then I switch between tabs "child"
	And I update Property "PROGRAM_PAYMENT_METHOD" to "Sponsor Invoice"
	Then I close open tabs "child"
	And I clear the cache

	And I click on "checkbox" "first" on "People" Page
	And I click on "button-newui" "New Order" on "People" Page
    And I click on "button-newui" "Next" on "create person" Page
   	And I click on "radiobutton-newui" "first pkg" on "package selection" Page
	And I click on "button-newui" "Add to Cart" on "package selection" Page
	And I should see Text "Shopping cart"
	And verify the tax details on "people ordering non-taxable" Page
	And I click on "button-newui" "Checkout" on "tax integration non-taxable" Page

	And I click on "MenuButton-newui" "People" on "HOME" Page
	And I set Program Payment Method to "Sponsor Invoice" where Vendor "66244"
	And I click on "checkbox" "first" on "People" Page
	And I click on "button-newui" "New Order" on "People" Page
    And I click on "button-newui" "Next" on "create person" Page
   	And I click on "radiobutton-newui" "first pkg" on "package selection" Page
	And I click on "button-newui" "Add to Cart" on "package selection" Page
	And I should see Text "Shopping cart"
	And verify the tax details on "people ordering non-taxable" Page
	And I click on "button-newui" "Checkout" on "tax integration non-taxable" Page

	And I click on "MenuButton-newui" "People" on "HOME" Page
	And I set Program Payment Method to "Credit Card" where Vendor "66244"
	And I click on "checkbox" "first" on "People" Page
	And I click on "button-newui" "New Order" on "People" Page
    And I click on "button-newui" "Next" on "create person" Page
    And I click on "radiobutton-newui" "first pkg" on "package selection" Page
	And I click on "button-newui" "Add to Cart" on "package selection" Page
	And I should see Text "Shopping cart"
	And verify the tax details on "people ordering non-taxable" Page
	And I click on "button-newui" "Authorize" on "Shopping Cart" Page
	And I click on "button-newui" "Checkout" on "tax integration non-taxable" Page
	And I set Program Payment Method to "Null" where Vendor "66244"

	And I close browser