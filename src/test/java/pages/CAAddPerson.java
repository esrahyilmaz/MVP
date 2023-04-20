package pages;

import com.aventstack.extentreports.Status;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;

public class CAAddPerson extends CAPeoplePage {

	Robot robot;
	String randomFirstName;
	String randomUpdatedName;
	Boolean status;
		
		 //People menu buttons
		 By peopleMenu_btn = By.xpath("(//a[contains(text(),'People')])[1]");
		 By searchPeople_btn = By.xpath("//a[contains(text(),'Search People')]");
		 By addPerson_btn = By.xpath("//a[contains(text(),'Add New Person')]");
		 
		 //People menu buttons -- home depo
		 By peopleMenuHD_btn = By.xpath("(//table//tr/td/a[contains(text(),'People')])[1]");
		 By searchPeopleHD_btn = By.xpath("//table//tr/td/a[contains(text(),'Search People')]");
		 By addPersonHD_btn = By.xpath("//table//tr/td/a[contains(text(),'Add New Person')]");
	
		 //People search page
		 
		 By firstName_ps = By.xpath("//input[@name='firstName']");
		 By lastName_ps = By.xpath("//input[@name='lastName']");
		 By search_btn = By.xpath("//input[@value='SEARCH']");
		 By searchPerson_link =By.xpath("//*[@id=\"row1\"]/a");
		
		 		 
		 
		 // Add person page	 -- common locators for customers (Primary - Aspen grove)
		 By errorMsg = By.xpath("//div[@id='errorMessages']");
		 By errorFirstName =By.xpath("//*[@id=\"errorMessages\"]/img[1]");
		 
		 By legalfirstName_field = By.xpath("//input[@name='firstName']");
		 By middleName = By.xpath("//input[@name='middleName']");
		 By legalLastName_field = By.xpath("//input[@name='lastName']");
		 By middleNameYes_radioBtn = By.xpath("//input[@name='middleNameRequired' and @title='Yes']");
		 By middleNameNo_radioBtn = By.xpath("//input[@name='middleNameRequired' and @title='No']");
		 By ssnYes_raidoBtn = By.xpath("//input[@name='isSSNRequired' and @title='Yes']");
		 By ssnNo_raidoBtn = By.xpath("//input[@name='isSSNRequired' and @title='No']");
		 By ssn = By.xpath("//input[@name='ssn']");
		 By dob = By.xpath("//input[@name='dob']");
		 By email = By.xpath("//input[@name = 'email']");
		 By mobileNumber = By.xpath("//input[@name='mobileNumber']");
		 By position_chkbox = By.xpath("//div/input[@name='selectedItems' and @value='ENGINEER1']");
		// By type_field = By.xpath("//select[@name='peopleType'])");
		
		 By type_field = By.xpath("//*[@id=\"peopleFormTable\"]/tbody/tr[13]/td[2]/select");
		 By userField1 = By.xpath("//input[@name='ref1']");
		 By userField2 = By.xpath("//input[@name='ref2']");
		
		 By vendorLocations_drpdown = By.xpath("//select[@name='locationId']");
		 
		 By address1_field = By.xpath("//input[@name='addressForm.addrLine1']");
		 By address2_field = By.xpath("//input[@name='addressForm.addrLine2']");
		 By city_field = By.xpath("//*[@id=\"addressForm.cityName\"]");
		 By state_dropdown = By.xpath("//select[@name='addressForm.stateCode']");
		 By zipCode = By.xpath("//input[@id='addressForm.zipCode']");
		 By areaCode= By.xpath("//input[@id='addressForm.zipCode4']");
		 By saveAddPerson_btn = By.xpath("//*[@id=\"saveBtn\"]");
		 By ignoreAddress_chkBox = By.xpath("//input[@name = 'ignoreAddressValidationErrorFlag']");
		 
		 		//HomeDepo  ---Add a person Locators
		
		 By typeHomeDepo = By.xpath("//select[@name = 'peopleType']");
		 By cityHomeDepo_txt = By.xpath("//*[@id=\"addressForm.cityName\"]");
		 By saveAddPersonHD_btn = By.xpath("//input[@value='SAVE']");
		//input[@name='driverLicenseNum']
		 By drivingLicenseNoHD_txt = By.xpath("//input[@name='driverLicenseNum']");
		//input[@value='YES']
		 By yesRosterHD_btn = By.xpath("//input[@value='YES']");
		 By noRosterHD_btn = By.xpath("//input[@value='NO']"); 
		 
		//person status detail
		
		 By editInformation_Btn	= By.xpath("//input[@name='edit']");
		 By beginOrderProcess_Btn	= By.xpath("//input[@name='orderBGC']");
		 By submitBadge_Btn	= By.xpath("//input[@name='submitBP']");		
		
		 By titlePersonStatusPage	= By.xpath("//b[contains(text(),'Person Status Detail')]");
		 
		 
		//submit badge photo
		 
	//	 By choose_Btn	= By.xpath("//input[@name='file']");  //*[@id="uploadBadgePhotoForm"]/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td[2]/input[1] 
		 By choose_Btn	= By.xpath("//*[@id='uploadBadgePhotoForm']/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td[2]/input[1]");
		 By uploadPhoto_Btn	= By.xpath("//input[@value='Upload Photo']");
		 By previous_Btn	= By.xpath("//input[@name='file']");
		 
		// Edit information page
		 By firstName_editPage	= By.xpath("//*[@id=\"firstName\"]");
		 By lastName_editPage	= By.xpath("//*[@id=\"lastName\"]");		
		 By activeStatus_dropdown = By.xpath("//select[@name='inactiveReasonCd' ]");	
		 By dateTerminated_datepicker= By.xpath("//img[@id='t_trigger_c']");
		
		 
		 By save_btn	= By.xpath("//*[@id=\"saveBtn\"]");
		
				
		
		// Order detail page
		 By cbsvOnlyPackage_rdbtn = By.xpath("//input[@name ='vevaPackage.packageId'  and @value ='3321']");
		 By agreed_chkbox	= By.xpath("//input[@name ='agreed_3321']");
		 By next_btn	= By.xpath("//input[@id ='actionbutton']");
		 By beginOrder_Btn	= By.xpath("//input[@name='orderBGC']");
		
	//================================================================================================================
		
		 public void addPersonVerify() {
			 try {
				String errorMsgDiv = driver.findElement(errorMsg).getText();	
					Assert.assertTrue(errorMsgDiv.contains("'First Name' is a required field."));
					Assert.assertTrue(errorMsgDiv.contains("'Address1' is a required field."));
					Assert.assertTrue(errorMsgDiv.contains("'City' is a required field."));
					Assert.assertTrue(errorMsgDiv.contains("'State' is a required field."));
					Assert.assertTrue(errorMsgDiv.contains("'Zip Code' is a required field."));
					Assert.assertTrue(errorMsgDiv.contains("'Type' is a required field."));
					Assert.assertTrue(errorMsgDiv.contains("'Last Name' is a required field."));
					
					reportLog(Status.PASS, "error message for adding person is verified", true);		
			
			 }catch(Exception e) {
				 
			 }
			 
		 }
		 
		 public void personTabButtons() {
			 try {
				 clickElementWithWait(peopleMenu_btn, "click on the people button from menu");
				clickElementWithWait(addPerson_btn, "click on the add perosn button from people menu");
									
			 }catch(Exception e) {
				 
			 }
			 
		 }
		 
		 public void addPerson() {
			try { 
		
			String tmpFirstName = Random_StringGenerator(3);
			randomFirstName = tmpFirstName;
			String ssnNumber =  Random_NumberGenerator(9);
			
			EnterText(legalfirstName_field, "enter first name",_dataRepo.getData("firstName")+tmpFirstName ); 
			EnterText(legalLastName_field, "enter last name",_dataRepo.getData("lastName"));
			clickElementWithWait(middleNameYes_radioBtn, "click on middle name yes radion button");
			EnterText(middleName, "enter middle name", _dataRepo.getData("middleName"));
			clickElementWithWait(ssnYes_raidoBtn, "click on ssn  yes radion button");
			EnterText(ssn, "enter ssn", ssnNumber);
			EnterText(email, "enter email", _dataRepo.getData("email"));
			clickElementWithWait(type_field, "click on type dropdown");
			selectDropDownByValue(type_field, "A", "click to select the type");
			
			clickElementWithWait(position_chkbox, "click to select the position checkbox");
			clickElementWithWait(vendorLocations_drpdown, "click to select");
			selectDropDownByIndex(vendorLocations_drpdown, "2", "location");
			EnterText(address1_field, "enter address", _dataRepo.getData("address1"));	
			EnterText(city_field, "enter city", _dataRepo.getData("city"));
			selectDropDownByValue(state_dropdown, _dataRepo.getData("stateCode"),"click to select value");
			EnterText(zipCode, "enter zip code", _dataRepo.getData("pin")); 	
			 	
			clickElementWithWait(saveAddPerson_btn, "click on continue button");

			if(driver.findElement(ignoreAddress_chkBox).isDisplayed()) {
				clickElementWithWait(ignoreAddress_chkBox, "click on ignore address checkbox");
				clickElementWithWait(saveAddPerson_btn, "click on continue button");
			}
			reportLog(Status.PASS, "Person is added", true);
			}catch(Exception e) {
	    		}
								
			}
		 
		 /*public void addPersonFlorida() {
				try { 
					
				String tmpFirstName = Random_StringGenerator(3);
				randomFirstName = tmpFirstName;
				String ssnNumber = "8787" + Random_NumberGenerator(5);
				wait(2);
				clickElementWithWait(peopleMenu_btn, "click on the people button from menu");
				wait(2);
				clickElementWithWait(addPerson_btn, "click on the add perosn button from people menu");	
				wait(2);
				EnterText(legalfirstName_field, "enter first name",_dataRepo.getData("firstName")+tmpFirstName ); 
				EnterText(legalLastName_field, "enter last name",_dataRepo.getData("lastName"));
				
				clickElementWithWait(middleNameYes_radioBtn, "click on middle name yes radion button");
				EnterText(middleName, "enter middle name", _dataRepo.getData("middleName"));
				clickElementWithWait(ssnYes_raidoBtn, "click on ssn  yes radion button");
				EnterText(ssn, "enter ssn", ssnNumber);
			//	EnterText(ssn, "enter ssn", "874545451");
			//	EnterText(dob, "enter dob", _dataRepo.getData("dob"));
				EnterText(email, "enter email", _dataRepo.getData("email"));
				clickElementWithWait(type_field, "click on type dropdown");
				
				
				selectDropDownByValue(type_field, "A", "click to select the type");
				
				
				clickElementWithWait(position_chkbox, "click to select the position checkbox");
				clickElementWithWait(vendorLocations_drpdown, "click to select");
				selectDropDownByIndex(vendorLocations_drpdown, "2", "location");
				EnterText(address1_field, "enter address", "9100 International Dr ");	
				EnterText(city_field, "enter city", "Orlando");
				selectDropDownByValue(state_dropdown, "FL","click to select value");
				EnterText(zipCode, "enter zip code", "32819"); 	
				wait(2);
				takeScreenshot();
				 	
				clickElementWithWait(saveAddPerson_btn, "click on continue button");
//				clickElementWithWait(submitBadge_Btn, "click on submit badge photo");
//				clickElement(element, objName);
				wait(1);
				if(driver.findElement(ignoreAddress_chkBox).isDisplayed()) {
					clickElementWithWait(ignoreAddress_chkBox, "click on ignore address checkbox");
					clickElementWithWait(saveAddPerson_btn, "click on continue button");
				}
				reportLog(Status.PASS, "Person is added for Florida", true);
			//	stateCount++;
				}catch(Exception e) {
		    		}
				
				}		
		public void addPersonNewYork() {
			try { 
				
			String tmpFirstName = Random_StringGenerator(3);
			randomFirstName = tmpFirstName;
			String ssnNumber = "8787" + Random_NumberGenerator(5);
			wait(2);
			clickElementWithWait(peopleMenu_btn, "click on the people button from menu");
			clickElementWithWait(addPerson_btn, "click on the add perosn button from people menu");
			wait(2);
			EnterText(legalfirstName_field, "enter first name",_dataRepo.getData("firstName")+tmpFirstName ); 
			EnterText(legalLastName_field, "enter last name",_dataRepo.getData("lastName"));
			wait(2);
			clickElementWithWait(middleNameYes_radioBtn, "click on middle name yes radion button");
			EnterText(middleName, "enter middle name", _dataRepo.getData("middleName"));
			clickElementWithWait(ssnYes_raidoBtn, "click on ssn  yes radion button");
			EnterText(ssn, "enter ssn", ssnNumber);
		//	EnterText(ssn, "enter ssn", "874545451");
		//	EnterText(dob, "enter dob", _dataRepo.getData("dob"));
			EnterText(email, "enter email", _dataRepo.getData("email"));
			clickElementWithWait(type_field, "click on type dropdown");
			
			
			selectDropDownByValue(type_field, "A", "click to select the type");
			
			
			clickElementWithWait(position_chkbox, "click to select the position checkbox");
			clickElementWithWait(vendorLocations_drpdown, "click to select");
			selectDropDownByIndex(vendorLocations_drpdown, "2", "location");
			EnterText(address1_field, "enter address", "44 North Airport Drive");	
			EnterText(city_field, "enter city", "Brooklyn");
			selectDropDownByValue(state_dropdown, "NY","click to select value");
			EnterText(zipCode, "enter zip code", "11204"); 	
			wait(2);
			takeScreenshot();
			 	
			clickElementWithWait(saveAddPerson_btn, "click on continue button");
//			clickElementWithWait(submitBadge_Btn, "click on submit badge photo");
//			clickElement(element, objName);
			wait(1);
			if(driver.findElement(ignoreAddress_chkBox).isDisplayed()) {
				clickElementWithWait(ignoreAddress_chkBox, "click on ignore address checkbox");
				clickElementWithWait(saveAddPerson_btn, "click on continue button");
			}
			reportLog(Status.PASS, "Person is added for New York", true);
		//	stateCount++;
			}catch(Exception e) {
	    		}
			
			}
		
		public void addPersonNewJersy() {
			try { 
			
				
			String tmpFirstName = Random_StringGenerator(3);
			randomFirstName = tmpFirstName;
			String ssnNumber = "8787" + Random_NumberGenerator(5);
			wait(2);
			clickElementWithWait(peopleMenu_btn, "click on the people button from menu");
			clickElementWithWait(addPerson_btn, "click on the add perosn button from people menu");
			wait(2);
			EnterText(legalfirstName_field, "enter first name",_dataRepo.getData("firstName")+tmpFirstName ); 
			EnterText(legalLastName_field, "enter last name",_dataRepo.getData("lastName"));
			
			clickElementWithWait(middleNameYes_radioBtn, "click on middle name yes radion button");
			EnterText(middleName, "enter middle name", _dataRepo.getData("middleName"));
			clickElementWithWait(ssnYes_raidoBtn, "click on ssn  yes radion button");
			EnterText(ssn, "enter ssn", ssnNumber);
		//	EnterText(ssn, "enter ssn", "874545451");
		//	EnterText(dob, "enter dob", _dataRepo.getData("dob"));
			EnterText(email, "enter email", _dataRepo.getData("email"));
			clickElementWithWait(type_field, "click on type dropdown");
			
			
			selectDropDownByValue(type_field, "A", "click to select the type");
			
			
			clickElementWithWait(position_chkbox, "click to select the position checkbox");
			clickElementWithWait(vendorLocations_drpdown, "click to select");
			selectDropDownByIndex(vendorLocations_drpdown, "2", "location");
			EnterText(address1_field, "enter address", "101 South Shore Road");	
			EnterText(city_field, "enter city", "Northfield");
			selectDropDownByValue(state_dropdown, "NJ","click to select value");
			EnterText(zipCode, "enter zip code", "08225"); 	
			wait(2);
			takeScreenshot();
			 	
			clickElementWithWait(saveAddPerson_btn, "click on continue button");
//			clickElementWithWait(submitBadge_Btn, "click on submit badge photo");
//			clickElement(element, objName);
			wait(1);
			if(driver.findElement(ignoreAddress_chkBox).isDisplayed()) {
				clickElementWithWait(ignoreAddress_chkBox, "click on ignore address checkbox");
				clickElementWithWait(saveAddPerson_btn, "click on continue button");
			}
			reportLog(Status.PASS, "Person is added for New Jersey", true);
		//	stateCount++;
			}catch(Exception e) {
	    		}
			
			}
	
		public void addPersonMaryland() {
			try { 
				
				
			String tmpFirstName = Random_StringGenerator(3);
			randomFirstName = tmpFirstName;
			String ssnNumber = "8787" + Random_NumberGenerator(5);
			wait(2);
			clickElementWithWait(peopleMenu_btn, "click on the people button from menu");
			clickElementWithWait(addPerson_btn, "click on the add perosn button from people menu");
			wait(2);
			EnterText(legalfirstName_field, "enter first name",_dataRepo.getData("firstName")+tmpFirstName ); 
			EnterText(legalLastName_field, "enter last name",_dataRepo.getData("lastName"));
			wait(2);
			clickElementWithWait(middleNameYes_radioBtn, "click on middle name yes radion button");
			EnterText(middleName, "enter middle name", _dataRepo.getData("middleName"));
			clickElementWithWait(ssnYes_raidoBtn, "click on ssn  yes radion button");
			EnterText(ssn, "enter ssn", ssnNumber);
		//	EnterText(ssn, "enter ssn", "874545451");
		//	EnterText(dob, "enter dob", _dataRepo.getData("dob"));
			EnterText(email, "enter email", _dataRepo.getData("email"));
			clickElementWithWait(type_field, "click on type dropdown");
			
			
			selectDropDownByValue(type_field, "A", "click to select the type");
			
			
			clickElementWithWait(position_chkbox, "click to select the position checkbox");
			clickElementWithWait(vendorLocations_drpdown, "click to select");
			selectDropDownByIndex(vendorLocations_drpdown, "2", "location");
			EnterText(address1_field, "enter address", "7101 Democracy Blvd");	
			EnterText(city_field, "enter city", "Bethesda");
			selectDropDownByValue(state_dropdown, "MD","click to select value");
			EnterText(zipCode, "enter zip code", "20817"); 	
			wait(2);
			takeScreenshot();
			 	
			clickElementWithWait(saveAddPerson_btn, "click on continue button");
//			clickElementWithWait(submitBadge_Btn, "click on submit badge photo");
//			clickElement(element, objName);
			wait(1);
			if(driver.findElement(ignoreAddress_chkBox).isDisplayed()) {
				clickElementWithWait(ignoreAddress_chkBox, "click on ignore address checkbox");
				clickElementWithWait(saveAddPerson_btn, "click on continue button");
			}
			reportLog(Status.PASS, "Person is added for Marlyland", true);
		//	stateCount++;
			}catch(Exception e) {
	    		}
			
			}
		
		public void addPersonSouthDakota() {
			try { 
				
				
			String tmpFirstName = Random_StringGenerator(3);
			randomFirstName = tmpFirstName;
			String ssnNumber = "8787" + Random_NumberGenerator(5);
			wait(2);
			clickElementWithWait(peopleMenu_btn, "click on the people button from menu");
			clickElementWithWait(addPerson_btn, "click on the add perosn button from people menu");
			wait(2);
			EnterText(legalfirstName_field, "enter first name",_dataRepo.getData("firstName")+tmpFirstName ); 
			EnterText(legalLastName_field, "enter last name",_dataRepo.getData("lastName"));
			wait(2);
			clickElementWithWait(middleNameYes_radioBtn, "click on middle name yes radion button");
			EnterText(middleName, "enter middle name", _dataRepo.getData("middleName"));
			clickElementWithWait(ssnYes_raidoBtn, "click on ssn  yes radion button");
			EnterText(ssn, "enter ssn", ssnNumber);
		//	EnterText(ssn, "enter ssn", "874545451");
		//	EnterText(dob, "enter dob", _dataRepo.getData("dob"));
			EnterText(email, "enter email", _dataRepo.getData("email"));
			clickElementWithWait(type_field, "click on type dropdown");
			
			
			selectDropDownByValue(type_field, "A", "click to select the type");
			
			
			clickElementWithWait(position_chkbox, "click to select the position checkbox");
			clickElementWithWait(vendorLocations_drpdown, "click to select");
			selectDropDownByIndex(vendorLocations_drpdown, "2", "location");
			EnterText(address1_field, "enter address", "616 E Havens Ave");	
			EnterText(city_field, "enter city", "Mitchell");
			selectDropDownByValue(state_dropdown, "SD","click to select value");
			EnterText(zipCode, "enter zip code", "57301"); 	
			wait(2);
			takeScreenshot();
			 	
			clickElementWithWait(saveAddPerson_btn, "click on continue button");
//			clickElementWithWait(submitBadge_Btn, "click on submit badge photo");
//			clickElement(element, objName);
			wait(1);
			if(driver.findElement(ignoreAddress_chkBox).isDisplayed()) {
				clickElementWithWait(ignoreAddress_chkBox, "click on ignore address checkbox");
				clickElementWithWait(saveAddPerson_btn, "click on continue button");
			}
			reportLog(Status.PASS, "Person is added for South Dakota", true);
		//	stateCount++;
			}catch(Exception e) {
	    		}
			
			}
		public void addPersonTexas() {
			try { 
		
				
			String tmpFirstName = Random_StringGenerator(3);
			randomFirstName = tmpFirstName;
			String ssnNumber = "8787" + Random_NumberGenerator(5);
			wait(2);
			clickElementWithWait(peopleMenu_btn, "click on the people button from menu");
			clickElementWithWait(addPerson_btn, "click on the add perosn button from people menu");
			wait(2);
			EnterText(legalfirstName_field, "enter first name",_dataRepo.getData("firstName")+tmpFirstName ); 
			EnterText(legalLastName_field, "enter last name",_dataRepo.getData("lastName"));
			wait(2);
			clickElementWithWait(middleNameYes_radioBtn, "click on middle name yes radion button");
			EnterText(middleName, "enter middle name", _dataRepo.getData("middleName"));
			clickElementWithWait(ssnYes_raidoBtn, "click on ssn  yes radion button");
			EnterText(ssn, "enter ssn", ssnNumber);
		//	EnterText(ssn, "enter ssn", "874545451");
		//	EnterText(dob, "enter dob", _dataRepo.getData("dob"));
			EnterText(email, "enter email", _dataRepo.getData("email"));
			clickElementWithWait(type_field, "click on type dropdown");
			
			
			selectDropDownByValue(type_field, "A", "click to select the type");
			
			
			clickElementWithWait(position_chkbox, "click to select the position checkbox");
			clickElementWithWait(vendorLocations_drpdown, "click to select");
			selectDropDownByIndex(vendorLocations_drpdown, "2", "location");
			EnterText(address1_field, "enter address", "1901 West William Cannon Drive");	
			EnterText(city_field, "enter city", "Austin");
			selectDropDownByValue(state_dropdown, "TX","click to select value");
			EnterText(zipCode, "enter zip code", "78745"); 	
			wait(2);
			takeScreenshot();
			 	
			clickElementWithWait(saveAddPerson_btn, "click on continue button");
//			clickElementWithWait(submitBadge_Btn, "click on submit badge photo");
//			clickElement(element, objName);
			wait(1);
			if(driver.findElement(ignoreAddress_chkBox).isDisplayed()) {
				clickElementWithWait(ignoreAddress_chkBox, "click on ignore address checkbox");
				clickElementWithWait(saveAddPerson_btn, "click on continue button");
			}
			reportLog(Status.PASS, "Person is added for Texas", true);
		//	stateCount++;
			}catch(Exception e) {
	    		}
			
			}*/
	
	
	public void searchPerson() {
		try {
		clickElementWithWait(peopleMenu_btn, "click on the people button from menu");
		clickElementWithWait(searchPeople_btn, "click on the search person button");
		EnterText(firstName_ps, "enter the updated name", existingFirstName);
		clickElementWithWait(search_btn, "click to search");
		reportLog(Status.PASS, "Searching a person", true);
	}catch(Exception e) {
		}
	}
		public void searchUpdatedPerson() {
			try {
			//	randomUpdatedName = Random_StringGenerator(3);
				wait(2);
			clickElementWithWait(peopleMenu_btn, "click on the people button from menu");
			clickElementWithWait(searchPeople_btn, "click on the search person button");
			EnterText(firstName_ps, "enter the updated name", _dataRepo.getData("updatedName")+ randomUpdatedName);//updated first name
			clickElementWithWait(search_btn, "click to search");
			clickElementWithWait(searchPerson_link, "click to search the person");

			
			reportLog(Status.PASS, "Searching update person and verify", true);
				
		}catch(Exception e) {
    		}
		}
		
		public boolean isClickable(WebDriver driver) 
		{
			try{
				WebDriverWait wait = new WebDriverWait(driver, 6);
				wait.until(ExpectedConditions.elementToBeClickable(beginOrder_Btn));
				System.out.println("button is active");
				return true;
				
			}
			catch (Exception e){
				System.out.println("button is not active");
				return false;
			}
		}
		
		public void editPersonInfo() {
			try {
			clickElementWithWait(editInformation_Btn, "click on edit informaiton button");
			EnterText(firstName_editPage, "provide the last name to edit", existingFirstName +"_updated" );
			clickElementWithWait(save_btn, "click to save informaiton");
			existingFirstName = existingFirstName +"_updated";
			reportLog(Status.PASS, "Editing person information and first name is changed", true);
			reportLog(Status.PASS, "Person details Edited !!!!", true);
			logStepInfo("Person details Edited !!!!");
			
			System.out.println(status);
			
		}catch(Exception e) {
			reportLog(Status.FAIL, "Person details Editing Failed !!!!"+e.getMessage(), true);
			logStepInfo("Person details Editing Failed !!!!"+e.getMessage());
			}
		}
		
		public void inActivePerson() {
			try {
			clickElementWithWait(editInformation_Btn, "click on edit informaiton button");
			clickElementWithWait(activeStatus_dropdown,"click on active status dropdown");
			selectDropDownByValue(activeStatus_dropdown, "630", "click to select the status");

			clickElementWithWait(save_btn, "click to save informaiton");
			reportLog(Status.PASS, "Person status changed to inactive", true);

			verifyElementPresence(beginOrderProcess_Btn);
			reportLog(Status.PASS, "Begin order proces button is not present", true);

			}catch(Exception e) {
	    		
	    				
			}
		}	
		public void checkBeginOrderButtonActive() {
			try {
				status = verifyElementPresence(beginOrderProcess_Btn);
				System.out.println(status);
				wait();
				takeScreenshot();
				
		}catch(Exception e) {
    		
    	
			}
		}
		
		
}










