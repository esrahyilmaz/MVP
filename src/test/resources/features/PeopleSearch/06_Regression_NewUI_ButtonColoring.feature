Feature: Regression NewUI ButtonColoring

######################Regression_NewUI_ButtonColoring- People Search######################
@NewUI-PeopleSearch
@NewUI-US-7508 
@Regression_NewUI_ButtonColoring 
@ButtonColorPeopleSearch
  Scenario: NewUI_SC13-ButtonColoring-PeopleSearch
    Given I initialize Browser
    And I am executing "NewUI_SC13-ButtonColoring-PeopleSearch"
    And I navigate to "NewUI" application
    Then I open only a new tab
    Then I switch between tabs "child"
    And I navigate to "Admin tool" application
    And I log in to admin tool select customer "XTDAUTOQCSA" for "QCSA"
    And I update Property "XTDFORCE_COMPLIANCE_SUPPRESSION" to "N"
    Then I switch between tabs "parent"
    And I should see element "login page"
    When I log in to "autoqcs" New UI application with "valid" Credentials
    And I click on "button-newui" "Login" on "Login" Page
    And I click on "button-newui" "I Certify" on "NOTICE" Page
    When I should see "menubutton-newui" named as "People" on "HOME" Page
    And I click on "MenuButton-NewUI" "People" on "HOME" Page
    And I should see element "People"
    And I should see element "Active" for "filter pill"
    And I should see element "Active" for "checkbox checked"
    #And I verify "compliance button coloring" for People
    And I close browser

######################Regression_NewUI_ButtonColoring- People Search Screening######################
@NewUI-PeopleSearch
@NewUI-US-8272 
@Regression_NewUI_ButtonColoring 
@ButtonColorPeopleSearchScreening
  Scenario: NewUI_SC14-ButtonColoring-Screening
    Given I initialize Browser
    And I am executing "NewUI_SC14-ButtonColoring-Screening"
    And I navigate to "NewUI" application
    Then I open only a new tab
    Then I switch between tabs "child"
    And I navigate to "Admin tool" application
    And I log in to admin tool select customer "QCSAAUTOVC" for "QCSA"
    And I update Property "XTDFORCE_COMPLIANCE_SUPPRESSION" to "Y"
    Then I switch between tabs "parent"
    And I should see element "login page"
    When I log in to "qcsavc" New UI application with "valid" Credentials
    And I click on "button-newui" "Login" on "Login" Page
    And I click on "button-newui" "I Certify" on "NOTICE" Page
    And I click on "MenuButton-NewUI" "People" on "HOME" Page
    When I should see "menubutton-newui" named as "People" on "HOME" Page
    And I should see element "Active" for "filter pill"
    And I should see element "Active" for "checkbox checked"
    And I verify "screening button coloring" for People
    And I close browser