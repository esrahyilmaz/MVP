package pages;

import Utility.ExcelReader;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import seleniumhelper.BaseClass;

public class CAOrderPage extends BaseClass {
	ExcelReader _dataRepo = new ExcelReader();
	DrugOrder drug=new DrugOrder();
	FingerPrintOrder Fp = new FingerPrintOrder();
	By OrderDetailsLbl = By.xpath("//*[@id='locationNav1']");

	By nextBtn = By.xpath("//*[@id='actionbutton']");
	By continueBtn = By.xpath("//*[@id=\"selfContractorRegistrationForm\"]/table/tbody/tr[13]/td[2]/input");
	By okBtnn=By.xpath("//input[@value='OK']");
	By orderBtn = By.xpath("//*[@id=\"OrderBtn\"]");
	By packageSelectiontxt = By.xpath("/html/body/form/table/tbody/tr[2]/td/b[5]");

	By daysPackageRadioBtn = By.xpath("//*[@id='2621']");
	By daysLOBCheckbox = By.xpath("//*[@id='div_2621']/table/tbody/tr/td/input[2]");

	By BLOREQC1PACKAGERadioBtn = By.xpath("//*[@id='2221']");
	By BLOREQC1PACKAGELOBCheckbox = By.xpath("//*[@id='div_2221']/input");

	By priniciplePackageRadioBtn = By.xpath("//*[@id='4701']");
	By priciplePackageCheckbox = By.xpath("//*[@id='div_4701']/input");
	
	By lmBasicPackageRadioBtn = By.xpath("//*[@id='124']");
	By lmBasicPackageCheckbox = By.xpath("//input[@name='agreed_124']");
	By previousCrimeTxtArea=By.xpath("//textarea[@name='admittedCriminalInfo']");

	By rescreenPackageRadioBtn = By.xpath("//*[@id='4742']");
	By rescreenPackageCheckbox = By.xpath("//*[@id='div_4742']/table/tbody/tr/td/input[2]");

	By lobDemoPackageRadioBtn = By.xpath("//*[@id=\"4941\"]");
	By lobDemoPackageCheckbox = By.xpath("//*[@id=\"div_4941\"]/table/tbody/tr/td/input[2]");

	By abcPackageRadioBtn = By.xpath("//*[@id=\"1263\"]");
	By abcPackageCheckBox1 = By.xpath("//*[@id=\"div_1263\"]/table/tbody/tr/td/input[2]");
	By abcPackageCheckbox2 = By.xpath("//*[@id=\"div_1263\"]/table/tbody/tr/td/input[3]");

	By BGDrugPackageRadioBtn = By.xpath("//*[@id=\"2601\"]");
	By BGDrugPackageCheckbox = By.xpath("//*[@id=\"div_2601\"]/table/tbody/tr/td/input[2]");
	By DrugTestOnlyProdRadioBtn=By.xpath("//*[@id=\"2948\"]");
	By DrugPackageRadioBtn = By.xpath("//*[@id=\"5101\"]");
	By BatchPackageRadioBtn = By.xpath("//*[@id=\"5201\"]");
	By DrugTestOnlyRadioBtn=By.xpath("//*[@id=\"5401\"]");
	By NextBtn=By.xpath("//input[@value='Next']");
	By NEXTBtn=By.xpath("//input[@value='NEXT']");
	By CollectionRadioBtn=By.xpath("(//input[@name='siteId'])[1]");
	By SubmitOrderBtn=By.xpath("//input[@value='SUBMIT ORDER']");
	By KaiserGlobalDrugTestRadioBtn=By.xpath("//*[@id=\"5409\"]");
	By DrugPackageCheckbox=By.xpath("//*[@id=\"div_5101\"]/table/tbody/tr/td/input[2]");
	By BatchPackageCheckbox=By.xpath("//input[@name='agreed_5201']");
	By FingerPrintTestRadioBtn=By.xpath("//*[@id=\"2321\"]");
	By EmailTB=By.xpath("//input[@name='emailAddress']");
	By ConfirmEmailTB=By.xpath("//input[@name='confirmEmailAddress']");
	By PhoneNumberTB=By.xpath("//input[@name='phoneNumber']");
	By GlobalBGOrderRadioBtn=By.xpath("//*[@id=\"8297\"]");
	By testpackRadioBtn = By.xpath("//*[@id=\"4133\"]");
	By testpackCheckbox = By.xpath("//*[@id=\"div_4133\"]/table/tbody/tr/td/input[2]");
	By fingerPrintPackageProdRadiobtn = By.xpath("//*[@id=\"4088\"]");
	By fingerPrintPackage = By.xpath("//*[@id='5102']");
	By fingerPrintCheckbox=By.xpath("//*[@id=\"div_2321\"]/table/tbody/tr/td/input[2]");
	
	By cdlRadioBtn = By.xpath("//*[@id=\"1249\"]");
	By cdlCheckbox = By.xpath("//input[@name='agreed_1249']");
	By crewWMVRRadioBtn = By.xpath("//*[@id=\"5721\"]");
	By crewWMVRCheckbox = By.xpath("//input[@name='agreed_5721']");
	
	By crewPackageRadioBTN=By.xpath("//*[@id=\"4721\"]");
	By crewPackageRadioBTNuat=By.xpath("//*[@id=\"13767\"]");
	By crewPackageCheckbox=By.xpath("//input[@name='agreed_4721']");
	By crewPackageCheckboxuat=By.xpath("//input[@name='agreed_13767']");
	By principlePackageCheckbox=By.xpath("//input[@name='agreed_363']");
	By newYorkPackageCheckbox=By.xpath("//input[@name='agreed_5002']");
	By lowsPackageCheckbox=By.xpath("//input[@name='agreed_5381']");
	
	By cpfDD=By.xpath("//select[contains(@name,'customField')]");
	By customFieldTB=By.xpath("(//input[contains(@name,'customField')])[last()]");
	By principlePackageNonHdRadioBtn=By.xpath("(//input[@name='vevaPackage.packageId'])[1]");
	By newYorkPackageNonHdRadioBtn=By.xpath("(//input[@name='vevaPackage.packageId'])[2]");
	By lowsPackageNonHdRadioBtn=By.xpath("(//input[@name='vevaPackage.packageId'])[2]");
	By amazonPackageRadioBtn=By.xpath("//input[@name='vevaPackage.packageId' and @id='5421']");

	By orderPageLbl = By.xpath("/html/body/table/tbody/tr/td[2]/div[2]");
	By okBtn = By.xpath("//*[@id='mainBody']/div[3]/div[17]/input[1]");
	By scheduleLink = By.xpath("(//a[contains(text(),\"Schedule\")])[1]");
	By orderIDTxt = By.xpath("//*[@id='mainBody']/div[3]/div[3]/b");
	By orderMenuBtn = By.xpath("//*[@id='menuHeaderId']/tbody/tr/td[4]/a");
	By searchBtn = By.xpath("//*[@id='menuOrder']/table/tbody/tr/td/a");
	By orderSearchPageLbl = By.xpath("/html/body/table/tbody/tr/td[2]/div[1]/b");
	By searchOrderBtn = By.xpath("//*[@id=\"orderSearchForm\"]/input[7]");
	By orderIDColumn = By.xpath("/html/body/table/tbody/tr/td[2]/b/table/thead/tr/th[1]/div");
	By orderNameLink = By.xpath("/html/body/table/tbody/tr/td[2]/b/table/tbody/tr[1]/td[2]/a");
	
	By DigitalBadgeOptionalRB=By.xpath("//input[@name='digitalBadgeOptional']");

	/**
	 * @author mishrbik
	 * @category Click on Package Radio Button for each and every page
	 * 
	 **/

	public void clickPackageRadioButton(String radioButton) throws Exception {
		try {
			 
			switch (radioButton) {
			case "LM Basic Package":
				clickElementWithWait(lmBasicPackageRadioBtn, "Clicked on LM Basic Package radio button");
				scrollDown(300);
				clickElementWithWait(lmBasicPackageCheckbox, "clicked on Accept check box");
				clickElement(NextBtn, "Next");
				EnterText(previousCrimeTxtArea, "previous crime", "Test ABC");
				break;
			case "Principal Package":
				clickElementWithWait(priniciplePackageRadioBtn, "Clicked on Priciple Package radio button");
				scrollDown(300);
				clickElementWithWait(priciplePackageCheckbox, "clicked on Accept check box");
				break;
			case "RescreenPkgPrinciple":
				clickElementWithWait(rescreenPackageRadioBtn, "Clicked on RescreenPkgPrinciple Package radio button");
				scrollDown(300);
				clickElementWithWait(rescreenPackageCheckbox, "clicked on Accept check box");
				break;
			case "30Days Package":
				clickElementWithWait(daysPackageRadioBtn, "Clicked on 30 days Package radio button");
				scrollDown(600);
				clickElementWithWait(daysLOBCheckbox, "clicked on Accept check box");
				break;
			case "BLOREQC1PACKAGE":
				clickElementWithWait(BLOREQC1PACKAGERadioBtn, "Clicked on BLOREQC1PACKAGE Package radio button");
				scrollDown(500);
				clickElementWithWait(BLOREQC1PACKAGELOBCheckbox, "clicked on Accept check box");
				break;
			case "LOB Demo Package":
				clickElementWithWait(lobDemoPackageRadioBtn, "Clicked on BLOREQC1PACKAGE Package radio button");
				scrollDown(500);
				clickElementWithWait(lobDemoPackageCheckbox, "clicked on Accept check box");
				break;
			case "abc pack":
				clickElementWithWait(abcPackageRadioBtn, "Clicked on BLOREQC1PACKAGE Package radio button");
				scrollDown(200);
				clickElementWithWait(abcPackageCheckBox1, "clicked on Accept check box");
				clickElementWithWait(abcPackageCheckbox2, "clicked on Accept check box");
				break;
			case "BG+Drug":
				clickElementWithWait(BGDrugPackageRadioBtn, "Clicked on BG+Drug Package radio button");
				scrollDown(200);
				clickElementWithWait(BGDrugPackageCheckbox, "clicked on Accept check box");
				break;
			case "testPack":
				clickElementWithWait(testpackRadioBtn, "Clicked on testPack Package radio button");
				scrollDown(200);
				clickElementWithWait(testpackCheckbox, "clicked on Accept check box");
				break;
			case "DRUG ONLY":
				clickElementWithWait(DrugTestOnlyRadioBtn, "Clicked on Drug test only Package radio button");
				scrollDown(200);
				clickElementWithWait(NextBtn, "Clicked on Next Button");
				drug.schedule();
				clickElementWithWait(NEXTBtn, "Clicked on Next Button");
				if(ShoppingCart.equalsIgnoreCase("N")) {
					clickElementWithWait(SubmitOrderBtn, "Clicked on Submit order button");
				}
				
				break;
			case "GLOBAL":
				clickElementWithWait(KaiserGlobalDrugTestRadioBtn, "Clicked on Global Package radio button");
				scrollDown(200);
				clickElementWithWait(NextBtn, "Clicked on Next Button");
				clickElementWithWait(NEXTBtn, "Clicked on Next Button");
				drug.schedule();
				clickElementWithWait(NEXTBtn, "Clicked on Next Button");
				if(ShoppingCart.equalsIgnoreCase("N")) {
					clickElementWithWait(SubmitOrderBtn, "Clicked on Submit order button");
				}
				break;
			case "FINGERPRINT":
				clickElementWithWait(FingerPrintTestRadioBtn, "Clicked on Global Package radio button");
				scrollDown(200);
				clickElementWithWait(NextBtn, "Clicked on Next Button");
				EnterText(EmailTB, "email", "chandra.shekarg@fadv.com");
				EnterText(ConfirmEmailTB, "Confirm email", "chandra.shekarg@fadv.com");
				EnterText(PhoneNumberTB, "Phone", Random_NumberGenerator(10));
				clickElementWithWait(NEXTBtn, "Clicked on Next Button");
				drug.schedule();
				clickElementWithWait(NEXTBtn, "Clicked on Next Button");
				break;
			case "DRUG":
				clickElementWithWait(DrugPackageRadioBtn, "Clicked on Drug Package radio button");
				scrollDown(200);
//				clickElementWithWait(DrugPackageCheckbox, "clicked on Accept check box");
				break;
			case "BATCH ORDER":
				clickElementWithWait(BatchPackageRadioBtn, "Clicked on Batch Package radio button");
				scrollDown(200);
				clickElementWithWait(BatchPackageCheckbox, "clicked on Accept check box");
				break;
			case "FINGER PRINTING":
				clickElementWithWait(fingerPrintPackage, "click on FINGER Printing package");
				scrollDown(200);
				clickElementWithWait(fingerPrintCheckbox, "clicked on Accept check box");
				break;
			case "Crew Package w/MVR":
				clickElementWithWait(crewWMVRRadioBtn, "Clicked on Crew Package w/MVR Package radio button");
				scrollDown(300);
				clickElementWithWait(crewWMVRCheckbox, "clicked on Accept check box");
				break;
			case "Crew Package":
				clickElementWithWait(crewPackageRadioBTN, "Clicked on Crew Package Package radio button");
				scrollDown(300);
				clickElementWithWait(crewPackageCheckbox, "clicked on Accept check box");
				break;
			case "Crew Package UAT":
				clickElementWithWait(crewPackageRadioBTNuat, "Clicked on Crew Package Package radio button");
				scrollDown(300);
				clickElementWithWait(crewPackageCheckboxuat, "clicked on Accept check box");
				break;
			case "Lows Package":
				clickElementWithWait(lowsPackageNonHdRadioBtn, "Clicked on Lows Package Package radio button");
				scrollDown(300);
				clickElementWithWait(lowsPackageCheckbox, "clicked on Accept check box");
				break;
			case "Principle Package Non HD":
				selectDropDown(cpfDD, "Cat", "Cat");
				EnterText(customFieldTB, "custom field", "1234");
				clickElementWithWait(principlePackageNonHdRadioBtn, "Clicked on Principle Package Package radio button");
				scrollDown(300);
				clickElementWithWait(principlePackageCheckbox, "clicked on Accept check box");
				break;
			case "NewYork Package Non HD":
				selectDropDown(cpfDD, "Cat", "Cat");
				EnterText(customFieldTB, "custom field", "1234");
				if(verifyElementPresence(By.xpath("//input[@checked='checked']"))) {
					scrollDown(300);
					clickElementWithWait(newYorkPackageCheckbox, "clicked on Accept check box");
				}else {
				clickElement(newYorkPackageNonHdRadioBtn, "Clicked on Principle Package Package radio button");
				scrollDown(300);
				clickElementWithWait(newYorkPackageCheckbox, "clicked on Accept check box");
				}
				break;
			case "Drug Test Only":
				clickElementWithWait(DrugTestOnlyProdRadioBtn, "Clicked on Drug test only Package radio button");
				scrollDown(200);
				clickElementWithWait(NextBtn, "Clicked on Next Button");
				String EmailAddress =_dataRepo.getData("Email") ;
				String PhoneNumber=Random_NumberGenerator(10);
				drug.emailAddress(EmailAddress, PhoneNumber);
				drug.schedule();
				clickElementWithWait(NEXTBtn, "Clicked on Next Button");
				break;
			case "GLOBAL PROD":
				clickElementWithWait(GlobalBGOrderRadioBtn, "Clicked on Global Package radio button");
				scrollDown(200);
				clickElementWithWait(NextBtn, "Clicked on Next Button");
				clickElementWithWait(NEXTBtn, "Clicked on Next Button");
				clickElementWithWait(SubmitOrderBtn, "Clicked on Submit order button");
				break;
			case "Fingerprint Package":
				clickElementWithWait(fingerPrintPackageProdRadiobtn, "Clicked on Drug test only Package radio button");
				scrollDown(200);
				clickElementWithWait(NextBtn, "Clicked on Next Button");
				clickElementWithWait(NEXTBtn, "Clicked on Next Button");
				String Race =_dataRepo.getData("Race");
				String EyeColor =_dataRepo.getData("EyeColor");
				String HairColor =_dataRepo.getData("HairColor");
				String PlaceOfBirth =_dataRepo.getData("State");
				String Citizenship =_dataRepo.getData("FPCountry");
				String Dob ="02/21/1990";
				String HeightInFeet =_dataRepo.getData("HeightFT");
				String HeightInInches =_dataRepo.getData("HeightInc");
				String WeightInPounds =_dataRepo.getData("WeightPo");
				String Gender =_dataRepo.getData("Gender");
				String PhotoIdType =_dataRepo.getData("PhotoIdType");
				String PhotoIdIssued =_dataRepo.getData("State");
				String PhotoIdNumber=Random_NumberGenerator(9);
				Fp.schedule(Race, EyeColor, HairColor, PlaceOfBirth, Citizenship, Dob, HeightInFeet, HeightInInches, WeightInPounds, Gender, PhotoIdType, PhotoIdIssued, PhotoIdNumber);
				clickElementWithWait(NEXTBtn, "Clicked on Next Button");				
				break;
			case "CDL":
				clickElementWithWait(cdlRadioBtn, "Clicked on CDL Driver Package radio button");
				scrollDown(300);
				clickElementWithWait(cdlCheckbox, "clicked on Accept check box");
				break;
			case "NewYork Package Non HD Empty":
				selectDropDown(cpfDD, "Cat", "Cat");
				EnterText(customFieldTB, "custom field", "1234");
				break;
			case "AFP XTDForce Package":
				clickElement(amazonPackageRadioBtn, "Clicked on AFP XTDForce Package radio button");
				break;
			default:
				System.out.println("Please enter valid Package Name");
				break;
			}
			logStepInfo("Vendor Verification completed!!!");
			reportLog(Status.PASS,"Vendor Verification completed!!!", true);

			}
			catch(Exception ex)
			{
				logStepInfo("Exception occured in clickPackageRadioButton():- "+ex.getMessage());
				reportLog(Status.FAIL,"Exception occured in clickPackageRadioButton():- "+ex.getMessage(), true);
			}

	}

}
