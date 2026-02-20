package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LaunchPage;
import pages.LoginPage;
import pages.ProfilePage;
import pages.RegisterPage;
import utils.TestDataProvider;

public class DemoQADPTest extends BaseTest {
	
	//prepare for all the annotaions iof TestNG in the selenium
	
	@Test()
	public void launchApplication()
	{
		LaunchPage launchPage = new LaunchPage();
		//launchPage.openBookStoreApplication();
		//Assert.assertTrue(driver.getCurrentUrl().contains("Book"));
		
	}
	
	@Test()
	public void registerUser()
	{
		
		RegisterPage registerPage = new RegisterPage();
		registerPage.clickRegister();
		//registerPage.registerUser("John", "Doe", "john123", "Password@123");
		
			//9448635191
	}
	@Test(priority =1,dataProvider = "loginData",dataProviderClass = TestDataProvider.class)
	//@Test
	public void loginUser(String username, String password)
	{
		
		LoginPage loginPage = new LoginPage();
		
		loginPage.login(username, password);
		//Assert.assertEquals(loginPage.getLoggedInUser(), "MahanM");
	}
	
	@Test(dependsOnMethods = {"loginUser"} )
	public void profilePage(String username)
	{
		ProfilePage profilepage = new ProfilePage(null);
				profilepage.navigatedToProfilePage(username);
				
	}

}
