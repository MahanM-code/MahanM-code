package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSelenium {

    public static void main(String[] args) {

        // Launch Chrome browser
    	
    	WebDriver driver= new ChromeDriver();

        // Maximize window
        driver.manage().window().maximize();
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//selenium 4 syntax

        // Open URL
        //driver.get("https://www.google.com");
        
        driver.navigate().to("https://www.google.com");
        
        driver.navigate().back();
        driver.navigate().forward();

        // Print page title
        System.out.println("Title: " + driver.getTitle());

        // Close browser
        driver.close();
    }
}
