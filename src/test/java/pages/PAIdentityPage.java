package pages;

import Utility.CurrentDateTime;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import seleniumhelper.BaseClass;

public class PAIdentityPage extends BaseClass {

	private static By SSNNum= By.xpath(".//*[@id='inputSSN_0']");
	private static By cnfrmSSNNum  = By.xpath(".//*[@id='confirmSSN_0']");
	private static By SSNPutNextButton = By.cssSelector("personal-ssn button[class='btn arrowrightctr'] i");
	private static By iUnderstandBtn = By.xpath("//button[text()='I UNDERSTAND']");
	

	public void enterIdentitySection() {
		try {
//			SSN = "112233445";
			SSN = CurrentDateTime.SystemDateYear()+Random_NumberGenerator(5);
			existingSSN = SSN;
						
			clickElement(SSNNum, "SSN");
			EnterText(SSNNum, "SSN", SSN);
			logStepInfo("SSN Field Entered : " + SSN);
			
			clickElement(cnfrmSSNNum, "Confirm SSN");
			EnterText(cnfrmSSNNum, "Confirm SSN", SSN);
			logStepInfo("Confirm SSN Field Entered : " + SSN);

			clickElement(SSNPutNextButton, "Next");
			logStepInfo("Next Button Clicked : " + "Next");

//			if (verifyElementPresence(iUnderstandBtn)) {
//				clickElement(iUnderstandBtn, "I Understand");
//				logStepInfo("I Understand Button clicked : " + "I Understand");
//			} else {
//				logStepInfo("I Understand Button Not clicked : "+"I Understand");
//			}

//			clickElement(iUnderstandBtn, "I Understand");
//			logStepInfo("I Understand Button clicked : " + "I Understand");

		} catch (Exception ex) {
			logStepInfo("Exception occured in PA Identity Page:- " + ex.getMessage());
			reportLog(Status.FAIL, "Exception occured in PA Identity Page :- " + ex.getMessage(), true);
		}
	}

}
