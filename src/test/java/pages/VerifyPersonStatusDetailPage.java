package pages;

import Utility.CurrentDateTime;
import Utility.ExcelReader;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import seleniumhelper.BaseClass;

public class VerifyPersonStatusDetailPage extends BaseClass{

	ExcelReader _dataRepo=new ExcelReader();
	
	public void verify() throws Exception {
		
		String ssn="XXXXX"+SSN.substring(5);
		String Date=CurrentDateTime.SystemDateMMDD();


		if ((scenarioName.contains("PA")) ||(scenarioName.contains("BGD"))) {
			String dob1=paDOB.substring(0, 3);
			String dob2=paDOB.substring(3, 6);
			String dob3="XXXX";
			String paCityUpper=paCity.toUpperCase();
			
			if(verifyElementPresence(By.xpath("(//*[contains(.,'"+ existingFirstName +"')])[last()-1]"))) {
				reportLog(Status.PASS, "FirstName Present "+ existingFirstName, false);
			}else {
				reportLog(Status.FAIL, "FirstName not Present "+ existingFirstName, false);
			}
			
			if(verifyElementPresence(By.xpath("(//*[contains(.,'"+existingLastName+"')])[last()]"))) {
				reportLog(Status.PASS, "LastName Present "+existingLastName, false);
			}else {
				reportLog(Status.FAIL, "LastName not Present "+existingLastName, false);
			}
			
			if(verifyElementPresence(By.xpath("(//*[contains(.,'"+ssn+"')])[last()]"))) {
				reportLog(Status.PASS, "SSN Present "+ssn, false);
			}else {
				reportLog(Status.FAIL, "SSN not Present "+ssn, false);
			}
			
			if(verifyElementPresence(By.xpath("(//*[contains(.,'"+dob2+dob1+dob3+"')])[last()]"))) {
				reportLog(Status.PASS, "DOB Present "+paDOB, false);
			}else {
				reportLog(Status.FAIL, "DOB not Present "+paDOB, false);
			}
			
			if(verifyElementPresence(By.xpath("(//*[contains(.,'"+EmailID+"')])[last()]"))) {
				reportLog(Status.PASS, "Email Id Present "+EmailID, false);
			}else {
				reportLog(Status.FAIL, "Email Id not Present "+EmailID, false);
			}
			
			if(verifyElementPresence(By.xpath("(//*[contains(.,'"+OrderRefID+"')])[last()]"))) {
				reportLog(Status.PASS, "Order reference id Present "+OrderRefID, false);
			}else {
				reportLog(Status.FAIL, "Order reference id not Present "+OrderRefID, false);
			}
			
//			if(verifyElementPresence(By.xpath("(//td[contains(.,'"+Date+"')])[3]"))) {
//				reportLog(Status.PASS, "Order Complete Date Present "+Date, false);
//			}else {
//				reportLog(Status.FAIL, "Order Complete not Present "+Date, false);
//			}
			
			if(verifyElementPresence(By.xpath("(//td[contains(.,'"+Date+"')])[2]"))) {
				reportLog(Status.PASS, "Order Date Present "+Date, false);
			}else {
				reportLog(Status.FAIL, "Order Date not Present "+Date, false);
			}
			
			if(verifyElementPresence(By.xpath("(//*[contains(.,'"+paAddress1+"')])[last()]"))) {
				reportLog(Status.PASS, "Address 1 Present "+paAddress1, false);
			}else {
				reportLog(Status.FAIL, "Address 1 not Present "+paAddress1, false);
			}
			
			if (scenarioName.contains("BGD")) {
				verifyElementPresence(By.xpath("(//*[contains(.,'"+paCity+"')])[last()]"));
				reportLog(Status.PASS, "City Present "+paCity, false);
			}else if(verifyElementPresence(By.xpath("(//*[contains(.,'"+paCityUpper+"')])[last()]"))) {
				reportLog(Status.PASS, "City Present "+paCity, false);
			}else {
				reportLog(Status.FAIL, "City not Present "+paCity, false);
			}
			
			if ((scenarioName.contains("BGD"))) {
				String stateUi=_dataRepo.getData("State");
				verifyElementPresence(By.xpath("(//*[contains(.,'"+stateUi+"')])[last()]"));
				reportLog(Status.PASS, "State "+paState+" : "+stateUi, false);
			}else if(verifyElementPresence(By.xpath("(//*[contains(.,'"+paState+"')])[last()]"))) {
				reportLog(Status.PASS, "State "+paState, false);
			}else {
				reportLog(Status.FAIL, "State not Present "+paState, false);
			}
			
			if(verifyElementPresence(By.xpath("(//*[contains(.,'"+countryPA+"')])[last()]"))) {
				reportLog(Status.PASS, "Country Present "+countryPA, false);
			}else {
				reportLog(Status.FAIL, "Country not Present "+countryPA, false);
			}
			
			if(verifyElementPresence(By.xpath("(//*[contains(.,'"+paZipCode+"')])[last()]"))) {
				reportLog(Status.PASS, "ZipCode Present "+paZipCode, false);
			}else {
				reportLog(Status.FAIL, "ZipCode not Present "+paZipCode, false);
			}
		} else {
			
			if(verifyElementPresence(By.xpath("(//*[contains(.,'"+ existingFirstName +"')])[last()-1]"))) {
				reportLog(Status.PASS, "FirstName Present "+ existingFirstName, false);
			}else {
				reportLog(Status.FAIL, "FirstName not Present "+ existingFirstName, false);
			}
			
			if(verifyElementPresence(By.xpath("(//*[contains(.,'"+existingLastName+"')])[last()]"))) {
				reportLog(Status.PASS, "LastName Present "+existingLastName, false);
			}else {
				reportLog(Status.FAIL, "LastName not Present "+existingLastName, false);
			}
			
			if(verifyElementPresence(By.xpath("(//*[contains(.,'"+ssn+"')])[last()]"))) {
				reportLog(Status.PASS, "SSN Present "+ssn, false);
			}else {
				reportLog(Status.FAIL, "SSN not Present "+ssn, false);
			}
			
			if(verifyElementPresence(By.xpath("(//*[contains(.,'"+OrderRefID+"')])[last()]"))) {
				reportLog(Status.PASS, "Order reference id Present "+OrderRefID, false);
			}else {
				reportLog(Status.FAIL, "Order reference id not Present "+OrderRefID, false);
			}
			
			if (scenarioName.contains("select")&& scenarioName.contains("SmokeSuite")) {
				if(verifyElementPresence(By.xpath("(//td[contains(.,' ')])[89]"))) {
					reportLog(Status.PASS, "Order Complete Date Present "+"Blank", false);
				}else {
					reportLog(Status.FAIL, "Order Complete not Present "+"Blank", false);
				}
			}else {
				if(verifyElementPresence(By.xpath("(//td[contains(.,'"+Date+"')])[3]"))) {
					reportLog(Status.PASS, "Order Complete Date Present "+Date, false);
				}else {
					reportLog(Status.FAIL, "Order Complete not Present "+Date, false);
				}
			}
			
			
			if(verifyElementPresence(By.xpath("(//td[contains(.,'"+Date+"')])[2]"))) {
				reportLog(Status.PASS, "Order Date Present "+Date, false);
			}else {
				reportLog(Status.FAIL, "Order Date not Present "+Date, false);
			}
			
		}
		
	}
}
