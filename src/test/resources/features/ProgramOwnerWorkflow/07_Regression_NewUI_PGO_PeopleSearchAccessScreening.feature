Feature: People Search/Access Screening
#*****************************************************************************************************************************************
######################NewUI Program Owner Workflow -People Search/Access Screening Screening######################
  @ProgramOwnerWorkflow @NewUI-ProgramOwnerWorkflow-US41880 @TC43451 @TC43456 @43497 @NewUIProgramOwnerWorkflow
  Scenario: NewUI_ProgramOwnerWorkflowProviderSearch-PeopleSearchAccessScreening
    Given I initialize Browser
    And I am executing "NewUI_ProgramOwnerWorkflowProviderSearch-PeopleSearchAccessScreening"
    And I navigate to "NewUI" application
    Then I open only a new tab
    Then I switch between tabs "child"
    And I navigate to "Admin tool" application
    And I log in to admin tool select customer "QCSAAUTOVC" for "QCSA"
    And I update Property "XTDFORCE_REGISTRATION_UI" to "Y"
    And I update Property "XTDFORCE_COMPLIANCE_SUPPRESSION" to "Y"
    And I update Property "ENABLE_PA_INTEGRATION" to "Y"
    Then I switch between tabs "parent"
    And I should see element "login page"
    When I log in to "qcsavc sponsor" New UI application with "valid" Credentials
    And I click on "button-newui" "Login" on "Login" Page
    And I click on "button-newui" "I Certify" on "NOTICE" Page
    When I should see "menubutton-newui" named as "People" on "HOME" Page
    And I click on "MenuButton-NewUI" "People" on "HOME" Page
    #And I verify hyperlink for "Admin Screening" user
    And I close browser
#*****************************************************************************************************************************************
######################NewUI Program Owner Workflow -People Search/Access Screening######################
  @ProgramOwnerWorkflow @NewUI-ProgramOwnerWorkflow-US41880 @TC43455 @TC43458 @43497 @NewUIProgramOwnerWorkflow
  Scenario: NewUI_ProgramOwnerWorkflowProviderSearch-PeopleSearchAccessCompliance
    Given I initialize Browser
    And I am executing "NewUI_ProgramOwnerWorkflowProviderSearch-PeopleSearchAccessCompliance"
    And I navigate to "NewUI" application
    Then I open only a new tab
    Then I switch between tabs "child"
    And I navigate to "Admin tool" application
    And I log in to admin tool select customer "QCSAAUTOVC" for "QCSA"
    And I update Property "XTDFORCE_REGISTRATION_UI" to "Y"
    And I update Property "XTDFORCE_COMPLIANCE_SUPPRESSION" to "N"
    And I update Property "ENABLE_PA_INTEGRATION" to "Y"
    Then I switch between tabs "parent"
    And I should see element "login page"
    When I log in to "qcsavc sponsor" New UI application with "valid" Credentials
    And I click on "button-newui" "Login" on "Login" Page
    And I click on "button-newui" "I Certify" on "NOTICE" Page
    When I should see "menubutton-newui" named as "People" on "HOME" Page
    And I click on "MenuButton-NewUI" "People" on "HOME" Page
    #And I verify hyperlink for "Admin Compliance" user
    And I close browser
######################NewUI Program Owner Workflow -People Search/Access Screening######################
  @ProgramOwnerWorkflow @NewUI-ProgramOwnerWorkflow-US41880 @TC43459 @NewUIProgramOwnerWorkflow
  Scenario: NewUI_ProgramOwnerWorkflowProviderSearch-PeopleSearchAccessSummaryScreening
    Given I initialize Browser
    And I am executing "NewUI_ProgramOwnerWorkflowProviderSearch-PeopleSearchAccessSummaryScreening"
    And I navigate to "NewUI" application
    Then I open only a new tab
    Then I switch between tabs "child"
    And I navigate to "Admin tool" application
    And I log in to admin tool select customer "QCSAAUTOVC" for "QCSA"
    And I update Property "XTDFORCE_REGISTRATION_UI" to "Y"
    And I update Property "XTDFORCE_COMPLIANCE_SUPPRESSION" to "Y"
    And I update Property "ENABLE_PA_INTEGRATION" to "Y"
    Then I switch between tabs "parent"
    And I should see element "login page"
    When I log in to "qcsavc sponsor summary" New UI application with "valid" Credentials
    And I click on "button-newui" "Login" on "Login" Page
    And I click on "button-newui" "I Certify" on "NOTICE" Page
    When I should see "menubutton-newui" named as "People" on "HOME" Page
    And I click on "MenuButton-NewUI" "People" on "HOME" Page
   # And I verify hyperlink for "Summary Screening" user
    And I close browser
######################NewUI Program Owner Workflow -People Search/Access Summary Compliance######################
  @ProgramOwnerWorkflow @NewUI-ProgramOwnerWorkflow-US41880 @TC43491 @NewUIProgramOwnerWorkflow
  Scenario: NewUI_ProgramOwnerWorkflowProviderSearch-PeopleSearchAccessSummaryCompliance
    Given I initialize Browser
    And I am executing "NewUI_ProgramOwnerWorkflowProviderSearch-PeopleSearchAccessSummaryCompliance"
    And I navigate to "NewUI" application
    Then I open only a new tab
    Then I switch between tabs "child"
    And I navigate to "Admin tool" application
    And I log in to admin tool select customer "QCSAAUTOVC" for "QCSA"
    And I update Property "XTDFORCE_REGISTRATION_UI" to "Y"
    And I update Property "XTDFORCE_COMPLIANCE_SUPPRESSION" to "N"
    And I update Property "ENABLE_PA_INTEGRATION" to "Y"
    Then I switch between tabs "parent"
    And I should see element "login page"
    When I log in to "qcsavc sponsor summary" New UI application with "valid" Credentials
    And I click on "button-newui" "Login" on "Login" Page
    And I click on "button-newui" "I Certify" on "NOTICE" Page
    When I should see "menubutton-newui" named as "People" on "HOME" Page
    And I click on "MenuButton-NewUI" "People" on "HOME" Page
    #And I verify hyperlink for "Summary Compliance" user
    And I close browser