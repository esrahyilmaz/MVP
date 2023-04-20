package pages;

import org.openqa.selenium.By;
import seleniumhelper.BaseClass;

public class PaymentPageLockheadMartin extends BaseClass{

	private By PaymentMehodDD=By.xpath("//select[@name='transactionType']");
	private By CardTypeDD=By.xpath("//select[@name='cardType']");
	private By CardNumberTB=By.xpath("//input[@name='cardNumber']");
	private By cseNumberTB=By.xpath("//input[@name='cscNumber']");
	private By ExpirationMonthDD=By.xpath("//select[@name='cardExpirationMonth']");
	private By ExpirationYearDD=By.xpath("//select[@name='cardExpirationYear']");
	
	public void fillPayment(String PaymentMethod,String CardType,String cardNumber,String cseNumber,String ExpMonth,String ExpYear) {
		
		if(verifyElementPresence(PaymentMehodDD)) {
			selectDropDown(PaymentMehodDD, PaymentMethod, "Payment method");
		}
		
		if(verifyElementPresence(CardTypeDD)) {
			selectDropDown(CardTypeDD, CardType, "Card Type");
		}
		
		if(verifyElementPresence(CardNumberTB)) {
			EnterText(CardNumberTB, "CardNumber", cardNumber);
		}
		
		if(verifyElementPresence(cseNumberTB)) {
			EnterText(cseNumberTB, "cseNumberTB", cseNumber);
		}
		
		if(verifyElementPresence(ExpirationMonthDD)) {
			selectDropDown(ExpirationMonthDD, ExpMonth, "Expiration Month");
		}
		
		if(verifyElementPresence(ExpirationYearDD)) {
			selectDropDown(ExpirationYearDD, ExpYear, "Expiration Year");
		}
	}
}
