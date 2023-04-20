#@NewUIProgramOwnerWorkflow
Feature: Program Owner Workflow -People Search/Accordion
#*****************************************************************************************************************************************
######################NewUI Program Owner Workflow -Validate User is given the default query of Active Individuals within the Program######################
#@ProgramOwnerWorkflow @41877 @TC43558
Scenario: NewUI_ProgramOwnerWorkflowPeopleSearchAccordion-DefaultFilter
  Given I initialize Browser
  And I am executing "NewUI_ProgramOwnerWorkflowPeopleSearchAccordion-DefaultFilter"
  And I navigate to "NewUI" application
  And I should see element "login page"
  When I log in to "automation sponsor" New UI application with "valid" Credentials
  And I click on "button-newui" "Login" on "Login" Page
  And I click on "button-newui" "I Certify" on "NOTICE" Page
  When I should see "menubutton-newui" named as "People" on "HOME" Page
  And I click on "MenuButton-NewUI" "People" on "HOME" Page
  And I should see element "People"
  And I should see element "Active" for "filter pill"
  And I click on "button-newui" "filter" on "People" Page
  And I should see element "Active" for "checkbox checked"
  And I should not see element "Inactive" for "filter pill"
  And I should not see element "Terminated" for "filter pill"
  And I should not see element "Inactive" for "checkbox checked"
  And I should not see element "Terminated" for "checkbox checked"
  And I should see element "Active" for "person status accordion search" for Program Owner
  And I close browser
######################NewUI Program Owner Workflow -Validate User is able to search via First Name, Last Name and/or SSN######################
 # @ProgramOwnerWorkflow @41877 @TC43326
  Scenario: NewUI_ProgramOwnerWorkflowPeopleSearchAccordion-FnLnSSNSearch
    Given I initialize Browser
    And I am executing "NewUI_ProgramOwnerWorkflowPeopleSearchAccordion-FnLnSSNSearch"
    And I navigate to "NewUI" application
    And I should see element "login page"
    When I log in to "automation sponsor" New UI application with "valid" Credentials
    And I click on "button-newui" "Login" on "Login" Page
    And I click on "button-newui" "I Certify" on "NOTICE" Page
    When I should see "menubutton-newui" named as "People" on "HOME" Page
    And I click on "MenuButton-NewUI" "People" on "HOME" Page
    And I should see element "People"
    And I should see element "Active" for "filter pill"
    And I choose a random user to search
    When Search table By "FN & LN & SSN" in "People" page
    And I click on "button-newui" "search" on "People" Page
    And I validate "FN,LN,SSN" search results for Program Owner
    And I close browser
######################NewUI Program Owner Workflow -Validate User can change status on any individuals within the program######################
 # @ProgramOwnerWorkflow @41877 @TC43333
  Scenario: NewUI_ProgramOwnerWorkflowPeopleSearchAccordion-ActionButton
    Given I initialize Browser
    And I am executing "NewUI_ProgramOwnerWorkflowPeopleSearchAccordion-ActionButton"
    And I navigate to "NewUI" application
    And I should see element "login page"
    When I log in to "automation sponsor" New UI application with "valid" Credentials
    And I click on "button-newui" "Login" on "Login" Page
    And I click on "button-newui" "I Certify" on "NOTICE" Page
    When I should see "menubutton-newui" named as "People" on "HOME" Page
    And I click on "MenuButton-NewUI" "People" on "HOME" Page
    And I should see element "People"
    And I should see element "Active" for "filter pill"
    And I click on "Active" filter pill on People Page
    And I search for "Nenad Bjelica"
    When Search table By "FN & LN" in "People" page
    And I click on "button-newui" "search" on "People" Page
    And I should see element "Active" for "person status accordion search" for People
    And I verify Action Button and change the user status to "Inactive"
    When Search table By "FN & LN" in "People" page
    And I click on "button-newui" "search" on "People" Page
    And I should see element "Inactive" for "person status accordion search" for People
    And I verify Action Button and change the user status to "Terminated"
    When Search table By "FN & LN" in "People" page
    And I click on "button-newui" "search" on "People" Page
    And I should see element "Terminated" for "person status accordion search" for People
    And I verify Action Button and change the user status to "Active"
    When Search table By "FN & LN" in "People" page
    And I click on "button-newui" "search" on "People" Page
    And I should see element "Active" for "person status accordion search" for People
    And I close browser
######################NewUI Program Owner Workflow -Validate User is able to access Accordion######################
 # @ProgramOwnerWorkflow @41877 @TC43555
  Scenario: NewUI_ProgramOwnerWorkflowPeopleSearchAccordion-Accordion
    Given I initialize Browser
    And I am executing "NewUI_ProgramOwnerWorkflowPeopleSearchAccordion-Accordion"
    And I navigate to "NewUI" application
    And I should see element "login page"
    When I log in to "qcsavc sponsor" New UI application with "valid" Credentials
    And I click on "button-newui" "Login" on "Login" Page
    And I click on "button-newui" "I Certify" on "NOTICE" Page
    When I should see "menubutton-newui" named as "People" on "HOME" Page
    And I click on "MenuButton-NewUI" "People" on "HOME" Page
    And I should see element "People"
    And I should see element "Active" for "filter pill"
    And I should see valid tile cards in accordion
    And I close browser
 ######################NewUI Program Owner Workflow -Validate User is see output grid of Name, Compliance Status, SSN, Order Date, Completed Date & Person Status######################
  #@ProgramOwnerWorkflow @41877 @TC43361 @ProgramOwnerWorkflowCompliance
  Scenario: NewUI_ProgramOwnerWorkflowPeopleSearchAccordion-ComplianceStatus
    Given I initialize Browser
    And I am executing "NewUI_ProgramOwnerWorkflowPeopleSearchAccordion-ComplianceStatus"
    And I navigate to "NewUI" application
    Then I open only a new tab
    Then I switch between tabs "child"
    And I navigate to "Admin tool" application
    And I log in to admin tool select customer "XTDAUTOQCSA" for "QCSA"
    And I update Property "XTDFORCE_REGISTRATION_UI" to "Y"
    And I update Property "XTDFORCE_COMPLIANCE_SUPPRESSION" to "N"
    And I update Property "XTDFORCE_API_PROGRAM" to "null"
    Then I switch between tabs "parent"
    And I should see element "login page"
    When I log in to "automation sponsor" New UI application with "valid" Credentials
    And I click on "button-newui" "Login" on "Login" Page
    And I click on "button-newui" "I Certify" on "NOTICE" Page
    When I should see "menubutton-newui" named as "People" on "HOME" Page
    And I click on "MenuButton-NewUI" "People" on "HOME" Page
    And I should see element "Active" for "filter pill"
    And I click on "button-newui" "filter" on "People" Page
    And I should see element "Active" for "checkbox checked"
    And I should see element "Active" for "person status accordion search" for Program Owner
#	default filter, active
    And I click on "button-newui" "ActiveCheck" on "People" Page
    And I click on "button-newui" "InactiveCheck" on "People" Page
    And I click on "button-newui" "filter complete" on "People" Page
    And I should see element "Inactive" for "filter pill"
    And I should see element "Inactive" for "checkbox checked"
    And I should see element "Inactive" for "person status accordion search" for Program Owner
    #	inactive
    And I click on "button-newui" "filter" on "People" Page
    And I click on "button-newui" "InactiveCheck" on "People" Page
    And I click on "button-newui" "TerminatedCheck" on "People" Page
    And I click on "button-newui" "filter complete" on "People" Page
    And I should see element "Terminated" for "filter pill"
    And I should see element "Terminated" for "checkbox checked"
    And I should see element "Terminated" for "person status accordion search" for Program Owner
#	terminated
    And I click on "button-newui" "filter" on "People" Page
    And I click on "button-newui" "CompliantCheck" on "People" Page
    And I click on "button-newui" "TerminatedCheck" on "People" Page
    And I click on "button-newui" "filter complete" on "People" Page
    And I should see element "Compliant" for "filter pill"
    And I should see element "Compliant" for "compliance accordion search" for Program Owner
#	compliant
    And I click on "button-newui" "filter" on "People" Page
    And I click on "button-newui" "CompliantCheck" on "People" Page
    And I click on "button-newui" "NonCompliantCheck" on "People" Page
    And I click on "button-newui" "filter complete" on "People" Page
    And I should see element "Non-Compliant" for "filter pill"
    And I should see element "Non-Compliant" for "compliance accordion search" for Program Owner
#	non-compliant
    And I click on "button-newui" "filter" on "People" Page
    And I click on "button-newui" "NonCompliantCheck" on "People" Page
    And I click on "button-newui" "PendingCheck" on "People" Page
    And I click on "button-newui" "filter complete" on "People" Page
    And I should see element "Pending" for "filter pill"
    And I should see element "Pending" for "compliance accordion search" for Program Owner
#	pending
    And I click on "button-newui" "filter" on "People" Page
    And I click on "button-newui" "ActiveCheck" on "People" Page
    And I click on "button-newui" "InactiveCheck" on "People" Page
    And I click on "button-newui" "TerminatedCheck" on "People" Page
    And I click on "button-newui" "NonCompliantCheck" on "People" Page
    And I click on "button-newui" "CompliantCheck" on "People" Page
    And I click on "button-newui" "PendingCheck" on "People" Page
    And I click on "button-newui" "filter complete" on "People" Page
    And I should see element "Active,Inactive,Terminated" "Compliant,Non-Compliant,Pending" for "person status and compliance accordion search" for Program Owner
	#every status
    And I click on "button-newui" "filter" on "People" Page
    And I click on "button-newui" "Date range picker" on "People" Page
    And I select Date "from" "August 1 2021"
    And I select Date "to" "September 30 2021"
    And I click on "button-newui" "filter complete" on "People" Page
    And I should see element "date accordion search" for People
	#date accordion search
    And I click on "button-newui" "filter" on "People" Page
    And I click on "button-newui" "Completion Date range picker" on "People" Page
    And I select Date "from completion" "August 1 2021"
    And I select Date "to completion" "September 30 2021"
    And I click on "button-newui" "filter complete" on "People" Page
    And I should see element "completion date accordion search" for People
 	#completion date accordion search
    And I close browser
######################NewUI Program Owner Workflow -Validate User is see output grid of Name, Screening Status, SSN, Order Date, Completed Date & Person Status######################
 # @ProgramOwnerWorkflow @41877 @TC43551
  Scenario: NewUI_ProgramOwnerWorkflowPeopleSearchAccordion-ScreeningStatus
    Given I initialize Browser
    And I am executing "NewUI_ProgramOwnerWorkflowPeopleSearchAccordion-ScreeningStatus"
    And I navigate to "NewUI" application
    Then I open only a new tab
    Then I switch between tabs "child"
    And I navigate to "Admin tool" application
    And I log in to admin tool select customer "XTDAUTOQCSA" for "QCSA"
    And I update Property "XTDFORCE_REGISTRATION_UI" to "Y"
    And I update Property "XTDFORCE_COMPLIANCE_SUPPRESSION" to "Y"
    And I update Property "XTDFORCE_API_PROGRAM" to "null"
    Then I switch between tabs "parent"
    And I should see element "login page"
    When I log in to "automation sponsor" New UI application with "valid" Credentials
    And I click on "button-newui" "Login" on "Login" Page
    And I click on "button-newui" "I Certify" on "NOTICE" Page
    When I should see "menubutton-newui" named as "People" on "HOME" Page
    And I click on "MenuButton-NewUI" "People" on "HOME" Page
    And I should see element "Active" for "filter pill"
    And I click on "button-newui" "filter" on "People" Page
    And I should see element "Active" for "checkbox checked"
    And I should see element "Active" for "person status accordion search" for Program Owner
	#default filter, active
    And I click on "button-newui" "ActiveCheck" on "People" Page
    And I click on "button-newui" "InactiveCheck" on "People" Page
    And I click on "button-newui" "filter complete" on "People" Page
    And I should see element "Inactive" for "filter pill"
    And I should see element "Inactive" for "checkbox checked"
    And I should see element "Inactive" for "person status accordion search" for Program Owner
#	inactive
    And I click on "button-newui" "filter" on "People" Page
    And I click on "button-newui" "InactiveCheck" on "People" Page
    And I click on "button-newui" "TerminatedCheck" on "People" Page
    And I click on "button-newui" "filter complete" on "People" Page
    And I should see element "Terminated" for "filter pill"
    And I should see element "Terminated" for "checkbox checked"
    And I should see element "Terminated" for "person status accordion search" for Program Owner
#	terminated
    And I click on "button-newui" "filter" on "People" Page
    And I click on "button-newui" "TerminatedCheck" on "People" Page
    And I click on "button-newui" "CompletedCheck" on "People" Page
    And I click on "button-newui" "filter complete" on "People" Page
    And I should see element "Completed" for "filter pill"
    And I should see element "Completed" for "screening accordion search" for People
	#Completed
    And I click on "button-newui" "filter" on "People" Page
    And I click on "button-newui" "CompletedCheck" on "People" Page
        
    And I click on "button-newui" "filter complete" on "People" Page
    And I should see element "Pending" for "filter pill"
    And I should see element "Pending" for "screening accordion search" for People
#	Pending
    And I click on "button-newui" "filter" on "People" Page
    And I click on "button-newui" "ActiveCheck" on "People" Page
    And I click on "button-newui" "InactiveCheck" on "People" Page
    And I click on "button-newui" "TerminatedCheck" on "People" Page
    And I click on "button-newui" "CompletedCheck" on "People" Page
    And I click on "button-newui" "filter complete" on "People" Page
    And I should see element "Active,Inactive,Terminated" "Completed,Pending" for "person status and screening accordion search" for Program Owner
	#every status
    And I click on "button-newui" "filter" on "People" Page
    And I click on "button-newui" "Date range picker" on "People" Page
    And I select Date "from" "August 1 2021"
    And I select Date "to" "September 30 2021"
    And I click on "button-newui" "filter complete" on "People" Page
    And I should see element "date accordion search" for People
	#date accordion search
    And I click on "button-newui" "filter" on "People" Page
    And I click on "button-newui" "Completion Date range picker" on "People" Page
    And I select Date "from completion" "August 1 2021"
    And I select Date "to completion" "September 30 2021"
    And I click on "button-newui" "filter complete" on "People" Page
    And I should see element "completion date accordion search" for People
 	#completion date accordion search
    And I close browser