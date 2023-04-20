package pages;

import org.openqa.selenium.By;
import seleniumhelper.BaseClass;

public class NUIPaymentMethodPage extends BaseClass {

	By paymentMethodIcon = By.xpath("//*[contains(@data-icon,'credit-card')])[last()]");
	By paymentMethodIconSection = By.xpath("//*[contains(@data-icon,'credit-card')])[last()-1]");
	
	By creditCardNumber = By.xpath("//input[@data-xf-qa-id='CCC-INPUT-CN']");
	By expiryMonthCC = By.xpath("//select[@data-xf-qa-id='CCC-SELECT-EXP-M']");
	By expiryYearCC = By.xpath("//select[@data-xf-qa-id='CCC-SELECT-EXP-Y']");
	By cSCNumber = By.xpath("//input[@data-xf-qa-id='CCC-INPUT-CSC']");
	
	By addNextButtonCC = By.xpath("//button[@class='btn btn-primary btn-order ml-1']");
	
	By nextOnPaymentButton = By.xpath("//div[contains(@class,'row footer-btn-wrapper')]/div/button[@data-xf-qa-id=\"VW-POPM-BTN-NEXT\"]");
	By submitPaymentButton = By.xpath("//button[contains(@data-xf-qa-id, 'VW-POPM-BTN-NEXT') and contains(text(), 'Submit Payment')]");
	By NextButtonOnPaymentpage= By.xpath("//button[@class='btn btn-primary btn-order ml-1']");
	By CloseButtonOnRevisedModal = By.xpath("//button[@class='btn btn-primary simple-modal-button']");
	By useNewPaymentMethod = By.xpath("//*[contains(@data-xf-qa-id,'CCP-CS-RADIO-NEW')]");

}

