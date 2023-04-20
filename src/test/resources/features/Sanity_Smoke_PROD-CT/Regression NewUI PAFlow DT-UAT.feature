Feature: Regression NewUI PAFlow DT-UAT
@NewUI-4-PAFlow-UAT-DT
Scenario: NewUIRegression_UI-4-PAFlow
  Given I initialize Browser
  And I navigate to "NewUIRegression" application
  #need to change credentials
  When I log in to "ayfuat" New UI application with "valid" Credentials
  And I click on "button-newui" "Login" on "Login" Page

  When I should see "button-newui" named as "I Certify" on "FCRA" Page
  And I click on "button-newui" "I Certify" on "NOTICE" Page

  And I should see element "People"

  When I click on "MenuButton-NewUI" "People" on "HOME" Page
  When I click on "button-newui" " Create Order " on "People" Page

  And I should see element "add people icon" for "POW icon"
  And I should see element "add people icon Section" for "POW icon"
  And I should see Text "Personal information"

  And I click on "button-newui" "Middle Name Yes" on "create person" Page
  And I enter "valid" value for "FN" textbox on "create person" Page NewUI
  And I enter "valid" value for "MN" textbox on "create person" Page NewUI
  And I enter "valid" value for "LN" textbox on "create person" Page NewUI
  And I enter "random" value for "email" textbox on "create person" Page NewUI
  And I enter "valid" value for "re-enter email" textbox on "create person" Page NewUI
  And I click on "button-newui" "Next" on "create person" Page

  And I should see Text "Package Selection"
  And I should see element "package icon" for "POW icon"
  And I should see element "package icon Section" for "POW icon"
  And I should see "button-newui" named as "Previous" on "Package Selection" Page

  When Search table By "Package" in "Package Selection" page
  And I click on "button-newui" "search" on "package selection" Page
  And I click on "radiobutton-newui" "first pkg" on "package selection" Page

  And I click on "button-NewUI" "Add to Cart" on "package selection" Page
  And I click on "button-newui" "Authorize" on "Shopping Cart" Page
  And I click on "button-NewUI" "Checkout" on "Shopping Cart" Page

  #	And I click on "radiobutton-newui" "use new payment method" on "payment method" Page
  And I enter "present" value for "FN" textbox on "pow" Page NewUI
  And I enter "present" value for "LN" textbox on "pow" Page NewUI
  #	And I enter "valid" value for "CardNumberVisa" textbox on "Add People" Page NewUI
  #	And I enter "valid" value for "MM" textbox on "Add People" Page NewUI
  #	And I enter "valid" value for "YY" textbox on "Add People" Page NewUI
  And I enter "valid" value for "CSC" textbox on "Add People" Page NewUI

  And I click on "button-newui" "Next button on PP" on "Payment Method" Page
  And wait for "2" Seconds
  Then I should see Text "Order complete!"
  Then I click on "button-newui" "Return to People Page" on "order submission" Page

  And I should see element "People"
  And Search table By "FN & LN" in "pow" page
  And I click on "button-newui" "search" on "People" Page
  And I should see element "by multi search"

  Then wait Until Profile Status is "Email Sent" for "PA flow"

  Then Get the ProfileId from UI
  Then I open only a new tab
  Then I switch between tabs "child"

  And I navigate to "PAInviteLanuchUrlUAT" application

  Then Wait until Element Present "Sign Up Page"
  And I fill details in PA "SignUp-UAT" page

  Then Wait until Element Present "Country Page"
  And I fill details in PA "Country" page

  Then Wait until Element Present "ESign Page"
  And I fill details in PA "ESign" page

  Then Wait until Element Present "Notice Page UAT"
  And I fill details in PA "Notice-UAT1" page

  Then Wait until Element Present "Consent Page UAT"
  And I fill details in PA "Consent-UAT" page

  Then Wait until Element Present "Notice Page UAT"
  And I fill details in PA "Agreement-UAT" page

  And I fill details in PA "Profile" page

  Then Wait until Element Present "Residence Page"
  And I fill details in PA "Residence-UAT" page

  Then Wait until Element Present "License Page"
  And I fill details in PA "License-UAT" page

  Then Wait until Element Present "Criminal Page"
  And I fill details in PA "Criminal" page

  Then Wait until Element Present "Identity Page"
  And I fill details in PA "Identity" page

  Then Wait until Element Present "AdditionalInfomartion Page"
  And I fill details in PA "AdditionalInfomartion-UAT" page

  Then Wait until Element Present "Review Page"
  And I fill details in PA "Review" page

  Then Wait until Element Present "DocumentUpload Page"
  And I fill details in PA "DocumentUpload-DT" page

  Then Wait until Element Present "ProfileDashboard Page"
  Then I close open tabs "child"

  And Search table By "FN & LN" in "pow" page
  And I click on "button-newui" "search" on "People" Page

  Then Click Logout NewUI
  And I close browser