package pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import seleniumhelper.BaseClass;

public class PACountryPage extends BaseClass {

	private static By countryFieldDD = By.xpath("//input[@id='consentCountry']");
    private static By countryNextButton = By.xpath("//button[text()='NEXT']");
    private static By concentCountryConfirm = By.xpath("//button[text()='CONFIRM']");
    public static By popupCountryConsentStatus = By.xpath("//h4[contains(text(),'Please confirm that UNITED STATES is your current country of residence. This cannot be changed later')]");
	public static By dropDownPA = By.xpath("//*[contains (@class,'marked')][last()]");
	//    private static By concentCountryConfirm = By.xpath("//*[@id=\"consent-modal\"]/div/div/div[3]/div/div[1]/button");
	
	public void enterPACountry(String countryPA) {
		try {

			WebDriverWait wait = new WebDriverWait(driver, 20); 
			
//			if (verifyElementPresence(countryFieldDD)) {
//				EnterText(countryFieldDD,"country", countryPA);
//				logStepInfo("Country Field Entered : " +countryPA );
//			} else {
//				logStepInfo("Country Field Not Entered : " +countryPA);
//			}
//			if (verifyElementPresence(countryNextButton)) {
//				clickElement(countryNextButton, "Next");
//				logStepInfo("Next Button Clicked : " +"Next");
//			} else {
//				logStepInfo("Next Button Not Clicked: " +"Next" );
//			}
			wait.until(ExpectedConditions.presenceOfElementLocated(countryFieldDD)).click();
			EnterText(countryFieldDD,"country", countryPA);
			wait(2);
			logStepInfo("Country Field Entered : " +countryPA );
			WebElement countryField=driver.findElement(countryFieldDD);
			countryField.sendKeys(Keys.ENTER);


//			if (verifyElementPresence(dropDownPA))
//			{
//				clickElementWithWait(dropDownPA, "Dropdown element!");
//			}
//
			wait.until(ExpectedConditions.presenceOfElementLocated(countryNextButton)).click();
			logStepInfo("Next Button Clicked : " +"Next");

			wait.until(ExpectedConditions.presenceOfElementLocated(popupCountryConsentStatus));
			wait.until(ExpectedConditions.presenceOfElementLocated(concentCountryConfirm));
			clickElement(concentCountryConfirm, "Confirm");
			logStepInfo("Confirm Button Clicked : " +"Confirm");
			

		} catch (Exception ex) {
			logStepInfo("Exception occured in PA Country Page:- "+ex.getMessage());
			reportLog(Status.FAIL,"Exception occured in PA Country Page :- "+ex.getMessage(), true);
		}
	}


}
