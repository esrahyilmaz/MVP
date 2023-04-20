package pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import seleniumhelper.BaseClass;

public class ValidationProd extends BaseClass{

	private By searchPeopleBTN=By.xpath("//input[@value='SEARCH']");
	private By middleNameYRBtN =By.xpath("//input[@name='middleNameRequired' and @title='Yes']");
	private By middleNameNRBtN =By.xpath("//input[@name='middleNameRequired' and @title='No']");
	private By saveBtN = By.xpath("//input[@value='SAVE']");
	
	public void verifySearchPeople() {
		if(verifyElementPresence(searchPeopleBTN)) {
			clickElement(searchPeopleBTN, "Search People");
		}
		
		int size=driver.findElements(By.xpath("//input[@name='batchViaID']/../..//a")).size();
		if(size>0) {
			reportLog(Status.PASS, "There are "+size+" Records present for the People Search", true);
		}else {
			reportLog(Status.FAIL, "There are "+size+" Records present for the People Search", true);
		}
	}
	
	public void verifyMiddleName(String middleName) {
		
		if(middleName.equalsIgnoreCase("Yes")) {
			clickElement(middleNameYRBtN, middleName+" MiddleName Radiobtn");
			clickElement(saveBtN, "Save");
			
		}else if (middleName.equalsIgnoreCase("No")) {
			clickElement(middleNameNRBtN, middleName+" MiddleName Radiobtn");
			clickElement(saveBtN, "Save");
			
		}
		 
		
	}
	
	
}
