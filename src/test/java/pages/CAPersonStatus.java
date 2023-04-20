package pages;

import Utility.ExcelReader;
import org.openqa.selenium.By;
import seleniumhelper.BaseClass;

public class CAPersonStatus extends BaseClass {
	ExcelReader _dataRepo = new ExcelReader();

	By beginOrderProcessBtn = By.xpath("//*[@id='pvComplianceDetails']/tbody/tr[2]/td/input");
	By personStatusLbl = By.xpath("/html/body/table/tbody/tr/td[2]/div/b");
	By submitBadgePhotoLbl = By.xpath("//*[@id=\"uploadBadgePhotoForm\"]/table/tbody/tr/td/table/tbody/tr[1]/td/b");
	By submitBadgePhotoBtn = By.xpath("//*[@id=\"pvComplianceDetails\"]/tbody/tr[4]/td/input");

	By orderReplacementBadgeBtn = By.xpath("//*[@id=\"pvComplianceDetails\"]/tbody/tr[4]/td/input");
	By addPhotoTxt = By
			.xpath("//*[@id=\"uploadBadgePhotoForm\"]/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td[1]");

	By printTempBadgeBtn = By.xpath("//input[contains(@value,\"PRINT TEMPORARY BADGE\")]");
	By sendBadgeBtn = By.xpath("//input[@value='SEND BADGE']");

	By chooseFileBtn = By.xpath(
			"//*[@id=\"uploadBadgePhotoForm\"]/table/tbody/tr/td/table/tbody/tr[7]/td/table/tbody/tr[2]/td[2]/input[1]");
	By uploadFileBtn = By.xpath(
			"//*[@id=\"uploadBadgePhotoForm\"]/table/tbody/tr/td/table/tbody/tr[7]/td/table/tbody/tr[2]/td[2]/input[2]");

	By addFileBtn = By.xpath(
			"//*[@id=\"uploadBadgePhotoForm\"]/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td[2]/input[1]");
	By addFileUploadBtn = By.xpath(
			"//*[@id=\"uploadBadgePhotoForm\"]/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td[2]/input[2]");

	By scAddFileBtn = By.xpath(
			"//*[@id=\"scUploadBadgePhotoForm\"]/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/input");
	By scFileUploadBtn = By.xpath(
			"//*[@id=\"scUploadBadgePhotoForm\"]/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[4]/td/input");
	By priceMsgLbl = By.xpath("//*[@id=\"uploadBadgePhotoForm\"]/table/tbody/tr/td/table/tbody/tr[3]/td");
	By nextBtn = By.xpath("//*[@id=\"uploadBadgePhotoForm\"]/table/tbody/tr/td/table/tbody/tr[7]/td/input[6]");
	By continueBtn = By.xpath("//*[@id=\"scUploadBadgePhotoForm\"]/table/tbody/tr/td/table/tbody/tr[3]/td/input[4]");
	By previousBtn = By.xpath("//*[@id=\"uploadBadgePhotoForm\"]/table/tbody/tr/td/table/tbody/tr[3]/td/p[3]/input");
	By previousBtn1 = By.xpath("//input[@value='Previous']");

	By complianceImpactTxt = By.xpath("/html/body/table/tbody/tr/td[2]/table[2]/tbody/tr[1]/td[5]");
	By caseStatusTxt = By.xpath("/html/body/table/tbody/tr/td[2]/table[2]/tbody/tr[2]/td/table/tbody/tr/td[6]");
	By complianceStatusTxt = By.xpath("//*[@id=\"peopleForm\"]/table/tbody/tr[20]/td[2]");
	By caseScoreTxt = By.xpath("/html/body/table/tbody/tr/td[2]/table[2]/tbody/tr[2]/td/table/tbody/tr/td[7]/a");
	By photoStatusTxt = By.xpath("//*[@id=\"pvComplianceDetails\"]/tbody/tr[12]/td[2]");
	By orderidTxt = By.xpath("/html/body/table/tbody/tr/td[2]/table[2]/tbody/tr[1]/td[1]");	
	By okBtn=By.xpath("//*[@value='OK']");

}
