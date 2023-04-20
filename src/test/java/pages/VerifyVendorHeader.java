package pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import seleniumhelper.BaseClass;

public class VerifyVendorHeader extends BaseClass{
	
	By ImageLogo = By.xpath("//img[@id='brand-image']");
	By PhoneNuumber=By.xpath("ml-1");
	By Email=By.xpath("//a[@class='ml-1']");
	By congratulateLogo=By.xpath("//img[@src='/assets/onboarding/party.png']");
	By accountactivatedLogo=By.xpath("//img[@src='/assets/onboarding/acount-activate-icon.png']");
	By emailCommunicationLogo=By.xpath("//img[@src='/assets/onboarding/detail-activate-icon.png']");
	public void VerifyVendorLogo() {
		
		try {
			if(verifyElementPresence(ImageLogo));

			logStepInfo("Vendor logo is displayed!");
			reportLog(Status.PASS,"Vendor logo is displayed!!", true);
		}
		catch(Exception ex)
		{
			logStepInfo("Exception occured in VerifyVendorHeader():- "+ex.getMessage());
			reportLog(Status.FAIL,"Exception occured in VerifyVendorHeader():- "+ex.getMessage(), true);
		}
		}

		public void VerifyCustomerNumber() {
			try {
			if(verifyElementPresence(PhoneNuumber)) {
			logStepInfo("Vendor Number is displayed!");
			reportLog(Status.PASS,"Vendor number is displayed!!", true);
			}
		}
		catch(Exception ex)
		{
			logStepInfo("Exception occured in VerifyVendorHeader():- "+ex.getMessage());
			reportLog(Status.FAIL,"Exception occured in VerifyVendorHeader():- "+ex.getMessage(), true);
		}
		}
		public void VerifyCustomerEmail() {
			try {
			verifyElementPresence(Email);
			logStepInfo("Vendor Email is displayed!");
			reportLog(Status.PASS,"Vendor Email is displayed!!", true);
		}
		catch(Exception ex)
		{
			logStepInfo("Exception occured in VerifyVendorHeader():- "+ex.getMessage());
			reportLog(Status.FAIL,"Exception occured in VerifyVendorHeader():- "+ex.getMessage(), true);
		}
		}
		public void CongratulationsLogo() {
			
			try {
				if(verifyElementPresence(congratulateLogo));
				logStepInfo("Vendor logo is displayed!");
				reportLog(Status.PASS,"Vendor logo is displayed!!", true);
			}
			catch(Exception ex)
			{
				logStepInfo("Exception occured in VerifyVendorHeader():- "+ex.getMessage());
				reportLog(Status.FAIL,"Exception occured in VerifyVendorHeader():- "+ex.getMessage(), true);
			}
			
			}
public void accountactivatedLogo() {
			
			try {
				if(verifyElementPresence(accountactivatedLogo));
				logStepInfo("Vendor logo is displayed!");
				reportLog(Status.PASS,"Vendor logo is displayed!!", true);
			}
			catch(Exception ex)
			{
				logStepInfo("Exception occured in VerifyVendorHeader():- "+ex.getMessage());
				reportLog(Status.FAIL,"Exception occured in VerifyVendorHeader():- "+ex.getMessage(), true);
			}
			
			}
public void EmailCommunicationLogo() {
	
	try {
		if(verifyElementPresence(emailCommunicationLogo));
		logStepInfo("Vendor logo is displayed!");
		reportLog(Status.PASS,"Vendor logo is displayed!!", true);
	}
	catch(Exception ex)
	{
		logStepInfo("Exception occured in VerifyVendorHeader():- "+ex.getMessage());
		reportLog(Status.FAIL,"Exception occured in VerifyVendorHeader():- "+ex.getMessage(), true);
	}
	
	}
}