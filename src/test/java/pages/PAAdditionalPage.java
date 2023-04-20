package pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import seleniumhelper.BaseClass;

public class PAAdditionalPage extends BaseClass {
	
	private static By addlPageNxtBtn = By.xpath("//form[@name='AdditionalDetails']//button[text()='NEXT']");

	public void enterAdditionalSection() {
		try {

			clickElement(addlPageNxtBtn, "Next");
			logStepInfo("Next Button is Clicked : " + "Next");
            
		} catch (Exception ex) {
			logStepInfo("Exception occured in PA Additional Page:- " + ex.getMessage());
			reportLog(Status.FAIL, "Exception occured in PA Additional Page :- " + ex.getMessage(), true);
		}
  }
}
