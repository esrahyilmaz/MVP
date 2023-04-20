package pages;

import org.openqa.selenium.By;
import seleniumhelper.BaseClass;

public class NUIXtdConnect extends BaseClass {
	
	
	public By OptOutOff = By.xpath("//div[@class='btn-switch']"); ////span[@class='switch-label-default'  and contains(text(), 'Off')]
	public By OptOutON = By.xpath("//span[@class='switch-label-checked'  and contains(text(), 'On')]");
	
	By NextBtnOnXtdConnect = By.xpath("//button[@data-xf-qa-id='VW-POPI-BTN-NEXT']");
	By CancelBtnOnXtdConnect = By.xpath("//button[@data-xf-qa-id='VW-POPI-BTN-CANCEL']");
	
	By xtdFirstName = By.xpath("//input[@data-xf-qa-id='VW-XTDC-FMN' and @placeholder='First Name *']");
	By xtdLastName = By.xpath("//input[@data-xf-qa-id='VW-XTDC-FMN' and @placeholder='Last Name *']");
	By xtdDocumentNumber = By.xpath("//input[@data-xf-qa-id='VW-XTDC-SSN']");
	public By xtdCalanderIcon = By.cssSelector(".date-picker__calendar-icon");
	By dobw = By.xpath("//fadv-date-picker[@data-xf-qa-id='VW-XTDC-DOB']");
	
	By xtdConnectConsenttickbox = By.xpath("//input[@id='xtdConnectConsent']");
	public By xtdConnectADDBtn = By.xpath("//button[normalize-space()='Connect']");
	public By OrderBtn = By.xpath("//button[@data-xf-qa-id='VW-POPI-BTN-ORDER']");
    By xtdConnectBanner = By.xpath("//*[@class='form-body w-100 ng-star-inserted' and //div[@class = 'p-2 align-self-center mr-auto xtdConnect-header-img']]");
	
	public By xtdConnectsuccessMessage = By.xpath("//div[@class='toast-body ng-tns-c377-1']//p[@class='ng-tns-c377-1']");
	
	public By XtdConnectLogoOnPeoplePage =  By.xpath("//tr[@id='panel-0']//td[@data-label='Compliance Status']//div[@class='badge badge-pill xtd-connect-badge']");
	By XtdConnectCloseOnModal =  By.xpath("//tr[@id='panel-0']//td[@data-label='Compliance Status']//div[@class='badge badge-pill xtd-connect-badge']");

	By firstNameOnPS = By.xpath("//fadv-input[@data-xf-qa-id='VW-POPI-LFN']");
    By lastNameOnPS = By.xpath("//fadv-input[@data-xf-qa-id='VW-POPI-LLN']");

	
	By CutomerOrderSelectOption=By.xpath("//button[@id='order-btn']");
	
	
}
