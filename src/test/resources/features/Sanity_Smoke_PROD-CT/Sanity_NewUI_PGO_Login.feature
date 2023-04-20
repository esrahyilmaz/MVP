Feature: Sanity_Prod_NewUI_PGO_Login

  Scenario: SanityNewUI_ProgramOwner Login
    Given I initialize Browser
    When I Execute "Validate Login Functionaity - US-ID 34482"

    And I am executing "SanityNewUI_ProgramOwner Login"
    And I navigate to "SanityNewUI" application

    And I should see element "login page"
    Then I should see element "Logo"

    When I should see "button-newui" named as "Login" on "Login" Page
    When I click on "button-newui" "Login" on "Login" Page
    And I should see "errormsg-newui" named as "Username is required" on "Login" Page
    And I should see "errormsg-newui" named as "Password is required" on "Login" Page

    When I log in to "automation sponsor" New UI application with "onlyUser" Credentials
    And I click on "button-newui" "Login" on "Login" Page
    And I should see "errormsg-newui" named as "Password is required" on "Login" Page

    When I log in to "automation sponsor" New UI application with "onlyPassword" Credentials
    And I click on "button-newui" "Login" on "Login" Page
    And I should see "errormsg-newui" named as "Username is required" on "Login" Page

    When I log in to "automation sponsor" New UI application with "validPassword" Credentials
    And I click on "button-newui" "Login" on "Login" Page
    And I should see "errormsg-newui" named as "Username or password is incorrect. If this issue persists, please use the forgot password link below." on "Login" Page

    When I log in to "automation sponsor" New UI application with "valid" Credentials
    And I click on "button-newui" "Login" on "Login" Page

    Then I should see the sponsor logo in the header "VendorLogo"
    And I should see Customer support "number" in the header
    And I should see Customer support "email" in the header
    Then I should click "SupportLink" in the footer
    And I should click "FactActLink" in the footer
    And I should click "LegalLink" in the footer
    And I should click "PrivacyPolice" in the footer
    And I should see "FadvTrademark" in the footer of the page

    When I Execute "Validate FCRA - US-ID 34481"
    And I should see "button-newui" named as "I Certify" on "FCRA" Page
    And I click on "button-newui" "I Certify" on "NOTICE" Page

    When I Execute "Validate Logout Functionality - US-ID 34478"
    And I should see element "profile icon"
    When I click on "profile-icon"
    And I should see element "User Name" for "profile icon"
    And I should see element "logout"
    When I click on "logout"

    And I should see element "login page"

    And I close browser