package base;

import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;




public class BaseTest {

    protected WebDriver driver;
    
    private static final Logger log = LogManager.getLogger(BaseTest.class);
    
   
    
    @BeforeMethod
    public void setUp() {
    	log.info("===== Test execution started =====");
    
        driver = new ChromeDriver(); // Selenium Manager which is with selenium version4
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com");
        
        log.info("Launching browser");
    }
    
        
    public String captureScreenshot(String testName)  {
    	
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS")
                .format(new Date());

        String fileName = testName + "_" + timestamp + ".png";

        Path destination = Paths.get("test-output/screenshots/" + fileName);

        try {
        	((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.createDirectories(destination.getParent());

            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            Files.copy(src.toPath(), destination, StandardCopyOption.REPLACE_EXISTING);

        } catch (NoSuchSessionException | IOException e) {
            System.out.println("Driver already closed. Screenshot skipped.");
        }

        return destination.toString();
    }


    @AfterMethod
    public void tearDown(ITestResult result)
    {
        if (result.getStatus() == ITestResult.FAILURE)
        {
            captureScreenshot(result.getName());
        }
        if (driver != null) {
            driver.quit();
        }
    }
    }

    
