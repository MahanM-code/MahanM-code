package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	private static ExtentReports extent;

	public static synchronized  ExtentReports getExtent()
	{
		{
			if(extent==null)
			{
				ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");
				spark.config().setReportName("DemoQA Automation Report");
				spark.config().setDocumentTitle("Selenium 4 Test Results");
				
				extent=new ExtentReports();
				extent.attachReporter(spark);
				extent.setSystemInfo("OS", System.getProperty("os.name"));
	            extent.setSystemInfo("Browser", "Chrome");
	            extent.setSystemInfo("Tester", "Automation Engineer");
				}
			return extent;
		
	}
	
}
}

