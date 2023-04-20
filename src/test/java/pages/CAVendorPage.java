package pages;

import Utility.ExcelReader;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import seleniumhelper.BaseClass;

public class CAVendorPage extends BaseClass {
	ExcelReader _dataRepo = new ExcelReader();

	// -------------------------Page Object-------------------------//
	By pageText = By.xpath("//*[contains(text(),'Service Provider Profile')]");

	// -------------------------Page Button-------------------------//

	By AspensearchBtn = By.xpath("/html/body/table/tbody/tr/td[2]/form/table[1]/tbody/tr[9]/td/input[1]");
	By homeDepotSearchBtn = By.xpath("//input[@value='Search']");
	By clearBtn = By.xpath("/html/body/table/tbody/tr/td[2]/form/table/tbody/tr[9]/td/input[2]");
	By editBtn = By.xpath("//*[@id=\"vdList\"]/tbody[1]/tr[1]/td[10]/input");
	// -------------------------Page Title-------------------------//
	By vendorTitle = By.xpath("/html/body/table/tbody/tr/td[2]/div[1]/b");

	// -------------------------Page Object-------------------------//
	By vendorName = By.xpath("//*[@id=\"peopleSearchForm\"]/table/tbody/tr[1]/td[1]");

	By peopleNumberLink = By.xpath("//*[@id='row2']/div/a");
	By vendorNameLink = By.xpath("//*[@id='row2']/a");
	By vendorNameLink2=By.xpath("//a[contains(.,'THD DEMO CA')]");
	

	// -------------------------Page Textbox-------------------------//
	By vendorNameTxt = By.xpath("//*[@id='vendorName']");
	By vendorTextVal = By.xpath("//*[@id=\"peopleSearchForm\"]/table/tbody/tr[1]/td[2]/b");

	// -------------------------Page Labels-------------------------//
	By vendorNameLbl = By.xpath("/html/body/table/tbody/tr/td[2]/form/table/tbody/tr[2]/td[1]");
	By contactFirstNameLbl = By.xpath("/html/body/table/tbody/tr/td[2]/form/table/tbody/tr[3]/td[1]");
	By vendorStatusLbl = By.xpath("/html/body/table/tbody/tr/td[2]/form/table/tbody/tr[5]/td[1]");
	By businessComponentStatusLbl = By.xpath("/html/body/table/tbody/tr/td[2]/form/table/tbody/tr[6]/td[1]");
	By businessComponentExpirationLbl = By.xpath("/html/body/table/tbody/tr/td[2]/form/table/tbody/tr[7]/td[1]");
	By contactLastNameLbl = By.xpath("/html/body/table/tbody/tr/td[2]/form/table/tbody/tr[4]/td[1]");
	By vendorAccountLbl = By.xpath("/html/body/table/tbody/tr/td[2]/form/table/tbody/tr[1]/td[1]");

	// -------------------------Page Table Objects-------------------------//
	By vendorNameCol = By.xpath("//*[@id=\"vdList\"]/thead/tr[2]/th[1]/div");
	By peopleCol = By.xpath("//*[@id=\"vdList\"]/thead/tr[2]/th[2]/div");
	By vendorAccountCol = By.xpath("//*[@id=\"vdList\"]/thead/tr[2]/th[3]/div");
	By contactNameCol = By.xpath("//*[@id=\"vdList\"]/thead/tr[2]/th[4]/div");
	By contactPhoneCol = By.xpath("//*[@id=\"vdList\"]/thead/tr[2]/th[5]/div");
	By vendorStatusCol = By.xpath("//*[@id=\"vdList\"]/thead/tr[2]/th[6]/div");
	By credentialStatusCol = By.xpath("//*[@id=\"vdList\"]/thead/tr[2]/th[7]/div");
	By businessAcknowledgedCol = By.xpath("//*[@id=\"vdList\"]/thead/tr[2]/th[8]/div");
	By businessExpirationCol = By.xpath("//*[@id=\"vdList\"]/thead/tr[2]/th[9]/div");
	By editVendorCol = By.xpath("//*[@id=\"vdList\"]/thead/tr[2]/th[10]/div");

	By vendorTable = By.xpath("//*[@id='vdList']");
//	By vendorTable=By.xpath("//td[@class='vendorDTO']");
	
	By vendorAccount=By.xpath("//input[@name='custVendorNum']");
	By vendorName1=By.xpath("//*[text()='Vendor Name']");
	By contactFirstName=By.xpath("//input[@name='firstName']");
	By contactLastName=By.xpath("//input[@name='lastName']");
	By vendorStatus=By.xpath("//select[@name='vendorStatus']");
	By businessComponentReportStatus=By.xpath("//select[@name='businessReportStatus']");
	By businessComponentReportExpiration=By.xpath("//select[@name='vendorExpires']");
	
	

	public void verifyVendorPage() {
		try {
			verifyElementPresence(vendorAccount);
			verifyElementPresence(vendorName1);
			verifyElementPresence(contactFirstName);
			verifyElementPresence(contactLastName);
			verifyElementPresence(vendorStatus);
			verifyElementPresence(businessComponentReportStatus);
			verifyElementPresence(businessComponentReportExpiration);

			logStepInfo("Vendor Verification completed!!!");
			reportLog(Status.PASS,"Vendor Verification completed!!!", true);

			}
			catch(Exception ex)
			{
				logStepInfo("Exception occured in verifyVendorPage():- "+ex.getMessage());
				reportLog(Status.FAIL,"Exception occured in verifyVendorPage():- "+ex.getMessage(), true);
			}
	
	}
}
