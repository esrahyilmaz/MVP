Feature: Regression NewUI UI-7

#First run Regression_UAT_Prerequisites.feature --> @UI-7-property-UAT     
#*****************************************************************************************************************************************

######################NewUI UI-7######################     
@UI-7 @NewUI-7-VendorOnboarding-UAT
Scenario: NewUIRegression_UI-7-VendorOnboarding
	Given I initialize Browser
	When I Execute "Validate the Vendor Onboarding Flow with Vendor Registration Cost $0" 
	And I am executing "NewUIRegression_UI-7-VendorOnboarding" 
	And I navigate to "NewUI" application 
	And I should see element "login page"
	
	And I should see "button-newui" named as "Sign up" on "Login" Page
	And I should see "text" named as "Have you signed up?" on "Login" Page
	And I click on "signupbutton" "Sign up" on "login page" Page
	
	And I should see "text" named as "Company" on "Initial" Page 
	And I should see "text" named as "I am signing up my company and screening my people" on "Initial" Page
	And I should see "text" named as "Registering will take 5 minutes." on "Initial" Page 
	And I should see "text" named as "We recommend preparing the following, before you begin:" on "Initial" Page 
	And I should see "text" named as "Legal Business Information" on "Initial" Page
	And I should see "text" named as "Primary Contact Information" on "Initial" Page
	And I should see "text" named as "Billing Information" on "Initial" Page 
	And I should see "text" named as "Signatory Rights" on "Initial" Page
	And I should see "text" named as "Please Note" on "Initial" Page 
	Then I should see "text" named as "Once your registration starts, you will not be able to end your session without losing your progress." on "Initial" Page 
	
	And I should see "button-newui" named as "Previous" on "User Profile" Page
	And I should see "button-newui" named as "Let's Begin!" on "User Profile" Page
	
	And I click on "button" "Let's Begin! " on "User Profile" Page 
	
	Then I should see "title" named as "User Profile" on "User Profile" Page
	When I should fill details in "User Profile" page 
	And I should see "button-newui" named as "Next" on "User Profile" Page
	And I click on "button" "NEXT" on "User Profile" Page
	
	Then I should see "title" named as "Business Information" on "Business Information" Page
	When I should fill details in "Business Information" page 
	And I click on "button" "NEXT" on "Business Information" Page
	
	Then I should see "title" named as "Business Contact" on "Business Contact" Page
	When I should fill details in "Business Contact" page
	And I click on "button" "NEXT" on "Business Contact" Page
		
	Then I should see "title" named as "Business Billing" on "Business Billing" Page
	And I click on "radiobutton-newui" "Primary Contact" on "Business Billing" Page 
	And I click on "checkbox" "My billing address" on "Business Billing" Page
	And I click on "button" "NEXT" on "Business Billing" Page 

	Then I should see "title" named as "Almost Done" on "Business Confirmation" Page 
	And I should see element "Check - Business Billing" for "Vendor Onboarding"
	
	And I should see "text" named as "Business Information" on "Business Confirmation" Page 
	And I should see "text-newui" named as "Business Information-Name" on "Business Confirmation" Page
	And I should see "text-newui" named as "Business Information-Doing Business As" on "Business Confirmation" Page
	And I should see "text-newui" named as "Business Information-Address" on "Business Confirmation" Page
	And I should see "text" named as "Contacts" on "Business Confirmation" Page
	And I should see "text-newui" named as "Contacts-Name" on "Business Confirmation" Page
	And I should see "text-newui" named as "Contacts-Email" on "Business Confirmation" Page
	And I should see "text" named as "Billing Contact Information" on "Business Confirmation" Page
	And I should see "text-newui" named as "Billing Contact Information-Name" on "Business Confirmation" Page
	And I should see "text-newui" named as "Billing Contact Information-Email" on "Business Confirmation" Page
	And I should see "text-newui" named as "Billing Contact Information-Address" on "Business Confirmation" Page
	
	When I click on "button-edit" "Edit" on "Business Confirmation" Page 
	When I wait for "2" Seconds 
	Then I should see "title" named as "Business Information" on "Business Information" Page 
	And I enter "random" value for "Business Name" textbox on "Business Information" Page NewUI
	And I click on "button" "NEXT" on "Business Information" Page 

	And I click on "button-newui" "Go Back" on "Business Contact" Page 
	And Verify Information on "Business Information" Page 
	
	And I click on "button" "NEXT" on "Business Information" Page 
	And I click on "button" "NEXT" on "Business Contact" Page 
	Then I should see "title" named as "Business Billing" on "Business Billing" Page
	
	And Verify Information on "Business Billing" Page
	And I should see element "Disabled Primary Contact Radiobutton"
	
	And I click on "button" "NEXT" on "Business Billing" Page 
	Then I should see "title" named as "Almost Done" on "Business Confirmation" Page 
	And I should see "text-newui" named as "Business Information-Name" on "Business Confirmation" Page
	And I click on "button" "NEXT" on "Business Confirmation" Page
	
	And I should see "text-newui" named as "Business Description" on "Business Signature" Page
	And I should see "text-newui" named as "Employment Purpose" on "Business Signature" Page
	And I should see "text-newui" named as "Name" on "Business Signature" Page
	And I should see "text-newui" named as "Title" on "Business Signature" Page
	And I should see "text-newui" named as "Date" on "Business Signature" Page
	And I should see "text-newui" named as "Client" on "Business Signature" Page
	And I should see "text-newui" named as "Address" on "Business Signature" Page
	And I should see "text-newui" named as "Sponsor" on "Business Signature" Page
	And I should see "text-newui" named as "Service Provider" on "Business Signature" Page
	And I should see "text-newui" named as "Provider Name" on "Business Signature" Page
	And I should see "text-newui" named as "Provider Title" on "Business Signature" Page
		
	And I should see element "Today's Date"
	And I should see element "Adopt and Sign unselected"
	And I should see "text" named as "You must agree to use of electronic signature agreement." on "Business Signature" Page
	
	And I Sign in Signature box
	And I should see element "Submit" for "disabled"
	And I click on "button-newui" "Clear Signature" on "Business Signature" Page
	And I Sign in Signature box
	And I should see element "Submit" for "disabled"	
	And I click on "tickbox" "adopAndSign" on "Business Signature" Page
	When I should see element "5 completed sections" for "green tick mark"
	And I click on "button" "Submit" on "Business Signature" Page
	
	Then I should see the sponsor logo in the header "congratulationsLogo" 
	And I should see "text-newui" named as "Welcome" on "Registration Complete" Page
	And I should see "button-newui" named as "Login" on "Registration Complete" Page 
	And I click on "linktext" "Login" on "Registration Complete" Page	
	
	And I close browser	
	
############################################NewUI UI-7##################################################################     
@UI-7 @NewUI-7-VendorOnboardingLogin-UAT
Scenario: NewUIRegression_UI-7-VendorOnboardingLogin
	Given I initialize Browser
	When I Execute "Validate the Vendor Onboarding Flow with Vendor Registration Cost $0" 
	And I am executing "NewUIRegression_UI-7-VendorOnboardingLogin" 
	And I navigate to "NewUI" application 
	And I should see element "login page"

	When I log in to "newuionboardedvendor" New UI application with "valid" Credentials 
	And I click on "button-newui" "Login" on "Login" Page 
	And I click on "button-newui" "I Certify" on "NOTICE" Page
	When I should see "menubutton-newui" named as "Dashboard" on "HOME" Page
	Then I should see "title" named as "Here is your dashboard." on "Dashboard" Page
	
	And I should see Text "Needs Review"
	And I should see Text "Non-Compliant"
	And I should see Text "Pending"
	
	And I should see element "0" for "Needs Review"
	And I should see element "0" for "Non-Compliant"
	And I should see element "0" for "Pending"
	
	When I click on "button-newui" "Needs Review" on "Dashboard" Page
	And I should see element "Needs Review" for "link url"
	Then I should see Text "No Results Found"
	
	And I should see "button-newui" named as "Add People" on "People" Page
    When I click on "button-newui" " Create Order " on "People" Page
   
    And I should see element "add people icon" for "POW icon"
    And I should see element "add people icon Section" for "POW icon"
    And I should see Text "Personal information"
   
   	And I click on "button-newui" "Middle Name Yes" on "create person" Page
	And I enter "valid" value for "FN" textbox on "create person" Page NewUI
	And I enter "valid" value for "MN" textbox on "create person" Page NewUI
	And I enter "valid" value for "LN" textbox on "create person" Page NewUI
    And I enter "random" value for "email" textbox on "create person" Page NewUI
    And I enter "valid" value for "re-enter email" textbox on "create person" Page NewUI  
	And I click on "button-newui" "Next" on "create person" Page
    
    And I should see Text "Package Selection"  
    And I should see element "package icon" for "POW icon"
	And I should see element "package icon Section" for "POW icon"
    And I should see "button-newui" named as "Previous" on "Package Selection" Page
	And I should see element "Add to Cart" for "disabled"
    And I should see element "price" for "displayed"
  	
  	When Search table By "Package" in "Package Selection" page
	And I click on "button-newui" "search" on "package selection" Page
	And I click on "radiobutton-newui" "first pkg" on "package selection" Page
	
	And Verify value "Price" on "Package Selection" Page for DB "UAT"
	And I should see element "Package select checkbox" for "POW"
	And I click on "button-NewUI" "Add to Cart" on "package selection" Page
	
	And Verify value "Price" on "Shopping Cart" Page for DB "UAT"
	And I should see "text-newui" named as "Subtotal" on "Shopping Cart" Page
	And Verify value "Tax" on "Shopping Cart" Page for DB "UAT"
	And I should see "text-newui" named as "Order Total" on "Shopping Cart" Page
	
	And I should see "button-newui" named as "Checkout" on "Shopping Cart" Page
	And I click on "button-newui" "Authorize" on "Shopping Cart" Page
	And I click on "button-NewUI" "Checkout" on "Shopping Cart" Page
	
	Then I should see Text "Payment method"
	And I should see element "credit card icon" for "POW icon"
	And I should see element "credit card icon Section" for "POW icon"
	
	And I should see Text "Use a new payment method"
	And I should see element "checked radiobutton" for "Use a new payment method"
		And I enter "present" value for "FN" textbox on "pow" Page NewUI
  	And I enter "present" value for "LN" textbox on "pow" Page NewUI
	And I enter "valid" value for "CardNumberVisa" textbox on "Add People" Page NewUI
	And I enter "valid" value for "MM" textbox on "Add People" Page NewUI
	And I enter "valid" value for "YY" textbox on "Add People" Page NewUI
	And I enter "valid" value for "CSC" textbox on "Add People" Page NewUI
	
	And I should see "text-newui" named as "Subtotal" on "Shopping Cart" Page
	And Verify value "Tax" on "Payment Method" Page for DB "UAT"
	And I should see "text-newui" named as "Tax" on "Shopping Cart" Page
	And I should see "text-newui" named as "Order Total" on "Shopping Cart" Page
		
	And I should see element "profile icon"
	When I click on "profile-icon"
	And I should see element "logout"
	When I click on "logout"
		
	Then I close browser
	
	
#####################################################################################################################################
@UI-7 @NewUI-7-PAFlow-UAT
	Scenario: NewUIRegression_UI-7-PAFlow

	Given I initialize Browser 
	When I Execute "Validate Profile status and Background tile is functional (EMAIL SENT, REGISTRATED, CONSENT ACCEPTED, COMPLETED)"
	When I Execute "Validate Additional Billing - Flag set to 'N' and Price to $0"
	
	And I am executing "NewUIRegression_UI-7-PAFlow" 
	And I navigate to "NewUI" application 
	And I should see element "login page"
    And I should see "button-newui" named as "Login" on "Login" Page	
	
	When I log in to "ayfuat" New UI application with "valid" Credentials  
	And I click on "button-newui" "Login" on "Login" Page
	
	When I should see "button-newui" named as "I Certify" on "FCRA" Page
	And I click on "button-newui" "I Certify" on "NOTICE" Page

	And I click on "Dashboard"
	And I should see Text "Needs Review"
	And I should see Text "Non-Compliant"
	And I should see Text "Pending"

	When I click on "button-newui" "Needs Review" on "Dashboard" Page
	And I should see element "Needs Review" for "link url"

	And I should see "button-newui" named as "Add People" on "People" Page
    When I click on "button-newui" " Create Order " on "People" Page
   
    And I should see element "add people icon" for "POW icon"
    And I should see element "add people icon Section" for "POW icon"
    And I should see Text "Personal information"
   
   	And I click on "button-newui" "Middle Name Yes" on "create person" Page
	And I enter "valid" value for "FN" textbox on "create person" Page NewUI
	And I enter "valid" value for "MN" textbox on "create person" Page NewUI
	And I enter "valid" value for "LN" textbox on "create person" Page NewUI
    And I enter "random" value for "email" textbox on "create person" Page NewUI
    And I enter "valid" value for "re-enter email" textbox on "create person" Page NewUI  
	And I click on "button-newui" "Next" on "create person" Page
    
    And I should see Text "Package Selection"  
    And I should see element "package icon" for "POW icon"
	And I should see element "package icon Section" for "POW icon"
    And I should see "button-newui" named as "Previous" on "Package Selection" Page
	And I should see element "Add to Cart" for "disabled"
    And I should see element "price" for "displayed"
  	
  	When Search table By "Package" in "Package Selection" page
	And I click on "button-newui" "search" on "package selection" Page
	And I click on "radiobutton-newui" "first pkg" on "package selection" Page
	
	And Verify value "Price" on "Package Selection" Page for DB "UAT"
	And I should see element "Package select checkbox" for "POW"
	And I click on "button-NewUI" "Add to Cart" on "package selection" Page
	
	And Verify value "Price" on "Shopping Cart" Page for DB "UAT"
	And I should see "text-newui" named as "Subtotal" on "Shopping Cart" Page
	And Verify value "Tax" on "Shopping Cart" Page for DB "UAT"
	And I should see "text-newui" named as "Order Total" on "Shopping Cart" Page
	
	And I should see "button-newui" named as "Checkout" on "Shopping Cart" Page
	And I click on "button-newui" "Authorize" on "Shopping Cart" Page
	And I click on "button-NewUI" "Checkout" on "Shopping Cart" Page
	
	Then I should see Text "Payment method"
	And I should see element "credit card icon" for "POW icon"
	And I should see element "credit card icon Section" for "POW icon"
	
	And I click on "radiobutton-newui" "use new payment method" on "payment method" Page
	And I enter "present" value for "FN" textbox on "pow" Page NewUI
  	And I enter "present" value for "LN" textbox on "pow" Page NewUI
	And I enter "valid" value for "CardNumberVisa" textbox on "Add People" Page NewUI
	And I enter "valid" value for "MM" textbox on "Add People" Page NewUI
	And I enter "valid" value for "YY" textbox on "Add People" Page NewUI
	And I enter "valid" value for "CSC" textbox on "Add People" Page NewUI
	
	And I should see "text-newui" named as "Subtotal" on "Shopping Cart" Page
	And Verify value "Tax" on "Payment Method" Page for DB "UAT"
	And I should see "text-newui" named as "Tax" on "Shopping Cart" Page
	And I should see "text-newui" named as "Order Total" on "Shopping Cart" Page
	
	Then I click on "checkbox" "Save CC" on "payment method" Page
    And I click on "button-newui" "Next button on PP" on "Payment Method" Page
    And wait for "2" Seconds 	
	Then I should see Text "Order complete!"
  	And I should see element "order icon" for "POW icon"
	And I should see element "order icon Section" for "POW icon"
		
	And I should see "element" named as "Transaction Number" on "Order Confirmation" Page
	And I should see "text-newui" named as "Credit card" on "order confirmation" Page
	And I should see "text-newui" named as "Credit Card Number" on "order confirmation" Page
	And Verify value "Vendor email" on "Order Confirmation" Page for DB "UAT"

	When I should see "button-newui" named as "Return to People" on "Add People" Page
	When I should see "button-newui" named as "Create a New Order" on "Add People" Page
	
	Then I click on "button-newui" "Return to People Page" on "order submission" Page
	
	And I should see element "People"
	And Search table By "FN & LN" in "pow" page
 	And I click on "button-newui" "search" on "People" Page
 	And I should see element "by multi search"
		
	Then wait Until Profile Status is "Email Sent" for "PA flow"  
	Then I should see element "Profile ID"
	Then I should not see element "Background Tile"
		
	Then Get the ProfileId from UI
	Then I open only a new tab
	Then I switch between tabs "child"
	
	And I navigate to "PAInviteLanuchUrlUAT" application 
   
    Then Wait until Element Present "Sign Up Page"
    And I fill details in PA "SignUp-UAT" page
   
    Then Wait until Element Present "Country Page"
     
    Then I switch between tabs "parent"
    Then wait Until Profile Status is "Registered" for "PA flow"  
	Then I should see element "Profile ID"
	Then I should not see element "Background Tile"
	Then I switch between tabs "child"
    
    And I navigate to "PAInviteLanuchUrlUAT" application
    
    Then Wait until Element Present "Sign In Page"
    And I fill details in PA "SignIn" page
    
    Then Wait until Element Present "Country Page" 
    And I fill details in PA "Country" page
           
    Then Wait until Element Present "ESign Page"
    And I fill details in PA "ESign" page

    Then Wait until Element Present "Notice Page UAT"
	And I fill details in PA "Notice-UAT1" page
	
	Then Wait until Element Present "Consent Page UAT"
	And I fill details in PA "Consent-UAT" page
	
	Then Wait until Element Present "Notice Page UAT"
	And I fill details in PA "Agreement-UAT" page
   
    Then Wait until Element Present "Profile Page"

    Then I switch between tabs "parent"
    Then wait Until Profile Status is "Consent Accepted" for "PA flow"  
	Then I should see element "Profile ID"
	Then I should not see element "Background Tile"
	And I click on "order status" "no hyperlink" on "People" Page
    And I should not see element "compliance hyperlink"
	    
    Then I switch between tabs "child"

    And I fill details in PA "Profile" page 

    Then Wait until Element Present "Residence Page"
    And I fill details in PA "Residence-UAT" page    
    
    Then Wait until Element Present "License Page"
    And I fill details in PA "License-UAT" page
        
     Then Wait until Element Present "Criminal Page"
     And I fill details in PA "Criminal" page
 
	Then Wait until Element Present "Identity Page"
    And I fill details in PA "Identity" page
    
    Then Wait until Element Present "AdditionalInfomartion Page"
    And I fill details in PA "AdditionalInfomartion" page

    Then Wait until Element Present "Review Page"
    And I fill details in PA "Review" page
    
    Then Wait until Element Present "DocumentUpload Page"
    And I fill details in PA "DocumentUpload" page
    
    Then Wait until Element Present "ProfileDashboard Page"
	Then I close open tabs "child"

	Then wait Until Profile Status is "Completed" for "PA flow"
	Then I should see element "Background Tile"
	Then I should see element "Background Tile" for "Pending"
	Then I should not see element "Screening Status"
	Then I should see element "Status" for "Compliance"
	And I should see element "Pending" for "compliance accordion search"
	And I click on "order status" "hyperlink" on "People" Page
	And I click on "button-newui" "continue" on "People" Page
	And I should see element "hyperlink"
    
    Then Click Logout NewUI
    And I close browser	
	
#####################################################################################################################################
@UI-7 @NewUI-7-Additional-BillingZero-UAT 
Scenario: NewUIRegression_UI-7-Additional-BillingZero
	Given I initialize Browser 
	When I Execute "Validate Additional Billing - Flag set to 'Y' and Price to $0"
	And I am executing "NewUIRegression_UI-7-Additional-BillingZero" 
	And I navigate to "NewUI" application 
	And I should see element "login page"
    And I should see "button-newui" named as "Login" on "Login" Page
    
    Then I open only a new tab
	Then I switch between tabs "child"
	And I navigate to "Admin tool-UAT" application
	And I log in to admin tool select customer "AYF Test" for "UAT"
	And I change Package property "ADDITIONAL EXPENSE" to "Y" in Admin tool
	And I change Package property "ADDITIONAL EXPENSE PRICE" to "0" in Admin tool 
	Then I close open tabs "child"
	And I clear the cache
	
	When I log in to "ayfuat" New UI application with "valid" Credentials  
	And I click on "button-newui" "Login" on "Login" Page
    
    When I should see "button-newui" named as "I Certify" on "FCRA" Page
	And I click on "button-newui" "I Certify" on "NOTICE" Page

	When I click on "button-newui" "Needs Review" on "Dashboard" Page
	And I should see element "Needs Review" for "link url"

	And I should see "button-newui" named as "Add People" on "People" Page
    When I click on "button-newui" " Create Order " on "People" Page
   
    And I click on "button-newui" "Middle Name Yes" on "create person" Page
	And I enter "valid" value for "FN" textbox on "create person" Page NewUI
	And I enter "valid" value for "MN" textbox on "create person" Page NewUI
	And I enter "valid" value for "LN" textbox on "create person" Page NewUI
    And I enter "random" value for "email" textbox on "create person" Page NewUI
    And I enter "valid" value for "re-enter email" textbox on "create person" Page NewUI  
	And I click on "button-newui" "Next" on "create person" Page
    
    And I should see Text "Package Selection"  
    And I should see element "package icon" for "POW icon"
	And I should see element "package icon Section" for "POW icon"
    And I should see "button-newui" named as "Previous" on "Package Selection" Page
	And I should see element "Add to Cart" for "disabled"
    And I should see element "price" for "displayed"
  	
  	When Search table By "Package" in "Package Selection" page
	And I click on "button-newui" "search" on "package selection" Page
	And I click on "radiobutton-newui" "first pkg" on "package selection" Page
	
	And Verify value "Price" on "Package Selection" Page for DB "UAT"
	And I should see element "Package select checkbox" for "POW"
	And I click on "button-NewUI" "Add to Cart" on "package selection" Page
	
	And Verify value "Price" on "Shopping Cart" Page for DB "UAT"
	And I should see "text-newui" named as "Subtotal" on "Shopping Cart" Page
	And Verify value "Tax" on "Shopping Cart" Page for DB "UAT"
	And I should see "text-newui" named as "Order Total" on "Shopping Cart" Page
	
	And I should see "button-newui" named as "Checkout" on "Shopping Cart" Page
	And I click on "button-newui" "Authorize" on "Shopping Cart" Page
	And I click on "button-NewUI" "Checkout" on "Shopping Cart" Page
	
	And I click on "radiobutton-newui" "use new payment method" on "payment method" Page
	And I enter "present" value for "FN" textbox on "pow" Page NewUI
  	And I enter "present" value for "LN" textbox on "pow" Page NewUI
	And I enter "valid" value for "CardNumberVisa" textbox on "Add People" Page NewUI
	And I enter "valid" value for "MM" textbox on "Add People" Page NewUI
	And I enter "valid" value for "YY" textbox on "Add People" Page NewUI
	And I enter "valid" value for "CSC" textbox on "Add People" Page NewUI
	
    And I should see "text-newui" named as "Subtotal" on "Shopping Cart" Page
	And Verify value "Tax" on "Payment Method" Page for DB "UAT"
	And I should see "text-newui" named as "Tax" on "Shopping Cart" Page
	And I should see "text-newui" named as "Order Total" on "Shopping Cart" Page
	
	And I click on "button-newui" "Next button on PP" on "Payment Method" Page
    And wait for "2" Seconds 	
	Then I should see Text "Order complete!"
  		
	And I should see "element" named as "Transaction Number" on "Order Confirmation" Page
	And I should see "text-newui" named as "Credit card" on "order confirmation" Page
	And I should see "text-newui" named as "Credit Card Number" on "order confirmation" Page
	And Verify value "Vendor email" on "Order Confirmation" Page for DB "UAT"

	When I should see "button-newui" named as "Return to People" on "Add People" Page
	When I should see "button-newui" named as "Create a New Order" on "Add People" Page
	
	Then I click on "button-newui" "Return to People Page" on "order submission" Page
	
	And I should see element "People"
	And Search table By "FN & LN" in "pow" page
 	And I click on "button-newui" "search" on "People" Page
 	And I should see element "by multi search"
 	
 	And I close browser
 	
 #####################################################################################################################################
@UI-7 @NewUI-7-Additional-BillingPrice-UAT
	Scenario: NewUIRegression_UI-7-Additional-BillingPrice

	Given I initialize Browser 
	When I Execute "Validate Additional Billing - Flag set to 'Y' and Price to $1"
	
	And I am executing "NewUIRegression_UI-7-Additional-BillingPrice" 
	And I navigate to "NewUI" application 
	And I should see element "login page"
    And I should see "button-newui" named as "Login" on "Login" Page
    
    Then I open only a new tab
	Then I switch between tabs "child"
	And I navigate to "Admin tool-UAT" application
	And I log in to admin tool select customer "AYF Test" for "UAT"
	And I change Package property "ADDITIONAL EXPENSE" to "Y" in Admin tool
	And I change Package property "ADDITIONAL EXPENSE PRICE" to "1" in Admin tool 
	Then I close open tabs "child"
	And I clear the cache
	
	When I log in to "ayfuat" New UI application with "valid" Credentials  
	And I click on "button-newui" "Login" on "Login" Page
    
    When I should see "button-newui" named as "I Certify" on "FCRA" Page
	And I click on "button-newui" "I Certify" on "NOTICE" Page

	When I click on "button-newui" "Needs Review" on "Dashboard" Page
	And I should see element "Needs Review" for "link url"

	And I should see "button-newui" named as "Add People" on "People" Page
    When I click on "button-newui" " Create Order " on "People" Page
   
    And I click on "button-newui" "Middle Name Yes" on "create person" Page
	And I enter "valid" value for "FN" textbox on "create person" Page NewUI
	And I enter "valid" value for "MN" textbox on "create person" Page NewUI
	And I enter "valid" value for "LN" textbox on "create person" Page NewUI
    And I enter "random" value for "email" textbox on "create person" Page NewUI
    And I enter "valid" value for "re-enter email" textbox on "create person" Page NewUI  
	And I click on "button-newui" "Next" on "create person" Page
    
    And I should see Text "Package Selection"  
    And I should see element "package icon" for "POW icon"
	And I should see element "package icon Section" for "POW icon"
    And I should see "button-newui" named as "Previous" on "Package Selection" Page
	And I should see element "Add to Cart" for "disabled"
    And I should see element "price" for "displayed"
  	
  	When Search table By "Package" in "Package Selection" page
	And I click on "button-newui" "search" on "package selection" Page
	And I click on "radiobutton-newui" "first pkg" on "package selection" Page
	
	And Verify value "Price" on "Package Selection" Page for DB "UAT"
	And I should see element "Package select checkbox" for "POW"
	And I click on "button-NewUI" "Add to Cart" on "package selection" Page
	
	And Verify value "Price" on "Shopping Cart" Page for DB "UAT"
	And I should see "text-newui" named as "Subtotal" on "Shopping Cart" Page
	And Verify value "Tax" on "Shopping Cart" Page for DB "UAT"
	And I should see "text-newui" named as "Order Total" on "Shopping Cart" Page
	
	And I should see "button-newui" named as "Checkout" on "Shopping Cart" Page
	And I click on "button-newui" "Authorize" on "Shopping Cart" Page
	And I click on "button-NewUI" "Checkout" on "Shopping Cart" Page
	
	And I click on "radiobutton-newui" "use new payment method" on "payment method" Page
	And I enter "present" value for "FN" textbox on "pow" Page NewUI
  	And I enter "present" value for "LN" textbox on "pow" Page NewUI
	And I enter "valid" value for "CardNumberVisa" textbox on "Add People" Page NewUI
	And I enter "valid" value for "MM" textbox on "Add People" Page NewUI
	And I enter "valid" value for "YY" textbox on "Add People" Page NewUI
	And I enter "valid" value for "CSC" textbox on "Add People" Page NewUI
	
    And I should see "text-newui" named as "Subtotal" on "Shopping Cart" Page
	And Verify value "Tax" on "Payment Method" Page for DB "UAT"
	And I should see "text-newui" named as "Tax" on "Shopping Cart" Page
	And I should see "text-newui" named as "Order Total" on "Shopping Cart" Page
	
	And I click on "button-newui" "Next button on PP" on "Payment Method" Page
    And wait for "2" Seconds 	
	Then I should see Text "Order complete!"
  		
	And I should see "element" named as "Transaction Number" on "Order Confirmation" Page
	And I should see "text-newui" named as "Credit card" on "order confirmation" Page
	And I should see "text-newui" named as "Credit Card Number" on "order confirmation" Page
	And Verify value "Vendor email" on "Order Confirmation" Page for DB "UAT"

	When I should see "button-newui" named as "Return to People" on "Add People" Page
	When I should see "button-newui" named as "Create a New Order" on "Add People" Page
	
	Then I click on "button-newui" "Return to People Page" on "order submission" Page
	
	And I should see element "People"
	And Search table By "FN & LN" in "pow" page
 	And I click on "button-newui" "search" on "People" Page
 	And I should see element "by multi search"
 	
 	And I close browser