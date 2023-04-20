package Utility;

import com.aventstack.extentreports.Status;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import seleniumhelper.BaseClass;

import java.io.File;

public class PdfReader extends BaseClass {
	private PDDocument document;

	public String getPdfData(String path) throws Exception {
		try {
			document = null;
			PDFTextStripper pdf = new PDFTextStripper();
			String pdfFileInText="";
//			if (!document.isEncrypted()) {
				document = PDDocument.load(new File(path));
				System.out.println("Total pages" + document.getNumberOfPages());
				pdf.setSortByPosition(true);
				pdfFileInText = pdf.getText(document);
				System.out.println(pdf.getText(document));
//			}
			reportLog(Status.PASS, "PDF reading successfully done !!!", true);
			logStepInfo("PDF reading successfully done !!!" + pdfFileInText);
			return pdfFileInText;
			
			
		} catch (Exception ex) {
			
			logStepInfo("Failed to Read PDF !!!" + ex.getMessage());
			reportLog(Status.FAIL, "Failed to Read PDF !!!" + ex.getMessage(), true);
			scenarioFailed();
			return ex.getMessage();
		}
	}
}
