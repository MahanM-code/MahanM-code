package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
	
	private WebDriver driver;
	
	private By registerBtn =By.id("newUser");
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
		driver.findElement(registerBtn).click();
	}
	
	public void registerUser(String fName, String lName,String uName,String pwd)
	{
		driver.findElement(firstName).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
        driver.findElement(userName).sendKeys(uName);
        driver.findElement(password).sendKeys(pwd);
        
     // CAPTCHA is manual on demoqa
        //MahanM
        //Mahan@143
        System.out.println("Please complete CAPTCHA manually");
	}

}
