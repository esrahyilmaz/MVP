Feature: Add Link to Help Center

  @NewUI-PeopleSearch
  @HelpCenter @US55633
  Scenario: NewUI_SC21-HelpCenter
    Given I initialize Browser
    And I am executing "NewUI_SC21-HelpCenter"
    And I navigate to "NewUI" application
    And I should see element "login page"
    When I log in to "autoqcs" New UI application with "valid" Credentials
    And I click on "button-newui" "Login" on "Login" Page
    And I click on "button-newui" "I Certify" on "NOTICE" Page
    And I should see element "profile icon"
    And I click on "button-newui" "profile icon" on "Home" Page
    And I should see element "Help Center"
    And I click on "button-newui" "Help Center" on "Home" Page
    And I should see element "hyperlink"
    And I verify hyperlink URL "https://fadv.com/learn/helpcenter/"
    And I close browser