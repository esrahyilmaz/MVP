package pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import seleniumhelper.BaseClass;

public class PADocumentUploadPage extends BaseClass {
	
	private static By docUplodSubMitProf1 = By.xpath("(//button[contains(text(),'NEXT')])[2]");
	private static By labAddress = By.xpath("//button[contains(text(),'NEXT')]");
	private static By submitProfile = By.xpath("//button [contains(text(),'SUBMIT PROFILE')]");
	private static By address = By.xpath("//online-schedule-address/div/div/div[2]/div[4]/div[2]/div/div[1]/div/div/div/div[2]/button");
	
	public void enterDocumUploadSection() {
		try {
			
			wait(5);
			clickOnElementUsingActions(docUplodSubMitProf1, "Next");
			logStepInfo("Next Button is Clicked : " + "Next");
			
			clickElement(submitProfile, "Submit Profile");
			logStepInfo("Submit Profile Button is Clicked : " + "Submit Profile");
						           
		} catch (Exception ex) {
			logStepInfo("Exception occured in PA Document Page:- " + ex.getMessage());
			reportLog(Status.FAIL, "Exception occured in PA Document Page :- " + ex.getMessage(), true);
		}
  }

    public void enterDocumUploadSectionDT() {
		try {

			clickElement(docUplodSubMitProf1, "Next");
			logStepInfo("Next Button is Clicked : " + "Next");

			clickElement(address, "Drug Address");
			logStepInfo("Drug Address is selected : " + "Address");

			wait(2);
			clickElement(labAddress, "Next");
			logStepInfo("Next Button is Clicked : " + "Next");

			clickElement(submitProfile, "Submit Profile");
			logStepInfo("Submit Profile Button is Clicked : " + "Submit Profile");

		} catch (Exception ex) {
			logStepInfo("Exception occured in PA Document Page:- " + ex.getMessage());
			reportLog(Status.FAIL, "Exception occured in PA Document Page :- " + ex.getMessage(), true);
		}
    }
}
