package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	private static ExtentReports extent; //Holds a single instance of ExtentReports and Shared across the entire framework

	public static synchronized  ExtentReports getExtent() //synchronized ensures thread safety

                                                          //Important when tests run in parallel
	{
		{
			if(extent==null) //Report is created only when required ,Saves memory and avoids duplicate reports
			{
				//Defines report output location and Creates HTML report
				ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html"); 
				
				spark.config().setReportName("DemoQA Automation Report");  //Sets report name and browser tab title
				spark.config().setDocumentTitle("Selenium 4 Test Results");
				
				extent=new ExtentReports();
				extent.attachReporter(spark); //Links Spark reporter with ExtentReports engine
				extent.setSystemInfo("OS", System.getProperty("os.name")); 
				//Adds environment details to the report and Helps in debugging and auditing
	            extent.setSystemInfo("Browser", "Chrome");
	            extent.setSystemInfo("Tester", "Automation Engineer");
				}
			return extent;
		
	}
	
}
}

/*The ExtentManager utility is used to manage a single instance of ExtentReports across the automation framework.
It follows the Singleton design pattern to avoid creating multiple report objects.
The getExtent() method initializes the report only once and returns the same instance for all tests.
The synchronized keyword ensures thread safety during parallel execution.
This helps in generating a clean, stable, and consolidated Extent HTML report.*/















