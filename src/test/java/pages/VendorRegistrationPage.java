package pages;

import Utility.CurrentDateTime;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import seleniumhelper.BaseClass;

public class VendorRegistrationPage extends BaseClass {

	private static String Address;
	private static String City;
	private static String State;
	private static String ZipCode;
	private static String FirstNamePrincipal;
	private static String LastNamePrincipal;
	private static String Businessdescription;
	private static String userid;
	private static String secretQuestion;
	private static String secretAnswer;
	private static String typeOfBusiness;
	private static String doingBusinessAs;
	private static String OwnerShipInfo;
	private static String SSNbusiness;
	private static String PhoneBusiness;
	private static String businessQuestion;
	private static String businessAnswer;
	private static String PhonePrincipal;
	private static String SSNprincipal;
	private static String DOBprincipal;
	private static String FirstNameBilling;
	private static String LastNameBilling;
	private static String FirstNameSecondary;
	private static String LastNameSecondary;
	private static String phoneSecondary;
	private static String previousConviction;
	private static String Email;
	
	// Service Provider Profile
	private By userIDTB = By.xpath("//input[@name='vevaUser.vuUserLoginId']");
	private By PasswordTB = By.xpath("//input[@id='vevaUser.vuPasswordToShow']");
	private By reEnterPasswordTB = By.xpath("//input[@id='password2ToShow']");
	private By secretQTNDD = By.xpath("//select[@name='vevaUser.vuSecretQuestionId']");
	private By secretAnsTB = By.xpath("//input[@name='vevaUser.vuSecretAnswer']");
	private By PasswordTBQC = By.xpath("//input[@name='vevaUser.vuPassword']");
	private By reEnterPasswordTBQC = By.xpath("//input[@name='password2']");

	// Business Information
	private By BusinessCountryDD = By.xpath("//select[@name='vevaVendor.vvCountry']");
	private By legalBusinessNameTB = By.xpath("//input[@name='vevaVendor.vvName']");
	private By doingBusinessAsTB = By.xpath("//input[@name='vevaVendor.doingBusinessAs']");
	private By TypeOfBusinessDD = By.xpath("//select[@name='vevaVendor.vvOwnershipType']");
	private By ownershipInfoTB = By.xpath("//input[@name='vevaVendor.vvOwnershipInfo']");
	private By businessSSNTB = By.xpath("//input[@name='vevaVendor.vvSSN']");
	private By businessAddress1TB = By.xpath("//input[@name='vevaVendor.vvAddress1']");
	private By businessCityTB = By.xpath("//input[@name='vevaVendor.vvCity']");
	private By businessStateDD = By.xpath("//select[@name='vevaVendor.vvStateCode']");
	private By businessZipTB = By.xpath("//input[@name='vevaVendor.vvZipCode']");
	private By businessPhoneTB = By.xpath("//input[@name='vevaVendor.vvdPhone']");
	private By prePostEmploymentChkBox = By.xpath("//input[@name='preAndPostHidden']");
	private By contractorChkBox = By.xpath("//input[@name='volunteerHidden']");
	private By BusinessDescTxtArea = By.xpath("//textarea[@name='vevaVendor.bussinessDescription']");

	// Business Questionire
	private By businessRelationDD = By.xpath("//select[@name='customerQuestionAnswer[0].answerId']");
	private By contactPersonTB = By.xpath("//input[@name='customerQuestionAnswer[1].answerId']");

	// Principal contact information
	private By principalCountryDD = By.xpath("//select[@name='addressForm.countryCode']");
	private By principalAddress1TB = By.xpath("//input[@name='addressForm.addrLine1']");
	private By principalCityTB = By.xpath("//input[@name='addressForm.cityName']");
	private By principalStateDD = By.xpath("//select[@name='addressForm.stateCode']");
	private By principalZipCodeTB = By.xpath("//input[@name='addressForm.zipCode']");
	private By principalSSNTB = By.xpath("//input[@name='individual.viSsn']");
	private By principalDObTB = By.xpath("//input[@name='individual.stringToDob']");
	private By principalFirstNameTB = By.xpath("//input[@name='vevaVendor.vvFirstName']");
	private By principalLastNameTB = By.xpath("//input[@name='vevaVendor.vvLastName']");
	private By principalTitleTB = By.xpath("//input[@name='vevaVendor.vvTitle']");
	private By principalPhoneTB = By.xpath("//input[@name='vevaVendor.vvPhone']");
	private By principalEmailTB = By.xpath("//input[@name='vevaVendor.vvEmail']");

	// Billing Contract Information
	private By billingCountryDD = By.xpath("//select[@name='address.countryCode']");
	private By billingAddress1TB = By.xpath("//input[@name='address.addrLine1']");
	private By billingCityTB = By.xpath("//input[@name='address.cityName']");
	private By billingStateDD = By.xpath("//select[@name='address.stateCode']");
	private By billingZipTB = By.xpath("//input[@name='address.zipCode']");
	private By billingFirstnameTB = By.xpath("//input[@name='address.firstName']");
	private By billingLastNameTB = By.xpath("//input[@name='address.lastName']");
	private By billingEmailTB = By.xpath("//input[@name='address.emailAddress']");

	// Secondary Contact Information
	private By defaultRadioBtn = By.xpath("//input[@name='hasAddAnotherPersonSelected' and @checked]");
	private By secondayContactInformationYESRadioBtn = By
			.xpath("//input[@name='hasAddAnotherPersonSelected' and @value='Y']");
	private By secondaryFirstNameTB = By.xpath("//input[@name='vevaVendor.vvaFirstName']");
	private By secondaryLastNameTB = By.xpath("//input[@name='vevaVendor.vvaLastName']");
	private By secondaryEmailTB = By.xpath("//input[@name='vevaVendor.vvaEmail']");
	private By secondaryPhoneTB=By.xpath("//input[@name='vevaVendor.vvaPhoneNumber']");

	// previous convictions
	private By convictionTextArea = By.xpath("//textarea[@name='regAdmittedCriminalInfo']");
	
	//validation
	private By prepostChecked=By.xpath("//input[@name='prePostYes' and @checked]");
	private By contractorChecked=By.xpath("//input[@name='ContractorYes' and @checked]");

	public void serviceProviderProfile(String UserID, String Password, String SecretQtn, String SecretAns) {
		String value = null;

		value = UserID;
		if (verifyElementPresence(userIDTB)) {
			EnterText(userIDTB, "User ID", value);
			userid=value;
		}

		value = Password;
		if (verifyElementPresence(PasswordTB)) {
			EnterText(PasswordTB, "Password", value);
		}else if (verifyElementPresence(PasswordTBQC)) {
			EnterText(PasswordTBQC, "Password", value);
		}

		if (verifyElementPresence(reEnterPasswordTB)) {
			EnterText(reEnterPasswordTB, "Re enter Password", value);
		}else if (verifyElementPresence(reEnterPasswordTBQC)) {
			EnterText(reEnterPasswordTBQC, "Re enter Password", value);
		}

		value = SecretQtn;
		if (verifyElementPresence(secretQTNDD)) {
			selectDropDown(secretQTNDD, value, "secret Qtn");
			secretQuestion=value;
		}

		value = SecretAns;
		if (verifyElementPresence(secretAnsTB)) {
			EnterText(secretAnsTB, "Secret Answer", value);
			secretAnswer=value;
		}
	}

	public void businessInformation(String BusinessCountry, String LegalBusinessName, String DoingBusinessAs,
			String TypeOfBusiness, String ownerShipInfo, String BusinessSSN, String BusinessAddress1,
			String BusinessCity, String BusinessState, String BusinessZip, String BusinessPhone,
			String BusinessDescription) {
		String value = null;

		value = BusinessCountry;
		if (verifyElementPresence(BusinessCountryDD)) {
			selectDropDown(BusinessCountryDD, value, "Business Country");
		}

		value = LegalBusinessName;
		if (verifyElementPresence(legalBusinessNameTB)) {
			EnterText(legalBusinessNameTB, "Legal Business Name", value);
			LeagalBusinessName=value;
		}

		value = DoingBusinessAs;
		if (verifyElementPresence(doingBusinessAsTB)) {
			EnterText(doingBusinessAsTB, "Doing Business As", value);
			doingBusinessAs=value;
		}

		value = TypeOfBusiness;
		if (verifyElementPresence(TypeOfBusinessDD)) {
			selectDropDown(TypeOfBusinessDD, value, "Type of Business");
			typeOfBusiness=value;
		}

		value = ownerShipInfo;
		if (verifyElementPresence(ownershipInfoTB)) {
			EnterText(ownershipInfoTB, "Ownership Info", value);
			OwnerShipInfo=value;
		}

		value = BusinessSSN;
		if (verifyElementPresence(businessSSNTB)) {
			EnterText(businessSSNTB, "Business SSN", value);
			SSNbusiness=value;
		}

		value = BusinessAddress1;
		if (verifyElementPresence(businessAddress1TB)) {
			EnterText(businessAddress1TB, "Business Address1", value);
			Address=value;
		}

		value = BusinessCity;
		if (verifyElementPresence(businessCityTB)) {
			EnterText(businessCityTB, "Business City", value);
			City=value;
		}

		value = BusinessState;
		if (verifyElementPresence(businessStateDD)) {
			selectDropDown(businessStateDD, value, "Business State");
			State=value;
		}

		value = BusinessZip;
		if (verifyElementPresence(businessZipTB)) {
			EnterText(businessZipTB, "Business Zip", value);
			ZipCode=value;
		}

		value = BusinessPhone;
		if (verifyElementPresence(businessPhoneTB)) {
			EnterText(businessPhoneTB, "Business Phone", value);
			PhoneBusiness=value;
		}

		if (verifyElementPresence(prePostEmploymentChkBox)) {
			clickElement(prePostEmploymentChkBox, "Pre/Post Employment");
		}

		if (verifyElementPresence(contractorChkBox)) {
			clickElement(contractorChkBox, "Contractor");
		}

		value = BusinessDescription;
		if (verifyElementPresence(BusinessDescTxtArea)) {
			EnterText(BusinessDescTxtArea, "Business Description", value);
			Businessdescription=value;
		}
	}

	public void businessQuestionnaire(String BusinessRelation, String ContactPerson) {
		String value = null;

		value = BusinessRelation;
		if (verifyElementPresence(businessRelationDD)) {
			selectDropDown(businessRelationDD, value, "Business Relation");
			businessQuestion=value;
		}

		value = ContactPerson;
		if (verifyElementPresence(contactPersonTB)) {
			EnterText(contactPersonTB, "Contact Person", value);
			businessAnswer=value;
		}
	}

	public void principalContactInformation(String PrincipalCountry, String PrincipalAddress1, String PrincipalCity,
			String PrincipalState, String PrincipalZipCode, String PrincipalSSN, String PrincipalDOB,
			String PrincipalFirstName, String PrincipalLastName, String PrincipalTitle, String PrincipalPhone,
			String PrincipalEmail) {
		String value = null;

		value = PrincipalCountry;
		if (verifyElementPresence(principalCountryDD)) {
			selectDropDown(principalCountryDD, value, "Principal country");
		}

		value = PrincipalAddress1;
		if (verifyElementPresence(principalAddress1TB)) {
			EnterText(principalAddress1TB, "Principal Address1", value);
		}

		value = PrincipalCity;
		if (verifyElementPresence(principalCityTB)) {
			EnterText(principalCityTB, "principal City", value);
		}

		value = PrincipalState;
		if (verifyElementPresence(principalStateDD)) {
			selectDropDown(principalStateDD, value, "Principal state");
		}

		value = PrincipalZipCode;
		if (verifyElementPresence(principalZipCodeTB)) {
			EnterText(principalZipCodeTB, "principal Zip", value);
		}

		value = PrincipalSSN;
		if (verifyElementPresence(principalSSNTB)) {
			EnterText(principalSSNTB, "Principal SSN", value);
			SSNprincipal=value;
		}

		value = PrincipalDOB;
		if (verifyElementPresence(principalDObTB)) {
			EnterText(principalDObTB, "Principal DOB", value);
			DOBprincipal=value;
		}

		value = PrincipalFirstName;
		if (verifyElementPresence(principalFirstNameTB)) {
			EnterText(principalFirstNameTB, "Principal FirstName", value);
			FirstNamePrincipal=value;
			VendorNameNonHD=value;
		}

		value = PrincipalLastName;
		if (verifyElementPresence(principalLastNameTB)) {
			EnterText(principalLastNameTB, "Principal LastName", value);
			LastNamePrincipal=value;
			VendorLastNameNonHD=value;
		}

		value = PrincipalTitle;
		if (verifyElementPresence(principalTitleTB)) {
			EnterText(principalTitleTB, "Principal Title", value);
		}

		value = PrincipalPhone;
		if (verifyElementPresence(principalPhoneTB)) {
			EnterText(principalPhoneTB, "Principal Phone", value);
			PhonePrincipal=value;
		}

		value = PrincipalEmail;
		if (verifyElementPresence(principalEmailTB)) {
			EnterText(principalEmailTB, "principal Email", value);
			Email=value;
		}
	}

	public void billingContactInformation(String BillingCountry, String BillingAddress1, String BillingCity,
			String BillingState, String BillingZip, String BillingFirstName, String BillingLastName,
			String BillingEmail) {
		String value = null;

		value = BillingCountry;
		if (verifyElementPresence(billingCountryDD)) {
			selectDropDown(billingCountryDD, value, "Billing Country");
		}

		value = BillingAddress1;
		if (verifyElementPresence(billingAddress1TB)) {
			EnterText(billingAddress1TB, "Billing Address1", value);
		}

		value = BillingCity;
		if (verifyElementPresence(billingCityTB)) {
			EnterText(billingCityTB, "Billing City", value);
		}

		value = BillingState;
		if (verifyElementPresence(billingStateDD)) {
			selectDropDown(billingStateDD, value, "Billing State");
		}

		value = BillingZip;
		if (verifyElementPresence(billingZipTB)) {
			EnterText(billingZipTB, "Billing Zip", value);
		}

		value = BillingFirstName;
		if (verifyElementPresence(billingFirstnameTB)) {
			EnterText(billingFirstnameTB, "Billing FirstName", value);
			FirstNameBilling=value;
		}

		value = BillingLastName;
		if (verifyElementPresence(billingLastNameTB)) {
			EnterText(billingLastNameTB, "Billing Lastname", value);
			LastNameBilling=value;
		}

		value = BillingEmail;
		if (verifyElementPresence(billingEmailTB)) {
			EnterText(billingEmailTB, "Billing Email", value);
		}
	}

	public void secondaryContactInformation(String SecondaryFirstName,String SecondaryLastName,String SecondaryEmail,String SecondaryPhone) {
		String value = null;

		if (verifyElementPresence(defaultRadioBtn)) {
			reportLog(Status.PASS, "Secondary Contact Information Pre-selected NO", true);
		} else {
			reportLog(Status.FAIL, "Secondary Contact Information Pre-selected NO", true);
		}

		if (verifyElementPresence(secondayContactInformationYESRadioBtn)) {
			clickElement(secondayContactInformationYESRadioBtn, "secondary contact information YES");
		}

		value=SecondaryFirstName;
		if (verifyElementPresence(secondaryFirstNameTB)) {
			EnterText(secondaryFirstNameTB, "Secondary FirstName", value);
			FirstNameSecondary=value;
		}

		value=SecondaryLastName;
		if (verifyElementPresence(secondaryLastNameTB)) {
			EnterText(secondaryLastNameTB, "secondary LastName", value);
			LastNameSecondary=value;
		}

		value=SecondaryEmail;
		if (verifyElementPresence(secondaryEmailTB)) {
			EnterText(secondaryEmailTB, "Secondary Email", value);
		}

		value=SecondaryPhone;
		if (verifyElementPresence(secondaryPhoneTB)) {
			EnterText(secondaryPhoneTB, "Secondary Phone", value);
			phoneSecondary=value;
		}
	}
	
	public void previousConviction(String value) {
		if(verifyElementPresence(convictionTextArea)) {
			EnterText(convictionTextArea, "Previous Conviction", value);
			previousConviction=value;
		}
	}
	
	public void agreementPage(String CompanyName) throws Exception {
		
		String Date=CurrentDateTime.SystemDateMMDD();
		int legalBusinessName=driver.findElements(By.xpath("//u[.='"+LeagalBusinessName+"']")).size();
		if(legalBusinessName==2) {
			reportLog(Status.PASS, "Legal Business Name is Present-->"+LeagalBusinessName, false);
		}else{
			reportLog(Status.FAIL, "Legal Business Name is not Present in 2 places-->"+LeagalBusinessName, false);
		}
		
		if(verifyElementPresence(By.xpath("//u[.='"+Address+","+City+","+State+","+ZipCode+"']"))) {
			reportLog(Status.PASS, "Address is present "+Address+","+City+","+State+","+ZipCode, false);
		}else {
			reportLog(Status.FAIL, "Address Not Found", false);
		}
		
		if(CompanyName==null||CompanyName.equalsIgnoreCase("")) {
			CompanyName=LeagalBusinessName;
		}
		
		if(verifyElementPresence(By.xpath("//u[.='"+CompanyName+"']"))) {
			reportLog(Status.PASS, "Company Name is Present "+CompanyName, false);
		}else {
			reportLog(Status.FAIL, "Company Name is not Present "+CompanyName, false);
		}
		
		int PrincipalName=driver.findElements(By.xpath("//u[.='"+FirstNamePrincipal+" "+LastNamePrincipal+"']")).size();
		if(PrincipalName==2) {
			reportLog(Status.PASS, "Principal Name is Present-->"+FirstNamePrincipal+" "+LastNamePrincipal, false);
		}else{
			reportLog(Status.FAIL, "Principal Name is not Present in 2 places-->"+FirstNamePrincipal+" "+LastNamePrincipal, false);
		}
		
		int date=driver.findElements(By.xpath("//u[.='"+Date+"']")).size();
		if(date==4) {
			reportLog(Status.PASS, "Date Present-->"+Date, false);
		}else{
			reportLog(Status.FAIL, "Date is not Present in 4 places-->"+Date, false);
		}
		
		if(verifyElementPresence(By.xpath("//u[.='"+Businessdescription+"']"))) {
			reportLog(Status.PASS, "Business Description is Present "+Businessdescription, false);
		}else {
			reportLog(Status.FAIL, "Business Description is not Present "+Businessdescription, false);
		}
		
		if(verifyElementPresence(prepostChecked) && verifyElementPresence(contractorChecked)) {
			reportLog(Status.PASS, "Pre/Post and Contractor Check box are present and are Checked", false);
		}else{
			reportLog(Status.FAIL, "Pre/Post and Contractor Check box are not present and are not Checked", false);
		}
		
		String text=driver.findElement(By.xpath("//span[.='Bret T. Jardine']/../../../../..//span[.='EVP, General Counsel']/../../../../..//span[@style='text-transform:uppercase']")).getText();
		if(text.equalsIgnoreCase("FIRST ADVANTAGE ENTERPRISE SCREENING CORPORATION")) {
			reportLog(Status.PASS, "First Advantage Address Is Present", false);
		}else {
			reportLog(Status.FAIL, "First Advantage Address Is not Present", false);
		}
	}
	
public void agreementPageNotification(String CompanyName) throws Exception {
		
		String Date=CurrentDateTime.SystemDateMMDD();
		int legalBusinessName=driver.findElements(By.xpath("//u[.='"+LeagalBusinessName+"']")).size();
		if(legalBusinessName==2) {
			reportLog(Status.PASS, "Legal Business Name is Present-->"+LeagalBusinessName, false);
		}else{
			reportLog(Status.FAIL, "Legal Business Name is not Present in 2 places-->"+LeagalBusinessName, false);
		}
		
		if(verifyElementPresence(By.xpath("//u[.='"+Address+","+City+","+State+","+ZipCode+"']"))) {
			reportLog(Status.PASS, "Address is present "+Address+","+City+","+State+","+ZipCode, false);
		}else {
			reportLog(Status.FAIL, "Address Not Found", false);
		}
		
		if(CompanyName==null||CompanyName.equalsIgnoreCase("")) {
			CompanyName=LeagalBusinessName;
		}
		
		if(verifyElementPresence(By.xpath("//u[.='"+CompanyName+"']"))) {
			reportLog(Status.PASS, "Company Name is Present "+CompanyName, false);
		}else {
			reportLog(Status.FAIL, "Company Name is not Present "+CompanyName, false);
		}
		
		int PrincipalName=driver.findElements(By.xpath("//u[.='"+FirstNamePrincipal+" "+LastNamePrincipal+"']")).size();
		if(PrincipalName==2) {
			reportLog(Status.PASS, "Principal Name is Present-->"+FirstNamePrincipal+" "+LastNamePrincipal, false);
		}else{
			reportLog(Status.FAIL, "Principal Name is not Present in 2 places-->"+FirstNamePrincipal+" "+LastNamePrincipal, false);
		}
		
		int date=driver.findElements(By.xpath("//u[.='"+Date+"']")).size();
		if(date==4) {
			reportLog(Status.PASS, "Date Present-->"+Date, false);
		}else{
			reportLog(Status.FAIL, "Date is not Present in 4 places-->"+Date, false);
		}
		
		if(verifyElementPresence(By.xpath("//u[.='"+Businessdescription+"']"))) {
			reportLog(Status.PASS, "Business Description is Present "+Businessdescription, false);
		}else {
			reportLog(Status.FAIL, "Business Description is not Present "+Businessdescription, false);
		}
		/*
		 * if(verifyElementPresence(prepostChecked) &&
		 * verifyElementPresence(contractorChecked)) { reportLog(Status.PASS,
		 * "Pre/Post and Contractor Check box are present and are Checked", false);
		 * }else{ reportLog(Status.FAIL,
		 * "Pre/Post and Contractor Check box are not present and are not Checked",
		 * false); }
		 */
		String text=driver.findElement(By.xpath("//span[.='Bret T. Jardine']/../../../../..//span[.='EVP, General Counsel']/../../../../..//span[@style='text-transform:uppercase']")).getText();
		if(text.equalsIgnoreCase("FIRST ADVANTAGE ENTERPRISE SCREENING CORPORATION")) {
			reportLog(Status.PASS, "First Advantage Address Is Present", false);
		}else {
			reportLog(Status.FAIL, "First Advantage Address Is not Present", false);
		}
	}
	
	public void verfyPersonalInformation() {
		
		int address=driver.findElements(By.xpath("//td[contains(.,'Business Information')]//td[contains(.,'"+Address+"')]")).size();
		int city=driver.findElements(By.xpath("//td[contains(.,'Business Information')]//td[contains(.,'"+City+"')]")).size();
		int state=driver.findElements(By.xpath("//td[contains(.,'Business Information')]/..//td[contains(.,'"+State+"')]")).size();
		int zip=driver.findElements(By.xpath("//td[contains(.,'Business Information')]//td[contains(.,'"+ZipCode+"')]")).size();
		int email=driver.findElements(By.xpath("//td[contains(.,'Business Information')]//td[contains(.,'"+Email+"')]")).size();
		
		if(address==3 & city==3 & state==3 & zip==3 & email==3) {
			reportLog(Status.PASS, "Address is Present as Expected", false);
		}else {
			reportLog(Status.FAIL, "Address is not Present as Expected", false);
		}
		
		verifyTextPresence(LeagalBusinessName);
		verifyTextPresence(FirstNamePrincipal);
		verifyTextPresence(LastNamePrincipal);
		verifyTextPresence(userid);
		verifyTextPresence(secretQuestion);
		verifyTextPresence(secretAnswer);
		verifyTextPresence(typeOfBusiness);
		verifyTextPresence(doingBusinessAs);
		verifyTextPresence(OwnerShipInfo);
		verifyTextPresence(SSNbusiness);
		verifyTextPresence(PhoneBusiness);
		verifyTextPresence(businessQuestion);
		verifyTextPresence(businessAnswer);
		verifyTextPresence(PhonePrincipal);
		verifyTextPresence(SSNprincipal);
		verifyTextPresence(DOBprincipal);
		verifyTextPresence(FirstNameBilling);
		verifyTextPresence(LastNameBilling);
		verifyTextPresence(FirstNameSecondary);
		verifyTextPresence(LastNameSecondary);
		verifyTextPresence(phoneSecondary);
		verifyTextPresence(previousConviction);
	}
}
