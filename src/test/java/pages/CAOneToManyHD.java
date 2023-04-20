package pages;

import Utility.ExcelReader;
import com.aventstack.extentreports.Status;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import seleniumhelper.BaseClass;

public class CAOneToManyHD extends BaseClass {
	public static String randomFirstName=null;
	public static String randomUpdatedName=null;
	public static String ssnNumber=null;
	int count =0;
	public static String fName = randomFirstName;
	public static String ssnExisting;
	 JavascriptExecutor js = (JavascriptExecutor)driver;
	
	ExcelReader _dataRepo = new ExcelReader();
	CAAddPerson caPerson= new CAAddPerson();
	CALoginPage caLogin = new CALoginPage();
	
	//Home page 
	By home_btn	= By.xpath("//table//a[contains(text(),'Home')]");
	By lob_dropdown	= By.xpath("//select[@name='lobId']");
	By submitLob_btn	= By.xpath("//input[@value='SUBMIT']"); 
	
	//secret question
	
	By secretQuestionAnswer_btn	= By.xpath("//input[@name='userRecertSecretAnswer']");
	By recertify_btn	= By.xpath("//input[@value='RECERTIFY']");
	
	
	//HDI value =22 , HD= 599
	//For new vendor in lob - provide vendor name = 	Bindhu1 QC1 Test
	By vendorHDILob_link	= By.xpath("//table//a[contains(text(),'Amrita HDE2 TESTING Update')]"); 
	
	//Add person page
	
	By userName_txt	= By.xpath("//input[@id ='userLoginIdToShow']");
	By password_txt	= By.xpath("//input[@id ='passwordToShow']");
	By signIn_btn	= By.xpath("//a[contains(text(),'Log In')]");
	By secretAnswer_txt	= By.xpath("//input[@name = 'userRecertSecretAnswer']");
	By recertifySceretAnswer_btn	= By.xpath("//input[@name = 'userRecertSecretAnswer']");
	By sessionOverride_btn	= By.xpath("//input[@value ='Proceed with Login']");
	By acceptLegalAgreement_btn	= By.xpath("//input[@type='submit' and @name ='accept']");
	
	By vendorMenu_btn	= By.xpath("(//table//tr/td/a[contains(text(),'Vendor')])[1]");
	By searchVendorMenu_btn	= By.xpath("//table//tr/td/a[contains(text(),'Search Vendor')]");
	By vendorName_txt	= By.xpath("//input[@id='vendorName']");
	
	By search_btn	= By.xpath("//input[@value='Search']");
	
	By errorMsgSsn_txt	= By.xpath("//div[@id='errorMessages']");
	
	// vendor names - home depo
	By amritavendor1_link	= By.xpath("//a[contains(text(),'Amritavendor1')]");
	By indiasangameshbusiness_link	= By.xpath("//a[contains(text(),'indiasangameshbusiness')]");
	By thdTesting_link	= By.xpath("//a[contains(text(),'THD Testing')]");
	
	By thdDemoCA_link	= By.xpath("//table//tbody//td/a[contains(text(),'THD DEMO CA')]");


	By next_btn	= By.xpath("//input[@id ='actionbutton']");
	
	// person status detail
	By editInformation_btn	= By.xpath("//input[@name='edit']");
	
	//Edit information - person information page
	By removeFromRoster_btn	= By.xpath("//input[@id='removeIndFromRoster']"); 
	
	By activeStatus_dropdown	= By.xpath("//select[@id='inactiveReasonCd']"); 
	By oneToMany_dtxt	= By.xpath("//td/b[contains(text(),'One To Many')]"); 

	

	
	//Removed from vendor's roster
	By errorMsgVendorRoster_txt	= By.xpath("//div[@id='errorMessages']");
	//An individual (87558) is successfully removed from Vendor's Roster.

	
	
	// Titles====================================================================================================
	By titlePeopleSearch = By.xpath("//b[contains(text(),'People Search for')]");
	By titlePersonStatusPage	= By.xpath("//b[contains(text(),'Person Status Detail')]");


	public void signInHomeDepot() {
		try{
			EnterText(userName_txt,"enter userName", _dataRepo.getData("page.UserName"));
			EnterText(password_txt,"enter passowrd", _dataRepo.getData("page.Password"));
			takeScreenshot();
			clickElementWithWait(signIn_btn, "click on the login button"); 
if(verifyElementPresence(caLogin.sessionOverrideTitle)) {
				clickElementWithWait(caLogin.proceedwithLoginBtn, "Clicked on proceed with login button");}
			if(verifyElementPresence(caLogin.recertificationTitle)) {
				String Value = "blue";
				EnterText(caLogin.secretAnswerText, "Secret Answer entered", Value);
				clickElementWithWait(caLogin.recertifyBtn, "click on Recertify Button");}
			if(verifyElementPresence(caLogin.sessionOverrideTitle)) {
				clickElementWithWait(caLogin.proceedwithLoginBtn, "Clicked on proceed with login button");}
			
			
			reportLog(Status.PASS, "user is signed in ", true); 
		}	
		catch(Exception e) {System.out.println("print error =================  "+e);}
	}
	
	
	public void acceptAgreement() {
		try {
	//	js.executeScript("arguments[0].click();", driver.findElement(acceptLegalAgreement_btn));
		clickElementWithWait(acceptLegalAgreement_btn, "AcceptLegalAgreement");
		}
		catch(Exception e) {}
	}
	
	
	public void selectLobHDIandSelectVendor() {
		try {
			clickElementWithWait(home_btn, "click on home button");
			selectDropDownByValue(lob_dropdown, "21", "select lob from dropdown");
			clickElementWithWait(submitLob_btn, "click to submit selected lob");
			wait(2);
			clickElementWithWait(vendorMenu_btn, "click on the vendor button from menu");
			wait(2);
			clickElementWithWait(searchVendorMenu_btn, "click on the search vendor button from menu"); 
			//select the vendor
			EnterText(vendorName_txt,"enter vendor name", "Amrita HDE2 TESTING Update");
			clickElementWithWait(search_btn, "click on the search vendor button from menu"); 
			wait(1);
			clickElementWithWait(vendorHDILob_link, "click on the vendor name");
			reportLog(Status.PASS, "selecting the new Lob", true);

			
		}catch(Exception e) {
			
		}
	}
	
	
	
	public void searchVendor() {
		try {

			wait(2);
			clickElementWithWait(vendorMenu_btn, "click on the vendor button from menu");
			wait(2);
			clickElementWithWait(searchVendorMenu_btn, "click on the search vendor button from menu"); 
			
			switch(count) {
			case 0:
			EnterText(vendorName_txt,"enter vendor name", "indiasangameshbusiness");
			clickElementWithWait(search_btn, "click on the search vendor button from menu"); 
			wait(2);
			takeScreenshot();
			clickElementWithWait(indiasangameshbusiness_link, "click on the vendor name");
			reportLog(Status.PASS, "vendor selected as indiasangameshbusiness", true);

			break;
			case 2:
			EnterText(vendorName_txt,"enter vendor name", "THD DEMO CA");
			clickElementWithWait(search_btn, "click on the search vendor button from menu"); 
			wait(2);
			clickElementWithWait(thdDemoCA_link, "click on the vendor name");
			reportLog(Status.PASS, "vendor selected as THD demo ca", true);
			break;
			case 1:
			EnterText(vendorName_txt,"enter vendor name", "amritavendor1");
			clickElementWithWait(search_btn, "click on the search vendor button from menu"); 
			wait(2);
			clickElementWithWait(amritavendor1_link, "click on the vendor name");
			reportLog(Status.PASS, "vendor selected as amritavendor1", true);

			break;
			}
			count++;
			
		}
		catch(Exception e) {
			
		}
	}
	
	public void addPersonHomeDepo() {
		try { 
			
			if(randomFirstName==null) { 
		 randomFirstName = _dataRepo.getData("firstName")+Random_StringGenerator(4);
		 ssnNumber = "878" + Random_NumberGenerator(6);
			
			fName=randomFirstName ;
			ssnExisting=ssnNumber;
			System.out.println("print fname "+ fName);
			}
			wait(2);
		clickElementWithWait(caPerson.peopleMenuHD_btn, "click on the people button from menu");
		wait(2);
		clickElementWithWait(caPerson.addPersonHD_btn, "click on the add perosn button from people menu");
		
		EnterText(caPerson.legalfirstName_field, "enter first name",randomFirstName ); 
		EnterText(caPerson.legalLastName_field, "enter last name",_dataRepo.getData("lastName"));
		wait(2);
		clickElementWithWait(caPerson.middleNameYes_radioBtn, "click on middle name yes radion button");
		EnterText(caPerson.middleName, "enter middle name", _dataRepo.getData("middleName"));
		EnterText(caPerson.ssn, "enter ssn", ssnNumber);
	
		EnterText(caPerson.dob, "enter dob", _dataRepo.getData("dob"));
		EnterText(caPerson.email, "enter email", _dataRepo.getData("email"));
		clickElementWithWait(caPerson.typeHomeDepo, "click on person type");
		selectDropDownByValue(caPerson.typeHomeDepo, "E", "click to select the type");
		selectDropDownByIndex(caPerson.vendorLocations_drpdown, "1", "location");
		EnterText(caPerson.address1_field, "enter address details", _dataRepo.getData("address1"));	
		EnterText(caPerson.cityHomeDepo_txt, "enter city name", _dataRepo.getData("city"));
		selectDropDownByValue(caPerson.state_dropdown, _dataRepo.getData("stateCode"),"select state");
		EnterText(caPerson.zipCode, "enter zip code", _dataRepo.getData("pin")); 	
		wait(2);
		takeScreenshot();
		 	
		clickElementWithWait(caPerson.saveAddPersonHD_btn, "click on save button");
		wait(1);
		if(driver.findElement(caPerson.ignoreAddress_chkBox).isDisplayed()) {
			clickElementWithWait(caPerson.ignoreAddress_chkBox, "click on ignore address checkbox");
			clickElementWithWait(caPerson.saveAddPersonHD_btn, "click on save button");
		}
		
		takeScreenshot();
		Assert.assertTrue("Person should be added and it should navigate to person status page",driver.findElement(titlePersonStatusPage).isDisplayed() );
		reportLog(Status.PASS, "New person added", true);

		}catch(Exception e) {
    		}
		
	}
	
	public void validateAddPersonWithSameSsn() {
		try { 	
		 String firstNameForSsn = _dataRepo.getData("firstName")+Random_StringGenerator(4);			
		wait(2);
		clickElementWithWait(caPerson.peopleMenuHD_btn, "click on the people button from menu");
		wait(2);
		clickElementWithWait(caPerson.addPersonHD_btn, "click on the add perosn button from people menu");
		
		EnterText(caPerson.legalfirstName_field, "enter first name",firstNameForSsn ); 
		EnterText(caPerson.legalLastName_field, "enter last name",_dataRepo.getData("lastName"));
		wait(2);
		clickElementWithWait(caPerson.middleNameYes_radioBtn, "click on middle name yes radion button");
		EnterText(caPerson.middleName, "enter middle name", _dataRepo.getData("middleName"));
		EnterText(caPerson.ssn, "enter ssn", ssnNumber);
		
		EnterText(caPerson.dob, "enter dob", _dataRepo.getData("dob"));
		EnterText(caPerson.email, "enter email", _dataRepo.getData("email"));
	//	clickElementWithWait(caPerson.typeHomeDepo, "click on type dropdown");
		
		
		selectDropDownByValue(caPerson.typeHomeDepo, "E", "click to select the type");
		selectDropDownByIndex(caPerson.vendorLocations_drpdown, "1", "location");
		EnterText(caPerson.address1_field, "enter address details", _dataRepo.getData("address1"));	
		EnterText(caPerson.cityHomeDepo_txt, "enter city name", _dataRepo.getData("city"));
		selectDropDownByValue(caPerson.state_dropdown, _dataRepo.getData("stateCode"),"select state");
		EnterText(caPerson.zipCode, "enter zip code", _dataRepo.getData("pin")); 	
		wait(2);
		takeScreenshot();
		 	
		clickElementWithWait(caPerson.saveAddPersonHD_btn, "click on save button");
		wait(1);
		System.out.println("VALIDATIENG ADD PERSON WITH SAME SSN");
		verifySsnErrorMsg(); // verify SSN error message

		if(driver.findElement(caPerson.ignoreAddress_chkBox).isDisplayed()) {
			clickElementWithWait(caPerson.ignoreAddress_chkBox, "click on ignore address checkbox");
			clickElementWithWait(caPerson.saveAddPersonHD_btn, "click on save button");
		}
		verifySsnErrorMsg(); // verify SSN error message
		
		
		reportLog(Status.PASS, "Adding the person with same ssn verifeid", true);

		}catch(Exception e) {
    		}
		
	}
	
	public void verifySsnErrorMsg() {
		try {
			String errorMsgSsnPresent = driver.findElement(errorMsgSsn_txt).getText();
			String errorMsgSsn = "This SSN for an employee (" +ssnNumber+") already exists.";
			Assert.assertTrue("This SSN already exists message should be displayed",errorMsgSsnPresent.equals(errorMsgSsn) );
			System.out.println("SSN ERROR MESSAGE VERIFIED");
			reportLog(Status.PASS, "ssn error message verifeid", true);

			}
			catch(Exception e) {}
		
	}
	
	// verify the tile here
		//==================
	
	public void rosterAddPersonValidation(String condition) {
		try {
			
			switch(condition) {
			case "Yes":
			Assert.assertTrue("Yes button in roster should be present",driver.findElement(caPerson.yesRosterHD_btn).isDisplayed() );
			wait(2);
			takeScreenshot();
			clickElementWithWait(caPerson.yesRosterHD_btn, "click on continue button");
			Assert.assertTrue("It should navigate to person status page",driver.findElement(titlePersonStatusPage).isDisplayed() );
			reportLog(Status.PASS, "Yes button in roster verifeid and person is added", true);

			break;
			
			case "No":
			Assert.assertTrue("No button in roster should be present",driver.findElement(caPerson.yesRosterHD_btn).isDisplayed() );
			wait(2);
			takeScreenshot();
			clickElementWithWait(caPerson.noRosterHD_btn, "click on continue button");
			
			Assert.assertTrue("It should navigate to person status page",driver.findElement(titlePeopleSearch).isDisplayed() );
			reportLog(Status.PASS, "No button in roster verifeid", true);

			break;

			}
			
	}catch(Exception e) {
		
	
		}
	}
	
	public void personStatusValidation() {
		try {
			clickElementWithWait(editInformation_btn, "click on edit information");
			selectDropDownByValue(activeStatus_dropdown, "610", "select active from the dropdown by value");
			verifyElementPresence(oneToMany_dtxt);
			clickElementWithWait(removeFromRoster_btn, "click on the remove from roaster button");
			driver.switchTo().alert().dismiss();
			clickElementWithWait(removeFromRoster_btn, "click on the remove from roaster button");
			driver.switchTo().alert().accept();
			reportLog(Status.PASS, "remove from roster button verified", true);
			String msgRemoveRoster1 = "An individual"; 
			String msgRemoveRoster2= "is successfully removed from Vendor's Roster.";
			
			String msgRemoveRosterPresent = driver.findElement(errorMsgVendorRoster_txt).getText();
			System.out.println("print roster msg ========================= "+msgRemoveRosterPresent);
			System.out.println("roster remove msg displayed===================");
			Assert.assertTrue(msgRemoveRosterPresent.contains(msgRemoveRoster1) && msgRemoveRosterPresent.contains(msgRemoveRoster2));
			reportLog(Status.PASS, "remove from roster message verified", true);
		}catch(Exception e) {
			
		}
	} 
	
}
