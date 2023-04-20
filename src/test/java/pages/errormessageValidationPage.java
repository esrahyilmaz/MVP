package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import seleniumhelper.BaseClass;

import java.util.List;

public class errormessageValidationPage extends BaseClass {
	
  By userProfilePage = By.xpath("//div[@class='form-group col-sm-12 col-md-6']//input");
  By businessPage = By.xpath("//input[@id='business-name-field']");
  By personalInfoSelf = By.xpath("//div[@class='form-group col-sm-12 col-md-12']");
  public void clearUserProfileAndContactPageFeilds(String value) {

	  WebDriverWait wait = new WebDriverWait(driver, 10);
      wait.until(ExpectedConditions.presenceOfElementLocated(userProfilePage));
      List<WebElement> allFields = driver.findElements(userProfilePage);
      for (int i = 0; i < allFields.size(); i++) {   
          new Actions(driver).click(allFields.get(i))
          .pause(200).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
          .pause(200).sendKeys(Keys.BACK_SPACE).perform();
      
//          allFields.get(i).clear();
      }
  
  }
  
  public void clearBusinessFields(String value) {

	  WebDriverWait wait = new WebDriverWait(driver, 10);
      wait.until(ExpectedConditions.presenceOfElementLocated(businessPage));
      List<WebElement> allFields = driver.findElements(businessPage);
      for (int i = 0; i < allFields.size(); i++) {   
          new Actions(driver).click(allFields.get(i))
          .pause(200).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
          .pause(200).sendKeys(Keys.BACK_SPACE).perform();
      }
      }
 
      public void clearPersonalInfoFields(String value) {

    	  WebDriverWait wait = new WebDriverWait(driver, 10);
          wait.until(ExpectedConditions.presenceOfElementLocated(personalInfoSelf));
          List<WebElement> allFields = driver.findElements(personalInfoSelf);
          for (int i = 0; i < allFields.size(); i++) {   
              new Actions(driver).click(allFields.get(i))
              .pause(200).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
              .pause(200).sendKeys(Keys.BACK_SPACE).perform();
         
          }
      }

}
