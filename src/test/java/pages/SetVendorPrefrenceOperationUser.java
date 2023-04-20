package pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import seleniumhelper.BaseClass;

public class SetVendorPrefrenceOperationUser extends BaseClass{
	
	private static By vendorStatusDD=By.xpath("//select[@name='vendorStatus']/option[@selected='selected' and @value='ACTIVE']");
	private static By paymentMethodCreditCardDD=By.xpath("//select[@name='programPaymentMethod']/option[@value='Credit Card']");
	private static By paymentMethodSponsorInvoiceDD=By.xpath("//select[@name='programPaymentMethod']/option[@value='Sponsor Invoice']");
	private static By paymentMethodVendorInvoiceDD=By.xpath("//select[@name='programPaymentMethod']/option[@value='Vendor Invoice']");
	private static By paymentMethod=By.xpath("//select[@name='programPaymentMethod']");
	private static By UpdateBTN=By.xpath("(//input[@value='Update'])[last()]");
	
	public void setPreference(String vendor,String value) {
		
		if(verifyElementPresence(By.xpath("//a[contains(.,'"+vendor+"')]/../..//input[@value='EDIT']"))) {
			clickElement(By.xpath("//a[contains(.,'"+vendor+"')]/../..//input[@value='EDIT']"), "Edit");
		}else {
			reportLog(Status.FAIL, "EDIT Button is not present for Vendor "+vendor, true);
		}
		
		if(verifyElementPresence(vendorStatusDD)) {
			reportLog(Status.PASS, "Vendor is Active "+vendor, true);
		}else {
			reportLog(Status.FAIL, "Vendor is not Active "+vendor, true);
		}
		
		if(verifyElementPresence(paymentMethodCreditCardDD)&&verifyElementPresence(paymentMethodSponsorInvoiceDD)&&verifyElementPresence(paymentMethodVendorInvoiceDD)) {
			reportLog(Status.PASS, "Payment Methods are present for the vendor-> "+vendor, true);
		}else {
			reportLog(Status.FAIL, "Payment Methods are not present for the vendor-> "+vendor, true);
		}
		
		selectDropDown(paymentMethod, value, "Payment Mathod");
		clickElementWithWait(UpdateBTN, "Update");
	}
}
