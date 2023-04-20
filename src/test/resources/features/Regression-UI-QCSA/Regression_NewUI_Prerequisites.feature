Feature: Regression NewUI Prerequisites 
    
#*****************************************************************************************************************************************

######################NewUIRegression_UI-7-Prerequisites######################     
@UI-7-property
Scenario: NewUIRegression_UI-7-Prerequisites
	Given I initialize Browser 
	When I Execute "Setting Prerequsites for UI-7" 
	And I am executing "NewUIRegression_UI-7-Prerequisites"
	And I navigate to "NewUI" application
	Then I open only a new tab
	Then I switch between tabs "child"
	And I navigate to "Admin tool" application
	And I log in to admin tool select customer "XTDAUTOQCSA" for "QCSA"
	And I update Property "XTDFORCE_REGISTRATION_UI" to "Y" 
	And I update Property "XTDFORCE_COMPLIANCE_SUPPRESSION" to "N"
	And I update Property "VENDOR_REGISTRATION_WORKFLOW_ENABLED" to "Vendor"
	And I update Property "ENABLE_PA_INTEGRATION" to "Y"
	And I update Property "TAX_CALCULATION_ENABLE" to "N"
	And I update Property "CUST_PAYMENT_GATEWAY" to "CARDCONNECT"
	And I update Property "POSITION_HIRE_LOCATION_REQUIRED" to "Null" 
	And I update Property "PROGRAM_PAYMENT_METHOD" to "Credit Card"
	#And I edit Customer Preference "VENDOR_REGISTRATION_COST" to "0" in Admin tool
	And I change Package property "PRICE" to "1.2" in Admin tool
	And I change Package property "ADDITIONAL EXPENSE" to "N" in Admin tool
	And I change Package property "ADDITIONAL EXPENSE PRICE" to "0" in Admin tool 
	Then I close open tabs "child"
	And I navigate to "NewUI" application 
	And I clear the cache
	And I close browser 
	

######################NewUIRegression_UI-10-Prerequisites######################     
@UI-10-property
Scenario: NewUIRegression_UI-10-Prerequisites
	Given I initialize Browser 
	When I Execute "Setting Prerequsites for UI-10" 
	And I am executing "NewUIRegression_UI-10-Prerequisites"
	And I navigate to "NewUI" application
	Then I open only a new tab
	Then I switch between tabs "child"
	And I navigate to "Admin tool" application
	And I log in to admin tool select customer "XTDAUTOQCSA" for "QCSA"
	And I update Property "XTDFORCE_REGISTRATION_UI" to "Y" 
	And I update Property "XTDFORCE_COMPLIANCE_SUPPRESSION" to "Y"
	And I update Property "VENDOR_REGISTRATION_WORKFLOW_ENABLED" to "Vendor"
	And I update Property "ENABLE_PA_INTEGRATION" to "Y"
	And I update Property "TAX_CALCULATION_ENABLE" to "N"
	And I update Property "CUST_PAYMENT_GATEWAY" to "CARDCONNECT"
	And I update Property "POSITION_HIRE_LOCATION_REQUIRED" to "Null" 
	And I update Property "PROGRAM_PAYMENT_METHOD" to "Credit Card"
	#And I edit Customer Preference "VENDOR_REGISTRATION_COST" to "0" in Admin tool
	And I change Package property "PRICE" to "1.2" in Admin tool
	And I change Package property "ADDITIONAL EXPENSE" to "N" in Admin tool
	And I change Package property "ADDITIONAL EXPENSE PRICE" to "0" in Admin tool 
	Then I close open tabs "child"
	And I navigate to "NewUI" application 
	And I clear the cache
	And I close browser 
	
######################NewUIRegression_UI-4-Prerequisites######################     
@UI-4-property
Scenario: NewUIRegression_UI-4-Prerequisites
	Given I initialize Browser 
	When I Execute "Setting Prerequsites for UI-4" 
	And I am executing "NewUIRegression_UI-4-Prerequisites"
	And I navigate to "NewUI" application
	Then I open only a new tab
	Then I switch between tabs "child"
	And I navigate to "Admin tool" application
	And I log in to admin tool select customer "XTDAUTOQCSA" for "QCSA"
	And I update Property "XTDFORCE_REGISTRATION_UI" to "Y" 
	And I update Property "XTDFORCE_COMPLIANCE_SUPPRESSION" to "Y"
	And I update Property "VENDOR_REGISTRATION_WORKFLOW_ENABLED" to "Vendor"
	And I update Property "ENABLE_PA_INTEGRATION" to "Y"
	And I update Property "TAX_CALCULATION_ENABLE" to "Y"
	And I update Property "CUST_PAYMENT_GATEWAY" to "CARDCONNECT"
	And I update Property "POSITION_HIRE_LOCATION_REQUIRED" to "Null" 
#	And I update Property "PROGRAM_PAYMENT_METHOD" to "Credit Card"
	And I update Property "ACTIVATE_VENDOR" to "Y"
	#And I edit Customer Preference "VENDOR_REGISTRATION_COST" to "1.5" in Admin tool
	And I change Package property "PRICE" to "1.2" in Admin tool
	And I change Package property "ADDITIONAL EXPENSE" to "N" in Admin tool
	And I change Package property "ADDITIONAL EXPENSE PRICE" to "0" in Admin tool 
	Then I close open tabs "child"
	And I navigate to "NewUI" application 
	And I clear the cache
	And I close browser 
	
	
	
	
	
	
	
	
	
