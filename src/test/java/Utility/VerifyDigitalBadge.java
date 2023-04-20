package Utility;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import seleniumhelper.BaseClass;
import seleniumhelper.DatabaseClass;

public class VerifyDigitalBadge extends BaseClass {

	DatabaseClass database = new DatabaseClass();
	private static String BadgeNumber1 = "";
	private static String BadgeNumber2 = "";

	public void verify(String Vendor) throws Exception {

		String Day = CurrentDateTime.SystemDateDay();
		String Month = CurrentDateTime.SystemDateMonth();
		String Year1 = CurrentDateTime.SystemDateYear();
		int Year2 = Integer.parseInt(Year1);
		int Year = Year2 + 2;
		String Date = Month + " " + Day + ", " + Year;
		System.out.println(Date);

		wait(5);
		if (verifyElementPresence(By.xpath("(//*[contains(.,'" + Date + "')])[last()]"))) {
			reportLog(Status.PASS, "Badge contains Date: " + Date, true);
		} else {
			reportLog(Status.FAIL, "Badge Does not contains Date: " + Date, true);
		}

		if (verifyElementPresence(By.xpath("(//*[contains(.,'" + BadgeNumber + "')])[last()]"))) {
			reportLog(Status.PASS, "Badge contains Badge Number: " + BadgeNumber, true);
		} else {
			reportLog(Status.FAIL, "Badge Does not contains Badge Number: " + BadgeNumber, true);
		}

		if (verifyElementPresence(By.xpath("(//*[contains(.,'" + Vendor + "')])[last()]"))) {
			reportLog(Status.PASS, "Badge contains Vendor: " + Vendor, true);
		} else {
			reportLog(Status.FAIL, "Badge Does not contains Vendor: " + Vendor, true);
		}

		if (verifyElementPresence(By.xpath("(//*[contains(.,'" + existingFirstName + "')])[last()]"))) {
			reportLog(Status.PASS, "Badge contains First Name: " + existingFirstName, true);
		} else {
			reportLog(Status.FAIL, "Badge Does not contains First Name: " + existingFirstName, true);
		}

		if (verifyElementPresence(By.xpath("(//*[contains(.,'" + existingLastName + "')])[last()]"))) {
			reportLog(Status.PASS, "Badge contains Last Name: " + existingLastName, true);
		} else {
			reportLog(Status.FAIL, "Badge Does not contains Last Name: " + existingFirstName, true);
		}

		if (verifyElementPresence(By.xpath("//img[@class='img-responsive']"))) {
			reportLog(Status.PASS, "Badge contains QR Code", true);
		} else {
			reportLog(Status.FAIL, "Badge Does not contains QR Code", true);
		}

		if (verifyElementPresence(By.xpath("//img[@class='main-customer-logo']"))) {
			reportLog(Status.PASS, "Badge contains Logo", true);
		} else {
			reportLog(Status.FAIL, "Badge Does not contains Logo", true);
		}

		if (verifyElementPresence(By.xpath("(//*[contains(.,'Associate')])[last()]"))
				|| verifyElementPresence(By.xpath("(//*[contains(.,'ASSOCIATE')])[last()]"))) {
			reportLog(Status.PASS, "Badge contains 'Associate' ", true);
		} else {
			reportLog(Status.FAIL, "Badge Does not contains 'Associate' ", true);
		}

		if (verifyElementPresence(By.xpath("//img[@class='individual-image']"))) {
			reportLog(Status.PASS, "Badge contains 'Photo' ", true);
		} else {
			reportLog(Status.FAIL, "Badge Does not contains 'Photo' ", true);
		}

		driver.navigate().back();
	}

	public void verifyTable(String BadgeType, String BadgeStatus) throws Exception {

		String OrderDate = CurrentDateTime.SystemDateMMDD();
		String ProcessedDate = CurrentDateTime.SystemDateMMDD();
		String IssueDate = CurrentDateTime.SystemDateMMDD();

		String Day = CurrentDateTime.SystemDateDay();
		String Month = CurrentDateTime.SystemDateMonth1();
		String Year1 = CurrentDateTime.SystemDateYear();
		int Year2 = Integer.parseInt(Year1);
		int Year = Year2 + 2;
		String ExpirationDate = Month + "/" + Day + "/" + Year;

		if (verifyElementPresence(By.xpath(
				"//td[.='" + BadgeType + "']/..//td[.='" + BadgeStatus + "']/..//td[.='" + OrderDate + "']/..//td[.='"
						+ ProcessedDate + "']/..//td[.='" + IssueDate + "']/..//td[.='" + ExpirationDate + "']"))) {
			reportLog(Status.PASS,
					"Badge Type :[" + BadgeType + "] Badge Status :[" + BadgeStatus + "] Order Date :[" + OrderDate
							+ "] Processed Date :[" + ProcessedDate + "] Issue Date :[" + IssueDate
							+ "] Expiration Date :[" + ExpirationDate + "]",
					true);
		} else {
			reportLog(Status.FAIL,
					"Badge Type :[" + BadgeType + "] Badge Status :[" + BadgeStatus + "] Order Date :[" + OrderDate
							+ "] Processed Date :[" + ProcessedDate + "] Issue Date :[" + IssueDate
							+ "] Expiration Date :[" + ExpirationDate + "]",
					true);
		}

	}

	public void verifyTableNonDB(String BadgeStatus) throws Exception {

		String OrderDate = CurrentDateTime.SystemDateMMDD();
		String ProcessedDate = CurrentDateTime.SystemDateMMDD();
		String IssueDate = CurrentDateTime.SystemDateMMDD();

		String Day = CurrentDateTime.SystemDateDay();
		String Month = CurrentDateTime.SystemDateMonth1();
		String Year1 = CurrentDateTime.SystemDateYear();
		int Year2 = Integer.parseInt(Year1);
		int Year = Year2 + 2;
		String ExpirationDate = Month + "/" + Day + "/" + Year;

		if(!(scenarioName.contains("Production"))) {
	        if (verifyElementPresence(By.xpath("//td[.='" + BadgeStatus + "']/..//td[.='" + OrderDate + "']/..//td[.='"
	                      + ProcessedDate + "']/..//td[.='" + IssueDate + "']/..//td[.='" + ExpirationDate + "']"))) {
	               reportLog(Status.PASS,
	                            "Badge Status :[" + BadgeStatus + "] Order Date :[" + OrderDate + "] Processed Date :["
	                                          + ProcessedDate + "] Issue Date :[" + IssueDate + "] Expiration Date :[" + ExpirationDate
	                                          + "]",
	                            true);
	        } else {
	               reportLog(Status.FAIL,
	                            "Badge Status :[" + BadgeStatus + "] Order Date :[" + OrderDate + "] Processed Date :["
	                                          + ProcessedDate + "] Issue Date :[" + IssueDate + "] Expiration Date :[" + ExpirationDate
	                                          + "]",
	                            true);
	        }
	        }else {
	               if (verifyElementPresence(By.xpath("//td[.='" + BadgeStatus + "']/..//td[.='" + OrderDate + "']/..//td[.='"
	                            + ProcessedDate + "']/..//td[.='" + IssueDate + "']"))) {
	                      reportLog(Status.PASS,
	                                   "Badge Status :[" + BadgeStatus + "] Order Date :[" + OrderDate + "] Processed Date :["
	                                                + ProcessedDate + "] Issue Date :[" + IssueDate + "]",
	                                   true);
	               } else {
	                      reportLog(Status.FAIL,
	                                   "Badge Status :[" + BadgeStatus + "] Order Date :[" + OrderDate + "] Processed Date :["
	                                                + ProcessedDate + "] Issue Date :[" + IssueDate + "]",
	                                   true);
	               }
	        }
	}

	public void verifyRescreening(String Vendor) throws Exception {
		String ComplianceStatus = driver
				.findElement(By.xpath("((//td[contains(.,'Compliance Status:')])[last()]/..//td)[last()]")).getText();
		ComplianceStatus = ComplianceStatus.replace(" ", "");
		String BadgeNO = driver
				.findElement(By.xpath("(//td[contains(.,'Badge Number:')])[last()]/..//td[@class='dispValue']"))
				.getText();
		BadgeNumber = BadgeNO.replaceAll(" ", "");
//		DigitalBadgeLink="https://qxtdforce.fadv.net/CA/QRCode/qrId/"+QRcodeUUID;
		DigitalBadgeLink = "https://qcs.fadv.net/CA/QRCode/qrId/" + QRcodeUUID;
		reportLog(Status.INFO, "Badge Link "+DigitalBadgeLink, false);
		
		String Day = CurrentDateTime.SystemDateDay();
		String Month = CurrentDateTime.SystemDateMonth1();
		String Year1 = CurrentDateTime.SystemDateYear();
		int Year2 = Integer.parseInt(Year1);
		int Year = Year2 + 2;
		String Date = Month + "/" + Day + "/" + Year;
		System.out.println(Date);

		driver.get(DigitalBadgeLink);
		wait(5);
		if (verifyElementPresence(By.xpath("(//*[contains(.,'" + Date + "')])[last()]"))) {
			reportLog(Status.PASS, "Badge contains Date: " + Date, true);
		} else {
			reportLog(Status.FAIL, "Badge Does not contains Date: " + Date, true);
		}

		if (verifyElementPresence(By.xpath("(//*[contains(.,'" + BadgeNumber + "')])[last()]"))) {
			reportLog(Status.PASS, "Badge contains Badge Number: " + BadgeNumber, true);
		} else {
			reportLog(Status.FAIL, "Badge Does not contains Badge Number: " + BadgeNumber, true);
		}

		if (verifyElementPresence(By.xpath("(//*[contains(.,'" + Vendor + "')])[last()]"))) {
			reportLog(Status.PASS, "Badge contains Vendor: " + Vendor, true);
		} else {
			reportLog(Status.FAIL, "Badge Does not contains Vendor: " + Vendor, true);
		}

		if (verifyElementPresence(By.xpath("(//*[contains(.,'" + existingFirstName + "')])[last()]"))) {
			reportLog(Status.PASS, "Badge contains First Name: " + existingFirstName, true);
		} else {
			reportLog(Status.FAIL, "Badge Does not contains First Name: " + existingFirstName, true);
		}

		if (verifyElementPresence(By.xpath("(//*[contains(.,'" + existingLastName + "')])[last()]"))) {
			reportLog(Status.PASS, "Badge contains Last Name: " + existingLastName, true);
		} else {
			reportLog(Status.FAIL, "Badge Does not contains Last Name: " + existingFirstName, true);
		}

		if (verifyElementPresence(By.xpath("//img[@class='logo img-responsive']"))) {
			reportLog(Status.PASS, "Badge contains Logo", true);
		} else {
			reportLog(Status.FAIL, "Badge Does not contains Logo", true);
		}

		if (verifyElementPresence(By.xpath("//img[@class='badgePhoto img-responsive']"))||verifyElementPresence(By.xpath("//img[@class='img-responsive']"))) {
			reportLog(Status.PASS, "Badge contains 'Photo' ", true);
		} else {
			reportLog(Status.FAIL, "Badge Does not contains 'Photo' ", true);
		}

		if (ComplianceStatus.equalsIgnoreCase("Compliant")) {

			if (verifyElementPresence(By.xpath("//img[@src='/CA/images/compliant_tag_s.png']"))||verifyElementPresence(By.xpath("//img[@src='/CA/images/compliant_lowes_s.PNG']"))) {
				reportLog(Status.PASS, "Badge contains " + ComplianceStatus, true);
			} else {
				reportLog(Status.FAIL, "Badge Does not contains " + ComplianceStatus, true);
			}

		} else if (ComplianceStatus.equalsIgnoreCase("Non-Compliant") || ComplianceStatus.equalsIgnoreCase("Pending")|| ComplianceStatus.equalsIgnoreCase("In Progress")) {

			if (ComplianceStatus.equalsIgnoreCase("Pending")||ComplianceStatus.equalsIgnoreCase("In Progress")) {
				ComplianceStatus = "Non-Compliant";
			}

			if (verifyElementPresence(By.xpath("//img[@src='/CA/images/non_compliant_tag_s.png']"))||verifyElementPresence(By.xpath("//img[@src='/CA/images/Non_complaint_lowes_s.png']"))) {
				reportLog(Status.PASS, "Badge contains " + ComplianceStatus, true);
			} else {
				reportLog(Status.FAIL, "Badge Does not contains " + ComplianceStatus, true);
			}

		}

		driver.navigate().back();
	}

	public void verifyDigitalBadgeStatus() throws Exception {

		database.getBadgeNumber();
		if (BadgeNumber1.equalsIgnoreCase("")) {
			BadgeNumber1 = BadgeNumber;
		} else {
			BadgeNumber2 = BadgeNumber;
		}
		int Size = driver.findElements(By.xpath("//td[.='DIGITAL']/..//td[.='" + BadgeNumber + "']")).size();
		String UISize = "" + Size;
		String DBSize = database.getSucessCount();

		if (UISize.equalsIgnoreCase(DBSize)) {
			reportLog(Status.PASS, "Number of Emailed Digital Badge in UI [ " + UISize
					+ " ] and Number of Digital Badge Which are Success From DB [ " + DBSize + " ]", false);
		} else {
			reportLog(Status.FAIL, "Number of Emailed Digital Badge in UI [ " + UISize
					+ " ] and Number of Digital Badge Which are Success From DB [ " + DBSize + " ]", false);
		}
	}

	public void verifyBadgeNumber() throws Exception {

		if (!(BadgeNumber1.equalsIgnoreCase(BadgeNumber2))) {
			reportLog(Status.PASS,
					"First Badge Number [ " + BadgeNumber1 + " ] != Second Badge Number [ " + BadgeNumber2 + " ]",
					false);
		} else {
			reportLog(Status.FAIL,
					"First Badge Number [ " + BadgeNumber1 + " ] == Second Badge Number [ " + BadgeNumber2 + " ]",
					false);
		}
	}

	public void verifyDigitalBadgeStatusRescreening(String Physical, String Digital) throws Exception {

		int ActualDigitalSize = driver.findElements(By.xpath("//td[.='DIGITAL']/..//td[.='" + BadgeNumber + "']"))
				.size();
		int ActualPhysicalSize = driver.findElements(By.xpath("//td[.='PHYSICAL']/..//td[.='" + BadgeNumber + "']"))
				.size();
		String UISize = "" + ActualDigitalSize;
		String UISizePhysical = "" + ActualPhysicalSize;
		String DBSize = database.getSucessCount();

		if (UISize.equalsIgnoreCase(DBSize) && UISize.equalsIgnoreCase(Digital) && Digital.equalsIgnoreCase(DBSize)) {
			reportLog(Status.PASS, "Number of Emailed Digital Badge in UI [ " + UISize
					+ " ] and Number of Digital Badge Which are Success From DB [ " + DBSize + " ]", false);
		} else {
			reportLog(Status.FAIL, "Number of Emailed Digital Badge in UI [ " + UISize
					+ " ] and Number of Digital Badge Which are Success From DB [ " + DBSize + " ]", false);
		}

		if (UISizePhysical.equalsIgnoreCase(Physical)) {
			reportLog(Status.PASS, "Number of Physical Badge in UI [ " + UISizePhysical
					+ " ] and Number of Physical Badge Which are Expected [ " + Physical + " ]", false);
		} else {
			reportLog(Status.FAIL, "Number of Physical Badge in UI [ " + UISizePhysical
					+ " ] and Number of Physical Badge Which are Expected [ " + Physical + " ]", false);
		}

		String mailBody = database.getEmailBodyCount();

		if (mailBody.equalsIgnoreCase(Digital)) {
			reportLog(Status.PASS, "Number of Emailed Digital Badge in UI [ " + Digital
					+ " ] and Number of Digital Badge Email Which are Sent From DB [ " + mailBody + " ]", false);
		} else {
			reportLog(Status.FAIL, "Number of Emailed Digital Badge in UI [ " + Digital
					+ " ] and Number of Digital Badge Email Which are Sent From DB [ " + mailBody + " ]", false);
		}
	}
}
