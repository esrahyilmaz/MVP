Feature: Regression NewUI People Search - Accordion with Profile Advantage/Screening Tiles
#******************************************************************************************************************************

########################People Search - Accordion with Profile Advantage/Screening Tiles - US -3220 ####################
#@NewUI-PeopleOrderingWorkflow
@ToBeImplemented
@NewUIAccordionPA-Completed
Scenario: NewUI_SC16-Accordion with PA/ST-Completed
	Given I initialize Browser 
    And I am executing "NewUI_SC16-Accordion with PA/ST-Completed"
    And I navigate to "NewUI" application

	And Set "PROGRAM_PAYMENT_METHOD" to "Vendor Invoice" for "1364" Customer
	And Set "XTDFORCE_COMPLIANCE_SUPPRESSION" to "N" for "1364" Customer
	And Set "POSITION_HIRE_LOCATION_REQUIRED" to "N" for "1364" Customer

	Then I open only a new tab
	Then I switch between tabs "child"
	And I navigate to "Admin tool" application
	And I log in to admin tool select customer "QCSAAUTOVC" for "QCSA"
	And I update Property "PROGRAM_PAYMENT_METHOD" to "Vendor Invoice"
	And I update Property "XTDFORCE_COMPLIANCE_SUPPRESSION" to "N"
	And I update Property "POSITION_HIRE_LOCATION_REQUIRED" to "N"
	Then I close open tabs "child"
	And I clear the cache

	And I should see element "login page"
    When I log in to "autoqcs" New UI application with "valid" Credentials
    And I click on "button-NewUI" "Login" on "Login" Page
    And I click on "button-NewUI" "I Certify" on "notice" Page 
    When I click on "button-newui" "Pending" on "Dashboard" Page
	  
  	When I click on "button-newui" " Create Order " on "People" Page
	And I should see Text "Personal information"
	And I click on "button-newui" "Middle Name Yes" on "create person" Page
	And I enter "valid" value for "FN" textbox on "create person" Page NewUI
	And I enter "valid" value for "MN" textbox on "create person" Page NewUI
	And I enter "valid" value for "LN" textbox on "create person" Page NewUI
    And I enter "random" value for "email" textbox on "create person" Page NewUI
    And I enter "valid" value for "re-enter email" textbox on "create person" Page NewUI  
	And I enter "valid" value for "Country" textbox on "create person" Page NewUI     
    And I enter "valid" value for "City" textbox on "create person" Page NewUI 
    And I enter "valid" value for "State" textbox on "create person" Page NewUI     
    And I click on "button-newui" "Next" on "create person" Page   
     
	When Search table By "package" in "Package Selection" page
	And I click on "button-newui" "search" on "package selection" Page
	And I click on "radiobutton-newui" "first pkg" on "package selection" Page
	And I should see element "Package select checkbox" for "POW"
	And I should see element "Package Price Tag" for "POW"
	
	And I click on "button-NewUI" "Add to Cart" on "package selection" Page
	And I should see Text "Shopping cart"
	And I click on "button-NewUI" "Checkout" on "Shopping Cart" Page
	And wait for "2" Seconds
	Then I should see Text "Order complete!"
	
	Then I click on "button-newui" "Return to People Page" on "order submission" Page
	
	And I should see element "People"
	And Search table By "FN & LN" in "pow" page
 	And I click on "button-newui" "search" on "People" Page
 	And I should see element "by multi search"
	
	Then wait Until Profile Status is "Email Sent" for "PA flow"	
	Then I should see element "Profile ID"
	Then I should not see element "Background Tile"
	Then I should not see element "Screening Status"
	Then I should see element "Status" for "Compliance"
	Then I should see element "Compliance Status" for "Pending"
	And I click on "order status" "no hyperlink" on "People" Page
    And I should not see element "compliance hyperlink"
    
    Then Get the ProfileId from UI
    Then I open only a new tab
    Then I switch between tabs "child"
    
    And I navigate to "PAInviteLanuchUrl" application
    Then Wait until Element Present "Sign Up Page"
    And I fill details in PA "SignUp" page
    Then Wait until Element Present "Country Page"
    
    Then I switch between tabs "parent"
    Then wait Until Profile Status is "Registered" for "PA flow"

	Then I should see element "Profile ID"
	Then I should not see element "Background Tile"
	Then I should not see element "Screening Status"
	Then I should see element "Status" for "Compliance"
	Then I should see element "Compliance Status" for "Pending"
	And I click on "order status" "no hyperlink" on "People" Page
    And I should not see element "compliance hyperlink"
    
    Then I switch between tabs "child"
    And I navigate to "PAInviteLanuchUrl" application
 
    Then Wait until Element Present "Sign In Page"
    And I fill details in PA "SignIn" page
    
    Then Wait until Element Present "Country Page" 
    And I fill details in PA "Country" page

    Then Wait until Element Present "ESign Page"
    And I fill details in PA "ESign" page

    Then Wait until Element Present "Notice Page"
    And I fill details in PA "Notice-QC" page
    Then Wait until Element Present "Profile Page"

    Then I switch between tabs "parent"
    
    Then wait Until Profile Status is "Consent Accepted" for "PA flow"

	Then I should see element "Profile ID"
	Then I should not see element "Background Tile"
	Then I should not see element "Screening Status"
	Then I should see element "Status" for "Compliance"
	Then I should see element "Compliance Status" for "Pending"
	And I click on "order status" "no hyperlink" on "People" Page
    And I should not see element "compliance hyperlink"
    
    Then I switch between tabs "child"
    And I fill details in PA "Profile" page 

    Then Wait until Element Present "Residence Page"
    And I fill details in PA "Residence" page    
    
    Then Wait until Element Present "License Page"
    And I fill details in PA "License" page
    
    Then Wait until Element Present "Identity Page"
    And I fill details in PA "Identity" page
    
    Then Wait until Element Present "Criminal Page"
    And I fill details in PA "Criminal" page

    Then Wait until Element Present "AdditionalInfomartion Page"
    And I fill details in PA "AdditionalInfomartion" page

    Then Wait until Element Present "Review Page"
    And I fill details in PA "Review" page
    
    Then Wait until Element Present "DocumentUpload Page"
    And I fill details in PA "DocumentUpload" page
    
    Then Wait until Element Present "ProfileDashboard Page"
    Then I close open tabs "child"

    Then wait Until Profile Status is "Completed" for "PA flow"

	Then I should see Text "Completed"
	Then I should see element "Profile ID"
	Then I should see element "Background Tile"
	Then I should not see element "Screening Status"
	Then I should see element "Status" for "Compliance"
	Then I should see element "Compliance Status" for "Pending"
	And I click on "order status" "hyperlink" on "People" Page
    And I click on "button-newui" "continue" on "People" Page
    And I should see element "hyperlink"
    
    Then Click Logout NewUI
    And I close browser

########################People Search - Accordion with Profile Advantage/Screening Tiles Positive- US -3220 ####################
#@NewUI-PeopleOrderingWorkflow
@ToBeImplemented
@NewUIAccordionPA-Registered
Scenario: NewUI_SC17-Accordion with PA/ST-Registered
	Given I initialize Browser 
    And I am executing "NewUI_SC17-Accordion with PA/ST-Registered"
   
    Then I open only a new tab
	Then I switch between tabs "child"
	And I navigate to "Admin tool" application
	And I log in to admin tool select customer "QCSAAUTOVC" for "QCSA"
	And I update Property "PROGRAM_PAYMENT_METHOD" to "Vendor Invoice" 
	And I update Property "XTDFORCE_COMPLIANCE_SUPPRESSION" to "N"
	And I update Property "POSITION_HIRE_LOCATION_REQUIRED" to "N"
	Then I close open tabs "child"
	And I clear the cache
	And I should see element "login page"
    
    When I log in to "autoqcs" New UI application with "valid" Credentials
    And I click on "button-NewUI" "Login" on "Login" Page
    And I click on "button-NewUI" "I Certify" on "notice" Page 
    When I click on "button-newui" "Pending" on "Dashboard" Page
	  
  	When I click on "button-newui" " Create Order " on "People" Page
	And I should see Text "Personal information"
	And I click on "button-newui" "Middle Name Yes" on "create person" Page
	And I enter "valid" value for "FN" textbox on "create person" Page NewUI
	And I enter "valid" value for "MN" textbox on "create person" Page NewUI
	And I enter "valid" value for "LN" textbox on "create person" Page NewUI
    And I enter "random" value for "email" textbox on "create person" Page NewUI
    And I enter "valid" value for "re-enter email" textbox on "create person" Page NewUI  
	And I enter "valid" value for "Country" textbox on "create person" Page NewUI     
    And I enter "valid" value for "City" textbox on "create person" Page NewUI 
    And I enter "valid" value for "State" textbox on "create person" Page NewUI     
    And I click on "button-newui" "Next" on "create person" Page   
     
	When Search table By "package" in "Package Selection" page
	And I click on "button-newui" "search" on "package selection" Page
	And I click on "radiobutton-newui" "first pkg" on "package selection" Page
	And I should see element "Package select checkbox" for "POW"
	And I should see element "Package Price Tag" for "POW"
	
	And I click on "button-NewUI" "Add to Cart" on "package selection" Page
	And I should see Text "Shopping cart"
	And I click on "button-NewUI" "Checkout" on "Shopping Cart" Page
	And wait for "2" Seconds
	Then I should see Text "Order complete!"
  	Then I click on "button-newui" "Return to People Page" on "order submission" Page
	
	And I should see element "People"
	And Search table By "FN & LN" in "pow" page
 	And I click on "button-newui" "search" on "People" Page
 	And I should see element "by multi search"
	
	Then wait Until Profile Status is "Email Sent" for "PA flow"	
	Then I should see element "Profile ID"
	Then I should not see element "Background Tile"
	Then I should not see element "Screening Status"
	Then I should see element "Status" for "Compliance"
	Then I should see element "Compliance Status" for "Pending"
	And I click on "order status" "no hyperlink" on "People" Page
    And I should not see element "compliance hyperlink"

	Then Get the ProfileId from UI
    Then I open only a new tab
    Then I switch between tabs "child"
    
    And I navigate to "PAInviteLanuchUrl" application 
    Then Wait until Element Present "Sign Up Page"
    And I fill details in PA "SignUp" page
    Then Wait until Element Present "Country Page"
     
    Then I switch between tabs "parent"
    Then wait Until Profile Status is "Registered" for "PA flow"

	Then I should see element "Profile ID"
	Then I should not see element "Background Tile"
	Then I should not see element "Screening Status"
	Then I should see element "Status" for "Compliance"
	Then I should see element "Compliance Status" for "Pending"
	And I click on "order status" "no hyperlink" on "People" Page
    And I should not see element "compliance hyperlink"
    
    Then I switch between tabs "child"
    And I navigate to "PAInviteLanuchUrl" application
 
    Then Wait until Element Present "Sign In Page"
    And I fill details in PA "SignIn" page
    
    Then Wait until Element Present "Country Page" 
    And I fill details in PA "Country" page
           
    Then Wait until Element Present "ESign Page"
    And I fill details in PA "ESign" page

    Then Wait until Element Present "Notice Page"
    And I fill details in PA "Notice-QC" page
    Then Wait until Element Present "Profile Page"

    Then I switch between tabs "parent"
    
    Then wait Until Profile Status is "Consent Rejected" for "PA flow"

	Then I should see element "Profile ID"
	Then I should not see element "Background Tile"
	Then I should not see element "Screening Status"
	Then I should see element "Status" for "Compliance"
	Then I should see element "Compliance Status" for "Pending"
	And I click on "order status" "no hyperlink" on "People" Page
    And I should not see element "compliance hyperlink"
    
    Then Click Logout NewUI
    And I close browser
