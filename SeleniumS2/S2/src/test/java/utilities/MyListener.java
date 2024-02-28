package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class MyListener extends TestListenerAdapter implements ITestListener{
	
	private ExtentReports extent;
	
    @Override
    public void onStart(ITestContext context) {
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("D:\\GIT\\A.MLA.T\\SeleniumS2\\S2\\ExtentReports\\extentReport.html");
        extent.attachReporter(spark);
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
		
	public void onTestFailure(ITestResult result) {
		System.out.println("Failed result's Name is : "+result.getName());
	}
	
	public void onTestSkipped(ITestResult result) {
		System.out.println("Skipped result's Name is : "+result.getName());
	}
	
	public void onTestStart(ITestResult result) {
		System.out.println("Started result's Name is : "+result.getName());
	}
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("Succeeded result's Name is : "+result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Test Failed within Success percentage: " + result.getName());
	}
}
