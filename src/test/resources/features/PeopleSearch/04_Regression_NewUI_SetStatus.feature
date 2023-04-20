Feature: Regression NewUI People Search - Set Status
    
#*****************************************************************************************************************************************

###################### People Search (Take Actions) - 1978 ######################     
@NewUI-PeopleSearch
@NewUI-US-1978 
Scenario: NewUI_SC06-People SetStatus    
    Given I initialize Browser 
    And I am executing "NewUI_SC06-People SetStatus" 
    And I navigate to "NewUI" application 
    And I should see element "login page"

    When I log in to "autoqcs" New UI application with "valid" Credentials 
    And I click on "button-newui" "Login" on "Login" Page 
    And I click on "button-newui" "I Certify" on "NOTICE" Page 
    And I click on "MenuButton-NewUI" "People" on "HOME" Page
    And I should see Text "People"
        
    And I should see element "Active" for "filter pill"
	Then I should not see "People" column "Person Status" value "Inactive" on "NewUI" Page
	Then I should not see "People" column "Person Status" value "Terminated" on "NewUI" Page
	
	When I get details of "Person" from UI
	
	When I Execute "Validate Active Person Record is updated to Inactive."
	And Search table By "FN & LN & SSN" in "People" page
 	And I click on "button-newui" "search" on "People" Page
    When I click on "checkbox" "first" on "People" Page
    And I should see element "Active" for "disabled"
    And I click on "button-newui" "Inactive" on "People" Page
	
	And Search table By "FN & LN & SSN" in "People" page
 	And I click on "button-newui" "search" on "People" Page
 	Then I should see Text "No Results Found"
 	
 	And I click on "button-newui" "filter" on "People" Page
 	And I click on "checkbox" "filter Active" on "People" Page
 	And I click on "checkbox" "filter Inactive" on "People" Page
 	And I click on "button-newui" "filter complete" on "People" Page
 	
 	And Search table By "FN & LN & SSN" in "People" page
 	And I click on "button-newui" "search" on "People" Page
 	Then I should see element "Inactive" for "searched person"

 	And Refresh The Page
 	
 	When I Execute "Validate Inactive Person Record is updated to Terminated."
 	And I should see element "Active" for "filter pill"
 	Then I should not see "People" column "Person Status" value "Inactive" on "NewUI" Page
	Then I should not see "People" column "Person Status" value "Terminated" on "NewUI" Page
	
	And I click on "button-newui" "filter" on "People" Page
 	And I click on "checkbox" "filter Active" on "People" Page
 	And I click on "checkbox" "filter Inactive" on "People" Page
 	And I click on "button-newui" "filter complete" on "People" Page
	
	And Search table By "FN & LN & SSN" in "People" page
 	And I click on "button-newui" "search" on "People" Page
 	When I click on "checkbox" "first" on "People" Page
 	And I should see element "Inactive" for "disabled"
 	And I click on "button-newui" "Terminated" on "People" Page
	
	And Search table By "FN & LN & SSN" in "People" page
 	And I click on "button-newui" "search" on "People" Page
 	Then I should see Text "No Results Found"
 	
 	And I click on "button-newui" "filter" on "People" Page
 	And I click on "checkbox" "filter Inactive" on "People" Page
 	And I click on "checkbox" "filter Terminated" on "People" Page
 	And I click on "button-newui" "filter complete" on "People" Page
 	
 	And Search table By "FN & LN & SSN" in "People" page
 	And I click on "button-newui" "search" on "People" Page
 	Then I should see element "Terminated" for "searched person"

 	And Refresh The Page
 	
 	When I Execute "Validate Terminated Person Record is updated to Active."
 	And I should see element "Active" for "filter pill"
	Then I should not see "People" column "Person Status" value "Inactive" on "NewUI" Page
	Then I should not see "People" column "Person Status" value "Terminated" on "NewUI" Page
		
	And I click on "button-newui" "filter" on "People" Page
 	And I click on "checkbox" "filter Active" on "People" Page
 	And I click on "checkbox" "filter Terminated" on "People" Page
 	And I click on "button-newui" "filter complete" on "People" Page
 	
	And Search table By "FN & LN & SSN" in "People" page
 	And I click on "button-newui" "search" on "People" Page
 	When I click on "checkbox" "first" on "People" Page
 	And I should see element "Terminated" for "disabled"
 	And I click on "button-newui" "Active" on "People" Page
 	
 	And Search table By "FN & LN & SSN" in "People" page
 	And I click on "button-newui" "search" on "People" Page
 	Then I should see Text "No Results Found"
 	
 	And I click on "button-newui" "filter" on "People" Page
 	And I click on "checkbox" "filter Terminated" on "People" Page
 	And I click on "checkbox" "filter Active" on "People" Page
 	And I click on "button-newui" "filter complete" on "People" Page
 	
 	And Search table By "FN & LN & SSN" in "People" page
 	And I click on "button-newui" "search" on "People" Page
 	Then I should see element "Active" for "searched person"

 	And Refresh The Page
 	
 	When I Execute "Validate Active Person Record is updated to Terminated."
 	And I should see element "Active" for "filter pill"
	Then I should not see "People" column "Person Status" value "Inactive" on "NewUI" Page
	Then I should not see "People" column "Person Status" value "Terminated" on "NewUI" Page
		
	And Search table By "FN & LN & SSN" in "People" page
 	And I click on "button-newui" "search" on "People" Page
 	When I click on "checkbox" "first" on "People" Page
 	And I should see element "Active" for "disabled"
 	And I click on "button-newui" "Terminated" on "People" Page
 	
 	And Search table By "FN & LN & SSN" in "People" page
 	And I click on "button-newui" "search" on "People" Page
 	Then I should see Text "No Results Found"
 	
 	And I click on "button-newui" "filter" on "People" Page
 	And I click on "checkbox" "filter Active" on "People" Page
 	And I click on "checkbox" "filter Terminated" on "People" Page
 	And I click on "button-newui" "filter complete" on "People" Page
 	
 	And Search table By "FN & LN & SSN" in "People" page
 	And I click on "button-newui" "search" on "People" Page
 	Then I should see element "Terminated" for "searched person"
 	
 	And Refresh The Page
 	
 	When I Execute "Validate Terminated Person Record is updated to Inactive."
 	And I should see element "Active" for "filter pill"
	Then I should not see "People" column "Person Status" value "Inactive" on "NewUI" Page
	Then I should not see "People" column "Person Status" value "Terminated" on "NewUI" Page
		
	And I click on "button-newui" "filter" on "People" Page
 	And I click on "checkbox" "filter Active" on "People" Page
 	And I click on "checkbox" "filter Terminated" on "People" Page
 	And I click on "button-newui" "filter complete" on "People" Page
 	
	And Search table By "FN & LN & SSN" in "People" page
 	And I click on "button-newui" "search" on "People" Page
 	When I click on "checkbox" "first" on "People" Page
 	And I should see element "Terminated" for "disabled"
 	And I click on "button-newui" "Inactive" on "People" Page
 	
 	And Search table By "FN & LN & SSN" in "People" page
 	And I click on "button-newui" "search" on "People" Page
 	Then I should see Text "No Results Found"
 	
 	And I click on "button-newui" "filter" on "People" Page
 	And I click on "checkbox" "filter Terminated" on "People" Page
 	And I click on "checkbox" "filter Inactive" on "People" Page
 	And I click on "button-newui" "filter complete" on "People" Page
 	
 	And Search table By "FN & LN & SSN" in "People" page
 	And I click on "button-newui" "search" on "People" Page
 	Then I should see element "Inactive" for "searched person"
 	
 	And Refresh The Page
 	
 	When I Execute "Validate Inactive Person Record is updated to Active."
 	And I should see element "Active" for "filter pill"
	Then I should not see "People" column "Person Status" value "Inactive" on "NewUI" Page
	Then I should not see "People" column "Person Status" value "Terminated" on "NewUI" Page
		
	And I click on "button-newui" "filter" on "People" Page
 	And I click on "checkbox" "filter Active" on "People" Page
 	And I click on "checkbox" "filter Inactive" on "People" Page
 	And I click on "button-newui" "filter complete" on "People" Page
 	
	And Search table By "FN & LN & SSN" in "People" page
 	And I click on "button-newui" "search" on "People" Page
 	When I click on "checkbox" "first" on "People" Page
 	And I should see element "Inactive" for "disabled"
 	And I click on "button-newui" "Active" on "People" Page
 	
 	And Search table By "FN & LN & SSN" in "People" page
 	And I click on "button-newui" "search" on "People" Page
 	Then I should see Text "No Results Found"
 	
 	And I click on "button-newui" "filter" on "People" Page
 	And I click on "checkbox" "filter Inactive" on "People" Page
 	And I click on "checkbox" "filter Active" on "People" Page
 	And I click on "button-newui" "filter complete" on "People" Page
 	
 	And Search table By "FN & LN & SSN" in "People" page
 	And I click on "button-newui" "search" on "People" Page
 	Then I should see element "Active" for "searched person"
 	
	And Click Logout NewUI
	And I close browser