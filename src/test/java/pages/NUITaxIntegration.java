package pages;

import Utility.ExcelReader;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;
import seleniumhelper.BaseClass;

public class NUITaxIntegration extends BaseClass {

	ExcelReader _dataRepo = new ExcelReader();

	By subtotalAmount = By.xpath("//h6[contains(text(),'Subtotal')]");
	By taxAmount = By.xpath("(//*[contains(text(), 'Tax')])[1]");
	By orderTotalAmount = By.xpath("//h6[contains(text(),'Order Total')]");

	public void TaxIntegrationYes() throws Exception {
//		String SponsorLvl = _dataRepo.getData("Sponsorlvl");
//		String VendorLvl = _dataRepo.getData("Vendorlvl");

//		if ((((SponsorLvl.equalsIgnoreCase("Sponsor Invoice")) && ((VendorLvl.equalsIgnoreCase("Null")) || (VendorLvl.equalsIgnoreCase("Sponsor Invoice")) || (VendorLvl.equalsIgnoreCase("")))) || ((VendorLvl.equalsIgnoreCase("Sponsor Invoice")))))
		try {
			if ((((propertyValueAT.equalsIgnoreCase("Sponsor Invoice")) && ((propertyValuePM.equalsIgnoreCase("Null")) || (propertyValuePM.equalsIgnoreCase("Sponsor Invoice")) || (propertyValuePM.equalsIgnoreCase("")))) || ((propertyValuePM.equalsIgnoreCase("Sponsor Invoice"))))) {
				// verify tax amount isn't displayed
				verifyElementNotPresence(taxAmount);
				logStepInfo("Tax isn't displayed");
				reportLog(Status.PASS, "Tax isn't displayed", false);
			}

			else {
				wait(1);
				String tax = driver.findElement(taxAmount).getText().replace("Tax: $", "");
				System.out.println("Order Tax is ::" + tax);

//				if (_dataRepo.getData("TaxState").equalsIgnoreCase("Yes")) {
				if (taxableState.equalsIgnoreCase("taxable")) {	

					// verify tax amount > 0.00
					Assert.assertFalse(tax.equals("0.00"));
					logStepInfo("Tax Validation Completed! Tax Value is not $0.00");
					reportLog(Status.PASS, "Tax Validation Completed! Tax Value is not $0.00", false);
				}

				else {
					// verify tax amount = 0.00
					Assert.assertTrue(tax.equals("0.00"));
					logStepInfo("Tax Validation Completed! Tax Value is  $0.00");
					reportLog(Status.PASS, "Tax Validation Completed! Tax Value is $0.00", false);
				}
			}
		} catch (Exception e) {
			logStepInfo("Expected Element is not present, Error- " + e.getMessage());
			reportLog(Status.FAIL, "Failed in this Step more details:- " + e.getMessage(), false);
		}
	}

	public void TaxIntegrationNo() throws Exception {
//		String SponsorLvl = _dataRepo.getData("Sponsorlvl");
//		String VendorLvl = _dataRepo.getData("Vendorlvl");

//		if (((SponsorLvl.equalsIgnoreCase("Sponsor Invoice")) && ((VendorLvl.equalsIgnoreCase("Null")) | (VendorLvl.equalsIgnoreCase("Sponsor Invoice")) | (VendorLvl.equalsIgnoreCase("")))) | ((VendorLvl.equalsIgnoreCase("Sponsor Invoice")))) 
		try {
			if ((((propertyValueAT.equalsIgnoreCase("Sponsor Invoice")) && ((propertyValuePM.equalsIgnoreCase("Null")) || (propertyValuePM.equalsIgnoreCase("Sponsor Invoice")) || (propertyValuePM.equalsIgnoreCase("")))) || ((propertyValuePM.equalsIgnoreCase("Sponsor Invoice"))))) {
				// verify tax amount isn't displayed
				verifyElementNotPresence(By.xpath("//*[@class = 'summary-card ng-tns-c101-1']"));
				logStepInfo("Tax isn't displayed");
				reportLog(Status.PASS, "Tax isn't displayed", false);
			}

			else {
				wait(1);
				String tax = driver.findElement(taxAmount).getText().replace("Tax: $", "");
				System.out.println("Order Tax is ::" + tax);
				// verify tax amount = 0.00
				Assert.assertTrue(tax.equals("0.00"));
				logStepInfo("Tax Validation Completed! Tax Value is  $0.00");
				reportLog(Status.PASS, "Tax Validation Completed! Tax Value is $0.00", false);
			}

		} catch (Exception e) {
			logStepInfo("Expected Element is not present, Error- " + e.getMessage());
			reportLog(Status.FAIL, "Failed in this Step more details:- " + e.getMessage(), false);
		}
	}
}