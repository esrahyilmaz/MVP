Feature: Regression NewUI People Search - Filtering 
    
#*****************************************************************************************************************************************
######################NewUI People Search -Apply Default Filter######################
  #@NewUI-PeopleSearch
  @NewUI-PS-Fltering
  @NewUI-US-18543
  @ApplyDefaultFilter
  Scenario: NewUI_SC07-People Search-Filtering-ApplyDefaultFilter
    Given I initialize Browser
    And I am executing "NewUI_SC07-People Search-Filtering-ApplyDefaultFilter"
    And I navigate to "NewUI" application
    And I should see element "login page"
    When I log in to "autoqcs" New UI application with "valid" Credentials
    And I click on "button-newui" "Login" on "Login" Page
    And I click on "button-newui" "I Certify" on "NOTICE" Page
    When I should see "menubutton-newui" named as "People" on "HOME" Page
    And I click on "MenuButton-NewUI" "People" on "HOME" Page
    And I should see element "People"
    And I should see element "Active" for "filter pill"
    And I click on "button-newui" "filter" on "People" Page
    And I click on "button-newui" "ActiveCheck" on "People" Page
    And I click on "button-newui" "InactiveCheck" on "People" Page
    And I click on "button-newui" "outside filter" on "People" Page
    And I click on "button-newui" "filter" on "People" Page
    And I should see element "Active" for "checkbox checked" for People
    And I should not see element "Inactive" for "filter pill"
    And I should not see element "Terminated" for "filter pill"
    And I should not see element "Inactive" for "checkbox checked"
    And I should not see element "Terminated" for "checkbox checked"
    And I should see element "Active" for "person status accordion search" for People
    And I close browser

######################NewUI People Search - Filtering on Person Status######################
  #@NewUI-PeopleSearch
  #@NewUI-PS-Fltering
  @NewUI-US-18544
  @NewUIPeopleSearch-FilteringPersonStatus
  Scenario Outline: <Scenario>
    Given I initialize Browser
    And I POST Admin Tool Login QCSA
    And I GET Admin Tool Customers QCSA
    And I POST change "XTDFORCE_COMPLIANCE_SUPPRESSION" of id"19641" for customer"1364" property to "<PropertyValue>"
    And I am executing "<Scenario>"
    And I navigate to "NewUI" application
    And I should see element "login page"
    When I log in to "autoqcs" New UI application with "valid" Credentials
#   When I log in to "ayfuat" New UI application with "valid" Credentials
    And I click on "button-newui" "Login" on "Login" Page
    And I click on "button-newui" "I Certify" on "NOTICE" Page
    When I should see "menubutton-newui" named as "People" on "HOME" Page
    And I click on "MenuButton-NewUI" "People" on "HOME" Page
    And I should see element "People"
    And I should see element "filter button"
    #three statuses
    And I click on "button-newui" "filter" on "People" Page
    And I click on "button-newui" "InactiveCheck" on "People" Page
    And I click on "button-newui" "TerminatedCheck" on "People" Page
    And I click on "button-newui" "<CheckButton>" on "People" Page
    And I click on "button-newui" "filter complete" on "People" Page
    And I should see element "Active" for "filter pill"
    And I should see element "Inactive" for "filter pill"
    And I should see element "Terminated" for "filter pill"
    And I should see element "Terminated,Active,Inactive" for "person status accordion search" for People
    #Inactive,Terminated
    And I click on "button-newui" "ClickablePillActive" on "People" Page
    And I should not see element "Active" for "filter pill"
    And I should see element "Inactive" for "filter pill"
    And I should see element "Terminated" for "filter pill"
    And I should not see element "Active" for "checkbox checked"
    And I should see element "Inactive" for "checkbox checked"
    And I should see element "Terminated" for "checkbox checked"
    And I should see element "Inactive,Terminated" for "person status accordion search" for People
    #Terminated
    And I click on "button-newui" "ClickablePillInactive" on "People" Page
    And I should not see element "Active" for "filter pill"
    And I should not see element "Inactive" for "filter pill"
    And I should see element "Terminated" for "filter pill"
    And I should not see element "Active" for "checkbox checked"
    And I should not see element "Inactive" for "checkbox checked"
    And I should see element "Terminated" for "checkbox checked"
    And I should see element "Terminated" for "person status accordion search" for People
    #defaultFilter
    And I click on "button-newui" "ClickablePillTerminated" on "People" Page
    And I should not see element "Active" for "filter pill"
    And I should not see element "Inactive" for "filter pill"
    And I should not see element "Terminated" for "filter pill"
    And I should not see element "Active" for "checkbox checked"
    And I should not see element "Inactive" for "checkbox checked"
    And I should not see element "Terminated" for "checkbox checked"
    And I should see element "Active,Inactive,Terminated" for "person status accordion search" for People
    And I close browser
    Examples:
      | Scenario                                                   | PropertyValue | CheckButton    |
      | NewUI_SC08-People Search-Filtering-PersonStatusCompliance  | N             | CompliantCheck |
      | NewUI_SC08.1-People Search-Filtering-PersonStatusScreening | Y             | CompletedCheck |
######################NewUI People Search -Filter on Order Date######################
  #@NewUI-PeopleSearch
  @NewUI-PS-Fltering
  @NewUI-US-18545
  @NewUIPeopleSearch-Filtering
  @FilterOnOrderDate
  Scenario: NewUI_SC09-People Search-Filtering-FilterOnOrderDate
    Given I initialize Browser
    And I am executing "NewUI_SC09-People Search-Filtering-FilterOnOrderDate"
    And I navigate to "NewUI" application
    And I should see element "login page"
    When I log in to "autoqcs" New UI application with "valid" Credentials
#   When I log in to "ayfuat" New UI application with "valid" Credentials
    And I click on "button-newui" "Login" on "Login" Page
    And I click on "button-newui" "I Certify" on "NOTICE" Page
    When I should see "menubutton-newui" named as "People" on "HOME" Page
    And I click on "MenuButton-NewUI" "People" on "HOME" Page
    And I should see element "People"
    And I should see element "Active" for "filter pill"
    And I click on "button-newui" "filter" on "People" Page
    And I click on "button-newui" "Date range picker" on "People" Page
    And I select Date "from" "August 1 2021"
    And I select Date "to" "September 30 2021"
    And I click on "button-newui" "Date to" on "People" Page
    And I click on "button-newui" "filter complete" on "People" Page
    And I should see element "date accordion search" for People
    And I close browser
   
######################NewUI People Search -Filter on Completion Date######################
 # @NewUI-PeopleSearch
  @NewUI-PS-Fltering
  @NewUI-US-18546
  @NewUIPeopleSearch-Filtering
  @CompletionOnOrderDate
  Scenario: NewUI_SC10-People Search-Filtering-CompletionOnOrderDate
    Given I initialize Browser
    And I am executing "NewUI_SC10-People Search-Filtering-CompletionOnOrderDate"
    And I navigate to "NewUI" application
    And I should see element "login page"
    When I log in to "autoqcs" New UI application with "valid" Credentials
#   When I log in to "ayfuat" New UI application with "valid" Credentials
    And I click on "button-newui" "Login" on "Login" Page
    And I click on "button-newui" "I Certify" on "NOTICE" Page
    When I should see "menubutton-newui" named as "People" on "HOME" Page
    And I click on "MenuButton-NewUI" "People" on "HOME" Page
    And I should see element "People"
    And I should see element "Active" for "filter pill"
    And I click on "button-newui" "filter" on "People" Page
    And I click on "button-newui" "completion date range picker" on "People" Page
#    And I select Date "from completion" "June 1 2021"
#    And I select Date "to completion" "July 30 2021"
    And I select Date "from completion" "August 1 2021"
    And I select Date "to completion" "September 30 2021"
    And I click on "button-newui" "filter complete" on "People" Page
    And I should see element "completion date accordion search" for People
    And I close browser
    
######################NewUI People Search -Filter on Compliance Status######################
  #@NewUI-PeopleSearch
    @NewUI-PS-Fltering
    @NewUI-US-18548
    @NewUIPeopleSearch-Filtering @FilterOnComplianceStatus
  Scenario: NewUI_SC11-People Search-Filtering-FilterOnComplianceStatus
    Given I initialize Browser
    And I POST Admin Tool Login QCSA
    And I GET Admin Tool Customers QCSA
    And I POST change "XTDFORCE_COMPLIANCE_SUPPRESSION" of id"19641" for customer"1364" property to "N"
    And I am executing "NewUI_SC11-People Search-Filtering-FilterOnComplianceStatus"
    And I navigate to "NewUI" application
    And I should see element "login page"
    When I log in to "autoqcs" New UI application with "valid" Credentials
#   When I log in to "ayfuat" New UI application with "valid" Credentials
    And I click on "button-newui" "Login" on "Login" Page
    And I click on "button-newui" "I Certify" on "NOTICE" Page
    When I should see "menubutton-newui" named as "People" on "HOME" Page
    And I click on "MenuButton-NewUI" "People" on "HOME" Page
    And I should see element "People"
    And I should see element "filter button"
    And I click on "button-newui" "filter" on "People" Page
    And I click on "button-newui" "ActiveCheck" on "People" Page
    #five statuses
    And I click on "button-newui" "TerminatedCheck" on "People" Page
    And I click on "button-newui" "CompliantCheck" on "People" Page
    And I click on "button-newui" "NonCompliantCheck" on "People" Page
    And I click on "button-newui" "ActionRequiredCheck" on "People" Page
    And I click on "button-newui" "PendingCheck" on "People" Page
    And I click on "button-newui" "NeedsReviewCheck" on "People" Page
    And I click on "button-newui" "filter complete" on "People" Page
    And I should see element "Terminated" for "filter pill"
    And I should see element "Compliant" for "filter pill"
    And I should see element "Non-Compliant" for "filter pill"
    And I should see element "Action Required" for "filter pill"
    And I should see element "Pending" for "filter pill"
    And I should see element "Needs Review" for "filter pill"
    And I should see element "Terminated" for "checkbox checked"
    And I should see element "Compliant" for "checkbox checked"
    And I should see element "Non-Compliant" for "checkbox checked"
    And I should see element "Action Required" for "checkbox checked"
    And I should see element "Pending" for "checkbox checked"
    And I should see element "Needs Review" for "checkbox checked"
    And I should see element "Compliant,Non-Compliant,Action Required,Pending,Needs Review" for "compliance accordion search" for People
    #Compliant,Non-Compliant,Action Required,Needs Review
    And I click on "button-newui" "ClickablePillPending" on "People" Page
    And I should see element "Terminated" for "filter pill"
    And I should see element "Compliant" for "filter pill"
    And I should see element "Non-Compliant" for "filter pill"
    And I should see element "Action Required" for "filter pill"
    And I should not see element "Pending" for "filter pill"
    And I should see element "Needs Review" for "filter pill"
    And I should see element "Terminated" for "checkbox checked"
    And I should see element "Compliant" for "checkbox checked"
    And I should see element "Non-Compliant" for "checkbox checked"
    And I should see element "Action Required" for "checkbox checked"
    And I should not see element "Pending" for "checkbox checked"
    And I should see element "Needs Review" for "checkbox checked"
    And I should see element "Compliant,Non-Compliant,Action Required,Needs Review" for "compliance accordion search" for People
    #Compliant,Non-Compliant,Needs Review
    And I click on "button-newui" "ClickablePillAction Required" on "People" Page
    And I should see element "Terminated" for "filter pill"
    And I should see element "Compliant" for "filter pill"
    And I should see element "Non-Compliant" for "filter pill"
    And I should not see element "Action Required" for "filter pill"
    And I should not see element "Pending" for "filter pill"
    And I should see element "Needs Review" for "filter pill"
    And I should see element "Terminated" for "checkbox checked"
    And I should see element "Compliant" for "checkbox checked"
    And I should see element "Non-Compliant" for "checkbox checked"
    And I should not see element "Action Required" for "checkbox checked"
    And I should not see element "Pending" for "checkbox checked"
    And I should see element "Needs Review" for "checkbox checked"
    And I should see element "Compliant,Non-Compliant,Needs Review" for "compliance accordion search" for People
    #Compliant,Non-Compliant
    And I click on "button-newui" "ClickablePillNeeds Review" on "People" Page
    And I should see element "Terminated" for "filter pill"
    And I should see element "Compliant" for "filter pill"
    And I should see element "Non-Compliant" for "filter pill"
    And I should not see element "Action Required" for "filter pill"
    And I should not see element "Pending" for "filter pill"
    And I should not see element "Needs Review" for "filter pill"
    And I should see element "Terminated" for "checkbox checked"
    And I should see element "Compliant" for "checkbox checked"
    And I should see element "Non-Compliant" for "checkbox checked"
    And I should not see element "Action Required" for "checkbox checked"
    And I should not see element "Pending" for "checkbox checked"
    And I should not see element "Needs Review" for "checkbox checked"
    And I should see element "Compliant,Non-Compliant" for "compliance accordion search" for People
    #Compliant
    And I click on "button-newui" "ClickablePillNon-Compliant" on "People" Page
    And I should see element "Terminated" for "filter pill"
    And I should see element "Compliant" for "filter pill"
    And I should not see element "Non-Compliant" for "filter pill"
    And I should not see element "Action Required" for "filter pill"
    And I should not see element "Pending" for "filter pill"
    And I should not see element "Needs Review" for "filter pill"
    And I should see element "Terminated" for "checkbox checked"
    And I should see element "Compliant" for "checkbox checked"
    And I should not see element "Non-Compliant" for "checkbox checked"
    And I should not see element "Action Required" for "checkbox checked"
    And I should not see element "Pending" for "checkbox checked"
    And I should not see element "Needs Review" for "checkbox checked"
    And I should see element "Compliant" for "compliance accordion search" for People
    #default filter
    And I click on "button-newui" "ClickablePillCompliant" on "People" Page
    And I should see element "Terminated" for "filter pill"
    And I should not see element "Compliant" for "filter pill"
    And I should not see element "Non-Compliant" for "filter pill"
    And I should not see element "Action Required" for "filter pill"
    And I should not see element "Pending" for "filter pill"
    And I should not see element "Needs Review" for "filter pill"
    And I should see element "Terminated" for "checkbox checked"
    And I should not see element "Compliant" for "checkbox checked"
    And I should not see element "Non-Compliant" for "checkbox checked"
    And I should not see element "Action Required" for "checkbox checked"
    And I should not see element "Pending" for "checkbox checked"
    And I should not see element "Needs Review" for "checkbox checked"
    And I should see element "Compliant,Non-Compliant,Action Required,Pending,Needs Review" for "compliance accordion search" for People

    And I close browser
 ######################NewUI People Search -Filter on Screening Status######################
  #@NewUI-PeopleSearch
  @NewUI-PS-Fltering
  @NewUI-US-18547
  @NewUIPeopleSearch-Filtering
  @FilterOnScreeningStatus
  Scenario: NewUI_SC12-People Search-Filtering-FilterOnScreeningStatus
    Given I initialize Browser
    And I POST Admin Tool Login QCSA
    And I GET Admin Tool Customers QCSA
    And I POST change "XTDFORCE_COMPLIANCE_SUPPRESSION" of id"19641" for customer"1364" property to "Y"
    And I am executing "NewUI_SC12-People Search-Filtering-FilterOnScreeningStatus"
    And I navigate to "NewUI" application
    And I should see element "login page"
    When I log in to "autoqcs" New UI application with "valid" Credentials
#   When I log in to "ayfuat" New UI application with "valid" Credentials
    And I click on "button-newui" "Login" on "Login" Page
    And I click on "button-newui" "I Certify" on "NOTICE" Page
    When I should see "menubutton-newui" named as "People" on "HOME" Page
    And I click on "MenuButton-NewUI" "People" on "HOME" Page
    And I should see element "People"
    And I should see element "filter button"
    #three statuses
    And I click on "button-newui" "filter" on "People" Page
    And I click on "button-newui" "ActiveCheck" on "People" Page
    And I click on "button-newui" "TerminatedCheck" on "People" Page
    And I click on "button-newui" "PendingCheck" on "People" Page
    And I click on "button-newui" "CompletedCheck" on "People" Page
    And I click on "button-newui" "ActionRequiredCheck" on "People" Page
    And I click on "button-newui" "filter complete" on "People" Page
    And I should see element "Terminated" for "filter pill"
    And I should see element "Pending" for "filter pill"
    And I should see element "Completed" for "filter pill"
    And I should see element "Action Required" for "filter pill"
    And I should see element "Terminated" for "checkbox checked"
    And I should see element "Pending" for "checkbox checked"
    And I should see element "Completed" for "checkbox checked"
    And I should see element "Action Required" for "checkbox checked"
    And I should see element "Completed,Pending,Action Required" for "screening accordion search" for People
    #Completed,Action Required
    And I click on "button-newui" "ClickablePillPending" on "People" Page
    And I should see element "Terminated" for "filter pill"
    And I should not see element "Pending" for "filter pill"
    And I should see element "Completed" for "filter pill"
    And I should see element "Action Required" for "filter pill"
    And I should see element "Terminated" for "checkbox checked"
    And I should not see element "Pending" for "checkbox checked"
    And I should see element "Completed" for "checkbox checked"
    And I should see element "Action Required" for "checkbox checked"
    And I should see element "Completed,Action Required" for "screening accordion search" for People
    #Action Required
    And I click on "button-newui" "ClickableCompleted" on "People" Page
    And I should see element "Terminated" for "filter pill"
    And I should not see element "Pending" for "filter pill"
    And I should not see element "Completed" for "filter pill"
    And I should see element "Action Required" for "filter pill"
    And I should see element "Terminated" for "checkbox checked"
    And I should not see element "Pending" for "checkbox checked"
    And I should not see element "Completed" for "checkbox checked"
    And I should see element "Action Required" for "checkbox checked"
    And I should see element "Action Required" for "screening accordion search" for People
    #defaultFilter
    And I click on "button-newui" "ClickablePillAction Required" on "People" Page
    And I should see element "Terminated" for "filter pill"
    And I should not see element "Pending" for "filter pill"
    And I should not see element "Completed" for "filter pill"
    And I should not see element "Action Required" for "filter pill"
    And I should see element "Terminated" for "checkbox checked"
    And I should not see element "Pending" for "checkbox checked"
    And I should not see element "Completed" for "checkbox checked"
    And I should not see element "Action Required" for "checkbox checked"
    And I should see element "Completed,Pending,Action Required" for "screening accordion search" for People
    And I close browser
