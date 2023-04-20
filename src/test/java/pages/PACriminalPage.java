package pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import seleniumhelper.BaseClass;

public class PACriminalPage extends BaseClass {
	
	private static By criminalActNoButton = By.xpath("//button[@data-id = 'criminalConfirmNo_0']");
	private static By iUnderstandBtn = By.xpath("//button[text()='I UNDERSTAND']");

	public void enterCriminalSection() {
		try {

//			if (verifyElementPresence(iUnderstandBtn)) {
//				clickElement(iUnderstandBtn, "I Understand");
//				logStepInfo("I Understand Button clicked : " + "I Understand");
//			} else {
//				logStepInfo("I Understand Button Not clicked : "+"I Understand");
//			}
			clickElement(criminalActNoButton, "No Criminal");
			logStepInfo("Criminal No Field Clicked : " + "No Criminal");
            
		} catch (Exception ex) {
			logStepInfo("Exception occured in PA Criminal Page:- " + ex.getMessage());
			reportLog(Status.FAIL, "Exception occured in PA Criminal Page :- " + ex.getMessage(), true);
		}
  }
}
