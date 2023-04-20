package pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import seleniumhelper.BaseClass;

public class UpadtePhoto extends BaseClass{

	private By SubmitBadgePhotoBTN= By.xpath("//input[@value='SUBMIT BADGE PHOTO']");
	private By UploadBTN=By.xpath("//input[@value='Upload Photo']");
	private By PreviousBTN=By.xpath("//input[@value='Previous']");
	private By UpdatedStatus=By.xpath("//td[.='UPLOADED']");
	private By CaseStatus=By.xpath("//div[.='Case Status']/../../../..//td[.='Submitted'][last()]");
	private By OkBTN=By.xpath("//input[@value='OK']");
	private By PeopleID=By.xpath("//input[@name='peopleId']");
	private By File=By.xpath("//input[@type='file']");
	public By ResultLink=By.xpath("//div[contains(.,'Name')]/../..//a");
	
	private static String PeopleId="";
	
	public String updatePhoto(String file)
	{	
	
		if(verifyElementPresence(SubmitBadgePhotoBTN)) {
			clickElement(SubmitBadgePhotoBTN, "SubmitBadgePhotoBTN");
		}
		
		if(verifyElementPresence(UploadBTN)) {
			uploadFile(File, "file", file);
			clickElement(UploadBTN, "UploadBTN");
		}
		
		if(verifyElementPresence(PreviousBTN)) {
			clickElement(PreviousBTN, "PreviousBTN");
		}
		
		if(verifyElementPresence(UpdatedStatus)) {
			reportLog(Status.PASS, "Photo Uploaded", true);
		}
		
		if(verifyElementPresence(CaseStatus)) {
			reportLog(Status.PASS, "case status is submitted", true);
		}
		
		if(verifyElementPresence(OkBTN)) {
			clickElement(OkBTN,"OK");
		}
		
		
			this.PeopleId=driver.findElement(PeopleID).getAttribute("value");
			if(!(PeopleId=="")) {
			reportLog(Status.PASS, "PeopleID is "+PeopleId, false);
			}else {
			reportLog(Status.FAIL, "PeopleID is Null", false);	
			}
			if(verifyElementPresence(ResultLink)) {
	        clickElement(ResultLink, "Result Link");
	        }
                     		return PeopleId;
                     		
	}
	
	public String getPeopleID() {
		
		PeopleId=driver.findElement(PeopleID).getAttribute("value");
		if(!(PeopleId=="")) {
		reportLog(Status.PASS, "PeopleID is "+PeopleId, false);
		}else {
		reportLog(Status.FAIL, "PeopleID is Null", false);	
		}
	
	return PeopleId;
}
	
}
