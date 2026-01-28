package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	
	private By userName = By.id("userName");
	private By password = By.id("password");
    private By loginBtn = By.xpath("//button[text()='Login']");
    private By profileName = By.id("userName-value");
    
    
    public LoginPage(WebDriver driver)
    {
    	this.driver=driver;
    }
    
//    public void login(String MahanM )
//    {
//    	driver.findElement(userName).sendKeys(MahanM);
//    	driver.findElement(password).sendKeys("Mahan@143");
//    	driver.findElement(loginBtn);
//    	driver.findElement(loginBtn).click();
//    	
//    }
    public void login(String username,String pwd)
    {
    	driver.findElement(userName).sendKeys(username);
    	driver.findElement(password).sendKeys(pwd);
    	driver.findElement(loginBtn).click();
    	
    }

    
    public String getLoggedInUser()
    {
		return driver.findElement(profileName).getText();
    	
    }
    

}
