package pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import seleniumhelper.BaseClass;

public class VerifyLegalAgreement extends BaseClass{
	
	private static By acceptChkBox=By.xpath("//input[@name='acceptFCRA']");
	private static By roasterChkBox=By.xpath("//input[@name='rosterIsUpToDate']");
	private static By continueToDashboardBTN=By.xpath("//input[@name='accept']");
	private static By acceptLegalAgreementBTN=By.xpath("//input[@value='ACCEPT LEGAL AGREEMENT']");
	private static By declineLegalAgreementBTN=By.xpath("//input[@value='DECLINE LEGAL AGREEMENT']");
	private static By proceedWithLoginBTN=By.xpath("//input[@value='Proceed with Login']");
	private static By acceptFCRAAgreementBTN=By.xpath("//input[@value='ACCEPT FCRA AGREEMENT']");
	private static By declineFCRAAgreementBTN=By.xpath("//input[@value='DECLINE FCRA AGREEMENT']");
	
	public void crwenabledExistingUser(String errorMsg1,String errorMsg2) {
		
		if(verifyElementPresence(proceedWithLoginBTN)) {
			clickElement(proceedWithLoginBTN, "proceed With Login");
			
			if(verifyElementPresence(declineFCRAAgreementBTN)) {
				clickElement(declineFCRAAgreementBTN, "Decline FCRA Agreement");
			}
			if(verifyElementPresence(By.xpath("//div[contains(.,'"+errorMsg1+"')]"))) {
				reportLog(Status.PASS, errorMsg1, false);
			}else {
				reportLog(Status.FAIL, errorMsg1+" not found", true);
			}
		}
		
		if(verifyElementPresence(continueToDashboardBTN)) {
			clickElement(continueToDashboardBTN, "continue to dashboard");
		}
		if(verifyElementPresence(By.xpath("//div[contains(.,'"+errorMsg1+"')]"))) {
			reportLog(Status.PASS, errorMsg1, false);
		}else {
			reportLog(Status.FAIL, errorMsg1+" not found", true);
		}
		
		if(verifyElementPresence(acceptChkBox)) {
			clickElement(acceptChkBox, "Accept Check box");
		}
		if(verifyElementPresence(continueToDashboardBTN)) {
			clickElement(continueToDashboardBTN, "continue to dashboard");
		}
		if(verifyElementPresence(By.xpath("//div[contains(.,'"+errorMsg2+"')]"))) {
			reportLog(Status.PASS, errorMsg2, false);
		}else {
			reportLog(Status.FAIL, errorMsg2+" not found", true);
		}
		
		if(verifyElementPresence(roasterChkBox)) {
			clickElement(roasterChkBox, "Accept Roaster");
		}
		if(verifyElementPresence(continueToDashboardBTN)) {
			clickElement(continueToDashboardBTN, "continue to dashboard");
		}
		if(verifyElementPresence(By.xpath("//div[contains(.,'"+errorMsg1+"')]"))) {
			reportLog(Status.PASS, errorMsg1, false);
		}else {
			reportLog(Status.FAIL, errorMsg1+" not found", true);
		}
		
		if(verifyElementPresence(acceptChkBox)) {
			clickElement(acceptChkBox, "Accept Check box");
		}
		if(verifyElementPresence(roasterChkBox)) {
			clickElement(roasterChkBox, "Accept Roaster");
		}
		if(verifyElementPresence(continueToDashboardBTN)) {
			clickElement(continueToDashboardBTN, "continue to dashboard");
		}
	}
	
	public void crwenabledNewUser(String errorMsg1,String errorMsg2,String errorMsg3) {
		
		if(verifyElementPresence(declineLegalAgreementBTN)) {
			clickElement(declineLegalAgreementBTN, "decline legal Agreement");
		}
		if(verifyElementPresence(By.xpath("//div[contains(.,'"+errorMsg3+"')]"))) {
			reportLog(Status.PASS, errorMsg3, false);
		}else {
			reportLog(Status.FAIL, errorMsg3+" not found", true);
		}
		if(verifyElementPresence(declineLegalAgreementBTN)) {
			clickElement(declineLegalAgreementBTN, "decline legal Agreement");
		}
		if(verifyElementPresence(By.xpath("//div[contains(.,'"+errorMsg3+"')]"))) {
			reportLog(Status.PASS, errorMsg3, false);
		}else {
			reportLog(Status.FAIL, errorMsg3+" not found", true);
		}
		if(verifyElementPresence(acceptLegalAgreementBTN)) {
			clickElement(acceptLegalAgreementBTN, "Accept legal Agreement");
		}
		
		if(verifyElementPresence(continueToDashboardBTN)) {
			clickElement(continueToDashboardBTN, "continue to dashboard");
		}
		if(verifyElementPresence(By.xpath("//div[contains(.,'"+errorMsg1+"')]"))) {
			reportLog(Status.PASS, errorMsg1, false);
		}else {
			reportLog(Status.FAIL, errorMsg1+" not found", true);
		}
		
		if(verifyElementPresence(acceptChkBox)) {
			clickElement(acceptChkBox, "Accept Check box");
		}
		if(verifyElementPresence(continueToDashboardBTN)) {
			clickElement(continueToDashboardBTN, "continue to dashboard");
		}
		if(verifyElementPresence(By.xpath("//div[contains(.,'"+errorMsg2+"')]"))) {
			reportLog(Status.PASS, errorMsg2, false);
		}else {
			reportLog(Status.FAIL, errorMsg2+" not found", true);
		}
		
		if(verifyElementPresence(roasterChkBox)) {
			clickElement(roasterChkBox, "Accept Roaster");
		}
		if(verifyElementPresence(continueToDashboardBTN)) {
			clickElement(continueToDashboardBTN, "continue to dashboard");
		}
		if(verifyElementPresence(By.xpath("//div[contains(.,'"+errorMsg1+"')]"))) {
			reportLog(Status.PASS, errorMsg1, false);
		}else {
			reportLog(Status.FAIL, errorMsg1+" not found", true);
		}
		
		if(verifyElementPresence(acceptChkBox)) {
			clickElement(acceptChkBox, "Accept Check box");
		}
		if(verifyElementPresence(roasterChkBox)) {
			clickElement(roasterChkBox, "Accept Roaster");
		}
		if(verifyElementPresence(continueToDashboardBTN)) {
			clickElement(continueToDashboardBTN, "continue to dashboard");
		}
	}

	public void crwdisabledExistingUser(String errorMsg1) {
	
		if(verifyElementPresence(proceedWithLoginBTN)) {
			clickElement(proceedWithLoginBTN, "proceed With Login");
			
			if(verifyElementPresence(declineFCRAAgreementBTN)) {
				clickElement(declineFCRAAgreementBTN, "Decline FCRA Agreement");
			}
			if(verifyElementPresence(By.xpath("//div[contains(.,'"+errorMsg1+"')]"))) {
				reportLog(Status.PASS, errorMsg1, false);
			}else {
				reportLog(Status.FAIL, errorMsg1+" not found", true);
			}
		}
		
		if(verifyElementPresence(declineFCRAAgreementBTN)) {
			clickElement(declineFCRAAgreementBTN, "Decline FCRA Agreement");
		}
		if(verifyElementPresence(By.xpath("//div[contains(.,'"+errorMsg1+"')]"))) {
			reportLog(Status.PASS, errorMsg1, false);
		}else {
			reportLog(Status.FAIL, errorMsg1+" not found", true);
		}
		
		if(verifyElementPresence(acceptFCRAAgreementBTN)) {
			clickElement(acceptFCRAAgreementBTN, "Accept FCRA Agreement");
		}
		
	}

	public void crwdisabledNewUser(String errorMsg1,String errorMsg3) {
	
		if(verifyElementPresence(declineLegalAgreementBTN)) {
			clickElement(declineLegalAgreementBTN, "decline legal Agreement");
		}
		if(verifyElementPresence(By.xpath("//div[contains(.,'"+errorMsg3+"')]"))) {
			reportLog(Status.PASS, errorMsg3, false);
		}else {
			reportLog(Status.FAIL, errorMsg3+" not found", true);
		}
		if(verifyElementPresence(declineLegalAgreementBTN)) {
			clickElement(declineLegalAgreementBTN, "decline legal Agreement");
		}
		if(verifyElementPresence(By.xpath("//div[contains(.,'"+errorMsg3+"')]"))) {
			reportLog(Status.PASS, errorMsg3, false);
		}else {
			reportLog(Status.FAIL, errorMsg3+" not found", true);
		}
		if(verifyElementPresence(acceptLegalAgreementBTN)) {
			clickElement(acceptLegalAgreementBTN, "Accept legal Agreement");
		}
		
		if(verifyElementPresence(declineFCRAAgreementBTN)) {
			clickElement(declineFCRAAgreementBTN, "Decline FCRA Agreement");
		}
		if(verifyElementPresence(By.xpath("//div[contains(.,'"+errorMsg1+"')]"))) {
			reportLog(Status.PASS, errorMsg1, false);
		}else {
			reportLog(Status.FAIL, errorMsg1+" not found", true);
		}
		if(verifyElementPresence(declineFCRAAgreementBTN)) {
			clickElement(declineFCRAAgreementBTN, "Decline FCRA Agreement");
		}
		if(verifyElementPresence(By.xpath("//div[contains(.,'"+errorMsg1+"')]"))) {
			reportLog(Status.PASS, errorMsg1, false);
		}else {
			reportLog(Status.FAIL, errorMsg1+" not found", true);
		}
		
		if(verifyElementPresence(acceptFCRAAgreementBTN)) {
			clickElement(acceptFCRAAgreementBTN, "Accept FCRA Agreement");
		}
	}

}
