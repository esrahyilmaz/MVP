Feature: Regression NewUI Site Credit Prerequisite Feature
#******************************************************************************************************************************

###################################Site Credit Prerequisite Feature ######################################
  @SiteCreditPrerequisiteSetToZero
  Scenario: NewUI_SiteCreditPrerequiste
    Given I initialize Browser
    When I am executing "NewUI_SiteCreditPrerequiste"
    And I navigate to "NewUI" application
    And I log in to "qcsavc" New UI application with "valid" Credentials
    And Get "Cust_ID" from API
    And Get "Vendor_ID" from API
    Then Set Site Credit "OFF"
    And I close browser

  @SiteCreditPrerequisiteSetToGreaterAmount
  Scenario: NewUI_SiteCreditPrerequiste
    Given I initialize Browser
    When I am executing "NewUI_SiteCreditPrerequiste"
    And I navigate to "NewUI" application
    And I log in to "qcsavc" New UI application with "valid" Credentials
    And Get "Cust_ID" from API
    And Get "Vendor_ID" from API
    Then Set Site Credit "ON"
    And I close browser
    
    @SiteCreditPrerequisiteSetToPartialAmount
  Scenario: NewUI_SiteCreditPrerequiste
    Given I initialize Browser
    When I am executing "NewUI_SiteCreditPrerequiste"
    And I navigate to "NewUI" application
    And I log in to "qcsavc" New UI application with "valid" Credentials
    And Get "Cust_ID" from API
    And Get "Vendor_ID" from API
    Then Set Site Credit "PartialAmount"
    And I close browser
