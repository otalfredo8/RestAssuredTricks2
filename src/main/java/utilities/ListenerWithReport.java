package utilities;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class ListenerWithReport implements ITestListener {

    protected static ExtentReports extentReports;
    protected static ExtentTest extentTest;
    private static String resultPath = getResultPath();

    private static String getResultPath(){
        //Directory name
        resultPath = "test";
        //If is not a Directory
        if (! new File(resultPath).isDirectory())
            //make a directory
            new File(resultPath);

            return resultPath;
    }

    //Test Listeners
    public void onTestStart(ITestResult result) {
        extentTest = extentReports.startTest(result.getMethod().getMethodName());
        extentTest.log(LogStatus.INFO, result.getMethod().getMethodName());
//        System.out.println(result.getTestClass().getTestName());
//        System.out.println(result.getTestClass().getTestName());
    }

    public void onTestSuccess(ITestResult result) {
        extentTest.log(LogStatus.PASS, "...onTestSuccess...");
    }

    public void onTestFailure(ITestResult result) {
        //LogStatus specify the log status of the log-event
        extentTest.log(LogStatus.FAIL, "...onTestFailure...");
    }

    public void onTestSkipped(ITestResult result) {
        extentTest.log(LogStatus.SKIP, "...onTestSkipped...");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        extentTest.log(LogStatus.FAIL, "...onTestFailedButWithinSuccessPercentage...");
    }

    public void onTestFailedWithTimeout(ITestResult result) {
        extentTest.log(LogStatus.FAIL, "...onTestFailedWithTimeout...");
    }

    //Report
    String reportLocation = "test-output/Report/" + resultPath + "/";
    public void onStart(ITestContext context) {
        extentReports = new ExtentReports(reportLocation + "ExtentReport.html");
        extentTest = extentReports.startTest("");
    }

    public void onFinish(ITestContext context) {
        extentReports.endTest(extentTest);
        extentReports.flush();
    }
}
