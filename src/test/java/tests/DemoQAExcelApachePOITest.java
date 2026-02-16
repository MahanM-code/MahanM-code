package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LaunchPage;
import pages.LoginPage;
import pages.ProfilePage;
import pages.RegisterPage;
import utils.ExcelDataProvider;

public class DemoQAExcelApachePOITest extends BaseTest {
	
	private static final Logger log = LogManager.getLogger(BaseTest.class);
	
	@Test(priority =0)
	public void launchApplication()
	{
		LaunchPage launchPage = new LaunchPage(driver);
		launchPage.openBookStoreApplication();
		//Assert.assertTrue(driver.getCurrentUrl().contains("Book"));
		
	}
	
	@Test()
	public void registerUser()
	{
		log.info("Login started performing");
		driver.get("https://demoqa.com");
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.clickRegister();
		//registerPage.registerUser("John", "Doe", "john123", "Password@123");
		
			
	}
	@Test(dataProvider = "excelLoginData",dataProviderClass = ExcelDataProvider.class,dependsOnMethods = {"registerUser"})
	    public void loginUser(String username, String password) {

	        //driver.get("https://demoqa.com");
	        //RegisterPage registerPage = new RegisterPage(driver);
	       // registerPage.clickRegister();
	        LoginPage loginPage = new LoginPage(driver);
	        loginPage.login(username, password);

	        }
	
//	@Test(dataProvider = "excelLoginData",dataProviderClass = ExcelDataProvider.class)
//	public void profilePage(String username)
//	{
//		ProfilePage profilepage = new ProfilePage(driver);
//				profilepage.navigatedToProfilePage(username);
//				
//	}
	
	//Note there are 2 tyoes to handle parallel execution one in with the testNG.xml 
	//<suite name="Parallel Suite" parallel="methods" thread-count="3"> 
	
	//Second method is with the ExcelDataprovider @DataProvider(name = "excelLoginData", parallel = true)
	

}
