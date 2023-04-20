#todo change implementation
Feature: Regression Hyperlink Vendor Credentials
 # @NewUI-PeopleSearch
  @HyperlinkCredentialsCompliance
  Scenario Outline:NewUI_SC18-HyperlinkVendorCredentialsCompliance
    Given I initialize Browser
    And I POST Admin Tool Login QCSA
    And I GET Admin Tool Customers QCSA
    And I POST change "XTDFORCE_COMPLIANCE_SUPPRESSION" of id"18671" for customer"1366" property to "N"
    And I am executing "NewUI_SC18-HyperlinkVendorCredentialsCompliance"
    And I navigate to "NewUI" application
    And I update credentials status to "<credentials>" for default vendor
#    Then I open only a new tab
#    Then I switch between tabs "child"
#    And I navigate to "Admin tool" application
#    And I log in to admin tool select customer "QCSAAUTOVC" for "QCSA"
#    And I update Property "XTDFORCE_COMPLIANCE_SUPPRESSION" to "N"
#    Then I switch between tabs "parent"
    When I log in to "qcsavc sponsor" New UI application with "valid" Credentials
    And I click on "button-newui" "Login" on "Login" Page
    And I click on "button-newui" "I Certify" on "NOTICE" Page
    And I click on "MenuButton-NewUI" "Providers" on "HOME" Page
    And I should see element "Providers"
    And I search for Provider "Pradeepnithin"
    And I search for "Pradeepnithin"
    And I verify hyperlink for "Provider Hyperlink" user
    And I close browser

    Examples:
      | credentials |
      | N/A         |
      | LIMITED     |
      | SUMMARY     |
      | FAIL        |
      | WITHDRAWN   |
      | FULL        |

  #@NewUI-PeopleSearch
  @HyperlinkCredentialsScreening
  Scenario Outline:NewUI_SC19-HyperlinkVendorCredentialsScreening
    Given I initialize Browser
    And I POST Admin Tool Login QCSA
    And I GET Admin Tool Customers QCSA
    And I POST change "XTDFORCE_COMPLIANCE_SUPPRESSION" of id"18671" for customer"1366" property to "Y"
    And I am executing "NewUI_SC19-HyperlinkVendorCredentialsScreening"
    And I navigate to "NewUI" application
    And I update credentials status to "<credentials>" for default vendor
#    Then I open only a new tab
#    Then I switch between tabs "child"
#    And I navigate to "Admin tool" application
#    And I log in to admin tool select customer "QCSAAUTOVC" for "QCSA"
#    And I update Property "XTDFORCE_COMPLIANCE_SUPPRESSION" to "Y"
#    Then I switch between tabs "parent"
    When I log in to "qcsavc sponsor" New UI application with "valid" Credentials
    And I click on "button-newui" "Login" on "Login" Page
    And I click on "button-newui" "I Certify" on "NOTICE" Page
    Then Navigate to "https://qcsa.fadv.net/vendor-workflow/people-search" Page
    And I click on "MenuButton-NewUI" "Providers" on "HOME" Page
    And I should see element "Providers"
    And I search for Provider "Pradeepnithin"
    And I search for "Pradeepnithin"
    And I verify hyperlink for "Provider Hyperlink Screening" user
    And I close browser

    Examples:
      | credentials |
      | N/A         |
      | LIMITED     |
      | SUMMARY     |
      | FAIL        |
      | WITHDRAWN   |
      | FULL        |