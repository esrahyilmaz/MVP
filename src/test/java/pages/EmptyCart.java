package pages;

import org.openqa.selenium.By;
import seleniumhelper.BaseClass;

public class EmptyCart extends BaseClass{

	private By closeBTN=By.xpath("//th[.='Price']/../../..//td[5]/img");
	private By Msg=By.xpath("//span[.='It looks like your cart is empty.']");
	
	public void empty() {
		wait(10);
		for(int i=1;i<=2;i++)
		{
			if(!(verifyElementPresence(Msg))) {
				
				if(verifyElementPresence(closeBTN)) {
					clickElement(closeBTN, "close");
				}
			}else {
				break;
			}
			
		}
		wait(5);
//		clickElementWithWait(Msg, "clicked message");
	}
}
