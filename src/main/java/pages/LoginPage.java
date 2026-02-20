package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	
	private By FirstName = By.id("firstName");
	private By LastName = By.id("lastName");
    private By loginBtn = By.xpath("//button[text()='Login']");
    private By profileName = By.id("userName-value");
    
    public  LoginPage() {
    	
        this.driver = DriverThread.getDriver();
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
    	driver.findElement(FirstName).isDisplayed();
    	driver.findElement(LastName).isDisplayed();
    	//driver.findElement(loginBtn).click();
    	
    }

    
    public String getLoggedInUser()
    {
		return driver.findElement(profileName).getText();
    	
    }
    

}
