package Utility;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import seleniumhelper.BaseClass;

public class HandlePopUp extends BaseClass{

	public void handlePopUp() {	
			wait(2);
		boolean alert=HandlePopUp.isAlertPresent();
		if(alert) {
		Alert aler=driver.switchTo().alert();	
		String msg=aler.getText();
		aler.accept();
		reportLog(Status.PASS, msg+" ---> Message of Alert", false);
		}	else {
		reportLog(Status.FAIL, "Alert Not Present", true);	
		}
	}
	
	public void handlePopUpRemoveEmail() {
		if(scenarioName.contains("Remove-Email")) {
			if(verifyElementPresence(By.xpath("//input[@value='SEND BADGE']"))) {
				clickElement((By.xpath("//input[@value='SEND BADGE']")), "SEND BADGE");
			}
			wait(5);
		}
			wait(2);
		boolean alert=HandlePopUp.isAlertPresent();
		if(alert) {
		Alert aler=driver.switchTo().alert();	
		String msg=aler.getText();
		aler.accept();
		reportLog(Status.PASS, msg+" ---> Message of Alert", false);
		}	else {
		reportLog(Status.FAIL, "Alert Not Present", true);	
		}
	}
	
	public static  boolean isAlertPresent(){
	    boolean foundAlert = false;
	    WebDriverWait wait = new WebDriverWait(driver, 0 /*timeout in seconds*/);
	    try {
	        wait.until(ExpectedConditions.alertIsPresent());
	        foundAlert = true;
	    } catch (TimeoutException eTO) {
	        foundAlert = false;
	    }
	    return foundAlert;
	}
}
