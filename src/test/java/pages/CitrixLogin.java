package pages;


import Utility.PropertyFileReader;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import seleniumhelper.BaseClass;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class CitrixLogin extends BaseClass {
	By detectRecieverBtn = By.xpath("//a[text()='Detect Receiver']");
	By alreadyInstalledLink = By.xpath("//*[@id=\"protocolhandler-detect-alreadyInstalledLink\"]");
	By agreeCheckBox = By.xpath("//*[@id=\"legalstatement-checkbox2\"]");
	By userNameTxt = By.xpath("//*[@id=\"username\"]");
	By passwordTxt = By.xpath("//*[@id=\"password\"]");
	By domainDDL = By.xpath("//*[@id=\"domain\"]");
	By logOnBtn = By.xpath("//a[text()='Log On']");
	By winESP1Btn = By.xpath("//*[@id=\"home-screen\"]/div[2]/section[4]/div[4]/ul/li[10]/a[1]/div[3]/p");
	
	String icaPath=System.getProperty("user.dir")+"\\output\\"+getTime()+".ica";
	StringSelection stringSelection = new StringSelection(icaPath);
	Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();	
	File file = new File(icaPath);
	Desktop desktop = Desktop.getDesktop();
    
		
	@Test
	public void loginCitrix() throws Exception {
	try {
		Robot robot=new Robot(); 
		/*System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + PropertyFileReader.getProperty("chromeDriver.path"));	
			Map<String, Object> prefs = new HashMap<String, Object>();
    		ChromeOptions options = new ChromeOptions();
	        prefs.put("download.prompt_for_download", true);
	        prefs.put("download.default_directory", "path-to-download-directory");
	        options.setExperimentalOption("prefs", prefs);
	        WebDriver driver = new ChromeDriver(options);
		    driver.manage().window().maximize();*/
		driver.navigate().to(PropertyFileReader.getProperty("CitrixUrl"));
		if (driver.findElement(detectRecieverBtn).isDisplayed() == true) {
			driver.findElement(detectRecieverBtn).click();
			driver.findElement(agreeCheckBox).click();
			driver.findElement(alreadyInstalledLink).click();
		
		}
		/**handling open in Citrix app alert**/
		robot.delay(5000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(3000);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		/**proving Credentials and Click on Log On**/
		
		driver.findElement(userNameTxt).sendKeys(PropertyFileReader.getProperty("CitrixUserName"));
		driver.findElement(passwordTxt).sendKeys(PropertyFileReader.getProperty("CitrixPassword"));
		Select dropdown = new Select(driver.findElement(domainDDL));
		dropdown.selectByVisibleText("APAC.FADV.NET");
		driver.findElement(logOnBtn).click();
		wait(2);
		/**proving Path to download of ica file**/
		driver.findElement(winESP1Btn).click();
		wait(2);
		clipboard.setContents(stringSelection, null);
		robot.delay(9000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.delay(3000);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(1000);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		/**open the ica file **/
		
		if(file.exists()) desktop.open(file);
	}
		catch(Exception ex) { 
			System.out.println("Exception occured in::"+ex.getMessage());
		}
	}
	public void logoutCitrix() throws Exception {

	}
}
