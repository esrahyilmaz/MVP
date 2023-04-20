package pages;

import Utility.CurrentDateTime;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import seleniumhelper.BaseClass;

public class DigitalBadgePhysicalBadge extends BaseClass{

	private static By DigitalBadgeRB=By.xpath("//input[@value='Digital Badge']");
	private static By PhysicalBadgeRB=By.xpath("//input[@value='Physical Badge']");
	private static By DigitalandPhysicalRB=By.xpath("//input[@value='Physical Badge and Digital Badge']");
	private static By NextBTN=By.xpath("//input[@value='Next']");
	private static By OKBtn=By.xpath("//input[@value='OK']");
	private static By OkBtn=By.xpath("//input[@value='Ok']");
	private static By errorMsg=By.xpath("//*[@id='errorMessages']");
	private static By EmailTB=By.xpath("//input[@name='email']");
	private static By SaveBtn=By.xpath("//input[@value='SAVE']");
	
	public void selectBadge(String value) {
		
		switch(value){
		
		case "Digital Badge":
		clickElement(DigitalBadgeRB, "Digital Badge");
		clickElement(NextBTN, "Next");
		clickElement(NextBTN, "Next");
		break;
		
		case "Digital Badge-Y":
			clickElement(DigitalBadgeRB, "Digital Badge");
			clickElement(NextBTN, "Next");
			verifyTextPresence("The Digital Badge link for "+ existingFirstName +","+existingLastName+" was successfully sent.");
			verifyTextPresence("Badge Order Confirmation");
			verifyTextPresence(existingFirstName +","+existingLastName);
			verifyTextPresence("Badge Order");
			clickElement(OkBtn, "OK");
			break;
		
		case "Physical Badge":
			clickElement(PhysicalBadgeRB, "Physical Badge");
			clickElement(NextBTN, "Next");
			clickElement(NextBTN, "Next");
			break;
			
		case "DigitalPhysical Badge":
			clickElement(DigitalandPhysicalRB, "Digital and Physical Badge");
			clickElement(NextBTN, "Next");
			clickElement(NextBTN, "Next");
			break;
		}
		
	}
	
	public void verifyOrderSummary(String BadgeType,String PackagePrice,String Tax,String Total) {
		
		if(verifyElementPresence(By.xpath("//td[.='"+ existingFirstName +"']/..//td[.='"+existingLastName+"']/..//td[.='"+BadgeType+"']/..//td[contains(.,'"+PackagePrice+"')]"))) {
			reportLog(Status.PASS, "First Name : "+ existingFirstName +" Last Name : "+existingLastName+" Badge Type : "+BadgeType+" Package Price : "+PackagePrice, true);
		}else {
			reportLog(Status.FAIL, "Package Details are not matching", true);
		}
		
		if(verifyElementPresence(By.xpath("//div[.='Taxes:']/..//div[contains(.,'"+Tax+"')]"))) {
			reportLog(Status.PASS, "Expected Tax Amount is Displayed :"+Tax, true);
		}else {
			reportLog(Status.FAIL, "Tax Amount is Different", true);
		}
		
		if(verifyElementPresence(By.xpath("//div[.='Total:']/..//div[contains(.,'"+Total+"')]"))) {
			reportLog(Status.PASS, "Expected Total Amount is Displayed :"+Total, true);
		}else {
			reportLog(Status.FAIL, "Total Amount is Different", true);
		}
		
	}
	
	public void badgeOrderConfirmation(String BadgeType,String Total) throws Exception {
		
		String Date=CurrentDateTime.SystemDateMMDD();
		
		if(verifyElementPresence(By.xpath("(//div[contains(.,'Service Name:')])[last()]/..//b[.='"+BadgeType+"']"))) {
			reportLog(Status.PASS, "Service Name : "+BadgeType, true);
		}else {
			reportLog(Status.FAIL, "Service Name is Different", true);
		}
		
		if(verifyElementPresence(By.xpath("(//div[contains(.,'Order Date:')])[last()]/..//div[.='"+Date+"']"))) {
			reportLog(Status.PASS, "Order Date is : "+Date, true);
		}else {
			reportLog(Status.FAIL, "Order Date is Different", true);
		}
		
		if(verifyElementPresence(By.xpath("(//div[contains(.,'Credit Card Number:')])[last()]/..//div[.='xxxxxxxxxxxx1111']"))) {
			reportLog(Status.PASS, "Credit Card Number is Displayed and card Number is secured", true);
		}else {
			reportLog(Status.INFO, "Credit Card is not displayed", true);
		}
		
		if(verifyElementPresence(By.xpath("((//div[contains(.,'Transaction Id:')])[last()]/..//b)[3]"))) {
			TransactionID=driver.findElement(By.xpath("((//div[contains(.,'Transaction Id:')])[last()]/..//b)[3]")).getText();
			reportLog(Status.PASS, "TransactionID is "+TransactionID, true);
		}else {
			reportLog(Status.INFO, "TransactionID is not displayed", true);
		}
		
		if(verifyElementPresence(By.xpath("(//div[contains(.,'Amount Charged:')])[last()]/../..//div[contains(.,'"+Total+"')]"))) {
			reportLog(Status.PASS, "Amount Charged :"+Total, true);
		}else {
			reportLog(Status.INFO, "Amount Charged is Different", true);
		}
		clickElement(OKBtn, "OK");
	}
	
	public void updateEmail() {
		
		if(verifyElementPresence(errorMsg)) {
			reportLog(Status.PASS, "Error Message is Present", true);
		}else {
			reportLog(Status.FAIL, "Error Message is not  Present", true);
		}
		
		if(verifyElementPresence(EmailTB)) {			
			EnterText(EmailTB, "Email", EmailID);
		}
		if(verifyElementPresence(SaveBtn)) {
			clickElement(SaveBtn, "Save");
		}
	}
}
