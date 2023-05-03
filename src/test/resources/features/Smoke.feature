@Smoke
Feature: Self healing code test

#@VendorOnboarding
  @smoke_01
  Scenario: NewUI_CA-New: Forgot Password
    Given Set Page
      | NewUI |
    Given I initialize Browser
    And I am executing "NewUI_CA-New: Forgot Password"
#    And Open url
#      | NewUI0 |
#    And I navigate to "NewUI" application
    And I navigate to "NewUI Vendor Registration" application
#    And I should see element "Login Page"
#    When I click on "button-newui" "Login" on "Login" Page