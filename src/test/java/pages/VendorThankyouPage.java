package pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import seleniumhelper.BaseClass;

public class VendorThankyouPage extends BaseClass{

	
	private By userid=By.xpath("//span[@title='Showing Login User Id']");
	
	
	public void verifyThankyouPage(String UserID,String PrincipalFirstName,String PrincipalLastName,String CrewFirstName,String CrewLastName) {
		
		String value=null;
		
		value=UserID;
		if (!value.isEmpty()) {
			String Actual=driver.findElement(userid).getText();
			if(value.equalsIgnoreCase(Actual)) {
				reportLog(Status.PASS, "Actual UserID: "+Actual+" and Expected UserID: "+value+"", false);
			}else {
				reportLog(Status.FAIL, "Actual UserID: "+Actual+" and Expected UserID: "+value+"", false);
			}
		}
		
		value=PrincipalFirstName;
		
		if (!value.isEmpty()) {
			String principal=driver.findElement(By.xpath("//span[contains(.,'Principal Details:')]/..//td[contains(.,'"+value+"')]")).getText();
			if(principal.contains(PrincipalFirstName)) {
				reportLog(Status.PASS, "Principal first name is present", false);
			}else {
				reportLog(Status.FAIL, "Principal first name is not present", false);
			}
		}
		
		value=PrincipalLastName;
		
		if (!value.isEmpty()) {
			String principal=driver.findElement(By.xpath("//span[contains(.,'Principal Details:')]/..//td[contains(.,'"+value+"')]")).getText();
			if(principal.contains(PrincipalLastName)) {
				reportLog(Status.PASS, "Principal last name is present", false);
			}else {
				reportLog(Status.FAIL, "Principal last name is not present", false);
			}
			principal=driver.findElement(By.xpath("//span[contains(.,'Principal Details:')]/..//td[contains(.,'XXXXX')]")).getText();
			if(principal.contains("XXXXX")) {
				reportLog(Status.PASS, "Principal SSN Number is Secured", false);
			}else {
				reportLog(Status.FAIL, "Principal SSN Number is not Secured", false);
			}
			principal=driver.findElement(By.xpath("//span[contains(.,'Principal Details:')]/..//td[contains(.,'/XXXX')]")).getText();
			if(principal.contains("/XXXX")) {
				reportLog(Status.PASS, "Principal DOB is Secured", false);
			}else {
				reportLog(Status.FAIL, "Principal DOB is not Secured", false);
			}
		}
		
		
		
		value=CrewFirstName;
		if (!value.isEmpty()) {
			WebElement element=driver.findElement(By.xpath("//span[.=' Crew Details :']/..//td[contains(.,'"+CrewFirstName+"')]"));
			if(element.isDisplayed()) {
				reportLog(Status.PASS, "Crew first name is present", false);
			}else {
				reportLog(Status.FAIL, "Crew first name is not present", false);
			}
		}
		
		value=CrewLastName;
		if (!value.isEmpty()) {
			WebElement element=driver.findElement(By.xpath("//span[.=' Crew Details :']/..//td[contains(.,'"+CrewLastName+"')]"));
			if(element.isDisplayed()) {
				reportLog(Status.PASS, "Crew Last name is present", false);
			}else {
				reportLog(Status.FAIL, "Crew Last name is not present", false);
			}
			WebElement element1=driver.findElement(By.xpath("//span[.=' Crew Details :']/..//td[contains(.,'XXXXX')]"));
			if(element1.isDisplayed()) {
				reportLog(Status.PASS, "Crew SSN Number is Secured", false);
			}else {
				reportLog(Status.FAIL, "Crew SSN Number is not Secured", false);
			}
			WebElement element2=driver.findElement(By.xpath("//span[.=' Crew Details :']/..//td[contains(.,'/XXXX')]"));
			if(element2.isDisplayed()) {
				reportLog(Status.PASS, "Crew DOB is Secured", false);
			}else {
				reportLog(Status.FAIL, "Crew DOB is not Secured", false);
			}
		}
	}
}
