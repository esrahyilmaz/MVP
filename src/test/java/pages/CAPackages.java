package pages;

import Utility.ExcelReader;
import com.aventstack.extentreports.Status;
import junit.framework.Assert;
import org.openqa.selenium.By;
import seleniumhelper.BaseClass;

public class CAPackages extends BaseClass {
	ExcelReader _dataRepo=new ExcelReader();
//package HD
	
	By beginOrderProcessBtn=By.xpath("//input[@name='orderBGC']");
	
	By lobDemoPackage_btn =By.xpath("//input[@value='4941']");//lob HD package
	By consentForm_chkbox = By.xpath("//input[@name ='agreed_4941' and @value='agreed']"); 
	By nextPackagePage_btn = By.xpath("//input[@value='Next']");
	By dlNumber = By.xpath("//input[@id='driverLicNum']");
	By dlState_dropdown = By.xpath("//select[@name='driverLicStateCd']"); 
	By nextDlPage_btn = By.xpath("//input[@value='NEXT']");
	
	//Checkout page HD

	By checkOut_btn=By.xpath("//input[@value='Checkout']");
	By continueOrdering_btn=By.xpath("//a[@id='signedNext']");
	By order_btn=By.xpath("//input[@value='Order']");
	By msgTextOrderValidate = By.xpath("//div[@id='successMessages']");
//	By beginOrderProcessBtn=By.xpath("//input[@name='orderBGC']");
//	By beginOrderProcessBtn=By.xpath("//input[@name='orderBGC']");
	
	//Methods==============================================================================================
	
	public void beginOrderProcess() {
		try {
			clickElementWithWait(beginOrderProcessBtn, "click on begin order process button");
			clickElementWithWait(lobDemoPackage_btn, "click on lob demo package");
			
			System.out.println("package============================================================");

			//if(driver.findElement(consentForm_chkbox).isDisplayed()) {
				clickElementWithWait(consentForm_chkbox, "click to provide consent");	
			//}
			System.out.println("package============================================================");
			clickElementWithWait(nextPackagePage_btn, "click on next button");
			EnterText(dlNumber, "enter dl number", _dataRepo.getData("DLNumber"));
		//	EnterText(dlState_dropdown, "select dl state", _dataRepo.getData("DLState"));
			selectDropDownByValue(dlState_dropdown, _dataRepo.getData("DLState"),"select dl state" );
			clickElementWithWait(nextDlPage_btn, "click on next button");
			clickElementWithWait(checkOut_btn, "click on checkout button");
			clickElementWithWait(order_btn, "click on order button");
			String orderPlacedText = "ORDER WAS PLACED SUCCESSFULLY";
			String orderPlacedTextPresent = driver.findElement(msgTextOrderValidate).getText();
			Assert.assertEquals(orderPlacedText, orderPlacedTextPresent);

			
			logStepInfo("Order Process successfully completed!!!");
			reportLog(Status.PASS,"Order Process successfully completed!!!", true);

			}
			catch(Exception ex)
			{
				logStepInfo("Exception occured in beginOrderProcess():- "+ex.getMessage());
				reportLog(Status.FAIL,"Exception occured in beginOrderProcess():- "+ex.getMessage(), true);
			}
	}
}
