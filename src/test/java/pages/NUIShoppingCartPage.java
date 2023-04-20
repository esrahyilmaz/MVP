package pages;

import org.openqa.selenium.By;
import seleniumhelper.BaseClass;

public class NUIShoppingCartPage extends BaseClass {

	
	By shoppingCartIcon = By.xpath("(//*[contains(@data-icon,'shopping-cart')])[last()]");
	By shoppingCartIconSection = By.xpath("(//*[contains(@data-icon,'shopping-cart')])[last()-1]");
	
	By searchShoppingCart = By.xpath("//input[@data-xf-qa-id='VW-POSC-PCKG-SEARCHFIELD']");
	By searchIconShoppingCart = By.xpath("//fa-icon[@data-xf-qa-id= 'VW-POSC-PCKG-SEARCHICON']");
	By deleteIconShoppingCart = By.xpath("//*[contains (@data-icon, 'trash-alt')]");
	By deletePkgPopupButtonYes = By.xpath("//button[text()='Yes']");
	By deletePkgPopupButtonNo = By.xpath("//button[text()='No']");
	By deletePkgPopupCheckbox = By.xpath("//input[@id='dontAsk']");
	
	By accordionShoppingCart = By.xpath("//*[@class='actionBtnCell ng-tns-c96-1']");
	
	By ccSubtotal = By.xpath("//*[@class = 'card-text ng-tns-c99-1' and contains(., 'Subtotal')]");
	By ccTax= By.xpath("//*[@class = 'card-text ng-tns-c99-1' and contains(., 'Tax')]");
	By ccOrderTotal = By.xpath("//*[@class = 'text-primary ng-tns-c99-1' and contains(., 'Order Total')]");
	
	By checkoutShoppingCartButton =  By.xpath("//div[contains(@class,'row footer-btn-wrapper')]/div/button[@data-xf-qa-id='VW-POSC-CHECKOUT']");
	By addAnotherPkgButton = By.xpath("(//button[@data-xf-qa-id='VW-POSC-ADD-ANOTHER-PCKG'])[last()]");
	
	By authorizeTickBox = By.xpath("//input[@id='authorizeCheckbox']");
	
	public By summarySection = By.xpath("//div[contains(@class, 'summary-drawer-header')]");

}
