package Utility;

import seleniumhelper.BaseClass;

import java.io.File;
import java.util.List;

public class ReportUpload extends BaseClass {

	public static String uploadUrl;

	private synchronized boolean copyToRemoteWEB(String strRemotePath, String strLocalFile) {
		boolean bSuccess = false;
		String strUploadResponse = "";
		try {
			if (uploadUrl == null || uploadUrl.isEmpty()) {
				System.out.println("upload url is null or empty");
				return false;
			}

			MultipartUtility multipart = new MultipartUtility(uploadUrl, "UTF-8");
			multipart.addFormField("upload", "2");
			multipart.addFormField("api", "2");
			multipart.addFormField("path", "JTAFDataStorage/" + strRemotePath);
			multipart.addFormField("pass", "Qctesting1");
			multipart.addFormField("overwrite", "on");
			multipart.addFilePart("file", new File(strLocalFile));
			List<String> response = multipart.finish();

			for (String line : response) {
				System.out.println("copyToRemoteWEB: " + line);
				strUploadResponse += line;
			}

			System.out.println("copyToRemote remotefile [" + strRemotePath + "] localfile [" + strLocalFile + "]");

			if (strUploadResponse.indexOf("uploaded,TRUE,flag") >= 0) {
				bSuccess = true;
			} else {
				bSuccess = false;
			}
		} catch (Exception e) {
			System.out.println("Unable to copy file to remote server");
			System.out.println(e);
			bSuccess = false;
		}
		return bSuccess;
	}

	public static void uploadToServer() throws Exception {
		uploadUrl = PropertyFileReader.getProperty("uploadUrl");

		Boolean status = new ReportUpload().copyToRemoteWEB(ReportScenarioDirectory, ReportpathLocal);
		if (status) {
			System.out.println("Success");
		} else {
			System.out.println("Failed");
		}
	}

	public static void uploadToServerEmailFile(String EmailPathServer,String EmailPathLocal) throws Exception {
		uploadUrl = PropertyFileReader.getProperty("uploadUrl");

		Boolean status = new ReportUpload().copyToRemoteWEB(EmailPathServer, EmailPathLocal);
		if (status) {
			System.out.println("Success");
		} else {
			System.out.println("Failed");
		}
	}
	
	public static void uploadScreenShotToServer() throws Exception {
		uploadUrl = PropertyFileReader.getProperty("uploadUrl");

		Boolean status = new ReportUpload().copyToRemoteWEB(ReportScreenShotDirectory, ScreenShotpathLocal);
		if (status) {
			System.out.println("ScreenShot Success");
		} else {
			System.out.println("ScreenShot Failed");
		}
	}
}
