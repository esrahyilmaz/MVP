package pages;

import Utility.ExcelReader;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import seleniumhelper.BaseClass;

public class PANoticePage extends BaseClass {
	
	ExcelReader _dataRepo = new ExcelReader();
	
	private static By declineBtn = By.xpath("//button[.='DECLINE']");
	private static By agreeBtn = By.xpath("//button[.='AGREE']");
	private static By noticePage = By.xpath("//h2[contains(text(),'Notice')]");
	private static By noticePagePROD = By.xpath("//h2[contains(text(),'Authorization')]");
	private static By qcNext = By.xpath("//button[.='NEXT']");
    private static By signInPanelTitle = By.xpath("//h3[contains(text(),'Please sign')]");
	private static By signInCanVas = By.xpath("//*[@id='signature_Modal']//signature-paddemo//canvas");
	private static By signButtoninSignPad = By.xpath("//button[text()='SIGN']");
	
	private static By confirmSignature = By.xpath("//button[.=' CONFIRM ']");
	private static By iUnderstandBtn = By.xpath("//button[text()='I UNDERSTAND']");
	private static By popupIUnderadand = By.xpath("//h4[contains(text(),'Please read through the following instructions')]");
	
	private static By acceptRBtn1 = By.xpath("(//*[@id=\"KnockoutDatafrm\"]/div[3]/div[2]/label[1]/input)[1]");
	private static By acceptRBtn2 = By.xpath("(//*[@id=\"KnockoutDatafrm\"]/div[3]/div[2]/label[1]/input)[2]");
	//*[@id="KnockoutDatafrm"]/div[3]/div[2]/label[1]/input
	private static By consentFirstName1 = By.xpath("(//label[text()='First Name']/following-sibling::input)[1]");
	private static By consentLastName1 = By.xpath("(//label[text()='Last Name']/following-sibling::input)[1]");
	private static By consentFirstName2 = By.xpath("(//label[text()='First Name']/following-sibling::input)[2]");
	private static By consentLastName2 = By.xpath("(//label[text()='Last Name']/following-sibling::input)[2]");
	private static By iConsentBtn1 = By.xpath("(//button[.='I CONSENT'])[1]");
	private static By iConsentBtn2 = By.xpath("(//button[.='I CONSENT'])[2]");
	
	private static By dontAcceptRBtn = By.xpath("//*[@id=\"KnockoutDatafrm\"]/div[3]/div[2]/label[2]/input");
	private static By iDeclineBtn = By.xpath("//form/div/div/div/div[4]/div[2]/button");
	private static By iDeclineBtnUAT= By.xpath("//*[@id='KnockoutDatafrm']/div[4]/div/dynamic-form/div/form/div/div/button");
	private static By popUpDeclineBtn = By.xpath("//*[@id=\"consent_disagree_modal\"]/div/div/div[3]/div/div[1]/button");
	private static By popUpDeclineBtnUAT = By.xpath("//*[@id='dynamic_decline_modal']/div/div/div[3]/div/div[1]/button");
	private static By popUpDeclineBtnPROD = By.xpath("//*[@id=\"consent_disagree_modal\"]/div/div/div[3]/div/div[1]/button");	
	private static By popUpDeclineMsg = By.xpath("//h4[contains(text(),'By declining, you are preventing')]");
	
	
	public void clickConsentRejectButtonPROD() {
		try {

			if (verifyElementPresence(qcNext)) {
				clickElement(qcNext,"Next" );
				logStepInfo("Next Button clicked : "+"Next");
			} else {
				logStepInfo("Next Button Not clicked : "+"Next");
			}
				
			wait(3);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.presenceOfElementLocated(noticePagePROD));
			wait.until(ExpectedConditions.presenceOfElementLocated(declineBtn)).click();
			logStepInfo("Decline Button clicked : "+"Decline");
			
			wait.until(ExpectedConditions.presenceOfElementLocated(popUpDeclineMsg));
			clickElement(popUpDeclineBtnPROD,"I DECLINE-popup");
			logStepInfo("I DECLINE button from popup clicked: "+"I DECLINE");
			
		} catch (Exception ex) {
			logStepInfo("Exception occured in PA Notice Page:- "+ex.getMessage());
			reportLog(Status.FAIL,"Exception occured in PA Notice Page :- "+ex.getMessage(), true);
		}
	}
	public void clickConsentButtonPROD() {
		try {

			if (verifyElementPresence(qcNext)) {
				clickElement(qcNext,"Next" );
				logStepInfo("Next Button clicked : "+"Next");
			} else {
				logStepInfo("Next Button Not clicked : "+"Next");
			}
				
			wait(3);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.presenceOfElementLocated(noticePagePROD));
			wait.until(ExpectedConditions.presenceOfElementLocated(agreeBtn)).click();
			logStepInfo("Agree Button clicked : "+"Agree");
			
			wait.until(ExpectedConditions.presenceOfElementLocated(signInPanelTitle));
			actionPerform(signInCanVas, "Draw on PA Signature Canvas");
			logStepInfo("Signature Entered : "+"Sign");
			clickElement(signButtoninSignPad, "Sign");
			logStepInfo("Sign Button clicked : "+"Sign");
			
			wait.until(ExpectedConditions.presenceOfElementLocated(confirmSignature)).click();
			logStepInfo("CONFIRM Button clicked : "+"CONFIRM");
			
			wait(2);
			
			if (verifyElementPresence(iUnderstandBtn)) {
				clickElement(iUnderstandBtn,"I Understand" );
				logStepInfo("I Understand Button clicked : "+"I Understand");
			} else {
				logStepInfo("I Understand Button Not clicked : "+"I Understand");
			}
			
		} catch (Exception ex) {
			logStepInfo("Exception occured in PA Notice Page:- "+ex.getMessage());
			reportLog(Status.FAIL,"Exception occured in PA Notice Page :- "+ex.getMessage(), true);
		}
	}

	
	public void clickConsentButtonQC() {
		try {
			
//			if (verifyElementPresence(agreeBtn)) {
//				clickElement(agreeBtn,"Agree" );
//				logStepInfo("Agree Button clicked : "+"Agree");
//			} else {
//				logStepInfo("Agree Button Not clicked : "+"Agree");
//			}
			wait(2);
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.presenceOfElementLocated(noticePage));
			wait.until(ExpectedConditions.presenceOfElementLocated(agreeBtn)).click();
			logStepInfo("Agree Button clicked : "+"Agree");
			
			wait.until(ExpectedConditions.presenceOfElementLocated(signInPanelTitle));
			actionPerform(signInCanVas, "Draw on PA Signature Canvas");
			logStepInfo("Signature Entered : "+"Sign");
			clickElement(signButtoninSignPad, "Sign");
			logStepInfo("Sign Button clicked : "+"Sign");
			
			wait.until(ExpectedConditions.presenceOfElementLocated(confirmSignature)).click();
			logStepInfo("CONFIRM Button clicked : "+"CONFIRM");
			
//			wait(2);
//			wait.until(ExpectedConditions.presenceOfElementLocated(popupIUnderadand));
//			clickElement(iUnderstandBtn,"I Understand");
//			wait(2);
//			logStepInfo("I Understand Button clicked : "+"I Understand");
			
		} catch (Exception ex) {
			logStepInfo("Exception occured in PA Notice Page:- "+ex.getMessage());
			reportLog(Status.FAIL,"Exception occured in PA Notice Page :- "+ex.getMessage(), true);
		}
	}
	
	public void clickConsentButtonUAT1() {
		try {

//			if (verifyElementPresence(agreeBtn)) {
//				clickElement(agreeBtn,"Agree" );
//				logStepInfo("Agree Button clicked : "+"Agree");
//			} else {
//				logStepInfo("Agree Button Not clicked : "+"Agree");
//			}
			
//			if (verifyElementPresence(qcNext)) {
//				clickElement(qcNext,"Next" );
//				logStepInfo("Next Button clicked : "+"Next");
//			} else {
//				logStepInfo("Next Button Not clicked : "+"Next");
//			}
			
			if (verifyElementPresence(acceptRBtn1)) {
				clickElement(acceptRBtn1,"Yes" );
				logStepInfo("Yes radiobutton clicked : "+"I Accept");
			} else {
				logStepInfo("Yes radiobutton Not clicked : "+"I Accept");
			}
			
			if (verifyElementPresence(consentFirstName1)) {
				EnterText(consentFirstName1, "User Entered First Name", _dataRepo.getData("FirstName"));
			} else {
				logStepInfo("User didn't enter First Name.");
			}
			
			if (verifyElementPresence(consentLastName1)) {
				EnterText(consentLastName1, "User Entered Last Name", _dataRepo.getData("LastName"));
			} else {
				logStepInfo("User didn't enter Last Name.");
			}
			
			if (verifyElementPresence(iConsentBtn1)) {
				clickElement(iConsentBtn1,"I CONSENT" );
				logStepInfo("I Consent Button clicked : "+"I CONSENT");
			} else {
				logStepInfo("I Consent Button Not clicked : "+"I CONSENT");
			} 
						
//			if (verifyElementPresence(signInPanelTitle)){
//				actionPerform(signInCanVas, "Draw on PA Signature Canvas");
//				logStepInfo("Signature Entered : "+"Sign");
//				clickElement(signButtoninSignPad, "Sign");
//				logStepInfo("Sign Button clicked : "+"Sign");
//			} else {
//				logStepInfo("Sign Button Not Clicked : "+"Sign");
//			}
//			
//			if (verifyElementPresence(confirmSignature)) {
//				clickElement(confirmSignature,"I Understand" );
//				logStepInfo("CONFIRM Button clicked : "+"CONFIRM");
//			} else {
//				logStepInfo("CONFIRM Button Not clicked : "+"CONFIRM");
//			}
//			
//			if (verifyElementPresence(iUnderstandBtn)) {
//				clickElement(iUnderstandBtn,"I Understand" );
//				logStepInfo("I Understand Button clicked : "+"I Understand");
//			} else {
//				logStepInfo("I Understand Button Not clicked : "+"I Understand");
//			}
			
		} catch (Exception ex) {
			logStepInfo("Exception occured in PA Notice Page:- "+ex.getMessage());
			reportLog(Status.FAIL,"Exception occured in PA Notice Page :- "+ex.getMessage(), true);
		}
	}
	
	public void clickConsentButtonUAT2() {
		try {

//			if (verifyElementPresence(agreeBtn)) {
//				clickElement(agreeBtn,"Agree" );
//				logStepInfo("Agree Button clicked : "+"Agree");
//			} else {
//				logStepInfo("Agree Button Not clicked : "+"Agree");
//			}
//			
//			if (verifyElementPresence(qcNext)) {
//				clickElement(qcNext,"Next" );
//				logStepInfo("Next Button clicked : "+"Next");
//			} else {
//				logStepInfo("Next Button Not clicked : "+"Next");
//			}
			
			if (verifyElementPresence(acceptRBtn2)) {
				clickElement(acceptRBtn2,"Yes" );
				logStepInfo("Yes radiobutton clicked : "+"I Accept");
			} else {
				logStepInfo("Yes radiobutton Not clicked : "+"I Accept");
			}
			
			if (verifyElementPresence(consentFirstName2)) {
				EnterText(consentFirstName2, "User Entered First Name", _dataRepo.getData("FirstName"));
			} else {
				logStepInfo("User didn't enter First Name.");
			}
			
			if (verifyElementPresence(consentLastName2)) {
				EnterText(consentLastName2, "User Entered Last Name", _dataRepo.getData("LastName"));
			} else {
				logStepInfo("User didn't enter Last Name.");
			}
			
			if (verifyElementPresence(iConsentBtn2)) {
				clickElement(iConsentBtn2,"I CONSENT" );
				logStepInfo("I Consent Button clicked : "+"I CONSENT");
			} else {
				logStepInfo("I Consent Button Not clicked : "+"I CONSENT");
			} 
//			
//			if (verifyElementPresence(agreeBtn)) {
//				clickElement(agreeBtn,"Agree" );
//				logStepInfo("Agree Button clicked : "+"Agree");
//			} else {
//				logStepInfo("Agree Button Not clicked : "+"Agree");
//			}
//			
//			if (verifyElementPresence(signInPanelTitle)){
//				actionPerform(signInCanVas, "Draw on PA Signature Canvas");
//				logStepInfo("Signature Entered : "+"Sign");
//				clickElement(signButtoninSignPad, "Sign");
//				logStepInfo("Sign Button clicked : "+"Sign");
//			} else {
//				logStepInfo("Sign Button Not Clicked : "+"Sign");
//			}
//			
//			if (verifyElementPresence(confirmSignature)) {
//				clickElement(confirmSignature,"I Understand" );
//				logStepInfo("CONFIRM Button clicked : "+"CONFIRM");
//			} else {
//				logStepInfo("CONFIRM Button Not clicked : "+"CONFIRM");
//			}
//			
//			if (verifyElementPresence(iUnderstandBtn)) {
//				clickElement(iUnderstandBtn,"I Understand" );
//				logStepInfo("I Understand Button clicked : "+"I Understand");
//			} else {
//				logStepInfo("I Understand Button Not clicked : "+"I Understand");
//			}
			
		} catch (Exception ex) {
			logStepInfo("Exception occured in PA Notice Page:- "+ex.getMessage());
			reportLog(Status.FAIL,"Exception occured in PA Notice Page :- "+ex.getMessage(), true);
		}
	}
	
	
	public void clickAgreeButtonUAT() {
		try {
			
			WebDriverWait wait = new WebDriverWait(driver, 20);
			
			if (verifyElementPresence(agreeBtn)) {
				clickElement(agreeBtn,"Agree" );
				logStepInfo("Agree Button clicked : "+"Agree");
			} else {
				logStepInfo("Agree Button Not clicked : "+"Agree");
			}
			
			wait.until(ExpectedConditions.presenceOfElementLocated(signInPanelTitle));
			actionPerform(signInCanVas, "Draw on PA Signature Canvas");
			logStepInfo("Signature Entered : "+"Sign");
			clickElement(signButtoninSignPad, "Sign");
			logStepInfo("Sign Button clicked : "+"Sign");
			
			wait.until(ExpectedConditions.presenceOfElementLocated(confirmSignature)).click();
			logStepInfo("CONFIRM Button clicked : "+"CONFIRM");
			
			
		} catch (Exception ex) {
			logStepInfo("Exception occured in PA Notice Page:- "+ex.getMessage());
			reportLog(Status.FAIL,"Exception occured in PA Notice Page :- "+ex.getMessage(), true);
		}
	}
	
	public void clickConsentRejectButton() {
		try {

//			clickElement(dontAcceptRBtn,"No");
//			logStepInfo("No radiobutton clicked: "+"Don't Accept");
			
			clickElement(iDeclineBtn,"I DECLINE");
			logStepInfo("I DECLINE button clicked: "+"Consent Rejected");
			
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.presenceOfElementLocated(popUpDeclineMsg));
			clickElement(popUpDeclineBtn,"I DECLINE-popup");
			logStepInfo("I DECLINE button from popup clicked: "+"Consent Rejected-popup");
			
			
		} catch (Exception ex) {
			logStepInfo("Exception occured in PA Notice Page:- "+ex.getMessage());
			reportLog(Status.FAIL,"Exception occured in PA Notice Page :- "+ex.getMessage(), true);
		}
	}
	
	public void clickConsentRejectButtonUAT() {
		try {

			clickElement(dontAcceptRBtn,"No");
			logStepInfo("No radiobutton clicked: "+"Don't Accept");
			
			clickElement(iDeclineBtnUAT,"I DECLINE");
			logStepInfo("I DECLINE button clicked: "+"Consent Rejected");
			
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.presenceOfElementLocated(popUpDeclineMsg));
			clickElement(popUpDeclineBtnUAT,"I DECLINE-popup");
			logStepInfo("I DECLINE button from popup clicked: "+"Consent Rejected-popup");
			
			
		} catch (Exception ex) {
			logStepInfo("Exception occured in PA Notice Page:- "+ex.getMessage());
			reportLog(Status.FAIL,"Exception occured in PA Notice Page :- "+ex.getMessage(), true);
		}
	}

}
