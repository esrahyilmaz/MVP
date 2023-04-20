package seleniumhelper;

import Utility.PropertyFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class AHKActions extends BaseClass {
	By detectRecieverBtn = By.xpath("//a[text()='Detect Receiver']");
	By alreadyInstalledLink = By.xpath("//*[@id=\"protocolhandler-detect-alreadyInstalledLink\"]");
	By agreeCheckBox = By.xpath("//*[@id=\"legalstatement-checkbox2\"]");
	By userNameTxt = By.xpath("//*[@id=\"username\"]");
	By passwordTxt = By.xpath("//*[@id=\"password\"]");
	By domainDDL = By.xpath("//*[@id=\"domain\"]");
	By logOnBtn = By.xpath("//a[text()='Log On']");
	By SearchBox=By.xpath("//*[@id=\"searchInputId\"]");
	By winESP1Btn = By.xpath("//*[text()='WinESP QA1']");

	
	String icaPath=System.getProperty("user.dir")+"\\output\\"+getTime()+".ica";
	StringSelection stringSelection = new StringSelection(icaPath);
	Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();	
	DatabaseClass _database=new DatabaseClass();
	Desktop desktop = Desktop.getDesktop();
    
	public void loginCitrix() throws Exception {
	try {
		Robot robot=new Robot(); 
		File file = new File(icaPath);
		
		prefs.put("download.prompt_for_download", true);
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
		driver.manage().window().maximize();
	
		driver.navigate().to(PropertyFileReader.getProperty("CitrixUrl"));
		if (driver.findElement(detectRecieverBtn).isDisplayed() == true) {
			driver.findElement(detectRecieverBtn).click();
			driver.findElement(agreeCheckBox).click();
			driver.findElement(alreadyInstalledLink).click();
		
		}
		/**handling open in Citrix app alert**/
		robot.delay(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(3000);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		/**proving Credentials and Click on Log On**/
		
		driver.findElement(userNameTxt).sendKeys(PropertyFileReader.getProperty("CitrixUserName"));
		driver.findElement(passwordTxt).sendKeys(PropertyFileReader.getProperty("CitrixPassword"));
		Select dropdown = new Select(driver.findElement(domainDDL));
		dropdown.selectByVisibleText("APAC.FADV.NET");
		driver.findElement(logOnBtn).click();
		
		driver.findElement(SearchBox).sendKeys("WINESP QA1");
		/**proving Path to donload of ica file**/
		driver.findElement(winESP1Btn).click();
		wait(5);
		clipboard.setContents(stringSelection, null);
		robot.delay(19000);
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
	public void AHKTaskPerform() throws Exception{
		try {
			Runtime.getRuntime().exec("cmd /c start "+ PropertyFileReader.getProperty("AHK.path")+"HomeDepo.ahk");
			wait(4);
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_F3);
			robot.delay(1000);
			robot.keyRelease(KeyEvent.VK_F3);
			Thread.sleep(415000);
			Runtime.getRuntime().exec("cmd /c start "+ PropertyFileReader.getProperty("AHK.path")+"HomeDepoLogout.ahk");	
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_F4);
			robot.delay(1000);
			robot.keyRelease(KeyEvent.VK_F4);
		
		}catch (Exception ex) {
			System.out.println("Exception occured in::"+ex.getMessage());
			}
		}
	}

