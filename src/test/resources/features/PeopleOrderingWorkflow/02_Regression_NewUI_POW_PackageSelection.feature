Feature: Regression NewUI People Order Workflow - Package Selection
#******************************************************************************************************************************

################################People Ordering Workflow -  Package Selection Screen - 3216 #########################################     
@NewUI-PeopleOrderingWorkflow
@NewUI-POW-PackageSelection01
Scenario: NewUI_SC04-Package Selection
	Given I initialize Browser 
	And I am executing "NewUI_SC04-Package Selection" 
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
	And I should see element "package icon" for "POW icon"
	And I should see element "package icon Section" for "POW icon"
	
	Then I should see the sponsor logo in the header "VendorLogo"
    And I should see Customer support "number" in the header
    And I should see Customer support "email" in the header
    Then I should click "SupportLink" in the footer
    And I should click "FactActLink" in the footer
    And I should click "LegalLink" in the footer
    And I should click "PrivacyPolice" in the footer
    And I should see "FadvTrademark" in the footer of the page
    
    And I should see element "pagination"
    When I click on "pagination" "next" on "Search Package" Page
    And I should see element "class disabled" for "next button"
    When I click on "pagination" "previous" on "Search Package" Page
    And I should see element "class disabled" for "previous button"
    When I click on "pagination" "GoToLast" on "Search Package" Page
    And I should see element "class disabled" for "next button"
    When I click on "pagination" "GoToFirst" on "Search Package" Page
    And I should see element "class disabled" for "previous button"
		
	And I should see Text "Select the screening package." 
	And I should see Text "Screening packages"
	And Verify Element "exist" with data-xf-qa-id "VW-POPS-PCKG-SEARCHFIELD" for "Search for Package"
	And Verify Element "exist" with data-xf-qa-id "VW-POPS-PCKG-SEARCHICON" for "Search for Package Icon"
	And I should see element "Package select checkbox" for "POW"
	And I should see element "Package Name" for "POW"
	And I should see element "Package Description" for "POW"
	
	When I Execute "Validate Package Price is displayed when PPM is CC"
	And I should see element "Package Price Tag" for "POW"
	
	And I should see element "Add to Cart" for "disabled"
	And I should see "button-newui" named as "Previous" on "People" Page
	
	When Search table By "invalid Package" in "package selection" page
	And I click on "button-newui" "search" on "package selection" Page
	And I should see Text "No packages found."
	
	And I click on "button-NewUI" "Previous" on "package selection" Page
	And I should see Text "Personal information"
	Then I click on "button-newui" "Next" on "create person" Page
	
	When Search table By "package" in "Package Selection" page
	And I click on "button-newui" "search" on "package selection" Page
	And I click on "radiobutton-newui" "first pkg" on "package selection" Page
	And I should see element "Package select checkbox" for "POW"
	And I should see element "Package Price Tag" for "POW"
	And Verify value "Price" on "Package Selection" Page for DB "QCSA"
	
	And I click on "button-NewUI" "Add to Cart" on "package selection" Page
	
	And I should see Text "Shopping cart"
	And I close browser
	
################################People Ordering Workflow -  Package Selection Screen - 3216 #########################################     
@NewUI-PeopleOrderingWorkflow
@NewUI-POW-PackageSelection 
@NewUI-POW-PackageSelection-ProgramPaymentMethod
Scenario: NewUI_SC05-Package Selection-Price
	Given I initialize Browser 
	And I am executing "NewUI_SC05-Package Selection-Price" 
    And I navigate to "NewUI" application
    
    Then I open only a new tab
	Then I switch between tabs "child"
	And I navigate to "Admin tool" application
	And I log in to admin tool select customer "XTDAUTOQCSA" for "QCSA"
	And I update Property "PROGRAM_PAYMENT_METHOD" to "Vendor Invoice" 
	Then I switch between tabs "parent"
	And I clear the cache
	And I should see element "login page"
       	   
    When I log in to "autoqcs" New UI application with "valid" Credentials 
    And I click on "button-newui" "Login" on "Login" Page 
    And I click on "button-newui" "I Certify" on "NOTICE" Page 
   	And I click on "MenuButton-NewUI" "People" on "HOME" Page
    And I should see element "People"
    And I should see Text "Create Order"
    When I click on "button-newui" " Create Order " on "People" Page
    
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
    When I Execute "Validate Package Price is displayed when PPM is Vendor Invoice"
   	And I should see element "Package Price Tag" for "POW"

#   	SPONSOR INVOICE IS NOT APPLICABLE
#   	And I set Program Payment Method to "Sponsor Invoice" where Vendor "66244"
#   	And Refresh The Page
#   	When I Execute "Validate Package Price is not displayed when Vendor lvl PPM is Sponsor Invoice"
#   	And I should not see element "Package Price Tag"
   	
#	Then I switch between tabs "child"
#	And I update Property "PROGRAM_PAYMENT_METHOD" to "Sponsor Invoice"
#	Then I switch between tabs "parent"
#	And I clear the cache
#	And I should see Text "Package Selection"
#	And I set Program Payment Method to "null" where Vendor "66244"
#	And Refresh The Page
#	When I Execute "Validate Package Price is displayed when PPM is Sponsor Invoice"
#   	And I should not see element "Package Price Tag"
   	
   	And I close browser
	