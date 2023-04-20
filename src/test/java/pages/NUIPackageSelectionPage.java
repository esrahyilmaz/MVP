package pages;

import org.openqa.selenium.By;
import seleniumhelper.BaseClass;

public class NUIPackageSelectionPage extends BaseClass {
	
	
	By packageIcon = By.xpath("(//*[contains(@data-icon,'boxes')])[last()]");
	By packageIconSection = By.xpath("(//*[contains(@data-icon,'boxes')])[last()-1]");
	
	By searchPackage = By.xpath("//input[@data-xf-qa-id='VW-POPS-PCKG-SEARCHFIELD']");
	By searchIconPackage = By.xpath("//fa-icon[@data-xf-qa-id= 'VW-POPS-PCKG-SEARCHICON']");
	
	By previousPackageButton = By.xpath("//button[@class = 'btn btn-default mr-2']");
	By addToCartShoppingButton =  By.xpath("//div[@class='row footer-btn-wrapper']/div/button[@data-xf-qa-id='VW-POPS-ADD-TO-CART']");
	By packageSelectionPageHeader=By.xpath("//h5[contains(text(),\"Package Selection\")]");
	
}

