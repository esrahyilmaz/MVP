Feature: Sanity_NewUI_CC

@SanityCC
Scenario: NewUI_People Ordering Credit Card

Given I initialize Browser 
	
	And I am executing "NewUI_People Ordering Credit Card" 
	And I navigate to "NewUI" application 
	
	And I should see element "login page"
    And I should see "button-newui" named as "Login" on "Login" Page	
	
	When I log in to "newuiamazon1" New UI application with "valid" Credentials 
	#When I log in to "newuiamazon1" New UI application with "valid" Credentials 
	
	And I click on "button-newui" "Login" on "Login" Page
	
	When I should see "button-newui" named as "I Certify" on "FCRA" Page
	And I click on "button-newui" "I Certify" on "NOTICE" Page
#	
	And I should see Text "Needs Review"
	And I should see Text "Non-Compliant"
	And I should see Text "Pending"
#	
	When I click on "button-newui" "Needs Review" on "Dashboard" Page
	And I should see element "Needs Review" for "link url"
	And I should see element "Active" for "filter pill"
	Then I should not see "People" column "Person Status" value "Inactive" on "NewUI" Page
	Then I should not see "People" column "Person Status" value "Terminated" on "NewUI" Page
	
	Then I should see "button-newui" named as "Add People" on "People" Page
    When I click on "button-newui" " Create Order " on "People" Page
    
    And I should see "button-newui" named as "Cancel" on "Personal Information" Page
    And I should see "button-newui" named as "Next" on "Personal Information" Page
    
    And I enter "valid" value for "FN" textbox on "Add People" Page NewUI
	And I click on "button-newui" "Middle Name Yes" on "add people" Page
	And I enter "valid" value for "MN" textbox on "Add People" Page NewUI
	And I enter "valid" value for "LN" textbox on "Add People" Page NewUI
    And I enter "random" value for "email" textbox on "Add People" Page NewUI
    And I enter "valid" value for "re-enter email" textbox on "Add People" Page NewUI 
#    And I enter "valid" value for "Country" textbox on "Add People" Page NewUI     
#    And I enter "valid" value for "City" textbox on "Add People" Page NewUI 
#    And I enter "valid" value for "State" textbox on "Add People" Page NewUI   

	And I click on "button-newui" "Next" on "Personal Information" Page
	
	And I should see "button-newui" named as "Previous" on "Package Selection" Page
	And I should see "button-newui" named as "Add to Cart" on "Package Selection" Page
	And I should not see element "Previous" for "disabled"
	And I should see element "Add to Cart" for "disabled"
    And I should see element "price" for "displayed"
    
    When Search table By "invalid Package" in "Package Selection" page
	And I click on "button-newui" "search" on "add people" Page
	Then I should see Text "No packages found."
		
	When Search table By "Package" in "Package Selection" page
	And I click on "button-newui" "search" on "add people" Page
	And I click on "radiobutton-newui" "first pkg" on "Add People" Page
	And I should not see element "Add to Cart" for "disabled"
 	And Verify value "Price" on "Package Selection" Page for DB "QCSA"
	And I should see element "Package select checkbox" for "POW"
	
	And I click on "button-NewUI" "Add to Cart" on "add people" Page
	
	And I should see "text-newui" named as "existing Person" on "Shopping Cart" Page
	And I should see "text-newui" named as "existing Package" on "Shopping Cart" Page	
	And Verify value "Price" on "Shopping Cart" Page for DB "QCSA"
	
	And I should see "text-newui" named as "Subtotal" on "Shopping Cart" Page
	And Verify value "Tax" on "Shopping Cart" Page for DB "QCSA"
	And I should see "text-newui" named as "Tax" on "Shopping Cart" Page
	And I should see "text-newui" named as "Order Total" on "Shopping Cart" Page

	When Search table By "invalid search" in "Shopping Cart" page
	And I click on "button-newui" "search" on "Shopping Cart" Page
	Then I should see Text "No items in the shopping cart."
	And I clear "Search field" in "Shopping Cart" Page
	And I click on "button-newui" "search" on "Shopping Cart" Page
	
	
#	And I should see "button-newui" named as "Checkout" on "Shopping Cart" Page	
	
	And I click on "button-NewUI" "Checkout" on "Add People" Page

	And I click on "radiobutton-newui" "new" on "Payment Method" Page
   And I enter "existing" value for "FN" textbox on "pow" Page NewUI
  	And I enter "existing" value for "LN" textbox on "pow" Page NewUI
	And I enter "valid" value for "CardNumber" textbox on "Add People" Page NewUI
	And I enter "valid" value for "MM" textbox on "Add People" Page NewUI
	And I enter "valid" value for "YY" textbox on "Add People" Page NewUI
	And I enter "valid" value for "CSC" textbox on "Add People" Page NewUI
	
	And I should see "button-newui" named as "Cancel" on "Payment Method" Page
	And I should see "button-newui" named as "Next" on "Payment Method" Page
		
	And I click on "button-newui" "Next button on PP" on "add people" Page
	
	And I should see "element" named as "transaction number" on "order confirmation" Page
	And I should see "text-newui" named as "Credit card" on "order confirmation" Page
	And I should see "text-newui" named as "Credit Card Number" on "order confirmation" Page
	And I should see Text "*Any outstanding balances related to services provided will be collected at the time of your next login."
	And Verify value "Vendor email" on "Order Confirmation" Page for DB "QCSA"
	
	When I should see "button-newui" named as "Return to People" on "Add People" Page
	When I should see "button-newui" named as "Create a New Order" on "Add People" Page
	
	Then I click on "button-newui" "Return to People Page" on "add people" Page
	And I should see element "People"
	
	And Search table By "FN & LN" in "People" page
 	And I click on "button-newui" "search" on "People" Page
 	And I should see element "by multi search" 
	And I click on Accordion
	Then I should see Text "Email Sent"
	Then I should see element "Profile ID"
	Then I should not see element "Background Tile"
	Then I should not see element "Screening Status"
	Then I should see element "Status" for "Compliance"
	Then I should see element "Compliance Status" for "Pending"
	And I click on "complinace status" "no hyperlink" on "People" Page
    And I should not see element "compliance hyperlink"
    
    #############################################
    ##		PA flow - Consent Accepted         ##
    #############################################
    
    When I get existing data of "Completed Profile Person"
    And Search table By "FN & LN" in "People" page
    And I click on "button-newui" "search" on "People" Page
    And I get details of "Person" from UI
    And I should see element "by multi search" 
	And I click on Accordion
	Then I should see Text "Completed"
	Then I should see element "Profile ID"
	Then I should see element "Background Tile"
	Then I should not see element "Screening Status"
	Then I should see element "Status" for "Compliance"
	Then I should see element "Compliance Status" for "Pending"
	And I click on "complinace status" "hyperlink" on "People" Page
    And I click on "button-newui" "continue" on "People" Page
    And I should see element "hyperlink"
    
    Then I should see the sponsor logo in the header "VendorLogo" 
	And I should see Customer support "number" in the header 
	And I should see Customer support "email" in the header 
	Then I should click "SupportLink" in the footer 
	And I should click "FactActLink" in the footer 
	And I should click "LegalLink" in the footer 
	And I should click "PrivacyPolice" in the footer 
	And I should see "FadvTrademark" in the footer of the page 
    
    Then Click Logout NewUI

    And I close browser
    
    
############################################################################################################################################
@SanityOB
Scenario: NewUI_People Ordering Credit Card-OB

Given I initialize Browser 
	
	And I am executing "NewUI_People Ordering Credit Card-OB" 
	And I navigate to "NewUI" application 
	
	And I should see element "login page"
    And I should see "button-newui" named as "Login" on "Login" Page	
	
	When I log in to "newuiamazonuat" New UI application with "valid" Credentials 
	#When I log in to "newuiamazon1" New UI application with "valid" Credentials 
	
	And I click on "button-newui" "Login" on "Login" Page
	
	When I should see "button-newui" named as "I Certify" on "FCRA" Page
	
	And I click on "button-newui" "I Certify" on "NOTICE" Page
	
	And I should see Text "Needs Review"
	And I should see Text "Non-Compliant"
	And I should see Text "Pending"
	
	When I click on "button-newui" "Needs Review" on "Dashboard" Page
	And I should see element "Needs Review" for "link url"
	And I should see element "Active" for "filter pill"
	Then I should not see "People" column "Person Status" value "Inactive" on "NewUI" Page
	Then I should not see "People" column "Person Status" value "Terminated" on "NewUI" Page
	
	Then I should see "button-newui" named as "Add People" on "People" Page
    When I click on "button-newui" " Create Order " on "People" Page
    
    And I should see "button-newui" named as "Cancel" on "Personal Information" Page
    And I should see "button-newui" named as "Next" on "Personal Information" Page
    
    And I enter "valid" value for "FN" textbox on "Add People" Page NewUI
	And I click on "button-newui" "Middle Name Yes" on "add people" Page
	And I enter "valid" value for "MN" textbox on "Add People" Page NewUI
	And I enter "valid" value for "LN" textbox on "Add People" Page NewUI
    And I enter "random" value for "email" textbox on "Add People" Page NewUI
    And I enter "valid" value for "re-enter email" textbox on "Add People" Page NewUI 
    And I enter "valid" value for "Country" textbox on "Add People" Page NewUI     
    And I enter "valid" value for "City" textbox on "Add People" Page NewUI 
    And I enter "valid" value for "State" textbox on "Add People" Page NewUI   

	And I click on "button-newui" "Next" on "Personal Information" Page
	
	And I should see "button-newui" named as "Previous" on "Package Selection" Page
	And I should see "button-newui" named as "Add to Cart" on "Package Selection" Page
	And I should see element "Add to Cart" for "disabled"
    And I should see element "price" for "displayed"
    
    When Search table By "invalid Package" in "Package Selection" page
	And I click on "button-newui" "search" on "add people" Page
	Then I should see Text "No packages found."
	And Refresh The Page
	
	When Search table By "Package" in "Package Selection" page
	And I click on "button-newui" "search" on "add people" Page
	And I click on "radiobutton-newui" "first pkg" on "Add People" Page
	And I should not see element "Add to Cart" for "disabled"
 	And Verify value "Price" on "Package Selection" Page for DB "QCSA"
	And I should see element "Package select checkbox" for "POW"
	And I click on "button-NewUI" "Add to Cart" on "add people" Page
	
	And I should see "text-newui" named as "existing Person" on "Shopping Cart" Page
	And I should see "text-newui" named as "existing Package" on "Shopping Cart" Page	
	And Verify value "Price" on "Shopping Cart" Page for DB "QCSA"
	
	And I should see "text-newui" named as "Subtotal" on "Shopping Cart" Page
	And Verify value "Tax" on "Shopping Cart" Page for DB "QCSA"
	And I should see "text-newui" named as "Order Total" on "Shopping Cart" Page

	When Search table By "invalid search" in "Shopping Cart" page
	And I click on "button-newui" "search" on "Shopping Cart" Page
	Then I should see Text "No items in the shopping cart."

	When Search table By "Package" in "Shopping Cart" page
	And I click on "button-newui" "search" on "Shopping Cart" Page
	
	And I should see "button-newui" named as "Checkout" on "Shopping Cart" Page	
	
	And I click on "button-NewUI" "Checkout" on "Add People" Page

	And I click on "radiobutton-newui" "new" on "Payment Method" Page
    And I enter "valid" value for "FN" textbox on "pow" Page NewUI
  	And I enter "valid" value for "LN" textbox on "pow" Page NewUI
	And I enter "valid" value for "CardNumber" textbox on "Add People" Page NewUI
	And I enter "valid" value for "MM" textbox on "Add People" Page NewUI
	And I enter "valid" value for "YY" textbox on "Add People" Page NewUI
	And I enter "valid" value for "CSC" textbox on "Add People" Page NewUI
	
	And I should see "button-newui" named as "Cancel" on "Payment Method" Page
	And I should see "button-newui" named as "Next" on "Payment Method" Page
		
	And I click on "button-newui" "Next button on PP" on "add people" Page
	
	And I should see "element" named as "transaction number" on "order confirmation" Page
	And I should see "text-newui" named as "Credit card" on "order confirmation" Page
	And I should see "text-newui" named as "Credit Card Number" on "order confirmation" Page
	
	And I should see Text "*Any outstanding balances related to services provided will be collected at the time of your next login."
	
	And Verify value "Vendor email" on "Order Confirmation" Page for DB "QCSA"
	
	When I should see "button-newui" named as "Return to People" on "Add People" Page
	When I should see "button-newui" named as "Create a New Order" on "Add People" Page
	
	Then I click on "button-newui" "Return to People Page" on "add people" Page
	And I should see element "People"
	
	And Search table By "FN & LN" in "People" page
 	And I click on "button-newui" "search" on "People" Page
 	And I should see element "by multi search" 
	And I click on Accordion
	Then I should see Text "Email Sent"
	Then I should see element "Profile ID"
	Then I should not see element "Background Tile"
	Then I should not see element "Screening Status"
	Then I should see element "Status" for "Compliance"
	Then I should see element "Compliance Status" for "Pending"
	And I click on "complinace status" "hyperlink" on "People" Page
    And I should see element "compliance hyperlink"
    
    #############################################
    ##		PA flow - Consent Accepted         ##
    #############################################
    
    When I get existing data of "Completed Profile Person"
    And Search table By "FN & LN" in "People" page
    And I click on "button-newui" "search" on "People" Page
    And I get details of "Person" from UI
    And I should see element "by multi search" 
	And I click on Accordion
	Then I should see Text "Completed"
	Then I should see element "Profile ID"
	Then I should see element "Background Tile"
	Then I should not see element "Screening Status"
	Then I should see element "Status" for "Compliance"
	Then I should see element "Compliance Status" for "Pending"
	And I click on "complinace status" "hyperlink" on "People" Page
    And I click on "button-newui" "continue" on "People" Page
    And I should see element "hyperlink"
    
    Then I should see the sponsor logo in the header "VendorLogo" 
	And I should see Customer support "number" in the header 
	And I should see Customer support "email" in the header 
	Then I should click "SupportLink" in the footer 
	And I should click "FactActLink" in the footer 
	And I should click "LegalLink" in the footer 
	And I should click "PrivacyPolice" in the footer 
	And I should see "FadvTrademark" in the footer of the page 
    
    Then Click Logout NewUI
	
	And I should see element "login page"
    And I should see "button-newui" named as "Login" on "Login" Page	
	
	When I log in to "newuiamazonuat" New UI application with "valid" Credentials 
	
	And I click on "button-newui" "Login" on "Login" Page
	When I should see "button-newui" named as "I Certify" on "FCRA" Page
	And I click on "button-newui" "I Certify" on "NOTICE" Page
	
	And I should see Text "Notice"
	
	 ## Order total in message##
	
	And I should see element "outstanding message" for "outstanding balance" 
	
	## Sysdate ##
	
	And I should see element "Order Date" for "outstanding balance"
	
	## Name of Vendor ##
	
	And I should see element "Name" for "outstanding balance" 
	
	## Name of Package ##
	
	And I should see element "Additional Charge" for "outstanding balance" 
	
	## Sysdate ##
	
	And I should see element "Date Charged" for "outstanding balance"
	
	## Order Total ##
	
	And I should see element "Balance Outstanding" for "outstanding balance"
	
	 
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
