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
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class TestBase{
	
public WebDriver driver;

@Parameters("browser")
@BeforeClass

public WebDriver launchbrowser(String browser) {
	if (browser.equalsIgnoreCase("chrome")) { 
		
		ChromeOptions opts = new ChromeOptions();
		opts.addArguments("--start-maximized");
		opts.addArguments("--window-position=1920,1080");
		  //Initialize the chrome driver
		System.setProperty("webdriver.chrome.driver", "/Users/sundar/Documents/driver/chromedriver");
	    driver = new ChromeDriver();

	  } 
	else if(browser.equalsIgnoreCase("firefox")) {
			 
		//Initializing the firefox driver (Gecko)
			  driver = new FirefoxDriver();	  

	  }
	  else if(browser.equalsIgnoreCase("safari")) {
			 
			//Initializing the firefox driver (Gecko)
				  driver = new SafariDriver();	  

		  }
	  else if (browser.equalsIgnoreCase("chrome1366_768")) { 
		
		ChromeOptions opts = new ChromeOptions();
		opts.addArguments("--start-maximized");
		opts.addArguments("--window-position=1366,768");
		  //Initialize the chrome driver
		System.setProperty("webdriver.chrome.driver", "/Users/sundar/Documents/driver/chromedriver");
	    driver = new ChromeDriver();
	    driver.manage().window().setSize(new Dimension(1366,768));
	  } 
	
	  else if (browser.equalsIgnoreCase("chrome1536_864")) { 
			
			ChromeOptions opts = new ChromeOptions();
			opts.addArguments("--start-maximized");
			opts.addArguments("--window-position=1536,864");
			  //Initialize the chrome driver
			System.setProperty("webdriver.chrome.driver", "/Users/sundar/Documents/driver/chromedriver");
		    driver = new ChromeDriver();
		    driver.manage().window().setSize(new Dimension(1536,864));
		  } 
	  else if (browser.equalsIgnoreCase("mobiledimension360_640")) { 
			
		  Map<String, String> mobileEmulation = new HashMap<>();
		  mobileEmulation.put("deviceName", "Galaxy S5");

		  ChromeOptions options = new ChromeOptions();
		  //options.addArguments("--window-position=360,640");
		  options.setExperimentalOption("mobileEmulation", mobileEmulation);
		  ChromeDriver driver = new ChromeDriver(options);
		  }	
	
	  else if (browser.equalsIgnoreCase("mobiledimension414_896")) { 
			
		  Map<String, String> mobileEmulation = new HashMap<>();
		  mobileEmulation.put("deviceName", "Galaxy S5");

		  ChromeOptions options = new ChromeOptions();
		  options.addArguments("--window-position=414,896");
		  options.setExperimentalOption("mobileEmulation", mobileEmulation);
		  ChromeDriver driver = new ChromeDriver(options);
		  }	
	
	  else if (browser.equalsIgnoreCase("mobiledimension375_667")) { 
			
		  Map<String, String> mobileEmulation = new HashMap<>();
		  mobileEmulation.put("deviceName", "Galaxy S5");

		  ChromeOptions options = new ChromeOptions();
		  options.addArguments("--window-position=375,667");
		  options.setExperimentalOption("mobileEmulation", mobileEmulation);
		  ChromeDriver driver = new ChromeDriver(options);
		  }	
	
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    //driver.get("https://www.getcalley.com/");
    driver.get("https://demo.dealsdray.com/"); 
    System.out.println("Launched website successfully");
    File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    try {
        FileUtils.copyFile(screenshot, new File("/Users/sundar/Documents/driver/chromedriver/homePageScreenshot.png"));
    } catch (IOException e) {
        System.out.println(e.getMessage());
    }
    
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
