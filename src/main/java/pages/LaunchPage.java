	package pages;
	import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

	public class LaunchPage {

	    private WebDriver driver;
	   
	    private By SearchButton = By.xpath("//*[@id=\"nav-search-bar-form\"]");

	  

	    public LaunchPage() {
	    	
	        this.driver = DriverThread.getDriver();
	    }

	    public void checkSearchButton() {
	        driver.findElement(SearchButton).click();
	    }
	}


