Feature: Regression NewUI Dashboard

######################NewUI People Search######################
 @NewUI-PeopleSearch
  @NewUI 
  @NewUIDashboard 
  @NewUIDashboardProvider
  Scenario: NewUI_SC03-Dashboard Provider Account
    Given I initialize Browser
    And I am executing "NewUI_SC03-Dashboard Provider Account"
    And I navigate to "NewUI" application
    
    Then I open only a new tab
    Then I switch between tabs "child"
    And I navigate to "Admin tool" application
    And I log in to admin tool select customer "XTDAUTOQCSA" for "QCSA"
    And I update Property "XTDFORCE_COMPLIANCE_SUPPRESSION" to "N"
    Then I switch between tabs "parent"
    
    And I should see element "login page"
    When I log in to "Autoqcs" New UI application with "valid" Credentials
    And I click on "button-newui" "Login" on "Login" Page
    And I click on "button-newui" "I Certify" on "NOTICE" Page
    When I should see "menubutton-newui" named as "Dashboard" on "HOME" Page
    Then I should see "title" named as "Here is your dashboard." on "Dashboard" Page

    And I get "Select_UserFirstName" with input value "UserName" in "Dashboard" page
    #And I should see element "Hello message!"
    And I should see Text "Manage People"

    Then I should see the sponsor logo in the header "VendorLogo"
    And I should see Customer support "number" in the header
    And I should see Customer support "email" in the header
    Then I should click "SupportLink" in the footer
    And I should click "FactActLink" in the footer
    And I should click "LegalLink" in the footer
    And I should click "PrivacyPolice" in the footer
    And I should see "FadvTrademark" in the footer of the page

    And I should see Text "Needs Review"
    When I click on "button-newui" "Needs Review" on "Dashboard" Page
    And I should see element "Needs Review" for "link url" 
    
    When I should see "menubutton-newui" named as "Dashboard" on "HOME" Page
    And I click on "MenuButton-NewUI" "Dashboard" on "HOME" Page
    
    And I should see Text "Non-Compliant"
    When I click on "button-newui" "Non-Compliant" on "Dashboard" Page
    And I should see element "Non-Compliant" for "link url"
    
    When I should see "menubutton-newui" named as "Dashboard" on "HOME" Page
    And I click on "MenuButton-NewUI" "Dashboard" on "HOME" Page
    
    And I should see Text "Pending"
    When I click on "button-newui" "Pending" on "Dashboard" Page
    And I should see element "Pending" for "link url"
    
    When I should see "menubutton-newui" named as "Dashboard" on "HOME" Page
    And I click on "MenuButton-NewUI" "Dashboard" on "HOME" Page
    
    And I should see Text "Action Required"
    When I click on "button-newui" "Action Required" on "Dashboard" Page
    And I should see element "Action Required" for "link url" 
    
    When I should see "menubutton-newui" named as "Dashboard" on "HOME" Page
    And I click on "MenuButton-NewUI" "Dashboard" on "HOME" Page
    
    And I should see Text "Expired"
    When I click on "button-newui" "Expired" on "Dashboard" Page
    And I should see element "Expired" for "link url"
    
    And I close browser

#*****************************************************************************************************************************************

@NewUI-PeopleSearch
  @NewUI 
  @NewUIDashboard 
  @NewUIDashboardProgramOwner
  Scenario: NewUI_SC03-Dashboard Program Owner Account
    Given I initialize Browser
    And I am executing "NewUI_SC03-Dashboard Program Owner Account"
    And I navigate to "NewUI" application
    
    Then I open only a new tab
    Then I switch between tabs "child"
    And I navigate to "Admin tool" application
    And I log in to admin tool select customer "XTDAUTOQCSA" for "QCSA"
    And I update Property "XTDFORCE_COMPLIANCE_SUPPRESSION" to "N"
    Then I switch between tabs "parent"
    
    And I should see element "login page"
    When I log in to "automation sponsor" New UI application with "valid" Credentials
    And I click on "button-newui" "Login" on "Login" Page
    And I click on "button-newui" "I Certify" on "NOTICE" Page
    When I should see "menubutton-newui" named as "Dashboard" on "HOME" Page
    Then I should see "title" named as "Here is your dashboard." on "Dashboard" Page

    And I get "Select_UserFirstName" with input value "UserName" in "Dashboard" page
    #And I should see element "Hello message!"
    And I should see Text "Manage People"

    Then I should see the sponsor logo in the header "VendorLogo"
    And I should see Customer support "number" in the header
    And I should see Customer support "email" in the header
    Then I should click "SupportLink" in the footer
    And I should click "FactActLink" in the footer
    And I should click "LegalLink" in the footer
    And I should click "PrivacyPolice" in the footer
    And I should see "FadvTrademark" in the footer of the page

    And I should see Text "Needs Review"
    When I click on "button-newui" "Needs Review" on "Dashboard" Page
    And I should see element "Needs Review" for "link url" 
    
    When I should see "menubutton-newui" named as "Dashboard" on "HOME" Page
    And I click on "MenuButton-NewUI" "Dashboard" on "HOME" Page
    
    And I should see Text "Non-Compliant"
    When I click on "button-newui" "Non-Compliant" on "Dashboard" Page
    And I should see element "Non-Compliant" for "link url"
    
    When I should see "menubutton-newui" named as "Dashboard" on "HOME" Page
    And I click on "MenuButton-NewUI" "Dashboard" on "HOME" Page
    
    And I should see Text "Pending"
    When I click on "button-newui" "Pending" on "Dashboard" Page
    And I should see element "Pending" for "link url"
    
    When I should see "menubutton-newui" named as "Dashboard" on "HOME" Page
    And I click on "MenuButton-NewUI" "Dashboard" on "HOME" Page
    
    When I should see "menubutton-newui" named as "Dashboard" on "HOME" Page
    And I click on "MenuButton-NewUI" "Dashboard" on "HOME" Page
    
    And I should see Text "Expired"
    When I click on "button-newui" "Expired" on "Dashboard" Page
    And I should see element "Expired" for "link url"
    
     When I should see "menubutton-newui" named as "Dashboard" on "HOME" Page
    And I click on "MenuButton-NewUI" "Dashboard" on "HOME" Page
    
     And I should see Text "Active Providers"
    When I click on "button-newui" "Active Providers" on "Dashboard" Page
    And I should see element "Active Providers" for "link url" 
    
    And I close browser
    
#######NewUI_Dashboard Landing Page - not landing#########################################################################################


@NewUI-PeopleSearch
  @NewUIDashboard 
  @NewUIDashboard-NOT
  Scenario: NewUI_SC04-Dashboard-NOT
    Given I initialize Browser
    And I am executing "NewUI_SC04-Dashboard-NOT"
    And I navigate to "NewUI" application

    Then I open only a new tab
    Then I switch between tabs "child"
    And I navigate to "Admin tool" application
    And I log in to admin tool select customer "XTDAUTOQCSA" for "QCSA"
    And I update Property "XTDFORCE_COMPLIANCE_SUPPRESSION" to "Y"
    Then I switch between tabs "parent"
    And I should see element "login page"

    When I log in to "autoqcs" New UI application with "valid" Credentials
    And I click on "button-newui" "Login" on "Login" Page
    And I click on "button-newui" "I Certify" on "NOTICE" Page

    When I should not see element "Dashboard"
    Then I should see the sponsor logo in the header "VendorLogo"
    And I should see Customer support "number" in the header
    And I should see Customer support "email" in the header
    Then I should click "SupportLink" in the footer
    And I should click "FactActLink" in the footer
    And I should click "LegalLink" in the footer
    And I should click "PrivacyPolice" in the footer
    And I should see "FadvTrademark" in the footer of the page
    And I close browser