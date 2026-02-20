package pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
	
	private WebDriver driver;
	
	private By logo =By.className("tools-qa-header__logo");
	private By seleniumtrainingLink=By.xpath("(//a[contains(text(),'Selenium Training')])[1]");	
	public RegisterPage()
	{
		this.driver=DriverThread.getDriver();
	}
	
	public void clickRegister()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println("Hey due i am here");
		driver.findElement(logo).click();
		System.out.println("clicking");
		
		driver.findElement(seleniumtrainingLink).click();
		
		System.out.println("selenium traning link clicked");
		//driver.findElement(practiseFrom).click();
	}
	
//	public void registerUser(String fName, String lName,String uName,String pwd)
//	{
//		driver.findElement(firstName).sendKeys(fName);
//        driver.findElement(lastName).sendKeys(lName);
//        //driver.findElement(userName).sendKeys(uName);
//       // driver.findElement(password).sendKeys(pwd);
//        
//     // CAPTCHA is manual on demoqa
//        //MahanM
//        //Mahan@143
//        System.out.println("Please complete CAPTCHA manually");
//	}

}
