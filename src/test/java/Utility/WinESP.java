//package Utility;
//
//import java.awt.Robot;
//import java.awt.event.KeyEvent;
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import automation.framework.Configs;
//import pages.ReadFile;
//import seleniumhelper.WDComponentObject;
//
//public class WinESP extends WDComponentObject {
//
//	static {
//		try {
//			System.setProperty("webdriver.chrome.driver",
//					System.getProperty("user.dir") + PropertyFileReader.getProperty("chromeDriver.path"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public void executeWinESP() throws Exception {
//
//		FileEditor fe = new FileEditor(); // creating objects
//		ReadFile rf = new ReadFile();
//		WriteFile wf = new WriteFile();
//
//		String path = "C:\\Users\\ShekarCG\\Desktop\\HomeDepo.ahk"; // path of file which need to be editied
//
//		WebDriver driver = new ChromeDriver();
//		driver.get("http://apacblr01xdb01/Citrix/XDQCDEVWeb/"); // launching citrix
//		driver.manage().deleteAllCookies(); // clearing cookies
//		driver.manage().window().maximize(); // maximizing the window
//		driver.findElement(By.xpath("//a[.='Detect Receiver']")).click();
//		Thread.sleep(2000);
//		String command = "cmd /c start C:\\Users\\ShekarCG\\Desktop\\citrix.ahk";
//		Runtime.getRuntime().exec(command); // running aitrix.ahk file from cmd
//		Thread.sleep(2000);
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_F7);
//		Thread.sleep(5000);
//		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("kumamani");
//		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Jamalpur@243731");
//		driver.findElement(By.xpath("//a[.='Log On']")).click();
//		Thread.sleep(2000);
//		robot.keyPress(KeyEvent.VK_F5);
//
//		String Automation_DBUsername = PropertyFileReader.getProperty("AutomationUserID");
//		String Automation_DBPassword = PropertyFileReader.getProperty("AutomationPassword");
//		String Automation_connectionURL = PropertyFileReader.getProperty("AutomationConnection");
//
//		String DBUsername = PropertyFileReader.getProperty("DBUserID");
//		String DBPassword = PropertyFileReader.getProperty("DBPassword");
//		String connectionURL = PropertyFileReader.getProperty("CAConnection");
//
//		Connection dbConn = null;
//		PreparedStatement prepStmt = null;
//		Statement Stmt = null;
//		ResultSet rs = null;
//		String sql = null;
//		String DBOrderId = "";
//
//		try {
//
//			// ***************Fetching Order Reference ID from Automation
//			// DB*************************//
//			Class.forName("com.mysql.jdbc.Driver").newInstance();
//			dbConn = DriverManager.getConnection(Automation_connectionURL, Automation_DBUsername,
//					Automation_DBPassword);
//			dbConn.setAutoCommit(true);
//			sql = "SELECT OrderRefID FROM BDD_CA_OrderID WHERE OrderStatus='In progress'";
//			Stmt = dbConn.createStatement();
//			System.out.println(sql);
//			rs = Stmt.executeQuery(sql);
//			while (rs.next()) {
//				DBOrderId = rs.getString("OrderRefID");
//				System.out.println(DBOrderId);
//			}
//			rs.close();
//			dbConn.close();
//
//			// ***************Replacing Order Reference ID in the AHK
//			// file*************************//
//			String Order = DBOrderId;
//			String read = rf.read(path); // reading file
//			Thread.sleep(1000);
//			String replace = fe.replaceEntities(read, Order); // replacing orderid in file
//			Thread.sleep(1000);
//			wf.write(replace, path); // writing back the edited file to its destination
//			Thread.sleep(105000);
//			String command1 = "cmd /c start C:\\Users\\ShekarCG\\Desktop\\HomeDepo.ahk";
//			Runtime.getRuntime().exec(command1); // running homedepo.ahk file from cmd
//			Thread.sleep(2000);
//			robot.keyPress(KeyEvent.VK_F3);
//			Thread.sleep(415000);
//			// ***************Fetching Order Status from CA DB*************************//
//			String DBOrderStatus = "";
//			String DBOrderScore = "";
//			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
//			dbConn = DriverManager.getConnection(connectionURL, DBUsername, DBPassword);
//			dbConn.setAutoCommit(true);
//			sql = "select VO_CASE_STATUS from VEVA_ORDER where cp_order_uid='" + Order + "'";
//			Stmt = dbConn.createStatement();
//			System.out.println(sql);
//			rs = Stmt.executeQuery(sql);
//			while (rs.next()) {
//				DBOrderStatus = rs.getString("VO_CASE_STATUS");
//				System.out.println(DBOrderStatus);
//			}
//			rs.close();
//			sql = "select VO_CASE_SCORE from VEVA_ORDER where cp_order_uid='" + Order + "'";
//			Stmt = dbConn.createStatement();
//			System.out.println(sql);
//			rs = Stmt.executeQuery(sql);
//			while (rs.next()) {
//				DBOrderScore = rs.getString("VO_CASE_SCORE");
//				System.out.println(DBOrderStatus);
//			}
//			rs.close();
//			dbConn.close();
//			// ***************Reseting Order Reference ID to Order in AHK
//			// file*************************//
//			String read1 = rf.read(path);
//			Thread.sleep(1000);
//			String replace1 = fe.retreive(read1, Order);
//			Thread.sleep(1000);
//			wf.write(replace1, path);
//			// ***************Update Order status in the Automation
//			// DB*************************//
//			if (DBOrderStatus == "Completed" && DBOrderScore == "Y") {
//				Class.forName("com.mysql.jdbc.Driver").newInstance();
//				dbConn = DriverManager.getConnection(Automation_connectionURL, Automation_DBUsername,
//						Automation_DBPassword);
//				dbConn.setAutoCommit(true);
//				sql = "UPDATE BDD_CA_OrderID SET OrderStatus='Completed' WHERE OrderRefID='" + Order + "'";
//				System.out.println(sql);
//				Stmt = dbConn.createStatement();
//				int count = Stmt.executeUpdate(sql);
//				System.out.println("Updated queries: " + count);
//			}
//			rs.close();
//		} catch (SQLException e) {
//			e.getMessage();
//		}
//		String command2 = "cmd /c start C:\\Users\\ShekarCG\\Desktop\\HomeDepoLogout.ahk";
//		Runtime.getRuntime().exec(command2); // running HomeDepoLogout.ahk file from cmd
//		Thread.sleep(2000);
//		robot.keyPress(KeyEvent.VK_F4);
//		driver.quit();
//	}
//
//	public static void main(String[] args) throws Exception {
//		WinESP win = new WinESP();
//		win.executeWinESP();
//	}
//}
