Feature: Regression People Search Provider Name

  #@NewUI-PeopleSearch
  @PeopleSearchProviderName
  Scenario: NewUI_SC20-PeopleSearchProviderName
    Given I initialize Browser
    And I am executing "NewUI_SC20-PeopleSearchProviderName"
    And I navigate to "NewUI" application
    And I should see element "login page"
    When I log in to "qcsavc sponsor" New UI application with "valid" Credentials
    And I click on "button-newui" "Login" on "Login" Page
    And I click on "button-newui" "I Certify" on "NOTICE" Page
    Then Navigate to "https://qcsa.fadv.net/vendor-workflow/people-search" Page
    And I click on "MenuButton-NewUI" "People" on "HOME" Page
    And I should see element "People"
    And I click on "button-newui" "filter" on "People" Page
    And I search for provider
    And I click on "button-newui" "filter complete" on "People" Page
    #And I GET total number of People for "Active" "Provider Name" filter for "Program Owner"
    And I Validate "Active" Filter for "Program Owner" Page
    And I click on "button-newui" "filter complete" on "People" Page
    And I should see element "Provider pill"
    And I verify the provider results
    And I close browser