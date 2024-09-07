package mavenframework;

import org.testng.annotations.Test;

public class DealsdrayLoginPageTest extends TestBase{
	
	public loginPageObjects ls;
	
	@Test (priority=0, groups = { "Logintests" })
	  public void Launchapp() throws InterruptedException {
		  ls = new loginPageObjects(driver);
	      Thread.sleep(5000);
	}

	@Test (priority=1, groups = { "smoketests", "Logintests" }, enabled=true)
	public void Logintoapp() throws InterruptedException {
	getdealsdrayapppagetitle(); // Verify App page title
	ls.username.sendKeys("prexo.mis@dealsdray.com");
    ls.password.sendKeys("prexo.mis@dealsdray.com");
    ls.loginbutton.click();
    Thread.sleep(5000);
    System.out.println("Logged in successfully");
	}
	
	
	@Test (priority=2, groups = { "smoketests" }, enabled=true)
	public void uploadfile() throws InterruptedException {
		
		ls.leftmenunavorderlinkclick.click();
		if(ls.orderslinkclick.isDisplayed())
		{
			ls.orderslinkclick.click();		}
		else 
			{System.out.println("unable to locate Orders link");
			}
			ls.bulkorderslinkclick.click();
			//upload data file using sendkeys
			ls.choosefile.click();
			ls.choosefile.sendKeys("/Users/jaya/javabasics/mavenframework/demo-data.xlsx");
			Thread.sleep(3000);
			ls.importexcelfile.click();
			//After upload, verify orders are present
			ls.orderid.isDisplayed();
	}
}