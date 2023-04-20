package pages;

import org.openqa.selenium.By;
import seleniumhelper.BaseClass;

public class AcceptTheForms extends BaseClass{

	private By AcceptAgreementBTN=By.xpath("//input[@name='accept']");
	private By proceedwithLoginBtn = By.xpath("//*[@id='proceed_login_divid']");
	
	public void accept() {
		
		if(verifyElementPresence(proceedwithLoginBtn)) {
			clickElement(proceedwithLoginBtn, "proceed");
		}
		
		if(verifyElementPresence(AcceptAgreementBTN)) {
			clickElement(AcceptAgreementBTN, "accept");
		}
		if(verifyElementPresence(AcceptAgreementBTN)) {
			clickElement(AcceptAgreementBTN, "accept");
		}
		
		
		
	}
}
