Feature: Admin Tool Property Change trough API

  @Test
  Scenario: SanityNewUI_ProgramOwner Search
    Given I initialize Browser
    When I am executing "SanityNewUI_ProgramOwner Search"
    When Set "XTDFORCE_COMPLIANCE_SUPPRESSION" to "N" for "1364" Customer
    Then I close browser


