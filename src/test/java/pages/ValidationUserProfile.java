package pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import seleniumhelper.BaseClass;

public class ValidationUserProfile extends BaseClass{

	private static String FirstNameInProgress="CAAuto_NKHRYMBB";
	private static String FirstNameNeedToOrder="CAAuto_RRHBJFBB";
	private static String FirstNameCompliant="CAAuto_IBOMOYBB";
//	private static String FirstNameCompliant="Krishna";
	
	private static By peopleTab=By.xpath("//a[.='> People']");
	private static By searchPersonTab=By.xpath("//a[.='Search People ']");
	private static By FirstNameTB=By.xpath("//input[@name='firstName']");
	private static By SearchBTn=By.xpath("//input[@value='SEARCH']");
	
	
	public void validate() {
		
		clickElement(peopleTab, "People Tab");
		clickElement(searchPersonTab, "search person");
		EnterText(FirstNameTB, "First Name", FirstNameInProgress);
		clickElement(SearchBTn, "Search");
		clickElement(By.xpath("//a[contains(.,'"+FirstNameInProgress+"')]"), FirstNameInProgress);
		
		//in Progress validation
		
		verifyElementPresence(By.xpath("//td[@class='dispLabelTextRight' and contains(.,'Compliance Expires')]/..//td[contains(.,'02/28/2021')]"),"Compliance Expiry");
		verifyElementPresence(By.xpath("//td[@class='dispLabelTextRight' and contains(.,'Compliance Status')]/..//td[contains(.,'In Progress')]"), "Compliance Status");
		String badgeNumberInprogress=driver.findElement(By.xpath("(//td[@class='dispLabelTextRight' and contains(.,'Badge Number')]/..//td[contains(.,'')])[last()]")).getText();
		if(badgeNumberInprogress.equalsIgnoreCase("")) {
			reportLog(Status.PASS, "Badge Number is Empty", true);
		}else {
			reportLog(Status.FAIL, "Badge Number is Not Empty", true);
		}
		verifyElementPresence(By.xpath("//input[@value='EDIT INFORMATION']"),"Edit Information");
		verifyElementPresence(By.xpath("//input[@value='BEGIN ORDER PROCESS']"),"begin Order Process");
		verifyElementPresence(By.xpath("//input[@value='SUBMIT BADGE PHOTO']"),"Submit Badge Photo");
		verifyElementNotPresence(By.xpath("//input[@value='SEND BADGE']"),"Send Badge");
		
		String OrderIDInprogress=driver.findElement(By.xpath("(//div[contains(.,'Order Id')]/../../../..//td)[1]")).getText();
		String OrderDateInprogress=driver.findElement(By.xpath("(//div[contains(.,'Order Id')]/../../../..//td)[2]")).getText();
		String OrderCompletedateInprogress=driver.findElement(By.xpath("(//div[contains(.,'Order Id')]/../../../..//td)[3]")).getText();
		String PackageInprogress=driver.findElement(By.xpath("(//div[contains(.,'Order Id')]/../../../..//td)[4]")).getText();
//		String ComplianceImpactInprogress=driver.findElement(By.xpath("(//div[contains(.,'Order Id')]/../../../..//td)[5]")).getText();
		String BadgeRequiredInprogress=driver.findElement(By.xpath("(//div[contains(.,'Order Id')]/../../../..//td)[5]")).getText();
		String viewReceiptInprogress=driver.findElement(By.xpath("(//div[contains(.,'Order Id')]/../../../..//td)[6]/input")).getAttribute("value");
		String OrderRefIDInprogress=driver.findElement(By.xpath("(//div[contains(.,'Order Id')]/../../../..//td)[9"
				+ "]")).getText();
		String ServiceInprogress=driver.findElement(By.xpath("(//div[contains(.,'Order Id')]/../../../..//td)[10]")).getText();
		
		String OrderStatusInprogress=driver.findElement(By.xpath("(//div[contains(.,'Order Id')]/../../../..//td)[11]")).getText();
		String CompleteDateInprogress=driver.findElement(By.xpath("(//div[contains(.,'Order Id')]/../../../..//td)[12]")).getText();
		String CaseStatusInprogress=driver.findElement(By.xpath("(//div[contains(.,'Order Id')]/../../../..//td)[13]")).getText();
		String caseScoreInprogress=driver.findElement(By.xpath("(//div[contains(.,'Order Id')]/../../../..//td)[14]")).getText();
		String ComplianceImpact2Inprogress=driver.findElement(By.xpath("(//div[contains(.,'Order Id')]/../../../..//td)[15]")).getText();
		
		if(OrderIDInprogress.isEmpty()||OrderDateInprogress.isEmpty()||OrderCompletedateInprogress.isEmpty()||PackageInprogress.isEmpty()||BadgeRequiredInprogress.isEmpty()||viewReceiptInprogress.isEmpty()||OrderRefIDInprogress.isEmpty()||ServiceInprogress.isEmpty()||OrderStatusInprogress.isEmpty()||CompleteDateInprogress.isEmpty()||CaseStatusInprogress.isEmpty()||caseScoreInprogress.isEmpty()||ComplianceImpact2Inprogress.isEmpty()) {
			reportLog(Status.FAIL, "Order History Table Contains Empty Values for Inprogress Person", true);
		}else {
			reportLog(Status.PASS, "Order History Table Doesn't Contain Empty Values for InProgress Person", true);
		}
		
		//for Need To Order
		clickElement(peopleTab, "People Tab");
		clickElement(searchPersonTab, "search person");
		EnterText(FirstNameTB, "First Name", FirstNameNeedToOrder);
		clickElement(SearchBTn, "Search");
		clickElement(By.xpath("//a[contains(.,'"+FirstNameNeedToOrder+"')]"), FirstNameNeedToOrder);
		
		String ComplianceExpiryNeedToOrder=driver.findElement(By.xpath("(//td[@class='dispLabelTextRight' and contains(.,'Compliance Expires')]/..//td[contains(.,'')])[last()]")).getText();
		verifyElementPresence(By.xpath("//td[@class='dispLabelTextRight' and contains(.,'Compliance Status')]/..//td[contains(.,'Need To Order')]"), "Compliance Status");
		String badgeNumberNeedToOrder=driver.findElement(By.xpath("(//td[@class='dispLabelTextRight' and contains(.,'Badge Number')]/..//td[contains(.,'')])[last()]")).getText();
		if(badgeNumberNeedToOrder.equalsIgnoreCase("")) {
			reportLog(Status.PASS, "Badge Number is Empty for NeedToOrder", true);
		}else {
			reportLog(Status.FAIL, "Badge Number is Not Empty for NeedToOrder", true);
		}
		if(ComplianceExpiryNeedToOrder.equalsIgnoreCase("")) {
			reportLog(Status.PASS, "Compliance Expiry is Empty for NeedToOrder", true);
		}else {
			reportLog(Status.FAIL, "Compliance Expiry is Not Empty for NeedToOrder", true);
		}
		verifyElementPresence(By.xpath("//input[@value='EDIT INFORMATION']"),"Edit Information");
		verifyElementPresence(By.xpath("//input[@value='BEGIN ORDER PROCESS']"),"begin Order Process");
		verifyElementPresence(By.xpath("//input[@value='SUBMIT BADGE PHOTO']"),"Submit Badge Photo");
		verifyElementNotPresence(By.xpath("//input[@value='SEND BADGE']"),"Send Badge");
		
		//for Compliant record
		clickElement(peopleTab, "People Tab");
		clickElement(searchPersonTab, "search person");
		EnterText(FirstNameTB, "First Name", FirstNameCompliant);
		clickElement(SearchBTn, "Search");
		clickElement(By.xpath("//a[contains(.,'"+FirstNameCompliant+"')]"), FirstNameCompliant);
		
		verifyElementPresence(By.xpath("//td[@class='dispLabelTextRight' and contains(.,'Compliance Expires')]/..//td[contains(.,'06/11/2022')]"),"Compliance Expiry");
		verifyElementPresence(By.xpath("//td[@class='dispLabelTextRight' and contains(.,'Compliance Status')]/..//td[contains(.,'Compliant')]"), "Compliance Status");
		verifyElementPresence(By.xpath("//td[@class='dispLabelTextRight' and contains(.,'Badge Number')]/..//td[contains(.,'23598D0121')]"), "Badge Number");
		verifyElementPresence(By.xpath("//input[@value='EDIT INFORMATION']"),"Edit Information");
		verifyElementPresence(By.xpath("//input[@value='BEGIN ORDER PROCESS']"),"begin Order Process");
		verifyElementPresence(By.xpath("//input[@value='SUBMIT BADGE PHOTO']"),"Submit Badge Photo");
		verifyElementPresence(By.xpath("//input[@value='SEND BADGE']"),"Send Badge");
		
		String OrderIDNeedToOrder=driver.findElement(By.xpath("(//div[contains(.,'Order Id')]/../../../..//td)[1]")).getText();
		String OrderDateNeedToOrder=driver.findElement(By.xpath("(//div[contains(.,'Order Id')]/../../../..//td)[2]")).getText();
		String OrderCompletedateNeedToOrder=driver.findElement(By.xpath("(//div[contains(.,'Order Id')]/../../../..//td)[3]")).getText();
		String PackageNeedToOrder=driver.findElement(By.xpath("(//div[contains(.,'Order Id')]/../../../..//td)[4]")).getText();
//		String ComplianceImpactNeedToOrder=driver.findElement(By.xpath("(//div[contains(.,'Order Id')]/../../../..//td)[5]")).getText();
		String BadgeRequiredNeedToOrder=driver.findElement(By.xpath("(//div[contains(.,'Order Id')]/../../../..//td)[5]")).getText();
		String viewReceiptNeedToOrder=driver.findElement(By.xpath("(//div[contains(.,'Order Id')]/../../../..//td)[6]/input")).getAttribute("value");
		String OrderRefIDNeedToOrder=driver.findElement(By.xpath("(//div[contains(.,'Order Id')]/../../../..//td)[9]")).getText();
		String ServiceNeedToOrder=driver.findElement(By.xpath("(//div[contains(.,'Order Id')]/../../../..//td)[10]")).getText();
		String OrderStatusNeedToOrder=driver.findElement(By.xpath("(//div[contains(.,'Order Id')]/../../../..//td)[11]")).getText();
		String CompleteDateNeedToOrder=driver.findElement(By.xpath("(//div[contains(.,'Order Id')]/../../../..//td)[12]")).getText();
		String CaseStatusNeedToOrder=driver.findElement(By.xpath("(//div[contains(.,'Order Id')]/../../../..//td)[13]")).getText();
		String caseScoreNeedToOrder=driver.findElement(By.xpath("(//div[contains(.,'Order Id')]/../../../..//td)[14]")).getText();
		String ComplianceImpact2NeedToOrder=driver.findElement(By.xpath("(//div[contains(.,'Order Id')]/../../../..//td)[15]")).getText();
		
		if(OrderIDNeedToOrder.isEmpty()||OrderDateNeedToOrder.isEmpty()||OrderCompletedateNeedToOrder.isEmpty()||PackageNeedToOrder.isEmpty()||BadgeRequiredNeedToOrder.isEmpty()||viewReceiptNeedToOrder.isEmpty()||OrderRefIDNeedToOrder.isEmpty()||ServiceNeedToOrder.isEmpty()||OrderStatusNeedToOrder.isEmpty()||CompleteDateNeedToOrder.isEmpty()||CaseStatusNeedToOrder.isEmpty()||caseScoreNeedToOrder.isEmpty()||ComplianceImpact2NeedToOrder.isEmpty()) {
			reportLog(Status.FAIL, "Order History Table Contains Empty Values for Compliant Person", true);
		}else {
			reportLog(Status.PASS, "Order History Table Doesn't Contain Empty Values for Compliant Person", true);
		}
		
		for(int i=1;i<=8;i++) {
			String value=driver.findElement(By.xpath("(//div[contains(.,'Badge Order')]//td)["+i+"]")).getText();
			if(value.isEmpty()) {
				reportLog(Status.FAIL, "Badge History Table contains Empty Values", true);
				break;
			}
		}
		
		String viewReceipt=driver.findElement(By.xpath("(//div[contains(.,'Badge Order')]//td)[9]/input")).getAttribute("value");
		if(viewReceipt.isEmpty()) {
			reportLog(Status.FAIL, "view receipt button is not present", true);
		}else {
			reportLog(Status.PASS, "view receipt button is present", true);
		}
		for(int i=10;i<=17;i++) {
			String value=driver.findElement(By.xpath("(//div[contains(.,'Badge Order')]//td)["+i+"]")).getText();
			if(value.isEmpty()) {
				reportLog(Status.FAIL, "Badge History Table contains Empty Values", true);
				break;
			}
		}
	}
}
