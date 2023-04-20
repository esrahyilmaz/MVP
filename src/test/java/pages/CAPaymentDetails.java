package pages;

import Utility.ExcelReader;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import seleniumhelper.BaseClass;

public class CAPaymentDetails extends BaseClass {
	ExcelReader _dataRepo = new ExcelReader();

	By paymentTitle = By.xpath("/html/body/table/tbody/tr/td/form/table/tbody/tr[1]/td/div/b");
	By orderBtn = By.xpath("//*[@id='OrderBtn']");
	By paymentDdl = By.xpath("//*[@id='transactionType']");
	By CreditCard=By.xpath("//input[@value='Credit Card']");
	By invoiceCodeTxt = By.xpath("(//*[@name='invoiceCode'])[last()]");
	By InvoiceSelected=By.xpath("//input[@name='invoiceCode' and @disabled='disabled']");
	By CreditCardSelected=By.xpath("//input[@name='invoiceCode' and @disabled='disabled' and @value='Credit Card']");
	
	By cardTypeDdl = By.xpath("//select[@name='accountType']");
	By cardNumberTxt = By.xpath("//*[@id=\"div_credit\"]/table/tbody/tr[2]/td[2]/input");
	By cssNumberTxt = By.xpath("//*[@id=\"div_credit\"]/table/tbody/tr[3]/td[2]/input");
	By expireMonthDdl = By.xpath("//*[@id=\"div_credit\"]/table/tbody/tr[5]/td[2]/select[1]");
	By expireYearDdl = By.xpath("//*[@id=\"div_credit\"]/table/tbody/tr[5]/td[2]/select[2]");
	By reuseCreditCard = By.xpath("//*[@id=\"div_credit\"]/table/tbody/tr[6]/td[2]/select");

	By cardTypeDdlVR = By.xpath("//select[@name='cardType']");
	By cardNumberTxtVR = By.xpath("//input[@name='cardNumber']");
	By cssNumberTxtVR = By.xpath("//input[@name='cscNumber']");
	By expireMonthDdlVR = By.xpath("//select[@name='cardExpirationMonth']");
	By expireYearDdlVR = By.xpath("//select[@name='cardExpirationYear']");
	
	
	By checkoutBtn = By.xpath("//*[@id='checkoutBtn']");
	By continueOrderingBtn = By.xpath("//*[@id='continueLnk']");
	By removeBtn = By.xpath("//*[@id=\"scRemove_\"]/img");
	By orderSlNoLbl = By.xpath("//*[@id='mainBody']/div[3]/div/div[2]/div[1]");
	By cartMessageLbl = By.xpath("//*[contains(text(),\"It looks like your cart is empty.\")]");
	By messageLbl=By.xpath("//*[@class='caption caption-danger']");
	static String number="4";
	
	public void processPayment() throws Exception {
		try {
			
		String PaymentType=_dataRepo.getData("PaymentMethod");
		System.out.println("Payment method is ::"+PaymentType);
		if(_dataRepo.getData("PaymentMethod").equalsIgnoreCase("")){
			PaymentType="Credit Card";
		}
		/*	if(driver.findElement(cardTypeDdl).isDisplayed()) {
				selectDropDown(paymentDdl, "Credit Card", "Select credit Card from Drop down");
			}
			else {
				System.out.println("Drop down is not present!!!!!");
			}*/
			if (PaymentType.equalsIgnoreCase("Credit Card")||PaymentType.equalsIgnoreCase("")) {
				if(verifyElementPresence(paymentDdl)) {
					selectDropDown(paymentDdl, "Credit Card", "Select credit Card from Drop down");
					
				}
				//if(!(verifyElementPresence(CreditCard))) {
					selectDropDown(cardTypeDdl, _dataRepo.getData("CardType"), "card Type selected from Drop down");
				//}
							EnterText(cardNumberTxt, "card number added", _dataRepo.getData("CardNumber"));
							wait(2);
							EnterText(cssNumberTxt, "Entered CSC text", Random_NumberGenerator(3));
							wait(3);
							selectDropDownByIndex(expireMonthDdl,number,"Selected Expiry Month from the drop down");
							wait(2);
							selectDropDownByIndex(expireYearDdl,number,"Selected Expiry Year from the drop down");
							wait(2);
							selectDropDown(reuseCreditCard, _dataRepo.getData("reUseCreditCard"), "select From the drop down");
						} else if(PaymentType.equalsIgnoreCase("Invoice Code")) {
							if(scenarioName.contains("-HD-")) {
								selectDropDown(paymentDdl, "Invoice", "Select Invoice code from Drop down");
							}else {
								selectDropDown(paymentDdl, "Invoice Code", "Select Invoice code from Drop down");
							}
							if(verifyElementPresence(invoiceCodeTxt)) {
								EnterText(invoiceCodeTxt, "Invoice code entered", _dataRepo.getData("InvoiceCode"));
							}							
						}
					else {
						System.out.println("Please enter Correct Payment Method!!!!");
					}
				logStepInfo("Payment data filled up successfully completed!!!");
				reportLog(Status.PASS,"Payment data filled up successfully completed!!!", true);

				}
				catch(Exception ex)
				{
					logStepInfo("Exception occured in processPayment():- "+ex.getMessage());
					reportLog(Status.FAIL,"Exception occured in processPayment():- "+ex.getMessage(), true);
				}

	}
	
	public void processPaymentValidation(String PaymentType) throws Exception {
		try {
			
		System.out.println("Payment method is ::"+PaymentType);
		if(_dataRepo.getData("PaymentMethod").equalsIgnoreCase("")){
			PaymentType="Credit Card";
		}
		
			if (PaymentType.equalsIgnoreCase("Credit Card")&&!(scenarioName.contains("Vendor Registration"))) {
				if(verifyElementPresence(CreditCardSelected)) {
					reportLog(Status.PASS, "Credit Card is present", true);
				}else {
					reportLog(Status.FAIL, "Credit Card is not present", true);
				}
					selectDropDown(cardTypeDdl, _dataRepo.getData("CardType"), "card Type selected from Drop down");
					
							EnterText(cardNumberTxt, "card number added", _dataRepo.getData("CardNumber"));
							EnterText(cssNumberTxt, "Entered CSC text", Random_NumberGenerator(3));
							selectDropDownByIndex(expireMonthDdl,number,"Selected Expiry Month from the drop down");
							selectDropDownByIndex(expireYearDdl,number,"Selected Expiry Year from the drop down");
							selectDropDown(reuseCreditCard, _dataRepo.getData("reUseCreditCard"), "select From the drop down");
						} else if(PaymentType.contains("Invoice")&&!(scenarioName.contains("Vendor Registration"))) {
							if(verifyElementPresence(InvoiceSelected)) {
								reportLog(Status.PASS, "Invoice is present", true);
							}else {
								reportLog(Status.FAIL, "Invoice is not present", true);
							}
							if(verifyElementPresence(invoiceCodeTxt) && scenarioName.contains("NONHD")) {
								EnterText(invoiceCodeTxt, "Invoice code entered",  _dataRepo.getData("InvoiceCode"));
							}						
						}else if (PaymentType.equalsIgnoreCase("Credit Card")&& scenarioName.contains("Vendor Registration")) {
							
										selectDropDown(cardTypeDdlVR, _dataRepo.getData("CardType"), "card Type selected from Drop down");		
										EnterText(cardNumberTxtVR, "card number added",_dataRepo.getData("CardNumber"));
										EnterText(cssNumberTxtVR, "Entered CSC text", Random_NumberGenerator(3));
										selectDropDownByIndex(expireMonthDdlVR,number,"Selected Expiry Month from the drop down");
										selectDropDownByIndex(expireYearDdlVR,number,"Selected Expiry Year from the drop down");
										}
						else if(PaymentType.equalsIgnoreCase("Sponsor Invoice")||PaymentType.equalsIgnoreCase("Vendor Invoice")&& scenarioName.contains("Vendor Registration")) {
							
							if(verifyElementPresence(invoiceCodeTxt) && scenarioName.contains("NONHD")) {
								EnterText(invoiceCodeTxt, "Invoice code entered", _dataRepo.getData("InvoiceCode"));
							}						
						}
						else {
						System.out.println("Please enter Correct Payment Method!!!!");
					}
				logStepInfo("Payment data filled up successfully completed!!!");
				reportLog(Status.PASS,"Payment data filled up successfully completed!!!", true);

				}
				catch(Exception ex)
				{
					logStepInfo("Exception occured in processPayment():- "+ex.getMessage());
					reportLog(Status.FAIL,"Exception occured in processPayment():- "+ex.getMessage(), true);
				}

	}
}
