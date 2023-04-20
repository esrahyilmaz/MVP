package pages;

import Utility.ExcelReader;
import Utility.SearchTextOnPage;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import seleniumhelper.BaseClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VendorRegistrationPageXML extends BaseClass {

	public static Connection conn;
	public static PreparedStatement prepareStmt;
	public static ResultSet result;
//	private static String LastName="";
//	private static String ssn="";
//	private static String dob="";
	public static String DBUsername;
	public static String DBPassword;
	public static String connectionURL;
	public static int count=0;
//	public static String SSN="";
	private static ExcelReader data = new ExcelReader();
	private static SearchTextOnPage text = new SearchTextOnPage();

// Create Profile	
	private By IAgreeCB = By.xpath("//label[.='Accept Agreement']/..//input");
	private By ReisterNowBTN = By.xpath("//a[.='REGISTER NOW']");
	private By UserIdTB = By.xpath("//input[@name='vevaUser.vuUserLoginId']");
	private By passwordTB = By.xpath("//input[@name='vevaUser.vuPassword']");
	private By ConfirmPasswordTB = By.xpath("//input[@name='password2']");
	private By FirstNameTB = By.xpath("//input[@name='vevaUser.vuFirstName']");
	private By LastNameTB = By.xpath("//input[@name='vevaUser.vuLastName']");
	private By EmailTB = By.xpath("//input[@name='vevaUser.vuEmail']");
	private By SecretQTNDD = By.xpath("//select[@name='vevaUser.vuSecretQuestionId']");
	private By AnswerTB = By.xpath("//input[@name='vevaUser.vuSecretAnswer']");

// Principal Contact Information
	private By Addprinciple = By.xpath("//*[@id='addAnotherPrinceBttn']");
	private By principalLegalFirstNameTB = By.xpath("//input[@name='principalInd.viFirstName']");
	private By principalLegalLastNameTB = By.xpath("//input[@name='principalInd.viLastName']");
	private By principalSuffixTB = By.xpath("//input[@name='principalInd.viNameSuffix']");
	private By principalSSNTB = By.xpath("//input[@name='principalInd.viSsn']");
	private By principalDOBTB = By.xpath("//input[@name='dob']");
	private By principalPersonalEmailTB = By.xpath("//input[@name='principalInd.viEmail']");
	private By principalPhoneTB = By.xpath("//input[@name='principalInd.viPhone']");
	private By principalDriverLicenseTB = By.xpath("//input[@name='principalInd.viDriverLicNum']");
	private By principalDriverLicenseStateDD = By.xpath("//select[@name='principalInd.viDriverLicStateCd']");
	private By MiddleNameDisblePrinciple = By.xpath("(//input[@type='text' and @disabled='disabled'])[1]");

// Principal Current Address
	private By principalCountryDD = By.xpath("//select[@name='addressForm.countryCode']");
	private By principalAddress1TB = By.xpath("//input[@name='addressForm.addrLine1']");
	private By principalAddress2TB = By.xpath("//input[@name='addressForm.addrLine2']");
	private By principalCityTB = By.xpath("//input[@name='addressForm.cityName']");
	private By principalStateDD = By.xpath("//select[@name='addressForm.stateCode']");
	private By principalZipCodeTB = By.xpath("//input[@name='addressForm.zipCode']");
	private By principalZipcode2TB = By.xpath("//input[@name='addressForm.zipCode4']");
	private By principalSaveBTN = By.id("savePrincBtn");
	private By SaveBTN = By.xpath("//input[@value='SAVE']");
	private By saveBTN = By.xpath("//button[.='Save']");
	private By saveBtn = By.xpath("//button[.='Save']");
	private By okBTN = By.xpath("(//button[.='OK'])[last()]");
	private By MiddleNameYES = By.xpath("(//input[@name='principalInd.hasMidddleName'])[1]");
	private By MiddleNameNO = By.xpath("(//input[@name='principalInd.hasMidddleName'])[2]");
	private By principleAddressValidation = By.xpath("//input[@name='princeAddressValid']");

//Crew/Employee Information
	private By CrewTab = By.xpath("//div[@class='accordionHD']");
	private By Addcrew = By.xpath("//*[@id='addAnothercrewBttn']");
	private By AddCrewYesRB = By.xpath("(//input[@name='crewRequired'])[2]");
	private By AddCrewNoRB = By.xpath("(//input[@name='crewRequired'])[3]");
	private By CrewLegalFirstNameTB = By.xpath("//input[@name='individual.viFirstName']");
	private By CrewLegalLastNameTB = By.xpath("//input[@name='individual.viLastName']");
	private By CrewSufixTB = By.xpath("//input[@name='individual.viNameSuffix']");
	private By CrewSSNTB = By.xpath("//input[@name='individual.viSsn']");
	private By CrewDOBTB = By.xpath("//input[@name='cDob']");
	private By CrewEmailIDTB = By.xpath("//input[@name='individual.viEmail']");
	private By CrewTypeDD = By.xpath("//select[@name='individual.associationTypes']");
	private By MiddleNameDisbleCrew = By.xpath("(//input[@type='text' and @disabled='disabled'])[2]");

//Crew/Employee Current Address
	private By CrewCountryDD = By.xpath("//select[@name='cAddressForm.countryCode']");
	private By CrewAddress1TB = By.xpath("//input[@name='cAddressForm.addrLine1']");
	private By CrewAddress2TB = By.xpath("//input[@name='cAddressForm.addrLine2']");
	private By CrewCityTB = By.xpath("//input[@name='cAddressForm.cityName']");
	private By CrewStateDD = By.xpath("//select[@name='cAddressForm.stateCode']");
	private By CrewZipCodeTB = By.xpath("//input[@name='cAddressForm.zipCode']");
	private By CrewZipCode2TB = By.xpath("//input[@name='cAddressForm.zipCode4']");
	private By CrewSaveBTN = By.id("saveCrewBtn");
	private By CrewCancelBTN = By.xpath("//input[@value='CANCEL']");
	private By CrewAddressValidationCB = By.xpath("//input[@name='crewAddressValid']");
	private By CrewMiddleNameYES = By.xpath("(//input[@name='individual.hasMidddleName'])[1]");
	private By CrewMiddleNameNO = By.xpath("(//input[@name='individual.hasMidddleName'])[2]");
	private By CrewAddressValidation = By.xpath("//input[@name='crewAddressValid']");

	private By SubmitRegistrationBTN = By.xpath("//a[.='SUBMIT REGISTRATION']");

	public void agreeAndContinue() throws InterruptedException {

		clickElement(IAgreeCB,"Agree");
		clickElement(ReisterNowBTN,"Register");

	}

	public void createProfile(String UserID, String Password, String FirstName, String LastName, String Email,
			String SecurityQTN, String Answer) {

		String value = null;

		value = UserID;
		if (!value.isEmpty()) {
			EnterText(UserIdTB, "UserID", value);
		}

		value = Password;
		if (!value.isEmpty()) {
			EnterText(passwordTB, "Password", value);
		}

		value = Password;
		if (!value.isEmpty()) {
			EnterText(ConfirmPasswordTB, "ConfirmPasswordTB", value);
		}

		value = FirstName;
		if (!value.isEmpty()) {
			EnterText(FirstNameTB, "FirstName", value);
		}

		value = LastName;
		if (!value.isEmpty()) {
			EnterText(LastNameTB, "LastName", value);
		}

		value = Email;
		if (!value.isEmpty()) {
			EnterText(EmailTB, "Email", value);
		}

		value = SecurityQTN;
		if (!value.isEmpty()) {
			selectDropDown(SecretQTNDD, value, "SecurityQTN");
		}

		value = Answer;
		if (!value.isEmpty()) {
			EnterText(AnswerTB, "Answer", value);
		}

	}

	public void createProfileValidation(String UserID, String Password, String FirstName, String LastName, String Email,
			String SecurityQTN, String Answer) {

		String value = null;

		EnterText(UserIdTB, "UserID TB", "");
		if (verifyElementPresence(SubmitRegistrationBTN)) {
			clickElement(SubmitRegistrationBTN, "submit");
		}

		wait(3);

		text.SearchTextProfile("'User ID' is a required field.");

		value = UserID;
		if (!value.isEmpty()) {
			EnterText(UserIdTB, "UserID", value);
		}

		EnterText(passwordTB, "Password TB", "");
		if (verifyElementPresence(SubmitRegistrationBTN)) {
			clickElement(SubmitRegistrationBTN, "submit");
		}

		wait(3);

		text.SearchTextProfile("'New Password' is a required field.");

		value = Password;
		if (!value.isEmpty()) {
			EnterText(passwordTB, "Password", value);
		}

		EnterText(ConfirmPasswordTB, "ConfirmPasswordTB", "");
		if (verifyElementPresence(SubmitRegistrationBTN)) {
			clickElement(SubmitRegistrationBTN, "submit");
		}

		wait(3);

		text.SearchTextProfile("'Re-Enter New Password' is a required field.");

		value = Password;
		if (!value.isEmpty()) {
			EnterText(ConfirmPasswordTB, "ConfirmPasswordTB", value);
		}

		EnterText(FirstNameTB, "FirstName", "");
		if (verifyElementPresence(SubmitRegistrationBTN)) {
			clickElement(SubmitRegistrationBTN, "submit");
		}

		wait(3);

		text.SearchTextProfile("'User First Name' is a required field.");

		value = FirstName;
		if (!value.isEmpty()) {
			EnterText(FirstNameTB, "FirstName", value);
		}

		EnterText(LastNameTB, "LastName", "");
		if (verifyElementPresence(SubmitRegistrationBTN)) {
			clickElement(SubmitRegistrationBTN, "submit");
		}

		wait(3);

		text.SearchTextProfile("'User Last Name' is a required field.");

		value = LastName;
		if (!value.isEmpty()) {
			EnterText(LastNameTB, "LastName", value);
		}

		EnterText(EmailTB, "Email", "");
		if (verifyElementPresence(SubmitRegistrationBTN)) {
			clickElement(SubmitRegistrationBTN, "submit");
		}

		wait(3);

		text.SearchTextProfile("'User Email' is a required field.");

		value = Email;
		if (!value.isEmpty()) {
			EnterText(EmailTB, "Email", value);
		}

		selectDropDown(SecretQTNDD, "Select:", "SecurityQTN");
		if (verifyElementPresence(SubmitRegistrationBTN)) {
			clickElement(SubmitRegistrationBTN, "submit");
		}

		wait(3);

		text.SearchTextProfile("'Secret Question' is a required field.");

		value = SecurityQTN;
		if (!value.isEmpty()) {
			selectDropDown(SecretQTNDD, value, "SecurityQTN");
		}
		EnterText(AnswerTB, "Answer", "");
		if (verifyElementPresence(SubmitRegistrationBTN)) {
			clickElement(SubmitRegistrationBTN, "submit");
		}
		wait(3);
		text.SearchTextProfile("'Secret Answer' is a required field.");
		value = Answer;
		if (!value.isEmpty()) {
			EnterText(AnswerTB, "Answer", value);
		}

	}

	public void principalContactInformation(String principalLegalFirstName, String principalLegalLastName,
			String principalSuffix, String principalSSN, String principalDOB, String principalPersonalEmail,
			String principalPhone, String principalDriverLicense, String principalDriverLicenseState) {
		String value = null;

		if (SSN==null) {
			this.SSN = principalSSN;
		}

		wait(5);

		if (verifyElementPresence(Addprinciple)) {
			clickElement(Addprinciple, "Add Principle");
		}

		value = principalLegalFirstName;
		if (!value.isEmpty()) {
			EnterText(principalLegalFirstNameTB, "principalLegalFirstName", value);
		}

		value = principalLegalLastName;
		if (!value.isEmpty()) {
			EnterText(principalLegalLastNameTB, "principalLegalLastName", value);
		}

		value = principalSuffix;
		if (!value.isEmpty()) {
			EnterText(principalSuffixTB, "principalSuffix", value);
		}
		if (scenarioName.contains("SSNValidation")) {
			value = SSN;
			if (!value.isEmpty()) {
				EnterText(principalSSNTB, "principalSSN", value);
			}
		} else {
			value = principalSSN;
			if (!value.isEmpty()) {
				EnterText(principalSSNTB, "principalSSN", value);
			}
		}

		value = principalDOB;
		if (!value.isEmpty()) {
			EnterText(principalDOBTB, "principalDOB", value);
		}

		value = principalPersonalEmail;
		if (!value.isEmpty()) {
			EnterText(principalPersonalEmailTB, "principalPersonalEmail", value);
		}

		value = principalPhone;
		if (!value.isEmpty()) {
			EnterText(principalPhoneTB, "principalPhone", value);
		}

		value = principalDriverLicense;
		if (!value.isEmpty()) {
			EnterText(principalDriverLicenseTB, "principalDriverLicense", value);
		}

		value = principalDriverLicenseState;
		if (!value.isEmpty()) {
			selectDropDown(principalDriverLicenseStateDD, value, "principalDriverLicenseState");
		}
	}

	public void principalContactInformationValidation(String principalLegalFirstName, String principalLegalLastName,
			String principalSuffix, String principalSSN, String principalDOB, String principalPersonalEmail,
			String principalPhone, String principalDriverLicense, String principalDriverLicenseState) {
		String value = null;

		if (verifyElementPresence(SubmitRegistrationBTN)) {
			clickElement(SubmitRegistrationBTN, "Sumit Registration");
		}
		wait(3);
		text.SearchText("Please enter all mandatory field for principal information and click Save to proceed!");
		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}

		if (verifyElementPresence(principalSaveBTN)) {
			clickElement(principalSaveBTN, "save");
		} else if (verifyElementPresence(SaveBTN)) {
			clickElement(SaveBTN, "save");
		} else {
			clickElement(saveBTN, "save");
		}
		wait(3);
		text.SearchText("Principal First Name is required!");
		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}

		value = principalLegalFirstName;
		if (!value.isEmpty()) {
			EnterText(principalLegalFirstNameTB, "principalLegalFirstName", value);
		}

		if (verifyElementPresence(principalSaveBTN)) {
			clickElement(principalSaveBTN, "save");
		} else if (verifyElementPresence(SaveBTN)) {
			clickElement(SaveBTN, "save");
		} else {
			clickElement(saveBTN, "save");
		}
		wait(3);
		text.SearchText("Principal Last Name is required!");
		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}

		value = principalLegalLastName;
		if (!value.isEmpty()) {
			EnterText(principalLegalLastNameTB, "principalLegalLastName", value);
		}

		value = principalSuffix;
		if (!value.isEmpty()) {
			EnterText(principalSuffixTB, "principalSuffix", value);
		}

		if (verifyElementPresence(principalSaveBTN)) {
			clickElement(principalSaveBTN, "save");
		} else if (verifyElementPresence(SaveBTN)) {
			clickElement(SaveBTN, "save");
		} else {
			clickElement(saveBTN, "save");
		}
		wait(3);
		text.SearchText("Principal SSN is required!");
		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}

		value = principalSSN;
		if (!value.isEmpty()) {
			EnterText(principalSSNTB, "principalSSN", "1234");
		}

		if (verifyElementPresence(principalSaveBTN)) {
			clickElement(principalSaveBTN, "save");
		} else if (verifyElementPresence(SaveBTN)) {
			clickElement(SaveBTN, "save");
		} else {
			clickElement(saveBTN, "save");
		}
		wait(3);
		text.SearchText("Principal Social Security Number(SSN) must contain 9 digits!");
		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}

		value = principalSSN;
		if (!value.isEmpty()) {
			EnterText(principalSSNTB, "principalSSN", "abcdefghi");
		}

		if (verifyElementPresence(principalSaveBTN)) {
			clickElement(principalSaveBTN, "save");
		} else if (verifyElementPresence(SaveBTN)) {
			clickElement(SaveBTN, "save");
		} else {
			clickElement(saveBTN, "save");
		}
		wait(3);
		text.SearchText("Principal date of birth is required!");
		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}

		value = principalDOB;
		if (!value.isEmpty()) {
			EnterText(principalDOBTB, "principalDOB", "20");
		}

		if (verifyElementPresence(principalSaveBTN)) {
			clickElement(principalSaveBTN, "save");
		} else if (verifyElementPresence(SaveBTN)) {
			clickElement(SaveBTN, "save");
		} else {
			clickElement(saveBTN, "save");
		}
		wait(3);
		text.SearchText("Principal date of birth is invalid!");
		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}

		value = principalDOB;
		if (!value.isEmpty()) {
			EnterText(principalDOBTB, "principalDOB", "10021883");
		}

		if (verifyElementPresence(principalSaveBTN)) {
			clickElement(principalSaveBTN, "save");
		} else if (verifyElementPresence(SaveBTN)) {
			clickElement(SaveBTN, "save");
		} else {
			clickElement(saveBTN, "save");
		}
		wait(3);
		text.SearchText("Principal Email is required!");
		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}

		value = principalPersonalEmail;
		if (!value.isEmpty()) {
			EnterText(principalPersonalEmailTB, "principalPersonalEmail", "chandru");
		}

		if (verifyElementPresence(principalSaveBTN)) {
			clickElement(principalSaveBTN, "save");
		} else if (verifyElementPresence(SaveBTN)) {
			clickElement(SaveBTN, "save");
		} else {
			clickElement(saveBTN, "save");
		}
		wait(3);
		String text1 = driver.findElement(By.xpath("//*[@id='dialog']//font")).getText();
		if (text1.equalsIgnoreCase("Driver's License Number is required!")) {
			reportLog(Status.PASS, "[" + text1 + "] is present", false);
		} else {
			reportLog(Status.FAIL, "[" + text1 + "] is not present", false);
		}
		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}

		value = principalPhone;
		if (!value.isEmpty()) {
			EnterText(principalPhoneTB, "principalPhone", value);
		}

		value = principalDriverLicense;
		if (!value.isEmpty()) {
			EnterText(principalDriverLicenseTB, "principalDriverLicense", value);
		}

		if (verifyElementPresence(principalSaveBTN)) {
			clickElement(principalSaveBTN, "save");
		} else if (verifyElementPresence(SaveBTN)) {
			clickElement(SaveBTN, "save");
		} else {
			clickElement(saveBTN, "save");
		}
		wait(3);
		String text2 = driver.findElement(By.xpath("//*[@id='dialog']//font")).getText();
		if (text2.equalsIgnoreCase("Driver's License State is required!")) {
			reportLog(Status.PASS, "[" + text2 + "] is present", false);
		} else {
			reportLog(Status.FAIL, "[" + text2 + "] is not present", false);
		}
		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}

		value = principalDriverLicenseState;
		if (!value.isEmpty()) {
			selectDropDown(principalDriverLicenseStateDD, value, "principalDriverLicenseState");
		}

	}

	public void principalContactInformationValidationOrderDetails(String principalLegalFirstName,
			String principalLegalLastName, String principalSuffix, String principalSSN, String principalDOB,
			String principalPersonalEmail, String principalPhone, String principalDriverLicense,
			String principalDriverLicenseState) {
		String value = null;

		if (verifyElementPresence(saveBTN)) {
			clickElement(saveBTN, "save");
		}
		wait(3);
		text.SearchText("Principal First Name is required!");
		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}

		value = principalLegalFirstName;
		if (!value.isEmpty()) {
			EnterText(principalLegalFirstNameTB, "principalLegalFirstName", value);
		}

		if (verifyElementPresence(saveBTN)) {
			clickElement(saveBTN, "save");
		}
		wait(3);
		text.SearchText("Principal Last Name is required!");
		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}

		value = principalLegalLastName;
		if (!value.isEmpty()) {
			EnterText(principalLegalLastNameTB, "principalLegalLastName", value);
		}

		value = principalSuffix;
		if (!value.isEmpty()) {
			EnterText(principalSuffixTB, "principalSuffix", value);
		}

		if (verifyElementPresence(saveBTN)) {
			clickElement(saveBTN, "save");
		}
		wait(3);
		text.SearchText("Principal SSN is required!");
		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}

		value = principalSSN;
		if (!value.isEmpty()) {
			EnterText(principalSSNTB, "principalSSN", "1234");
		}

		if (verifyElementPresence(saveBTN)) {
			clickElement(saveBTN, "save");
		}
		wait(3);
		text.SearchText("Principal Social Security Number(SSN) must contain 9 digits!");
		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}

		value = principalSSN;
		if (!value.isEmpty()) {
			EnterText(principalSSNTB, "principalSSN", "abcdefghi");
		}

		if (verifyElementPresence(saveBTN)) {
			clickElement(saveBTN, "save");
		}
		wait(3);
		text.SearchText("Principal date of birth is required!");
		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}

		value = principalDOB;
		if (!value.isEmpty()) {
			EnterText(principalDOBTB, "principalDOB", "20");
		}

		if (verifyElementPresence(saveBTN)) {
			clickElement(saveBTN, "save");
		}
		wait(3);
		text.SearchText("Principal date of birth is invalid!");
		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}

		value = principalDOB;
		if (!value.isEmpty()) {
			EnterText(principalDOBTB, "principalDOB", "10021883");
		}

		if (verifyElementPresence(saveBTN)) {
			clickElement(saveBTN, "save");
		}
		wait(3);
		text.SearchText("Principal Email is required!");
		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}

		value = principalPersonalEmail;
		if (!value.isEmpty()) {
			EnterText(principalPersonalEmailTB, "principalPersonalEmail", "chandru");
		}

		if (verifyElementPresence(saveBTN)) {
			clickElement(saveBTN, "save");
		}
		wait(3);
		text.SearchText("License Number is required!");
		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}

		value = principalPhone;
		if (!value.isEmpty()) {
			EnterText(principalPhoneTB, "principalPhone", value);
		}

		value = principalDriverLicense;
		if (!value.isEmpty()) {
			EnterText(principalDriverLicenseTB, "principalDriverLicense", value);
		}

		if (verifyElementPresence(saveBTN)) {
			clickElement(saveBTN, "save");
		}
		wait(3);
		text.SearchText("License State is required!");

		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}

		value = principalDriverLicenseState;
		if (!value.isEmpty()) {
			selectDropDown(principalDriverLicenseStateDD, value, "principalDriverLicenseState");
		}

	}

	public void principalCurrentAddress(String principalCountry, String principalAddress1, String principalAddress2,
			String principalCity, String principalState, String principalZipCode, String principalZipcode2) {

		String value = null;

		/*
		 * value = principalCountry; if (!value.isEmpty()) {
		 * selectDropDown(principalCountryDD, value, "principalCountry"); }
		 * 
		 * value = principalAddress1; if (!value.isEmpty()) {
		 * EnterText(principalAddress1TB, "principalAddress1", value); }
		 * 
		 * value = principalAddress2; if (!value.isEmpty()) {
		 * EnterText(principalAddress2TB, "principalAddress2", value); }
		 * 
		 * value = principalCity; if (!value.isEmpty()) { EnterText(principalCityTB,
		 * "principalCity", value); }
		 * 
		 * value = principalState; if (!value.isEmpty()) {
		 * selectDropDown(principalStateDD, value, "principalState"); }
		 * 
		 * value = principalZipCode; if (!value.isEmpty()) {
		 * EnterText(principalZipCodeTB, "principalZipCode", value); }
		 * 
		 * value = principalZipcode2; if (!value.isEmpty()) {
		 * EnterText(principalZipcode2TB, "principalZipcode2", value); }
		 */
		
		value = principalCountry;
		
			selectDropDown(principalCountryDD, value, "principalCountry");
	
		value = principalAddress1;
		
			EnterText(principalAddress1TB, "principalAddress1", value);
		

		value = principalAddress2;
	
			EnterText(principalAddress2TB, "principalAddress2", value);
	

		value = principalCity;
		
			EnterText(principalCityTB, "principalCity", value);
		

		value = principalState;
		
			selectDropDown(principalStateDD, value, "principalState");
		

		value = principalZipCode;
		
			EnterText(principalZipCodeTB, "principalZipCode", value);
		

		value = principalZipcode2;
		
			EnterText(principalZipcode2TB, "principalZipcode2", value);
		

		
		wait(4);
		if (verifyElementPresence(principalSaveBTN)) {
			clickElement(principalSaveBTN, "save");
		} else if (verifyElementPresence(SaveBTN)) {
			clickElement(SaveBTN, "save");
		} else if (verifyElementPresence(saveBTN)){
			clickElement(saveBTN, "save");
		}else {
			clickElement(saveBtn, "SAVE");
		}

		if (data.getData("PopUpPri").equalsIgnoreCase("YES")) {
			wait(10);
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}
		String PopUpPriSSN=data.getData("PopUpPriSSN");
		if(PopUpPriSSN==null) {
			PopUpPriSSN="";
		}
		
		String Count=data.getData("Count");
		if(Count.equalsIgnoreCase("")||Count==null) {
			Count="0";
		}
		int count1=Integer.parseInt(Count);
		if(count==count1) {
			count=0;
		}else {
			count=1;
		}
		

		if (PopUpPriSSN.equalsIgnoreCase("YES") && count==0) {
			String error1 = "This Social Security number (" + ssn
					+ ") you have entered is associated to another person. The first and last name, social security number, and date of birth must be an exact match to add this person to your roster. Please double check your information to ensure it is correct and try again";
			if (verifyElementPresence(By.xpath("//font[contains(.,'" + error1 + "')]"))) {
				reportLog(Status.PASS, "Pop up is present and verified", false);
			} else {
				reportLog(Status.FAIL, "Pop up is not present or may be changed", false);
			}
			wait(3);
			if (verifyElementPresence(okBTN)) {
				clickElement(okBTN, "OK");
			}
			wait(4);
			if (verifyElementPresence(principalSaveBTN)) {
				clickElement(principalSaveBTN, "save");
			} else if (verifyElementPresence(SaveBTN)) {
				clickElement(SaveBTN, "save");
			} else if (verifyElementPresence(saveBTN)){
				clickElement(saveBTN, "save");
			}else {
				clickElement(saveBtn, "SAVE");
			}
			String error2 = "The social security number (" + ssn
					+ ") you have entered is associated to another person. The first and last name, social security number, and date of birth must be an exact match to add this person to your roster. You may double check your information to ensure it is correct and try again OR bypass this process and add a new person under this social security number !";
			
			wait(3);
			if(Count.equalsIgnoreCase("1")) {
				if (verifyElementPresence(By.xpath("//font[contains(.,'" + error2 + "')]"))) {
					reportLog(Status.PASS, "Pop up is present and verified", false);
				} else {
					reportLog(Status.FAIL, "Pop up is not present or may be changed", false);
				}
				wait(3);
				if (verifyElementPresence(okBTN)) {
					clickElement(okBTN, "OK");
				}
			}else {
			Alert alert = driver.switchTo().alert();
			String error = alert.getText();
			alert.accept();
			if (error.equalsIgnoreCase(error2)) {
				reportLog(Status.PASS, "Pop up is present and verified", false);
			} else {
				reportLog(Status.FAIL, "Pop up is not present or may be changed", false);
			}
			wait(4);
			
			}
		}

	}

	public void validateSSN(String person) {

		wait(3);
		text.SearchText("This SSN for an employee (" + SSN + ") already added!");
		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}

		if (person.equalsIgnoreCase("principal")) {

			String value = Random_NumberGenerator(9);
			if (verifyElementPresence(principalSSNTB)) {
				EnterText(principalSSNTB, "principal ssn", value);
			}

			if (verifyElementPresence(principalSaveBTN)) {
				clickElement(principalSaveBTN, "save");
			} else if (verifyElementPresence(SaveBTN)) {
				clickElement(SaveBTN, "save");
			} else if (verifyElementPresence(saveBTN)){
				clickElement(saveBTN, "save");
			}else {
				clickElement(saveBtn, "SAVE");
			}
			} else if (person.equalsIgnoreCase("Crew")) {
			String value = Random_NumberGenerator(9);
			this.SSN = value;
			if (verifyElementPresence(CrewSSNTB)) {
				EnterText(CrewSSNTB, "Crew SSN", value);
			}

			if (verifyElementPresence(CrewSaveBTN)) {
				clickElement(CrewSaveBTN, "save");
			} else if (verifyElementPresence(SaveBTN)) {
				clickElement(SaveBTN, "save");
			} else {
				clickElement(saveBTN, "save");
			}
		}
	}

	public void principalCurrentAddressValidation(String principalCountry, String principalAddress1,
			String principalAddress2, String principalCity, String principalState, String principalZipCode,
			String principalZipcode2) {

		String value = null;

		value = principalCountry;
		if (!value.isEmpty()) {
			selectDropDown(principalCountryDD, "Select:", "principalCountry");
		}

		if (verifyElementPresence(principalSaveBTN)) {
			clickElement(principalSaveBTN, "save");
		} else if (verifyElementPresence(SaveBTN)) {
			clickElement(SaveBTN, "save");
		} else {
			clickElement(saveBTN, "save");
		}
		wait(3);
		text.SearchText("Principal country is required!");
		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}

		value = principalCountry;
		if (!value.isEmpty()) {
			selectDropDown(principalCountryDD, value, "principalCountry");
		}

		if (verifyElementPresence(principalSaveBTN)) {
			clickElement(principalSaveBTN, "save");
		} else if (verifyElementPresence(SaveBTN)) {
			clickElement(SaveBTN, "save");
		} else {
			clickElement(saveBTN, "save");
		}
		wait(3);
		String text1 = driver.findElement(By.xpath("//*[@id='dialog']//font")).getText();
		if (text1.equalsIgnoreCase("Principal AddressLine1 is required!")) {
			reportLog(Status.PASS, "[" + text1 + "] is present", false);
		} else {
			reportLog(Status.FAIL, "[" + text1 + "] is not present", false);
		}
		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}

		value = principalState;
		if (!value.isEmpty()) {
			selectDropDown(principalDriverLicenseStateDD, value, "principalDriverLicenseState");
		}

		if (verifyElementPresence(principalSaveBTN)) {
			clickElement(principalSaveBTN, "save");
		} else if (verifyElementPresence(SaveBTN)) {
			clickElement(SaveBTN, "save");
		} else {
			clickElement(saveBTN, "save");
		}
		wait(3);
		text.SearchText("Principal AddressLine1 is required!");
		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}

		value = principalAddress1;
		if (!value.isEmpty()) {
			EnterText(principalAddress1TB, "principalAddress1", "Address");
		}

		value = principalAddress2;
		if (!value.isEmpty()) {
			EnterText(principalAddress2TB, "principalAddress2", value);
		}

		if (verifyElementPresence(principalSaveBTN)) {
			clickElement(principalSaveBTN, "save");
		} else if (verifyElementPresence(SaveBTN)) {
			clickElement(SaveBTN, "save");
		} else {
			clickElement(saveBTN, "save");
		}
		wait(3);
		text.SearchText("Principal city is required!");
		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}

		value = principalCity;
		if (!value.isEmpty()) {
			wait(3);
			EnterText(principalCityTB, "principalCity", "City");
		}

		if (verifyElementPresence(principalSaveBTN)) {
			clickElement(principalSaveBTN, "save");
		} else if (verifyElementPresence(SaveBTN)) {
			clickElement(SaveBTN, "save");
		} else {
			clickElement(saveBTN, "save");
		}
		wait(3);
		text.SearchText("Principal state is required!");
		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}

		value = principalState;
		if (!value.isEmpty()) {
			selectDropDown(principalStateDD, value, "principalState");
		}

		if (verifyElementPresence(principalSaveBTN)) {
			clickElement(principalSaveBTN, "save");
		} else if (verifyElementPresence(SaveBTN)) {
			clickElement(SaveBTN, "save");
		} else {
			clickElement(saveBTN, "save");
		}
		wait(3);
		text.SearchText("Principal zip code is required!");
		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}

		value = principalZipCode;
		if (!value.isEmpty()) {
			EnterText(principalZipCodeTB, "principalZipCode", "1234");
		}

		if (verifyElementPresence(principalSaveBTN)) {
			clickElement(principalSaveBTN, "save");
		} else if (verifyElementPresence(SaveBTN)) {
			clickElement(SaveBTN, "save");
		} else {
			clickElement(saveBTN, "save");
		}
		wait(3);
		text.SearchText("Principal zip code can not be less than 5 characters!");
		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}

		value = principalZipCode;
		if (!value.isEmpty()) {
			EnterText(principalZipCodeTB, "principalZipCode", "12345");
		}

		value = principalZipcode2;
		if (!value.isEmpty()) {
			EnterText(principalZipcode2TB, "principalZipcode2", value);
		}

		if (verifyElementPresence(principalSaveBTN)) {
			clickElement(principalSaveBTN, "save");
		} else if (verifyElementPresence(SaveBTN)) {
			clickElement(SaveBTN, "save");
		} else {
			clickElement(saveBTN, "save");
		}

		wait(3);

		text.SearchText("Principal email is not valid!");
		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}

		value = "chandra.shekarg@fadv.com";
		if (!value.isEmpty()) {
			EnterText(principalPersonalEmailTB, "principalPersonalEmail", value);
		}

		if (verifyElementPresence(principalSaveBTN)) {
			clickElement(principalSaveBTN, "save");
		} else if (verifyElementPresence(SaveBTN)) {
			clickElement(SaveBTN, "save");
		} else {
			clickElement(saveBTN, "save");
		}
		wait(3);
		text.SearchText("A background check cannot be ordered for a person above the age of 100!");
		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}

		value = "10022009";
		if (!value.isEmpty()) {
			EnterText(principalDOBTB, "principalDOB", value);
		}

		if (verifyElementPresence(principalSaveBTN)) {
			clickElement(principalSaveBTN, "save");
		} else if (verifyElementPresence(SaveBTN)) {
			clickElement(SaveBTN, "save");
		} else {
			clickElement(saveBTN, "save");
		}
		wait(3);
		text.SearchText("A background check cannot be ordered for a person under the age of 14!");
		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}

		value = "10021993";
		if (!value.isEmpty()) {
			EnterText(principalDOBTB, "principalDOB", value);
		}

		if (verifyElementPresence(principalSaveBTN)) {
			clickElement(principalSaveBTN, "save");
		} else if (verifyElementPresence(SaveBTN)) {
			clickElement(SaveBTN, "save");
		} else {
			clickElement(saveBTN, "save");
		}
		wait(3);
		text.SearchText("Principal SSN is not valid!");
		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}

		value = Random_NumberGenerator(9);
		if (!value.isEmpty()) {
			EnterText(principalSSNTB, "principalSSN", value);
		}

		if (verifyElementPresence(principalSaveBTN)) {
			clickElement(principalSaveBTN, "save");
		} else if (verifyElementPresence(SaveBTN)) {
			clickElement(SaveBTN, "save");
		} else {
			clickElement(saveBTN, "save");
		}
		wait(3); //// *[@id='alertmsgpop']//font
		String text2 = driver.findElement(By.xpath("//*[@id='dialog']//font")).getText();
		if (text2.equalsIgnoreCase(
				"The address could not be verified. Please correct the address and try again or if you want to continue with using this address, select the 'Use the Address as Entered' checkbox at the bottom of the address section!")) {
			reportLog(Status.PASS, "[" + text2 + "] is present", false);
		} else {
			reportLog(Status.FAIL, "[" + text2 + "] is not present", false);
		}
		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}
		if (verifyElementPresence(MiddleNameDisblePrinciple)) {
			reportLog(Status.PASS, "Middle name is disabled", false);
		} else {
			reportLog(Status.FAIL, "Middle name is not disabled", false);
		}

		if (verifyElementPresence(MiddleNameYES)) {
			clickElement(MiddleNameYES, "middle name yes");
		}

		if (verifyElementPresence(principalSaveBTN)) {
			clickElement(principalSaveBTN, "save");
		} else if (verifyElementPresence(SaveBTN)) {
			clickElement(SaveBTN, "save");
		} else {
			clickElement(saveBTN, "save");
		}
		wait(3);
		text.SearchText("Principal Middle Name is required!");
		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}

		if (verifyElementPresence(MiddleNameNO)) {
			clickElement(MiddleNameNO, "middle name NO");
		}

		if (verifyElementPresence(MiddleNameDisblePrinciple)) {
			reportLog(Status.PASS, "Middle name is disabled", false);
		} else {
			reportLog(Status.FAIL, "Middle name is not disabled", false);
		}

		if (verifyElementPresence(principleAddressValidation)) {
			clickElement(principleAddressValidation, "Address validation checkbox");
		}

		wait(4);
		if (verifyElementPresence(principalSaveBTN)) {
			clickElement(principalSaveBTN, "save");
		} else if (verifyElementPresence(SaveBTN)) {
			clickElement(SaveBTN, "save");
		} else {
			clickElement(saveBTN, "save");
		}

		if (data.getData("PopUpPri").equalsIgnoreCase("YES")) {
			wait(3);
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}

	}

	public void principalCurrentAddressValidationOrderDetails(String principalCountry, String principalAddress1,
			String principalAddress2, String principalCity, String principalState, String principalZipCode,
			String principalZipcode2) {

		String value = null;

		value = principalCountry;
		if (!value.isEmpty()) {
			selectDropDown(principalCountryDD, "Select:", "principalCountry");
		}

		if (verifyElementPresence(saveBTN)) {
			clickElement(saveBTN, "save");
		}
		wait(3);
		text.SearchText("Principal country is required!");
		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}

		value = principalCountry;
		if (!value.isEmpty()) {
			selectDropDown(principalCountryDD, value, "principalCountry");
		}

		if (verifyElementPresence(saveBTN)) {
			clickElement(saveBTN, "save");
		}
//		wait(3);
//		text.SearchText("Principal AddressLine1 is required!");
//		if (verifyElementPresence(okBTN)) {
//			clickElement(okBTN, "OK");
//		}
//		if (verifyElementPresence(saveBTN)) {
//			clickElement(saveBTN, "save");
//		}
		wait(5);
		text.SearchText("Driver's License State is required!");

		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}

		value = principalState;
		if (!value.isEmpty()) {
			selectDropDown(principalDriverLicenseStateDD, value, "principalDriverLicenseState");
		}

		if (verifyElementPresence(saveBTN)) {
			clickElement(saveBTN, "save");
		}
		wait(3);
		text.SearchText("Principal AddressLine1 is required!");
		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}

		value = principalAddress1;
		if (!value.isEmpty()) {
			EnterText(principalAddress1TB, "principalAddress1", "Address");
		}

		value = principalAddress2;
		if (!value.isEmpty()) {
			EnterText(principalAddress2TB, "principalAddress2", value);
		}

		if (verifyElementPresence(saveBTN)) {
			clickElement(saveBTN, "save");
		}
		wait(3);
		text.SearchText("Principal city is required!");
		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}

		value = principalCity;
		if (!value.isEmpty()) {
			wait(3);
			EnterText(principalCityTB, "principalCity", "City");
		}

		if (verifyElementPresence(saveBTN)) {
			clickElement(saveBTN, "save");
		}
		wait(3);
		text.SearchText("Principal state is required!");
		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}

		value = principalState;
		if (!value.isEmpty()) {
			selectDropDown(principalStateDD, value, "principalState");
		}

		if (verifyElementPresence(saveBTN)) {
			clickElement(saveBTN, "save");
		}
		wait(3);
		text.SearchText("Principal zip code is required!");
		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}

		value = principalZipCode;
		if (!value.isEmpty()) {
			EnterText(principalZipCodeTB, "principalZipCode", "1234");
		}

		if (verifyElementPresence(saveBTN)) {
			clickElement(saveBTN, "save");
		}
		wait(3);
		text.SearchText("Principal zip code can not be less than 5 characters!");
		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}

		value = principalZipCode;
		if (!value.isEmpty()) {
			EnterText(principalZipCodeTB, "principalZipCode", "12345");
		}

		value = principalZipcode2;
		if (!value.isEmpty()) {
			EnterText(principalZipcode2TB, "principalZipcode2", value);
		}

		if (verifyElementPresence(saveBTN)) {
			clickElement(saveBTN, "save");
		}

		wait(3);

		text.SearchText("Email is not valid!");
		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}

		value = "chandra.shekarg@fadv.com";
		if (!value.isEmpty()) {
			EnterText(principalPersonalEmailTB, "principalPersonalEmail", value);
		}

		if (verifyElementPresence(saveBTN)) {
			clickElement(saveBTN, "save");
		}
		wait(3);
		text.SearchText("A background check cannot be ordered for a person above the age of 100!");
		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}

		value = "10022009";
		if (!value.isEmpty()) {
			EnterText(principalDOBTB, "principalDOB", value);
		}

		if (verifyElementPresence(saveBTN)) {
			clickElement(saveBTN, "save");
		}
		wait(3);
		text.SearchText("A background check cannot be ordered for a person under the age of 14!");
		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}

		value = "10021993";
		if (!value.isEmpty()) {
			EnterText(principalDOBTB, "principalDOB", value);
		}

		if (verifyElementPresence(saveBTN)) {
			clickElement(saveBTN, "save");
		}
		wait(3);
		text.SearchText("SSN is not valid!");
		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}

		value = Random_NumberGenerator(9);
		if (!value.isEmpty()) {
			EnterText(principalSSNTB, "principalSSN", value);
		}

		if (verifyElementPresence(saveBTN)) {
			clickElement(saveBTN, "save");
		}
		wait(3);

		String text2 = driver.findElement(By.xpath("//*[@id='alertmsgpop']//font")).getText();
		if (text2.equalsIgnoreCase(
				"The address could not be verified. Please correct the address and try again or if you want to continue with using this address, select the 'Use the Address as Entered' checkbox at the bottom of the address section!")) {
			reportLog(Status.PASS, "[" + text2 + "] is present", false);
		} else {
			reportLog(Status.FAIL, "[" + text2 + "] is not present", false);
		}

		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}
		if (verifyElementPresence(MiddleNameDisblePrinciple)) {
			reportLog(Status.PASS, "Middle name is disabled", false);
		} else {
			reportLog(Status.FAIL, "Middle name is not disabled", false);
		}

		if (verifyElementPresence(MiddleNameYES)) {
			clickElement(MiddleNameYES, "middle name yes");
		}

		if (verifyElementPresence(saveBTN)) {
			clickElement(saveBTN, "save");
		}
		wait(3);
		text.SearchText("Principal Middle Name is required!");
		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}

		if (verifyElementPresence(MiddleNameNO)) {
			clickElement(MiddleNameNO, "middle name NO");
		}

		if (verifyElementPresence(MiddleNameDisblePrinciple)) {
			reportLog(Status.PASS, "Middle name is disabled", false);
		} else {
			reportLog(Status.FAIL, "Middle name is not disabled", false);
		}

		if (verifyElementPresence(principleAddressValidation)) {
			clickElement(principleAddressValidation, "Address validation checkbox");
		}

		wait(4);
		if (verifyElementPresence(saveBTN)) {
			clickElement(saveBTN, "save");
		}

		if (data.getData("PopUpPri").equalsIgnoreCase("YES")) {
			wait(3);
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}

	}

	public void CrewContactInformation(String AddCrew, String CrewLegalFirstName, String CrewLegalLastName,
			String CrewSufix, String CrewSSN, String CrewDOB, String CrewEmailID, String CrewType) {
		String value = null;
		
		value = AddCrew;
		if (value.equalsIgnoreCase("YES")) {
			if (verifyElementPresence(AddCrewYesRB)) {
				clickElement(AddCrewYesRB, "Add Crew");
			}
		} else if (value.equalsIgnoreCase("NO")) {
			if (verifyElementPresence(AddCrewNoRB)) {
				clickElement(AddCrewNoRB, "Add Crew NO");
			}
		}
		if (verifyElementPresence(CrewTab)) {
			clickElement(CrewTab, "crew tab");
		}
		
		if (verifyElementPresence(CrewTab)) {
			clickElement(CrewTab, "crew tab");
		}

		if (verifyElementPresence(Addcrew)) {
			clickElement(Addcrew, "Add Crew");
		}

		value = CrewLegalFirstName;
		if (!value.isEmpty()) {
			EnterText(CrewLegalFirstNameTB, "CrewLegalFirstName", value);
		}

		value = CrewLegalLastName;
		if (!value.isEmpty()) {
			EnterText(CrewLegalLastNameTB, "CrewLegalLastName", value);
		}

		value = CrewSufix;
		if (!value.isEmpty()) {
			EnterText(CrewSufixTB, "CrewSufix", value);
		}
		if (scenarioName.contains("SSNValidation")) {
			value = SSN;
			if (!value.isEmpty()) {
				EnterText(CrewSSNTB, "CrewSSN", value);
			}
		} else {
			value = CrewSSN;
			if (!value.isEmpty()) {
				EnterText(CrewSSNTB, "CrewSSN", value);
			}
		}

		value = CrewDOB;
		if (!value.isEmpty()) {
			EnterText(CrewDOBTB, "CrewDOB", value);
		}

		value = CrewEmailID;
		if (!value.isEmpty()) {
			EnterText(CrewEmailIDTB, "CrewEmailID", value);
		}

		value = CrewType;
		if (!value.isEmpty()) {
			selectDropDown(CrewTypeDD, value, "CrewType");
		}
	}

	public void CrewContactInformationValidation(String AddCrew, String CrewLegalFirstName, String CrewLegalLastName,
			String CrewSufix, String CrewSSN, String CrewDOB, String CrewEmailID, String CrewType) {
		String value = null;
		wait(2);
		value = AddCrew;
		if (value.equalsIgnoreCase("YES")) {
			if (verifyElementPresence(AddCrewYesRB)) {
				clickElement(AddCrewYesRB, "Add Crew");
			}
		} else if (value.equalsIgnoreCase("NO")) {
			if (verifyElementPresence(AddCrewNoRB)) {
				clickElement(AddCrewNoRB, "Add Crew NO");
			}
		}

		if (verifyElementPresence(Addcrew)) {
			clickElement(Addcrew, "Add Crew");
		}

		if (verifyElementPresence(SubmitRegistrationBTN)) {
			clickElement(SubmitRegistrationBTN, "Sumit Registration");
		}
		wait(3);
		text.SearchText(
				"Please enter all the mandatory fields in Crew information OR select NO option to Add crew information section!");
		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}

		if (verifyElementPresence(CrewSaveBTN)) {
			clickElement(CrewSaveBTN, "save");
		} else if (verifyElementPresence(SaveBTN)) {
			clickElement(SaveBTN, "save");
		} else {
			clickElement(saveBTN, "save");
		}
		wait(3);
		text.SearchText("Crew First Name is required!");
		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}

		value = CrewLegalFirstName;
		if (!value.isEmpty()) {
			EnterText(CrewLegalFirstNameTB, "CrewLegalFirstName", value);
		}

		if (verifyElementPresence(CrewSaveBTN)) {
			clickElement(CrewSaveBTN, "save");
		} else if (verifyElementPresence(SaveBTN)) {
			clickElement(SaveBTN, "save");
		} else {
			clickElement(saveBTN, "save");
		}
		wait(3);
		text.SearchText("Crew Last Name is required!");
		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}

		value = CrewLegalLastName;
		if (!value.isEmpty()) {
			EnterText(CrewLegalLastNameTB, "CrewLegalLastName", value);
		}

		if (verifyElementPresence(CrewSaveBTN)) {
			clickElement(CrewSaveBTN, "save");
		} else if (verifyElementPresence(SaveBTN)) {
			clickElement(SaveBTN, "save");
		} else {
			clickElement(saveBTN, "save");
		}
		wait(3);
		text.SearchText("Crew SSN is required!");
		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}

		value = CrewSSN;
		if (!value.isEmpty()) {
			EnterText(CrewSSNTB, "CrewSSN", "1234");
		}

		if (verifyElementPresence(CrewSaveBTN)) {
			clickElement(CrewSaveBTN, "save");
		} else if (verifyElementPresence(SaveBTN)) {
			clickElement(SaveBTN, "save");
		} else {
			clickElement(saveBTN, "save");
		}
		wait(3);
		text.SearchText("Crew Social Security Number(SSN) must contain 9 digits!");
		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}

		value = CrewSSN;
		if (!value.isEmpty()) {
			EnterText(CrewSSNTB, "CrewSSN", "abcdefghi");
		}

		if (verifyElementPresence(CrewSaveBTN)) {
			clickElement(CrewSaveBTN, "save");
		} else if (verifyElementPresence(SaveBTN)) {
			clickElement(SaveBTN, "save");
		} else {
			clickElement(saveBTN, "save");
		}
		wait(3);
		text.SearchText("Crew date of birth is required!");
		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}

		value = CrewDOB;
		if (!value.isEmpty()) {
			EnterText(CrewDOBTB, "CrewDOB", "20");
		}

		if (verifyElementPresence(CrewSaveBTN)) {
			clickElement(CrewSaveBTN, "save");
		} else if (verifyElementPresence(SaveBTN)) {
			clickElement(SaveBTN, "save");
		} else {
			clickElement(saveBTN, "save");
		}
		wait(3);
		text.SearchText("Crew date of birth is invalid!");
		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}

		value = CrewDOB;
		if (!value.isEmpty()) {
			EnterText(CrewDOBTB, "CrewDOB", "10021883");
		}

		if (verifyElementPresence(CrewSaveBTN)) {
			clickElement(CrewSaveBTN, "save");
		} else if (verifyElementPresence(SaveBTN)) {
			clickElement(SaveBTN, "save");
		} else {
			clickElement(saveBTN, "save");
		}
		wait(3);
		text.SearchText("Crew Email is required!");
		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}

		value = CrewEmailID;
		if (!value.isEmpty()) {
			EnterText(CrewEmailIDTB, "CrewPersonalEmail", "chandru");
		}

		if (verifyElementPresence(CrewSaveBTN)) {
			clickElement(CrewSaveBTN, "save");
		} else if (verifyElementPresence(SaveBTN)) {
			clickElement(SaveBTN, "save");
		} else {
			clickElement(saveBTN, "save");
		}
		wait(3);
		text.SearchText("Crew Type is required!");
		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}

		value = CrewType;
		if (!value.isEmpty()) {
			selectDropDown(CrewTypeDD, value, "CrewType");
		}

	}

	public void CrewCurrentAddressTaxable(String CrewCountry, String CrewAddress1, String CrewAddress2, String CrewCity,
			String CrewState, String CrewZipCode, String CrewZipcode2, String Save) {

		String value = null;

		value = "UNITED STATES";
		if (!value.isEmpty()) {
			selectDropDown(CrewCountryDD, value, "CrewCountry");
		}

		value = "520 W 28th ST";
		if (!value.isEmpty()) {
			EnterText(CrewAddress1TB, "CrewAddress1", value);
		}

		value = CrewAddress2;
		if (!value.isEmpty()) {
			EnterText(CrewAddress2TB, "CrewAddress2", value);
		}

		value = "New York";
		if (!value.isEmpty()) {
			EnterText(CrewCityTB, "CrewCity", value);
		}

		value = "New York";
		if (!value.isEmpty()) {
			selectDropDown(CrewStateDD, value, "CrewState");
		}

		value = "10001";
		if (!value.isEmpty()) {
			EnterText(CrewZipCodeTB, "CrewZipCode", value);
		}

		value = CrewZipcode2;
		if (!value.isEmpty()) {
			EnterText(CrewZipCode2TB, "CrewZipcode2", value);
		}

		value = Save;
		if (value.equalsIgnoreCase("YES")) {
			wait(4);
			clickElement(CrewSaveBTN, "save");
		} else if (value.equalsIgnoreCase("NO")) {
			wait(2);
			clickElement(CrewCancelBTN, "cancel");
		}

	}

	public void CrewCurrentAddressNonTaxable(String CrewCountry, String CrewAddress1, String CrewAddress2,
			String CrewCity, String CrewState, String CrewZipCode, String CrewZipcode2, String Save) {

		String value = null;

		value = "UNITED STATES";
		if (!value.isEmpty()) {
			selectDropDown(CrewCountryDD, value, "CrewCountry");
		}

		value = "1100 Alderman Dr.";
		if (!value.isEmpty()) {
			EnterText(CrewAddress1TB, "CrewAddress1", value);
		}

		value = CrewAddress2;
		if (!value.isEmpty()) {
			EnterText(CrewAddress2TB, "CrewAddress2", value);
		}

		value = "Alpharetta";
		if (!value.isEmpty()) {
			EnterText(CrewCityTB, "CrewCity", value);
		}

		value = "Georgia";
		if (!value.isEmpty()) {
			selectDropDown(CrewStateDD, value, "CrewState");
		}

		value = "30005";
		if (!value.isEmpty()) {
			EnterText(CrewZipCodeTB, "CrewZipCode", value);
		}

		value = CrewZipcode2;
		if (!value.isEmpty()) {
			EnterText(CrewZipCode2TB, "CrewZipcode2", value);
		}

		value = Save;
		if (value.equalsIgnoreCase("YES")) {
			wait(4);
			clickElement(CrewSaveBTN, "save");
		} else if (value.equalsIgnoreCase("NO")) {
			wait(2);
			clickElement(CrewCancelBTN, "cancel");
		}

	}

	public void CrewCurrentAddress(String CrewCountry, String CrewAddress1, String CrewAddress2, String CrewCity,
			String CrewState, String CrewZipCode, String CrewZipcode2, String Save) {

		String value = null;

		value = CrewCountry;
		if (!value.isEmpty()) {
			selectDropDown(CrewCountryDD, value, "CrewCountry");
		}

		value = CrewAddress1;
		if (!value.isEmpty()) {
			EnterText(CrewAddress1TB, "CrewAddress1", value);
		}

		value = CrewAddress2;
		if (!value.isEmpty()) {
			EnterText(CrewAddress2TB, "CrewAddress2", value);
		}

		value = CrewCity;
		if (!value.isEmpty()) {
			EnterText(CrewCityTB, "CrewCity", value);
		}

		value = CrewState;
		if (!value.isEmpty()) {
			selectDropDown(CrewStateDD, value, "CrewState");
		}

		value = CrewZipCode;
		if (!value.isEmpty()) {
			EnterText(CrewZipCodeTB, "CrewZipCode", value);
		}

		value = CrewZipcode2;
		if (!value.isEmpty()) {
			EnterText(CrewZipCode2TB, "CrewZipcode2", value);
		}

		value = Save;
		if (value.equalsIgnoreCase("YES")) {
			wait(4);
			clickElement(CrewSaveBTN, "save");
		} else if (value.equalsIgnoreCase("NO")) {
			wait(2);
			clickElement(CrewCancelBTN, "cancel");
		}

		if (data.getData("PopUpCrew").equalsIgnoreCase("YES")) {
			wait(10);
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}
		String PopUpCrewSSN=data.getData("PopUpCrewSSN");
		if(PopUpCrewSSN==null) {
			PopUpCrewSSN="";
		}
		
		if (PopUpCrewSSN.equalsIgnoreCase("YES")) {
			String error1 = "This Social Security number (" + ssn
					+ ") you have entered is associated to another person. The first and last name, social security number, and date of birth must be an exact match to add this person to your roster. Please double check your information to ensure it is correct and try again";
			if (verifyElementPresence(By.xpath("//font[contains(.,'" + error1 + "')]"))) {
				reportLog(Status.PASS, "Pop up is present and verified", false);
			} else {
				reportLog(Status.FAIL, "Pop up is not present or may be changed", false);
			}
			wait(3);
			if (verifyElementPresence(okBTN)) {
				clickElement(okBTN, "OK");
			}
			wait(4);
			if (verifyElementPresence(CrewSaveBTN)) {
				wait(4);
				clickElement(CrewSaveBTN, "save");
			}
			wait(3);
			Alert alert = driver.switchTo().alert();
			String error = alert.getText();
			String error2 = "The social security number (" + ssn
					+ ") you have entered is associated to another person. The first and last name, social security number, and date of birth must be an exact match to add this person to your roster. You may double check your information to ensure it is correct and try again OR bypass this process and add a new person under this social security number !";
			alert.accept();
			if (error.equalsIgnoreCase(error2)) {
				reportLog(Status.PASS, "Pop up is present and verified", false);
			} else {
				reportLog(Status.FAIL, "Pop up is not present or may be changed", false);
			}
		}
	}

	public void CrewCurrentAddressValidation(String CrewCountry, String CrewAddress1, String CrewAddress2,
			String CrewCity, String CrewState, String CrewZipCode, String CrewZipcode2, String Save) {

		String value = null;

		value = CrewCountry;
		if (!value.isEmpty()) {
			selectDropDown(CrewCountryDD, "Select:", "CrewCountry");
		}

		if (verifyElementPresence(CrewSaveBTN)) {
			clickElement(CrewSaveBTN, "save");
		} else if (verifyElementPresence(SaveBTN)) {
			clickElement(SaveBTN, "save");
		} else {
			clickElement(saveBTN, "save");
		}
		wait(3);
		text.SearchText("Crew country is required!");
		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}

		value = CrewCountry;
		if (!value.isEmpty()) {
			selectDropDown(CrewCountryDD, value, "CrewCountry");
		}

		if (verifyElementPresence(CrewSaveBTN)) {
			clickElement(CrewSaveBTN, "save");
		} else if (verifyElementPresence(SaveBTN)) {
			clickElement(SaveBTN, "save");
		} else {
			clickElement(saveBTN, "save");
		}

		wait(3);
		text.SearchText("Crew AddressLine1 is required!");
		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}

		value = CrewAddress1;
		if (!value.isEmpty()) {
			EnterText(CrewAddress1TB, "CrewAddress1", "Address");
		}

		value = CrewAddress2;
		if (!value.isEmpty()) {
			EnterText(CrewAddress2TB, "CrewAddress2", value);
		}

		if (verifyElementPresence(CrewSaveBTN)) {
			clickElement(CrewSaveBTN, "save");
		} else if (verifyElementPresence(SaveBTN)) {
			clickElement(SaveBTN, "save");
		} else {
			clickElement(saveBTN, "save");
		}
		wait(3);
		text.SearchText("Crew city is required!");
		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}

		value = CrewCity;
		if (!value.isEmpty()) {
			wait(3);
			EnterText(CrewCityTB, "CrewCity", "City");
		}

		if (verifyElementPresence(CrewSaveBTN)) {
			clickElement(CrewSaveBTN, "save");
		} else if (verifyElementPresence(SaveBTN)) {
			clickElement(SaveBTN, "save");
		} else {
			clickElement(saveBTN, "save");
		}
		wait(3);
		text.SearchText("Crew state is required!");
		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}

		value = CrewState;
		if (!value.isEmpty()) {
			selectDropDown(CrewStateDD, value, "CrewState");
		}

		if (verifyElementPresence(CrewSaveBTN)) {
			clickElement(CrewSaveBTN, "save");
		} else if (verifyElementPresence(SaveBTN)) {
			clickElement(SaveBTN, "save");
		} else {
			clickElement(saveBTN, "save");
		}
		wait(3);
		text.SearchText("Crew zip code is required!");
		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}

		value = CrewZipCode;
		if (!value.isEmpty()) {
			EnterText(CrewZipCodeTB, "CrewZipCode", "1234");
		}

		if (verifyElementPresence(CrewSaveBTN)) {
			clickElement(CrewSaveBTN, "save");
		} else if (verifyElementPresence(SaveBTN)) {
			clickElement(SaveBTN, "save");
		} else {
			clickElement(saveBTN, "save");
		}
		wait(3);
		text.SearchText("Crew zip code can not be less than 5 characters!");
		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}

		value = CrewZipCode;
		if (!value.isEmpty()) {
			EnterText(CrewZipCodeTB, "CrewZipCode", "12345");
		}

		if (verifyElementPresence(CrewSaveBTN)) {
			clickElement(CrewSaveBTN, "save");
		} else if (verifyElementPresence(SaveBTN)) {
			clickElement(SaveBTN, "save");
		} else {
			clickElement(saveBTN, "save");
		}

		wait(3);

		text.SearchText("Crew email is not valid!");
		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}

		value = "chandra.shekarg@fadv.com";
		if (!value.isEmpty()) {
			EnterText(CrewEmailIDTB, "CrewPersonalEmail", value);
		}

		if (verifyElementPresence(CrewSaveBTN)) {
			clickElement(CrewSaveBTN, "save");
		} else if (verifyElementPresence(SaveBTN)) {
			clickElement(SaveBTN, "save");
		} else {
			clickElement(saveBTN, "save");
		}
		wait(3);
		text.SearchText("A background check cannot be ordered for a person above the age of 100!");
		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}

		value = "10022009";
		if (!value.isEmpty()) {
			EnterText(CrewDOBTB, "CrewDOB", value);
		}

		if (verifyElementPresence(CrewSaveBTN)) {
			clickElement(CrewSaveBTN, "save");
		} else if (verifyElementPresence(SaveBTN)) {
			clickElement(SaveBTN, "save");
		} else {
			clickElement(saveBTN, "save");
		}
		wait(3);
		text.SearchText("A background check cannot be ordered for a person under the age of 14!");
		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}

		value = "10021993";
		if (!value.isEmpty()) {
			EnterText(CrewDOBTB, "CrewDOB", value);
		}

		if (verifyElementPresence(CrewSaveBTN)) {
			clickElement(CrewSaveBTN, "save");
		} else if (verifyElementPresence(SaveBTN)) {
			clickElement(SaveBTN, "save");
		} else {
			clickElement(saveBTN, "save");
		}
		wait(3);
		text.SearchText("Crew SSN is not valid!");
		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}

		value = Random_NumberGenerator(9);
		if (!value.isEmpty()) {
			EnterText(CrewSSNTB, "CrewSSN", value);
		}

		if (verifyElementPresence(CrewSaveBTN)) {
			clickElement(CrewSaveBTN, "save");
		} else if (verifyElementPresence(SaveBTN)) {
			clickElement(SaveBTN, "save");
		} else {
			clickElement(saveBTN, "save");
		}
		wait(3);
		String text2 = driver.findElement(By.xpath("//*[@id='dialog']//font")).getText();
		if (text2.equalsIgnoreCase(
				"The address could not be verified. Please correct the address and try again or if you want to continue with using this address, select the 'Use the Address as Entered' checkbox at the bottom of the address section!")) {
			reportLog(Status.PASS, "[" + text2 + "] is present", false);
		} else {
			reportLog(Status.FAIL, "[" + text2 + "] is not present", false);
		}
		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}
		if (verifyElementPresence(MiddleNameDisbleCrew)) {
			reportLog(Status.PASS, "Middle name is disabled", false);
		} else {
			reportLog(Status.FAIL, "Middle name is not disabled", false);
		}

		if (verifyElementPresence(CrewMiddleNameYES)) {
			clickElement(CrewMiddleNameYES, "middle name yes");
		}

		if (verifyElementPresence(CrewSaveBTN)) {
			clickElement(CrewSaveBTN, "save");
		} else if (verifyElementPresence(SaveBTN)) {
			clickElement(SaveBTN, "save");
		} else {
			clickElement(saveBTN, "save");
		}
		wait(3);
		text.SearchText("Crew Middle Name is required!");
		if (verifyElementPresence(okBTN)) {
			clickElement(okBTN, "OK");
		}

		if (verifyElementPresence(CrewMiddleNameNO)) {
			clickElement(CrewMiddleNameNO, "middle name NO");
		}

		if (verifyElementPresence(MiddleNameDisbleCrew)) {
			reportLog(Status.PASS, "Middle name is disabled", false);
		} else {
			reportLog(Status.FAIL, "Middle name is not disabled", false);
		}

		if (verifyElementPresence(CrewAddressValidation)) {
			clickElement(CrewAddressValidation, "Address validation checkbox");
		}

		value = Save;
		if (value.equalsIgnoreCase("YES")) {
			wait(4);
			clickElement(CrewSaveBTN, "save");
		} else if (value.equalsIgnoreCase("NO")) {
			wait(2);
			clickElement(CrewCancelBTN, "cancel");
		}

		if (data.getData("PopUpCrew").equalsIgnoreCase("YES")) {
			wait(3);
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}
	}

	public void submit() {
		wait(7);
		clickElement(SubmitRegistrationBTN, "Submit Registration");
	}

}