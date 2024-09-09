package mavenframework;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class DealsdrayAppParallelTest extends TestBase{


	@Test (priority=1, groups = { "Logintests" }, enabled=true)
	public void launchgetcalleyapp() throws InterruptedException {
		//Tests too Launch app in multiple browsers and resolutions
		getdealsdrayapppagetitle(); 
		//verify404error(); 
	}
		}

