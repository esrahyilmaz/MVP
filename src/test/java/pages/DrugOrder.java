package pages;

import Utility.CurrentDateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import seleniumhelper.BaseClass;

public class DrugOrder extends BaseClass{
	
	private static By AddressTB=By.xpath("//*[@id='sitesSearchAddress']");
	private static By SearchBtn=By.xpath("//input[@value='Search']");
	private static By ScheduleLink=By.xpath("(//a[.='Schedule'])[2]");
	private static By SaveScheduleBtn=By.xpath("//*[@id='SaveScheduleButton']");
	private static By ChangeSiteBtn=By.xpath("//input[@value=''Change Site]");
	private static By OfferDateTB=By.xpath("//input[@name='OfferDate']");
	private static By FpAppDateDD=By.xpath("//select[@name='FPRINTApptDate']");
    private static By FpAppTimeDD=By.xpath("(//th[.='Finger Print Appointment']/..//select)[3]");
    private static By EmailAddressTB=By.xpath("//input[@name='emailAddress']");
	private static By ConfirmEmailAddressTB=By.xpath("//input[@name='confirmEmailAddress']");
	private static By PhoneNumberTB=By.xpath("//input[@name='phoneNumber']");
	private static By NextBtn=By.xpath("//input[@value='NEXT']");
	private static By DrugTestChkbox=By.xpath("//input[@id='INPUT_URIFULDOT']");
	
	public void schedule() throws Exception {
		WebElement Frame=driver.findElement(By.xpath("//iframe[@name='schPortletFrame']"));
		driver.switchTo().frame(Frame);
		
		wait(30);
		
		if(verifyElementPresence(ChangeSiteBtn)) {
			EnterText(OfferDateTB, "Offer Date", CurrentDateTime.SystemDateMMDD());
			clickElement(By.xpath("//h2[.='Scheduling Information']"), "outside");
			clickElement(ChangeSiteBtn, "Change Site");
			wait(30);
		}
			
		
		if(verifyElementPresence(AddressTB)&&!(scenarioName.contains("Fingerprint"))) {
			EnterText(AddressTB, "Address", "3655 Nantucket Island Dr, Port Orange, FL 32129, USA");
		}
		
		if(verifyElementPresence(DrugTestChkbox)) {
			clickElement(DrugTestChkbox, "DrugTestCheckBox");
		}
		
		if(verifyElementPresence(SearchBtn)) {
			clickElement(SearchBtn, "search");
		}
		wait(30);
		if(verifyElementPresence(ScheduleLink)) {
			clickElement(ScheduleLink, "schedule");
		}
		
		
		wait(20);
		
        if(verifyElementPresence(FpAppDateDD)) {
                       selectDropDownByIndex(FpAppDateDD, "2", "FpAppoinmentDate");
                       clickElement(By.xpath("//h2[.='Scheduling Information']"), "outside");
        }
        wait(3);
        if(verifyElementPresence(FpAppTimeDD)) {
                       selectDropDownByIndex(FpAppTimeDD, "2", "FpAppoinmentTime");
                       clickElement(By.xpath("//h2[.='Scheduling Information']"), "outside");
        }

		
		if(verifyElementPresence(SaveScheduleBtn)) {
			EnterText(OfferDateTB, "Offer Date", CurrentDateTime.SystemDateMMDD());
			clickElement(By.xpath("//h2[.='Scheduling Information']"), "outside");
			clickElement(SaveScheduleBtn, "save schedule");
		}
		wait(5);
		verifyTextPresence("Schedule has been tentatively saved.");
		
		driver.switchTo().parentFrame();
	}
	
public void emailAddress(String EmailAddress, String PhoneNumber) throws Exception {
		
		String value =null;
		
		value=EmailAddress;
		if(!(value==null)|| !(value.isEmpty())) {
		EnterText(EmailAddressTB, "EmailAddress", value);
		}
	
		if(!(value==null)|| !(value.isEmpty())) {
		EnterText(ConfirmEmailAddressTB, "ConfirmEmailAddress", value);
		}
		value=PhoneNumber;
		if(!(value==null)|| !(value.isEmpty())) {
		EnterText(PhoneNumberTB, "EmailAddress", value);
		
		}
		clickElement(NextBtn, "Next");
	}

}
