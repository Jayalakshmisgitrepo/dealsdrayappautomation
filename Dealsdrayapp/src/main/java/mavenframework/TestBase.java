package mavenframework;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v85.emulation.Emulation;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class TestBase{
	
public WebDriver driver;

@Parameters("browser")
@BeforeClass

public WebDriver launchbrowser(String browser) throws InterruptedException {
	if (browser.equalsIgnoreCase("chrome")) { 
		
		ChromeOptions opts = new ChromeOptions();
		opts.addArguments("--start-maximized");
		opts.addArguments("--window-position=1920,1080");
		  //Initialize the chrome driver
		System.setProperty("webdriver.chrome.driver", "/Users/jaya/Documents/driver/chromedriver");
	    driver = new ChromeDriver();

	  } 
	else if(browser.equalsIgnoreCase("firefox")) {
			 
		//Initializing the firefox driver (Gecko)
			  driver = new FirefoxDriver();	  

	  }
	  else if(browser.equalsIgnoreCase("safari")) {
			 
			//Initializing the firefox driver (Gecko)
				  driver = new SafariDriver();	Thread.sleep(5000);  

		  }
	  else if (browser.equalsIgnoreCase("chrome1366_768")) { 
		
		ChromeOptions opts = new ChromeOptions();
		opts.addArguments("--start-maximized");
		opts.addArguments("--window-position=1366,768");
		  //Initialize the chrome driver
		System.setProperty("webdriver.chrome.driver", "/Users/jaya/Documents/driver/chromedriver");
	    driver = new ChromeDriver();
	    driver.manage().window().setSize(new Dimension(1366,768));
	  } 
	
	  else if (browser.equalsIgnoreCase("chrome1536_864")) { 
			
			ChromeOptions opts = new ChromeOptions();
			opts.addArguments("--start-maximized");
			opts.addArguments("--window-position=1536,864");
			  //Initialize the chrome driver
			System.setProperty("webdriver.chrome.driver", "/Users/jaya/Documents/driver/chromedriver");
		    driver = new ChromeDriver();
		    driver.manage().window().setSize(new Dimension(1536,864));
		  } 
	  else if (browser.equalsIgnoreCase("mobiledimension360_640")) { 
		  System.setProperty("webdriver.chrome.driver", "/Users/jaya/Documents/driver/chromedriver");
		  Map<String, String> mobileEmulation = new HashMap<>();
		  mobileEmulation.put("deviceName", "Nexus 5");
		  ChromeOptions chromeOptions = new ChromeOptions();
		  chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
		  driver = new ChromeDriver(chromeOptions);
		  }	
	
	 
	
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    //driver.get("https://www.getcalley.com/");
    driver.get("https://demo.dealsdray.com/"); 
    System.out.println("App Launch is successfull");
   /* File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    try {
        FileUtils.copyFile(screenshot, new File("/Users/jaya/Documents/driver/chromedriver/homePageScreenshot.png"));
    } catch (IOException e) {
        System.out.println(e.getMessage());
    }*/
    
return driver;
}

public void navigateback()
{
	driver.navigate().back();
}
@AfterClass
public void closebrowser()
{
	driver.quit();
}

public void getdealsdrayapppagetitle()
{
Assert.assertEquals(driver.getTitle().contains("Prexo"), true);
}

public void verify404error()
{
	Assert.assertTrue(driver.getPageSource().contains("404"));	
}

public void aftertest()
{
	driver.close();
}
}
