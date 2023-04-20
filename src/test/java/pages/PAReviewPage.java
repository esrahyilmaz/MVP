package pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import seleniumhelper.BaseClass;

public class PAReviewPage extends BaseClass {
	
//	private static By reviwPageNxtBtn = By.xpath("//div[contains(@class,'mobile_container')]//button[text()='NEXT']");
	private static By reviwPageNxtBtn = By.xpath("//*[@id='card-slide']/clipboard/form/div[2]/div[1]/div[3]/button");
	private static By reviwModlNxtBtn = By.xpath("//div[@class='modal-footer']//button[text()='NEXT']");
//	private static By iUnderstandBtn = By.xpath("//button[text()='I UNDERSTAND']");

	public void enterReviewSection() {
		try {

			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.presenceOfElementLocated(reviwPageNxtBtn));
			
			wait(5);
			clickOnElementUsingActions(reviwPageNxtBtn, "Next");
			logStepInfo("Next Button is Clicked : " + "Next");
			
			clickElement(reviwModlNxtBtn, "Next");
			logStepInfo("Next Button is Clicked : " + "Next");
			
//			clickElement(iUnderstandBtn,"I Understand" );
//			logStepInfo("I Understand Button clicked : "+"I Understand");
			
//			if (verifyElementPresence(iUnderstandBtn)) {
//				clickElement(iUnderstandBtn,"I Understand" );
//				logStepInfo("I Understand Button clicked : "+"I Understand");
//			} else {
//				logStepInfo("I Understand Button Not clicked : "+"I Understand");
//			} 
            
		} catch (Exception ex) {
			logStepInfo("Exception occured in PA Review Page:- " + ex.getMessage());
			reportLog(Status.FAIL, "Exception occured in PA Review Page :- " + ex.getMessage(), true);
		}
  }

}
