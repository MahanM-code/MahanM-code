package tests;


import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestNGallAnnotaions
{
	@BeforeSuite
	public void beforesuite()
	{
		Reporter.log("Before suite method is being Executed", true);// if i menetion true then it will display in both console and html report also
	}
	
	@BeforeTest
	public void beforetest()
	{
		Reporter.log("Before test method is getting executed",true);// if no true then it will only print in the html report only
	}
	
	@BeforeClass
	public void beforeclass()
	{
		Reporter.log("Before class method being executed",true);
	}
	
	@BeforeMethod
	public void beforemethod()
	{
		Reporter.log("Before method is getting executed",true);
	}
	
		
	@Test
	public void test1()
	{
		Reporter.log("Test1 method is being executed",true);
	}
	@Test
	public void test2()
	{
		Reporter.log("Test2 method is being executed",true);
	}
	
	@AfterMethod
	public void aftermethod()
	{
		Reporter.log("After Method method is being executed",true);
	}
	
	@AfterClass
	public void afterclass()
	{
		Reporter.log("After class method is being executed",true);
	}
	
	@AfterTest
	public void aftertest()
	{
		Reporter.log("After test method being executed",true);
	}
	
	@AfterSuite
	public void aftersuite()
	{
		Reporter.log("After suite is being executed",true);
	}
	
	//output of this program is 
	/*Before suite method is being Executed
		Before test method is getting executed
		Before class method being executed
		Before method is getting executed
		Test1 method is being executed
		After Method method is being executed
		Before method is getting executed
		Test2 method is being executed
		After Method method is being executed
		After class method is being executed
		After test method being executed
	 * 
	 * @AfterSuite executes once after the entire suite finishes. If it is not executing,
	 *  possible reasons include the class not being included in testng.xml,
	 *  incorrect annotation spelling, method visibility issues, or suite execution failure.
	 * 
	 * 
	 * 
	 */
	
	

}
