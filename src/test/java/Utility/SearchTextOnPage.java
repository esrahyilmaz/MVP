package Utility;


import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import seleniumhelper.BaseClass;


public class SearchTextOnPage extends BaseClass {
	
	public void SearchText(String PARAM_EXPECTED_TEXT) {
		String value = null;
		
		value = PARAM_EXPECTED_TEXT;
		if (!value.isEmpty()) {
			if (verifyElementPresence(By.xpath("(//*[contains(text(),'"+ value +"')])[last()]"))) {
				reportLog(Status.PASS, "Text [" + value + "] was found on the web page", false);
			}else if(verifyElementPresence(By.xpath("//*[@id='alertmsgpop']//font"))) {
				reportLog(Status.PASS, "Text [" + value + "] was found on the web page", false);
			}
			else 
				reportLog(Status.FAIL, "Text [" + value + "] was NOT found on the web page", false);
			}
		}
	

	public void SearchTextProfile(String PARAM_EXPECTED_TEXT) {
String value = null;
		
		value = PARAM_EXPECTED_TEXT;
		String text=driver.findElement(By.xpath("//*[@id='errorMessages']")).getText();
		if (!text.isEmpty()) {
			if (text.contains(PARAM_EXPECTED_TEXT)) {
				reportLog(Status.PASS, "Text [" + value + "] was found on the web page", false);
			} else {
				reportLog(Status.FAIL, "Text [" + value + "] was NOT found on the web page", false);
			}
		}
	}

}
