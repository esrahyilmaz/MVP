package pages;

import org.openqa.selenium.By;
import seleniumhelper.BaseClass;

public class NUIOrderSubmissionPage extends BaseClass {

		
	By orderConfirmationIcon = By.xpath("//*[contains(@data-icon,'check')])[last()]");
	By orderConfirmationIconSection = By.xpath("//*[contains(@data-icon,'check')])[last()-1]"); 
	By returnToPeopleButton =  By.xpath("//button[@data-xf-qa-id='VW-POOC-RETURN-TO-PEOPLE']");
	
	
}
