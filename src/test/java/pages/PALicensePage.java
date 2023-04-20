package pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import seleniumhelper.BaseClass;

public class PALicensePage extends BaseClass {
	
	private static By licenceyesbuttonClick = By.xpath("//button[contains(text(),'YES')]");
	private static By fildCountry = By.cssSelector("input[id='mvrCountry0']");
	private static By licencecntryNextButton = By.xpath("//button[starts-with(@data-id,'mvrCountryNext')]");
	private static By fildState = By.cssSelector("input[id='mvrState_0']");
	private static By licencestateNextButton = By.xpath("//button[starts-with(@data-id,'mvrStateNext')]");
	private static By fildlicenceNumTxtBox = By.xpath("//input[@formcontrolname='number']");
	private static By licencenumNextButton = By.xpath("//button[starts-with(@data-id,'mvrNumberNext')]");
	private static By licenseTypeNonComm = By.xpath("//option[@value='Non-commercial']");
	private static By licencetypeNextButton = By.xpath("//button[starts-with(@data-id,'mvrTypeNext')]");
	private static By licencereconfirmNo = By.xpath("//button[starts-with(@data-id,'mvrReConfirmNo')]");
	private static By iUnderstandBtn = By.xpath("//button[text()='I UNDERSTAND']");
	public static By dropDownPA = By.xpath("//*[contains (@class,'marked')][last()]");

	public void enterLicenseSection(String country, String state, String licenseNumb) {
		try {

			clickElement(licenceyesbuttonClick, "Yes");
			logStepInfo("Yes Button clicked : " + "Yes");
            
			clickElement(fildCountry, "Country");
			EnterText(fildCountry, "Country", country);
			logStepInfo("Country Entered : " + country);

			if (verifyElementPresence(dropDownPA))
			{
				clickElementWithWait(dropDownPA, "Dropdown element!");
			}
            
			clickElement(licencecntryNextButton, "Next");
			logStepInfo("Next Button Clicked : " + "Next");

			clickElement(fildState, "State");
			EnterText(fildState, "State", state);
			logStepInfo("State Entered : " + state);

			if (verifyElementPresence(dropDownPA))
			{
				clickElementWithWait(dropDownPA, "Dropdown element!");
			}

			clickElement(licencestateNextButton, "Next");
			logStepInfo("Next Button Clicked : " + "Next");

			clickElement(fildlicenceNumTxtBox, "License No");
			EnterText(fildlicenceNumTxtBox, "License No", licenseNumb);
			logStepInfo("License Number Entered : " + licenseNumb);

			clickElement(licencenumNextButton, "Next");
			logStepInfo("Next Button Clicked : " + "Next");

			clickElement(licenseTypeNonComm, "Non Commerical");
			logStepInfo("Non Commerical field clicked : " + "Non Comerical");
			
			clickElement(licencetypeNextButton, "Next");
			logStepInfo("Next Button Clicked : " + "Next");
			
			wait(2);
			clickElement(licencereconfirmNo, "No");
			logStepInfo("Confirm License No Button is clicked : " + "No");
			
//			wait(5);
//			clickElement(iUnderstandBtn,"I Understand" );
//			logStepInfo("I Understand Button clicked : "+"I Understand");
						
		} catch (Exception ex) {
			logStepInfo("Exception occured in PA License Page:- " + ex.getMessage());
			reportLog(Status.FAIL, "Exception occured in PA License Page :- " + ex.getMessage(), true);
		}
	}

	
	public void enterLicenseSectionUAT(String country, String state, String licenseNumb) {
		try {

			clickElement(iUnderstandBtn, "I Understand");
			logStepInfo("I Understand Button clicked : " + "I Understand");
			
			clickElement(licenceyesbuttonClick, "Yes");
			logStepInfo("Yes Button clicked : " + "Yes");
            
			clickElement(fildCountry, "Country");
			EnterText(fildCountry, "Country", country);
			logStepInfo("Country Entered : " + country);
            
			clickElement(licencecntryNextButton, "Next");
			logStepInfo("Next Button Clicked : " + "Next");

			clickElement(fildState, "State");
			EnterText(fildState, "State", state);
			logStepInfo("State Entered : " + state);

			clickElement(licencestateNextButton, "Next");
			logStepInfo("Next Button Clicked : " + "Next");

			clickElement(fildlicenceNumTxtBox, "License No");
			EnterText(fildlicenceNumTxtBox, "License No", licenseNumb);
			logStepInfo("License Number Entered : " + licenseNumb);

			clickElement(licencenumNextButton, "Next");
			logStepInfo("Next Button Clicked : " + "Next");

			clickElement(licenseTypeNonComm, "Non Commerical");
			logStepInfo("Non Commerical field clicked : " + "Non Comerical");
			
			clickElement(licencetypeNextButton, "Next");
			logStepInfo("Next Button Clicked : " + "Next");
			
			wait(2);
			clickElement(licencereconfirmNo, "No");
			logStepInfo("Confirm License No Button is clicked : " + "No");
			
			wait(5);
			clickElement(iUnderstandBtn,"I Understand" );
			logStepInfo("I Understand Button clicked : "+"I Understand");
						
		} catch (Exception ex) {
			logStepInfo("Exception occured in PA License Page:- " + ex.getMessage());
			reportLog(Status.FAIL, "Exception occured in PA License Page :- " + ex.getMessage(), true);
		}
	}
}
