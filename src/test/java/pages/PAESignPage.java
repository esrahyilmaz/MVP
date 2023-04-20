package pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import seleniumhelper.BaseClass;

public class PAESignPage extends BaseClass {

	private static By yesEAuthSign = By.xpath("//button[@id='eauth_yes']");
	
	public void clickESignButton() {
		try {

			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.presenceOfElementLocated(yesEAuthSign)).click();
			logStepInfo("E-Sign Button clicked : "+"Yes Use E-Signature");
			
			
		} catch (Exception ex) {
			logStepInfo("Exception occured in PA ESign Page:- "+ex.getMessage());
			reportLog(Status.FAIL,"Exception occured in PA ESign Page :- "+ex.getMessage(), true);
		}
	}

}
