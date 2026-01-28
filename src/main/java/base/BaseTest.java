package base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.nio.file.Files;
import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver(); // Selenium Manager which is with selenium version4
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com");
    }
    
    public String captureScreenshot(String testName) 
    {
    	TakesScreenshot ts = (TakesScreenshot) driver;
    	File src =ts.getScreenshotAs(OutputType.FILE);
    	String path ="test-output/screenshots/"+testName+".png";
    	try {
    		Files.createDirectories(new File("test-output/screenshots/").toPath());
    		Files.copy(src.toPath(), new File(path).toPath());
    		
    		
			
		} catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		return path;
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}