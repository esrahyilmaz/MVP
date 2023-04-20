Feature: Regression NewUI XtdConnect Workflow
#******************************************************************************************************************************

################################XtdConnect Workflow#########################################     
@NewUI-PeopleOrderingWorkflow
@NewUI-XtdConnect01 @NewUI-XtdConnectall
  Scenario Outline: NewUI_SC18-XtdConnect Successfully copied to the roaster
    Given I initialize Browser
     When I am executing "NewUI_SC18-XtdConnect Successfully copied to the roaster" 
  
    Then I open only a new tab
  	Then I switch between tabs "child"
  	And I navigate to "Admin tool" application
  	And I log in to admin tool select customer "XTDAUTOQCSA" for "QCSA"
  	And I update Property "POSITION_HIRE_LOCATION_REQUIRED" to "Y"
  	And I update Property "ENABLE_MULTIPLE_ORDERING" to "Y"
  	And I update Property "ENABLE_PA_INTEGRATION" to "Y"
  	And I update Property "PROGRAM_PAYMENT_METHOD" to "Credit Card" 
  	And I update Property "XTDCONNECT_PRICE" to "<Price>" 
  	And I update Property "XTDCONNECT_ENABLED" to "Y" 
  	And I update Property "XTDCONNECT_HIERARCHY_ENABLED" to "270724;110220" 
  	
  	Then I close open tabs "child"
  	And I clear the cache
  
      And I navigate to "NewUI" application 
      And I should see element "login page"
  
     When I log in to "autoqcs" New UI application with "valid" Credentials 
      And I click on "button-newui" "Login" on "Login" Page 
      And I click on "button-newui" "I Certify" on "NOTICE" Page 
      And I click on "MenuButton-NewUI" "People" on "HOME" Page
  
      And I should see element "People"
      And I should see Text "Create Order"
     When I click on "button-newui" " Create Order " on "People" Page
  
      And I should see Text "Personal information"
      And I should see element "xtdconnect banner"
      And I should see Text " Search With XtdConnect "
      And I should see Text " Toggle on - to check if this individual is already in the program. This will require the person’s Social Security Number and Date of Birth."
  
      And I should see element "XtdConnect Opt-Out Off"
  
      And I click on "button-newui" "Off" on "XtdConnect" Page 
      And I should see element "XtdConnect Opt-In ON"
      And I should not see element "Personal information"
  
      And I click on "button-newui" "Cancel" on "XtdConnect" Page
      And I should see element "People"
      And I should see Text "Create Order"
     When I click on "button-newui" " Create Order " on "People" Page
      And I should see Text "Personal information"
  
      And I should see element "xtdconnect banner"
      And I click on "button-newui" "Off" on "XtdConnect" Page 
      And I should see element "XtdConnect Opt-In ON"
      And I should not see element "Personal information"    
  
      And Verify PlaceHolder Value for "First Name *" on "XtdConnect" Page
      And Verify PlaceHolder Value for "Last Name *" on "XtdConnect" Page
      And Verify PlaceHolder Value for "Document Number *" on "XtdConnect" Page
      And Verify PlaceHolder Value for "Date of Birth *" on "XtdConnectDOBTitle" Page
   #   And I should see element "calenderIcon"
  
      And I click on "button-NewUI" "Next" on "XtdConnect" Page
      And I should see "xtdConnectErrormsg-newui" named as "First Name is required" on "XtdConnect" Page
      And I should see "xtdConnectErrormsg-newui" named as "Last Name is required" on "XtdConnect" Page
      And I should see "xtdConnectErrormsg-newui" named as "Document Number is required" on "XtdConnect" Page
      And I should see "xtdConnectErrormsg-newui" named as "Date of Birth is required" on "XtdConnect" Page
  
      And I enter "CompliantOrder" value for "FN" textbox on "XtdConnect" Page NewUI
      And I enter "CompliantOrder" value for "LN" textbox on "XtdConnect" Page NewUI
      And I enter "CompliantOrder" value for "Document Number" textbox on "XtdConnect" Page NewUI
      And I enter "CompliantOrder" value for "Date Of Birth" textbox on "XtdConnect" Page NewUI
  
      And I click on "button-NewUI" "Next" on "XtdConnect" Page
  #once bug fixed then removing this duplicate line and this is happening just on UI.
  #And I click on "button-NewUI" "Next" on "XtdConnect" Page
  
      And I should see Text "Personal information"
      And I should see Text "We need some details to add the new person."
      And I should see Text "You can choose to add this person into your roster, or order a background check"
      And I should see Text "Name"
      And I should see Text "Package Ordered"
      And I should see Text "Date Completed"
      And I should see Text "Expiry Date"
      And I should see Text " In accordance with the FCRA I attest that I have a permissible purpose (employment) and will otherwise comply with the requirements of the FCRA including having provided a disclosure and having obtained an authorization from the individual who is the subject of this request "
  
      And I should validate "Order New Package" button is clickable on "XtdConnect" Page
     Then I click on "checkbox" "xtdconnectconsent" on "xtdconnect" Page
      And I click on "button" "Connect" on "XtdConnect" Page
  
      And I wait for "8" Seconds
     Then I should see element "successfully connected message"
      And I should see element "People"
      And I search for xtdconnect order on people Page
      And I should see "row" named as "xtdConnectUser" on "xtdconnect" Page
      And I close browser
      
      Examples:
      |Price|
      |0|
      |Null|
  
      	
  
  @NewUI-PeopleOrderingWorkflow
  @NewUI-XtdConnect02   @NewUI-XtdConnectall
  Scenario: NewUI_SC19-XtdConnect Order should not copied to the roaster
    Given I initialize Browser
     When I am executing "NewUI_SC19-XtdConnect Order should not copied to the roaster" 
      And I navigate to "NewUI" application 
      And I should see element "login page"
  
     When I log in to "autoqcs" New UI application with "valid" Credentials 
      And I click on "button-newui" "Login" on "Login" Page 
      And I click on "button-newui" "I Certify" on "NOTICE" Page 
      And I click on "MenuButton-NewUI" "People" on "HOME" Page
  
      And I should see element "People"
      And I should see Text "Create Order"
     When I click on "button-newui" " Create Order " on "People" Page
  
     And I should see element "xtdconnect banner"
      And I click on "button-newui" "Off" on "XtdConnect" Page 
      
      And I should see element "XtdConnect Opt-In ON"
      And I should not see element "Personal information"
  
      And I enter "NonCompliantOrder" value for "FN" textbox on "XtdConnect" Page NewUI
      And I enter "NonCompliantOrder" value for "LN" textbox on "XtdConnect" Page NewUI
      And I enter "CompliantOrder" value for "Document Number" textbox on "XtdConnect" Page NewUI
      And I enter "CompliantOrder" value for "Date Of Birth" textbox on "XtdConnect" Page NewUI
  
      And I click on "button-NewUI" "Next" on "XtdConnect" Page
#  #once bug fixed then removing this duplicate line and this is happening just on UI.

     # And I click on "button-NewUI" "Next" on "XtdConnect" Page	
  
      And I wait for "8" Seconds
     Then I should see element "Unsuccessfully connected Error message"
  
      And I close browser
  
  
  @NewUI-PeopleOrderingWorkflow
  @NewUI-XtdConnect03  @NewUI-XtdConnectall
  Scenario: NewUI_SC20-XtdConnect with price greater than Zero
    Given I initialize Browser
     When I am executing "NewUI_SC20-XtdConnect with price greater than Zero" 
  
      Then I open only a new tab
  	Then I switch between tabs "child"
  	And I navigate to "Admin tool" application
  	And I log in to admin tool select customer "XTDAUTOQCSA" for "QCSA"
  	And I update Property "POSITION_HIRE_LOCATION_REQUIRED" to "Y" 
  	And I update Property "SHOW_ORDER_HISTORY" to "Y"
  	And I update Property "PROGRAM_PAYMENT_METHOD" to "Credit Card" 
  	And I update Property "XTDCONNECT_PRICE" to "30" 
  	And I update Property "XTDCONNECT_ENABLED" to "Y" 
  	And I update Property "XTDCONNECT_HIERARCHY_ENABLED" to "270724;110220" 
  	
  	Then I close open tabs "child"
  	And I clear the cache
  
  
      And I navigate to "NewUI" application 
      And I should see element "login page"
  
     When I log in to "autoqcs" New UI application with "valid" Credentials 
      And I click on "button-newui" "Login" on "Login" Page 
      And I click on "button-newui" "I Certify" on "NOTICE" Page 
      And I click on "MenuButton-NewUI" "People" on "HOME" Page
      And I should see element "People"
      And I should see Text "Create Order"
     When I click on "button-newui" " Create Order " on "People" Page
  
      And I should see Text "Personal information"
      And I should see element "xtdconnect banner"
      And I should see element "XtdConnect Opt-Out Off"
  
      And I click on "button-newui" "Off" on "XtdConnect" Page 
      And I should see element "XtdConnect Opt-In ON"
      And I should not see element "Personal information"
  
      And I enter "CompliantOrder" value for "FN" textbox on "XtdConnect" Page NewUI
      And I enter "CompliantOrder" value for "LN" textbox on "XtdConnect" Page NewUI
      And I enter "CompliantOrder" value for "Document Number" textbox on "XtdConnect" Page NewUI
      And I enter "CompliantOrder" value for "Date Of Birth" textbox on "XtdConnect" Page NewUI
  
      And I click on "button-NewUI" "Next" on "XtdConnect" Page
  #once bug fixed then removing this duplicate line and this is happening just on UI.
  #And I click on "button-NewUI" "Next" on "XtdConnect" Page
  
      And I should see Text "Personal information"
      And I should see Text "We need some details to add the new person."
      And I should see Text "You can choose to add this person into your roster, or order a background check"
      And I should see Text "Name"
      And I should see Text "Package Ordered"
      And I should see Text "Date Completed"
      And I should see Text "Expiry Date"
      And I should see Text " In accordance with the FCRA I attest that I have a permissible purpose (employment) and will otherwise comply with the requirements of the FCRA including having provided a disclosure and having obtained an authorization from the individual who is the subject of this request "
  
      And I should validate "Order New Package" button is clickable on "XtdConnect" Page
     Then I click on "checkbox" "xtdconnectconsent" on "xtdconnect" Page
      And I click on "button" "Connect" on "XtdConnect" Page
      
      
      And I should see Text "Shopping cart"
	And I should see element "Person Name Label"
	And I should see "text-newui" named as "person" on "Shopping Cart" Page
	And I should see element "Package Name Label"
	And I should see element "Package Price Label"
	And I should see "text-newui" named as "Price" on "Shopping Cart" Page
	And I should see element "Summary"
	And I should see element "Subtotal:"
	And I should see "text-newui" named as "Subtotal:" on "Shopping Cart" Page
	And I should see element "Tax:"
	And I should see "text-newui" named as "Tax:" on "Shopping Cart" Page
	And I should see element "Order Total:"
	And I should see "text-newui" named as "Order Total:" on "Shopping Cart" Page

	And I click on "button-newui" "Authorize" on "Shopping Cart" Page
	And I click on "button-NewUI" "Checkout" on "Shopping Cart" Page
	
	Then I should see Text "Payment method"
	
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
   	
	And I wait for "8" Seconds
     Then I should see element "successfully connected message"
      And I should see element "People"
      And I search for xtdconnect order on people Page
      And I should see "row" named as "xtdConnectUser" on "xtdconnect" Page
      
     And I should see element "XtdConnect Logo On People Page"
     And I click on "indicator" "XtdConnectLogo" on "XtdConnect" Page
     And I should see element "XtdConnect Logo on Modal"
      #And I should see "row" named as "xtdConnectUserModal" on "xtdconnectModal" Page
      
      And I should see Text " This person was added using XtdConnect and the details of the consumer report are not available to you. For more details please order a background check on this person. "
      And I should see Text " Visit our "
      And I should see Text " for more information "
  
     And I click on "button-newui" "Close" on "XtdConnect" Page
     And I click on "person name" "XtdConnectOrder" on "person details" Page
     And I wait for "5" Seconds
      And I should see element "XtdConnect Logo On person details"
  
      And I close browser	
  
@NewUI-PeopleOrderingWorkflow
 @NewUI-XtdConnect04  @NewUI-XtdConnectall
  Scenario: NewUI_SC21-I have XtdConnect Order in Shopping Cart 
    Given I initialize Browser
     When I am executing "NewUI_SC21-I have XtdConnect Order in Shopping Cart" 
  
      And I navigate to "NewUI" application 
      And I should see element "login page"
  
     When I log in to "autoqcs" New UI application with "valid" Credentials 
      And I click on "button-newui" "Login" on "Login" Page 
      And I click on "button-newui" "I Certify" on "NOTICE" Page 
      And I click on "MenuButton-NewUI" "People" on "HOME" Page
      And I should see element "People"
      And I should see Text "Create Order"
     When I click on "button-newui" " Create Order " on "People" Page
  
      And I should see Text "Personal information"
      And I should see element "xtdconnect banner"
      And I should see element "XtdConnect Opt-Out Off"
  
      And I click on "button-newui" "Off" on "XtdConnect" Page 
      And I should see element "XtdConnect Opt-In ON"
      And I should not see element "Personal information"
  
      And I enter "CompliantOrder" value for "FN" textbox on "XtdConnect" Page NewUI
      And I enter "CompliantOrder" value for "LN" textbox on "XtdConnect" Page NewUI
      And I enter "CompliantOrder" value for "Document Number" textbox on "XtdConnect" Page NewUI
      And I enter "CompliantOrder" value for "Date Of Birth" textbox on "XtdConnect" Page NewUI
  
      And I click on "button-NewUI" "Next" on "XtdConnect" Page
  #once bug fixed then removing this duplicate line and this is happening just on UI.
  #And I click on "button-NewUI" "Next" on "XtdConnect" Page
  
      And I should see Text "Personal information"
      And I should see Text "We need some details to add the new person."
      And I should see Text "You can choose to add this person into your roster, or order a background check"
      And I should see Text "Name"
      And I should see Text "Package Ordered"
      And I should see Text "Date Completed"
      And I should see Text "Expiry Date"
      And I should see Text " In accordance with the FCRA I attest that I have a permissible purpose (employment) and will otherwise comply with the requirements of the FCRA including having provided a disclosure and having obtained an authorization from the individual who is the subject of this request "
  
      And I should validate "Order New Package" button is clickable on "XtdConnect" Page
     Then I click on "checkbox" "xtdconnectconsent" on "xtdconnect" Page
      And I click on "button" "Connect" on "XtdConnect" Page
      
      And I should see Text "Shopping cart"
	And I should see element "Person Name Label"
	And I should see "text-newui" named as "person" on "Shopping Cart" Page

	And I click on "MenuButton-NewUI" "People" on "HOME" Page
	And I should see element "People"
      And I should see Text "Create Order"
     When I click on "button-newui" " Create Order " on "People" Page
     
     And I should see element "xtdConnect toast notification" 
     And I should see element "Notice message on toast notification"
     And I close browser	
        
        
@NewUI-PeopleOrderingWorkflow 
@NewUI-XtdConnect05  @NewUI-XtdConnectall
Scenario: NewUI_SC22-MultiOrder capabilities with XtdConnect
    Given I initialize Browser
     When I am executing "NewUI_SC22-MultiOrder capabilities with XtdConnect" 
  
      Then I open only a new tab
  	Then I switch between tabs "child"
  	And I navigate to "Admin tool" application
  	And I log in to admin tool select customer "XTDAUTOQCSA" for "QCSA"
  	And I update Property "POSITION_HIRE_LOCATION_REQUIRED" to "Y" 
  	  	And I update Property "ENABLE_MULTIPLE_ORDERING" to "Y"
  	And I update Property "SHOW_ORDER_HISTORY" to "Y"
  	And I update Property "PROGRAM_PAYMENT_METHOD" to "Credit Card" 
  	And I update Property "XTDCONNECT_PRICE" to "30" 
  	And I update Property "XTDCONNECT_ENABLED" to "Y" 
  	And I update Property "XTDCONNECT_HIERARCHY_ENABLED" to "270724;110220" 
  	
  	Then I close open tabs "child"
  	And I clear the cache
  
      And I navigate to "NewUI" application 
      And I should see element "login page"
  
     When I log in to "autoqcs" New UI application with "valid" Credentials 
      And I click on "button-newui" "Login" on "Login" Page 
      And I click on "button-newui" "I Certify" on "NOTICE" Page 
      And I click on "MenuButton-NewUI" "People" on "HOME" Page
      And I should see element "People"
      And I should see Text "Create Order"
     When I click on "button-newui" " Create Order " on "People" Page
  
      And I should see Text "Personal information"
      And I should see element "xtdconnect banner"
      And I should see element "XtdConnect Opt-Out Off"
  
      And I click on "button-newui" "Off" on "XtdConnect" Page 
      And I should see element "XtdConnect Opt-In ON"
      And I should not see element "Personal information"
  
      And I enter "CompliantOrder" value for "FN" textbox on "XtdConnect" Page NewUI
      And I enter "CompliantOrder" value for "LN" textbox on "XtdConnect" Page NewUI
      And I enter "CompliantOrder" value for "Document Number" textbox on "XtdConnect" Page NewUI
      And I enter "CompliantOrder" value for "Date Of Birth" textbox on "XtdConnect" Page NewUI
  
      And I click on "button-NewUI" "Next" on "XtdConnect" Page
  #once bug fixed then removing this duplicate line and this is happening just on UI.
  #And I click on "button-NewUI" "Next" on "XtdConnect" Page
  
      And I should see Text "Personal information"
      And I should see Text "We need some details to add the new person."
      And I should see Text "You can choose to add this person into your roster, or order a background check"
      And I should see Text "Name"
      And I should see Text "Package Ordered"
      And I should see Text "Date Completed"
      And I should see Text "Expiry Date"
      And I should see Text " In accordance with the FCRA I attest that I have a permissible purpose (employment) and will otherwise comply with the requirements of the FCRA including having provided a disclosure and having obtained an authorization from the individual who is the subject of this request "
     
      And I click on "button-newui" "Order New Package" on "XtdConnect" Page      
       And I should see Text "Personal information"
      And I should see element "xtdconnect banner"
      And I should see Text " Search With XtdConnect "
      And I should see Text " Toggle on - to check if this individual is already in the program. This will require the person’s Social Security Number and Date of Birth."
  
      And I should see element "XtdConnect Opt-Out Off"

      And I should see Text "Personal information"
      
      And I should see "FirsName" textbox for "Pre-populated" value on "create person" Page NewUI
      And I should see "LastName" textbox for "Pre-populated" value on "create person" Page NewUI
           
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
  And I should see element "Person Name Label"
	And I should see "text-newui" named as "person" on "Shopping Cart" Page
	And I should see element "Package Name Label"
	And I should see element "Package Price Label"
	And I should see "text-newui" named as "Price" on "Shopping Cart" Page
	And I should see element "Summary"
	And I should see element "Subtotal:"
	And I should see "text-newui" named as "Subtotal:" on "Shopping Cart" Page
	And I should see element "Tax:"
	And I should see "text-newui" named as "Tax:" on "Shopping Cart" Page
	And I should see element "Order Total:"
	And I should see "text-newui" named as "Order Total:" on "Shopping Cart" Page

	And I click on "button-newui" "Authorize" on "Shopping Cart" Page
	And I click on "button-NewUI" "Checkout" on "Shopping Cart" Page
	
	Then I should see Text "Payment method"
	
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
	
	And I should see Text "Order Confirmation"
	And I should see Text "Here is your transaction number:"
	And I should see "element" named as "transaction number" on "order confirmation" Page
	And I should see Text "Paid via:"
	And I should see "text-newui" named as "Credit Card" on "Order Confirmation" Page
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

@NewUI-PeopleOrderingWorkflow  
@NewUI-XtdConnect06  @NewUI-XtdConnectall
 Scenario: NewUI_SC23-Shopping cart or adding another order SO XTDCONNECT should be disabled
    Given I initialize Browser
    When I am executing "NewUI_SC23-Shopping cart or adding another order SO XTDCONNECT should be disabled" 
  
      Then I open only a new tab
  	Then I switch between tabs "child"
  	And I navigate to "Admin tool" application
  	And I log in to admin tool select customer "XTDAUTOQCSA" for "QCSA"
  	And I update Property "POSITION_HIRE_LOCATION_REQUIRED" to "Y" 
  	And I update Property "ENABLE_MULTIPLE_ORDERING" to "Y"
  	And I update Property "SHOW_ORDER_HISTORY" to "Y"
  	And I update Property "PROGRAM_PAYMENT_METHOD" to "Credit Card" 
  	And I update Property "XTDCONNECT_PRICE" to "30" 
  	And I update Property "XTDCONNECT_ENABLED" to "Y" 
  	And I update Property "XTDCONNECT_HIERARCHY_ENABLED" to "270724;110220" 
  	
  	Then I close open tabs "child"
  	And I clear the cache
  
      And I navigate to "NewUI" application 
      And I should see element "login page"
  
     When I log in to "autoqcs" New UI application with "valid" Credentials 
      And I click on "button-newui" "Login" on "Login" Page 
      And I click on "button-newui" "I Certify" on "NOTICE" Page 
      And I click on "MenuButton-NewUI" "People" on "HOME" Page
      And I should see element "People"
      And I should see Text "Create Order"
     When I click on "button-newui" " Create Order " on "People" Page
  
      And I should see Text "Personal information"
      And I should see element "xtdconnect banner"
      And I should see element "XtdConnect Opt-Out Off"
      And I should see Text " Search With XtdConnect "
      And I should see Text " Toggle on - to check if this individual is already in the program. This will require the person’s Social Security Number and Date of Birth."
  
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
    And I should see element "Person Name Label"
	And I should see "text-newui" named as "person" on "Shopping Cart" Page
	And I should see element "Package Name Label"
	And I should see element "Package Price Label"
	And I should see "text-newui" named as "Price" on "Shopping Cart" Page
	And I should see element "Summary"
	And I should see element "Subtotal:"
	And I should see "text-newui" named as "Subtotal:" on "Shopping Cart" Page
	And I should see element "Tax:"
	And I should see "text-newui" named as "Tax:" on "Shopping Cart" Page
	And I should see element "Order Total:"
	And I should see "text-newui" named as "Order Total:" on "Shopping Cart" Page
	
    And I click on "button-NewUI" "Add Another Package" on "Shopping Cart" Page  
    And I should see Text "Personal information"
    And I should see element "xtdconnect banner"
    And I should see element "XtdConnect Opt-Out Off"
    And I should see Text " Search With XtdConnect "
    And I should see Text "To utilize XtdConnect, you will need to checkout or clear your shopping cart" 
    And I click on "button-newui" "Off" on "XtdConnect" Page
    And I should see element "xtdConnect toast notification" 
    And I should see element "Notice message on toast notification"
    And I close browser
    
    
    
    	
