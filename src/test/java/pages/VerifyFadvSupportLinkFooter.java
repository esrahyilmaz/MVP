package pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import seleniumhelper.BaseClass;

public class VerifyFadvSupportLinkFooter extends BaseClass {
	
	By SupportFadvLink = By.xpath("//a[@href='https://fad.com/']");
public void VerifySupportFadvLink() {
	
			if(verifyElementPresence(SupportFadvLink)) {
				clickElement(SupportFadvLink,  "element click");
				reportLog(Status.PASS, "First Advantage Support Link is present", false);
			}else {
				reportLog(Status.FAIL, "First Advantage Support Link is not present", false);
			}

}
}
