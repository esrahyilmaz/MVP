Feature: Regression NewUI Hide Add/New Order Button 
    
#*****************************************************************************************************************************************

######################NewUI Hide Add/New Order Button ######################
@NewUI-PeopleSearch
  @NewUI 
  @NewUIHideAddNewButton 
  @NewUIHideAddNewButton-N
  Scenario: NewUI_SC16-Hide Button-N
    Given I initialize Browser
    And I am executing "NewUI_SC16-Hide Button-N"
    And I navigate to "NewUI" application
    Then I open only a new tab
    Then I switch between tabs "child"
    And I navigate to "Admin tool" application
    And I log in to admin tool select customer "XTDAUTOQCSA" for "QCSA"
    And I update Property "XTDFORCE_API_PROGRAM" to "Registration"
    Then I switch between tabs "parent"
    And I should see element "login page"

    When I log in to "autoqcs" New UI application with "valid" Credentials
    And I click on "button-newui" "Login" on "Login" Page
    And I click on "button-newui" "I Certify" on "NOTICE" Page
    And I click on "MenuButton-NewUI" "People" on "HOME" Page
    And I should see element "People"

    Then I should see "button-newui" named as "Add People" on "People" Page
    When I click on "button-newui" " Create Order " on "People" Page
    And I click on "button-newui" "Cancel" on "Personal Information" Page

    And I should see element "People"
    When I click on "checkbox" "first" on "People" Page
    When I should see "button-newui" named as "New Order" on "People" Page
    And I click on "button-NewUI" "New Order" on "People" Page

    And I click on "MenuButton-NewUI" "People" on "HOME" Page
    Then I switch between tabs "child"
    And I navigate to "Admin tool" application
    And I log in to admin tool select customer "XTDAUTOQCSA" for "QCSA"
    And I update Property "XTDFORCE_API_PROGRAM" to "Null"
    Then I switch between tabs "parent"
    Then I should see "button-newui" named as "Add People" on "People" Page
    When I click on "button-newui" " Create Order " on "People" Page
    And I click on "button-newui" "Cancel" on "Personal Information" Page

    And I should see element "People"
    When I click on "checkbox" "first" on "People" Page
    When I should see "button-newui" named as "New Order" on "People" Page
    And I click on "button-NewUI" "New Order" on "People" Page

    And I close browser
    
######################NewUI Hide Add/New Order Button N ######################
@NewUI-PeopleSearch
  @NewUI 
  @NewUIHideAddNewButton 
  @NewUIHideAddNewButton-Y
  Scenario: NewUI_SC17-Hide Button-Y
    Given I initialize Browser
    And I am executing "NewUI_SC17-Hide Button-Y"
    And I navigate to "NewUI" application
    Then I open only a new tab
    Then I switch between tabs "child"
    And I navigate to "Admin tool" application
    And I log in to admin tool select customer "XTDAUTOQCSA" for "QCSA"
    And I update Property "XTDFORCE_API_PROGRAM" to "Order"
    Then I switch between tabs "parent"
    And I should see element "login page"

    When I log in to "autoqcs" New UI application with "valid" Credentials
    And I click on "button-newui" "Login" on "Login" Page
    And I click on "button-newui" "I Certify" on "NOTICE" Page
    And I click on "MenuButton-NewUI" "People" on "HOME" Page
    And I should see element "People"

    Then I should see "button-newui" named as "Add People" on "People" Page
    And I should not see "button-newui" named as "Add People" on "People" Page

    When I click on "checkbox" "first" on "People" Page
    When I should not see "button-newui" named as "New Order" on "People" Page

    And I click on "MenuButton-NewUI" "People" on "HOME" Page
    Then I switch between tabs "child"
    And I navigate to "Admin tool" application
    And I log in to admin tool select customer "XTDAUTOQCSA" for "QCSA"
    And I update Property "ENABLE_PA_INTEGRATION" to "Y"
    And I update Property "XTDFORCE_API_PROGRAM" to "Both"
    Then I switch between tabs "parent"
    Then I should see "button-newui" named as "Add People" on "People" Page
    And I should not see "button-newui" named as "Add People" on "People" Page

    When I click on "checkbox" "first" on "People" Page
    When I should not see "button-newui" named as "New Order" on "People" Page

	Then I switch between tabs "child"
    And I navigate to "Admin tool" application
    And I log in to admin tool select customer "XTDAUTOQCSA" for "QCSA"
    And I update Property "XTDFORCE_API_PROGRAM" to "Null"

    And I close browser    