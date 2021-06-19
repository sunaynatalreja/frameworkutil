/**
 * 
 */
package prj.sunaynatalreja.extentreportutil;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;





/**
 * @author Sunayna Talreja
 * This class is created to provide a basic configuration
 * of the extent report. 
 */
public class ExtentReportUtil { 
	ExtentReports reports ;
	ExtentTest test; 
	ExtentHtmlReporter htmlReporter;
	private static ExtentReportUtil extentReportUtilInstance;

	private ExtentReportUtil()
	{
		reports = new ExtentReports(); 
	}

	// static method to create instance of Singleton class
	public static ExtentReportUtil getInstance()
	{
		if (extentReportUtilInstance == null)
			extentReportUtilInstance = new ExtentReportUtil();

		return extentReportUtilInstance;
	}	
	

	/**
	 * Creating extent report
	 * @param pathToCreateReport
	 * @param docTitle
	 * @param reportName
	 */
	public void createReport(String pathToCreateReport,String docTitle, String reportName) {
		htmlReporter = new ExtentHtmlReporter(pathToCreateReport);
		htmlReporter.config().setDocumentTitle(docTitle); // Tile of report
		htmlReporter.config().setReportName(reportName); // Name of the report
		htmlReporter.config().setTheme(Theme.DARK);
		reports.attachReporter(htmlReporter);
	}

	
	/**
	 * Creating extent test
	 * @param testName
	 */
	public void createReportExtentTest(String testName)
	{
		test = reports.createTest(testName);
	}

	/**
	 * Ending Extent Report
	 */
	public void endReportExtent()
	{
		reports.flush();
	}

	
	/**
	 * Setting extent report test details
	 * @param status
	 * @param testData
	 * @param testName
	 */
	public void setReportExtentTestDetails(String status,String testData,String testName)
	{
		String details="TestData: "+testData;
		if(status=="PASS") {
			test.log(Status.PASS, MarkupHelper.createLabel(testName + " PASSED ", ExtentColor.GREEN));
			test.pass(details);
		}else if(status=="FAIL") {
			test.log(Status.FAIL, MarkupHelper.createLabel(testName+" FAILED ", ExtentColor.RED));
			test.fail(details);
		}else if(status=="SKIP") {
			test.log(Status.SKIP, MarkupHelper.createLabel(testName + " SKIPPED ", ExtentColor.ORANGE));
			test.skip(details);
		}
	}
}