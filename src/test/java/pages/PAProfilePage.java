package pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import seleniumhelper.BaseClass;

public class PAProfilePage extends BaseClass {

	By pAFirstName = By.xpath("//input[@id='inputFirstName']");
	By pALastName = By.xpath("//input[@id='inputLastName']");
	By pAMiddleName = By.xpath("//input[@id='inputMiddleName']");
	By changeNameBtn = By.xpath("//button[@data-id='changeNameAgreeBtn']");
	private static By nameNextBtn = By.xpath("//button[@id='paNameNext']");
	private static By noMiddleNameButton = By.xpath("//button[starts-with(@data-id,'paNoMiddleName')]");
	private static By noOtherNameBtn = By.xpath("//button[@id='aliasNoName']");
	private static By genederSelectMale = By.xpath("(//select[@name='gendertype']/option)[1]");
	private static By genderNextBtn = By.xpath("//button[@id='paGenderNext']");
	private static By dateofBirth = By.xpath("//input[@type='date']");
	private static By dobNextBtn = By.xpath("//button[@id='paDobNext']");
	private static By dobConfirm = By.xpath("//button[.='CONFIRM']");
	private static By backgrndScrnNextBtn = By.xpath("//button[@id='paInfoNext']");
	private static By iUnderstandBtn1 = By.xpath("//button[text()='I UNDERSTAND']");
	//private static By iUnderstandPopup = By.xpath("//h4[contains(text(),'Please read through the following instructions')]");

	public void enterProfileSection(String profileDob) {
		try {

			WebDriverWait wait = new WebDriverWait(driver, 10);
//			if (verifyElementPresence(nameNextBtn)) {
//				clickElement(nameNextBtn, "Next");
//				logStepInfo("Next Button Clicked : " +"Next");
//			} else {
//				logStepInfo("Next Button Not Clicked : " +"Next");
//			}
			
			clickElement(nameNextBtn, "Next");
			logStepInfo("Next Button clicked : " + "Next");

//			if (verifyElementPresence(noMiddleNameButton)) {
//				clickElement(noMiddleNameButton, "No Middle Name");
//				logStepInfo("No Middle Name Button Clicked : " +"No Middle Name");
//			} else {
//				logStepInfo("No Middle Name Button Not Clicked : " +"No Middle Name");
//			}
			
//			clickElement(noMiddleNameButton, "No Middle Name");
//			logStepInfo("No Middle Name Button Clicked : " + "No Middle Name");

//			if (verifyElementPresence(noOtherNameBtn)) {
//				clickElement(noOtherNameBtn, "No Other Name");
//				logStepInfo("No Other Name Button Clicked : " +"No Other Name");
//			} else {
//				logStepInfo("No Other Name Button Not Clicked : " +"No Other Name");
//			}
			clickElement(noOtherNameBtn, "No Other Name");
			logStepInfo("No Other Name Button Clicked : " + "No Other Name");

//			if (verifyElementPresence(genederSelectMale)) {
//				clickElement(genederSelectMale, "Male");
//				logStepInfo("Gender Selected as Male : " + "Gender Select");
//			} else {
//				logStepInfo("Gender Not Selected as Male : " + "Gender Select");
//			}
//			clickElement(genederSelectMale, "Gender Select Male");
//			logStepInfo("Gender Selected as Male : " + "Gender Select");

//			if (verifyElementPresence(genderNextBtn)) {
//				clickElement(genderNextBtn, "Next");
//				logStepInfo("Gender Next Button Clicked : " +"Gender Next");
//			} else {
//				logStepInfo("Gender Next Button Not Clicked : " +"Gender Next");
//			}
//			clickElement(genderNextBtn, "Gender Next Button");
//			logStepInfo("Gender Next Button Clicked : " + "Gender Next");

//			if (verifyElementPresence(dateofBirth)) {
//				clickElement(dateofBirth, "DOB");
//				EnterText(dateofBirth, "DOB", profileDob);
//				logStepInfo("Date Of Birth Entered : " + profileDob);
//			} else {
//				logStepInfo("Date Of Birth Not Entered : " + profileDob);
//			}
//			clickElement(dateofBirth, "DOB");
			wait(2);
			EnterTextWithoutDelete(dateofBirth, "DOB", profileDob);
			wait(2);
			logStepInfo("Date Of Birth Entered : " + profileDob);

//			if (verifyElementPresence(dobNextBtn)) {
//				clickElement(dobNextBtn, "DOB Next");
//				logStepInfo("DOB Next Button clicked : " + "DOB Next");
//			} else {
//				logStepInfo("DOB Next Button Not clicked : " + "DOB Next");
//			}
			clickElement(dobNextBtn, "DOB Next");
			logStepInfo("DOB Next Button clicked : " + "DOB Next");

//			if (verifyElementPresence(dobConfirm)) {
//				clickElement(dobConfirm, "DOB Confirm");
//				logStepInfo("DOB Confirm Button clicked : " + "DOB Confirm");
//			} else {
//				logStepInfo("DOB Confirm Button Not clicked : " + "DOB Confirm");
//			}
			clickElement(dobConfirm, "Confirm");
			logStepInfo("DOB Confirm Button Clicked : " + "Confirm");

//			if (verifyElementPresence(backgrndScrnNextBtn)) {
//				clickElement(backgrndScrnNextBtn, "BS Next");
//				logStepInfo("Background Screen Next Button Clicked : " + "BS Next");
//			} else {
//				logStepInfo("Background Screen Next Button Not Clicked : " + "BS Next");
//			}
			clickElement(backgrndScrnNextBtn, "BS Next");
			logStepInfo("Background Screen Next Button Clicked : " + "BS Next");

//			clickElement(iUnderstandBtn1, "I Understand");
//			logStepInfo("I Understand Button Clicked : " + "I Understand");
			
//			if (verifyElementPresence(iUnderstandPopup)) {
//				clickElement(iUnderstandBtn1, "I Understand");
//				logStepInfo("I Understand Button Clicked : " + "I Understand");
//			} else {
//				logStepInfo("I Understand Button Not Clicked : " + "I Understand");
//			}
			
//			wait.until(ExpectedConditions.presenceOfElementLocated(iUnderstandPopup));
//			clickElement(iUnderstandBtn, "I Understand");
//			logStepInfo("I Understand Button clicked : " + "I Understand");

		} catch (Exception ex) {
			logStepInfo("Exception occured in PA Profile Page:- " + ex.getMessage());
			reportLog(Status.FAIL, "Exception occured in PA Profile Page :- " + ex.getMessage(), true);
		}
	}

	
	public void enterProfileWithChanges(String profileDob, String pANewFirstName, String pANewLastName, String pANewMiddleName) {
		try {

			WebDriverWait wait = new WebDriverWait(driver, 10);

			clickElement(pAFirstName, "First Name");
			EnterText(pAFirstName, "First Name", pANewFirstName);
			
			logStepInfo("First Name changed to: " + pANewFirstName);
			
			clickElement(pALastName, "Last Name");
			EnterText(pALastName, "Last Name", pANewLastName);
			logStepInfo("Last Name changed to: " + pANewLastName);
			
			clickElement(pAMiddleName, "Middle Name");
			EnterText(pAMiddleName, "Middle Name", pANewMiddleName);
			logStepInfo("Middle Name changed to: " + pANewMiddleName);
			
			clickElement(nameNextBtn, "Next");
			logStepInfo("Next Button clicked : " + "Next");
			
			clickElement(changeNameBtn, "Confirm Changed Name");
			logStepInfo("Confirm Changed Name clicked : " + "Confirm Changed Name");
//			
//			if (verifyElementPresence(noMiddleNameButton)) {
//				clickElement(noMiddleNameButton, "No Middle Name");
//				logStepInfo("No Middle Name Button Clicked : " +"No Middle Name");
//			} else {
//				logStepInfo("No Middle Name Button Not Clicked : " +"No Middle Name");
//			}

			clickElement(noOtherNameBtn, "No Other Name");
			logStepInfo("No Other Name Button Clicked : " + "No Other Name");

//			clickElement(genederSelectMale, "Gender Select Male");
//			logStepInfo("Gender Selected as Male : " + "Gender Select");
//
//			clickElement(genderNextBtn, "Gender Next Button");
//			logStepInfo("Gender Next Button Clicked : " + "Gender Next");


			clickElement(dateofBirth, "DOB");
			wait(2);
			EnterText(dateofBirth, "DOB", profileDob);
			wait(2);
			logStepInfo("Date Of Birth Entered : " + profileDob);

			clickElement(dobNextBtn, "DOB Next");
			logStepInfo("DOB Next Button clicked : " + "DOB Next");

			clickElement(dobConfirm, "Confirm");
			logStepInfo("DOB Confirm Button Clicked : " + "Confirm");

			clickElement(backgrndScrnNextBtn, "BS Next");
			logStepInfo("Background Screen Next Button Clicked : " + "BS Next");

		} catch (Exception ex) {
			logStepInfo("Exception occured in PA Profile Page:- " + ex.getMessage());
			reportLog(Status.FAIL, "Exception occured in PA Profile Page :- " + ex.getMessage(), true);
		}
	}
	
	
	
}
