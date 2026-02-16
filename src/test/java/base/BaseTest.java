package base;

import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import utils.ExtentManager;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;




public class BaseTest {

    protected WebDriver driver; //Makes driver available to all child test classes Any test extending BaseTest can use driver directly
    
    //Used for logging test execution steps
    //Professional logging instead of System.out.println
    private static final Logger log = LogManager.getLogger(BaseTest.class);
    
   
    
    @BeforeMethod 
    @Parameters({"browser", "execution"})
    public void setUp(
            @Optional("chrome") String browser,
            @Optional("local") String execution) throws Exception
{ //Runs before EVERY test method,even you can keep this for everybefore suite also Prepares browser environment
    	log.info("===== Test execution started =====");
    
    	   	
    	//Parameter shouldbe LOCAL with UI mode then it will pick the below line of code locally
    	if (execution.equalsIgnoreCase("local")) {

            switch (browser.toLowerCase()) {

                case "chrome":
                                       
                    driver = new ChromeDriver();
                    break;

                case "firefox":
                    
                    driver = new FirefoxDriver();
                    break;

                default:
                    throw new Exception("Browser not supported: " + browser);
            }
    	}

        
        else if (execution.equalsIgnoreCase("remote")) {

            String gridUrl = "http://localhost:4444/wd/hub";
            if (browser.equalsIgnoreCase("chrome")) {
	            ChromeOptions options = new ChromeOptions();
	            driver = new RemoteWebDriver(
	                    new URL(gridUrl),
	                    options);
	            log.info("Execution Type: " + execution);
	            log.info("Browser Selected: " + browser);
	            
	        }
	        
	        

	        else if (browser.equalsIgnoreCase("firefox")) {
	            FirefoxOptions options = new FirefoxOptions();
	            driver = new RemoteWebDriver(
	                    new URL(gridUrl),
	                    options);
	            log.info("Execution Type: " + execution);
	            log.info("Browser Selected: " + browser);
	        }
        }
    	
    	//Parameter is CHROME and want to run it locally with the Headless with git actions then execute the same
    	if (browser.equalsIgnoreCase("chrome")) //if not remote then run it in the local level with chrome
        {
                   ChromeOptions chromeOptions = new ChromeOptions();

                    // Headless support for CI (GitHub Actions)
                    if (System.getProperty("ci") != null) {
                        chromeOptions.addArguments("--headless=new");
                        chromeOptions.addArguments("--no-sandbox");
                        chromeOptions.addArguments("--disable-dev-shm-usage");
            driver = new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("firefox")) { //if not remote then run it in the local with firefox
            driver = new FirefoxDriver();
        }

    	    driver.manage().window().maximize();
    	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	    driver.get("https://demoqa.com");

    	    log.info("Browser Launched Successfully");
    	    
    	        	    
    	    //driver.quit();
    	}

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com");

        log.info("Browser launched successfully");
    }
    	/*
        driver = new ChromeDriver(); // Selenium Manager which is with selenium version4
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com");
        
        log.info("Launching browser");
    }*/
    
        
    public String captureScreenshot(String testName)  { //automatically capture screenshot when a test fails 
    	//callig this method on on test failure in the testNG listers
    	
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


    @AfterMethod //Runs after EVERY test method //Cleanup activity
    public void tearDown(ITestResult result)
    {
        if (result.getStatus() == ITestResult.FAILURE)
        {
            captureScreenshot(result.getName());
        }
        if (driver != null) 
        {
            driver.quit();
        }
    }
    }

/*The BaseTest class is used as a parent class to provide common functionalities required for all test classes.
It handles WebDriver initialization, browser setup, implicit waits, and application launch using the @BeforeMethod annotation.
It also contains a reusable screenshot utility method to capture screenshots on test failure.
The @AfterMethod is used to capture failure screenshots and close the browser after each test.
This avoids code duplication and ensures reusability, maintainability, and better framework structure.*/

    
