package Report;

import Utility.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import seleniumhelper.BaseClass;
import seleniumhelper.DatabaseClass;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

public class ReportUtils extends BaseClass {

	public static ExtentHtmlReporter reporter = new ExtentHtmlReporter(reportPath + "\\CA_report.html");
	public static ExtentReports extent = new ExtentReports();
	public static ExtentTest repLog;
	private static final String filePath = System.getProperty("user.dir") + "\\output\\Execution_Result.xlsx";
	private static ExcelReader data=new ExcelReader();
	
	public static void createScenario(String scenarioName) {
		extent.attachReporter(reporter);
		repLog = extent.createTest(scenarioName);
		String[] a = scenarioName.split("_");
		String category = a[0];
		repLog.assignCategory(category);
	}

	public String writeExcel(String writeValue) throws Exception {
		InputStream inp = new FileInputStream(filePath);
		Workbook wb = WorkbookFactory.create(inp);
		Sheet sheet = wb.getSheetAt(0);
		Status result = repLog.getStatus();

		int num = sheet.getLastRowNum();
		Row row = sheet.createRow(++num);
		row.createCell(0).setCellValue(CurrentDateTime.getSystemDate());
		row.createCell(1).setCellValue(scenarioName);
		row.createCell(2).setCellValue(result.toString());
		FileOutputStream fileOut = new FileOutputStream(filePath);
		wb.write(fileOut);
		return "str";
	}

	public static void endScenario() throws Exception {
		report.removeTest(test);
		report.flush();
		report.flush();
		extent.flush();
		Status result = repLog.getStatus();
		String status=result.toString();
		if(status.equalsIgnoreCase("pass")) {
			ReportStatus="PASSED";
		}else if(status.equalsIgnoreCase("fail")) {
			ReportStatus="FAILED";
		}
		System.out.println("Report Status is "+ReportStatus);
		String ScenarioNos="1";
		String Date=CurrentDateTime.getDateRepo();
		String Time=CurrentDateTime.getTimeRepo();
		String Module=data.getData("Module");
		String ReportType=PropertyFileReader.getProperty("ReportType");
		ReportUpload.uploadToServer();
		DeleteFile.delete();
		String Project="CA-New";
		String Env="QC-A";
		if(scenarioName.contains("Production")) {
			Project="Sanity";
			Env="PRODUCTION";
			Module="CA-New";
		}
		DatabaseClass.saveReportDB(Project, scenarioName, ReportStatus, Env, Date, Time,Module, ScenarioNos,ReportType);
	}

}
