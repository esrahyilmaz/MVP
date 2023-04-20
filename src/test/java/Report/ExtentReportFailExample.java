package Report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentReporter;
import org.testng.annotations.Test;

public class ExtentReportFailExample {
	
	public ExtentHtmlReporter reporter;
	public ExtentReports extent;
	public  ExtentTest logger;
	public static int counter;
  @Test
  public void getReport() {
	  
	  
      reporter= new ExtentHtmlReporter("C://Automation1//hello.html");
	  
	  extent=new ExtentReports();
	  
	  extent.attachReporter(reporter);
	  
	  logger=extent.createTest("Login Test");
	  
	  logger.log(Status.INFO, "Login to FADV");
	  
	  logger.log(Status.PASS, "Title verified");
	  
	  extent.flush();
	    
  }
}
