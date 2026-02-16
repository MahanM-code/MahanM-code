package pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
	
	private WebDriver driver;
	
	private By forms =By.id("//*[contains(.,'Forms') and @class =\"card-body\"]");
	private By practiseFrom=By.xpath("//span[text()='Practice Form']");
	private By firstName = By.id("firstname");
    private By lastName = By.id("lastname");
    private By userName = By.id("userName");
    private By password = By.id("password");
    private By registerSubmit = By.id("register");
	
	public RegisterPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void clickRegister()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(forms).click();
		driver.findElement(practiseFrom).click();
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
