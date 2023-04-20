package pages;

import org.openqa.selenium.By;
import seleniumhelper.BaseClass;

public class NUIForgotPasswordPage  extends BaseClass{

	By frgtPasswordField = By.xpath("//*[@id='pass-field']");
	By frgtConfirmPasswordField = By.xpath("//*[@id='confirm-field']");
	By returnToLogin = By.xpath("/html/body/modal-container/div/div/div/button");
	By submit = By.xpath("//*[@id=\"resetPassword\"]/div[5]/button");
}
