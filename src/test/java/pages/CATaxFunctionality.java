package pages;

import Utility.ExcelReader;
import com.aventstack.extentreports.Status;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import seleniumhelper.BaseClass;

public class CATaxFunctionality extends BaseClass {
	private static final double DELTA = 1e-15;
	CAPaymentDetails caPayment = new CAPaymentDetails();
	ExcelReader _dataRepo = new ExcelReader();
	JavascriptExecutor js = (JavascriptExecutor)driver;
	static int count=0;
		
	// Packages page
	By fingerPrintPackage = By.xpath("//*[@id='5102']");//*[@id="5102"]
	By drugPackage = By.xpath("//*[@id='5101']");
	By _30dayPackage = By.xpath("//*[@id='2621']");
	By nextPackagePage_btn = By.xpath("//*[@id='actionbutton']");
	
		// consent form checkbox in 30day package															
		By consentForm_chkbox = By.xpath("//*[@id='div_2621']/table/tbody/tr/td/input[2]");
	
	// person information page//*[@id="peopleFormTable"]/tbody/tr[2]/td/b/input
	By emailAddress = By.xpath("//*[@id='peopleFormTable']/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/input");
	By reEnterEmailAddress = By.xpath("//*[@id='peopleFormTable']/tbody/tr[2]/td/table/tbody/tr[4]/td[2]/input");
	By next_personPage_btn = By.xpath("//*[@id='peopleFormTable']/tbody/tr[2]/td/b/input");
	
	//schedule the visit
	//input[@name='FullAddress']
	By searchAddress_txt =By.xpath("//input[@name='FullAddress']");
	By searchSchedule_btn = By.xpath("//input[@value='Search']");
	By scheduleLink = By.xpath("(//a[contains(text(),'Schedule')])[1]");
	By saveSchedule_btn = By.xpath("//input[@id='SaveScheduleButton']");
	By next_schdeluePage_btn = By.xpath("//input[@name='save']");
	
	//appointment not scheduled
	By next_appointNotScheduled_btn = By.xpath("//*[@id='mainBody']/form/div[7]/b/input");
	
	//tax fields on Payments page
	By taxTextForValidate1_txt = By.xpath("//form/table/tbody/tr[9]/td/text()[3]");
	By taxTextForValidate2_txt = By.xpath("//form/table/tbody/tr[9]/td/span[@id='span_tax_details']");

	By taxValueForValidate_txt = By.xpath("//td[contains(text(),'Taxes : ')]/following-sibling::td/span");
	
	//order page
	By orderSuccessful_txt = By.xpath("//*[@id='successMessages']");
	By orderId = By.xpath("//div[contains(text(),'Contractor Advantage Order Id:')]/following-sibling::div/b");
	
	By orderTotalTxt=By.xpath("//*[contains(text(),'Order Total : ')]/following::td[1]");
	By taxesTxt=By.xpath("//*[contains(text(),'Taxes : ')]/following::td[1]");
	By totalTxt=By.xpath("//tr[@id='span_cardTotalAmount']/td[2]");
	
	String taxNotesCssPath = "table tbody tr td form table tbody tr:nth-child(11) td";
	//===========================================================================================================
	

	 public String getTextInformationfromUI(String cssPath) {
			String taxNotes= "return document.querySelector(\"table tbody tr td form table tbody tr:nth-child(11) td\").textContent";
			String infoText=null;
			JavascriptExecutor js=(JavascriptExecutor)driver;
			infoText=(String)js.executeScript(taxNotes);
			return infoText;
					}											
	
	
	public void packageFingerPrint() {
		try {
		clickElementWithWait(fingerPrintPackage, "click on finger print package");
		wait(2);
		takeScreenshot();
		clickElementWithWait(nextPackagePage_btn, "click on the next button");
		EnterText(emailAddress, "enter email address", _dataRepo.getData("email"));
		EnterText(reEnterEmailAddress, "reenter email address", _dataRepo.getData("email"));
		wait(2);
		takeScreenshot();
		clickElementWithWait(next_personPage_btn, "click on the next button");
		
		driver .switchTo().frame("schPortletFrame");
		//driver.findElement(searchAddress_txt).clear();
		//EnterText(searchAddress_txt, "provide the address to schedule collection", "Brooklyn");
		js.executeScript("arguments[0].click();", driver.findElement(searchSchedule_btn));

		clickElementWithWait(scheduleLink, "click on the first schedule link");
		//write code here
		clickElementWithWait(next_schdeluePage_btn, "click on the next button");
		clickElementWithWait(next_appointNotScheduled_btn, "click on the next button");
		reportLog(Status.PASS, "Fingerprint package selected", true);
		}
		catch(Exception e) {
		
		}
	}
	
	public void packageDrug() {
		try {
//		clickElementWithWait(drugPackage, "click on drug package");
//		wait(2);
//		takeScreenshot();
//		clickElementWithWait(nextPackagePage_btn, "click on the next button");
//		EnterText(emailAddress, "enter email address", _dataRepo.getData("email"));
//		EnterText(reEnterEmailAddress, "reenter email address", _dataRepo.getData("email"));
//		wait(2);
//		takeScreenshot();
//		clickElementWithWait(next_personPage_btn, "click on the next button");
		driver .switchTo().frame("schPortletFrame");
		driver.findElement(searchAddress_txt).clear();
		EnterText(searchAddress_txt, "provide the address to schedule collection", "Brooklyn");
		js.executeScript("arguments[0].click();", driver.findElement(searchSchedule_btn));
	//	clickElementWithWait(searchSchedule_btn, "click on the search button");
		clickElementWithWait(searchSchedule_btn, "click on the search button");
		clickElementWithWait(scheduleLink, "click on the first schedule link");
		clickElementWithWait(saveSchedule_btn, "click on the save schedule button");
		
		wait(2);
		driver.switchTo().defaultContent();
		clickElementWithWait(next_schdeluePage_btn, "click on the next button");
		clickElementWithWait(next_appointNotScheduled_btn, "click on the next button");
		reportLog(Status.PASS, "Drug package selected", true);
		}
		catch(Exception e) {
			
		}
	}
	
	

	public  void taxTextAndValueValidation() {
		try{
		String taxTextValue1 = "* If you did not (yet) pass First Advantage credentialing, you will not be able to see the detailed results.";
		String taxTextValue2 = "       * Applicable state taxes are applied in certain locations to comply with state requirements.      ";
		String taxTextPresent1 = getTextInformationfromUI(taxNotesCssPath);
		String taxTextPresent2 = driver.findElement(taxTextForValidate2_txt).getText();
		System.out.println("Tax Value Present is : \n"+taxTextPresent1+taxTextPresent2 );																						
		Assert.assertTrue(taxTextPresent1.contains(taxTextValue1));
		Assert.assertTrue(taxTextValue2.contains(taxTextPresent2));
		
		System.out.println("Tax Information is ::"+taxTextPresent1);
		System.out.println("Tax Information is ::"+taxTextPresent2);
		
		String taxValuePresent = driver.findElement(taxValueForValidate_txt).getText();
		System.out.println("Tax applied is: "+ taxValuePresent);
		if(count<2) {
			System.out.println("count of Tax present is  =  "+ count);
		Assert.assertTrue("Tax value should be given zero", taxValuePresent.contains("$ 0.00"));
		reportLog(Status.PASS, "Tax given is "+taxValuePresent, true);

/*		clickElementWithWait(caPayment.orderBtn, "click on order button");
		reportLog(Status.PASS, "Payment done by credit card", true);
		System.out.println("=============================================================================count =  "+ count);
*/
		}
		if(count>1) {
			Assert.assertTrue("Tax value should contain $ sign", taxValuePresent.contains("$"));
			Assert.assertFalse("Tax value should not be given zero", taxValuePresent.contains("$ 0.00"));
			reportLog(Status.PASS, "Tax given is "+taxValuePresent, true);
			/*clickElementWithWait(caPayment.orderBtn, "click on order button");
			reportLog(Status.PASS, "Payment done by credit card", true);
			System.out.println("=============================================================================count =  "+count);*/
			
		}
		count++;
		
		}
		catch(Exception e) {
			
		}
		
	}
	
	public void creditCardPaymentOrderConfirmation() {
		try {
		
		selectDropDownByValue(caPayment.paymentDdl, "C","click to select value");
		selectDropDownByValue(caPayment.cardTypeDdl, "Visa","click to select value");
		EnterText(caPayment.cardNumberTxt, "enter card number", _dataRepo.getData("cardNumber"));
		EnterText(caPayment.cssNumberTxt, "enter csc number", _dataRepo.getData("cscNumber"));
		selectDropDownByValue(caPayment.expireMonthDdl, "03",_dataRepo.getData("expireMonth"));
		selectDropDownByValue(caPayment.expireYearDdl, "2020",_dataRepo.getData("expireYear"));
		
		takeScreenshot();
		selectDropDownByValue(caPayment.reuseCreditCard,"N","Select to reuse card yes or no");
	
	//	taxTextAndValueValidation();// validate the tax
	//	System.out.println("+++print the tax results+++");
	//	taxTextAndValueValidation();
		System.out.println("Ist done++++++++++++++++++++++++++++++++");
	///	orderValidation();
	//	clickElementWithWait(caPayment.orderBtn, "click on order button");
		
		reportLog(Status.PASS, "Credit card payement method selected", true);		
		
	//	taxTextAndValueValidation();
		}
		catch(Exception e){
			}
		}
	
	public void orderValidation() {
		try {
			
		String orderPlaced = "ORDER WAS PLACED SUCCESSFULLY";
		String orderPlacedTextPresent = driver.findElement(orderSuccessful_txt).getText();
		Assert.assertEquals(orderPlaced, orderPlacedTextPresent);
		Assert.assertTrue("order id should be present",driver.findElement(orderId).isDisplayed() );
		System.out.println("order validation");
		reportLog(Status.PASS, "Order placed sussessfully", true);

		System.out.println("done 3rd+++++++++++++++========================");
		
		}
		catch(Exception e) {
			
		}
	}
		public void taxValidation() throws Exception {
			try {
		String []orderTotal=(driver.findElement(orderTotalTxt).getText().trim()).split(" ");
		System.out.println("Order Total is ::"+orderTotal[1]);
		String []tax=(driver.findElement(taxesTxt).getText().trim()).split(" ");
		System.out.println("Order Tax is ::"+tax[1]);
		String []total=(driver.findElement(totalTxt).getText().trim()).split(" ");
		System.out.println("Total is ::"+total[1]);
				
		double actualTotal=Double.parseDouble(total[1]);
		double expectedTotal = Double.parseDouble(orderTotal[1])+Double.parseDouble(tax[1]);
					
		if(_dataRepo.getData("State").equalsIgnoreCase("Florida")||_dataRepo.getData("State").equalsIgnoreCase("Georgia")||_dataRepo.getData("State").equalsIgnoreCase("Georgia")) {
			Assert.assertTrue(tax[1].equals("0.00"));
			logStepInfo("Tax Validation Completed!!! Tax Value is  $0.00 for State :-"+_dataRepo.getData("State"));
			reportLog(Status.PASS, "Tax Validation Completed!!! Tax Value is $0.00 for State :-"+_dataRepo.getData("State"), true);
		}else {
			Assert.assertFalse(tax[1].contains("0.00"));
			logStepInfo("Tax Validation Completed!!! Tax Value is not  $0.00 for State :-"+_dataRepo.getData("State"));
			reportLog(Status.PASS, "Tax Validation Completed!!! Tax Value is not $0.00 for State :-"+_dataRepo.getData("State"), true);
			
		}
		Assert.assertEquals(expectedTotal, actualTotal,DELTA);
		logStepInfo("Tax Amount Validated!!!");
	}
			catch(Exception ex) {
				logStepInfo("Tax Validation Failed!!! "+_dataRepo.getData("State")+ex.getMessage());
				reportLog(Status.FAIL, "Tax Validation Failed!!! - "+_dataRepo.getData("State")+ex.getMessage(), true);
				}
			}

}




