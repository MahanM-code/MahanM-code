	package pages;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;

	public class LaunchPage {

	    private WebDriver driver;
	   
	    private By bookStoreApp = By.xpath("//*[text()='Book Store Application']");

	    public LaunchPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void openBookStoreApplication() {
	        driver.findElement(bookStoreApp).click();
	    }
	}


