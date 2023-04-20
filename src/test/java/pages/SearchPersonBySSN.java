package pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import seleniumhelper.BaseClass;

public class SearchPersonBySSN extends BaseClass
{
public By PeopleTAB=By.xpath("//a[.='> People']");
public By SearchTAB=By.xpath("//a[contains(.,'Search People')]");
public By ssnTB=By.xpath("//input[@name='ssn']");
public By firstNameTB=By.xpath("//input[@name='firstName']");
public By SearchBTN=By.xpath("//input[@name='search']");
public By ResultLink=By.xpath("//div[contains(.,'Name')]/../..//a");
public By OrderIDData=By.xpath("(//div[contains(.,'Order Id')]/../../../..//td)[1]");
public By OrderRefIDData=By.xpath("(//div[contains(.,'Order Ref Id')]/../../../..//td)[2]");
public By ComplianceDD=By.xpath("//select[@name='complianceStatusCd']");


public void searchPersonByssn() {
	
	if(verifyElementPresence(PeopleTAB)) {
		clickElement(PeopleTAB, "people tab");
	}
	
	if(verifyElementPresence(SearchTAB)) {
		clickElement(SearchTAB, "Search tab");
	}
	
	if(verifyElementPresence(ssnTB)) {
		EnterText(ssnTB, "SSN", SSN);
	}
	
	if(verifyElementPresence(SearchBTN)) {
		clickElement(SearchBTN, "Search button");
	}
	
	if(verifyElementPresence(ResultLink)) {
		clickElement(ResultLink, "Result Link");
	}
	
	
	if(verifyElementPresence(OrderIDData)) {
		OrderID=driver.findElement(OrderIDData).getText();
	}
	
	if(verifyElementPresence(OrderRefIDData)) {
		OrderRefID=driver.findElement(OrderRefIDData).getText();
	}
}

public void searchPersonByFN() {
	
	if(verifyElementPresence(PeopleTAB)) {
		clickElement(PeopleTAB, "people tab");
	}
	
	if(verifyElementPresence(SearchTAB)) {
		clickElement(SearchTAB, "Search tab");
	}
	
	if(verifyElementPresence(firstNameTB)) {
		EnterText(firstNameTB, "firstName", existingFirstName);
	}
		
	if(verifyElementPresence(SearchBTN)) {
		clickElement(SearchBTN, "Search button");
	}
	
	if(verifyElementPresence(ResultLink)) {
		clickElement(ResultLink, "Result Link");
	}
	
	if(verifyElementPresence(OrderIDData)) {
		OrderID=driver.findElement(OrderIDData).getText();
	}
	
	if(verifyElementPresence(OrderRefIDData)) {
		OrderRefID=driver.findElement(OrderRefIDData).getText();
	}
	
	if(verifyElementPresence(By.xpath("(//td[contains(.,'First Name:')])[last()]/..//td[contains(.,'"+ existingFirstName +"')]"))) {
		reportLog(Status.PASS, "First Name is Present", true);
	}else {
		reportLog(Status.FAIL, "First NAme is Not Present", true);
	}
	
	if(verifyElementPresence(By.xpath("(//td[contains(.,'Last Name:')])[last()]/..//td[contains(.,'"+existingLastName+"')]"))) {
		reportLog(Status.PASS, "Last Name is Present", true);
	}else {
		reportLog(Status.FAIL, "Last NAme is Not Present", true);
	}
}

	public void searchPersonByStatus(String status) {
		
		if(verifyElementPresence(PeopleTAB)) {
			clickElement(PeopleTAB, "people tab");
		}
		
		if(verifyElementPresence(SearchTAB)) {
			clickElement(SearchTAB, "Search tab");
		}
		
		if(verifyElementPresence(ComplianceDD)) {
			selectDropDown(ComplianceDD, status, "Compliance status");
		}
		
		if(verifyElementPresence(SearchBTN)) {
			clickElement(SearchBTN, "Search button");
		}
		
		if(verifyElementPresence(By.xpath("//div[contains(.,'Name')]/../..//a[.='Next>']"))) {
			clickElement(By.xpath("(//div[contains(.,'Name')]/../..//a)[2]"), "Result Link");
		}else {
		if(verifyElementPresence(ResultLink)) {
			clickElement(ResultLink, "Result Link");
		}
		}
		
	}
}
