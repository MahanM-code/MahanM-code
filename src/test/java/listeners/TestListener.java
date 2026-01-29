package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import base.BaseTest;
import utils.ExtentManager;
import utils.ExtentTestManager;

public class TestListener implements ITestListener {
	private static ExtentReports extent = ExtentManager.getExtent();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    
    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test  =
                extent.createTest(result.getMethod().getMethodName());
        ExtentTestManager.setTest(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    	ExtentTestManager.getTest().pass("Test Passed");
    	
    }

    @Override
    public void onTestFailure(ITestResult result) {
    	try {
        BaseTest baseTest = (BaseTest) result.getInstance();

        String screenshotPath = baseTest.captureScreenshot(result.getMethod().getMethodName());

        ExtentTest test = ExtentTestManager.getTest();
        test.fail(result.getThrowable());
        test.addScreenCaptureFromPath(screenshotPath);
    	}
    	catch (Exception e) {
			// TODO: handle exception
    		e.printStackTrace();
		}
    }
    
    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentTestManager.getTest().skip("Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }

}
