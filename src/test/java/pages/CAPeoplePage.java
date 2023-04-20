package pages;

import Utility.CurrentDateTime;
import Utility.ExcelReader;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import seleniumhelper.BaseClass;

public class CAPeoplePage extends BaseClass {
	ExcelReader _dataRepo = new ExcelReader();
	// -------------------------Page Button-------------------------//
	By searchBtn = By.xpath("//*[@id='peopleSearchForm']/input[8]");
	public By saveBtn = By.xpath("//*[@id=\"saveBtn\"]");
	// -------------------------Page Links-------------------------//
	By peopleNameLink = By.xpath("//*[@id='row1']/a");
	By peopleName2Link = By.xpath("//*[@id=\"row3\"]/a");
	By compliantStatusDDl = By.xpath("//*[@id=\"peopleSearchForm\"]/table/tbody/tr[4]/td[2]/select");
	By peopleMenuBtn = By.xpath("//*[@id=\"menuHeaderId\"]/tbody/tr/td[3]/a");
	By searchpeopleMenuBtn = By.xpath("//*[@id=\"menu3\"]/table/tbody/tr[1]/td/a");
	By addNewPeopleMenuBtn = By.xpath("//*[@id=\"menu3\"]/table/tbody/tr[2]/td/a");
	By addExistingPeopleMenuBtn = By.xpath("//*[@id=\"menu3\"]/table/tbody/tr[3]/td/a");
	// -------------------------Page Button-------------------------//
	By vendorNameLbl = By.xpath("//*[@id='peopleSearchForm']/table/tbody/tr[1]/td[2]/b");

	// -------------------------Page Button-------------------------//
	By searchFirstName = By.xpath("//*[@id=\"firstName\"]");
	By searchLastNameTxt = By.xpath("//*[@id=\"lastName\"]");

	/** Add New user to People ***/
	public By firstNameTxt = By.xpath("//*[contains(text(),'First Name')]/following::td[1]/input[1]");

	public By middleNameYRadio = By.xpath("//*[@id=\"peopleFormTable\"]/tbody/tr[3]/td[2]/input[1]");
	public By middleNameNRadio = By.xpath("//*[@id=\"peopleFormTable\"]/tbody/tr[3]/td[2]/input[2]");

	public By middleNameTxt = By.xpath("//*[contains(text(),'Middle Name')]/following::td[1]/input[1]");
	public By lastNameTxt = By.xpath("//*[contains(text(),'Last Name')]/following::td[1]/input[1]");
	public By suffixTxt = By.xpath("//*[contains(text(),'Suffix Name')]/following::td[1]/input[1]");

	public By ssnYRadio = By.xpath("//*[@id=\"peopleFormTable\"]/tbody/tr[8]/td[2]/input[1]");
	public By ssnNRadio = By.xpath("//*[@id=\"peopleFormTable\"]/tbody/tr[3]/td[2]/input[2]");

	public By ssnTxt = By.xpath("//*[contains(text(),'SSN')]/following::td[1]/input[1]");
	public By reEnterSsnTxt = By.xpath("//*[contains(text(),'Re-Enter SSN')]/following::td[1]/input[1]");
	public By dobTxt = By.xpath("//*[contains(text(),'Date of Birth')]/following::td[1]/input[1]");
	public By emailTxt = By.xpath("//*[contains(text(),'Email')]/following::td[1]/input[1]");
	public By mobileTxt = By.xpath("//*[contains(text(),'Mobile Number')]/following::td[1]/input[1]");

	public By typeOtherDdl = By.xpath("//*[@id=\"peopleFormTable\"]/tbody/tr[13]/td[2]/select");
	public By typeHDDdl = By.xpath("//select[@name='peopleType']");
	public By VendorLocation=By.xpath("//select[@name='locationId']");
	public By UserField1TB=By.xpath("//input[@name='ref1']");
	public By UserField2TB=By.xpath("//input[@name='ref2']");

	public By vBusinessAreaNONHD = By.xpath("//select[@name='ref2']");    // Lockheed Martin Business Area
	public By vLocationNONHD = By.xpath("//select[@name='userField3']");  // Lockheed Martin Location
	
	public By countryDdl = By.xpath("//*[@id=\"peopleFormTable\"]/tbody/tr[19]/td[2]/select");

	public By addressTxt = By.xpath("//*[contains(text(),'Address 1')]/following::td[1]/input[1]");
	public By cityTxt = By.xpath("//input[@name='addressForm.cityName']");
	public By stateDdl = By.xpath("//*[@id=\"addressformStateCode\"]/td[2]/select");
	public By zipCodeTxt = By.xpath("//*[contains(text(),'Zip')]/following::td[1]/input[1]");
	
	public By ExistingPersonYesBtn=By.xpath("//*[@value='YES']");
	public By ExistingPersonNoBtn=By.xpath("//*[@value='NO']");
	By ignoreAddress_chkBox = By.xpath("//input[@name = 'ignoreAddressValidationErrorFlag']");
	/** Add Existing user to People ***/
	public By existingEmailTxt = By.xpath("//*[@id=\"peopleFormTable\"]/tbody/tr[8]/td[2]/input");
	public By signatureTxt = By.xpath("//*[@id=\"signatureName\"]");
	public By existingSSNTxt = By.xpath("//*[@id=\"ssn\"]");
	
	public By DlNumberTxt=By.xpath("//*[@name='driverLicenseNum']");
	public By DlNumberState=By.xpath("//*[@name='driverLicenseState']");

	public static String LastName="";
	public static int count=1;
	

	public void addNewPeople() throws Exception {
		
		try {
		String FirstName = _dataRepo.getData("FirstName") + Random_StringGenerator(8);
		String ssnNumber = Random_NumberGenerator(9);
		if(scenarioName.contains("BatchOrder")) {
			String date=CurrentDateTime.getDate().replaceAll("-", "");
		LastName = _dataRepo.getData("LastName")+date;	
		}else {
		LastName = _dataRepo.getData("LastName") + Random_StringGenerator(8);
		}
		String phoneNumber = Random_NumberGenerator(10);

		EnterText(firstNameTxt, "First Name entered", FirstName);
		EnterText(lastNameTxt, "Last Name Entered", LastName);
		
		clickElementWithWait(middleNameYRadio, "click on middle name yes radion button");
		EnterText(middleNameTxt, "enter middle name", LastName);

		if (verifyElementPresence(ssnYRadio))
			clickElementWithWait(ssnYRadio, "Clicked on Yes Radio button");
		EnterText(ssnTxt, "SSN Entered", ssnNumber);
		if(verifyElementPresence(reEnterSsnTxt)) {
			EnterText(reEnterSsnTxt, "SSN Re-Entered", ssnNumber);
		}
		EnterText(suffixTxt, "Suffix Entered", _dataRepo.getData("Suffix"));
		EnterText(dobTxt, "Date of Birth Entered", _dataRepo.getData("DOB"));
		EmailID=_dataRepo.getData("Email");
		EnterText(emailTxt, "Email ID Entered",EmailID);
		EnterText(mobileTxt, "mobile Number Entered", phoneNumber);
		
		String personType=_dataRepo.getData("PersonType");
		if(scenarioName.contains("NONHD")&&personType.equalsIgnoreCase("Crew")) {
			personType="Employee";
		}else if(scenarioName.contains("NONHD")&&personType==null) {
			personType="Employee";
		}
		if(personType==null) {
			personType="";
		}
		if (verifyElementPresence(typeHDDdl))
			selectDropDown(typeHDDdl,personType , "PersonType selected");
		else if(verifyElementPresence(typeOtherDdl)&&!(personType.equalsIgnoreCase("")))
			selectDropDown(typeOtherDdl,personType , "PersonType selected");
		else
			selectDropDownByIndex(typeOtherDdl, "2", "PersonType selected");
		if (verifyElementPresence(DlNumberTxt)) {
		EnterText(DlNumberTxt, "DL Number Entered", phoneNumber);
		selectDropDown(DlNumberState, (_dataRepo.getData("State")), "State Selected");
		}		
		EnterText(addressTxt, "Address added to textbox", (_dataRepo.getData("Address")));
		EnterText(cityTxt, "City added to textbox", (_dataRepo.getData("City")));
		selectDropDown(stateDdl, (_dataRepo.getData("State")), "State selected From Drop down");
		EnterText(zipCodeTxt, "zip code added to textbox", (_dataRepo.getData("ZipCode")));		
		
		if(verifyElementPresence(VendorLocation)) {
			selectDropDownByIndex(VendorLocation, "1", "Vendor Location");
		}
		
		if(verifyElementPresence(UserField1TB)) {
			EnterText(UserField1TB, "Userfield1", "1");
		}
		
		if(verifyElementPresence(UserField2TB)) {
			EnterText(UserField2TB, "Userfield2", "2");
		}
	
		if(verifyElementPresence(vBusinessAreaNONHD)) {
			selectDropDown(vBusinessAreaNONHD, (_dataRepo.getData("businessArea")), "Business Area Selected");
			if(verifyElementPresence(vLocationNONHD)) {
				selectDropDown(vLocationNONHD, (_dataRepo.getData("vendorLocation")), "Vendor Location Selected");
			}
		}
		
		if(verifyElementPresence(vLocationNONHD)) {
			selectDropDown(vLocationNONHD, (_dataRepo.getData("vendorLocation")), "Vendor Location Selected");
		}
		existingFirstName = FirstName;
		existingLastName = LastName;
		existingphoneNumber = phoneNumber;
		existingssnNumber = ssnNumber;
		existingphoneNumber = phoneNumber;
		SSN=ssnNumber;
		
		if(scenarioName.contains("Batch")&&count==1) {
			BatchFirstName=FirstName;
			count=count+1;
		}
		
		reportInfo("Add New person completed!!!");
		reportLog(Status.PASS,"Add New person completed!!!", true);
		}
		catch(Exception ex)
		{
			reportInfo("Exception occured in addNewPeople():- "+ex.getMessage());
			reportLog(Status.FAIL,"Add New person Failed!!!:- "+ex.getMessage(), true);
		}
	}
	
	public void addSamePeople() throws Exception {
		try {
		String phoneNumber = Random_NumberGenerator(10);
		
		EnterText(firstNameTxt, "First Name entered", existingFirstName);
		EnterText(lastNameTxt, "Last Name Entered", existingLastName);
		if (verifyElementPresence(ssnYRadio))
			clickElementWithWait(ssnYRadio, "Clicked on Yes Radio button");
		EnterText(ssnTxt, "SSN Entered", existingssnNumber);

		EnterText(suffixTxt, "Suffix Entered", _dataRepo.getData("Suffix"));
		EnterText(dobTxt, "Date of Birth Entered", (_dataRepo.getData("DOB")));
		EnterText(emailTxt, "Email ID Entered", _dataRepo.getData("Email"));
		EnterText(mobileTxt, "mobile Number Entered", existingphoneNumber);
		if (verifyElementPresence(typeHDDdl))
			selectDropDown(typeHDDdl, _dataRepo.getData("PersonType"), "PersonType selected");
		else
			selectDropDownByIndex(typeOtherDdl, "2", "PersonType selected");
		
		EnterText(DlNumberTxt, "DL Number Entered", phoneNumber);
		selectDropDown(DlNumberState, (_dataRepo.getData("State")), "State Selected");
		EnterText(addressTxt, "Address added to textbox", (_dataRepo.getData("Address")));
		EnterText(cityTxt, "City added to textbox", (_dataRepo.getData("City")));
		selectDropDown(stateDdl, (_dataRepo.getData("State")), "State selected From Drop down");
		EnterText(zipCodeTxt, "zip code added to textbox", (_dataRepo.getData("ZipCode")));	
		
		reportInfo("Add New person completed!!!");
		reportLog(Status.PASS,"Add New person completed!!!", true);
		}
		catch(Exception ex)
		{
			reportInfo("Exception occured in addNewPeople():- "+ex.getMessage());
			reportLog(Status.FAIL,"Add New person Failed!!!:- "+ex.getMessage(), true);
		}	
	}
	public void addExistingPerson() throws Exception {
		try {
		EnterText(firstNameTxt, "First Name entered", existingFirstName);
		EnterText(lastNameTxt, "Last Name Entered", existingLastName);
		EnterText(existingSSNTxt, "SSN Entered", existingssnNumber);
		EnterText(suffixTxt, "Suffix Entered", _dataRepo.getData("Suffix"));
		EnterText(dobTxt, "Date of Birth Entered", (_dataRepo.getData("DOB")));
		EnterText(existingEmailTxt, "Email ID Entered", _dataRepo.getData("Email"));
		EnterText(mobileTxt, "mobile Number Entered", existingphoneNumber);
		EnterText(signatureTxt, "Signature added to textbox", existingFirstName);
		/*if (verifyElementPresence(saveBtn))
			clickElementWithWait(saveBtn, "Click on Save button");*/
		
		reportInfo("Add Existing person completed!!!");
		reportLog(Status.PASS,"Add Existing person completed!!!", true);

		
	}
		catch(Exception ex)
		{
			reportInfo("Exception occured in addExistingPerson() :-"+ex.getMessage());
			reportLog(Status.FAIL,"Add Existing person Failed!!! " +ex.getMessage(), true);
		}
	}

}
