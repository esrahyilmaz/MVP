package pages;

import Utility.ExcelReader;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import seleniumhelper.BaseClass;

import java.util.List;

public class NUIAdministrationPage extends BaseClass {
	ExcelReader _dataRepo = new ExcelReader();
	// ------------------Page Administration----------------------//

	By newUserButton = By.xpath("//button[contains(text(),' New User')]");

	public By firstNameText = By.xpath("//input[@placeholder='First Name']");
	public By lastNameText = By.xpath("//input[@placeholder='Last Name']");
	public By SSNText = By.xpath("//input[@placeholder='Social Security Number']");
	public By emailText = By.xpath("//input[@placeholder='Email']");
	public By searchButton = By.xpath("//*[@id='user-search-btn']");

	// ---------Page Administration-New User---------------------//

	By newUsertitle = By.xpath("//h5[text()='New User']");

	By firstNameField = By.xpath("//input[@id='first-name-field']");
	By lastNameField = By.xpath("//input[@id='last-name-field']");
	By userIDField = By.xpath("//input[@id='user-name-field']");
	By emailField = By.xpath("//input[@id='email-field']");
	By passwordField = By.xpath("//input[@id='pass-field']");
	By confirmPassField = By.xpath("//input[@id='confirm-field']");

	By statusDropList = By.xpath("//select[@id='status']");
	By roleDropList = By.xpath("//select[@id='userRoles']");

	By addNewUserButton = By.xpath("//button[@id='addUser']");
	By userCancleButton = By.xpath("//button[contains(text(),'Cancel')]");

	// ---------Page Administration-Action---------------------//

	By userActionButton = By.xpath("//*[@id=\"dropdownMenuButton\"]");
	By userEditNavButton = By.xpath("//*[contains(@class,'dropdown-item') and contains(text(),'Edit User')]");
	By userUpdateButton = By.xpath("//button[@id='updateUser' and contains(text(), 'Update user')]");
	By saveCreditCard = By.xpath("//button[contains(text(), 'Save Card ')]");
	By SaveCreditCardCheckbox=By.xpath("//input[@data-xf-qa-id='CCC-CHKBOX-SPM']");

	By requiredFields = By.xpath("//*[contains(@class,'required-field')]");
	public By nextPageButtonAdministration = By.cssSelector("body > xf-root > xf-in-layout > div > main > xf-users-search > div:nth-child(2) > xf-table-pagination > div > pagination > ul > li.pagination-next.page-item > a > fa-icon");
	public By nextPageButtonDisabledAdministration = By.cssSelector("body > xf-root > xf-in-layout > div > main > xf-users-search > div:nth-child(2) > xf-table-pagination > div > pagination > ul > li.pagination-next.page-item.disabled");

	// ---------Page Administration-Password validation---------------------//
	By upperChar = By.xpath("//small[contains(text(),'At least 1 upper case')]/fa-icon/*[@data-icon='check-circle']");
	By lowerChar = By.xpath("//small[contains(text(),'At least 1 lower case')]/fa-icon/*[@data-icon='check-circle']");
	By specialChar = By.xpath("//small[contains(text(),'At least 1 special character')]/fa-icon/*[@data-icon='check-circle']");
	By numberChar = By.xpath("//small[contains(text(),'At least 1 numerical character')]/fa-icon/*[@data-icon='check-circle']");
	By errorMessage = By.xpath("(//*[contains(@class,'d-block') and contains(text(),'Password must meet all criteria')])");
	By passLength = By.xpath("//small[contains(text(),'At least 8 characters')]/fa-icon/*[@data-icon='check-circle']");
	By passBar = By.xpath("//div[@class='mx-1 empty-bar']/div[not(@hidden)]");

	// ---------Page Administration-error messages validation---------------------//
	By msgErrorModal = By.xpath("//div[@style='display: block;' and @class='modal fade in show']");
	By message = By.xpath("//*[contains(@class,'text-danger')]");


	//================================================================================================================	
	// -------------------------Add action-------------------------//

	public void addNewUser() throws Exception {

		try {
			String FirstName = _dataRepo.getData("FirstName") + Random_StringGenerator(4);
			String LastName = _dataRepo.getData("LastName") + Random_StringGenerator(4);
			String UserID = _dataRepo.getData("UserID") + Random_NumberGenerator(6);
			String Email = _dataRepo.getData("Email");
			String Role = _dataRepo.getData("Role");
			String UserStatus = _dataRepo.getData("Status");
			String Password = _dataRepo.getData("Password");

			EnterText(firstNameField, "First Name entered", FirstName);
			EnterText(lastNameField, "Last Name Entered", LastName);
			EnterText(userIDField, "User ID Entered", UserID);
			EnterText(emailField, "Email Entered", Email);
			EnterText(passwordField, "Password Entered", Password);
			EnterText(confirmPassField, "Confirm Password Entered", Password);

			selectDropDown(statusDropList, UserStatus, "Status selected");
			selectDropDown(roleDropList, Role, "Role selected");

			existingUserID = UserID;
			existingPassword = Password;
			existingFirstName = FirstName;
			existingLastName = LastName;
			existingEmail = Email;
			existingRole = Role;
			existingStatus = UserStatus;

			existingName = FirstName + " " + LastName;

			logStepInfo("Add New user completed!");
			reportLog(Status.PASS, "Add New user completed!", true);

		} catch (Exception ex) {
			logStepInfo("Exception occured in addNewPeople():- " + ex.getMessage());
			reportLog(Status.FAIL, "Add New person Failed!:- " + ex.getMessage(), true);
		}
	}

	// -------------------------Edit action-------------------------//
	public void editUser(String pageName) {
		try {

			if (pageName.equalsIgnoreCase("Edit User Production")) {
				existingFirstName = _dataRepo.getData("UpdateFirstName");
				existingLastName = _dataRepo.getData("UpdateLastName");
			} else {
				existingFirstName = _dataRepo.getData("UpdateFirstName") + Random_StringGenerator(4);
				existingLastName = _dataRepo.getData("UpdateLastName") + Random_StringGenerator(4);
			}

			existingEmail = _dataRepo.getData("UpdateEmail");
			existingRole = _dataRepo.getData("UpdateRole");
			existingStatus = _dataRepo.getData("UpdateStatus");

			EnterText(firstNameField, "provide the first name to edit", existingFirstName);
			EnterText(lastNameField, "provide the last name to edit", existingLastName);
			EnterText(emailField, "provide the email to edit", existingEmail);
			selectDropDown(statusDropList, existingStatus, "Status selected");
			selectDropDown(roleDropList, existingRole, "Role selected");


			reportLog(Status.PASS, "Editing person information and first name is changed", true);
			reportLog(Status.PASS, "Person details Edited !!!!", true);
			logStepInfo("Person details Edited !!!!");

		} catch (Exception e) {
			reportLog(Status.FAIL, "Person details Editing Failed !!!!" + e.getMessage(), true);
			logStepInfo("Person details Editing Failed !!!!" + e.getMessage());
		}
	}

	public void passwordValidation() throws Exception {
		try {
			EnterTextWithoutDelete(passwordField, "provide one upper case character for password", "A");
			verifyElementPresence(upperChar, "one upper case character validation message for password");
			passBarVerifyWithValue("Very Weak");

			EnterTextWithoutDelete(passwordField, "provide one lower case character for password", "a");
			verifyElementPresence(lowerChar, "one lower case character validation message for password");
			passBarVerifyWithValue("Weak");

			EnterTextWithoutDelete(passwordField, "provide one special character for password", "@");
			verifyElementPresence(specialChar, "one special character validation message for password");
			passBarVerifyWithValue("Moderate");

			EnterTextWithoutDelete(passwordField, "provide one numerical character for password", "1");
			verifyElementPresence(numberChar, "one numerical character validation message for password");
			passBarVerifyWithValue("Strong");

			String MessageTxt = driver.findElement(errorMessage).getText();
			verifyMessageTxt(MessageTxt, "Password must meet all criteria");

			String validPassword = _dataRepo.getData("Password");
			EnterText(passwordField, "provide valid value for password", validPassword);
			existingPassword = validPassword;
			verifyElementPresence(passLength, "length validation message for password");
			passBarVerifyWithValue("Very Strong");

			reportLog(Status.PASS, "Password is validated", false);

		} catch (Exception e) {
			reportLog(Status.FAIL, "Password validation Failed!" + e.getMessage(), true);
			logStepInfo("Password validation Failed!" + e.getMessage());
		}
	}

	public void passBarVerifyWithValue(String identifierValue) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			if (verifyElementPresence(By.xpath("//*[contains(text(),'" + identifierValue + "')]"))) {
				wait.until(ExpectedConditions.presenceOfElementLocated(passBar));
				int passBarCount = driver.findElements(passBar).size();
				switch (identifierValue) {
					case "Very Weak":
						if (passBarCount == 1) {
							System.out.println("Password Bar is present with " + passBarCount + " bar.");
							reportLog(Status.PASS, "Password Bar is present with " + passBarCount + " bar.", false);
						}
						break;
					case "Weak":
						if (passBarCount == 2) {
							System.out.println("Password Bar is present with " + passBarCount + " bar.");
							reportLog(Status.PASS, "Password Bar is present with " + passBarCount + " bar.", false);
						}
						break;
					case "Moderate":
						if (passBarCount == 3) {
							System.out.println("Password Bar is present with " + passBarCount + " bar.");
							reportLog(Status.PASS, "Password Bar is present with " + passBarCount + " bar.", false);
						}
						break;
					case "Strong":
						if (passBarCount == 4) {
							System.out.println("Password Bar is present with " + passBarCount + " bar.");
							reportLog(Status.PASS, "Password Bar is present with " + passBarCount + " bar.", false);
						}
						break;
					case "Very Strong":
						if (passBarCount == 5) {
							System.out.println("Password Bar is present with " + passBarCount + " bar.");
							reportLog(Status.PASS, "Password Bar is present with " + passBarCount + " bar.", false);
						}
						break;
					default:
						passBar = By.xpath("//div[@class='mx-1 empty-bar']/div[@hidden]");
						passBarCount = driver.findElements(passBar).size();
						if (passBarCount == 5) {
							System.out.println("Password Bar is present with " + passBarCount + " bar.");
							reportLog(Status.PASS, "Password Bar is present with " + passBarCount + " bar.", false);
						}
						break;
				}

			} else {
				reportLog(Status.FAIL, "Element Not Present " + identifierValue, false);
			}

		} catch (Exception ex) {
			System.out.println("error in following Lines::" + ex.getMessage());
		}
	}

    public void fieldValidation() throws Exception {
		try {
			clickElement(addNewUserButton, "Add New User button");
			verifyElementPresence(msgErrorModal, "Error message for mandatory fields");

			List<WebElement> allFields = driver.findElements(message);
			String[] errorMsg = {"First Name is required", "Last Name is required", "User ID is required", "A valid email is required", "User status is required", "User role is required", "Password must meet all criteria", "Confirm password is required"};

			for (int i = 0; i < allFields.size(); i++) {
				By message = By.xpath("(//*[contains(@class,'text-danger') and contains(text(),'"+ errorMsg[i] +"')])");
				String MessageTxt = driver.findElement(message).getText();
				verifyMessageTxt(MessageTxt, errorMsg[i]);
			}
			reportLog(Status.PASS, "Field validation success!", false);
			logStepInfo("Field validation success!");

		} catch (Exception e) {
			reportLog(Status.FAIL, "Field validation Failed!" + e.getMessage(), false);
			logStepInfo("Field validation Failed!" + e.getMessage());
		}
    }
}