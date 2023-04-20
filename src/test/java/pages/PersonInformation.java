package pages;

import Utility.CurrentDateTime;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import seleniumhelper.BaseClass;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PersonInformation extends BaseClass {

	private By employerTB = By.xpath("//input[@name ='empForm.employerName']");
	private By currentEmployerRbTN = By.xpath("//input[@title ='Yes']");
	private By businessTypeTB = By.xpath("//input[@name='empForm.businessType']");
	private By addressTB = By.xpath("//input[@name='empForm.addressForm.addrLine1']");
	private By cityTB = By.xpath("//input[@name='empForm.addressForm.cityName']");
	private By stateDD = By.xpath("//select[@name='empForm.addressForm.stateCode']");
	private By countryDD = By.xpath("//select[@name='empForm.addressForm.countryCode']");
	private By zipcodeTB = By.xpath("//input[@name='empForm.addressForm.zipCode']");
	private By phoneTB = By.xpath("//input[@name='empForm.phone']");
	private By fromDateTB = By.xpath("//input[@name='empForm.fromDate']");
	private By toDateTB = By.xpath("//input[@name='empForm.toDate']");
	private By tittleTB = By.xpath("//input[@name='empForm.title']");
	private By startingPayTB = By.xpath("//input[@name='empForm.startingPay']");
	private By endingPayTB = By.xpath("//input[@name='empForm.endingPay']");
	private By startingPayTypeDD = By.xpath("//select[@name='empForm.startingPayType']");
	private By endingPayTypeDD = By.xpath("//select[@name='empForm.endingPayType']");
	private By supervisorTB = By.xpath("//input[@name='empForm.supervisorName']");
	private By supervisorTitleTB = By.xpath("//input[@name='empForm.supervisorTitle']");
	private By supervisorPhoneTB = By.xpath("//input[@name='empForm.supervisorPhone']");
	private By supervisorPhoneExtnTB = By.xpath("//input[@name='empForm.supervisorPhoneExt']");
	private By addEmploymentEntryBTN = By.xpath("//input[@value='ADD EMPLOYMENT ENTRY']");
	private By nameTB = By.xpath("//input[@name='refForm.contactName']");
	private By primaryPhoneNumberTB = By.xpath("//input[@name='refForm.primaryPhone']");
	private By alternatePhoneNumberTB = By.xpath("//input[@name='refForm.altPhone']");
	private By primaryPhoneNumberExtnTB = By.xpath("//input[@name='refForm.primaryPhoneExt']");
	private By alternatePhoneNumberExtnTB = By.xpath("//input[@name='refForm.altPhoneExt']");
	private By yearsYouHaveKnownReferenceTB = By.xpath("//input[@name='refForm.yrsAquianted']");
	private By stateReferenceDD = By.xpath("//select[@name='refForm.stateResideIn']");
	private By addReferenceBTN = By.xpath("//input[@value='ADD REFERENCE']");
	private By nextBTN = By.xpath("//input[@value='NEXT']");

	public void addEmploymentInformation(String Employer, String BusinessType, String Address1, String City,
			String State, String Zipcode, String Phone, String FromDate, String ToDate, String Tittle,
			String StartingPay, String EndingPay, String StartingPayType, String EndingPayType, String Supervisor,
			String SupervisorTitle, String SupervisorPhone, String SupervisorPhoneExtn) {

		String value = null;

		value = Employer;
		if (!(value == null) || !(value.isEmpty())) {
			EnterText(employerTB, "Employer", value);
		}

		clickElement(currentEmployerRbTN, "CurrentEmployer");

		value = BusinessType;
		if (!(value == null) || !(value.isEmpty())) {
			EnterText(businessTypeTB, "BusinessType", value);
		}

		value = Address1;
		if (!(value == null) || !(value.isEmpty())) {
			EnterText(addressTB, "Address1", value);
		}

		value = City;
		if (!(value == null) || !(value.isEmpty())) {
			EnterText(cityTB, "City", value);
		}

		value = State;
		if (!(value == null) || !(value.isEmpty())) {
			selectDropDown(stateDD, value, "State");
		}

		value = Zipcode;
		if (!(value == null) || !(value.isEmpty())) {
			EnterText(zipcodeTB, "Zipcode", value);

		}

		value = Phone;
		if (!(value == null) || !(value.isEmpty())) {
			EnterText(phoneTB, "Phone", value);

		}

		value = FromDate;
		if (!(value == null) || !(value.isEmpty())) {
			EnterText(fromDateTB, "FromDate", value);

		}

		value = ToDate;
		if (!(value == null) || !(value.isEmpty())) {
			EnterText(toDateTB, "ToDate", value);

		}

		value = Tittle;
		if (!(value == null) || !(value.isEmpty())) {
			EnterText(tittleTB, "Tittle", value);

		}

		value = StartingPay;
		if (!(value == null) || !(value.isEmpty())) {
			EnterText(startingPayTB, "StartingPay", value);

		}

		value = EndingPay;
		if (!(value == null) || !(value.isEmpty())) {
			EnterText(endingPayTB, "EndingPay", value);

		}

		value = StartingPayType;
		if (!(value == null) || !(value.isEmpty())) {
			selectDropDown(startingPayTypeDD, value, "StartingPayType");
		}

		value = EndingPayType;
		if (!(value == null) || !(value.isEmpty())) {
			selectDropDown(endingPayTypeDD, value, "EndingPayType");
		}

		value = Supervisor;
		if (!(value == null) || !(value.isEmpty())) {
			EnterText(supervisorTB, "Supervisor", value);

		}

		value = SupervisorTitle;
		if (!(value == null) || !(value.isEmpty())) {
			EnterText(supervisorTitleTB, "SupervisorTitle", value);

		}

		value = SupervisorPhone;
		if (!(value == null) || !(value.isEmpty())) {
			EnterText(supervisorPhoneTB, "SupervisorPhone", value);

		}

		value = SupervisorPhoneExtn;
		if (!(value == null) || !(value.isEmpty())) {
			EnterText(supervisorPhoneExtnTB, "SupervisorPhoneExtn", value);

		}
		clickElement(addEmploymentEntryBTN, "Add Employment Entry Button");
	}

	public void referenceInformation(String Name, String PrimaryPhoneNumber, String AlternatePhoneNumber,
			String PrimaryPhoneNumberExtn, String AlternatePhoneNumberExtn, String YearsYouHaveKnownReference,
			String StateReference) {

		String value = null;

		value = Name;
		if (!(value == null) || !(value.isEmpty())) {
			EnterText(nameTB, "Name", value);

		}

		value = PrimaryPhoneNumber;
		if (!(value == null) || !(value.isEmpty())) {
			EnterText(primaryPhoneNumberTB, "PrimaryPhoneNumber", value);

		}

		value = AlternatePhoneNumber;
		if (!(value == null) || !(value.isEmpty())) {
			EnterText(alternatePhoneNumberTB, "AlternatePhoneNumber", value);

		}

		value = PrimaryPhoneNumberExtn;
		if (!(value == null) || !(value.isEmpty())) {
			EnterText(primaryPhoneNumberExtnTB, "PrimaryPhoneNumberExtn", value);

		}

		value = AlternatePhoneNumberExtn;
		if (!(value == null) || !(value.isEmpty())) {
			EnterText(alternatePhoneNumberExtnTB, "AlternatePhoneNumberExtn", value);

		}

		value = YearsYouHaveKnownReference;
		if (!(value == null) || !(value.isEmpty())) {
			EnterText(yearsYouHaveKnownReferenceTB, "YearsYouHaveKnownReference", value);

		}

		value = StateReference;
		if (!(value == null) || !(value.isEmpty())) {
			selectDropDown(stateReferenceDD, value, "StateReference");
		}

		clickElement(addReferenceBTN, "Add Reference");
		clickElement(nextBTN, "Next");
	}

	public void verifyPerson() throws Exception {

		if (verifyElementPresence(By.xpath("(//td[contains(.,'Active')])[last()]"))) {
			if (verifyElementPresence(By.xpath("(//td[contains(.,'Active')])[last()]"))
					&& verifyElementPresence(By.xpath("//input[@value='BEGIN ORDER PROCESS']"))) {
				reportLog(Status.PASS, "Person is Active and Begin Order Process is Present", true);
			} else {
				reportLog(Status.FAIL, "Person is not Active or Begin Order Process is not Present", true);
			}
		} else if (verifyElementPresence(By.xpath("(//td[contains(.,'Inactive')])[last()]"))) {
			if (verifyElementPresence(By.xpath("(//td[contains(.,'Inactive')])[last()]"))
					&& !(verifyElementPresence(By.xpath("//input[@value='BEGIN ORDER PROCESS']")))) {
				reportLog(Status.PASS, "Person is Inactive and Begin Order Process is not Present", true);
			} else {
				reportLog(Status.FAIL, "Person is not Inactive or Begin Order Process is Present", true);
			}
		} else if (verifyElementPresence(By.xpath("(//td[contains(.,'Terminated')])[last()]"))) {
			if (verifyElementPresence(By.xpath("(//td[contains(.,'Terminated')])[last()]"))
					&& !(verifyElementPresence(By.xpath("//input[@value='BEGIN ORDER PROCESS']")))) {
				reportLog(Status.PASS, "Person is Terminated and Begin Order Process is notPresent", true);
			} else {
				reportLog(Status.FAIL, "Person is not Terminated or Begin Order Process is  Present", true);
			}
		}

		String TodayDate1 = CurrentDateTime.SystemDateMMDD().toString();

		if (verifyElementPresence(By.xpath("(//td[contains(.,'Eligible')])[3]"))&& !(scenarioName.contains("THD Customer"))) {
			if (verifyElementPresence(
					By.xpath("(//td[contains(.,'Long Term Non Employee Screen Package')])[2]/..//td[2]"))) {
				String ActualDate1 = driver
						.findElement(
								By.xpath("(//td[contains(.,'Long Term Non Employee Screen Package')])[2]/..//td[2]"))
						.getText();
				/*
				 * if (ActualDate1.compareTo(TodayDate1) > 0) { reportLog(Status.PASS,
				 * "Ordered Date is lesser than Today", true); } else { reportLog(Status.FAIL,
				 * "Ordered Date is not lesser than Today", true); }
				 */
				// Create SimpleDateFormat object
				SimpleDateFormat sdfo = new SimpleDateFormat("MM/DD/YYYY");

				// Get the two dates to be compared
				Date d1 = sdfo.parse(ActualDate1);
				Date d2 = sdfo.parse(TodayDate1);

				// Print the dates
				System.out.println("Date1 : " + sdfo.format(d1));
				System.out.println("Date2 : " + sdfo.format(d2));

				// Compare the dates using compareTo()
				if (d1.compareTo(d2) > 0) {

					// When Date d1 > Date d2
					System.out.println("Date1 is after Date2");
					reportLog(Status.FAIL, "Ordered Date is not lesser than Today", true);
				}

				else if (d1.compareTo(d2) < 0) {

					// When Date d1 < Date d2
					System.out.println("Date1 is before Date2");
					reportLog(Status.PASS, "Ordered Date is lesser than Today", true);
				}

				else if (d1.compareTo(d2) == 0) {

					// When Date d1 = Date d2
					System.out.println("Date1 is equal to Date2");
					reportLog(Status.FAIL, "Ordered Date is not lesser than Today", true);
				}
			}

			if (verifyElementPresence(By.xpath("(//td[contains(.,'Little League Volunteer Package')])[2]/..//td[2]"))) {
				String ActualDate1 = driver
						.findElement(
								By.xpath("(//td[contains(.,'Long Term Non Employee Screen Package')])[2]/..//td[2]"))
						.getText();
				if (ActualDate1.compareTo(TodayDate1) > 0) {
					reportLog(Status.PASS, "Ordered Date is lesser than Today", true);
				} else {
					reportLog(Status.FAIL, "Ordered Date is not lesser than Today", true);
				}
			}

			if (verifyElementPresence(By.xpath("(//td[contains(.,'Compliance Expires:')])[last()]/..//td[last()]"))) {
				String ActualDate2 = driver
						.findElement(By.xpath("(//td[contains(.,'Compliance Expires:')])[last()]/..//td[last()]"))
						.getText();
				// Create SimpleDateFormat object
				SimpleDateFormat sdfo = new SimpleDateFormat("MM/DD/YYYY");

				// Get the two dates to be compared
				Date d1 = sdfo.parse(ActualDate2);
				Date d2 = sdfo.parse(TodayDate1);

				// Print the dates
				System.out.println("Date1 : " + sdfo.format(d1));
				System.out.println("Date2 : " + sdfo.format(d2));

				// Compare the dates using compareTo()
				if (d1.compareTo(d2) > 0) {

					// When Date d1 > Date d2
					System.out.println("Date1 is after Date2");
					reportLog(Status.FAIL, "Compliance Expiry Date is not lesser than Today", true);
				}

				else if (d1.compareTo(d2) < 0) {

					// When Date d1 < Date d2
					System.out.println("Date1 is before Date2");
					reportLog(Status.PASS, "Compliance Expiry Date is lesser than Today", true);
				}

				else if (d1.compareTo(d2) == 0) {

					// When Date d1 = Date d2
					System.out.println("Date1 is equal to Date2");
					reportLog(Status.FAIL, "Compliance Expiry Date is not lesser than Today", true);
				}
			}
		} else if (verifyElementPresence(By.xpath("(//td[contains(.,'APPROVED')])[3]"))&& !(scenarioName.contains("THD Customer"))) {
			if (verifyElementPresence(By.xpath("(//td[contains(.,'Compliance Expires:')])[last()]/..//td[last()]"))) {
				String ActualDate2 = driver
						.findElement(By.xpath("(//td[contains(.,'Compliance Expires:')])[last()]/..//td[last()]"))
						.getText();
				// Create SimpleDateFormat object
				SimpleDateFormat sdfo = new SimpleDateFormat("MM/DD/YYYY");

				// Get the two dates to be compared
				Date d1 = sdfo.parse(ActualDate2);
				Date d2 = sdfo.parse(TodayDate1);

				// Print the dates
				System.out.println("Date1 : " + sdfo.format(d1));
				System.out.println("Date2 : " + sdfo.format(d2));

				// Compare the dates using compareTo()
				if (d1.compareTo(d2) > 0) {

					// When Date d1 > Date d2
					System.out.println("Date1 is after Date2");
					reportLog(Status.PASS, "Compliance Expiry Date is Greater than Today", true);
				}

				else if (d1.compareTo(d2) < 0) {

					// When Date d1 < Date d2
					System.out.println("Date1 is before Date2");
					reportLog(Status.FAIL, "Compliance Expiry Date is Not Greater than Today", true);
				}

				else if (d1.compareTo(d2) == 0) {

					// When Date d1 = Date d2
					System.out.println("Date1 is equal to Date2");
					reportLog(Status.PASS, "Compliance Expiry Date is Equal to Today", true);
				}
			}
		}else if (verifyElementPresence(By.xpath("(//td[contains(.,'Eligible')])[3]"))&& scenarioName.contains("THD Customer")) {
			if (verifyElementPresence(By.xpath("(//td[contains(.,'Compliance Expires:')])[last()]/..//td[last()]"))) {
				String ActualDate2 = driver
						.findElement(By.xpath("(//td[contains(.,'Compliance Expires:')])[last()]/..//td[last()]"))
						.getText();
				// Create SimpleDateFormat object
				SimpleDateFormat sdfo = new SimpleDateFormat("MM/DD/YYYY");

				// Get the two dates to be compared
				Date d1 = sdfo.parse(ActualDate2);
				Date d2 = sdfo.parse(TodayDate1);

				// Print the dates
				System.out.println("Date1 : " + sdfo.format(d1));
				System.out.println("Date2 : " + sdfo.format(d2));
				
				// Compare the dates using compareTo()
				if (d1.compareTo(d2) > 0) {

					// When Date d1 > Date d2
					System.out.println("Date1 is after Date2");
					reportLog(Status.PASS, "Compliance Expiry Date is Greater than Today", true);
				}

				else if (d1.compareTo(d2) < 0) {

					// When Date d1 < Date d2
					System.out.println("Date1 is before Date2");
					reportLog(Status.FAIL, "Compliance Expiry Date is Not Greater than Today", true);
				}

				else if (d1.compareTo(d2) == 0) {

					// When Date d1 = Date d2
					System.out.println("Date1 is equal to Date2");
					reportLog(Status.PASS, "Compliance Expiry Date is Equal to Today", true);
				}
			}
		}
	}
}
