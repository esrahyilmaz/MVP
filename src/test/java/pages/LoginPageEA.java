package pages;

import Utility.ExcelReader;
import Utility.PropertyFileReader;
import org.openqa.selenium.By;
import seleniumhelper.BaseClass;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Random;


public class LoginPageEA extends BaseClass {
    
	ExcelReader _dataRepo = new ExcelReader();
	private By AccountTB=By.name("accountnumber");
	private By UserNameTB=By.name("username");           
	private By PasswordTB=By.name("password");
	private By SigninBTN=By.id("signOn");
	private By InvalidCredentials = By.xpath("//div[contains(text(),'Invalid Credentials')]");
	private By OKBTn=By.xpath("//div[@class='html-face']//td");
	private By ForgotPWBTn=By.xpath("//a[@class='forgotPasswordLink']");
	private By SubmitBTN=By.xpath("//*[@id='submitBtn']");
	private By SecretTB=By.xpath("//*[@type='password']");
	private By ConfirmPWTB=By.xpath("//*[@name='confirmPassword']");
	private By ReturnBTN=By.xpath("//*[@id='returnBtn']");
	private By proceedBTN = By.xpath("//td[@class='html-face' and text()='Proceed']");
	private By UserInformation=By.xpath("//div[text()='User Information']");
	private By UserSubmitBTn=By.id("submitBtn");
	private By AgreeBTn=By.id("agreeBtn");
	private By Alerts_Notification=By.xpath("//div[text()='Alerts & Notifications']");
	private By continueBTn=By.id("continueBtn");
	private By OK=By.name("ok");
	private By HomePage=By.id("home");
	private By ChangePasswordPage=By.xpath("//div[.='Change Password']");
	private By OldPWTB=By.xpath("//input[@name='oldPassword']");
	private By NewPWTB=By.xpath("//input[@name='password']");
	private By ConfirmNewPWTB=By.xpath("//input[@name='confirmPassword']");
	private static String DBPassword="";	

				public void login(String AccountNO, String UserName,String env) throws InterruptedException, Exception {
                                String Password=null;
                                String mysqlConn = PropertyFileReader.getProperty("AutomationConnection");
                                String mysqlUser = PropertyFileReader.getProperty("AutomationUserID");
                                String mysqlPass = PropertyFileReader.getProperty("AutomationPassword");
                                
                                Connection dbConn = null;
                                PreparedStatement prepStmt=null;
                                Statement Stmt = null;
                                ResultSet rs = null;
                                String sql = null;
                                
                                try {
                                                Class.forName("com.mysql.jdbc.Driver").newInstance();
                                } catch (Exception E) {
                                                System.err.println("Unable to load driver");
                                                E.printStackTrace();
                                }

                                try {
                                                dbConn = DriverManager.getConnection(mysqlConn, mysqlUser, mysqlPass);
                                } catch (SQLException e) {
                                                // TODO Auto-generated catch block
                                                e.printStackTrace();
                                }
                                                
                                try {
                                    //Date date = new Date();
                                    dbConn.setAutoCommit(true);
                                  //  sql="SELECT PASSWORD FROM fw_Env_Login WHERE Environment='BLR-QC2' AND Account_Number='111000LMS' AND User_Name='Tester'";
                                   sql = "SELECT PASSWORD FROM fw_Env_Login WHERE Environment= '"+env+"' AND Account_Number= '"+AccountNO+"' AND User_Name='"+UserName+"'";
                                    
                                   Stmt= dbConn.createStatement();
                                    
                                    
                                    System.out.println(sql);
                                    rs = Stmt.executeQuery(sql);
                                    if(rs.next()){
                                                    
                                                  String  DBPassword = rs.getString("Password");  
                                                  this.DBPassword=DBPassword;
                                                    System.out.println(DBPassword);
                                    }
                                    rs.close();                                                       
                    } catch (SQLException e) {
                                    logger.error(e);
                     } finally {
                                    try {
                                                    if (dbConn != null)
                                                                    dbConn.close();
                                    } catch (Exception e) {
                                                    logger.error(e);
                                    }
                    }   
                                			try {
                                                Password=DBPassword;
                                		
                                                EnterText(AccountTB,"Entered Account number "+AccountNO,AccountNO );
                                				EnterText(UserNameTB,"Entered UserName "+UserName,UserName );
                                				EnterText(PasswordTB,"Entered Password"+Password,Password );
                                				clickElement(SigninBTN, "Clicked on Sign in button");
                                			}catch(Exception e) {
                                				e.printStackTrace();
                                			}
                                               
                                                
                                                Password = null;
                                                Random rand = new Random();
                                                int rand_num = rand.nextInt(100000);
                                                Password = "Testing@"+rand_num;
                                                final DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                                	Date date = new Date(rand_num);
                                                	String date1 = sdf.format(date);
                                                
                                                if(verifyElementPresence(InvalidCredentials))
                                                {
                                                	try {
                                                				clickElement(OKBTn, "Clicked on ok button");
                                                				clickElement(ForgotPWBTn, "Clicked on Forgot Password");
                                                                EnterText(AccountTB,"Entered Account number "+AccountNO,AccountNO );
                                                                EnterText(UserNameTB,"Entered UserName "+UserName,UserName );
                                                                clickElement(SubmitBTN, "Clicked on Submit button");
                                                                String Answer=_dataRepo.getData("SecurityAns");
                                                                if(Answer==null||Answer.equalsIgnoreCase("")) {
                                                                	Answer="Test";
                                                                }
                                                                EnterText(SecretTB,"Entered Secret Answer",Answer);
                                                                clickElement(SubmitBTN, "Clicked on Submit Button");
                                                                EnterText(PasswordTB,"Entered new Password "+Password,Password );
                                                                EnterText(ConfirmPWTB,"Entered confirm new Password "+Password,Password );
                                                                clickElement(SubmitBTN, "Clicked on submit Button");
                                                                clickElement(ReturnBTN, "Clicked on Return Button");
                                                                
                                                	}catch(Exception e){
                                                		e.printStackTrace();
                                                	}
                                                    
                                                	
                                                	try {
                                                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                                        } catch (Exception E) {
                                                        System.err.println("Unable to load driver");
                                                        E.printStackTrace();
                                        }

                                        try {
                                                        dbConn = DriverManager.getConnection(mysqlConn, mysqlUser, mysqlPass);
                                        } catch (SQLException e) {
                                                        // TODO Auto-generated catch block
                                                        e.printStackTrace();
                                        }
                                                	
                                                	

                                                                try {
                                                                                
                                                                                dbConn.setAutoCommit(true);
                                                                                
                                                                                sql = "UPDATE fw_Env_Login SET Password='"+Password+"', Update_Date='"+date+"', Updated_BY='Automation' WHERE Environment='"+env+"' AND Account_Number='"+AccountNO+"' AND User_Name='"+UserName+"'";
                                                                                
                                                                                Stmt= dbConn.createStatement();
                                                                                
                                                                                
                                                                                System.out.println(sql);
                                                                                int count = Stmt.executeUpdate(sql);
                                                                                System.out.println("Updated queries: "+count);
                                                                                System.out.println("Password Updated :"+Password);
                                                                                rs.close();                                                       
                                                                } catch (SQLException e) {
                                                                                logger.error(e);
                                                                } finally {
                                                                                try {
                                                                                                if (dbConn != null)
                                                                                                                dbConn.close();
                                                                                } catch (Exception e) {
                                                                                                logger.error(e);
                                                                                }
                                                                }                                              

                                                                
                                                                EnterText(AccountTB,"textbox field",AccountNO );
                                                				EnterText(UserNameTB,"textbox field",UserName );
                                                				EnterText(PasswordTB,"textbox field",Password );
                                                				clickElement(SigninBTN, "button");
                                                                
                                                }
                                                if(verifyElementPresence(ChangePasswordPage)){
                                                	
                                                	try {
                                        				
                                                        String Answer=_dataRepo.getData("SecurityAns");
                                                        if(Answer==null||Answer.equalsIgnoreCase("")) {
                                                        	Answer="Test";
                                                        }
                                                        EnterText(OldPWTB, "old password", DBPassword);
                                                        EnterText(PasswordTB,"Entered new Password "+Password,Password );
                                                        EnterText(ConfirmPWTB,"Entered confirm new Password "+Password,Password );
                                                        clickElement(SubmitBTN, "Clicked on submit Button");
                                                        clickElement(ReturnBTN, "Clicked on Return Button");
                                                        
                                        	}catch(Exception e){
                                        		e.printStackTrace();
                                        	}
                                            
                                        	
                                        	try {
                                                Class.forName("com.mysql.jdbc.Driver").newInstance();
                                } catch (Exception E) {
                                                System.err.println("Unable to load driver");
                                                E.printStackTrace();
                                }

                                try {
                                                dbConn = DriverManager.getConnection(mysqlConn, mysqlUser, mysqlPass);
                                } catch (SQLException e) {
                                                // TODO Auto-generated catch block
                                                e.printStackTrace();
                                }
                                        	
                                        	

                                                        try {
                                                                        
                                                                        dbConn.setAutoCommit(true);
                                                                        
                                                                        sql = "UPDATE fw_Env_Login SET Password='"+Password+"', Update_Date='"+date+"', Updated_BY='Automation' WHERE Environment='"+env+"' AND Account_Number='"+AccountNO+"' AND User_Name='"+UserName+"'";
                                                                        
                                                                        Stmt= dbConn.createStatement();
                                                                        
                                                                        
                                                                        System.out.println(sql);
                                                                        int count = Stmt.executeUpdate(sql);
                                                                        System.out.println("Updated queries: "+count);
                                                                        System.out.println("Password Updated :"+Password);
                                                                        rs.close();                                                       
                                                        } catch (SQLException e) {
                                                                        logger.error(e);
                                                        } finally {
                                                                        try {
                                                                                        if (dbConn != null)
                                                                                                        dbConn.close();
                                                                        } catch (Exception e) {
                                                                                        logger.error(e);
                                                                        }
                                                                        
                                                                        try {
                                                                            
                                                            		
                                                                            EnterText(AccountTB,"Entered Account number "+AccountNO,AccountNO );
                                                            				EnterText(UserNameTB,"Entered UserName "+UserName,UserName );
                                                            				EnterText(PasswordTB,"Entered Password"+Password,Password );
                                                            				clickElement(SigninBTN, "Clicked on Sign in button");
                                                            			}catch(Exception e) {
                                                            				e.printStackTrace();
                                                            			}
                                                }
                                                }
                                                
                                                if (verifyElementPresence(proceedBTN)){
                                                	clickElement(proceedBTN, "button");                    
                                                }
                                                
                                                if (verifyElementPresence(SecretTB)){
                                                	String Answer=_dataRepo.getData("SecurityAns");
                                                    if(Answer==null||Answer.equalsIgnoreCase("")) {
                                                    	Answer="Test";
                                                    }
                                                	EnterText(SecretTB, "Entered Secret Answer",Answer);  
                                                	clickElement(SubmitBTN, "Clicked on Submit Button");
                                                }
                                                
                                                if (verifyElementPresence(proceedBTN)){
                                                	clickElement(proceedBTN, "button");                    
                                                }

                                                //check for user information update
                                                if(verifyElementPresence(UserInformation)){
                                                	clickElement(UserSubmitBTn, "button");
                                                }                                              
                                                
                                                //click agreen button and check for UI
                                                if(verifyElementPresence(AgreeBTn)){
                                                	clickElement(AgreeBTn, "button");
                                                                  
                                                                
                                                                //alerts & notifications
                                                                if(verifyElementPresence(Alerts_Notification)){
                                                                	clickElement(continueBTn, "button");
                                                                }                                                              
                                                                
                                                                /*//this.waitFor(By.id("EE_MENU_HOME"), 7);
                                                                this.waitForDisappear(EspEnv.progressSpinner);*/
                                                } else {
                                                                clickElementWithWait(OK, "waited and cliked OK");
                                                                verifyElementPresence(HomePage);
                                                                
                      
                                }
                                			
                
				}
               
}


