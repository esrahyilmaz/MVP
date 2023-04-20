package Utility;

import com.aventstack.extentreports.Status;
import seleniumhelper.BaseClass;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class RobotFunction extends BaseClass {
	CurrentDateTime date = new CurrentDateTime();
	private static int count=0;

	public void saveFile(String fileName) throws Exception {
		try {
			count=count+1;
			System.out.println("file Name with location is ::" + fileName);
			StringSelection stringSelection = new StringSelection(fileName);
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(stringSelection, null);
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_S);
			Thread.sleep(2000);
			robot.keyRelease(KeyEvent.VK_S);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(2000);

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			System.out.println("File saved to following Location: " + fileName);
			
			wait(5);
			if(count>1) {
				robot.keyPress(KeyEvent.VK_TAB);
				robot.keyPress(KeyEvent.VK_ENTER);
			}
			Thread.sleep(30000);
			// closing the window
			robot.keyPress(KeyEvent.VK_ALT);
			robot.keyPress(KeyEvent.VK_F4);

			robot.keyRelease(KeyEvent.VK_F4);
			robot.keyRelease(KeyEvent.VK_ALT);
			
		
			reportLog(Status.PASS, "Save using Robot Code completed !!!", true);
			logStepInfo("Save using Robot Code completed !!!" + fileName);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			logStepInfo("Save using Robot Code completed !!!" + ex.getMessage());
			reportLog(Status.FAIL, "Save using Robot Code completed !!!" + ex.getMessage(), true);
			scenarioFailed();

		}
	}
}
