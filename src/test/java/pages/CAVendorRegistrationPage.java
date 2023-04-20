package pages;

import Utility.ExcelReader;
import Utility.PropertyFileReader;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import seleniumhelper.BaseClass;

public class CAVendorRegistrationPage extends BaseClass {
	ExcelReader _dataRepo = new ExcelReader();

	public By vendorRegLbl = By.xpath("/html/body/table/tbody/tr/td/form/table[1]/tbody/tr[1]/td/div/b");
	public By agreementLbl = By.xpath("/html/body/table/tbody/tr/td/table[1]/tbody/tr[1]/td/div[3]/b");
	public By electronicSignLbl = By.xpath("//*[@id='agreement-nameInfo']/font/div[3]/h6");
	public By electronicSignTextArea = By.xpath("//*[@id='signatureImage1']/canvas");
	public By iAgreeBtn = By.xpath("//*[@id='registerBtn']");
	public By personalInfoLbl = By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/table/tbody/tr[1]/td/b");
	public By confirmBtn = By.xpath("//*[@id='confirmation1']/td[1]/input");
	public By thanksMsgLbl = By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[2]/td/b");

	public By createUserIdTxt = By.xpath("//*[@name='vevaUser.vuUserLoginId']");
	public By passwordTxt = By.xpath("//input[@name='vevaUser.vuPassword']");
	public By repasswordTxt = By.xpath("//input[@name='password2']");
	public By secretQuestionDdl = By.xpath("//*[@name='vevaUser.vuSecretQuestionId']");
	public By secretQuestionTxt = By.xpath("//*[@name='vevaUser.vuSecretAnswer']");

	public By countryDdl = By.xpath("//*[@id='countryCode']");
	public By legalBusinessNameTxt = By.xpath("//*[@name='vevaVendor.vvName']");
	public By doingBusinessAsTxt = By.xpath("//*[@name='vevaVendor.doingBusinessAs']");
	public By typeOfBusinessDdl = By.xpath("//*[@name='vevaVendor.vvOwnershipType']");
	public By ownershipTxt = By.xpath("//*[@name='vevaVendor.vvOwnershipInfo']");
	public By ssnYRadio = By.xpath("//*[@name='isSSNRequired' ][1]");
	public By ssnNRadio = By.xpath("//*[@name='isSSNRequired' ][2]");
	public By ssnTxt = By.xpath("//*[@id='ssnTextBox']");
	public By addressTxt = By.xpath("//*[@id='addrLine1']");
	public By cityTxt = By.xpath("//*[@id='cityName']");
	public By stateDdl = By.xpath("//*[@id='stateCode']");
	public By zipCodeTxt = By.xpath("//*[@id='zipCode']");
	public By phoneTxt = By.xpath("//*[@name='vevaVendor.vvdPhone']");
	public By employmentPreCheck = By.xpath("//*[@name='preAndPostHidden']");
	public By employmentVolunteerCheck = By.xpath("//*[@name='contractorHidden']");
	public By employmentContractorCheck = By.xpath("//*[@name='volunteerHidden']");
	public By businessDescrTxt = By.xpath("//*[@id='regAdmittedCriminalInfo']");

	public By LockheedLOBCheck = By.xpath("//*[@id='761']");
	public By LockheedLOB1Check = By.xpath("//*[@id='762']");
	public By LockheedLOB2Check = By.xpath("//*[@id='763']");

	public By countryPCIDdl = By.xpath("//*[@name='addressForm.countryCode']");
	public By legalFirstNameTxt = By.xpath("//*[@id='vvFirstName']");
	public By middleNameTxt = By.xpath("//*[@id='vvMiddleName']");
	public By legalLastNameTxt = By.xpath("//*[@id='vvLastName']");
	public By middleNameYRadio = By.xpath("//*[@name='middleNameRequired' ][1]");
	public By middleNameNRadio = By.xpath("//*[@name='middleNameRequired' ][2]");
	public By suffixTxt = By.xpath("//*[@id='vvNameSuffix']");
	public By titleTxt = By.xpath("//*[@name='vevaVendor.vvTitle']");
	public By phonePCITxt = By.xpath("//*[@id='vvPhone']");
	public By phoneExtTxt = By.xpath("//*[@name='vevaVendor.vvPhoneExt']");
	public By faxTxt = By.xpath("//*[@name='vevaVendor.vvFax']");
	public By eMailTxt = By.xpath("//*[@id='vvEmail']");

	public By sameAddressAsBusinessChk = By.xpath("//*[@id='isBillingInfoSame']");

	public By addressPCITxt = By.xpath("//*[@id='billingAddress_addrLine1']");
	public By cityPCITxt = By.xpath("//*[@id='billingAddress_cityName']");
	public By statePCIDdl = By.xpath("//*[@id='billingAddress_stateCode']");
	public By zipPCITxt = By.xpath("//*[@id='billingAddress_zipCode']");
	public By firstPCITxt = By.xpath("//*[@id='billingAddress_vvFirstName']");
	public By lastPCITxt = By.xpath("//*[@id=\"billingAddress_vvLastName\"]");
	public By suffixPCITxt = By.xpath("//*[@id='billingAddress_vvNameSuffix']");
	public By emailPCITxt = By.xpath("//*[@id='billingAddress_vvEmail']");

	public By secondaryContactYRadio = By.xpath("//*[@id='hasAddAnotherPersonSelected1']");
	public By secondaryContactNRadio = By.xpath("//*[@id='hasAddAnotherPersonSelected2']");

	public By firstSCITxt = By.xpath("//*[@name='vevaVendor.vvaFirstName']");
	public By lastSCITxt = By.xpath("//*[@name='vevaVendor.vvaLastName']");
	public By emailSCITxt = By.xpath("//*[@name='vevaVendor.vvaEmail']");
	public By phoneSCITxt = By.xpath("//*[@name='vevaVendor.vvaPhoneNumber']");

	public By nextBtn = By.xpath("//*[@value='NEXT']");
	public By paymentInfoLbl = By.xpath("/html/body/form/table/tbody/tr[3]/td");

	public By paymentMethodDdl = By.xpath("//*[@name='transactionType']");
	public By InvoiceCodeTxt = By.xpath("//*[@id=\"div_promo\"]/table/tbody/tr/td[2]/input");
	public By submitBtn = By.xpath("//*[@id=\"confirmation2\"]/td[1]/input");

	public void VendorRegistration() throws Exception{
		try {
		String FirstName = _dataRepo.getData("FirstName") + Random_StringGenerator(8);
		VendorNameNonHD=FirstName;
		String LastName = _dataRepo.getData("LastName") + Random_StringGenerator(8);
		VendorLastNameNonHD=LastName;
		String MiddleName = _dataRepo.getData("MiddleName") + Random_StringGenerator(8);
		String UserName = _dataRepo.getData("UserID") + Random_StringGenerator(6);
		String phoneNumber = Random_NumberGenerator(10);
		String extnNumber = Random_NumberGenerator(4);
		String ssnString = Random_NumberGenerator(9);

		selectDropDown(countryDdl, _dataRepo.getData("Country"), "Select Country Name from Drop down");
		EnterText(legalBusinessNameTxt, "Legal Business Name added to textbox", FirstName);
		EnterText(doingBusinessAsTxt, "Doing Business as added to textbox",
				_dataRepo.getData("DoingBusinessAs"));
		selectDropDown(typeOfBusinessDdl, _dataRepo.getData("BusinessType"),
				"Doing Business As added to text");
		EnterText(ownershipTxt, "Name suffix added to textbox", (_dataRepo.getData("Ownership")));
		/*
		 * if(_dataRepo.getData("SSNY/N").equalsIgnoreCase("Yes")) { wait(2);
		 * clickElementWithWait(ssnYRadio, "Click on Yes for SSN ");
		 * EnterText(ssnTxt, "SSN added to textbox",ssnString); } else {
		 * clickElementWithWait(ssnNRadio, "Click on No for SSN "); }
		 */
		EnterText(addressTxt, "Address added to textbox", (_dataRepo.getData("Address")));
		EnterText(cityTxt, "City added to textbox", (_dataRepo.getData("City")));
		selectDropDown(stateDdl, (_dataRepo.getData("State")), "State selected From Drop down");
		EnterText(zipCodeTxt, "zip code added to textbox", (_dataRepo.getData("ZipCode")));
		EnterText(phoneTxt, "study added to textbox", phoneNumber);
		wait(2);
		if (_dataRepo.getData("EmploymentType").equalsIgnoreCase("Pre/Post Employment"))
			clickElementWithWait(employmentPreCheck, "Click on Pre/Post Employment");
		else if (_dataRepo.getData("EmploymentType").equalsIgnoreCase("Volunteer"))
			clickElementWithWait(employmentVolunteerCheck, "Click on Volunteer");
		else if (_dataRepo.getData("EmploymentType").equalsIgnoreCase("Contractor"))
			clickElementWithWait(employmentContractorCheck, "Click on Contractor");
		else
			clickElementWithWait(employmentPreCheck, "Click on Pre/Post Employment");
		clickElementWithWait(employmentVolunteerCheck, "Click on Volunteer");
		clickElementWithWait(employmentContractorCheck, "Click on Contractor");

		EnterText(businessDescrTxt, "Business Description added to textbox",
				(_dataRepo.getData("Description")));

		if (verifyElementPresence(LockheedLOBCheck))
			clickElementWithWait(LockheedLOBCheck, "Clicked on LOB checkbox");

		/***
		 * @author mishrbik
		 * 
		 *         Primary Contact Information
		 * 
		 */
		selectDropDown(countryPCIDdl, _dataRepo.getData("Country"), "Selected country from Drop Down");
		EnterText(legalFirstNameTxt, "First Name added to textbox", FirstName);
		EnterText(legalLastNameTxt, "Last Name added to textbox", LastName);
		EnterText(middleNameTxt, "First Name added to textbox", MiddleName);
		clickElementWithWait(middleNameYRadio, "Click on Yes Middle Name button");
		/*
		 * if(_dataRepo.getData("MiddleNameY/N").equalsIgnoreCase("Yes")) { wait(2);
		 * clickElementWithWait(middleNameYRadio,
		 * "Click on Yes Middle Name button"); EnterText(middleNameTxt,
		 * "First Name added to textbox", _dataRepo.getData("VendorLBMiddleName")); }
		 * else { clickElementWithWait(middleNameYRadio,
		 * "Click on No Middle Name button"); }
		 */
		EnterText(suffixTxt, "suffix added to textbox", _dataRepo.getData("Suffix"));
		EnterText(titleTxt, "Title added to textbox", _dataRepo.getData("Title"));
		EnterText(phonePCITxt, "Phone added to textbox", phoneNumber);
		EnterText(phoneExtTxt, "phone Ext added to textbox", extnNumber);
		EnterText(faxTxt, "Fax added to textbox", phoneNumber);
		EnterText(eMailTxt, "Email added to textbox", (_dataRepo.getData("Email")));

		/***
		 * @author mishrbik
		 * 
		 *         Billing Contact Information
		 * 
		 */

		/*
		 * if(_dataRepo.getData("AddressSame").equalsIgnoreCase("Yes")) {
		 * clickElementWithWait(
		 * sameAddressAsBusinessChk,"Same Address of Business checked"); } else {
		 */
		selectDropDown(countryDdl, _dataRepo.getData("Country"),
				"Selected Vendor country from Drop Down");
		EnterText(addressPCITxt, "Address added to textbox", (_dataRepo.getData("Address")));
		EnterText(cityPCITxt, "city added to textbox", (_dataRepo.getData("City")));
		selectDropDown(statePCIDdl, _dataRepo.getData("State"), "Selected Vendor State from Drop Down");
		EnterText(zipPCITxt, "Zip code added to textbox", (_dataRepo.getData("ZipCode")));
		EnterText(firstPCITxt, "First Name added to textbox", FirstName);
		EnterText(lastPCITxt, "Last Name added to textbox", LastName);
		EnterText(suffixTxt, "suffix added to textbox", _dataRepo.getData("Suffix"));
		EnterText(emailPCITxt, "Email added to textbox", (_dataRepo.getData("Email")));

		/***
		 * @author mishrbik
		 * 
		 *         Secondary Contact Information
		 * 
		 */
		if (_dataRepo.getData("SecodaryAddress") == "Yes") {
			clickElementWithWait(secondaryContactYRadio, "Secondary of Address Yes Radio Button");
			EnterText(firstSCITxt, "First Name added to textbox", FirstName);
			EnterText(lastSCITxt, "Last Name added to textbox", LastName);
			EnterText(emailSCITxt, "Email added to textbox", _dataRepo.getData("Email"));
			EnterText(phoneSCITxt, "phone added to textbox", phoneNumber);
		} else {
			clickElementWithWait(secondaryContactNRadio, "Secondary of Address No Radio Button");
		}

		/***
		 * @author mishrbik
		 * 
		 *         Service Provider Profile
		 * 
		 */
		EnterText(createUserIdTxt, "User Name entered", UserName);
		EnterText(passwordTxt, "Password Entered", PropertyFileReader.getProperty("CustHDPassword"));
		EnterText(repasswordTxt, "Password Re-Entered", PropertyFileReader.getProperty("CustHDPassword"));
		selectDropDown(secretQuestionDdl, _dataRepo.getData("secretQuestion"),
				"Secret Question selected");
		EnterText(secretQuestionTxt, "Answer Entered", _dataRepo.getData("secretAnswer"));
		
		
		logStepInfo("Vendor Registration completed!!!");
		reportLog(Status.PASS,"Vendor Registration completed!!!", true);

		}
		catch(Exception ex)
		{
			logStepInfo("Exception occured in VendorRegistration():- "+ex.getMessage());
			reportLog(Status.FAIL,"Exception occured in VendorRegistration():- "+ex.getMessage(), true);
		}

	}
}
