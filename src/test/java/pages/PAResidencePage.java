package pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import seleniumhelper.BaseClass;

public class PAResidencePage extends BaseClass {
	
	private static By countryNextBtn = By.xpath("//button[contains(text(), 'NEXT')]");
	private static By addressNextBtn = By.xpath("(//button[contains(@id,'resDetailsNext') and contains(.,'NEXT')])[last()]");
	private static By startLivingNextBtn = By.xpath("(//button[contains(@id,'resMoveInOutNext') and contains(.,'NEXT')])[last()]");
	private static By strtAddrInp = By.xpath("//input[@formcontrolname='street_address']");
	private static By zipCodInp = By.xpath("//input[@id = 'residentialAddressZipcode_0']");
	private static By cityInp = By.xpath("//input[@id='resCityTextField_0_0']");
	private static By stateInp = By.xpath("//input[@id='resStateTextField_0_0']");
	private static By ResSlideCalendr = By.xpath("//div[@id='residentialSlide']//input[contains(@id,'-widget')]");
	private static By iUnderstandBtn =  By.xpath("//button[text()='I UNDERSTAND']");
	public static By dropDownPA = By.xpath("//*[contains (@class,'marked')][last()]");

	public void enterResidenceSection(String address1, String zipCode, String state, String city, String startMonth,
			String startYear) {
		try {

//			clickElement(iUnderstandBtn, "I Understand");
//			logStepInfo("I Understand Button clicked : " + "I Understand");
			
			clickElement(countryNextBtn, "Next");
			logStepInfo("Next Button clicked : " + "Next");
            
			clickElement(strtAddrInp, "Address1");
			EnterText(strtAddrInp, "Address1", address1);
			logStepInfo("Address1 Entered : " + address1);
            
			clickElement(zipCodInp, "ZipCode");
			EnterText(zipCodInp, "ZipCode", zipCode);
			logStepInfo("ZipCode Entered : " + zipCode);

			if (verifyElementPresence(dropDownPA))
			{
				clickElementWithWait(dropDownPA, "Dropdown element!");
			}

			clickElement(stateInp, "State");
			EnterText(stateInp, "State", state);
			logStepInfo("State Entered : " + state);

			if (verifyElementPresence(dropDownPA))
			{
				clickElementWithWait(dropDownPA, "Dropdown element!");
			}

			clickElement(cityInp, "City");
			EnterText(cityInp, "City", city);
			logStepInfo("City Entered : " + city);

			if (verifyElementPresence(dropDownPA))
			{
				clickElementWithWait(dropDownPA, "Dropdown element!");
			}

			clickElementWithWait(addressNextBtn, "Next");
			logStepInfo("Next Button clicked : " + "Next");

			clickElement(ResSlideCalendr, "Start Living");
			logStepInfo("Start Living field clicked : " + "Start Living");
			EnterText(ResSlideCalendr, "Start Month", startMonth);
			logStepInfo("Start Month Entered : " + startMonth);

			driver.findElement(ResSlideCalendr).sendKeys(Keys.TAB);
			
			driver.findElement(ResSlideCalendr).sendKeys(startYear);
			logStepInfo("Start Year Entered : " + startYear);

			clickElement(startLivingNextBtn, "Next");
			logStepInfo("Next Button clicked : " + "Next");
			
//			clickElement(iUnderstandBtn, "I Understand");
//			logStepInfo("I Understand Button clicked : " + "I Understand");
			
//			if (verifyElementPresence(iUnderstandBtn)) {
//				clickElement(iUnderstandBtn,"I Understand");
//				logStepInfo("I Understand Button clicked : "+"I Understand");
//			} else {
//				logStepInfo("I Understand Button Not clicked : "+"I Understand");
//			}
//			
////			clickElement(iUnderstandBtn, "I Understand");
////			logStepInfo("I Understand Button clicked : " + "I Understand");

		} catch (Exception ex) {
			logStepInfo("Exception occured in PA Profile Page:- " + ex.getMessage());
			reportLog(Status.FAIL, "Exception occured in PA Profile Page :- " + ex.getMessage(), true);
		}
	}
	
	public void enterResidenceSectionUAT (String address1, String zipCode, String state, String city, String startMonth, String startYear) {
		try {
			clickElement(iUnderstandBtn, "I Understand");
			logStepInfo("I Understand Button clicked : " + "I Understand");
			
			clickElement(countryNextBtn, "Next");
			logStepInfo("Next Button clicked : " + "Next");
            
			clickElement(strtAddrInp, "Address1");
			EnterText(strtAddrInp, "Address1", address1);
			logStepInfo("Address1 Entered : " + address1);
            
			clickElement(zipCodInp, "ZipCode");
			EnterText(zipCodInp, "ZipCode", zipCode);
			logStepInfo("ZipCode Entered : " + zipCode);

			if (verifyElementPresence(dropDownPA))
			{
				clickElementWithWait(dropDownPA, "Dropdown element!");
			}

			clickElement(stateInp, "State");
			EnterText(stateInp, "State", state);
			logStepInfo("State Entered : " + state);

			if (verifyElementPresence(dropDownPA))
			{
				clickElementWithWait(dropDownPA, "Dropdown element!");
			}

			clickElement(cityInp, "City");
			EnterText(cityInp, "City", city);
			logStepInfo("City Entered : " + city);

			if (verifyElementPresence(dropDownPA))
			{
				clickElementWithWait(dropDownPA, "Dropdown element!");
			}

			clickElementWithWait(addressNextBtn, "Next");
			logStepInfo("Next Button clicked : " + "Next");

			clickElement(ResSlideCalendr, "Start Living");
			logStepInfo("Start Living field clicked : " + "Start Living");
			EnterText(ResSlideCalendr, "Start Month", startMonth);
			logStepInfo("Start Month Entered : " + startMonth);

			driver.findElement(ResSlideCalendr).sendKeys(Keys.TAB);
			
			driver.findElement(ResSlideCalendr).sendKeys(startYear);
			logStepInfo("Start Year Entered : " + startYear);

			clickElement(startLivingNextBtn, "Next");
			logStepInfo("Next Button clicked : " + "Next");
			

		} catch (Exception ex) {
			logStepInfo("Exception occured in PA Profile Page:- " + ex.getMessage());
			reportLog(Status.FAIL, "Exception occured in PA Profile Page :- " + ex.getMessage(), true);
		}
	}
	
}
