package seleniumhelper;

import Utility.CurrentDateTime;
import Utility.PropertyFileReader;
import Utility.WriteFile;
import com.aventstack.extentreports.Status;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseClass extends BaseClass {
	public static Connection conn;
	public static PreparedStatement prepareStmt;
	public static ResultSet result;
	public static String DBUsername;
	public static String DBPassword;
	public static String connectionURL;
	static String returnValue = null;
	static String dbc;
	static String dbv;
	public static int venUpdate;

	/**
	 * @author shekarcg
	 * @category Used to connect Database
	 ***/

	
	public Connection getDBConnection(String env) throws ClassNotFoundException, IOException {

		try {
			if (env.equalsIgnoreCase("QCA") || env.equalsIgnoreCase("EA") || env.equalsIgnoreCase("BLR_QC1")) {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				DBUsername = PropertyFileReader.getProperty("EAUserID");
				DBPassword = PropertyFileReader.getProperty("EAPassword");
				connectionURL = PropertyFileReader.getProperty("EAConnection");
			
			} else if (env.equalsIgnoreCase("CA")) {
				if(scenarioName.contains("DigitalBadge_")) {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					DBUsername = PropertyFileReader.getProperty("DBUserIDUAT");
					DBPassword = PropertyFileReader.getProperty("DBPasswordUAT");
					connectionURL = PropertyFileReader.getProperty("CAConnectionUAT");
				} else {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					DBUsername = PropertyFileReader.getProperty("DBUserID");
					DBPassword = PropertyFileReader.getProperty("DBPassword");
					connectionURL = PropertyFileReader.getProperty("CAConnection");
				}	
			
			} else if (env.equalsIgnoreCase("Automation")) {
				Class.forName("com.mysql.jdbc.Driver");
				DBUsername = PropertyFileReader.getProperty("AutomationUserID");
				DBPassword = PropertyFileReader.getProperty("AutomationPassword");
				connectionURL = PropertyFileReader.getProperty("AutomationConnection");

			/**
			 * @author marovimo 06/14/2021 -- New DB connections
			 **/	
				
			} else if (env.equalsIgnoreCase("QCS")) {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				DBUsername = PropertyFileReader.getProperty("NewUIQCSUserID");
				DBPassword = PropertyFileReader.getProperty("NewUIQCSPassword");
				connectionURL = PropertyFileReader.getProperty("NewUIQCSConnection");
			}
			
			else if (env.equalsIgnoreCase("QCSA")) {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				DBUsername = PropertyFileReader.getProperty("NewUIQCSAUserID");
				DBPassword = PropertyFileReader.getProperty("NewUIQCSAPassword");
				connectionURL = PropertyFileReader.getProperty("NewUIQCSAConnection");
			}
			
			else if (env.equalsIgnoreCase("QCSB")) {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				DBUsername = PropertyFileReader.getProperty("NewUIQCSBUserID");
				DBPassword = PropertyFileReader.getProperty("NewUIQCSBPassword");
				connectionURL = PropertyFileReader.getProperty("NewUIQCSBConnection");
			}
			
			else if (env.equalsIgnoreCase("UAT")) {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				DBUsername = PropertyFileReader.getProperty("NewUIUATUserID");
				DBPassword = PropertyFileReader.getProperty("NewUIUATPassword");
				connectionURL = PropertyFileReader.getProperty("NewUIUATConnection");
			}
			
			else if (env.equalsIgnoreCase("PROD")) {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				DBUsername = PropertyFileReader.getProperty("NewUIPRODUserID");
				DBPassword = PropertyFileReader.getProperty("NewUIPRODPassword");
				connectionURL = PropertyFileReader.getProperty("NewUIPRODConnection");
			}
			
			conn = DriverManager.getConnection(connectionURL, DBUsername, DBPassword);
			conn.setAutoCommit(true);
			System.err.println("**********************************database Connected**********************************");
			reportLog(Status.PASS, "Succesfully connected to database......" + env, false);
			reportInfo("Successfully connected to database....." + env);
		} catch (SQLException e) {
			e.printStackTrace();
			reportLog(Status.FAIL, "database connectivity failed !!!" + env, false);
			scenarioFailed();
		}
		return conn;
	}

	/**
	 * @author shekarcg
	 * @category Used for fetching database
	 * @param
	 * @return value from Database
	 ***/

	public String DBSelect(String queryName, String input) throws Exception {
		String query = PropertyFileReader.getProperty(queryName);
		System.out.println("query Name is ::" + query);

		try {
			if (conn.isClosed()) {
				System.out.println("connection is closed");

			} else {
				prepareStmt = conn.prepareStatement(query);
				prepareStmt.setString(1, input);
				result = prepareStmt.executeQuery();

				try {
					if (result != null) {
						while (result.next()) {
							returnValue = result.getString(1);
						}
					}
				} catch (SQLException ex) {
					throw new SQLException(ex);
				} catch (Exception ex) {
					throw new Exception(ex);
				}
			}
			return returnValue;
		} catch (Exception e) {
			return e.getMessage();
		}

	}

	/**
	 * @author shekarcg
	 * @category Used for Updating database
	 * @param
	 ***/
	public void DBUpdate(String queryName, String input) throws Exception {
		try {
			String sql = "";
			if (!(PeopleID == null) && queryName.equalsIgnoreCase("update_image_PHOTO_VALID")) {
				sql = "update veva_image set vi_image_status='PHOTO_VALID' where individual_id=" + PeopleID;
			} else {
				sql = PropertyFileReader.getProperty(queryName);
				System.out.println("SQL ::" + sql);
			}

			System.out.println("Order ID is ::" + input);
			if (conn.isClosed()) {
				System.out.println("connection is closed");
				return;
			}
			prepareStmt = conn.prepareStatement(sql);

			if (!(PeopleID == null) && queryName.equalsIgnoreCase("update_image_PHOTO_VALID")) {

			} else {
				prepareStmt.setString(1, input);

			}

			if (queryName.equalsIgnoreCase("update_BDD_CA_OrderID")) {
				String[] scenario = scenarioName.split("_");
				prepareStmt.setString(1, input);
				prepareStmt.setString(2, PropertyFileReader.getProperty("OrderRefID"));
				prepareStmt.setString(3, PropertyFileReader.getProperty("OrderStatus"));
				prepareStmt.setString(4, scenario[1]);
			}
			System.out.println(prepareStmt.toString());

			int iCount = prepareStmt.executeUpdate();

			if (iCount > 0) {
				logStepInfo("Component status updated succesfully " + input);
				reportLog(Status.PASS, "Component status updated succesfully - " + input, false);
			}
		} catch (Exception ex) {
			logStepInfo("Component status not updated succesfully!!!! " + input);
			reportLog(Status.FAIL, "Component status not updated succesfully !!!! " + input, false);
			scenarioFailed();
		}
	}

	public void closeConnection() throws SQLException {
		if (result != null) {
			try {
				result.close();
			} catch (Exception ex) {
				System.out.println("exeption is in ::" + ex);
			}
		}
		if (conn != null) {
			try {
				conn.close();
				System.out
						.println("**********************************database Closed**********************************");
			} catch (Exception ex) {
				System.out.println("exeption is in ::" + ex);
			}
		}
	}

	public static void saveReportDB(String Project, String Scenario_Name, String Status, String Environment,
			String Date, String Time, String Module, String ScenarioNos, String ReportType)
			throws Exception, IOException {
		int count = 1;
		new DatabaseClass().getDBConnection("Automation");
		String sql = "select Status from BDD_Report  where Scenario_Name= ? and Date= ? and Module= ? and ReportType=? and Environment= ?";
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		prepStmt.setString(1, Scenario_Name);
		prepStmt.setString(2, Date);
		prepStmt.setString(3, Module);
		prepStmt.setString(4, ReportType);
		prepStmt.setString(5, Environment);
		result = prepStmt.executeQuery();
		if (result.next()) {
			String sql1 = "update BDD_Report set Status= ?,Time=?, ScenarioNos=?, ServerPath=? where Scenario_Name= ? and Project= ? and Module= ? and Date='"
					+ Date + "'";
			PreparedStatement prepStmt1 = conn.prepareStatement(sql1);
			prepStmt1.setString(1, Status);
			prepStmt1.setString(2, Time);
			prepStmt1.setString(3, ScenarioNos);
			prepStmt1.setString(4, ReportpathServer);
			prepStmt1.setString(5, Scenario_Name);
			prepStmt1.setString(6, Project);
			prepStmt1.setString(7, Module);
			int iCount = prepStmt1.executeUpdate();
			if (iCount > 0) {
				System.out.println("Report Updated");
				count = 2;
			}
		}

		if (count == 1) {
			try {
				String sql1 = "INSERT INTO BDD_Report (Project, Scenario_Name, Status, Environment, Date,Time,Module,ScenarioNos,ReportType,ServerPath)\r\n"
						+ "VALUES (?, ?, ?, ?,'" + Date + "', ?, ?, ?,?,?)";
				PreparedStatement prepStmt1 = conn.prepareStatement(sql1);
				prepStmt1.setString(1, Project);
				prepStmt1.setString(2, Scenario_Name);
				prepStmt1.setString(3, Status);
				prepStmt1.setString(4, Environment);
				prepStmt1.setString(5, Time);
				prepStmt1.setString(6, Module);
				prepStmt1.setString(7, ScenarioNos);
				prepStmt1.setString(8, ReportType);
				prepStmt1.setString(9, ReportpathServer);
				prepStmt1.execute();

			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
		new DatabaseClass().closeConnection();
	}

	public void photoValid(String PeopleID) throws Exception {
		new DatabaseClass().getDBConnection("CA");
		String sql = "UPDATE VEVA_IMAGE\r\n" + "SET VI_IMAGE_STATUS ='PHOTO_VALID' \r\n" + "WHERE individual_id= ? \r\n"
				+ "";
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		prepStmt.setString(1, PeopleID);
		int iCount = prepStmt.executeUpdate();
		if (iCount > 0) {
			reportLog(Status.PASS, "The number of row updated for Photo Valid is : [" + iCount + "]", false);
		} else {
			reportLog(Status.FAIL, "The number of row updated for Photo Valid is : [" + iCount + "]", false);
		}
		new DatabaseClass().closeConnection();
	}

	public void updatePrintBadgeStatus() throws Exception {
		new DatabaseClass().getDBConnection("CA");
		String sql = "update veva_process_schedule s\r\n" + "set\r\n" + "s.vps_start_time = sysdate,\r\n"
				+ "s.vps_end_time = (sysdate + INTERVAL '6' minute), -- vps_end_time > vps_start_time\r\n"
				+ "s.vps_next_run_time = sysdate, -- vps_next_run_time equal to sysdate to kick off job\r\n"
				+ "--s.process_status = 'STOPPED1', -- change process status to STOPPED1 to prevent job from running\r\n"
				+ "s.process_status = 'STOPPED', -- change process status to STOPPED to run job.\r\n"
				+ "s.vps_error_text = null\r\n" + "where \r\n" + "s.process_name in (\r\n" + "'PRINT_BADGE_STAGE'\r\n"
				+ ") \r\n" + "";
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		int iCount = prepStmt.executeUpdate();
		if (iCount > 0) {
			reportLog(Status.PASS, "The number of row updated for Print Badge Status is : [" + iCount + "]", false);
		} else {
			reportLog(Status.FAIL, "The number of row updated for Print Badge Status is : [" + iCount + "]", false);
		}
		new DatabaseClass().closeConnection();
	}

	public void badgeStatus(String orderID) throws Exception {
		new DatabaseClass().getDBConnection("CA");
		String sql = "update veva_badge set vb_badge_status='PRINTED' where order_id= ? AND BADGE_PRINTTYPE = 'NEW' OR BADGE_PRINTTYPE = 'REPLACEMENT'";
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		prepStmt.setString(1, orderID);
		int iCount = prepStmt.executeUpdate();
		if (iCount > 0) {
			reportLog(Status.PASS, "The number of row updated for Badge Status is : [" + iCount + "]", false);
		} else {
			reportLog(Status.FAIL, "The number of row updated for Badge Status is : [" + iCount + "]", false);
		}
		new DatabaseClass().closeConnection();
	}

	public void startJob() throws Exception {
		new DatabaseClass().getDBConnection("CA");
		String sql = "update veva_process_schedule s\r\n" + "set\r\n" + "s.vps_start_time = sysdate,\r\n"
				+ "s.vps_end_time = (sysdate + INTERVAL '6' minute), -- vps_end_time > vps_start_time\r\n"
				+ "s.vps_next_run_time = sysdate, -- vps_next_run_time equal to sysdate to kick off job\r\n"
				+ "--s.process_status = 'STOPPED1', -- change process status to STOPPED1 to prevent job from running\r\n"
				+ "s.process_status = 'STOPPED', -- change process status to STOPPED to run job.\r\n"
				+ "s.vps_error_text = null\r\n" + "where \r\n" + "s.process_name in (\r\n" + "'ORDER_BG_ORDERS'\r\n"
				+ ")\r\n" + "";
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		int iCount = prepStmt.executeUpdate();
		if (iCount > 0) {
			reportLog(Status.PASS, "The number of row updated for Starting Job is : [" + iCount + "]", false);
		} else {
			reportLog(Status.FAIL, "The number of row updated for Starting Job is : [" + iCount + "]", false);
		}
		new DatabaseClass().closeConnection();
	}

	public void getEmailBody(String orderID) throws Exception {
		new DatabaseClass().getDBConnection("CA");
		String sql = "select * from VEVA_EMAIL_LOG  where VEL_PROCESS_NAME='DIGITAL BADGE' and order_id = ?";
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		prepStmt.setString(1, orderID);
		result = prepStmt.executeQuery();
		if (result.next()) {
			String strEmailBody = result.getString("VEL_BODY_CLOB");
			System.out.println(strEmailBody);
			EmailBody = strEmailBody;
			reportLog(Status.PASS, "The Email Body is: [" + strEmailBody + "]", false);
			NotificationSubject=result.getString("VEL_SUBJECT_TX");
			if(NotificationSubject.equalsIgnoreCase("DIGITAL_BADGE_LINK")) {
				reportLog(Status.PASS, "Notification subject is "+NotificationSubject, false);
			}else {
				reportLog(Status.FAIL, "Notification Subject is different", false);
			}
		}else if(scenarioName.contains("NO-Notification")){
			reportLog(Status.PASS, "Digial Badge Clob is not Present ", false);
		} else {
			reportLog(Status.FAIL, "The Email Body is Empty ", false);
		}

		new DatabaseClass().closeConnection();
	}
	
	public String getEmailBodyCount() throws Exception {
		new DatabaseClass().getDBConnection("CA");
		String Count = "";
		String sql = "SELECT COUNT(*) AS COUNT from VEVA_EMAIL_LOG  where VEL_PROCESS_NAME='DIGITAL BADGE' and order_id = ?";
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		prepStmt.setString(1, OrderID);
		result = prepStmt.executeQuery();
		if (result.next()) {
			Count = result.getString("COUNT");
		} else {
			reportLog(Status.FAIL, "The Email Count is Empty ", false);
		}
		new DatabaseClass().closeConnection();
		return Count;
	}

	public void enableDisbaleDigitalBadge(String vendor, String value) throws Exception {
		new DatabaseClass().getDBConnection("CA");
		String sql = "UPDATE VEVA_VENDOR SET ENABLE_DIGITAL_BADGE=? WHERE VV_NAME=?";
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		prepStmt.setString(1, value);
		prepStmt.setString(2, vendor);
		int iCount = prepStmt.executeUpdate();
		if (iCount > 0) {
			reportLog(Status.PASS, "Update Digital Badge Status to " + value + " for the vendor " + vendor, false);
		} else {
			reportLog(Status.FAIL, "The number of row updated for Digital Badge : [" + iCount + "]", false);
		}
		conn.commit();
		new DatabaseClass().closeConnection();
	}

	public void inactiveActiveVendorStatus(String value, String vendor) throws Exception {
		new DatabaseClass().getDBConnection("CA");
		String sql = "UPDATE VEVA_VENDOR SET VV_VENDOR_STATUS=? WHERE VV_NAME=?";
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		prepStmt.setString(1, value);
		prepStmt.setString(2, vendor);
		int iCount = prepStmt.executeUpdate();
		if (iCount > 0) {
			reportLog(Status.PASS, "Update Digital Badge Status to " + value + " for the vendor " + vendor, false);
		} else {
			reportLog(Status.FAIL, "The number of row updated for Digital Badge : [" + iCount + "]", false);
		}
		conn.commit();
		new DatabaseClass().closeConnection();
	}

	public void enableDisbaleDigitalBadgeCustomer(String value1, String value2) throws Exception {
		new DatabaseClass().getDBConnection("CA");
		String sql = "Update VEVA_CUST_PROPERTY SET VCP_VALUE=? WHERE VCP_KEY='ENABLE_DIGITAL_BADGE' AND CUST_ID='1296'";
		if(scenarioName.contains("DigitalBadge_")) {
			sql = "Update VEVA_CUST_PROPERTY SET VCP_VALUE=? WHERE VCP_KEY='ENABLE_DIGITAL_BADGE' AND CUST_ID='2898'";
		}
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		prepStmt.setString(1, value1);
		int iCount = prepStmt.executeUpdate();
		if (iCount > 0) {
			reportLog(Status.PASS, "Update Digital Badge Status to " + value1, false);
		} else {
			reportLog(Status.FAIL, "The number of row updated for Digital Badge : [" + iCount + "]", false);
		}

		String sql2 = "update VEVA_CUST_PROPERTY SET VCP_VALUE=? where vcp_key ='ENABLE_DIGITAL_BADGE_OPTIONAL' and cust_id='1296'";
		if(scenarioName.contains("DigitalBadge_")) {
			sql2 = "update VEVA_CUST_PROPERTY SET VCP_VALUE=? where vcp_key ='ENABLE_DIGITAL_BADGE_OPTIONAL' and cust_id='2898'";
		}
		PreparedStatement prepStmt1 = conn.prepareStatement(sql2);
		prepStmt1.setString(1, value2);
		int iCount1 = prepStmt1.executeUpdate();
		if (iCount1 > 0) {
			reportLog(Status.PASS, "Update Digital Badge Optional Status to " + value2, false);
		} else {
			reportLog(Status.FAIL, "The number of row updated for Digital Badge Optional: [" + iCount + "]", false);
		}
		conn.commit();
		new DatabaseClass().closeConnection();
	}

	public void orderPaidFlag(String orderID, String Expected) throws Exception {
		new DatabaseClass().getDBConnection("CA");
		String sql = "select DIGITAL_BADGE_ORDER_PAID_FLAG from veva_order where order_id = ?";
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		prepStmt.setString(1, orderID);
		result = prepStmt.executeQuery();
		if (result.next()) {
			String data = result.getString("DIGITAL_BADGE_ORDER_PAID_FLAG");
			if (data == null || data.equalsIgnoreCase("N")) {
				data = "null";
			}
			if (data.equalsIgnoreCase(Expected)) {
				reportLog(Status.PASS, "Actual Data of Badge Order Paid Flag is [" + data
						+ "] Expected Data of Badge Order Paid Flag is [" + Expected + "]", false);
			} else {
				reportLog(Status.FAIL, "Actual Data of Badge Order Paid Flag is [" + data
						+ "] Expected Data of Badge Order Paid Flag is [" + Expected + "]", false);
			}
		}

		String sql1 = "select count(*) AS TOTAL from veva_order where order_id = ?";
		PreparedStatement prepStmt1 = conn.prepareStatement(sql1);
		prepStmt1.setString(1, orderID);
		result = prepStmt1.executeQuery();
		if (result.next()) {
			String count = result.getString("TOTAL");
			if (count.equalsIgnoreCase("1")) {
				reportLog(Status.PASS, "Number of rows present is 1", false);
			} else {
				reportLog(Status.FAIL, "Number of rows present might be >1 or <1", false);
			}
		}
		new DatabaseClass().closeConnection();
	}

	public void rescreenUpdate(String order, String OldDate) throws Exception {
		new DatabaseClass().getDBConnection("CA");
		String sql = "update individual_order set order_DATE=? where order_id=?";
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		prepStmt.setString(1, OldDate);
		prepStmt.setString(2, order);
		int iCount = prepStmt.executeUpdate();
		if (iCount > 0) {
			reportLog(Status.PASS, "Update Rescreen date to " + OldDate, false);
		} else {
			reportLog(Status.FAIL, "The number of row updated for Rescreen : [" + iCount + "]", false);
		}
		conn.commit();
		new DatabaseClass().closeConnection();

		new DatabaseClass().getDBConnection("CA");
		String sql1 = "update veva_order set VO_ORDER_DT= ? where order_id=?";
		PreparedStatement prepStmt1 = conn.prepareStatement(sql1);
		prepStmt1.setString(1, OldDate);
		prepStmt1.setString(2, order);
		int iCount1 = prepStmt1.executeUpdate();
		if (iCount1 > 0) {
			reportLog(Status.PASS, "Update Rescreen date to " + OldDate, false);
		} else {
			reportLog(Status.FAIL, "The number of row updated for Rescreen : [" + iCount1 + "]", false);
		}
		conn.commit();
		new DatabaseClass().closeConnection();
		if (!(scenarioName.contains("SC06-E2E-Scenario-CompliantExpiry")
				|| scenarioName.contains("SC07-E2E-Scenario-Inactive"))) {
			new DatabaseClass().getDBConnection("CA");
			String sql2 = "update veva_process_schedule s\r\n" + "set\r\n" + "s.vps_start_time = sysdate,\r\n"
					+ "s.vps_end_time = (sysdate + INTERVAL '6' minute), -- vps_end_time > vps_start_time\r\n"
					+ "s.vps_next_run_time = sysdate, -- vps_next_run_time equal to sysdate to kick off job\r\n"
					+ "--s.process_status = 'STOPPED1', -- change process status to STOPPED1 to prevent job from running\r\n"
					+ "s.process_status = 'STOPPED', -- change process status to STOPPED to run job.\r\n"
					+ "s.vps_error_text = null\r\n" + "where \r\n" + "s.process_name in ('INDIVIDUAL_RESCREENING')";
			PreparedStatement prepStmt2 = conn.prepareStatement(sql2);
			int iCount2 = prepStmt2.executeUpdate();
			if (iCount2 > 0) {
				reportLog(Status.PASS, "Update job for rescreening", false);
			} else {
				reportLog(Status.FAIL, "The number of row updated for Rescreen : [" + iCount2 + "]", false);
			}
			conn.commit();
			new DatabaseClass().closeConnection();
		}

	}

	public void startComplianceJob() throws Exception {
		new DatabaseClass().getDBConnection("CA");
		String Today = CurrentDateTime.getDateComp();
		String sql = "update veva_process_schedule set VPS_NEXT_RUN_TIME= '" + Today
				+ "' WHERE PROCESS_NAME='CREATE_BADGE' OR PROCESS_NAME ='PRINT_BADGE_STAGE'";
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		int iCount = prepStmt.executeUpdate();
		if (iCount > 0) {
			reportLog(Status.PASS, "The number of row updated for Compliance Job is : [" + iCount + "]", false);
		} else {
			reportLog(Status.FAIL, "The number of row updated for Compliance Job is : [" + iCount + "]", false);
		}
		String sql1 = "update veva_process_schedule set process_status='STOPPED' WHERE PROCESS_NAME='CREATE_BADGE' OR PROCESS_NAME ='PRINT_BADGE_STAGE'";
		PreparedStatement prepStmt1 = conn.prepareStatement(sql1);
		int iCount1 = prepStmt1.executeUpdate();
		if (iCount1 > 0) {
			reportLog(Status.PASS, "The number of row updated for Compliance Job is : [" + iCount1 + "]", false);
		} else {
			reportLog(Status.FAIL, "The number of row updated for Compliance Job is : [" + iCount1 + "]", false);
		}
		new DatabaseClass().closeConnection();
	}

	public void getCRWstatus(String custID) throws Exception {
		new DatabaseClass().getDBConnection("CA");
		String sql = "select VCP_VALUE from veva_cust_property c where c.vcp_key in ('CUST_MONITORING_ENABLED_FLAG') AND cust_id = ?";
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		prepStmt.setString(1, custID);
		result = prepStmt.executeQuery();
		if (result.next()) {
			String CRW = result.getString("VCP_VALUE");
			crwValue = CRW;
			reportLog(Status.PASS, "CRW is: [" + CRW + "]", false);
		} else {
			reportLog(Status.FAIL, "CRW is null", false);
		}

		new DatabaseClass().closeConnection();
	}

	public void getLocationID(String Update) throws Exception {
		new DatabaseClass().getDBConnection("CA");
		String sql = "select LOCATION_ID from vendor_individual_association where individual_id = ?";
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		prepStmt.setString(1, PeopleID);
		result = prepStmt.executeQuery();
		if (result.next()) {
			String locID = result.getString("LOCATION_ID");
			LocationID = locID;
			reportLog(Status.PASS, "LocationID is: [" + locID + "]", false);
		} else {
			reportLog(Status.FAIL, "CRW is null", false);
		}

		if (Update.equalsIgnoreCase("YES")) {
			String sql1 = "update vendor_individual_association set LOCATION_ID='' where individual_id=?";
			PreparedStatement prepStmt1 = conn.prepareStatement(sql1);
			prepStmt1.setString(1, PeopleID);
			int iCount = prepStmt1.executeUpdate();
			if (iCount > 0) {
				reportLog(Status.PASS, "LocationID updated to null", false);
			} else {
				reportLog(Status.FAIL, "LocationID is not Updated", false);
			}
		}

		new DatabaseClass().closeConnection();
	}

	public void getOrderByUserModified(String ExpectedOrderBy, String ExpectedUserModified) throws Exception {
		new DatabaseClass().getDBConnection("CA");
		String sql = "select * from veva_order where order_id=?";
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		prepStmt.setString(1, OrderID);
		result = prepStmt.executeQuery();
		if (result.next()) {
			String ActualOrderBy = result.getString("VO_ORDERED_BY");
			String ActualUserModified = result.getString("VO_USER_MODIFIED");

			if (ActualOrderBy.equalsIgnoreCase(ExpectedOrderBy)
					&& ActualUserModified.equalsIgnoreCase(ExpectedUserModified)) {
				reportLog(Status.PASS,
						"Actual Order BY -->[" + ActualOrderBy + "] Expected Order BY-->[" + ExpectedOrderBy
								+ "]  Actual User Modified-->[" + ActualUserModified + "]  Expected User Modified-->["
								+ ExpectedUserModified + "]",
						false);
			} else {
				reportLog(Status.FAIL,
						"Actual Order BY -->[" + ActualOrderBy + "] Expected Order BY-->[" + ExpectedOrderBy
								+ "]  Actual User Modified-->[" + ActualUserModified + "]  Expected User Modified-->["
								+ ExpectedUserModified + "]",
						false);
			}
		} else {
			reportLog(Status.FAIL, "no row present", false);
		}

		new DatabaseClass().closeConnection();
	}

	public void getQRcodeUUID() throws Exception {
		new DatabaseClass().getDBConnection("CA");
		String sql = "select QR_CODE_UUID from veva_badge where individual_id=? ORDER BY BADGE_ID DESC";
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		prepStmt.setString(1, PeopleID);
		result = prepStmt.executeQuery();
		if (result.next()) {
			QRcodeUUID = result.getString("QR_CODE_UUID");

			reportLog(Status.PASS, "QR code UUID " + QRcodeUUID, false);

		} else {
			reportLog(Status.FAIL, "no row present", false);
		}

		new DatabaseClass().closeConnection();
	}

	public void getAdditionalBilling() throws Exception {
		new DatabaseClass().getDBConnection("CA");
		String sql = "select VCP_VALUE from veva_cust_property c where c.vcp_key in ('CUST_ADDTL_BILLING_ENABLED_FLAG') and  c.cust_id = '"+CustID+"'";
		if(scenarioName.contains("DigitalBadge_")) {
			sql = "select VCP_VALUE from veva_cust_property c where c.vcp_key in ('CUST_ADDTL_BILLING_ENABLED_FLAG') and  c.cust_id = '2898'";
		}
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		result = prepStmt.executeQuery();
		if (result.next()) {
			AdditionalBilling = result.getString("VCP_VALUE");

			reportLog(Status.PASS, "Additional Billing" + AdditionalBilling, false);

		} else {
			reportLog(Status.FAIL, "no row present", false);
		}

		new DatabaseClass().closeConnection();
	}

	public void enableDisbaleNYPackage(String value1, String value2) throws Exception {
		new DatabaseClass().getDBConnection("CA");
		String sql = "update veva_package set VV_NEW_YORK_PACKAGE= ? where cust_id =215 and package_id =5002";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		prepStmt.setString(1, value1);
		int iCount = prepStmt.executeUpdate();
		if (iCount > 0) {
			reportLog(Status.PASS, "Updated VV_NEW_YORK_PACKAGE to " + value1, false);
		} else {
			reportLog(Status.FAIL, "The number of row updated for VV_NEW_YORK_PACKAGE : [" + iCount + "]", false);
		}

		String sql2 = "update veva_cust_property set  VCP_VALUE = ? where vcp_key ='ENABLE_NY_PACKAGE' and cust_id =215";
		PreparedStatement prepStmt1 = conn.prepareStatement(sql2);
		prepStmt1.setString(1, value2);
		int iCount1 = prepStmt1.executeUpdate();
		if (iCount1 > 0) {
			reportLog(Status.PASS, "Updated VCP_VALUE to " + value2, false);
		} else {
			reportLog(Status.FAIL, "The number of row updated for VCP_VALUE: [" + iCount1 + "]", false);
		}
		conn.commit();
		new DatabaseClass().closeConnection();
	}

	public void ExpireCompliant() throws Exception {
		String date = CurrentDateTime.geDayBeforetYesterdayDate().toUpperCase();
		new DatabaseClass().getDBConnection("CA");
		String sql = "update veva_individual set VI_COMPL_EXPIRATION_DATE ='" + date + "' where individual_id= ?";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		prepStmt.setString(1, PeopleID);
		int iCount = prepStmt.executeUpdate();
		if (iCount > 0) {
			reportLog(Status.PASS, "Updated Compliance Expiration Date to " + date, false);
		} else {
			reportLog(Status.FAIL, "The number of row updated for Compliance Expiration Date : [" + iCount + "]",
					false);
		}

		conn.commit();
		new DatabaseClass().closeConnection();
	}

	public void updateCompliant() throws Exception {
		new DatabaseClass().getDBConnection("CA");

		String sql2 = "update  veva_individual  set  VI_INDIVIDUAL_COMPL_STATUS='401' where individual_id= ?";
		PreparedStatement prepStmt1 = conn.prepareStatement(sql2);
		prepStmt1.setString(1, PeopleID);
		int iCount1 = prepStmt1.executeUpdate();
		if (iCount1 > 0) {
			reportLog(Status.PASS, "Updated Compliance status  ", false);
		} else {
			reportLog(Status.FAIL, "The number of row updated for Compliance status Update: [" + iCount1 + "]", false);
		}
		conn.commit();
		new DatabaseClass().closeConnection();
	}

	public void startRescreeningJob() throws Exception {
		new DatabaseClass().getDBConnection("CA");
		String sql2 = "update veva_process_schedule s\r\n" + "set\r\n" + "s.vps_start_time = sysdate,\r\n"
				+ "s.vps_end_time = (sysdate + INTERVAL '6' minute), -- vps_end_time > vps_start_time\r\n"
				+ "s.vps_next_run_time = sysdate, -- vps_next_run_time equal to sysdate to kick off job\r\n"
				+ "--s.process_status = 'STOPPED1', -- change process status to STOPPED1 to prevent job from running\r\n"
				+ "s.process_status = 'STOPPED', -- change process status to STOPPED to run job.\r\n"
				+ "s.vps_error_text = null\r\n" + "where \r\n" + "s.process_name in ('INDIVIDUAL_RESCREENING')";
		PreparedStatement prepStmt2 = conn.prepareStatement(sql2);
		int iCount2 = prepStmt2.executeUpdate();
		if (iCount2 > 0) {
			reportLog(Status.PASS, "Update job for rescreening", false);
		} else {
			reportLog(Status.FAIL, "The number of row updated for Rescreen : [" + iCount2 + "]", false);
		}
		conn.commit();
		new DatabaseClass().closeConnection();

	}

	public void getVendorIDFromOrder() throws Exception {
		new DatabaseClass().getDBConnection("CA");
		String sql = "select vendor_id  from veva_order where order_id = ?";
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		prepStmt.setString(1, OrderID);
		result = prepStmt.executeQuery();
		if (result.next()) {
			String vendorid = result.getString("vendor_id");
			VendorID = vendorid;
			reportLog(Status.PASS, "Vendor id for Order :[" + OrderID + "] is [" + vendorid + "]", false);
		} else {
			reportLog(Status.FAIL, "vendor id is null", false);
		}
		new DatabaseClass().closeConnection();
	}
	
	public void getVendorIDFromVendorName() throws Exception {
		new DatabaseClass().getDBConnection("CA");
		String sql = "select VENDOR_ID from veva_vendor where vv_name=?";
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		prepStmt.setString(1, VendorNameNonHD);
		result = prepStmt.executeQuery();
		if (result.next()) {
			String vendorid = result.getString("VENDOR_ID");
			VendorID = vendorid;
			reportLog(Status.PASS, "Vendor id for Vendor Name :[" + VendorNameNonHD + "] is [" + vendorid + "]", false);
		} else {
			reportLog(Status.FAIL, "vendor id is null for "+VendorNameNonHD, false);
		}
		new DatabaseClass().closeConnection();
	}

	public void getCreditCardDetailsGlobal() throws Exception {
		new DatabaseClass().getDBConnection("CA");
		String sql = "select * from veva_transaction_log l where l.vtl_process_name in ('PREAUTH_BGCHECK_ORDER') and l.VTL_DATA1=? order by l.vtl_dt_created desc";
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		prepStmt.setString(1, OrderID);
		result = prepStmt.executeQuery();
		if (result.next()) {
			String AmountCharged = result.getString("VTL_DATA4");
			CreditCardInput = result.getString("VTL_INPUT_CLOB");
			CreditCardOutput = result.getString("VTL_OUTPUT_CLOB");
			String UserName = result.getString("VTL_USER_CREATED");
			String DateCreated = result.getString("VTL_DT_CREATED");
			String PaymentType = result.getString("PAYMENT_TYPE");
			String PaymentStatus = result.getString("PAYMENT_STATUS");
			String InvoiceNumber = result.getString("INVOICE_NB");
			if (!(AmountCharged.equalsIgnoreCase("") || AmountCharged == null)) {
				reportLog(Status.PASS, "Amount Charged is " + AmountCharged, false);
			} else {
				reportLog(Status.FAIL, "Amount Charged is " + AmountCharged, false);
			}
			if (!(CreditCardInput.equalsIgnoreCase("") || CreditCardInput == null)) {
				reportLog(Status.PASS, "CreditCardInput Data is " + CreditCardInput, false);
			} else {
				reportLog(Status.FAIL, "CreditCardInput Data is " + CreditCardInput, false);
			}
			if (!(CreditCardOutput.equalsIgnoreCase("") || CreditCardOutput == null)) {
				reportLog(Status.PASS, "CreditCardOutput Data is " + CreditCardOutput, false);
			} else {
				reportLog(Status.FAIL, "CreditCardOutput Data is " + CreditCardOutput, false);
			}
			if (!(UserName.equalsIgnoreCase("") || UserName == null)) {
				reportLog(Status.PASS, "UserName is " + UserName, false);
			} else {
				reportLog(Status.FAIL, "UserName is " + UserName, false);
			}
			if (!(DateCreated.equalsIgnoreCase("") || DateCreated == null)) {
				reportLog(Status.PASS, "DateCreated is " + DateCreated, false);
			} else {
				reportLog(Status.FAIL, "DateCreated is " + DateCreated, false);
			}
			if (!(PaymentType.equalsIgnoreCase("") || PaymentType == null)) {
				reportLog(Status.PASS, "Payment Type is " + PaymentType, false);
			} else {
				reportLog(Status.FAIL, "Payment Type is " + PaymentType, false);
			}
			if (!(PaymentStatus.equalsIgnoreCase("") || PaymentStatus == null)) {
				reportLog(Status.PASS, "Payment Status is " + PaymentStatus, false);
			} else {
				reportLog(Status.FAIL, "Payment Status is " + PaymentStatus, false);
			}
			if (!(InvoiceNumber.equalsIgnoreCase("") || InvoiceNumber == null)) {
				reportLog(Status.PASS, "Invoice Number is " + InvoiceNumber, false);
			} else {
				reportLog(Status.FAIL, "Invoice Number is " + InvoiceNumber, false);
			}
		} else {
			reportLog(Status.FAIL, "Data is null", false);
		}
		new DatabaseClass().closeConnection();
	}

	public void getCreditCardDetails() throws Exception {
		new DatabaseClass().getDBConnection("CA");
		String sql = "select * from veva_transaction_log l where l.vtl_process_name in ('CHARGE_BGCHECK_ORDER') and l.VTL_DATA1=? order by l.vtl_dt_created desc";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		prepStmt.setString(1, OrderID);
		result = prepStmt.executeQuery();
		if (result.next()) {
			String AmountCharged = result.getString("VTL_DATA4");
			CreditCardInput = result.getString("VTL_INPUT_CLOB");
			CreditCardOutput = result.getString("VTL_OUTPUT_CLOB");
			String UserName = result.getString("VTL_USER_CREATED");
			String DateCreated = result.getString("VTL_DT_CREATED");
			String PaymentType = result.getString("PAYMENT_TYPE");
			String PaymentStatus = result.getString("PAYMENT_STATUS");
			String InvoiceNumber = result.getString("INVOICE_NB");
			if (!(AmountCharged.equalsIgnoreCase("") || AmountCharged == null)) {
				reportLog(Status.PASS, "Amount Charged is " + AmountCharged, false);
			} else {
				reportLog(Status.FAIL, "Amount Charged is " + AmountCharged, false);
			}
			if (!(CreditCardInput.equalsIgnoreCase("") || CreditCardInput == null)) {
				reportLog(Status.PASS, "CreditCardInput Data is " + CreditCardInput, false);
			} else {
				reportLog(Status.FAIL, "CreditCardInput Data is " + CreditCardInput, false);
			}
			if (!(CreditCardOutput.equalsIgnoreCase("") || CreditCardOutput == null)) {
				reportLog(Status.PASS, "CreditCardOutput Data is " + CreditCardOutput, false);
			} else {
				reportLog(Status.FAIL, "CreditCardOutput Data is " + CreditCardOutput, false);
			}
			if (!(UserName.equalsIgnoreCase("") || UserName == null)) {
				reportLog(Status.PASS, "UserName is " + UserName, false);
			} else {
				reportLog(Status.FAIL, "UserName is " + UserName, false);
			}
			if (!(DateCreated.equalsIgnoreCase("") || DateCreated == null)) {
				reportLog(Status.PASS, "DateCreated is " + DateCreated, false);
			} else {
				reportLog(Status.FAIL, "DateCreated is " + DateCreated, false);
			}
			if (!(PaymentType.equalsIgnoreCase("") || PaymentType == null)) {
				reportLog(Status.PASS, "Payment Type is " + PaymentType, false);
			} else {
				reportLog(Status.FAIL, "Payment Type is " + PaymentType, false);
			}
			if (!(PaymentStatus.equalsIgnoreCase("") || PaymentStatus == null)) {
				reportLog(Status.PASS, "Payment Status is " + PaymentStatus, false);
			} else {
				reportLog(Status.FAIL, "Payment Status is " + PaymentStatus, false);
			}
			if (!(InvoiceNumber.equalsIgnoreCase("") || InvoiceNumber == null)) {
				reportLog(Status.PASS, "Invoice Number is " + InvoiceNumber, false);
			} else {
				reportLog(Status.FAIL, "Invoice Number is " + InvoiceNumber, false);
			}
		} else {
			reportLog(Status.FAIL, "Data is null", false);
		}

		new DatabaseClass().closeConnection();
	}

	public void getCreditCardDetailsTranctionID() throws Exception {
		new DatabaseClass().getDBConnection("CA");
		if (scenarioName.contains("DigitalBadge-AddExistingPerson")) {
			String sql = "select INVOICE_NB from veva_badge where order_id = ? and BADGE_PRINTTYPE ='DIGITAL' and TRANSACTION_ID=?";
			PreparedStatement prepStmt = conn.prepareStatement(sql);
			prepStmt.setString(1, OrderID);
			prepStmt.setString(2, TransactionID);
			result = prepStmt.executeQuery();
			if (result.next()) {
				InvoiceNO = result.getString("INVOICE_NB");
			}
		} else {
			String sql = "select INVOICE_NB from veva_badge where order_id = ? and BADGE_PRINTTYPE ='REPLACEMENT' and TRANSACTION_ID=?";
			PreparedStatement prepStmt = conn.prepareStatement(sql);
			prepStmt.setString(1, OrderID);
			prepStmt.setString(2, TransactionID);
			result = prepStmt.executeQuery();
			if (result.next()) {
				InvoiceNO = result.getString("INVOICE_NB");
			}
		}

		String sql1 = "select * from veva_transaction_log l where l.vtl_process_name in ('Replace Badge') and l.invoice_nb = ? order by l.vtl_dt_created desc";
		PreparedStatement prepStmt1 = conn.prepareStatement(sql1);
		prepStmt1.setString(1, InvoiceNO);
		result = prepStmt1.executeQuery();
		if (result.next()) {
			String AmountCharged = result.getString("VTL_DATA4");
			CreditCardInput = result.getString("VTL_INPUT_CLOB");
			CreditCardOutput = result.getString("VTL_OUTPUT_CLOB");
			String UserName = result.getString("VTL_USER_CREATED");
			String DateCreated = result.getString("VTL_DT_CREATED");
			String PaymentType = result.getString("PAYMENT_TYPE");
			String PaymentStatus = result.getString("PAYMENT_STATUS");
			String InvoiceNumber = result.getString("INVOICE_NB");
			if (!(AmountCharged.equalsIgnoreCase("") || AmountCharged == null)) {
				reportLog(Status.PASS, "Amount Charged is " + AmountCharged, false);
			} else {
				reportLog(Status.FAIL, "Amount Charged is " + AmountCharged, false);
			}
			if (!(CreditCardInput.equalsIgnoreCase("") || CreditCardInput == null)) {
				reportLog(Status.PASS, "CreditCardInput Data is " + CreditCardInput, false);
			} else {
				reportLog(Status.FAIL, "CreditCardInput Data is " + CreditCardInput, false);
			}
			if (!(CreditCardOutput.equalsIgnoreCase("") || CreditCardOutput == null)) {
				reportLog(Status.PASS, "CreditCardOutput Data is " + CreditCardOutput, false);
			} else {
				reportLog(Status.FAIL, "CreditCardOutput Data is " + CreditCardOutput, false);
			}
			if (!(UserName.equalsIgnoreCase("") || UserName == null)) {
				reportLog(Status.PASS, "UserName is " + UserName, false);
			} else {
				reportLog(Status.FAIL, "UserName is " + UserName, false);
			}
			if (!(DateCreated.equalsIgnoreCase("") || DateCreated == null)) {
				reportLog(Status.PASS, "DateCreated is " + DateCreated, false);
			} else {
				reportLog(Status.FAIL, "DateCreated is " + DateCreated, false);
			}
			if (!(PaymentType.equalsIgnoreCase("") || PaymentType == null)) {
				reportLog(Status.PASS, "Payment Type is " + PaymentType, false);
			} else {
				reportLog(Status.FAIL, "Payment Type is " + PaymentType, false);
			}
			if (!(PaymentStatus.equalsIgnoreCase("") || PaymentStatus == null)) {
				reportLog(Status.PASS, "Payment Status is " + PaymentStatus, false);
			} else {
				reportLog(Status.FAIL, "Payment Status is " + PaymentStatus, false);
			}
			if (!(InvoiceNumber.equalsIgnoreCase("") || InvoiceNumber == null)) {
				reportLog(Status.PASS, "Invoice Number is " + InvoiceNumber, false);
			} else {
				reportLog(Status.FAIL, "Invoice Number is " + InvoiceNumber, false);
			}
		} else {
			reportLog(Status.FAIL, "Data is null", false);
		}
		new DatabaseClass().closeConnection();
	}

	public void getCreditCardDetailsVendorName() throws Exception {
		new DatabaseClass().getDBConnection("CA");
		String sql = "select * from veva_transaction_log l where l.vtl_process_name in ('VENDOR REGISTRATION') and l.VTL_DATA1=? order by l.vtl_dt_created desc";
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		prepStmt.setString(1, VendorNameNonHD);
		result = prepStmt.executeQuery();
		if (result.next()) {
			String AmountCharged = result.getString("VTL_DATA4");
			CreditCardInput = result.getString("VTL_INPUT_CLOB");
			CreditCardOutput = result.getString("VTL_OUTPUT_CLOB");
			String UserName = result.getString("VTL_USER_CREATED");
			String DateCreated = result.getString("VTL_DT_CREATED");
			String PaymentType = result.getString("PAYMENT_TYPE");
			String PaymentStatus = result.getString("PAYMENT_STATUS");
			String InvoiceNumber = result.getString("INVOICE_NB");
			if (!(AmountCharged.equalsIgnoreCase("") || AmountCharged == null)) {
				reportLog(Status.PASS, "Amount Charged is " + AmountCharged, false);
			} else {
				reportLog(Status.FAIL, "Amount Charged is " + AmountCharged, false);
			}
			if (!(CreditCardInput.equalsIgnoreCase("") || CreditCardInput == null)) {
				reportLog(Status.PASS, "CreditCardInput Data is " + CreditCardInput, false);
			} else {
				reportLog(Status.FAIL, "CreditCardInput Data is " + CreditCardInput, false);
			}
			if (!(CreditCardOutput.equalsIgnoreCase("") || CreditCardOutput == null)) {
				reportLog(Status.PASS, "CreditCardOutput Data is " + CreditCardOutput, false);
			} else {
				reportLog(Status.FAIL, "CreditCardOutput Data is " + CreditCardOutput, false);
			}
			if (!(UserName.equalsIgnoreCase("") || UserName == null)) {
				reportLog(Status.PASS, "UserName is " + UserName, false);
			} else {
				reportLog(Status.FAIL, "UserName is " + UserName, false);
			}
			if (!(DateCreated.equalsIgnoreCase("") || DateCreated == null)) {
				reportLog(Status.PASS, "DateCreated is " + DateCreated, false);
			} else {
				reportLog(Status.FAIL, "DateCreated is " + DateCreated, false);
			}
			if (!(PaymentType.equalsIgnoreCase("") || PaymentType == null)) {
				reportLog(Status.PASS, "Payment Type is " + PaymentType, false);
			} else {
				reportLog(Status.FAIL, "Payment Type is " + PaymentType, false);
			}
			if (!(PaymentStatus.equalsIgnoreCase("") || PaymentStatus == null)) {
				reportLog(Status.PASS, "Payment Status is " + PaymentStatus, false);
			} else {
				reportLog(Status.FAIL, "Payment Status is " + PaymentStatus, false);
			}
			if (!(InvoiceNumber.equalsIgnoreCase("") || InvoiceNumber == null)) {
				reportLog(Status.PASS, "Invoice Number is " + InvoiceNumber, false);
			} else {
				reportLog(Status.FAIL, "Invoice Number is " + InvoiceNumber, false);
			}
		} else {
			reportLog(Status.FAIL, "Data is null", false);
		}
		new DatabaseClass().closeConnection();
	}

	public void updateShoppingCart(String custID, String value) throws Exception {
		new DatabaseClass().getDBConnection("CA");

		String sql2 = "update veva_cust_property set vcp_value =? where vcp_key ='SHOPPING_CART_ENABLED' and cust_id =?";
		PreparedStatement prepStmt1 = conn.prepareStatement(sql2);
		prepStmt1.setString(1, value);
		prepStmt1.setString(2, custID);
		int iCount1 = prepStmt1.executeUpdate();
		if (iCount1 > 0) {
			reportLog(Status.PASS, "Updated Shopping Cart to  " + value, false);
		} else {
			reportLog(Status.FAIL, "The number of row updated for Shopping Cart Update: [" + iCount1 + "]", false);
		}
		conn.commit();
		new DatabaseClass().closeConnection();
	}

	public void getDrugTableDetails() throws Exception {
		new DatabaseClass().getDBConnection("CA");

		String sql = "select * from drug_testing_order where order_id =?";
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		prepStmt.setString(1, OrderID);
		result = prepStmt.executeQuery();
		if (result.next()) {
			String drugOrder = result.getString("DRUG_TESTING_ORDER_ID");
			String orderDate = result.getString("ORDER_DATE");
			String orderStatus = result.getString("ORDER_STATUS");
			String orderCost = result.getString("ORDER_COST");
			String paymentStatus = result.getString("PAYMENT_STATUS");
			String transactionID = result.getString("TRANSACTION_ID");
			String specimenID = result.getString("SPECIMEN_ID");
			String usercreated = result.getString("USER_CREATED");
			String usermodified = result.getString("USER_MODIFIED");
			String dateModified = result.getString("DT_MODIFIED");
			String labConfirmationNumber = result.getString("LAB_CONFIRMATION_NUM");
			String siteID = result.getString("SITE_ID");
			String accountID = result.getString("ACCOUNT_ID");
			String complianceImpact = result.getString("COMPLI_IMPACT_FLAG");
			if (!(drugOrder.equalsIgnoreCase("") || drugOrder == null)) {
				reportLog(Status.PASS, "drugOrder is " + drugOrder, false);
			} else {
				reportLog(Status.FAIL, "drugOrder is " + drugOrder, false);
			}
			if (!(orderDate.equalsIgnoreCase("") || orderDate == null)) {
				reportLog(Status.PASS, "orderDate is " + orderDate, false);
			} else {
				reportLog(Status.FAIL, "orderDate is " + orderDate, false);
			}
			if (!(orderStatus.equalsIgnoreCase("") || orderStatus == null)) {
				reportLog(Status.PASS, "orderStatus is " + orderStatus, false);
			} else {
				reportLog(Status.FAIL, "orderStatus is " + orderStatus, false);
			}
			if (!(orderCost.equalsIgnoreCase("") || orderCost == null)) {
				reportLog(Status.PASS, "orderCost is " + orderCost, false);
			} else {
				reportLog(Status.FAIL, "orderCost is " + orderCost, false);
			}
			if (!(paymentStatus.equalsIgnoreCase("") || paymentStatus == null)) {
				reportLog(Status.PASS, "paymentStatus is " + paymentStatus, false);
			} else {
				reportLog(Status.FAIL, "paymentStatus is " + paymentStatus, false);
			}
			if (!(transactionID.equalsIgnoreCase("") || transactionID == null)) {
				reportLog(Status.PASS, "transactionID is " + transactionID, false);
			} else {
				reportLog(Status.FAIL, "transactionID is " + transactionID, false);
			}
			if (!(specimenID.equalsIgnoreCase("") || specimenID == null)) {
				reportLog(Status.PASS, "specimenID is " + specimenID, false);
			} else {
				reportLog(Status.FAIL, "specimenID is " + specimenID, false);
			}
			if (!(usercreated.equalsIgnoreCase("") || usercreated == null)) {
				reportLog(Status.PASS, "usercreated is " + usercreated, false);
			} else {
				reportLog(Status.FAIL, "usercreated is " + usercreated, false);
			}
			if (!(usermodified.equalsIgnoreCase("") || usermodified == null)) {
				reportLog(Status.PASS, "usermodified is " + usermodified, false);
			} else {
				reportLog(Status.FAIL, "usermodified is " + usermodified, false);
			}
			if (!(dateModified.equalsIgnoreCase("") || dateModified == null)) {
				reportLog(Status.PASS, "dateModified is " + dateModified, false);
			} else {
				reportLog(Status.FAIL, "dateModified is " + dateModified, false);
			}
			if (!(labConfirmationNumber.equalsIgnoreCase("") || labConfirmationNumber == null)) {
				reportLog(Status.PASS, "labConfirmationNumber is " + labConfirmationNumber, false);
			} else {
				reportLog(Status.FAIL, "labConfirmationNumber is " + labConfirmationNumber, false);
			}
			if (!(siteID.equalsIgnoreCase("") || siteID == null)) {
				reportLog(Status.PASS, "siteID is " + siteID, false);
			} else {
				reportLog(Status.FAIL, "siteID is " + siteID, false);
			}
			if (!(accountID.equalsIgnoreCase("") || accountID == null)) {
				reportLog(Status.PASS, "accountID is " + accountID, false);
			} else {
				reportLog(Status.FAIL, "accountID is " + accountID, false);
			}
			if (!(complianceImpact.equalsIgnoreCase("") || complianceImpact == null)) {
				reportLog(Status.PASS, "complianceImpact is " + complianceImpact, false);
			} else {
				reportLog(Status.FAIL, "complianceImpact is " + complianceImpact, false);
			}
		} else {
			reportLog(Status.FAIL, "Data is null", false);
		}
		new DatabaseClass().closeConnection();
	}
	
	public void getFingerPrintDetails() throws Exception {
		new DatabaseClass().getDBConnection("CA");

		String sql = "select * from FINGER_PRINTING_ORDER where order_id =?";
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		prepStmt.setString(1, OrderID);
		result = prepStmt.executeQuery();
		if (result.next()) {
			String FPOrder = result.getString("FINGER_PRINTING_ORDER_ID");
			String orderDate = result.getString("ORDER_DATE");
			String orderStatus = result.getString("ORDER_STATUS");
			String orderCost = result.getString("ORDER_COST");
			String paymentStatus = result.getString("PAYMENT_STATUS");
			String transactionID = result.getString("TRANSACTION_ID");
//			String specimenID = result.getString("SPECIMEN_ID");
			String usercreated = result.getString("USER_CREATED");
			String usermodified = result.getString("USER_MODIFIED");
			String dateModified = result.getString("DT_MODIFIED");
//			String labConfirmationNumber = result.getString("LAB_CONFIRMATION_NUM");
//			String siteID = result.getString("SITE_ID");
			String accountID = result.getString("ACCOUNT_ID");
			String complianceImpact = result.getString("COMPLI_IMPACT_FLAG");
			if (!(FPOrder.equalsIgnoreCase("") || FPOrder == null)) {
				reportLog(Status.PASS, "FPOrder is " + FPOrder, false);
			} else {
				reportLog(Status.FAIL, "FPOrder is " + FPOrder, false);
			}
			if (!(orderDate.equalsIgnoreCase("") || orderDate == null)) {
				reportLog(Status.PASS, "orderDate is " + orderDate, false);
			} else {
				reportLog(Status.FAIL, "orderDate is " + orderDate, false);
			}
			if (!(orderStatus.equalsIgnoreCase("") || orderStatus == null)) {
				reportLog(Status.PASS, "orderStatus is " + orderStatus, false);
			} else {
				reportLog(Status.FAIL, "orderStatus is " + orderStatus, false);
			}
			if (!(orderCost.equalsIgnoreCase("") || orderCost == null)) {
				reportLog(Status.PASS, "orderCost is " + orderCost, false);
			} else {
				reportLog(Status.FAIL, "orderCost is " + orderCost, false);
			}
			if (!(paymentStatus.equalsIgnoreCase("") || paymentStatus == null)) {
				reportLog(Status.PASS, "paymentStatus is " + paymentStatus, false);
			} else {
				reportLog(Status.FAIL, "paymentStatus is " + paymentStatus, false);
			}
			if (!(transactionID.equalsIgnoreCase("") || transactionID == null)) {
				reportLog(Status.PASS, "transactionID is " + transactionID, false);
			} else {
				reportLog(Status.FAIL, "transactionID is " + transactionID, false);
			}
			/*
			 * if (!(specimenID.equalsIgnoreCase("") || specimenID == null)) {
			 * reportLog(Status.PASS, "specimenID is " + specimenID, false); } else {
			 * reportLog(Status.FAIL, "specimenID is " + specimenID, false); }
			 */
			if (!(usercreated.equalsIgnoreCase("") || usercreated == null)) {
				reportLog(Status.PASS, "usercreated is " + usercreated, false);
			} else {
				reportLog(Status.FAIL, "usercreated is " + usercreated, false);
			}
			if (!(usermodified.equalsIgnoreCase("") || usermodified == null)) {
				reportLog(Status.PASS, "usermodified is " + usermodified, false);
			} else {
				reportLog(Status.FAIL, "usermodified is " + usermodified, false);
			}
			if (!(dateModified.equalsIgnoreCase("") || dateModified == null)) {
				reportLog(Status.PASS, "dateModified is " + dateModified, false);
			} else {
				reportLog(Status.FAIL, "dateModified is " + dateModified, false);
			}
			/*
			 * if (!(labConfirmationNumber.equalsIgnoreCase("") || labConfirmationNumber ==
			 * null)) { reportLog(Status.PASS, "labConfirmationNumber is " +
			 * labConfirmationNumber, false); } else { reportLog(Status.FAIL,
			 * "labConfirmationNumber is " + labConfirmationNumber, false); } if
			 * (!(siteID.equalsIgnoreCase("") || siteID == null)) { reportLog(Status.PASS,
			 * "siteID is " + siteID, false); } else { reportLog(Status.FAIL, "siteID is " +
			 * siteID, false); }
			 */
			if (!(accountID.equalsIgnoreCase("") || accountID == null)) {
				reportLog(Status.PASS, "accountID is " + accountID, false);
			} else {
				reportLog(Status.FAIL, "accountID is " + accountID, false);
			}
			if (!(complianceImpact.equalsIgnoreCase("") || complianceImpact == null)) {
				reportLog(Status.PASS, "complianceImpact is " + complianceImpact, false);
			} else {
				reportLog(Status.FAIL, "complianceImpact is " + complianceImpact, false);
			}
		} else {
			reportLog(Status.FAIL, "Data is null", false);
		}
		new DatabaseClass().closeConnection();
	}

	public void getVendorData(String Scenario) throws Exception {
		new DatabaseClass().getDBConnection("Automation");
		String sql = "select * from CA_VendorData where Scenario= ?";
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		prepStmt.setString(1, Scenario);
		result = prepStmt.executeQuery();

		if (result.next()) {
			existingFirstName = result.getString("FirstName");
			if (!(existingFirstName.isEmpty()) || !(existingFirstName == null)) {
				reportLog(Status.PASS, "DB FirstName is : [" + existingFirstName + "]", false);
			} else {
				reportLog(Status.FAIL, "DB is : [" + existingFirstName + "]", false);
			}
			existingLastName = result.getString("LastName");
			if (!(existingLastName.isEmpty()) || !(existingLastName == null)) {
				reportLog(Status.PASS, "DB LastName is : [" + existingLastName + "]", false);
			} else {
				reportLog(Status.FAIL, "DB LastName is : [" + existingLastName + "]", false);
			}

			SSN = result.getString("SSN");
			if (!(SSN.isEmpty()) || !(SSN == null)) {
				reportLog(Status.PASS, "SSN is : [" + SSN + "]", false);
			} else {
				reportLog(Status.FAIL, "SSN is : [" + SSN + "]", false);
			}
		}
		new DatabaseClass().closeConnection();
	}

	public void updateDigitalBadgePrice(String Price) throws Exception {
		new DatabaseClass().getDBConnection("CA");
		String sql2 = "update veva_cust_property set VCP_VALUE=? where vcp_key ='DIGITAL_BADGE_PRICE'";
		PreparedStatement prepStmt2 = conn.prepareStatement(sql2);
		prepStmt2.setString(1, Price);
		int iCount2 = prepStmt2.executeUpdate();
		if (iCount2 > 0) {
			reportLog(Status.PASS, "Digital Badge Price Updated to : " + Price, false);
		} else {
			reportLog(Status.FAIL, "The number of row updated for Digital Badge Price : [" + iCount2 + "]", false);
		}
		conn.commit();
		new DatabaseClass().closeConnection();

	}

	public void deleteEmail() throws Exception {
		new DatabaseClass().getDBConnection("CA");
		String sql1 = "update veva_individual set vi_email='' where individual_id=?";
		PreparedStatement prepStmt1 = conn.prepareStatement(sql1);
		prepStmt1.setString(1, PeopleID);
		int iCount = prepStmt1.executeUpdate();
		if (iCount > 0) {
			reportLog(Status.PASS, "Email Sucessfully Deleted for the peopleID : " + PeopleID, false);
		} else {
			reportLog(Status.FAIL, "Email is not Deleted", false);
		}
		new DatabaseClass().closeConnection();

	}

	public void getBadgeNumber() throws Exception {
		new DatabaseClass().getDBConnection("CA");
		String sql = "select VB_BADGE_NUMBER from VEVA_BADGE where order_id = ?";
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		prepStmt.setString(1, OrderID);
		result = prepStmt.executeQuery();
		if (result.next()) {
			BadgeNumber = result.getString("VB_BADGE_NUMBER");
			reportLog(Status.PASS, "The BadgeNumber for OrderID [ " + OrderID + " ] is: [" + BadgeNumber + "]", false);
		} else {
			reportLog(Status.FAIL, "The Badge Number is Empty ", false);
		}

		new DatabaseClass().closeConnection();
	}

	public String getSucessCount() throws Exception {
		new DatabaseClass().getDBConnection("CA");
		String Total = "";
		String sql = "select COUNT(*) AS TOTAL from VEVA_EMAIL_LOG  where VEL_PROCESS_NAME='DIGITAL BADGE' and order_id = ? and VEL_SEND_STATUS='SUCCESS'";
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		prepStmt.setString(1, OrderID);
		result = prepStmt.executeQuery();
		if (result.next()) {
			Total = result.getString("TOTAL");
			reportLog(Status.PASS,
					"Total Digital Badge Email Sucess for OrderID [ " + OrderID + " ] is: [" + Total + "]", false);
		} else {
			reportLog(Status.FAIL, "The Email Body is Empty ", false);
		}
		new DatabaseClass().closeConnection();
		return Total;
	}
	
	public void savePerformance(String Type) throws  Exception {
		new DatabaseClass().getDBConnection("Automation");
		try {
			String sql1 = "INSERT INTO CA_Performance (UserName, Password, Type)\r\n"
					+ "VALUES (?, ?, ?)";
			PreparedStatement prepStmt1 = conn.prepareStatement(sql1);
			prepStmt1.setString(1, UserIDUserAdmin);
			prepStmt1.setString(2, CurrentPasswordUser);
			prepStmt1.setString(3, Type);
			prepStmt1.execute();

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		new DatabaseClass().closeConnection();
	}
	
	public void getProfileId(String firstName, String lastName, String connDB) throws Exception {
		new DatabaseClass().getDBConnection(connDB);
		String sql = "SELECT da_application_id FROM veva_order \r\n" + 
				"WHERE vo_dt_created =(SELECT MAX(vo_dt_created) \r\n" + 
				"FROM veva_order \r\n" + 
				"WHERE vo_first_name = ? \r\n" + 
				"AND vo_last_name=?) ";
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		prepStmt.setString(1, firstName);
		prepStmt.setString(2, lastName);
		result = prepStmt.executeQuery();
		if (result.next()) {
			profileId = result.getString("da_application_id");
			reportLog(Status.PASS, "Profile id for DB:  "+firstName + lastName, false);
		}
        System.out.println("Profile ID firstName from DB: " + userName);

		new DatabaseClass().closeConnection();
	}
	
	public void getPersonName(String userName, String connDB) throws Exception {
		new DatabaseClass().getDBConnection(DB);
		String sql = "SELECT vu_first_name, vu_last_name FROM veva_user WHERE vu_user_login_id=?; ";
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		prepStmt.setString(1, userName);
		
		result = prepStmt.executeQuery();
		if (result.next()) {
			existingFirstName = result.getString("vu_first_name");
			existingLastName = result.getString("vu_last_name");
			reportLog(Status.PASS, "Position Hire Sucessfully Updated to "+userName , false);

		}
        System.out.println("Profile ID UserName from DB: " + userName);
		new DatabaseClass().closeConnection();
	}
	
	public void getPositionLocation(String orderID) throws Exception {
		new DatabaseClass().getDBConnection("CA");
		String sql = "select VOL_INPUT_CLOB from veva_order_log where order_id = ?";
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		prepStmt.setString(1, orderID);
		result = prepStmt.executeQuery();
		if (result.next()) {
			String data = result.getString("VOL_INPUT_CLOB");
			new WriteFile().write(data, "C:\\temp\\positionLocation.xml");
		}
		new DatabaseClass().closeConnection();
	}
	
	public void updatePositionLocation(String value) throws Exception {
		new DatabaseClass().getDBConnection("CA");
		String sql1 = "UPDATE veva_cust_property SET VCP_VALUE= ? WHERE VCP_KEY = 'POSITION_HIRE_LOCATION_REQUIRED' AND CUST_ID=14";
		PreparedStatement prepStmt1 = conn.prepareStatement(sql1);
		prepStmt1.setString(1, value);
		int iCount = prepStmt1.executeUpdate();
		if (iCount > 0) {
			reportLog(Status.PASS, "Position Hire Sucessfully Updated to "+value, false);
		} else {
			reportLog(Status.FAIL, "No row updated for position Hire", false);
		}
		new DatabaseClass().closeConnection();

	}
	
	public void getPositionLocationIndividual(String ExpectedCountry,String ExpectedState,String ExpectedCity) throws Exception {
		new DatabaseClass().getDBConnection("CA");
		String sql = "select VI_POSITION_COUNTRY,VI_POSITION_STATE, VI_POSITION_CITY from veva_individual where individual_id=?";
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		prepStmt.setString(1, PeopleID);
		result = prepStmt.executeQuery();
		if (result.next()) {
			String Country=result.getString("VI_POSITION_COUNTRY");
			String State=result.getString("VI_POSITION_STATE");
			String City=result.getString("VI_POSITION_CITY");
			if(Country==null) {
				Country="null";
			}
			if(State==null) {
				State="null";
			}
			if(City==null) {
				City="null";
			}
			if(Country.equalsIgnoreCase(ExpectedCountry) && State.equalsIgnoreCase(ExpectedState) && City.equalsIgnoreCase(ExpectedCity)) {
				reportLog(Status.PASS, "Expected Country ["+ExpectedCountry+"] Actual Country ["+Country+"] Expected State ["+ExpectedState+"] Actual State ["+State+"] Expected City ["+ExpectedCity+"] Actual City ["+City+"]", false);
			}else {
				reportLog(Status.FAIL, "Expected Country ["+ExpectedCountry+"] Actual Country ["+Country+"] Expected State ["+ExpectedState+"] Actual State ["+State+"] Expected City ["+ExpectedCity+"] Actual City ["+City+"]", false);
			}
		}
		new DatabaseClass().closeConnection();
	}
	
	public void getLogin(String AccountNumber) throws  Exception {
		new DatabaseClass().getDBConnection("Automation");
		try {
			String sql = "SELECT * FROM fw_Env_Login WHERE Account_Number =?";
			PreparedStatement prepStmt = conn.prepareStatement(sql);
			prepStmt.setString(1, AccountNumber);
			result = prepStmt.executeQuery();
			if (result.next()) {
				userName=result.getString("User_Name");
				password=result.getString("Password");
			}else {
				reportLog(Status.FAIL, "No Account Details found for "+AccountNumber, false);
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		new DatabaseClass().closeConnection();
	}
	
	public void setBillingPreference(String value, String CustID) throws Exception {
		new DatabaseClass().getDBConnection("CA");
		String sql = "Update VEVA_CUST_PROPERTY SET VCP_VALUE=? WHERE VCP_KEY='PROGRAM_PAYMENT_METHOD' AND CUST_ID=?";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		prepStmt.setString(1, value);
		prepStmt.setString(2, CustID);
		int iCount = prepStmt.executeUpdate();
		if (iCount > 0) {
			reportLog(Status.PASS, "Updated Program Payment Method to [" + value+"] for Cust id ["+CustID+"]", false);
		} else {
			reportLog(Status.FAIL, "The number of row updated for Program Payment Method : [" + iCount + "]", false);
		}
		conn.commit();
		new DatabaseClass().closeConnection();
	}
	
	public void setBillingPreferenceVendor(String value, String vendor) throws Exception {
		new DatabaseClass().getDBConnection("CA");
		String sql = "update veva_vendor set PROGRAM_PAYMENT_METHOD =? where vv_name=?";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		prepStmt.setString(1, value);
		prepStmt.setString(2, vendor);
		int iCount = prepStmt.executeUpdate();
		if (iCount > 0) {
			reportLog(Status.PASS, "Updated Program Payment Method to [" + value+"] for Vendor "+vendor, false);
		} else {
			reportLog(Status.FAIL, "The number of row updated for Program Payment Method Vendor: [" + iCount + "]", false);
		}
		conn.commit();
		new DatabaseClass().closeConnection();
	}
	
	public void enableProgramBillng(String value)
			throws Exception, IOException {
		new DatabaseClass().getDBConnection("CA");
		String sql = "select VCP_KEY from veva_cust_property where cust_id=? and VCP_KEY='PROGRAM_PAYMENT_METHOD'";
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		prepStmt.setString(1, value);
		result = prepStmt.executeQuery();
		if (!(result.next())) {
			String sql1 = "insert into veva_cust_property (CUST_ID, VCP_KEY, VCP_VALUE, VEVA_CUST_PROPERTY_ID, USER_CREATED, DT_CREATED, USER_MODIFIED, DT_MODIFIED)\r\n" + 
					"    values (?, 'PROGRAM_PAYMENT_METHOD', 'Credit Card', VEVA_CUST_PROPERTY_ID_sn.nextval, null, null, null, null)";
			PreparedStatement prepStmt1 = conn.prepareStatement(sql1);
			prepStmt1.setString(1, value);
			int iCount = prepStmt1.executeUpdate();
			if (iCount>0) {
				reportLog(Status.PASS, "Inserted property--> Program Payment Method to [" + value+"] Customer ", false);
			}else {
				reportLog(Status.FAIL, "Not inserted property--> Program Payment Method to [" + value+"] Customer ", false);
			}
		}else {
			reportLog(Status.INFO, "Program Billing is already Enabled for  [" + value+"] Customer ", false);
		}
		conn.commit();
		new DatabaseClass().closeConnection();
	}
	
	public void deleteProgramBillng(String value)
			throws Exception, IOException {
		new DatabaseClass().getDBConnection("CA");
		String sql = "select VCP_KEY from veva_cust_property where cust_id=? and VCP_KEY='PROGRAM_PAYMENT_METHOD'";
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		prepStmt.setString(1, value);
		result = prepStmt.executeQuery();
		if (result.next()) {
			String sql1 = "delete from veva_cust_property where cust_id=? and VCP_KEY='PROGRAM_PAYMENT_METHOD'";
			PreparedStatement prepStmt1 = conn.prepareStatement(sql1);
			prepStmt1.setString(1, value);
			int iCount = prepStmt1.executeUpdate();
			if (iCount>0) {
				reportLog(Status.PASS, "Deleted property--> Program Payment Method to [" + value+"] Customer ", false);
			}else {
				reportLog(Status.FAIL, "Not Deleted property--> Program Payment Method to [" + value+"] Customer ", false);
			}
		}else {
			reportLog(Status.INFO, "Program Billing is not present for  [" + value+"] Customer ", false);
		}
		conn.commit();
		new DatabaseClass().closeConnection();
	}
	
	public void updatePackage() throws Exception {
		new DatabaseClass().getDBConnection("CA");
		String sql = "update veva_package set Package_type = 'PKG0001' where package_id='4721'";
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		int iCount = prepStmt.executeUpdate();
		if(iCount > 0) {
				reportLog(Status.PASS,"The number of row updated for Package Update is : [" + iCount + "]",false);
			}else {
				reportLog(Status.FAIL,"The number of row updated for Package Update is : [" + iCount + "]",false);
			}
		new DatabaseClass().closeConnection();
}
	
	public void getEmailBodySubject(String processName,String Email) throws  Exception {
		new DatabaseClass().getDBConnection("CA");
		try {
			String sql = "select * from veva_email_log vel where vel.vel_process_name = ? and VEL_TO_ADDR=? and VEL_SUBJECT_TX like '%Newly Registered Vendor Account.' order by vel.vel_dt_created desc";
			PreparedStatement prepStmt = conn.prepareStatement(sql);
			prepStmt.setString(1, processName);
			prepStmt.setString(2, Email);
			result = prepStmt.executeQuery();
			if (result.next()) {
				NotificationSubject=result.getString("VEL_SUBJECT_TX");
				reportLog(Status.INFO, "Email SUbject is:    "+NotificationSubject, false);
				NotificationEmail=result.getString("VEL_BODY_CLOB");
				reportLog(Status.INFO, "Email Body is:       "+NotificationEmail, false);
			}else {
				reportLog(Status.FAIL, "No Email Details found for "+Email, false);
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		new DatabaseClass().closeConnection();
	}
	
	public void getEmailBodySubjectConfirmRegistration(String processName,String Email) throws  Exception {
		new DatabaseClass().getDBConnection("CA");
		try {
			String sql = "select * from veva_email_log vel where vel.vel_process_name = ? and VEL_TO_ADDR=? and vel.VEL_SUBJECT_TX='XtdForce - Registration Confirmation' order by vel.vel_dt_created desc";
			PreparedStatement prepStmt = conn.prepareStatement(sql);
			prepStmt.setString(1, processName);
			prepStmt.setString(2, Email);
			result = prepStmt.executeQuery();
			if (result.next()) {
				NotificationEmail=result.getString("VEL_BODY_TX");
				reportLog(Status.INFO, "Email Body is:       "+NotificationEmail, false);
			}else {
				reportLog(Status.FAIL, "No Email Details found for "+Email, false);
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		new DatabaseClass().closeConnection();
	}
	
	public String getAgreementText() throws  Exception {
		String Agreement="";
		new DatabaseClass().getDBConnection("CA");
		try {
			String sql = "Select * from veva_agreement_history  where vendor_id=? order by ACKDATE desc";
			PreparedStatement prepStmt = conn.prepareStatement(sql);
			prepStmt.setString(1, VendorID);
			result = prepStmt.executeQuery();
			if (result.next()) {
				Agreement=result.getString("AGREEMENT_TEXT");
				reportLog(Status.INFO, "Agreement Text is Present "+Agreement, false);
			}else {
				reportLog(Status.FAIL, "Agreement Text is not Present", false);
			}		
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		new DatabaseClass().closeConnection();
		return Agreement;			
	}
	
	public void saveNotification() throws  Exception {
		int count = 1;
		new DatabaseClass().getDBConnection("Automation");
		String sql = "select * from XtdForceNotification  where ScenarioName= ?";
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		prepStmt.setString(1, scenarioName+"_verification");
		result = prepStmt.executeQuery();
		if (result.next()) {
			String sql1 = "Update XtdForceNotification SET FirstName=? , LastName=? , UserFirstName=? , UserLastName=? , ComplianceStatus=? , OrderID=? , OrderDate=? , PackageName=? , UserEmail=? WHERE ScenarioName=?";
			PreparedStatement prepStmt1 = conn.prepareStatement(sql1);
			prepStmt1.setString(1, existingFirstName);
			prepStmt1.setString(2, existingLastName);
			prepStmt1.setString(3, NotificationUserFirstName);
			prepStmt1.setString(4, NotificationUserLastName);
			prepStmt1.setString(5, NotificationComplianceStatus);
			prepStmt1.setString(6, OrderID);
			prepStmt1.setString(7, NotificationOrderDate);
			prepStmt1.setString(8, NotificationPackageName);
			prepStmt1.setString(9, NotificationUserEmail);
			prepStmt1.setString(10, scenarioName+"_verification");
			int iCount = prepStmt1.executeUpdate();
			if (iCount > 0) {
				System.out.println("Notification Data Updated");
				count = 2;
			}
		}

		if (count == 1) {
		try {
			String sql1 = "INSERT INTO XtdForceNotification (ScenarioName, FirstName, LastName,UserFirstName,UserLastName,ComplianceStatus,OrderID,OrderDate,PackageName,UserEmail)\r\n"
					+ "VALUES (?, ?, ?,?, ?, ?,?, ?, ?,?)";
			PreparedStatement prepStmt1 = conn.prepareStatement(sql1);
			prepStmt1.setString(1, scenarioName+"_verification");
			prepStmt1.setString(2, existingFirstName);
			prepStmt1.setString(3, existingLastName);
			prepStmt1.setString(4, NotificationUserFirstName);
			prepStmt1.setString(5, NotificationUserLastName);
			prepStmt1.setString(6, NotificationComplianceStatus);
			prepStmt1.setString(7, OrderID);
			prepStmt1.setString(8, NotificationOrderDate);
			prepStmt1.setString(9, NotificationPackageName);
			prepStmt1.setString(10, NotificationUserEmail);
			prepStmt1.execute();

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		}
		new DatabaseClass().closeConnection();
	}
	
	public void getNotificationData() throws  Exception {
		new DatabaseClass().getDBConnection("Automation");
		try {
			String sql = "SELECT * FROM XtdForceNotification WHERE ScenarioName=?";
			PreparedStatement prepStmt = conn.prepareStatement(sql);
			prepStmt.setString(1, scenarioName);
			result = prepStmt.executeQuery();
			if (result.next()) {
				existingFirstName =result.getString("FirstName");
				existingLastName=result.getString("LastName");
				NotificationUserFirstName=result.getString("UserFirstName");
				NotificationUserLastName=result.getString("UserLastName");
				NotificationComplianceStatus=result.getString("ComplianceStatus");
				OrderID=result.getString("OrderID");
				NotificationOrderDate=result.getString("OrderDate");
				NotificationPackageName=result.getString("PackageName");
				NotificationUserEmail=result.getString("UserEmail");	
				reportLog(Status.INFO, "First Name : "+ existingFirstName, false);
				reportLog(Status.INFO, "Last Name : "+existingLastName, false);
				reportLog(Status.INFO, "User First Name : "+NotificationUserFirstName, false);
				reportLog(Status.INFO, "User Last Name : "+NotificationUserLastName, false);
				reportLog(Status.INFO, "Compliance Status : "+NotificationComplianceStatus, false);
				reportLog(Status.INFO, "Order ID : "+OrderID, false);
				reportLog(Status.INFO, "Order Date : "+NotificationOrderDate, false);
				reportLog(Status.INFO, "Package Name : "+NotificationPackageName, false);
				reportLog(Status.INFO, "User Email : "+NotificationUserEmail, false);
			}else {
				reportLog(Status.FAIL, "No Row Present for Scenario Name: "+scenarioName, false);
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		new DatabaseClass().closeConnection();
	}
	
	public void verifyComplianceTable() throws  Exception {
		new DatabaseClass().getDBConnection("CA");
		try {
			String sql = "SELECT * FROM notification_indv_compliance where order_id =?";
			PreparedStatement prepStmt = conn.prepareStatement(sql);
			prepStmt.setString(1, OrderID);
			result = prepStmt.executeQuery();
			if (result.next()) {
				if(existingFirstName.equalsIgnoreCase(result.getString("SUBJECT_FIRSTNAME"))) {
					reportLog(Status.PASS, "Expected First Name: ["+ existingFirstName +"] Actual First Name ["+result.getString("SUBJECT_FIRSTNAME")+"]", false);
				}else {
					reportLog(Status.FAIL, "Expected First Name: ["+ existingFirstName +"] Actual First Name ["+result.getString("SUBJECT_FIRSTNAME")+"]", false);
				}
				if(existingLastName.equalsIgnoreCase(result.getString("SUBJECT_LASTNAME"))) {
					reportLog(Status.PASS, "Expected Last Name: ["+existingLastName+"] Actual Last Name ["+result.getString("SUBJECT_LASTNAME")+"]", false);
				}else {
					reportLog(Status.FAIL, "Expected Last Name: ["+existingLastName+"] Actual Last Name ["+result.getString("SUBJECT_LASTNAME")+"]", false);
				}
				if(OrderID.equalsIgnoreCase(result.getString("ORDER_ID"))) {
					reportLog(Status.PASS, "Expected OrderID ["+OrderID+"] Actual OrderID ["+result.getString("ORDER_ID")+"]", false);
				}else {
					reportLog(Status.FAIL, "Expected OrderID ["+OrderID+"] Actual OrderID ["+result.getString("ORDER_ID")+"]", false);
				}
				String day=NotificationOrderDate.substring(3,5);
				String month=NotificationOrderDate.substring(0, 2);
				String year=NotificationOrderDate.substring(6);
				String OrderDate=year+"-"+month+"-"+day;
				String ActualDate=result.getString("ORDER_DATE").substring(0,10);
				if(OrderDate.equalsIgnoreCase(ActualDate)) {
					reportLog(Status.PASS, "Expected Order Date ["+OrderDate+"] Actual Order Date ["+ActualDate+"]", false);
				}else {
					reportLog(Status.FAIL, "Expected Order Date ["+OrderDate+"] Actual Order Date ["+ActualDate+"]", false);
				}
				NotificationOrderDate=OrderDate;
				if(NotificationUserEmail.equalsIgnoreCase(result.getString("EMAIL_ADDRESS"))) {
					reportLog(Status.PASS, "Expected Email ["+NotificationUserEmail+"] Actual Email ["+result.getString("EMAIL_ADDRESS")+"]", false);
				}else {
					reportLog(Status.FAIL, "Expected Email ["+NotificationUserEmail+"] Actual Email ["+result.getString("EMAIL_ADDRESS")+"]", false);
				}
				if(NotificationComplianceStatus.equalsIgnoreCase(result.getString("COMPLIANCE"))) {
					reportLog(Status.PASS, "Expected Compliance Status ["+NotificationComplianceStatus+"] Actual Compliance Status ["+result.getString("COMPLIANCE")+"]", false);
				}else {
					reportLog(Status.FAIL, "Expected Compliance Status ["+NotificationComplianceStatus+"] Actual Compliance Status ["+result.getString("COMPLIANCE")+"]", false);
				}
				if(result.getString("NOTIFICATION_STATUS").equalsIgnoreCase("FAILED")||result.getString("NOTIFICATION_STATUS").equalsIgnoreCase("SENT")) {
					reportLog(Status.PASS, "Email Has Been Sent and Notification Status is FAILED/SENT", false);
				}else {
					reportLog(Status.FAIL, "Email Has Not Sent and Notification Status is FAILED/SENT", false);
				}
			}else if(scenarioName.contains("NO-Notification")){
				reportLog(Status.PASS, "Compliance Email is not sent to "+NotificationUserEmail, false);
			}else {
				reportLog(Status.FAIL, "No Row Present for OrderID: "+OrderID, false);
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		new DatabaseClass().closeConnection();
	}
	
	public String getEmaillog() throws  Exception {
		String Emaillog="";
		new DatabaseClass().getDBConnection("CA");
		try {
			String sql = "select * from veva_email_log vel where vel.vel_process_name = 'INDV_COMPL_NOTIFICATIONS' and VEL_TO_ADDR=? and vel.ORDER_ID=? order by vel.vel_dt_created ASC";
			PreparedStatement prepStmt = conn.prepareStatement(sql);
			prepStmt.setString(1, NotificationUserEmail);
			prepStmt.setString(2, OrderID);
			result = prepStmt.executeQuery();
			if (result.next()) {
				Emaillog=result.getString("VEL_BODY_CLOB");
				reportLog(Status.INFO, "Email log Text is Present "+Emaillog, false);
				NotificationSubject=result.getString("VEL_SUBJECT_TX");
				if(NotificationSubject.equalsIgnoreCase("First Advantage Notification - Compliance Update")) {
					reportLog(Status.PASS, "Notification subject is "+NotificationSubject, false);
				}else {
					reportLog(Status.FAIL, "Notification Subject is different", false);
				}
			}else if(scenarioName.contains("NO-Notification")){
				reportLog(Status.PASS, "Email is not sent to "+NotificationUserEmail, false);
			}else {
				reportLog(Status.FAIL, "Email log Text is not Present", false);
			}		
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		new DatabaseClass().closeConnection();
		return Emaillog;			
	}
	
	public String getOrderConfirmationClob() throws  Exception {
		String EmailClob="";
		new DatabaseClass().getDBConnection("CA");
		try {
			String sql = "select * from veva_email_log vel where vel.vel_process_name = 'ORDER_CONFIRMATION_EMAIL' and ORDER_ID=? order by vel.vel_dt_created desc";
			PreparedStatement prepStmt = conn.prepareStatement(sql);
			prepStmt.setString(1, OrderID);
			result = prepStmt.executeQuery();
			if (result.next()) {
				EmailClob=result.getString("VEL_BODY_CLOB");
				reportLog(Status.INFO, "Order Confirmation Clob is Present "+EmailClob, false);
				NotificationSubject=result.getString("VEL_SUBJECT_TX");
				if(NotificationSubject.equalsIgnoreCase("XtdForce� - Order Confirmation")) {
					reportLog(Status.PASS, "Notification subject is "+NotificationSubject, false);
				}else {
					reportLog(Status.FAIL, "Notification Subject is different", false);
				}
			}else if(scenarioName.contains("NO-Notification")){
				reportLog(Status.PASS, "Order Confirmation Clob is not Present ", false);
			}else {
				reportLog(Status.FAIL, "Order Confirmation Clob is not Present", false);
			}		
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		new DatabaseClass().closeConnection();
		return EmailClob;			
	}
	
	public String getResetPasswordClob() throws  Exception {
		String ResetPWClob="";
		new DatabaseClass().getDBConnection("CA");
		try {
			String sql = "select * from veva_email_log vel where vel.vel_process_name = 'PASSWORD SETUP' and VEL_TO_ADDR=? order by vel.vel_dt_created desc";
			PreparedStatement prepStmt = conn.prepareStatement(sql);
			prepStmt.setString(1, NotificationUserEmail);
			result = prepStmt.executeQuery();
			if (result.next()) {
				ResetPWClob=result.getString("VEL_BODY_CLOB");
				reportLog(Status.INFO, "Password Reset Clob is Present "+ResetPWClob, false);
				NotificationSubject=result.getString("VEL_SUBJECT_TX");
				if(NotificationSubject.equalsIgnoreCase("XtdForce - Password Reset")) {
					reportLog(Status.PASS, "Notification subject is "+NotificationSubject, false);
				}else {
					reportLog(Status.FAIL, "Notification Subject is different", false);
				}
			}else {
				reportLog(Status.FAIL, "Password Reset Clob is not Present", false);
			}		
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		new DatabaseClass().closeConnection();
		return ResetPWClob;			
	}
	
	public String getPrincipalClob() throws  Exception {
		String PrincipalClob="";
		new DatabaseClass().getDBConnection("CA");
		try {
			String sql = "select * from veva_email_log vel where vel.vel_process_name = 'PRINCIPLECHANGE' and VEL_TO_ADDR=? order by vel.vel_dt_created desc";
			PreparedStatement prepStmt = conn.prepareStatement(sql);
			prepStmt.setString(1, NotificationUserEmail);
			result = prepStmt.executeQuery();
			if (result.next()) {
				PrincipalClob=result.getString("VEL_BODY_CLOB");
				reportLog(Status.INFO, "Principal Clob is Present "+PrincipalClob, false);
				NotificationSubject=result.getString("VEL_SUBJECT_TX");
				if(NotificationSubject.equalsIgnoreCase("PRINICIPAL change notification!")) {
					reportLog(Status.PASS, "Notification subject is "+NotificationSubject, false);
				}else {
					reportLog(Status.FAIL, "Notification Subject is different", false);
				}
			}else if(scenarioName.contains("NO-Notification")){
				reportLog(Status.PASS, "Principal Clob is not Present ", false);
			}else {
				reportLog(Status.FAIL, "Principal CLob is not Present", false);
			}		
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		new DatabaseClass().closeConnection();
		return PrincipalClob;			
	}
	
	public void getOrderOutputLog() throws Exception {
		new DatabaseClass().getDBConnection("CA");
			String sql = "select * from veva_order_log where order_id=? and VOL_USER_CREATED ='API_INTEGRATION'";
			PreparedStatement prepStmt = conn.prepareStatement(sql);
			prepStmt.setString(1, OrderID);
			result = prepStmt.executeQuery();
			if (result.next()) {
				PAOutputLog = result.getString("VOL_OUTPUT_CLOB");
				if (!(PAOutputLog.equalsIgnoreCase("") || PAOutputLog == null)) {
					reportLog(Status.PASS, "Api Order Output is " + PAOutputLog, false);
				} else {
					reportLog(Status.FAIL, "Api Order Output is " + PAOutputLog, false);
				}

			} else {
				reportLog(Status.FAIL, "Data is null", false);
			}
		new DatabaseClass().closeConnection();
	}
	
	public void getOrderRefId() throws Exception {
		new DatabaseClass().getDBConnection("CA");
		String sql = "select CP_ORDER_UID from veva_order where order_id =?";
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		prepStmt.setString(1, OrderID);
		result = prepStmt.executeQuery();
		if (result.next()) {
			OrderRefID = result.getString("CP_ORDER_UID");

			reportLog(Status.PASS, "Order Ref ID" + OrderRefID, false);

		} else {
			reportLog(Status.FAIL, "no row present", false);
		}

		new DatabaseClass().closeConnection();
	}
	
	public String verifyQuotebackValue(String qBName) throws Exception {
		new DatabaseClass().getDBConnection("CA");
		String quoteBackValue="";
		String sql = "select * from order_quoteback where order_id =? and name=?";
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		prepStmt.setString(1, OrderID);
		prepStmt.setString(2, qBName);
		result = prepStmt.executeQuery();
		if (result.next()) {
			quoteBackValue = result.getString("VALUE");
			reportLog(Status.PASS, "Quoteback Value is stored for : " + OrderID, false);
			

		} else {
			quoteBackValue="Empty";
			reportLog(Status.PASS, "Quoteback Value is Not stored for : " + OrderID, false);
			
		}
		new DatabaseClass().closeConnection();
		return quoteBackValue;
	}
	
	public void updatePositionLocationDynamic(String value, String custId) throws Exception {
		new DatabaseClass().getDBConnection("CA");
		String sql1 = "UPDATE veva_cust_property SET VCP_VALUE= ? WHERE VCP_KEY = 'POSITION_HIRE_LOCATION_REQUIRED' AND CUST_ID=?";
		PreparedStatement prepStmt1 = conn.prepareStatement(sql1);
		prepStmt1.setString(1, value);
		prepStmt1.setString(2, custId);
		int iCount = prepStmt1.executeUpdate();
		if (iCount > 0) {
			reportLog(Status.PASS, "Position Hire Sucessfully Updated to "+value, false);
		} else {
			reportLog(Status.FAIL, "No row updated for position Hire", false);
		}
		new DatabaseClass().closeConnection();

	}
	
	public void getDigitalBadgeEnableDisabled() throws Exception {
		new DatabaseClass().getDBConnection("CA");
		String sql1 = "select vcp_value from veva_cust_property where VCP_KEY ='ENABLE_DIGITAL_BADGE' and cust_id=1296";
		PreparedStatement prepStmt = conn.prepareStatement(sql1);
		result = prepStmt.executeQuery();
		if (result.next()) {
			dbc = result.getString("VCP_VALUE");
			reportLog(Status.PASS, "Rows present", false);
			if (dbc.equalsIgnoreCase("Y")) {
				sendBadgeStatus="EMAILED";
				logStepInfo("The Digital badge is enabled both at customer or vendor level : " +dbc+dbv );
			} else if (dbc.equalsIgnoreCase("N")) {
				sendBadgeStatus="PRINTED";
				logStepInfo("The Digital badge is not enabled both at customer or vendor level : " +dbc+dbv );
			} 
		} else {
			reportLog(Status.FAIL, "no row present", false);
		}
		new DatabaseClass().closeConnection();
		enableDisbaleDigitalBadge("THD Demo CA", dbc);
	}
	
	public void updateXtdforceApiProgram(String value, String custId) throws Exception {
		new DatabaseClass().getDBConnection("CA");
		String sql1 = "UPDATE VEVA_CUST_PROPERTY SET VCP_VALUE= ? WHERE VCP_KEY = 'XTDFORCE_API_PROGRAM' AND CUST_ID=?";
		PreparedStatement prepStmt1 = conn.prepareStatement(sql1);
		prepStmt1.setString(1, value);
		prepStmt1.setString(2, custId);
		int iCount = prepStmt1.executeUpdate();
		if (iCount > 0) {
			reportLog(Status.PASS, "Xtdforce Api Program is Sucessfully Updated to "+value, false);
		} else {
			reportLog(Status.FAIL, "No row updated for position Hire", false);
		}
		new DatabaseClass().closeConnection();

	}
	
	public void setPromocode() throws Exception {
		SSN=Random_NumberGenerator(9);
		EmailID="Automation."+Random_StringGenerator(5)+"@fadv.com";
		Promocode1="00GDBVC"+Random_NumberGenerator(4);
		Promocode2="MROHT5VCD"+Random_NumberGenerator(4);
		reportLog(Status.INFO, "SSN is "+SSN+"<br>Email ID is "+EmailID+"<br>Promocode1 is "+Promocode1+"<br>Promocode2 is "+Promocode2+"", false);
		try {
		new DatabaseClass().getDBConnection("CA");
		String sql = "INSERT INTO VOUCHER_CODES(APP_SSN,APP_FIRST_NAME,app_last_name,app_dob,app_email,app_addr1,app_addr2,app_city,APP_STATE_CODE,APP_ZIP_CODE,VOUCHER_CODE1_STATUS,VOUCHER_CODE2_STATUS,VOUCHER_CODE1,\r\n" + 
				"    VOUCHER_CODE2,VOUCH_CODE1_USED_DT,VOUCH_CODE2_USED_DT,USER_CREATED,DT_CREATED,USER_MODIFIED,DT_MODIFIED)\r\n" + 
				"  VALUES\r\n" + 
				"  (?,'Mind','Tree52','01-JAN-1990',?,'100 Carillon Pkwy','','Saint Petersburg','FL','33716','Y','Y',?,?,\r\n" + 
				"    NULL,NULL,NULL,NULL,NULL,NULL)";
		PreparedStatement prepStmt1 = conn.prepareStatement(sql);
		prepStmt1.setString(1, SSN);
		prepStmt1.setString(2, EmailID);
		prepStmt1.setString(3, Promocode1);
		prepStmt1.setString(4, Promocode2);
		prepStmt1.execute();
		
		new DatabaseClass().closeConnection();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void validatePromocodeDB() throws Exception {
		new DatabaseClass().getDBConnection("CA");
		String sql = "select * from voucher_codes where app_ssn = ?";
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		prepStmt.setString(1, SSN);
		result = prepStmt.executeQuery();
		if (result.next()) {
			String ActualDate1 = result.getString("VOUCH_CODE1_USED_DT");
			String ActualDate2 = result.getString("VOUCH_CODE2_USED_DT");
			String ExpectedDate=CurrentDateTime.getDateRepo();
			if(ActualDate1.contains(ExpectedDate)) {
				reportLog(Status.PASS, "Promocode Voucher code "+Promocode1+" Applied date is "+ActualDate1, false);
			}else {
				reportLog(Status.FAIL, "Expected Voucher Applied date is incorrect", false);
			}
			if(ActualDate2.contains(ExpectedDate)) {
				reportLog(Status.PASS, "Promocode Voucher code "+Promocode2+" Applied date is "+ActualDate2, false);
			}else {
				reportLog(Status.FAIL, "Expected Voucher Applied date is incorrect", false);
			}
		} else {
			reportLog(Status.FAIL, "The Promocode Coloumn is Empty for SSN "+SSN, false);
		}
		new DatabaseClass().closeConnection();
		
	}
	
	public void updateNewUIVendorConfiguration(String value) throws Exception {
		new DatabaseClass().getDBConnection("CA");
		String sql1 = "UPDATE veva_cust_property set vcp_value=? where vcp_value='SELF_CONTRACTOR' and cust_id = 2935";
		PreparedStatement prepStmt = conn.prepareStatement(sql1);
		prepStmt.setString(1, value);
		int iCount = prepStmt.executeUpdate();
		if (iCount > 0) {
			reportLog(Status.INFO, " Customer level is Updated to ["+value+"] ", false);
		} else {
			reportLog(Status.INFO, " Customer level is not Updated to ["+value+"] ", false);
		}
		new DatabaseClass().closeConnection();
	}
	public void updateNewUIVendorConfigRegistration(String value) throws Exception {
		new DatabaseClass().getDBConnection("CA");
		String sql1 = "UPDATE veva_cust_property set vcp_value=? where vcp_value='N' and cust_id = 2935";
		PreparedStatement prepStmt = conn.prepareStatement(sql1);
		prepStmt.setString(1, value);
		int iCount = prepStmt.executeUpdate();
		if (iCount > 0) {
			reportLog(Status.INFO, "Digital Badge Customer level is Updated to ["+value+"] ", false);
		} else {
			reportLog(Status.INFO, "Digital Badge Customer level is not Updated to ["+value+"] ", false);
		}
		new DatabaseClass().closeConnection();
	}
	public void updateNewUISelfSccreeingConfigRegistration(String value) throws Exception {
		new DatabaseClass().getDBConnection("CA");
		String sql1 = "UPDATE veva_cust_property set vcp_value=? where vcp_value='Vendor' and cust_id = 2935";
		PreparedStatement prepStmt = conn.prepareStatement(sql1);
		prepStmt.setString(1, value);
		int iCount = prepStmt.executeUpdate();
		if (iCount > 0) {
			reportLog(Status.INFO, "Digital Badge Customer level is Updated to ["+value+"] ", false);
		} else {
			reportLog(Status.INFO, "Digital Badge Customer level is not Updated to ["+value+"] ", false);
		}
		new DatabaseClass().closeConnection();
	}
	
	public void updateNewUIVendLevelCreditCard(String value) throws Exception {
		new DatabaseClass().getDBConnection("CA");
		String sql1 = "UPDATE veva_cust_property set vcp_value=? where vcp_value='Vendor Invoice' and cust_id = 2935";
		PreparedStatement prepStmt = conn.prepareStatement(sql1);
		prepStmt.setString(1, value);
		int iCount = prepStmt.executeUpdate();
		if (iCount > 0) {
			reportLog(Status.INFO, "Digital Badge Customer level is Updated to ["+value+"] ", false);
		} else {
			reportLog(Status.INFO, "Digital Badge Customer level is not Updated to ["+value+"] ", false);
		}
		new DatabaseClass().closeConnection();
	}
	
	public void getVendorLevelCreditCardDetails() throws Exception {
		new DatabaseClass().getDBConnection("CA");
		String sql = "select * from veva_payment where USER_CREATED='amazon789328'";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		prepStmt.setString(1, OrderID);
		result = prepStmt.executeQuery();
		if (result.next()) {
			String AmountCharged = result.getString("PAYMENT_TOTAL");
			String CreditCardInput = result.getString("VEVA_PAYMENT_ID");
			
			String UserName = result.getString("USER_MODIFIED");
//			String DateCreated = result.getString("DT_CREATED");
//			String PaymentType = result.getString("CARD_CHARGED_LAST");
//			String PaymentStatus = result.getString("PAYMENT_STATUS");
//			String OrderID = result.getString("VENDOR_ID");
			if (!(AmountCharged.equalsIgnoreCase("") || AmountCharged == null)) {
				reportLog(Status.PASS, "Amount Charged is " + AmountCharged, false);
			} else {
				reportLog(Status.FAIL, "Amount Charged is " + AmountCharged, false);
			}
			if (!(CreditCardInput.equalsIgnoreCase("") || CreditCardInput == null)) {
				reportLog(Status.PASS, "CreditCardInput Data is " + CreditCardInput, false);
			} else {
				reportLog(Status.FAIL, "CreditCardInput Data is " + CreditCardInput, false);
			}
			if (!(UserName.equalsIgnoreCase("") || UserName == null)) {
				reportLog(Status.PASS, "UserName is " + UserName, false);
			} else {
				reportLog(Status.FAIL, "UserName is " + UserName, false);
			}
//			if (!(DateCreated.equalsIgnoreCase("") || DateCreated == null)) {
//				reportLog(Status.PASS, "DateCreated is " + DateCreated, false);
//			} else {
//				reportLog(Status.FAIL, "DateCreated is " + DateCreated, false);
//			}
//			if (!(PaymentType.equalsIgnoreCase("") || PaymentType == null)) {
//				reportLog(Status.PASS, "Payment Type is " + PaymentType, false);
//			} else {
//				reportLog(Status.FAIL, "Payment Type is " + PaymentType, false);
//			}
//			if (!(PaymentStatus.equalsIgnoreCase("") || PaymentStatus == null)) {
//				reportLog(Status.PASS, "Payment Status is " + PaymentStatus, false);
//			} else {
//				reportLog(Status.FAIL, "Payment Status is " + PaymentStatus, false);
//			}
			if (!(OrderID.equalsIgnoreCase("") || OrderID == null)) {
				reportLog(Status.PASS, "ORDER ID is " + OrderID, false);
			} else {
				reportLog(Status.FAIL, "ORDER ID is " + OrderID, false);
			}
		} else {
			reportLog(Status.FAIL, "Data is null", false);
		}

		new DatabaseClass().closeConnection();
	}
	
/**
	 * @author marovimo 06/06/2021 -- Veva_Cust_Property Setting 
	 **/
	
	public void setVevaCustProperty(String property, String value, String custId) throws Exception {
		new DatabaseClass().getDBConnection(DB);

		String sql1 =  "select cust_id from VEVA_CUSTOMER where VC_NAME=?";
		PreparedStatement prepStmt1 = conn.prepareStatement(sql1);
		prepStmt1.setString(1, custId);
		result = prepStmt1.executeQuery();
		
		if (result.next()) {
		custId = result.getString(1);
		}
		
		String sql2 = "UPDATE VEVA_CUST_PROPERTY SET VCP_VALUE=? WHERE VCP_KEY =? AND CUST_ID=?";
		PreparedStatement prepStmt2 = conn.prepareStatement(sql2);
		prepStmt2.setString(1, value);
		prepStmt2.setString(2, property);
		prepStmt2.setString(3, custId);
				
		int iCount = prepStmt1.executeUpdate();
		if (iCount > 0) {
			logStepInfo("Property is Sucessfully Updated to " +value);
			reportLog(Status.PASS, "Property is Sucessfully Updated to "+value, false);
		} else {
			logStepInfo("No row is updated in DB");
			reportLog(Status.FAIL, "No row is updated", false);
		}
		new DatabaseClass().closeConnection();
		driver.navigate().refresh();
		wait(3);
	}
	
	/**
	 * @author marovimo 06/09/2021 -- Veva_Vendor Payment Method
	 **/
	
	public void setProgramPaymentVendor(String paymentMethod, int vendorID) throws Exception {
		new DatabaseClass().getDBConnection(DB);
		if (paymentMethod.equalsIgnoreCase("null")) {
				paymentMethod = null;
		}
			
		String sql1 = "UPDATE VEVA_VENDOR SET PROGRAM_PAYMENT_METHOD =? WHERE VENDOR_ID =?";
		PreparedStatement prepStmt1 = conn.prepareStatement(sql1);
		prepStmt1.setString(1, paymentMethod);
		prepStmt1.setInt(2, vendorID);
		int iCount = prepStmt1.executeUpdate();
		if (iCount > 0) {
			logStepInfo("Property is Sucessfully Updated to " + paymentMethod);
			reportLog(Status.PASS, "Program Payment is Sucessfully Updated to "+ paymentMethod, false);
		} else {
			logStepInfo("No row is updated in DB");
			reportLog(Status.FAIL, "No row is updated", false);
		}
		new DatabaseClass().closeConnection();
		driver.navigate().refresh();
		wait(3);
	}
	
	public void setVendorAddress(String tax, int vendorID) throws Exception { 
		{
		try {
			new DatabaseClass().getDBConnection(DB);
			String sql1 = "UPDATE VEVA_VENDOR SET VV_ADDRESS1 = '4500 W 69TH ST', VV_CITY = 'SIOUX FALLS', VV_STATE_CODE = 'SD', VV_ZIP_CODE = 57108 WHERE VENDOR_ID =?";
			String sql2 = "UPDATE VEVA_VENDOR SET VV_ADDRESS1 = '110 Madison Ave', VV_CITY = 'Jackson', VV_STATE_CODE = 'GA', VV_ZIP_CODE = 30233 WHERE VENDOR_ID =?";
						
			if (tax.equalsIgnoreCase("taxable")) { 
				PreparedStatement prepStmt1 = conn.prepareStatement(sql1);
				prepStmt1.setInt(1, vendorID);
				int iCount = prepStmt1.executeUpdate();
				if (iCount > 0) {
					logStepInfo("Vendor Address is Sucessfully Updated to " + tax +" state");
					reportLog(Status.PASS, "Vendor Address is Sucessfully Updated to " + tax +" state", false);
				} else {
					logStepInfo("No row is updated in DB");
					reportLog(Status.FAIL, "No row is updated", false);
				}
			}
			else {
				PreparedStatement prepStmt1 = conn.prepareStatement(sql2);
				prepStmt1.setInt(1, vendorID);
				int iCount = prepStmt1.executeUpdate();
				if (iCount > 0) {
					logStepInfo("Vendor Address is Sucessfully Updated to " + tax +" state");
					reportLog(Status.PASS, "Vendor Address is Sucessfully Updated to " + tax +" state", false);
				} else {
					logStepInfo("No row is updated in DB");
					reportLog(Status.FAIL, "No row is updated", false);
				}
			}
			
			new DatabaseClass().closeConnection();
			driver.navigate().refresh();
			wait(3);
		} catch(Throwable e) 
			{
			   e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * @author marovimo 06/10/2021 -- Update Veva_User table 
	 **/
	public void setVevaUserlocked(String flag, int userID) throws Exception {
		new DatabaseClass().getDBConnection(DB);
		if (flag.equalsIgnoreCase("Null")) 
			flag = null;
		String sql1 = "UPDATE VEVA_USER SET VU_LOCKED_USER_FLG =? WHERE USER_ID =?";
		PreparedStatement prepStmt1 = conn.prepareStatement(sql1);
		prepStmt1.setString(1, flag);
		prepStmt1.setInt(2, userID);
		int iCount = prepStmt1.executeUpdate();
		if (iCount > 0) {
			reportLog(Status.PASS, "User Acc Sucessfully Updated to "+flag, false);
		} else {
			reportLog(Status.FAIL, "No row is updated", false);
		}
		new DatabaseClass().closeConnection();
		driver.navigate().refresh();
		wait(3);
	}
	
	public void getComplianceStatus (String queryName, String complStatus, String inputValue, String caseScore) throws Exception {
		new DatabaseClass().getDBConnection(DB);
		
		String query = PropertyFileReader.getProperty(queryName) + " " + caseScore;
		
		System.out.println("query Name is ::" + query);

		PreparedStatement prepStmt1 = conn.prepareStatement(query);
		prepStmt1.setString(1, complStatus);
		prepStmt1.setString(2, inputValue);
			
		result = prepStmt1.executeQuery();
		
		if (result.next()) {
			String firstName = result.getString(1);
			existingFirstName = firstName;
			System.out.println(existingFirstName);
			String lastName = result.getString(2);
			existingLastName = lastName;
			System.out.println(existingLastName);
			String middleName = result.getString(3);
			existingMiddleName = middleName;
			System.out.println(existingMiddleName);

		}
	}
	public void getPkgPrice (String queryName, String inputValue1, String inputValue2, String DB) throws Exception {
		new DatabaseClass().getDBConnection(DB);
		
		String query = PropertyFileReader.getProperty(queryName);
		
		System.out.println("query Name is ::" + query);

		PreparedStatement prepStmt1 = conn.prepareStatement(query);
		prepStmt1.setString(1, inputValue1);
		prepStmt1.setString(2, inputValue2);

		result = prepStmt1.executeQuery();
		
		if (result.next()) {
			
			packagePrice = result.getString(1).trim(); 
			System.out.println(packagePrice);
			additionalBillingPrice = result.getString(2); 
			System.out.println(additionalBillingPrice);
			additionalBillingFlag = result.getString(3); 
			System.out.println(additionalBillingFlag);

		}
	}
		
	public void getStateCodeVendorEmail (String queryName, String inputValue, String DB) throws Exception {
		new DatabaseClass().getDBConnection(DB);
			
		String query = PropertyFileReader.getProperty(queryName);
			
		System.out.println("query Name is ::" + query);

		PreparedStatement prepStmt1 = conn.prepareStatement(query);
		prepStmt1.setString(1, inputValue);
				
		result = prepStmt1.executeQuery();
			
		if (result.next()) {
			
			if (queryName.equalsIgnoreCase("Select_vendor_statecd")) {
				vendorStateCd = result.getString(1); 
				System.out.println(vendorStateCd);
			}
			else {
				vendorEmail = result.getString(1); 
				System.out.println(vendorEmail);
			}
		}
	}
	
	public void setAdditionalBillingPrice (String queryName, String custID, String inputPkg, String Flag, String Price) throws Exception {
		new DatabaseClass().getDBConnection(DB);
		String query = PropertyFileReader.getProperty(queryName);
		PreparedStatement prepStmt1 = conn.prepareStatement(query);
		prepStmt1.setString(1, Flag);
		prepStmt1.setString(2, Price);
		prepStmt1.setString(3, custID);
		prepStmt1.setString(4, inputPkg);
		
		int iCount = prepStmt1.executeUpdate();
		if (iCount > 0) {
			reportLog(Status.PASS, "Additional Billing successfuly updated! ", false);
		} else {
			reportLog(Status.FAIL, "No row is updated", false);
		}
		
		new DatabaseClass().closeConnection();
		driver.navigate().refresh();
		wait(3);
		
	}
	
	public void setVendorCost(String cost, String custID) throws Exception {
		new DatabaseClass().getDBConnection(DB);
		String query = "UPDATE VEVA_CUSTOMER SET VC_VENDOR_REGISTRATION_COST=? WHERE VC_NAME=?";
		PreparedStatement prepStmt1 = conn.prepareStatement(query);
		prepStmt1.setString(1, cost);
		prepStmt1.setString(2, custID);
				
		int iCount = prepStmt1.executeUpdate();
		if (iCount > 0) {
			reportLog(Status.PASS, "Vendor Cost is set to:  "+ cost, false);
		} else {
			reportLog(Status.FAIL, "No row is updated", false);
		}
		
		new DatabaseClass().closeConnection();
		driver.navigate().refresh();
		wait(3);
	}
	
	public void setPackagePrice(String queryName, String price, String custID, String inputPkg) throws Exception {
		new DatabaseClass().getDBConnection(DB);
		String query = PropertyFileReader.getProperty(queryName);
		PreparedStatement prepStmt1 = conn.prepareStatement(query);
		prepStmt1.setString(1, price);
		prepStmt1.setString(2, custID);
		prepStmt1.setString(3, inputPkg);
		
		int iCount = prepStmt1.executeUpdate();
		if (iCount > 0) {
			reportLog(Status.PASS, "Package Price is set to:  "+ price, false);
		} else {
			reportLog(Status.FAIL, "No row is updated", false);
		}
		
		new DatabaseClass().closeConnection();
		driver.navigate().refresh();
		wait(3);
	}
	
	public void getProperyValue (String property) throws Exception {
		new DatabaseClass().getDBConnection(DB);
		
		String query = PropertyFileReader.getProperty("Select_property_vale");
		String custID = driver.getTitle();
		System.out.println("query Name is ::" + query);

		PreparedStatement prepStmt1 = conn.prepareStatement(query);
		prepStmt1.setString(1, custID);
		prepStmt1.setString(2, property);

		result = prepStmt1.executeQuery();
		
		if (result.next()) {
			
			propertyValue = result.getString(1).trim(); 
			System.out.println(propertyValue);
			
		}
	}
	
	public void getLoginUserName (String userID) throws Exception {
		new DatabaseClass().getDBConnection(DB);
		
		String query = "select VU_FIRST_NAME, VU_LAST_NAME from veva_user where VU_USER_LOGIN_ID =?";
		PreparedStatement prepStmt1 = conn.prepareStatement(query);
		prepStmt1.setString(1, userID);
		result = prepStmt1.executeQuery();
		
		if (result.next()) {
			String UserFirstName = result.getString(1);
			String UserLastName = result.getString(2); 
			userNameLogin = UserFirstName + " " + UserLastName;
		}
	}

	public String getActivePeopleProgramOwner (String queryName, String provider) throws Exception {
		new DatabaseClass().getDBConnection(DB);
		String activePeopleDB = "";
		String query = PropertyFileReader.getProperty(queryName);
		PreparedStatement prepStmt1 = conn.prepareStatement(query);
		prepStmt1.setString(1, provider);
		result = prepStmt1.executeQuery();

		if (result.next()) {
			activePeopleDB = result.getString(1);
		}
		return activePeopleDB;
	}

	public void getProviderLocation (String queryName, String provider) throws Exception {
		new DatabaseClass().getDBConnection(DB);
		String query = PropertyFileReader.getProperty(queryName);
		PreparedStatement prepStmt1 = conn.prepareStatement(query);
		prepStmt1.setString(1, provider);
		result = prepStmt1.executeQuery();

		if (result.next()) {
			providerAddress1 = result.getString(1);
			providerAddress2 = result.getString(2);
			providerCity = result.getString(3);
			providerState = result.getString(4);
			providerZipCode = result.getString(5);
			providerCountry = result.getString(6);
		}
	}

	public String getPeopleNumberFiltering (String filter, String pageName) throws Exception {
		new DatabaseClass().getDBConnection(DB);

		String filterDB = "";
		String filterPeopleNumberDB = "";

		if (filter.equalsIgnoreCase("Active"))
			filterDB = "AND VI.VI_INACTIVE_REASON_CD IN (610)";
		else if (filter.equalsIgnoreCase("Inactive"))
			filterDB = "AND VI.VI_INACTIVE_REASON_CD IN (630)";
		else if (filter.equalsIgnoreCase("Terminated"))
			filterDB = "AND VI.VI_INACTIVE_REASON_CD IN (650)";
		else if (filter.equalsIgnoreCase("Compliant"))
			filterDB = "AND VI.VI_INDIVIDUAL_COMPL_STATUS IN (400)";
		else if (filter.equalsIgnoreCase("Non-Compliant"))
			filterDB = "AND VI.VI_INDIVIDUAL_COMPL_STATUS IN (401";
		else if (filter.equalsIgnoreCase("Pending"))
			filterDB = "AND VI.VI_INDIVIDUAL_COMPL_STATUS IN (403)";
		else if (filter.equalsIgnoreCase("Needs Review"))
			filterDB = "AND VI.VI_INDIVIDUAL_COMPL_STATUS IN (404)";
		else if (filter.equalsIgnoreCase("Completed"))
			filterDB = "AND VI.VI_INDIVIDUAL_COMPL_STATUS IN (400,401)";
		else
			filterDB = "";

		String query = PropertyFileReader.getProperty("Select_People_Filter") + " " + filterDB;
		PreparedStatement prepStmt1 = conn.prepareStatement(query);

		if (pageName.equalsIgnoreCase("Program Owner"))
			prepStmt1.setString(1, providerName);
		else
			prepStmt1.setString(1, userName);

		result = prepStmt1.executeQuery();
		if (result.next())
			 filterPeopleNumberDB = result.getString(1);

		new DatabaseClass().closeConnection();
		return filterPeopleNumberDB;
	}

	public String getPeopleNumberWihtoutFiltering (String pageName) throws Exception {
		new DatabaseClass().getDBConnection(DB);

		String filterPeopleNumberDB = "";
		String query = "";

		if (pageName.equalsIgnoreCase("Program Owner"))
			query = PropertyFileReader.getProperty("Select_Program_Owner_Filter");
		else
			query = PropertyFileReader.getProperty("Select_People_Filter");

		PreparedStatement prepStmt1 = conn.prepareStatement(query);
		prepStmt1.setString(1, userName);

		result = prepStmt1.executeQuery();
		if (result.next())
			filterPeopleNumberDB = result.getString(1);

		System.out.println("Total people without filter is: " +filterPeopleNumberDB);
		new DatabaseClass().closeConnection();
		return filterPeopleNumberDB;
	}

	public String getProviderID () throws Exception {
		new DatabaseClass().getDBConnection(DB);
		String providerID = "";
		String query = "SELECT VENDOR_ID FROM VEVA_VENDOR WHERE VV_NAME =?";
		PreparedStatement prepStmt1 = conn.prepareStatement(query);
		prepStmt1.setString(1, providerName);
		result = prepStmt1.executeQuery();
		if (result.next())
			providerID = result.getString(1);
		new DatabaseClass().closeConnection();
		return providerID;
	}

	public void updateCredentialsStatus(String status) throws Exception {
		new DatabaseClass().getDBConnection(DB);
		String sql1 = "UPDATE VEVA_VENDOR SET VV_CREDENTIAL_STATUS = ? WHERE VENDOR_ID = 66364";
		PreparedStatement prepStmt1 = conn.prepareStatement(sql1);
		prepStmt1.setString(1, status);
		int iCount = prepStmt1.executeUpdate();
		if (iCount > 0) {
			reportLog(Status.PASS, "Updated Provider Credential Status to: "+status, false);
		} else {
			reportLog(Status.FAIL, "Provider Credential Status Update Failed", false);
		}
		conn.commit();
		new DatabaseClass().closeConnection();
	}

	public String getPropertyID (String custID, String property) throws Exception {
		new DatabaseClass().getDBConnection(DB);
		String propertyID = "";
		String sql1 = "SELECT VEVA_CUST_PROPERTY_ID FROM VEVA_CUST_PROPERTY WHERE CUST_ID =? AND VCP_KEY =?";
		PreparedStatement prepStmt1 = conn.prepareStatement(sql1);
		prepStmt1.setString(1, custID);
		prepStmt1.setString(2, property);
		result = prepStmt1.executeQuery();
		if (result.next())
			propertyID = result.getString(1);
		new DatabaseClass().closeConnection();
		return propertyID;
	}

	public void insertSiteCredit(String siteCreditState) throws Exception {
		String sql1 = PropertyFileReader.getProperty("Insert_Site_Credit");
		Integer VendorId = Integer.valueOf(VendorID);
		Integer CustId = Integer.valueOf(CustID);

		if (siteCreditState.equalsIgnoreCase("OFF")) {
			PreparedStatement prepStmt1 = conn.prepareStatement(sql1);
			prepStmt1.setInt(1, CustId);
			prepStmt1.setInt(2, VendorId);
			prepStmt1.setInt(3, siteCreditOrderID);
			prepStmt1.setDouble(4, siteCreditAmount);
			prepStmt1.setString(5, null);
			prepStmt1.setString(6, "AUTOMATION_TEST_SITE_CREDIT_OFF");
			prepStmt1.setString(7, "AUTOMATION_TEST_SITE_CREDIT_OFF");
			int iCount = prepStmt1.executeUpdate();
			if (iCount > 0) {
				logStepInfo("Site Credit set to 0 in SITE_CREDIT_AUDIT!");
			} else {
				logStepInfo("Failed to set Site Credit to 0 in SITE_CREDIT_AUDIT!");
			}
		}
		else if (siteCreditState.equalsIgnoreCase("ON")) {
			PreparedStatement prepStmt1 = conn.prepareStatement(sql1);
			prepStmt1.setInt(1, CustId);
			prepStmt1.setInt(2, VendorId);
			prepStmt1.setInt(3, siteCreditOrderID);
			prepStmt1.setString(4, null);
			prepStmt1.setDouble(5, siteCreditAmount);
			prepStmt1.setString(6, "AUTOMATION_TEST_SITE_CREDIT_ON");
			prepStmt1.setString(7, "AUTOMATION_TEST_SITE_CREDIT_ON");
			int iCount = prepStmt1.executeUpdate();
			if (iCount > 0) {
				logStepInfo("Site Credit rolled back in SITE_CREDIT_AUDIT!");
			} else {
				logStepInfo("Failed to rollback Site Credit in SITE_CREDIT_AUDIT!");
			}
		}
	}

	public void setSiteCreditToZero(String siteCreditState) throws Exception {
		new DatabaseClass().getDBConnection(DB);
		String sql1 = PropertyFileReader.getProperty("Select_SC_Credit_Amount");
		Integer VendorId = Integer.valueOf(VendorID);
		PreparedStatement prepStmt1 = conn.prepareStatement(sql1);
		prepStmt1.setInt(1, VendorId);
		result = prepStmt1.executeQuery();
		if (result.next())
			siteCreditAmount = result.getDouble(1);
//			PropertyFileReader.setProperty("SiteCreditAmount", siteCreditAmount.toString());

		if (siteCreditAmount > 0) {

			String sql2 = PropertyFileReader.getProperty("Select_SC_Order_ID");
			PreparedStatement prepStmt2 = conn.prepareStatement(sql2);
			prepStmt2.setInt(1, VendorId);
			result = prepStmt2.executeQuery();
			if (result.next())
				siteCreditOrderID = result.getInt(1);

		//	insertSiteCredit(siteCreditState);

			String sql3 = PropertyFileReader.getProperty("Update_SC_Zero");
			PreparedStatement prepStmt3 = conn.prepareStatement(sql3);
			prepStmt3.setInt(1, VendorId);
			int iCount = prepStmt3.executeUpdate();
			if (iCount > 0) {
				reportLog(Status.PASS, "Site Credit Updated to Zero!", false);
			} else {
				reportLog(Status.FAIL, "Failed Updating Site Credit to Zero!", false);
			}

		} else
			logStepInfo("Site Credit is zero!");

		conn.commit();
		new DatabaseClass().closeConnection();
	}

	public void rollbackSiteCreditState(String siteCreditState) throws Exception {
		new DatabaseClass().getDBConnection(DB);
		String sql1 = PropertyFileReader.getProperty("Update_SC_Rollback");
		Integer VendorId = Integer.valueOf(VendorID);
		PreparedStatement prepStmt1 = conn.prepareStatement(sql1);
		prepStmt1.setInt(1, VendorId);
	//	prepStmt1.setDouble(2, siteCreditAmount);
		int iCount = prepStmt1.executeUpdate();
		if (iCount > 0) {
			reportLog(Status.PASS, "Site Credit Value set greater than Packages price!", false);
		} else {
			reportLog(Status.FAIL, "Failed value set to an amount of Site Credit!", false);
		}
	//	insertSiteCredit(siteCreditState);
		conn.commit();
		new DatabaseClass().closeConnection();
	}
	public void partialSiteCredit(String siteCreditState) throws Exception {
		new DatabaseClass().getDBConnection(DB);
		String sql1 = PropertyFileReader.getProperty("Update_SC_Partial");
		Integer VendorId = Integer.valueOf(VendorID);
		PreparedStatement prepStmt1 = conn.prepareStatement(sql1);
		prepStmt1.setInt(1, VendorId);
	//	prepStmt1.setDouble(2, siteCreditAmount);
		int iCount = prepStmt1.executeUpdate();
		if (iCount > 0) {
			reportLog(Status.PASS, "Site Credit Value set partial less than Packages price!", false);
		} else {
			reportLog(Status.FAIL, "Failed value set to less than an amount of Packages price!", false);
		}
	//	insertSiteCredit(siteCreditState);
		conn.commit();
		new DatabaseClass().closeConnection();
	}
	//to do look this up
	public String uniqueVendorDB(int custID) throws IOException, ClassNotFoundException, SQLException {
		new DatabaseClass().getDBConnection(DB);
		String sqlQuery=PropertyFileReader.getProperty("Select_Unique_Vendor");
		PreparedStatement preparedStatement=conn.prepareStatement(sqlQuery);
		preparedStatement.setInt(1,custID);
		result=preparedStatement.executeQuery();
		String uniqueName=" ";
		while (result.next()) {
			uniqueName=result.getString("VV_NAME");
		}
		logStepInfo("Unique provider was found:"+uniqueName);
		return uniqueName;

	}
	public List<String> lengthOfServiceDB(int custID, String vendorID) throws IOException, ClassNotFoundException, SQLException {
		new DatabaseClass().getDBConnection(DB);
		String sqlQuery="SELECT END_OF_SERVICE, START_OF_SERVICE, VV_NAME from veva_vendor where cust_id = ? and VV_NAME =?";
		PreparedStatement preparedStatement=conn.prepareStatement(sqlQuery);
		preparedStatement.setInt(1,custID);
		preparedStatement.setString(2,vendorID);
		result=preparedStatement.executeQuery();
		List<String> results=new ArrayList<>();
		while (result.next()){
			results.add(result.getString("START_OF_SERVICE"));
			results.add(result.getString("END_OF_SERVICE"));
			results.add(result.getString("VV_NAME"));
		}
		logStepInfo("Length of Service Found in DB:"+results);
		return results;
	}
}
