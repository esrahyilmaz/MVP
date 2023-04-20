package pages;

import Utility.ExcelReader;
import com.aventstack.extentreports.Status;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import seleniumhelper.BaseClass;

public class CAExistingPerson extends BaseClass {
	ExcelReader _dataRepo = new ExcelReader();
	CAAddPerson caPerson= new CAAddPerson();
	CAPersonalPage caPeople=new CAPersonalPage();
	CAPersonStatus caPersonStatus =  new CAPersonStatus();
	CAPackages caPackage = new CAPackages();
				
	
	 By addExistingPerson_btn = By.xpath("//a[contains(text(),'Add Existing Person')]");
	 By legalfirstName = By.xpath("//input[@name='firstName']");
	 By middleName = By.xpath("//input[@name='middleName']");
	 By legalLastName_field = By.xpath("//input[@id='lastName']");
	 By middleNameYes_radioBtn = By.xpath("//input[@name='middleNmeRequired' and @value='Y']");
	 By middleNameNo_radioBtn = By.xpath("//input[@name='middleNmeRequired' and @value='N']");
	 By ssn = By.xpath("//input[@name='ssn']");
	 By dob = By.xpath("//input[@name='dob']");
	 By email = By.xpath("//input[@name = 'email']");
	 By mobileNumber = By.xpath("//input[@name='mobileNumber']");
	 By vendorLocations_drpdown = By.xpath("//select[@name='locationId']");//select by index 1
	 By signature_field = By.xpath("//input[@name='signatureName']");
	 By save_btn = By.xpath("//input[@value='SAVE']");
	 By lastName_ps = By.xpath("//input[@name='lastName']");
	 By warning1_txt = By.xpath("//*[@id='peopleForm']/span/b[1]/text()");
	 By warning2_txt = By.xpath("//*[@id=\"peopleForm\"]/span/b[2]");

	 
	 //	--->	error message
	
	 By errorMsgAddExistingPerosn = By.xpath("//form/div[@id='errorMessages']");
	
	 //person status detail page
	
	 By legalfirstName_Validate = By.xpath("//input[@name='firstName']");
	 By middleName_Validate = By.xpath("//input[@name='middleName']");
	 By legalLastName_field_Validate = By.xpath("//input[@id='lastName']");
	 By middleNameYes_radioBtn_Validate = By.xpath("//input[@name='middleNmeRequired' and @value='Y']");
	 By middleNameNo_radioBtn_Validate = By.xpath("//input[@name='middleNmeRequired' and @value='N']");
	 By ssn_Validate = By.xpath("//input[@name='ssn']");
	 By dob_Validate = By.xpath("//input[@name='dob']");
	 By email_Validate = By.xpath("//input[@name = 'email']");
	 By dlNumberTxt=By.xpath("//*[@id=\"peopleFormTable\"]/tbody/tr[16]/td[2]/input[1]");
	 By dlStateDdl=By.xpath("//*[@id=\"peopleFormTable\"]/tbody/tr[17]/td[2]/select");
	 By tablePersonDetail_Validate = By.xpath("//table[@class='detail']");
	 
	 public String getTextInformationfromUI() {
			String PersonInformationText="return document.querySelector(\"form span b:nth-child(1)\").textContent;";
			String infoText=null;
			JavascriptExecutor js=(JavascriptExecutor)driver;
			infoText=(String)js.executeScript(PersonInformationText);
			return infoText;
																					
		}   
	 
	 
	 public void addExistingPerson() {
			try {
				
				wait(2);
				clickElementWithWait(caPerson.peopleMenuHD_btn, "click on the people button from menu");
				clickElementWithWait(addExistingPerson_btn, "click on the add perosn button from people menu");
				
				EnterText(legalfirstName, "enter first name",CAOneToManyHD.randomFirstName ); 
				EnterText(legalLastName_field, "enter last name",_dataRepo.getData("lastName"));
				
				clickElementWithWait(middleNameYes_radioBtn, "click on middle name yes radion button");
				EnterText(middleName, "enter middle name", _dataRepo.getData("middleName"));
				
				EnterText(ssn, "enter ssn", CAOneToManyHD.ssnNumber);
//				EnterText(dlNumberTxt, "Entered DL Number", Random_NumberGenerator(10));
//				selectDropDown(dlStateDdl, _dataRepo.getData("State"), "Selected State from drop down");
				EnterText(caPerson.dob, "enter dob", _dataRepo.getData("dob"));
				EnterText(caPerson.email, "enter email", _dataRepo.getData("email"));
				selectDropDownByIndex(vendorLocations_drpdown, "1", "vendor location");
				EnterText(signature_field, "enter the full name for signature", CAOneToManyHD.randomFirstName+_dataRepo.getData("middleName")+_dataRepo.getData("lastName"));	
							 	
				clickElementWithWait(save_btn, "click on save button");
				
				if(driver.findElement(caPerson.ignoreAddress_chkBox).isDisplayed()) {
					clickElementWithWait(caPerson.ignoreAddress_chkBox, "click on ignore address checkbox");
					clickElementWithWait(caPerson.saveAddPersonHD_btn, "click on save button");
				}
				reportLog(Status.PASS, "Existing person is added", true);

				
		}catch(Exception e) {
			}
		}
	 
	 public void addExistingPersonWithoutAlreadyExisting() {
			try {
				 String firstName = _dataRepo.getData("firstName")+Random_StringGenerator(4);
				 String ssnNumber = "87878" + Random_NumberGenerator(4);
				wait(2);
				clickElementWithWait(caPerson.peopleMenuHD_btn, "click on the people button from menu");
				clickElementWithWait(addExistingPerson_btn, "click on the add perosn button from people menu");
				
				EnterText(legalfirstName, "enter first name",firstName ); 
				EnterText(legalLastName_field, "enter last name",_dataRepo.getData("lastName"));
				wait(2);
				clickElementWithWait(middleNameYes_radioBtn, "click on middle name yes radion button");
				EnterText(middleName, "enter middle name", _dataRepo.getData("middleName"));
				
				EnterText(ssn, "enter ssn", ssnNumber);
			
				EnterText(caPerson.dob, "enter dob", _dataRepo.getData("dob"));
				EnterText(caPerson.email, "enter email", _dataRepo.getData("email"));
				selectDropDownByIndex(vendorLocations_drpdown, "1", "vendor location");
				EnterText(signature_field, "enter the full name for signature", firstName +_dataRepo.getData("middleName")+_dataRepo.getData("lastName"));	
				
				 	
				clickElementWithWait(save_btn, "click on save button");
				String errorMsg = "Cannot find any match.";
				String verifyErrorMsg = driver.findElement(errorMsgAddExistingPerosn).getText();
				Assert.assertTrue("'Can not find any match' message should be present",errorMsg.equals(verifyErrorMsg));
				reportLog(Status.PASS, " Add existing person without previously existing verified ", true);
	
				
		}catch(Exception e) {
			}
		}
	 
	 public void verifyAddExistingPerson() {
		 String ssnCheck = (CAOneToManyHD.ssnNumber).substring(6);
		 String dobCheck = _dataRepo.getData("dob").substring(0, 2);
		 String addressCheck = _dataRepo.getData("address1").substring(1, 18);
	//	 String stateCodeCheck =  _dataRepo.getData("state").substring(6);
		 String pinCheck = _dataRepo.getData("pin").substring(0,5);
		
		 System.out.println("ssn and dob  ======== " +ssnCheck+" "+dobCheck);
		 Assert.assertTrue("It should navigate to person status page",driver.findElement(caPerson.titlePersonStatusPage).isDisplayed() );
		takeScreenshot();
		 System.out.println("person added with different vendor");
		 String personDetailValidate = driver.findElement(tablePersonDetail_Validate).getText();
		 System.out.println("print the table details ======================= "+personDetailValidate);
		 Assert.assertTrue("Verify if this contains same first name",personDetailValidate.contains(CAOneToManyHD.randomFirstName) );
		 Assert.assertTrue("Verify if this contains same last name",personDetailValidate.contains(_dataRepo.getData("lastName")) );
		 Assert.assertTrue("Verify if this contains same middle name",personDetailValidate.contains(_dataRepo.getData("middleName")) );
		 Assert.assertTrue("Verify if this contains same ssn",personDetailValidate.contains(ssnCheck));
		 Assert.assertTrue("Verify if this contains sam dob",personDetailValidate.contains(dobCheck));
		 Assert.assertTrue("Verify if this contains same email",personDetailValidate.contains(_dataRepo.getData("email")) );
		 Assert.assertTrue("Verify if this contains same address",personDetailValidate.contains(addressCheck) );

		 Assert.assertTrue("Verify if this contains same city",personDetailValidate.contains( _dataRepo.getData("city")) );
		 Assert.assertTrue("Verify if this contains same state ",personDetailValidate.contains( _dataRepo.getData("state")) );
		 Assert.assertTrue("Verify if this contains same pin",personDetailValidate.contains(_dataRepo.getData("pin")) );
		reportLog(Status.PASS, "Added existing person details verified", true);

	 }
	 
	
	 public void addExistingPersonWithDifferentNameButSameSSN() {
			try {
				 String firstName = _dataRepo.getData("firstName")+Random_StringGenerator(4);
				 String lastName = _dataRepo.getData("lastName")+Random_StringGenerator(4);
				wait(2);
				clickElementWithWait(caPerson.peopleMenuHD_btn, "click on the people button from menu");
				clickElementWithWait(addExistingPerson_btn, "click on the add perosn button from people menu");
				
				EnterText(legalfirstName, "enter first name",firstName ); 
				EnterText(legalLastName_field, "enter last name",lastName);
				wait(2);
				clickElementWithWait(middleNameYes_radioBtn, "click on middle name yes radion button");
				EnterText(middleName, "enter middle name", _dataRepo.getData("middleName"));
				
				EnterText(ssn, "enter ssn", CAOneToManyHD.ssnNumber);
			
				EnterText(caPerson.dob, "enter dob", _dataRepo.getData("dob"));
				EnterText(caPerson.email, "enter email", _dataRepo.getData("email"));
				selectDropDownByIndex(vendorLocations_drpdown, "1", "vendor location");
				EnterText(signature_field, "enter the full name for signature", firstName +_dataRepo.getData("middleName")+_dataRepo.getData("lastName"));	
				clickElementWithWait(save_btn, "click on save button");
				
				String warningMsg1 = " The Name (First and Last),Social Security Number,AND the Date of Birth must be an EXACT match to the existing profile to be located.The system will not allow you to proceed with adding this individual ";
				String warningMsg2 = " to your roster until the information matches exactly. ";
			//	String verifyWarningMsg1 = driver.findElement(warning1_txt).getText();
			//	String verifyWarningMsg2 = driver.findElement(warning2_txt).getText();
				String verifyWarningMsg1 = getTextInformationfromUI();
				System.out.println("Warning from existing person page :>>>>>>  "+verifyWarningMsg1);
			//	String verifyWarningMsg2 = driver.findElement(warning2_txt).getText();

				
				Assert.assertTrue("Warning message should be present",warningMsg1.contains(verifyWarningMsg1));
		//		Assert.assertTrue("Warning message should be present",warningMsg2.contains(verifyWarningMsg2));
				EnterText(ssn, "enter ssn", CAOneToManyHD.ssnNumber);
				String errorMsg = " Cannot find any match. ";
				String verifyErrorMsg = driver.findElement(errorMsgAddExistingPerosn).getText();
				Assert.assertTrue("'Can not find any match' message should be present",errorMsg.contains(verifyErrorMsg));

				reportLog(Status.PASS, " Add existing person with same ssn but different name verified ", true);
	
				
		}catch(Exception e) {
			}
		}
	 
}


