Feature: Sanity_NewUI_Filtering

 ######################Sanity_NewUI_Filtering######################
  @NewUI @Sanity_NewUI_Filtering
  Scenario: Sanity_NewUI_Filtering
    Given I initialize Browser
    And I am executing "Sanity_NewUI_Filtering"
    And I navigate to "NewUI" application
    Then I open only a new tab
    Then I switch between tabs "child"
    And I navigate to "Admin tool" application
    And I log in to admin tool select customer "XTDAUTOQCSA" for "QCSA"
    And I update Property "XTDFORCE_REGISTRATION_UI" to "Y"
    And I update Property "XTDFORCE_COMPLIANCE_SUPPRESSION" to "N"
    And I update Property "VENDOR_REGISTRATION_WORKFLOW_ENABLED" to "Vendor"
    And I update Property "PROGRAM_PAYMENT_METHOD" to "Vendor Invoice"
    And I update Property "XTDFORCE_API_PROGRAM" to "null"
    Then I switch between tabs "parent"
    And I should see element "login page"
    When I log in to "automation" New UI application with "valid" Credentials
    And I click on "button-newui" "Login" on "Login" Page
    And I click on "button-newui" "I Certify" on "NOTICE" Page
    When I click on "menubutton-newui" "Dashboard" on "HOME" Page
    When I should see "menubutton-newui" named as "Dashboard" on "HOME" Page
    And I should see Text "Needs Review"
    And I should see Text "Non-Compliant"
    And I should see Text "Pending"
    When I click on "button-newui" "Pending" on "Dashboard" Page
    And I should see element "Pending" for "link url"
    And I should see element "People"
    And I should see element "Active" for "filter pill"
    And I click on "button-newui" "filter" on "People" Page
    And I should see element "Active" for "checkbox checked"
    And I should see element "Active" for "person status accordion search"
	#default filter
    And I click on "button-newui" "PendingCheck" on "People" Page
    And I click on "button-newui" "InactiveCheck" on "People" Page
    And I click on "button-newui" "TerminatedCheck" on "People" Page
    And I click on "button-newui" "filter complete" on "People" Page
    And I should see element "Active,Inactive,Terminated" for "person status accordion search" for People
	#active,inactive terminated
    And I click on "button-newui" "filter" on "People" Page
    And I click on "button-newui" "CompliantCheck" on "People" Page
    And I click on "button-newui" "filter complete" on "People" Page
    And I should see element "Active,Inactive,Terminated" "Compliant" for "person status and compliance accordion search" for People
	#active,inactive,terminated and compliant
    And I click on "button-newui" "filter" on "People" Page
    And I click on "button-newui" "CompliantCheck" on "People" Page
    And I click on "button-newui" "NonCompliantCheck" on "People" Page
    And I click on "button-newui" "filter complete" on "People" Page
    And I should see element "Active,Inactive,Terminated" "Non-Compliant" for "person status and compliance accordion search" for People
	#active,inactive,terminated and non-compliant
    And I click on "button-newui" "filter" on "People" Page
    And I click on "button-newui" "NonCompliantCheck" on "People" Page
    And I click on "button-newui" "PendingCheck" on "People" Page
    And I click on "button-newui" "filter complete" on "People" Page
    And I should see element "Active,Inactive,Terminated" "Pending" for "person status and compliance accordion search" for People
	#active,inactive,terminated and pending
    And I click on "button-newui" "filter" on "People" Page
    And I click on "button-newui" "PendingCheck" on "People" Page
    And I click on "button-newui" "CompliantCheck" on "People" Page
    And I click on "button-newui" "InactiveCheck" on "People" Page
    And I click on "button-newui" "TerminatedCheck" on "People" Page
    And I click on "button-newui" "filter complete" on "People" Page
    And I should see element "Active" "Compliant" for "person status and compliance accordion search" for People
	#active and compliant
    And I click on "button-newui" "filter" on "People" Page
    And I click on "button-newui" "CompliantCheck" on "People" Page
    And I click on "button-newui" "NonCompliantCheck" on "People" Page
    And I click on "button-newui" "filter complete" on "People" Page
    And I should see element "Active" "Non-Compliant" for "person status and compliance accordion search" for People
	#active and non-compliant
    And I click on "button-newui" "filter" on "People" Page
    And I click on "button-newui" "NonCompliantCheck" on "People" Page
    And I click on "button-newui" "PendingCheck" on "People" Page
    And I click on "button-newui" "filter complete" on "People" Page
    And I should see element "Active" "Pending" for "person status and compliance accordion search" for People
	#active and pending
    And I click on "button-newui" "filter" on "People" Page
    And I click on "button-newui" "PendingCheck" on "People" Page
    And I click on "button-newui" "ActiveCheck" on "People" Page
    And I click on "button-newui" "InactiveCheck" on "People" Page
    And I click on "button-newui" "CompliantCheck" on "People" Page
    And I click on "button-newui" "filter complete" on "People" Page
    And I should see element "Inactive" "Compliant" for "person status and compliance accordion search" for People
	#inactive compliant
    And I click on "button-newui" "filter" on "People" Page
    And I click on "button-newui" "CompliantCheck" on "People" Page
    And I click on "button-newui" "NonCompliantCheck" on "People" Page
    And I click on "button-newui" "filter complete" on "People" Page
    And I should see element "Inactive" "Non-Compliant" for "person status and compliance accordion search" for People
	#inactive non-compliant
    And I click on "button-newui" "filter" on "People" Page
    And I click on "button-newui" "NonCompliantCheck" on "People" Page
    And I click on "button-newui" "PendingCheck" on "People" Page
    And I click on "button-newui" "filter complete" on "People" Page
    And I should see element "Inactive" "Pending" for "person status and compliance accordion search" for People
	#inactive pending
    And I click on "button-newui" "filter" on "People" Page
    And I click on "button-newui" "PendingCheck" on "People" Page
    And I click on "button-newui" "InactiveCheck" on "People" Page
    And I click on "button-newui" "TerminatedCheck" on "People" Page
    And I click on "button-newui" "CompliantCheck" on "People" Page
    And I click on "button-newui" "filter complete" on "People" Page
    And I should see element "Terminated" "Compliant" for "person status and compliance accordion search" for People
	#terminated compliant
    And I click on "button-newui" "filter" on "People" Page
    And I click on "button-newui" "CompliantCheck" on "People" Page
    And I click on "button-newui" "NonCompliantCheck" on "People" Page
    And I click on "button-newui" "filter complete" on "People" Page
    And I should see element "Terminated" "Non-Compliant" for "person status and compliance accordion search" for People
	#terminated non-compliant
    And I click on "button-newui" "filter" on "People" Page
    And I click on "button-newui" "NonCompliantCheck" on "People" Page
    And I click on "button-newui" "PendingCheck" on "People" Page
    And I click on "button-newui" "filter complete" on "People" Page
    And I should see element "Inactive" "Pending" for "person status and compliance accordion search" for People
	#terminated pending
    And I click on "button-newui" "filter" on "People" Page
    And I click on "button-newui" "ActiveCheck" on "People" Page
    And I click on "button-newui" "InactiveCheck" on "People" Page
    And I click on "button-newui" "NonCompliantCheck" on "People" Page
    And I click on "button-newui" "CompliantCheck" on "People" Page
    And I click on "button-newui" "filter complete" on "People" Page
    And I should see element "Active,Inactive,Terminated" "Compliant,Non-Compliant,Pending" for "person status and compliance accordion search" for People
	#every status
    And I click on "button-newui" "filter" on "People" Page
    And I click on "button-newui" "ActiveCheck" on "People" Page
    And I click on "button-newui" "InactiveCheck" on "People" Page
    And I click on "button-newui" "TerminatedCheck" on "People" Page
    And I click on "button-newui" "NonCompliantCheck" on "People" Page
    And I click on "button-newui" "CompliantCheck" on "People" Page
    And I click on "button-newui" "PendingCheck" on "People" Page
    And I click on "button-newui" "filter complete" on "People" Page
	#remove statuses (može i u jednoj metodi, ako treba)
    And I click on "button-newui" "filter" on "People" Page
    And I click on "button-newui" "Completion Date range picker" on "People" Page
    And I select Date "from" "August 1 2021"
    And I select Date "to" "September 30 2021"
    And I click on "button-newui" "filter complete" on "People" Page
    And I should see element "date accordion search"
	#date accordion search
    And I click on "button-newui" "filter" on "People" Page
    And I click on "button-newui" "Completion Date range picker" on "People" Page
    And I select Date "from completion" "August 1 2021"
    And I select Date "to completion" "September 30 2021"
    And I click on "button-newui" "filter complete" on "People" Page
    And I should see element "date accordion search"
 	#completion date accordion search
    And I click on "button-newui" "filter" on "People" Page
    And I click on "button-newui" "ActiveCheck" on "People" Page
    And I click on "button-newui" "InactiveCheck" on "People" Page
    And I click on "button-newui" "TerminatedCheck" on "People" Page
    And I click on "button-newui" "NonCompliantCheck" on "People" Page
    And I click on "button-newui" "CompliantCheck" on "People" Page
    And I click on "button-newui" "PendingCheck" on "People" Page
    And I click on "button-newui" "date range picker" on "People" Page
    And I select Date "from" "August 1 2021"
    And I select Date "to" "September 30 2021"
    And I click on "button-newui" "Completion Date range picker" on "People" Page
    And I select Date "from completion" "August 1 2021"
    And I select Date "to completion" "September 30 2021"
    And I click on "button-newui" "filter complete" on "People" Page
    And I search for "Fadv Test 503191234"
    # And I should see element "by multi search"
    And I should see element "Active,Inactive,Terminated" "Compliant,Non-Compliant,Pending" for "person status compliance order date completion date accordion search" for People
    When Search table By "FN & LN & SSN" in "People" page
    And I click on "button-newui" "search" on "People" Page
    #all statuses, date range picker, completion date range picker
    And I close browser