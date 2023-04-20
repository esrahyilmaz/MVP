Feature: Regression NewUI Administration ButtonColoring

######################Regression_NewUI_ButtonColoring- Administration######################
@NewUI-Administration
@NewUI-US-8274
@ButtonColorAdministration
  Scenario: NewUI_SC11-ButtonColoring-Administration
    Given I initialize Browser
    And I am executing "NewUI_SC11-ButtonColoring-Administration"
    And I navigate to "NewUI" application
    And I should see element "login page"
    When I log in to "autoqcs" New UI application with "valid" Credentials
    And I click on "button-newui" "Login" on "Login" Page
    And I click on "button-newui" "I Certify" on "NOTICE" Page
    When I should see "menubutton-newui" named as "People" on "HOME" Page
    And I click on "MenuButton-NewUI" "Administration" on "HOME" Page
    And I click on "MenuButton-NewUI" "User Management" on "HOME" Page
    And I verify "Administration button coloring" for Administration
    And I close browser