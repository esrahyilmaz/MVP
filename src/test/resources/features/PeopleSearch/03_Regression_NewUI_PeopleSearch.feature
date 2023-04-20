Feature: Regression NewUI People Search
    
#*****************************************************************************************************************************************

###################### People Search (Output) - 1979 ######################     
@NewUI-PeopleSearch 
@NewUI-US-1979 
Scenario: NewUI_SC05-People Search
	Given I initialize Browser 
    And I am executing "NewUI_SC05-People Search" 
    And I navigate to "NewUI" application 
    And I should see element "login page" 
    
    When I log in to "autoqcs" New UI application with "valid" Credentials 
    And I click on "button-newui" "Login" on "Login" Page 
    And I click on "button-newui" "I Certify" on "NOTICE" Page 
   	When I should see "menubutton-newui" named as "People" on "HOME" Page
   	And I click on "MenuButton-NewUI" "People" on "HOME" Page
    And I should see element "People"
    	
	Then I should see the sponsor logo in the header "VendorLogo"
    And I should see Customer support "number" in the header
    And I should see Customer support "email" in the header
    Then I should click "SupportLink" in the footer
    And I should click "FactActLink" in the footer
    And I should click "LegalLink" in the footer
    And I should click "PrivacyPolice" in the footer
    And I should see "FadvTrademark" in the footer of the page
        
    #And Save search reslut state "before"
    And I "refresh" page
    And I click on "button-newui" "search" on "People" Page
    #And Save search reslut state "after"
    #And Compare search result state 
    
    And I click on "button-newui" "search" on "People" Page
    When I get details of "Person" from UI
	
	And I should see element "search"
	And I should see "textbox" named as "First Name" on "People" Page
    And Search table By "FN" in "People" page
    And I click on "button-newui" "search" on "People" Page
    Then I should see element "by search"
    And Refresh The Page
    
    And I should see "textbox" named as "Last Name" on "People" Page
    When Search table By "LN" in "People" page
    And I click on "button-newui" "search" on "People" Page
    Then I should see element "by search"
    And Refresh The Page
    
    And I should see "textbox" named as "Social Security Number" on "People" Page
    When Search table By "SSN" in "People" page
    And I click on "button-newui" "search" on "People" Page
    Then I should see element "by search"
    And Refresh The Page
	
	When Search table By "FN & LN" in "People" page
    And I click on "button-newui" "search" on "People" Page
    And I should see element "by multi search"
    And Refresh The Page
		 
    When Search table By "FN & SSN" in "People" page
    And I click on "button-newui" "search" on "People" Page
    And I should see element "by multi search"
    And Refresh The Page
    	
	When Search table By "LN & SSN" in "People" page
    And I click on "button-newui" "search" on "People" Page
    And I should see element "by multi search"
    And Refresh The Page
	
    When Search table By "FN & LN & SSN" in "People" page
    And I click on "button-newui" "search" on "People" Page
    And I should see element "by multi search"
    
    
    And Refresh The Page
	
	When Search table By "invalid search" in "People" page
    And I click on "button-newui" "search" on "People" Page
    Then I should see Text "No Results Found"
	   
    And I close browser
 