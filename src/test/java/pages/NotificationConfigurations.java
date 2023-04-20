package pages;

import Utility.CurrentDateTime;
import Utility.ExcelReader;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import seleniumhelper.BaseClass;

public class NotificationConfigurations extends BaseClass {

	private static By AdministrationTAB = By.xpath("(//a[.='> Administration'])[last()-1]");
	private static By ProfileTAB = By.xpath("(//a[.='Profile'])[last()]");
	private static By UserFirstName = By.xpath("//input[@name='firstName']");
	private static By UserLastName = By.xpath("//input[@name='lastName']");
	private static By UserEmail = By.xpath("//input[@name='email']");
	private static By OrderCompletionNotificationSelected = By
			.xpath("//select[@name='complianceEmails']//option[@value='ALL' and @selected='selected']");
	private static By OrderCompletionNotificationDD = By.xpath("//select[@name='complianceEmails']");
	private static By OrderSubmitionNotificationSected = By
			.xpath("//select[@name='complianceEmailsFilter']//option[@value='ALL' and @selected='selected']");
	private static By OrderSubmitionNotificationSectedVendor = By
			.xpath("//select[@name='complianceEmailsFilter']//option[@value='MINE' and @selected='selected']");
	private static By OrderSubmissionNotificationDD = By.xpath("//select[@name='complianceEmailsFilter']");
	private static By CurrentpwTB = By.xpath("//input[@name='currentPassword']");
	private static By SaveBTN = By.xpath("//input[@name='SAVE']");

	private static By ComplianceStatusTXT = By.xpath("(//td[contains(.,'Compliance Status:')])[last()]/..//td//span");
	private static By ComplinaceStatusPendingTXT = By
			.xpath("(//td[contains(.,'Compliance Status:')])[last()]/..//td[2]");
	private static By OrderDateTXT = By.xpath("((//span[.='Order History']/..//table)[5]//tr[1])[2]//td[2]");
	private static By PackageTXT = By.xpath("((//span[.='Order History']/..//table)[5]//tr[1])[2]//td[4]");

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
	public By dobTxt = By.xpath("//*[contains(text(),'Date of Birth')]/following::td[1]/input[1]");
	public By emailTxt = By.xpath("//*[contains(text(),'Email')]/following::td[1]/input[1]");
	public By mobileTxt = By.xpath("//*[contains(text(),'Mobile Number')]/following::td[1]/input[1]");

	public By typeOtherDdl = By.xpath("//*[@id=\"peopleFormTable\"]/tbody/tr[13]/td[2]/select");
	public By typeHDDdl = By.xpath("//*[@id=\"peopleFormTable\"]/tbody/tr[11]/td[2]/select");
	public By VendorLocation = By.xpath("//select[@name='locationId']");
	public By UserField1TB = By.xpath("//input[@name='ref1']");
	public By UserField2TB = By.xpath("//input[@name='ref2']");

	public By countryDdl = By.xpath("//*[@id=\"peopleFormTable\"]/tbody/tr[19]/td[2]/select");

	public By addressTxt = By.xpath("//*[contains(text(),'Address 1')]/following::td[1]/input[1]");
	public By cityTxt = By.xpath("//input[@name='addressForm.cityName']");
	public By stateDdl = By.xpath("//*[@id=\"addressformStateCode\"]/td[2]/select");
	public By zipCodeTxt = By.xpath("//*[contains(text(),'Zip')]/following::td[1]/input[1]");

	public By ExistingPersonYesBtn = By.xpath("//*[@value='YES']");
	public By ExistingPersonNoBtn = By.xpath("//*[@value='NO']");
	By ignoreAddress_chkBox = By.xpath("//input[@name = 'ignoreAddressValidationErrorFlag']");
	public By DlNumberTxt = By.xpath("//*[@name='driverLicenseNum']");
	public By DlNumberState = By.xpath("//*[@name='driverLicenseState']");

	ExcelReader _dataRepo = new ExcelReader();

	private static String FirstName1;
	private static String MiddleName1;
	private static String LastName1;
	private static String suffix1;
	private static String ssn1;
	private static String dob1;
	private static String email1;
	private static String DLNumber1;
	private static String DLstate1;
	private static String Address1;
	private static String city1;
	private static String state1;
	private static String zip1;
	private static String phone1;

	private static String FirstName2;
	private static String MiddleName2;
	private static String LastName2;
	private static String suffix2;
	private static String ssn2;
	private static String dob2;
	private static String email2;
	private static String DLNumber2;
	private static String DLstate2;
	private static String Address2;
	private static String city2;
	private static String state2;
	private static String zip2;
	private static String phone2;

	public void checkProfileConfig() {
		clickElement(AdministrationTAB, "Administration TAB");
		clickElement(ProfileTAB, "Profile");
		NotificationUserFirstName = driver.findElement(UserFirstName).getAttribute("value");
		reportLog(Status.INFO, "User FirstName is : " + NotificationUserFirstName, false);
		NotificationUserLastName = driver.findElement(UserLastName).getAttribute("value");
		reportLog(Status.INFO, "User LastName is : " + NotificationUserLastName, false);
		NotificationUserEmail = driver.findElement(UserEmail).getAttribute("value");
		reportLog(Status.INFO, "User Email is :" + NotificationUserEmail, false);

	if(!(scenarioName.contains("NO-Notification"))) {
		if (verifyElementPresence(OrderCompletionNotificationSelected)) {
			reportLog(Status.INFO,
					"Do you want to receive an email when an order has completed? --> Yes, for all types of results",
					false);
		} else {
			selectDropDown(OrderCompletionNotificationDD, "Yes, for all types of results",
					"Do you want to receive an email when an order has completed?");
		}

		if (scenarioName.contains("CustUser")) {
			if (verifyElementPresence(OrderSubmitionNotificationSected)) {
				reportLog(Status.INFO,
						"Do you want to be notified for all orders within your account, or only the orders you have submitted? --> All orders in my account",
						false);
			} else {
				selectDropDown(OrderSubmissionNotificationDD, "All orders in my account",
						"Do you want to be notified for all orders within your account, or only the orders you have submitted?");
			}
		} else if (scenarioName.contains("VendorUser")) {
			if (verifyElementPresence(OrderSubmitionNotificationSectedVendor)) {
				reportLog(Status.INFO,
						"Do you want to be notified for all orders within your account, or only the orders you have submitted? --> Only orders I have submitted",
						false);
			} else {
				selectDropDown(OrderSubmissionNotificationDD, "Only orders I have submitted",
						"Do you want to be notified for all orders within your account, or only the orders you have submitted?");
			}
		}
	}

		EnterText(CurrentpwTB, "Current PW", CurrentPasswordUser);
		clickElement(SaveBTN, "Save");
	}

	public void getPersonDetail() {

		if (scenarioName.contains("Pending")) {
			NotificationComplianceStatus = driver.findElement(ComplinaceStatusPendingTXT).getText();
		} else {
			NotificationComplianceStatus = driver.findElement(ComplianceStatusTXT).getText();
		}
		NotificationOrderDate = driver.findElement(OrderDateTXT).getText();
		NotificationPackageName = driver.findElement(PackageTXT).getText();
	}

	public void verifyOrderConfirmationMail(String Sponsor, String Vendor, String Package, String Total,
			String PaymentMethod) {

		String TodayDate = CurrentDateTime.getOrderConfirmationDate();

		if (EmailBody.contains("First Advantage Order Confirmation")) {
			reportLog(Status.PASS, "Order Confirmation Email Header is verified and received as Expected", false);
		} else {
			reportLog(Status.FAIL, "Order Confirmation Email Header is verified and not received as Expected", false);
		}
		if (EmailBody.contains("Order Number: " + OrderID)) {
			reportLog(Status.PASS, "Order Confirmation Email Order ID is verified and received as Expected", false);
		} else {
			reportLog(Status.FAIL, "Order Confirmation Email Order ID is verified and not received as Expected", false);
		}
		if (EmailBody.contains("Sponsor: " + Sponsor)) {
			reportLog(Status.PASS, "Order Confirmation Email Sponsor Name is verified and received as Expected", false);
		} else {
			reportLog(Status.FAIL, "Order Confirmation Email Sponsor Name is verified and not received as Expected",
					false);
		}
		if (EmailBody.contains("Vendor: " + Vendor)) {
			reportLog(Status.PASS, "Order Confirmation Email Vendor Name is verified and received as Expected", false);
		} else {
			reportLog(Status.FAIL, "Order Confirmation Email Vendor Name is verified and not received as Expected",
					false);
		}
		if (EmailBody.contains("Date: " + TodayDate)) {
			reportLog(Status.PASS, "Order Confirmation Email Date is verified and received as Expected", false);
		} else {
			reportLog(Status.FAIL, "Order Confirmation Email Date is verified and not received as Expected", false);
		}
		if (EmailBody.contains("Package Name: " + Package)) {
			reportLog(Status.PASS, "Order Confirmation Email Package Name is verified and received as Expected", false);
		} else {
			reportLog(Status.FAIL, "Order Confirmation Email Package Name is verified and not received as Expected",
					false);
		}
		if (EmailBody.contains("Subject: " + existingFirstName + " " + existingLastName)) {
			reportLog(Status.PASS, "Order Confirmation Email Person Name is verified and received as Expected", false);
		} else {
			reportLog(Status.FAIL, "Order Confirmation Email Person Name is verified and not received as Expected",
					false);
		}
		if (EmailBody.contains("Order Total: " + Total)) {
			reportLog(Status.PASS, "Order Confirmation Email Order Total is verified and received as Expected", false);
		} else {
			reportLog(Status.FAIL, "Order Confirmation Email Order Total is verified and not received as Expected",
					false);
		}
		if (EmailBody.contains("Payment Method: " + PaymentMethod)) {
			reportLog(Status.PASS, "Order Confirmation Email Payment Method is verified and received as Expected",
					false);
		} else {
			reportLog(Status.FAIL, "Order Confirmation Email Payment Method is verified and not received as Expected",
					false);
		}
	}

	public void verifyResetPasswordCLOB() {

		if (EmailBody.contains("Dear " + NotificationUserFirstName + " " + NotificationUserLastName + ",")) {
			reportLog(Status.PASS, "Password Reset Email Contains User First name and Last Name", false);
		} else {
			reportLog(Status.FAIL, "Password Reset Email Does not Contains User First name and Last Name", false);
		}
		if (EmailBody.contains("User ID: <b>" + UserIDUserAdmin)) {
			reportLog(Status.PASS, "Password Reset Email Contains User ID", false);
		} else {
			reportLog(Status.FAIL, "Password Reset Email Does not Contains User ID", false);
		}
		if (EmailBody
				.contains("This email acknowledges that changes have been made to your FIRST ADVANTAGE account.")) {
			reportLog(Status.PASS, "Password Reset Email Contains Aknowledgement", false);
		} else {
			reportLog(Status.FAIL, "Password Reset Email Does not Contains Aknowledgement", false);
		}
		if (EmailBody.contains("PLEASE DO NOT REPLY TO THIS EMAIL")) {
			reportLog(Status.PASS, "Password Reset Email Contains DO NOT REPLY", false);
		} else {
			reportLog(Status.FAIL, "Password Reset Email Does not Contains DO NOT REPLY", false);
		}
	}

	public void addFirstPerson() throws Exception {

		try {
			FirstName1 = _dataRepo.getData("FirstName") + Random_StringGenerator(8);
			ssn1 = Random_NumberGenerator(9);
			LastName1 = _dataRepo.getData("LastName") + Random_StringGenerator(8);
			phone1 = "85"+Random_NumberGenerator(8);
			EnterText(firstNameTxt, "First Name entered", FirstName1);
			EnterText(lastNameTxt, "Last Name Entered", LastName1);
			MiddleName1 = LastName1;
			clickElementWithWait(middleNameYRadio, "click on middle name yes radion button");
			EnterText(middleNameTxt, "enter middle name", MiddleName1);

			if (verifyElementPresence(ssnYRadio))
				clickElementWithWait(ssnYRadio, "Clicked on Yes Radio button");
			EnterText(ssnTxt, "SSN Entered", ssn1);
			SSN = ssn1;
			suffix1 = "abc";
			EnterText(suffixTxt, "Suffix Entered", suffix1);
			dob1 = "12111981";
			EnterText(dobTxt, "Date of Birth Entered", dob1);
			email1 = "chandra.shekarg@fadv.com";
			EnterText(emailTxt, "Email ID Entered", email1);
			EnterText(mobileTxt, "mobile Number Entered", phone1);

			String personType = "Principal";

			if (verifyElementPresence(typeHDDdl))
				selectDropDown(typeHDDdl, personType, "PersonType selected");
			else if (verifyElementPresence(typeOtherDdl) && !(personType.equalsIgnoreCase("")))
				selectDropDown(typeOtherDdl, personType, "PersonType selected");
			DLNumber1 = phone1;
			if (verifyElementPresence(DlNumberTxt)) {
				EnterText(DlNumberTxt, "DL Number Entered", DLNumber1);
				DLstate1 = "Georgia";
				selectDropDown(DlNumberState, DLstate1, "State Selected");
			}
			Address1 = "2450 Cumberland Pkwy SE";
			EnterText(addressTxt, "Address added to textbox", Address1);
			city1 = "Atlanta";
			EnterText(cityTxt, "City added to textbox", city1);
			state1 = "Georgia";
			selectDropDown(stateDdl, state1, "State selected From Drop down");
			zip1 = "30339";
			EnterText(zipCodeTxt, "zip code added to textbox", zip1);

			if (verifyElementPresence(VendorLocation)) {
				selectDropDownByIndex(VendorLocation, "1", "Vendor Location");
			}

			if (verifyElementPresence(UserField1TB)) {
				EnterText(UserField1TB, "Userfield1", "1");
			}

			if (verifyElementPresence(UserField2TB)) {
				EnterText(UserField2TB, "Userfield2", "2");
			}

			reportInfo("Add New person completed!!!");
			reportLog(Status.PASS, "Add New person completed!!!", true);
		} catch (Exception ex) {
			reportInfo("Exception occured in addNewPeople():- " + ex.getMessage());
			reportLog(Status.FAIL, "Add New person Failed!!!:- " + ex.getMessage(), true);
		}
	}

	public void addSecondPerson() throws Exception {

		try {
			FirstName2 = _dataRepo.getData("FirstName") + Random_StringGenerator(8);
			ssn2 = Random_NumberGenerator(9);
			LastName2 = _dataRepo.getData("LastName") + Random_StringGenerator(8);
			phone2 = "86"+Random_NumberGenerator(8);
			EnterText(firstNameTxt, "First Name entered", FirstName2);
			EnterText(lastNameTxt, "Last Name Entered", LastName2);
			MiddleName2 = LastName2;
			clickElementWithWait(middleNameYRadio, "click on middle name yes radion button");
			EnterText(middleNameTxt, "enter middle name", MiddleName2);

			if (verifyElementPresence(ssnYRadio))
				clickElementWithWait(ssnYRadio, "Clicked on Yes Radio button");
			EnterText(ssnTxt, "SSN Entered", ssn2);
			suffix2 = "xyz";
			EnterText(suffixTxt, "Suffix Entered", suffix2);
			dob2 = "12122000";
			EnterText(dobTxt, "Date of Birth Entered", dob2);
			email2 = "nithin.krishna@fadv.com";
			EnterText(emailTxt, "Email ID Entered", email2);
			EnterText(mobileTxt, "mobile Number Entered", phone2);

			String personType = "Crew";

			if (verifyElementPresence(typeHDDdl))
				selectDropDown(typeHDDdl, personType, "PersonType selected");
			else if (verifyElementPresence(typeOtherDdl) && !(personType.equalsIgnoreCase("")))
				selectDropDown(typeOtherDdl, personType, "PersonType selected");
			DLNumber2 = phone2;
			if (verifyElementPresence(DlNumberTxt)) {
				EnterText(DlNumberTxt, "DL Number Entered", DLNumber2);
				DLstate2 = "New York";
				selectDropDown(DlNumberState, DLstate2, "State Selected");
			}
			Address2 = "520 W 28th St";
			EnterText(addressTxt, "Address added to textbox", Address2);
			city2 = "New York";
			EnterText(cityTxt, "City added to textbox", city2);
			state2 = "New York";
			selectDropDown(stateDdl, state2, "State selected From Drop down");
			zip2 = "10001";
			EnterText(zipCodeTxt, "zip code added to textbox", zip2);

			if (verifyElementPresence(VendorLocation)) {
				selectDropDownByIndex(VendorLocation, "1", "Vendor Location");
			}

			if (verifyElementPresence(UserField1TB)) {
				EnterText(UserField1TB, "Userfield1", "1");
			}

			if (verifyElementPresence(UserField2TB)) {
				EnterText(UserField2TB, "Userfield2", "2");
			}

			reportInfo("Add New person completed!!!");
			reportLog(Status.PASS, "Add New person completed!!!", true);
		} catch (Exception ex) {
			reportInfo("Exception occured in addNewPeople():- " + ex.getMessage());
			reportLog(Status.FAIL, "Add New person Failed!!!:- " + ex.getMessage(), true);
		}
	}

	public void verifyPrincipalChangeCLOB() {

		if (scenarioName.contains("Inactive")) {
			if (EmailBody.contains("The following Service Provider has modified the principal listed on the account")) {
				reportLog(Status.PASS, "Email Contains the Heading", false);
			} else {
				reportLog(Status.FAIL, "Email Does Not Contains Heading", false);
			}

			if (EmailBody.contains("Payto Name: <b>THD Demo")) {
				reportLog(Status.PASS, "Email Contains PayTo Name", false);
			} else {
				reportLog(Status.FAIL, "Email Does not Contain Pay To Name", false);
			}

			if (EmailBody.contains("Payto #   : PAYTO4")) {
				reportLog(Status.PASS, "Email Contains PayTo Number", false);
			} else {
				reportLog(Status.FAIL, "Email Doesnot Contain PayTo Number", false);
			}

			if (EmailBody.contains("The following action was taken for principal - <b>" + existingFirstName)) {
				reportLog(Status.PASS,
						"Email Contains The following action was taken for principal - <b>" + existingFirstName, false);
			} else {
				reportLog(Status.FAIL,
						"Email Doesnot Contain The following action was taken for principal - <b>" + existingFirstName,
						false);
			}

			if (EmailBody.contains("The Status was changed from Active to Inactive")) {
				reportLog(Status.PASS, "Email Contains-->The Status was changed from Active to Inactive", false);
			} else {
				reportLog(Status.FAIL, "Email Doesnot Contain-->The Status was changed from Active to Inactive", false);
			}
		} else if (scenarioName.contains("Terminated")) {
			if (EmailBody.contains("The following Service Provider has modified the principal listed on the account")) {
				reportLog(Status.PASS, "Email Contains the Heading", false);
			} else {
				reportLog(Status.FAIL, "Email Does Not Contains Heading", false);
			}

			if (EmailBody.contains("Payto Name: <b>THD Demo")) {
				reportLog(Status.PASS, "Email Contains PayTo Name", false);
			} else {
				reportLog(Status.FAIL, "Email Does not Contain Pay To Name", false);
			}

			if (EmailBody.contains("Payto #   : PAYTO4")) {
				reportLog(Status.PASS, "Email Contains PayTo Number", false);
			} else {
				reportLog(Status.FAIL, "Email Doesnot Contain PayTo Number", false);
			}

			if (EmailBody.contains("The following action was taken for principal - <b>" + existingFirstName)) {
				reportLog(Status.PASS,
						"Email Contains The following action was taken for principal - <b>" + existingFirstName, false);
			} else {
				reportLog(Status.FAIL,
						"Email Doesnot Contain The following action was taken for principal - <b>" + existingFirstName,
						false);
			}

			if (EmailBody.contains("The Status was changed from Active to Terminated")) {
				reportLog(Status.PASS, "Email Contains-->The Status was changed from Active to Terminated", false);
			} else {
				reportLog(Status.FAIL, "Email Doesnot Contain-->The Status was changed from Active to Terminated",
						false);
			}
		} else {
			if (EmailBody.contains("The following Service Provider has modified the principal listed on the account")) {
				reportLog(Status.PASS, "Email Contains the Heading", false);
			} else {
				reportLog(Status.FAIL, "Email Does Not Contains Heading", false);
			}

			if (EmailBody.contains("Payto Name: <b>THD Demo")) {
				reportLog(Status.PASS, "Email Contains PayTo Name", false);
			} else {
				reportLog(Status.FAIL, "Email Does not Contain Pay To Name", false);
			}

			if (EmailBody.contains("Payto #   : PAYTO4")) {
				reportLog(Status.PASS, "Email Contains PayTo Number", false);
			} else {
				reportLog(Status.FAIL, "Email Doesnot Contain PayTo Number", false);
			}

			if (EmailBody.contains("The following action was taken for principal - <b>" + FirstName1)) {
				reportLog(Status.PASS, "Email Contains The following action was taken for principal - <b>" + FirstName1,
						false);
			} else {
				reportLog(Status.FAIL,
						"Email Doesnot Contain The following action was taken for principal - <b>" + FirstName1, false);
			}

			if (EmailBody.contains("The First Name was changed from " + FirstName1 + " to " + FirstName2)) {
				reportLog(Status.PASS,
						"Email Contains-->The First Name was changed from " + FirstName1 + " to " + FirstName2, false);
			} else {
				reportLog(Status.FAIL,
						"Email Doesnot Contain-->The First Name was changed from " + FirstName1 + " to " + FirstName2,
						false);
			}

			if (EmailBody.contains("The Middle Name was changed from " + MiddleName1 + " to " + MiddleName2)) {
				reportLog(Status.PASS,
						"Email Contains-->The Middle Name was changed from " + MiddleName1 + " to " + MiddleName2,
						false);
			} else {
				reportLog(Status.FAIL, "Email Doesnot contain-->The Middle Name was changed from " + MiddleName1
						+ " to " + MiddleName2, false);
			}

			if (EmailBody.contains("The Last Name was changed from " + LastName1 + " to " + LastName2)) {
				reportLog(Status.PASS,
						"Email Contains-->The Last Name was changed from " + LastName1 + " to " + LastName2, false);
			} else {
				reportLog(Status.FAIL,
						"Email Doesnot Contain-->The Last Name was changed from " + LastName1 + " to " + LastName2,
						false);
			}

			if (EmailBody.contains("The Suffix Name was changed from abc to xyz")) {
				reportLog(Status.PASS, "Email Contains-->The Suffix Name was changed from abc to xyz", false);
			} else {
				reportLog(Status.FAIL, "Email Doesnot Contain-->The Suffix Name was changed from abc to xyz", false);
			}

			if (EmailBody.contains(
					"The SSN Name was changed from XXXXX" + ssn1.substring(5) + " to XXXXX" + ssn2.substring(5))) {
				reportLog(Status.PASS, "Email Contains-->The SSN Name was changed from XXXXX" + ssn1.substring(5)
						+ " to XXXXX" + ssn2.substring(5), false);
			} else {
				reportLog(Status.FAIL, "Email Doesnot Conatin-->The SSN Name was changed from XXXXX" + ssn1.substring(5)
						+ " to XXXXX" + ssn2.substring(5), false);
			}

			if (EmailBody.contains("The DOB Name was changed from 12/11/XXXX to 12/12/XXXX")) {
				reportLog(Status.PASS, "Email Contains-->The DOB Name was changed from 12/11/XXXX to 12/12/XXXX",
						false);
			} else {
				reportLog(Status.FAIL, "Email Doesnot Contain-->The DOB Name was changed from 12/11/XXXX to 12/12/XXXX",
						false);
			}

			if (EmailBody.contains("The Type was changed from P to E")) {
				reportLog(Status.PASS, "Email Contains-->The Type was changed from P to E", false);
			} else {
				reportLog(Status.FAIL, "Email Doesnot Contain-->The Type was changed from P to E", false);
			}

			if (EmailBody.contains("The email was changed from chandra.shekarg@fadv.com to nithin.krishna@fadv.com")) {
				reportLog(Status.PASS,
						"Email Contains-->The email was changed from chandra.shekarg@fadv.com to nithin.krishna@fadv.com",
						false);
			} else {
				reportLog(Status.FAIL,
						"Email Doesnot Conatin-->The email was changed from chandra.shekarg@fadv.com to nithin.krishna@fadv.com",
						false);
			}

			if (EmailBody.contains("The Driver's License Number was changed from " + DLNumber1.substring(0, 6)
					+ "XXXX to " + DLNumber2.substring(0, 6) + "XXXX")) {
				reportLog(Status.PASS, "Email Contains-->The Driver's License Number was changed from "
						+ DLNumber1.substring(0, 6) + "XXXX to " + DLNumber2.substring(0, 6) + "XXXX", false);
			} else {
				reportLog(Status.FAIL, "Email Doesnot Conatin-->The Driver's License Number was changed from "
						+ DLNumber1.substring(0, 6) + "XXXX to " + DLNumber2.substring(0, 6) + "XXXX", false);
			}

			if (EmailBody.contains("The Driver's License State was changed from GA to NY")) {
				reportLog(Status.PASS, "Email Contains-->The Driver's License State was changed from GA to NY", false);
			} else {
				reportLog(Status.FAIL, "Email Doesnot Conatin-->The Driver's License State was changed from GA to NY",
						false);
			}

			if (EmailBody.contains("The Address1 was changed from 2450 Cumberland Pkwy SE to 520 W 28th St")) {
				reportLog(Status.PASS,
						"Email Contains-->The Address1 was changed from 2450 Cumberland Pkwy SE to 520 W 28th St",
						false);
			} else {
				reportLog(Status.FAIL,
						"Email Doesnot Conatin-->The Address1 was changed from 2450 Cumberland Pkwy SE to 520 W 28th St",
						false);
			}

			if (EmailBody.contains("The City was changed from Atlanta to New York")) {
				reportLog(Status.PASS, "Email Contains-->The City was changed from Atlanta to New York", false);
			} else {
				reportLog(Status.FAIL, "Email Doesnot Conatin-->The City was changed from Atlanta to New York", false);
			}

			if (EmailBody.contains("The State was changed from GA to NY")) {
				reportLog(Status.PASS, "Email Contains-->The State was changed from GA to NY", false);
			} else {
				reportLog(Status.FAIL, "Email Doesnot Conatin-->The State was changed from GA to NY", false);
			}

			if (EmailBody.contains("The Zip was changed from 30339 to 10001")) {
				reportLog(Status.PASS, "Email Contains-->The Zip was changed from 30339 to 10001", false);
			} else {
				reportLog(Status.FAIL, "Email Doesnot Conatin-->The Zip was changed from 30339 to 10001", false);
			}

			if (EmailBody.contains("[Note: This is an automated E-Mail, Please do not reply to this E-Mail.]")) {
				reportLog(Status.PASS,
						"Email Contains-->[Note: This is an automated E-Mail, Please do not reply to this E-Mail.]",
						false);
			} else {
				reportLog(Status.FAIL,
						"Email Doesnot Conatin-->[Note: This is an automated E-Mail, Please do not reply to this E-Mail.]",
						false);
			}
		}
	}

	public void verifyDigitalBagdeCLOB() {
		if (EmailBody.contains("Hello "+ existingFirstName +" "+existingLastName)) {
			reportLog(Status.PASS, "Email Contains-->Hello "+ existingFirstName +" "+existingLastName, false);
		} else {
			reportLog(Status.FAIL, "Email Doesnot Contain-->Hello "+ existingFirstName +" "+existingLastName, false);
		}

		if (EmailBody.contains("This notice is to inform you that your digital badge for THE HOME DEPOT  has been generated. You can access your badge by clicking on the below link.")) {
			reportLog(Status.PASS, "Email Contains-->This notice is to inform you that your digital badge for THE HOME DEPOT  has been generated. You can access your badge by clicking on the below link.", false);
		} else {
			reportLog(Status.FAIL, "Email Doesnot Conatin-->This notice is to inform you that your digital badge for THE HOME DEPOT  has been generated. You can access your badge by clicking on the below link.", false);
		}

		if (EmailBody.contains("If you have questions, please feel free to contact us at XTDForceCustomerCare@fadv.com or 866-237-2135.")) {
			reportLog(Status.PASS, "Email Contains-->If you have questions, please feel free to contact us at XTDForceCustomerCare@fadv.com or 866-237-2135.", false);
		} else {
			reportLog(Status.FAIL, "Email Doesnot Conatin-->If you have questions, please feel free to contact us at XTDForceCustomerCare@fadv.com or 866-237-2135.", false);
		}
	}
}
