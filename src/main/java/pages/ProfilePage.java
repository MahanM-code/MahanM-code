package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {
	private WebDriver driver;
	
	 private By profileName = By.id("userName-value");

	    public ProfilePage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void navigatedToProfilePage(String username) {
	        driver.findElement(profileName).click();
	        driver.findElement(profileName).getText().equals(username);
	    }

}
