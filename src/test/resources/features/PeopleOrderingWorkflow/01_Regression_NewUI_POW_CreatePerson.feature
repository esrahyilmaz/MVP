Feature: Regression NewUI People Order Workflow - Create Person
#******************************************************************************************************************************

################################People Ordering Workflow - Create Person Screen - 3215#########################################     
  @NewUI-PeopleOrderingWorkflow
  @SiteCreditPrerequisiteSetZero
  Scenario: NewUI_SiteCreditPrerequisteNewAccount
    Given I initialize Browser
    When I am executing "NewUI_SiteCreditPrerequisteNewAccount"
    And I navigate to "NewUI" application
    And I log in to "autoqcs" New UI application with "valid" Credentials
    And Get "Cust_ID" from API
    And Get "Vendor_ID" from API
    Then Set Site Credit "OFF"
    And I close browser
    
@NewUI-PeopleOrderingWorkflow
@NewUI-POW-CreatePerson01
Scenario: NewUI_SC01-Create Person
	Given I initialize Browser
	When I am executing "NewUI_SC01-Create Person" 
      
    Then I open only a new tab
	Then I switch between tabs "child"
	And I navigate to "Admin tool" application
	And I log in to admin tool select customer "XTDAUTOQCSA" for "QCSA"
	And I update Property "ENABLE_PA_INTEGRATION" to "Y"
	And I update Property "POSITION_HIRE_LOCATION_REQUIRED" to "Y" 
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
    
    Then I should see the sponsor logo in the header "VendorLogo"
    And I should see Customer support "number" in the header
    And I should see Customer support "email" in the header
    Then I should click "SupportLink" in the footer
    And I should click "FactActLink" in the footer
    And I should click "LegalLink" in the footer
    And I should click "PrivacyPolice" in the footer
    And I should see "FadvTrademark" in the footer of the page
    
    And I should see element "add people icon" for "POW icon"
    And I should see element "add people icon Section" for "POW icon"
    And I should see Text "Personal information"
    And I should see Text "We need some details to add the new person." 
    And I should see Text "Do You Have Middle Name?"
    
    And Verify Element "exist" with data-xf-qa-id "VW-POPI-LFN" for "First Name"
	And Verify Element "exist" with data-xf-qa-id "VW-POPI-LMN" for "Middle Name"
	And Verify Element "exist" with data-xf-qa-id "VW-POPI-LLN" for "Last Name"
	And Verify Element "exist" with data-xf-qa-id "VW-POPI-PEA" for "Email"
	And Verify Element "exist" with data-xf-qa-id "VW-POPI-CPEA" for "Confirm email"
	And Verify Element "exist" with data-xf-qa-id "VW-POPI-WCOUNTRY" for "Country"
	And Verify Element "exist" with data-xf-qa-id "VW-POPI-WCITY" for "City"
	And Verify Element "exist" with data-xf-qa-id "VW-POPI-WSTATE" for "State"
	
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
	And I close browser

##########################People Ordering Workflow - Create Person Screen - error msg/position hire location ##################
@NewUI-PeopleOrderingWorkflow
@NewUI-POW-CreatePerson 
@NewUI-POW-CreatePerson-PositionHireLocation
Scenario: NewUI_SC02-Create Person-Error Messages
	Given I initialize Browser
	And I am executing "NewUI_SC02-Create Person-Error Messages" 
	And I navigate to "NewUI" application 
	
	Then I open only a new tab
	Then I switch between tabs "child"
	And I navigate to "Admin tool" application
	And I log in to admin tool select customer "XTDAUTOQCSA" for "QCSA"
	And I update Property "POSITION_HIRE_LOCATION_REQUIRED" to "Y" 
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
    And I click on "button-newui" "Next" on "create person" Page
    
    And I should see "errormsg-newui" named as "First Name is required" on "create person" Page
    And I should see "errormsg-newui" named as "Last Name is required" on "create person" Page
    And I should see "errormsg-newui" named as "Email is required" on "create person" Page
    And I should see "errormsg-newui" named as "Confirm Email Address is required" on "create person" Page
    And I should see "errormsg-newui" named as "Country is required" on "create person" Page
    And I should see "errormsg-newui" named as "City/Municipality is required" on "create person" Page
    And I should see "errormsg-newui" named as "State / Region is required" on "create person" Page
    
    When I click on "button-newui" "Middle Name Yes" on "create person" Page
    And I should see "errormsg-newui" named as "Middle Name is required" on "create person" Page
    
    And I enter "max" value for "FN" textbox on "create person" Page NewUI
    And I should see "errormsg-newui" named as "Max length (50) exceeded" on "create person" Page
    And I clear "FN" in "pow" Page
        
    And I enter "max" value for "MN" textbox on "create person" Page NewUI
    And I should see "errormsg-newui" named as "Max length (50) exceeded" on "create person" Page
    And I clear "MN" in "pow" Page
    
    And I enter "max" value for "LN" textbox on "create person" Page NewUI
    And I should see "errormsg-newui" named as "Max length (50) exceeded" on "create person" Page
    And I clear "LN" in "pow" Page
        
    And I enter "invalid" value for "email" textbox on "create person" Page NewUI
    And I should see "errormsg-newui" named as "A valid email is required" on "create person" Page
    
    And I enter "min" value for "email" textbox on "create person" Page NewUI
    And I should see "errormsg-newui" named as "Min length (3) not met" on "create person" Page
    
 	Then I switch between tabs "child"
	And I update Property "POSITION_HIRE_LOCATION_REQUIRED" to "N" 
	Then I switch between tabs "parent"
	And I clear the cache
	And Refresh The Page
	
	And I click on "button-newui" "Next" on "create person" Page
    Then I should not see "errormsg-newui" named as "Country is required" on "create person" Page
	And I should not see "errormsg-newui" named as "City/Municipality is required" on "create person" Page 
	And I should not see "errormsg-newui" named as "State/Region is required" on "create person" Page  
	
	Then I switch between tabs "child"
	And I update Property "POSITION_HIRE_LOCATION_REQUIRED" to "Null" 
	Then I close open tabs "child"
	And I clear the cache
	And Refresh The Page
	
	And Verify Element "doesn't exist" with data-xf-qa-id "country-field" for "Country"
	And Verify Element "doesn't exist" with data-xf-qa-id "region-field" for "City"
	And Verify Element "doesn't exist" with data-xf-qa-id "city" for "State"
          
	And I close browser
	
###################### People Ordering Workflow - Create Person Screen - cancel/next ###########################################    
#@NewUI-PeopleOrderingWorkflow
@NewUI-POW-CreatePerson 
@NewUI-POW-CreatePerson-Cancel/NextPage
Scenario: NewUI_SC03-Create Person-CancelNext
	Given I initialize Browser
	And I am executing "NewUI_SC03-Create Person-CancelNext" 
    And I navigate to "NewUI" application 
    
    Then I open only a new tab
	Then I switch between tabs "child"
	And I navigate to "Admin tool" application
	And I log in to admin tool select customer "XTDAUTOQCSA" for "QCSA"
	And I update Property "POSITION_HIRE_LOCATION_REQUIRED" to "Y"
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
    And I click on "button-newui" "Middle Name Yes" on "create person" Page
	And I enter "valid" value for "FN" textbox on "create person" Page NewUI
	And I enter "valid" value for "MN" textbox on "create person" Page NewUI
	And I enter "valid" value for "LN" textbox on "create person" Page NewUI
    And I enter "valid" value for "email" textbox on "create person" Page NewUI
    And I enter "valid" value for "re-enter email" textbox on "create person" Page NewUI  
	And I enter "valid" value for "Country" textbox on "create person" Page NewUI     
    And I enter "valid" value for "City" textbox on "create person" Page NewUI 
    And I enter "valid" value for "State" textbox on "create person" Page NewUI
    
    And I click on "button-newui" "Cancel" on "create person" Page
	And I should see element "People"
	And Search table By "FN & LN" in "pow" page
 	And I click on "button-newui" "search" on "People" Page
 	And I should see Text "No Results Found"
 	
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
    
    And I click on "button-newui" "Previous" on "package selection" Page
    And Verify Information on "create person" Page
    
    And I click on "button-newui" "Cancel" on "create person" Page
	And I should see element "People"
	And Search table By "FN & LN" in "pow" page
 	And I click on "button-newui" "search" on "People" Page
 	And I should see Text "No Results Found"
 	
 	And I close browser
	