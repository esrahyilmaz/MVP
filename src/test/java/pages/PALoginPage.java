package pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import seleniumhelper.BaseClass;

public class PALoginPage extends BaseClass  {
	
	private static By continuePopup= By.xpath("//*[.='CONTINUE']");
	private static By createPassword = By.xpath("//*[@id='loginInputPwd' or @id='inputSetPwd']");
	private static By passwordconfirm = By.id("inputsCnfrmPwd");
    private static By secretQuestion = By.xpath("//select[@name='secretQuestion']");
    private static By secretAnswer = By.id("inputsSecAns");
    private static By nextButtonLogIn = By.xpath("//button[@name='action']");
    private static By enterPassword = By.xpath("//*[@id='loginInputPwd' or @id='inputSetPwd']");
    private static By agreeBtn = By.xpath("//*[@id=\"myModal\"]/div/div/div[3]/div[1]/button");
	
	public void logintoPAApplication(String CrTPassword, String SecretQuestion, String SecretAnswer) {
		try {

			if (verifyElementPresence(createPassword)) {
				EnterText(createPassword,"CreatePassword", CrTPassword);
				logStepInfo("Create Password Entered : " +CrTPassword );
			} else {
				logStepInfo("Create Password Not Entered : " +CrTPassword );
			}
			if (verifyElementPresence(passwordconfirm)) {
				EnterText(passwordconfirm,"CreatePassword", CrTPassword);
				logStepInfo("Confirm Password Entered : " +CrTPassword );
			} else {
				logStepInfo("Confirm Password Not Entered : " +CrTPassword );
			}
			if (verifyElementPresence(secretQuestion)) {
				selectDropDownByValue(secretQuestion, SecretQuestion, "SecretQuestion");
				logStepInfo("Secret Question  Selected : " +SecretQuestion );
			} else {
				logStepInfo("Secret Question Not Selected : " +SecretQuestion );
			}
			if (verifyElementPresence(secretAnswer)) {
				EnterText(secretAnswer,"CreatePassword", SecretAnswer);
				logStepInfo("Secret Answer Entered : " +SecretAnswer );
			} else {
				logStepInfo("SecretAnswer  Not Entered : " +SecretAnswer );
			}
			if (verifyElementPresence(nextButtonLogIn)) {
				clickElement(nextButtonLogIn, "Next");
				logStepInfo("Next Button Clicked : " +"Next");
			} else {
				logStepInfo("Next Button Not Clicked: " +"Next" );
			}
//			wait(3);
//			if (verifyElementPresence(agreeBtn)) {
//				clickElement(agreeBtn, "Agree");
//				logStepInfo("Agree Button Clicked :  " +"Agree");
//			} else {
//				logStepInfo("Agree Button Not Clicked :  " +"Agree");
//			}
			
		} catch (Exception ex) {
			logStepInfo("Exception occured in PA Login Page:- "+ex.getMessage());
			reportLog(Status.FAIL,"Exception occured in PA Login Page :- "+ex.getMessage(), true);
		}
	}

	public void logintoPAApplicationUAT(String CrTPassword, String SecretQuestion, String SecretAnswer) {
		try {

			if (verifyElementPresence(createPassword)) {
				EnterText(createPassword,"CreatePassword", CrTPassword);
				logStepInfo("Create Password Entered : " +CrTPassword );
			} else {
				logStepInfo("Create Password Not Entered : " +CrTPassword );
			}
			if (verifyElementPresence(passwordconfirm)) {
				EnterText(passwordconfirm,"CreatePassword", CrTPassword);
				logStepInfo("Confirm Password Entered : " +CrTPassword );
			} else {
				logStepInfo("Confirm Password Not Entered : " +CrTPassword );
			}
			if (verifyElementPresence(secretQuestion)) {
				selectDropDownByValue(secretQuestion, SecretQuestion, "SecretQuestion");
				logStepInfo("Secret Question  Selected : " +SecretQuestion );
			} else {
				logStepInfo("Secret Question Not Selected : " +SecretQuestion );
			}
			if (verifyElementPresence(secretAnswer)) {
				EnterText(secretAnswer,"CreatePassword", SecretAnswer);
				logStepInfo("Secret Answer Entered : " +SecretAnswer );
			} else {
				logStepInfo("SecretAnswer  Not Entered : " +SecretAnswer );
			}
			if (verifyElementPresence(nextButtonLogIn)) {
				clickElement(nextButtonLogIn, "Next");
				logStepInfo("Next Button Clicked : " +"Next");
			} else {
				logStepInfo("Next Button Not Clicked: " +"Next" );
			}
			wait(3);
			if (verifyElementPresence(agreeBtn)) {
				clickElement(agreeBtn, "Agree");
				logStepInfo("Agree Button Clicked :  " +"Agree");
			} else {
				logStepInfo("Agree Button Not Clicked :  " +"Agree");
			}
			
		} catch (Exception ex) {
			logStepInfo("Exception occured in PA Login Page:- "+ex.getMessage());
			reportLog(Status.FAIL,"Exception occured in PA Login Page :- "+ex.getMessage(), true);
		}
	}
	
	
	public void signInIntoPAApplication(String CrTPassword) {
		try {

//			if (verifyElementPresence(continuePopup)) {
//				clickElement(continuePopup, "CONTINUE");
//				logStepInfo("Continue Button Clicked : " +"CONTINUE");
//			} else {
//				logStepInfo("Continue Button Not Clicked : " +"CONTINUE");
//			}
			
			if (verifyElementPresence(enterPassword)) {
				EnterText(enterPassword,"CreatePassword", CrTPassword);
				logStepInfo("Password Entered : " +CrTPassword );
			} else {
				logStepInfo("Password Not Entered : " +CrTPassword );
			}
			if (verifyElementPresence(nextButtonLogIn)) {
				clickElement(nextButtonLogIn, "Next");
				logStepInfo("Next Button Clicked : " +"Next");
			} else {
				logStepInfo("Next Button Not Clicked: " +"Next" );
			}
		} catch (Exception ex) {
			logStepInfo("Exception occured in PA Login Page:- "+ex.getMessage());
			reportLog(Status.FAIL,"Exception occured in PA Login Page :- "+ex.getMessage(), true);
		}
	}
}
