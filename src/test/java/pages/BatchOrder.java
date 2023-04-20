package pages;

import org.openqa.selenium.By;
import seleniumhelper.BaseClass;

public class BatchOrder extends BaseClass{

	public By PeopleTAB=By.xpath("//a[.='> People']");
	public By SearchTAB=By.xpath("//a[contains(.,'Search People')]");
	public By lastNameTB=By.xpath("//input[@name='lastName']");
	public By ComplianceStatusDD=By.xpath("//select[@name='complianceStatusCd']");
	public By searchBtn=By.xpath("//input[@value='SEARCH']");
	public By recordsChkBox=By.xpath("//input[@name='batchViaID']");
	public By OrderSelectedBtn=By.xpath("//input[@name='Submit']");
	
	public void batchOrder() {
		if(verifyElementPresence(PeopleTAB)) {
			clickElement(PeopleTAB, "people tab");
		}
		
		if(verifyElementPresence(SearchTAB)) {
			clickElement(SearchTAB, "Search tab");
		}
		
		if(verifyElementPresence(lastNameTB)) {
			EnterText(lastNameTB, "last name", existingLastName);
		}
		
		if(verifyElementPresence(ComplianceStatusDD)) {
			selectDropDown(ComplianceStatusDD, "Need To Order", "Compliance Status");
		}
		
		if(verifyElementPresence(searchBtn)) {
			clickElement(searchBtn, "search Btn");
		}
		
		if(verifyElementPresence(recordsChkBox)) {
			int size = driver.findElements(By.xpath("//input[@name='batchViaID']")).size();
			for(int i=1;i<=size;i++) {
				clickElement(By.xpath("(//input[@name='batchViaID'])["+i+"]"), "background radio button");
			}
		}
		
		if(verifyElementPresence(OrderSelectedBtn)) {
			clickElement(OrderSelectedBtn, "Order Selected");
		}
	}
}
