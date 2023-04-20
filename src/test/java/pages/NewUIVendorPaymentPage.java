package pages;

import Utility.ExcelReader;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import seleniumhelper.BaseClass;

public class NewUIVendorPaymentPage extends BaseClass {

	ExcelReader _dataRepo = new ExcelReader();

	By firstNameOnCard = By.xpath("//input[@id='firstName']");
	By lastNameOnCard = By.xpath("//input[@id='lastName']");
	By CreditCardNumber = By.xpath("//input[@data-xf-qa-id='CCC-INPUT-CN']");
	By ccexpireMonth = By.xpath("//select[@data-xf-qa-id='CCC-SELECT-EXP-M']");
	By ccexpireYear = By.xpath("//select[@data-xf-qa-id='CCC-SELECT-EXP-Y']");
	By paymentMethodFields= By.xpath("//*[contains (@class, 'form-control')]");
	public By CCcssNumberTxt = By.xpath("//input[@data-xf-qa-id='CCC-INPUT-CSC']");
	static String number = "4";

	public void VendorPayment() throws Exception {
		try {
			wait(3);
			EnterText(firstNameOnCard, "Card holder First Name added", Random_StringGenerator(5));
			wait(3);
			EnterText(lastNameOnCard, "Card holder Last Name added", Random_StringGenerator(5));
			wait(3);
			EnterText(CreditCardNumber, "Card Number added", _dataRepo.getData("CardNumber"));
			wait(2);
			selectDropDownByIndex(ccexpireMonth, number, "Month selected");
			wait(2);
			selectDropDownByIndex(ccexpireYear, number, "Year selected");
			wait(2);
			EnterText(CCcssNumberTxt, "Entered CSC text", _dataRepo.getData("CSC"));
			wait(3);
			logStepInfo("Payment data filled up successfully completed!!!");
			reportLog(Status.PASS, "Payment data filled up successfully completed!!!", true);

		} catch (Exception ex) {
			logStepInfo("Exception occured in processPayment():- " + ex.getMessage());
			reportLog(Status.FAIL, "Exception occured in processPayment():- " + ex.getMessage(), true);
		}
	}

	public void VendorPaymentTaxValidation() throws Exception {

		int size = driver.findElements(By.xpath("//*[@class='card-text']")).size();
		for (int i = 1; i <= size; i++) {
			String text = driver.findElement(By.xpath("(//*[@class='card-text'])[" + i + "]")).getText();
			System.out.println(text);
		}
//		     if(_dataRepo.getData("State").equalsIgnoreCase("Florida")||_dataRepo.getData("State").equalsIgnoreCase("Georgia")||_dataRepo.getData("State").equalsIgnoreCase("Georgia")) {
//		Assert.assertTrue(taxesTxt.equals("0.00"));
//		logStepInfo("Tax Validation Completed!!! Tax Value is  $0.00 for State :-"+_dataRepo.getData("State"));
//		reportLog(Status.PASS, "Tax Validation Completed!!! Tax Value is $0.00 for State :-"+_dataRepo.getData("State"), true);
//	}else {
//		//Assert.assertFalse(text.contains("0.00"));
//		logStepInfo("Tax Validation Completed!!! Tax Value is not  $0.00 for State :-"+_dataRepo.getData("State"));
//		reportLog(Status.PASS, "Tax Validation Completed!!! Tax Value is not $0.00 for State :-"+_dataRepo.getData("State"), true);
//		
//	}
//	
		try {
			int size2 = driver.findElements(By.xpath("(//*[@class='text-primary'])[3]")).size();
			for (int a = 1; a <= size2; a++) {
				String OderTotal = driver.findElement(By.xpath("(//*[@class='text-primary'])[3][" + a + "]")).getText();
				System.out.println(OderTotal);
				logStepInfo("Tax Amount Validated!!!");
			}
		} catch (Exception ex) {
			logStepInfo("Tax Validation Failed!!! " + ex.getMessage());
			reportLog(Status.FAIL, "Tax Validation Failed!!! - " + ex.getMessage(), true);
		}

		try {
			int size3 = driver.findElements(By.xpath("//*[@class='text-secondary']")).size();
			for (int b = 1; b <= size3; b++) {
				String WarningMessa = driver.findElement(By.xpath("//*[@class='text-secondary'][" + b + "]")).getText();
				System.out.println(WarningMessa);
				logStepInfo("Warning Message: ");
			}
		} catch (Exception ex) {
			logStepInfo("Warning Message Not Displaying!!! " + ex.getMessage());
			reportLog(Status.FAIL, "Warning Message Not Displaying!!! - " + ex.getMessage(), true);

		}
		try {
			int size4 = driver.findElements(By.xpath("(//*[@class='d-flex warning-subtext text-center'])")).size();
			for (int b = 1; b <= size4; b++) {
				String WarningMessa2 = driver
						.findElement(By.xpath("(//*[@class='d-flex warning-subtext text-center'])[" + b + "]"))
						.getText();
				System.out.println(WarningMessa2);
				logStepInfo("Warning Message2: ");
			}
		} catch (Exception ex) {
			logStepInfo("Warning Message Not Displaying!!! " + ex.getMessage());
			reportLog(Status.FAIL, "Warning Message Not Displaying!!! - " + ex.getMessage(), true);

		}
	}

}
