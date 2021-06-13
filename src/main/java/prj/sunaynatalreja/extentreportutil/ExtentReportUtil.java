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
	static ExtentReports reports ;
	static ExtentTest test; 
	static ExtentHtmlReporter htmlReporter;

public static void createReport(String path,String docTitle, String reportName) {
	reports = new ExtentReports(); 
	htmlReporter = new ExtentHtmlReporter(path);
    htmlReporter.config().setDocumentTitle(docTitle); // Tile of report
    htmlReporter.config().setReportName(reportName); // Name of the report
    htmlReporter.config().setTheme(Theme.DARK);
    reports.attachReporter(htmlReporter);
}

public static void reportExtentTestStart(String testName)
{

    test = reports.createTest(testName);
}

public static void reportExtentEnd()
{

    reports.flush();

}

public static void setReportExtentTestDetails(String status,String testData,String testName)
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