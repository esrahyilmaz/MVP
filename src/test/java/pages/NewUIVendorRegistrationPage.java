package pages;

import Utility.ExcelReader;
import Utility.PropertyFileReader;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import seleniumhelper.BaseClass;
import seleniumhelper.DatabaseClass;

public class NewUIVendorRegistrationPage extends BaseClass {
	ExcelReader _dataRepo = new ExcelReader();

	private static String FirstName;
	private static String LastName;
	private static String Email;
	private static String UserID;
	private static String Password;
	private static String ConfirmPassword;
	private static String SecretQuestion;
	private static String SecretAnswer;

	// SelfScreening
	public By SelffirstNm = By.xpath("//input[@placeholder='First Name *']");
	public By SelflastNm = By.xpath("//input[@placeholder='Last Name *']");
	private By Selfemail = By.xpath("//input[@placeholder='Email *']");

	//Instruction Page
	By previousButton = By.xpath("//button[contains(text(), 'Previous')]");
	By VendorSignUp = By.xpath("//*[@data-xf-qa-id='LOGIN-SIGNUP-BTN']");
	// User Profile Page
	
	By letsBegin = By.xpath("//button[contains (., 'Begin')]");
	By firstNm = By.xpath("//input[@id='first-name-field']");
	By lastNm = By.xpath("//input[@id='last-name-field']");
	By email = By.xpath("//input[@id='email-field']");
	By userID = By.xpath("//input[@id='user-name-field']");
	By password = By.xpath("//input[@id='pass-field']");
	By confirmPassword = By.xpath("//input[@id='confirm-field']");
	By secretQ = By.xpath("//select[@id='secret-question']");
	By secretAnswer = By.xpath("//input[@id='secret-answer']");
	By next = By.xpath("//button[@type='submit']");

	// Business Information Page - Demographic Business Information
	By businessName = By.xpath("//input[@id='business-name-field']");
	By doingBusnissAs = By.xpath("//input[@id='dbAs']");
	By busniessType = By.xpath("//select[@id='business-type-field']");
	By ownerShipInfo = By.xpath("//input[@id='ownership-info']");
	//By snn = By.xpath("//input[@id='ssn-field']");
	By employmentPurpose = By.xpath("//input[@id='employmentPurposePrePostEmployment']");
	By businessDescription = By.xpath("//textarea[@id='businessDescription']");

	// Business Information Page - Business Address Information
	By businessAddInfo = By.xpath("//p[@aria-expanded='true']");
	By countryName = By.xpath("//select[@id='country-field']");
	By address1 = By.xpath("//input[@id='street-field']");
	By address2 = By.xpath("//input[@id='street-two-field']");
	By state = By.xpath("//select[@id='region-field']");
	By city = By.xpath("//input[@id='city-field']");
	By zipCode = By.xpath("//input[@id='zip-field']");

	// Business Contact Page - Primary Business Contact
	By busiContactFirstName = By.xpath("//input[@placeholder='First Name *']");
	By busiContactLastName = By.xpath("//input[@placeholder='Last Name *']");
	By primaryContactMidlName = By.xpath("//input[@id='middleNameNo']");
	By busiContactTitle = By.xpath("//input[@placeholder='Title *']");
	By busiContactEmail = By.xpath("//input[@placeholder='Email *']");
	By busiCountry = By.xpath("//select[@id='primaryCountry']");
	By countryCode = By.xpath("//select[@id='phone-country-field']");
	By busiContactPhoneNumber = By.xpath("//*[@formcontrolname='primaryPhone']");
	By nextButton = By.xpath("//button[@class='shadow btn btn-primary btn-vendor']");
	By goBackButton = By.xpath("//button[@class='shadow btn btn-default btn-vendor mr-2']");

	// Secondary Business Contact Page - Secondary Business Contact
	By SecondaryBusinessContact = By.xpath("//div[@id='addSecondaryContact']");
	By SecondarybusiContactFirstName = By.xpath("(//input[@placeholder='First Name *'])[2]");
	By SecondarybusiContactLastName = By.xpath("(//input[@placeholder='Last Name *'])[2]");
	By SecondaryprimaryContactMidlName = By.xpath("//input[@id='secondaryMiddleNameNo']");
	By SecondarybusiContactTitle = By.xpath("(//input[@placeholder='Title *'])[2]");
	By SecondarybusiContactEmail = By.xpath("(//input[@placeholder='Email *'])[2]");
	By SecondarybusiCountry = By.xpath("//select[@id='secondaryCountry']");
	By SecondarycountryCode = By.xpath("//select[@id='secondary-phone-country-field']");
	By SecondarybusiContactPhoneNumber = By.xpath("//*[@formcontrolname='secondaryPhone']");

	// Business Billing Page - Billing Contact
	By addBillingContact = By.xpath("//div[@id='addBillingContact']");
	By billingContactFirstName = By.xpath("//input[@placeholder='First Name *']");
	By billingContactLastName = By.xpath("//input[@placeholder='Last Name *']");
	By primaryBillingContactMidlName = By.xpath("//input[@id='middleNameNo']");
	By billingContactTitle = By.xpath("//input[@placeholder='Title *']");
	By billingContactEmail = By.xpath("//input[@placeholder='Email *']");
	By billingContactCountry = By.xpath("//select[@id='primaryCountry']");
	By billingCountryCode = By.xpath("//select[@id='phone-country-field']");
	By billingContactPhoneNumber = By.xpath("//*[@formcontrolname='contactPhone']");
	By BillingCountry =By.xpath("//select[@id='billingCountry']");
	By billingAddress = By.xpath("//form/div[2]/div[1]/input");
	By billingCity = By.xpath("//input[@id='billingCity']");
	By billingState = By.xpath("//*[@id='billingRegion']");
	By billingStateValue = By.xpath("//select[@id='billingRegion']/option");
	By billingZipCode = By.xpath("//*[@formcontrolname='billingPostalCode']");
	By MiddleNameYes = By.xpath("//input[@id='middleNameYes']");

	By PrimaryContactCheckbox = By.xpath("//label[@for='checkbox']");
	By billingAddressSameRadio = By.xpath("//input[@aria-label='Checkbox for following text input']");
	By billingNextButton = By.xpath("//button[@class='shadow btn btn-primary btn-vendor']");

	By ConvasSign = By.xpath("//div[@class='card card m-auto']/signature-pad");
	By SubmitBtn = By.xpath("//*[@class='shadow btn btn-primary btn-vendor']");
	By expectedText = By.xpath("//*[contains(text(), 'Congratulations!')]");
	By loginOnComPage = By.xpath("//a[@class='btn btn-primary']");
	public By NewUIForgotPasswordLink = By.xpath("//span[@id='forgotPassword']");
	By emailOnforgotpassword = By.xpath("//input[@id='email-field']");
	public By ResestButton = By.xpath("//button[@id='reset-password-btn']");
	public By ReturnButton = By.xpath("(//button[@type='button'])[last()]");
	public By GoBack = By.xpath("//button[@id='business-info-back-btn']");

	// Sign up page
	public By adopAndSign = By.xpath("//input[@id='adoptCheckbox']");

	String randomString = Random_StringGenerator(8);
	PropertyFileReader _config = new PropertyFileReader();
	DatabaseClass database = new DatabaseClass();

	public void emailOnforgotPassword(String email) {
		if (verifyElementPresence(emailOnforgotpassword)) {
			EnterText(emailOnforgotpassword, "emailId", email);
			logStepInfo("Email is entered : " + email);
		} else {
			logStepInfo("Email is not entered : " + email);
		}
	}

	public void UserProfilePage(String firstName, String lastName, String emailId, String userId, String password1,
			String secretQues, String secretAns) throws Exception {
		if (verifyElementPresence(firstNm)) {
			EnterText(firstNm, "first name", firstName);
			existingFirstName = firstName;
			logStepInfo("First Name is entered : " + firstName);
		} else if (verifyElementPresence(SelffirstNm)) {
			EnterText(SelffirstNm, "first name", firstName);
			logStepInfo("First Name is entered : " + firstName);

		} else {
			logStepInfo("First Name is not entered : " + firstName);
		}

		if (verifyElementPresence(lastNm)) {
			EnterText(lastNm, "last name", lastName);
			existingLastName = lastName;
			logStepInfo("Last Name is entered : " + lastName);
		} else if (verifyElementPresence(SelflastNm)) {
			EnterText(SelflastNm, "last name", lastName);
			logStepInfo("Last Name is entered : " + lastName);

		} else {
			logStepInfo("Last Name is not entered : " + lastName);
		}

		if (verifyElementPresence(email)) {
			EnterText(email, "emailId", emailId);
			logStepInfo("Email is entered : " + emailId);
		} else if (verifyElementPresence(Selfemail)) {
			EnterText(Selfemail, "emailId", emailId);
			logStepInfo("Email is entered : " + emailId);
		} else {
			logStepInfo("Email is not entered : " + emailId);
		}

		if (verifyElementPresence(userID)) {
			existingUserID = userId;
			PropertyFileReader.setProperty("VendorUserID", existingUserID);
			EnterText(userID, "userId", userId);
			logStepInfo("UserID is entered : " + userId);
			reportLog(Status.INFO, "<br>" + "UserID for new Vendor is: " + userId + "</br>", false);
		} else {
			logStepInfo("UserID is not entered : " + userId);
		}

		if (verifyElementPresence(password)) {
			existingPassword = password1;
			PropertyFileReader.setProperty("VendorPassword", existingPassword);
			EnterText(password, "Password", password1);
			logStepInfo("Password is entered : " + password1);

		} else {
			logStepInfo("Password is not entered : " + password1);
		}

		if (verifyElementPresence(confirmPassword)) {
			EnterText(confirmPassword, "Re enter Password", password1);
			logStepInfo("Confirm Password is entered : " + password1);
		} else {
			logStepInfo("Confirm Password is not entered : " + password1);
		}

		if (verifyElementPresence(secretQ)) {
			selectDropDown(secretQ, secretQues, "SecretQues");
			logStepInfo("secret question selected : " + secretQues);

		} else {
			logStepInfo("secret question not selected : " + secretQues);
		}

		if (verifyElementPresence(secretAnswer)) {
			EnterText(secretAnswer, "Secret Answer", secretAns);

			logStepInfo("secret Answer is entered : " + secretAns);

		} else {
			logStepInfo("secret Answer is not entered : " + secretAns);
		}
	}

	public void BusinessInformationPage(String BusinessName, String DoingBusnissAs, String BusniessType,
			String OwnerShipInfo, String BusinessDescription, String CountryName, String Address1,
			String State, String City, String ZipCode) {
		if (verifyElementPresence(businessName)) {
			existingBusinessName = BusinessName;
			EnterText(businessName, "Business name", BusinessName);
			logStepInfo("Business Name is entered : " + BusinessName);
		} else {
			logStepInfo("Business Name is not entered : " + BusinessName);
		}

		if (verifyElementPresence(doingBusnissAs)) {
			exisingDoingBusinessAs = DoingBusnissAs;
			EnterText(doingBusnissAs, "last name", DoingBusnissAs);
			logStepInfo(" DoingBusnissAs name is entered : " + DoingBusnissAs);

		} else {
			logStepInfo("DoingBusnissAs name is not entered : " + DoingBusnissAs);
		}

		if (verifyElementPresence(busniessType)) {
			selectDropDown(busniessType, BusniessType, "busniessType");
			logStepInfo("Busniess Type is entered : " + BusniessType);
		} else {
			logStepInfo("Busniess Type is not entered : " + BusniessType);
		}

		if (verifyElementPresence(ownerShipInfo)) {
			EnterText(ownerShipInfo, "userId", OwnerShipInfo);
			logStepInfo("UserID is entered : " + OwnerShipInfo);
		} else {
			logStepInfo("UserID is not entered : " + OwnerShipInfo);
		}

		clickElementWithWait(employmentPurpose, "clicked on employment purpose check box");

		if (verifyElementPresence(businessDescription)) {
			existingBusinessDesc = BusinessDescription;
			EnterText(businessDescription, "Business Description", BusinessDescription);
			logStepInfo("Business Description is entered: " + BusinessDescription);

		} else {
			logStepInfo("Business Description is not entered : " + BusinessDescription);
		}

		if (verifyElementPresence(businessAddInfo)) {
			clickElementWithWait(businessAddInfo, "Business address");
			logStepInfo(" businessAddInfo is clicked : ");
		} else {
			logStepInfo("businessAddInfo is not entered : ");
		}
		wait(3);
		if (verifyElementPresence(countryName)) {
			existingBusinessInfoCountry = CountryName;
			selectDropDown(countryName, CountryName, "country Name");
			logStepInfo("countryName is entered : " + CountryName);
		} else {
			logStepInfo("countryName is not entered : " + CountryName);
		}

//		if (verifyElementPresence(snn)) {
//			EnterText(snn, "Social Security Number", SNN);
//			logStepInfo("Social Security Number is entered : " + SNN);
//		} else {
//			logStepInfo("Social Security Number is not entered : " + SNN);
//		}

		if (verifyElementPresence(address1)) {
			existingBusinessInfoAddress = Address1;
			EnterText(address1, "Address1", Address1);
			logStepInfo(" Address is entered : " + Address1);
		} else {
			logStepInfo("Address is not entered : " + Address1);
		}

		if (verifyElementPresence(state)) {
			existingBusinessInfoState = State;
			selectDropDown(state, State, "State");
			logStepInfo("State is entered : " + State);
		} else {
			logStepInfo("State is not entered : " + State);
		}

		if (verifyElementPresence(city)) {
			existingBusinessInfoCity = City;
			EnterText(city, "City", City);
			logStepInfo("City is entered : " + City);
		} else {
			logStepInfo("City is not entered : " + City);
		}
		wait(3);
		if (verifyElementPresence(zipCode)) {
			existingBusinessInfoZip = ZipCode;
			EnterText(zipCode, "Zip Code", ZipCode);
			logStepInfo("Zip Code is entered : " + ZipCode);
		} else {
			logStepInfo("Zip Code is not entered : " + ZipCode);
		}

		String stateCode = driver.findElement(state).getAttribute("value");
		stateCode = stateCode.substring(stateCode.length() - 2);
		existingBusinessAddress = Address1 + ", " + City + ", " + stateCode + ", " + ZipCode;
	}

	// ####################################
	public void BusinessContactPage(String BusiContactFirstName, String BusiContactLastName, String BusiContactTitle,
			String BusiContactEmail, String BusiCountry, String SecondaryBusiContactPhoneNumber) {

		if (verifyElementPresence(busiContactFirstName)) {
			existingBusinesContactFirstName = BusiContactFirstName;
			existingBusinesContactName = BusiContactFirstName;
			EnterText(busiContactFirstName, "primary Business Contact first name", BusiContactFirstName);
			logStepInfo("primary Business Contact First Name is entered : " + BusiContactFirstName);
		} else {
			logStepInfo("primary Business Contact First Name is not entered : " + BusiContactFirstName);
		}

		if (verifyElementPresence(busiContactLastName)) {
			existingBusinesContactName += " " + BusiContactLastName;
			existingBusinesContactLastName = BusiContactLastName;
			EnterText(busiContactLastName, "primary Business Contact last name", BusiContactLastName);
			logStepInfo(" primary Business Contact last Name is entered : " + BusiContactLastName);
		} else {
			logStepInfo("primary Business Contact last Name is not entered : " + BusiContactLastName);
		}

		//clickElementWithWait(primaryContactMidlName, "clicked on Specify primary contact middle name?: No");

		if (verifyElementPresence(busiContactTitle)) {
			existingBusinessTitle = BusiContactTitle;
			EnterText(busiContactTitle, "Business contact title", BusiContactTitle);
			logStepInfo(" primary Business Contact Person title is entered : " + BusiContactTitle);
		} else {
			logStepInfo(" primary Business Contact Person title is not entered : " + BusiContactTitle);
		}
		if (verifyElementPresence(busiContactEmail)) {
			existingBusinessContactEmail = BusiContactEmail;
			EnterText(busiContactEmail, "Business Contact email", BusiContactEmail);
			logStepInfo("primary Business Contact email is entered : " + BusiContactEmail);
		} else {
			logStepInfo("primary Business Contact email is not entered : " + BusiContactEmail);
		}
		if (verifyElementPresence(busiCountry)) {
			selectDropDown(busiCountry, BusiCountry, "Country");
			existingBusinesContactCountry = BusiCountry;
			logStepInfo("primary Business Contact country is selected : " + BusiCountry);
		} else {
			logStepInfo("primary Business Contact country is not selected : " + BusiCountry);
		}

		if (verifyElementPresence(countryCode)) {
			selectDropDownByIndex(countryCode, "1", "CountryCode");
			existingBusinesContactCode = "1";
			logStepInfo("primary Business Contact country Code is selected : ");
		} else {
			logStepInfo("primary Business Contact country code is not selected : ");
		}
		if (verifyElementPresence(busiContactPhoneNumber)) {
			existingBusinesContactPN = SecondaryBusiContactPhoneNumber;
			EnterText(busiContactPhoneNumber, "Phone Number", SecondaryBusiContactPhoneNumber);
			logStepInfo("primary Business Contact phone number is entered : " + SecondaryBusiContactPhoneNumber);
		} else {
			logStepInfo("primary Business Contact phone number is not entered : " + SecondaryBusiContactPhoneNumber);
		}

	}

	public void SecondaryBusinessCont(String secondaryBusiContactLastName, String secondaryBusiContactTitle,
			String secondaryBusiContactEmail, String secondaryBusiCountry, String secondaryBusiContactPhoneNumber) {

		clickElementWithWait(SecondaryBusinessContact, "Click to Add a Secondary Business Contact");
		if (verifyElementPresence(SecondarybusiContactFirstName)) {
			existingBusinesContactFirstName = secondaryBusiContactLastName;
			existingBusinesContactName = secondaryBusiContactLastName;
			EnterText(SecondarybusiContactFirstName, "primary Business Contact first name",
					secondaryBusiContactLastName);
			logStepInfo("primary Business Contact First Name is entered : " + secondaryBusiContactLastName);
		} else {
			logStepInfo("primary Business Contact First Name is not entered : " + SecondarybusiContactFirstName);
		}

		if (verifyElementPresence(SecondarybusiContactLastName)) {
			existingBusinesContactName += " " + secondaryBusiContactLastName;
			existingBusinesContactLastName = secondaryBusiContactLastName;
			EnterText(SecondarybusiContactLastName, "primary Business Contact last name", secondaryBusiContactLastName);
			logStepInfo(" primary Business Contact last Name is entered : " + secondaryBusiContactLastName);
		} else {
			logStepInfo("primary Business Contact last Name is not entered : " + SecondarybusiContactLastName);
		}

	//	clickElementWithWait(primaryContactMidlName, "clicked on Specify primary contact middle name?: No");

		if (verifyElementPresence(SecondarybusiContactTitle)) {
			existingBusinessTitle = secondaryBusiContactTitle;
			EnterText(SecondarybusiContactTitle, "Business contact title", secondaryBusiContactTitle);
			logStepInfo(" primary Business Contact Person title is entered : " + secondaryBusiContactTitle);
		} else {
			logStepInfo(" primary Business Contact Person title is not entered : " + SecondarybusiContactTitle);
		}
		if (verifyElementPresence(SecondarybusiContactEmail)) {
			existingBusinessContactEmail = secondaryBusiContactEmail;
			EnterText(SecondarybusiContactEmail, "Business Contact email", secondaryBusiContactEmail);
			logStepInfo("primary Business Contact email is entered : " + secondaryBusiContactEmail);
		} else {
			logStepInfo("primary Business Contact email is not entered : " + SecondarybusiContactEmail);
		}
		if (verifyElementPresence(SecondarybusiCountry)) {
			selectDropDown(SecondarybusiCountry, secondaryBusiCountry, "Country");
			existingBusinesContactCountry = secondaryBusiCountry;
			logStepInfo("primary Business Contact country is selected : " + secondaryBusiCountry);
		} else {
			logStepInfo("primary Business Contact country is not selected : " + secondaryBusiCountry);
		}

		if (verifyElementPresence(SecondarycountryCode)) {
			selectDropDownByIndex(SecondarycountryCode, "1", "CountryCode");
			existingBusinesContactCode = "1";
			logStepInfo("primary Business Contact country Code is selected : ");
		} else {
			logStepInfo("primary Business Contact country code is not selected : ");
		}
		if (verifyElementPresence(SecondarybusiContactPhoneNumber)) {
			existingBusinesContactPN = secondaryBusiContactPhoneNumber;
			EnterText(SecondarybusiContactPhoneNumber, "Phone Number", secondaryBusiContactPhoneNumber);
			logStepInfo("primary Business Contact phone number is entered : " + secondaryBusiContactPhoneNumber);
		} else {
			logStepInfo("primary Business Contact phone number is not entered : " + secondaryBusiContactPhoneNumber);
		}

	}

	// ************************************************************
	public void businessBillingPage(String BusiContactFirstName, String BusiContactLastName, String BusiContactTitle,
			String BusiContactEmail, String BusiCountry, String BusiContactPhoneNumber,  String CountryName, String Address1, String State, String City, String ZipCode) {

		if (verifyElementPresence(addBillingContact)) {
			clickElementWithWait(addBillingContact, "click to add a billing contact");
			logStepInfo("Add Billing Contact link is clicked.");
		} else {
			logStepInfo("Add Billing Contact link is not clicked.");
		}

		if (verifyElementPresence(billingContactFirstName)) {
			existingBillingContactName = BusiContactFirstName;
			EnterText(billingContactFirstName, "primary Billing Contact first name", BusiContactFirstName);
			logStepInfo("primary Billing Contact First Name is entered : " + BusiContactFirstName);
		} else {
			logStepInfo("primary Billing Contact First Name is not entered : " + BusiContactFirstName);
		}

		if (verifyElementPresence(billingContactLastName)) {
			existingBillingContactName += " " + BusiContactLastName;
			EnterText(billingContactLastName, "primary Billing Contact last name", BusiContactLastName);
			logStepInfo(" primary Billing Contact last Name is entered : " + BusiContactLastName);
		} else {
			logStepInfo("primary Billing Contact last Name is not entered : " + BusiContactLastName);
		}
		clickElementWithWait(primaryBillingContactMidlName, "clicked on Specify primary contact middle name?: No");

		if (verifyElementPresence(billingContactTitle)) {
			EnterText(billingContactTitle, "Billing contact title", BusiContactTitle);
			logStepInfo(" primary Billing Contact Person title is entered : " + BusiContactTitle);
		} else {
			logStepInfo(" primary Billing Contact Person title is not entered : " + BusiContactTitle);
		}
		if (verifyElementPresence(billingContactEmail)) {
			EnterText(billingContactEmail, "Billing Contact email", BusiContactEmail);
			logStepInfo("primary Billing Contact email is entered : " + BusiContactEmail);
		} else {
			logStepInfo("primary Billing Contact email is not entered : " + BusiContactEmail);
		}
		if (verifyElementPresence(billingContactCountry)) {
			selectDropDown(billingContactCountry, BusiCountry, "Country");
			logStepInfo("primary Billing Contact country is selected : " + BusiCountry);
		} else {
			logStepInfo("primary Billing Contact country is not selected : " + BusiCountry);
		}

		if (verifyElementPresence(billingCountryCode)) {
			selectDropDownByIndex(billingCountryCode, "1", "CountryCode");
			logStepInfo("primary Billing Contact country Code is selected : ");
		} else {
			logStepInfo("primary Billing Contact country code is not selected : ");
		}
		if (verifyElementPresence(billingContactPhoneNumber)) {
			EnterText(billingContactPhoneNumber, "Phone Number", BusiContactPhoneNumber);
			logStepInfo("primary Billing Contact phone number is entered : " + BusiContactPhoneNumber);
		} else {
			logStepInfo("primary Billing Contact phone number is not entered : " + BusiContactPhoneNumber);
		}
		
		if (verifyElementPresence(BillingCountry)) {
	//		existingBusinessInfoCountry = CountryName;
			selectDropDown(BillingCountry, CountryName, "country Name");
			logStepInfo("countryName is entered : " + CountryName);
		} else {
			logStepInfo("countryName is not entered : " + CountryName);
		}
		
		if (verifyElementPresence(billingAddress)) {
			existingBusinessInfoAddress = Address1;
			EnterText(billingAddress, "Address1", Address1);
			logStepInfo(" Address is entered : " + Address1);
		} else {
			logStepInfo("Address is not entered : " + Address1);
		}

		if (verifyElementPresence(billingCity)) {
			existingBusinessInfoCity = City;
			EnterText(billingCity, "City", City);
			logStepInfo("City is entered : " + City);
		} else {
			logStepInfo("City is not entered : " + City);
		}
		if (verifyElementPresence(billingState)) {
			existingBusinessInfoState = State;
			selectDropDown(billingState, State, "State");
			logStepInfo("State is entered : " + State);
		} else {
			logStepInfo("State is not entered : " + State);
		}
		wait(3);
		if (verifyElementPresence(billingZipCode)) {
			existingBusinessInfoZip = ZipCode;
			EnterText(billingZipCode, "Zip Code", ZipCode);
			logStepInfo("Zip Code is entered : " + ZipCode);
		} else {
			logStepInfo("Zip Code is not entered : " + ZipCode);
		}
//		
//		String stateCode = driver.findElement(state).getAttribute("value");
//		stateCode = stateCode.substring(stateCode.length() - 2);
//		existingBusinessAddress= Address1 + ", " + City + ", " + stateCode + ", " + ZipCode;
		
//		clickElementWithWait(billingAddressSameRadio,
//				"clicked on My billing address is the same as my business address");

	}

	public void businessSignaturePage(String convazSign) {
		clickElementWithWait(adopAndSign, "clicked on Adop and Sign check box");
		actionPerform(ConvasSign, "Draw on Signature Canvas");
	}

	public void selectingValue(String value) {
	if (verifyElementPresence(countryName)) {
		existingBusinessInfoCountry = value;
		selectDropDown(countryName, value, "country Name");
		logStepInfo("countryName is entered : " + value);
	}else if(verifyElementPresence(busiCountry)) {
		existingBusinessInfoCountry = value;
		selectDropDown(busiCountry, value, "country Name");
		logStepInfo("countryName is entered : " + value);
	}else if(verifyElementPresence(BillingCountry)) {
		existingBusinessInfoCountry = value;
		selectDropDown(BillingCountry, value, "Billing address country Name selected");
		logStepInfo("countryName is entered : " + value);
	}else {
		logStepInfo("countryName is not entered : " + value);
	}
	
}
	public void selectingSecondaryCountry(String value) {
		if(verifyElementPresence(SecondarybusiCountry)) {
			existingBusinessInfoCountry = value;
			selectDropDown(SecondarybusiCountry, value, "country Name");
			logStepInfo("secondary business contact countryName is entered : " + value);
		}
		else {
			logStepInfo("countryName is not entered : " + value);
		}
    }
	
	
}
