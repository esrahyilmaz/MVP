package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import seleniumhelper.BaseClass;

public class ShopingCart extends BaseClass{

	JavascriptExecutor js = (JavascriptExecutor)driver;

	
	
	By shoppingCart_btn = By.xpath("table tbody tr td div div a");
	By shoppingCart_Item = By.xpath("//div[@id='mainBody']/div[5]/div[1]/div[1]/span");
	By shoppingCart_Price = By.xpath("(//div[.='Total:']/..//div)[last()]");

	
	public void shoppingCartBtn(String orderNumber) {
		
//		//Number of cart items >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>	
//		String shoppingCartItems = driver.findElement(shoppingCart_Item).getText();
//		System.out.println(shoppingCartItems+">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

		//Price of cart items >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		String shoppingCartPrice = driver.findElement(shoppingCart_Price).getText();
		System.out.println(shoppingCartPrice+">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		
		// Button on cart item >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement shopingBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/a[@id='shoppingCart']")));
		String text = shopingBtn.getText();
		System.out.println(text+"=========");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		String text1=(String)jse.executeScript("return arguments[0].childNodes[0].nodeValue.trim()", shopingBtn);
		
		
		
		System.out.println(text+text1+">>>>>>>>>>>>>>>>>");
						
	
	switch (orderNumber)
		{
		case "0":
			Assert.assertTrue(text.contains("Cart (0)"));
			break;
			
		case "1":
			Assert.assertTrue(text.contains("Cart (1)"));
			break;
			
		case "2":  
			Assert.assertTrue(text.contains("Cart (2)"));
			//Assert.assertEquals("2", shoppingCartItems);
			Assert.assertTrue(shoppingCartPrice.contains("$"));

			break;	
		
	//	case "3":
			
			
		}
	
	
	
	
	}
	
}
