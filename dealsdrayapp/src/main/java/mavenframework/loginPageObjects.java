package mavenframework;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPageObjects {

	WebDriver driver;
		
		public loginPageObjects(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}

			
		@FindBy(name="username")
		public WebElement username;
		
		@FindBy(name="password")
		public WebElement password;
		
		@FindBy(xpath="//button[@type='submit']")
		public WebElement loginbutton;
		
		@FindBy(xpath="//span[@class='sidenavHoverShow css-1s178v5'][contains(text(),'Order')]")
		public WebElement leftmenunavorderlinkclick;
		
		@FindBy(xpath="//span[@class='sidenavHoverShow MuiBox-root css-i9zxpg'][contains(text(),'Order')]")
		public WebElement orderslinkclick;
		
		@FindBy(xpath="//button[contains(text(),'Add Bulk Order')]")
		public WebElement bulkorderslinkclick;
		
		@FindBy(id="mui-317")
		public WebElement choosefile;
		
		@FindBy(xpath="//button[contains(text(),'Import')]")
		public WebElement importexcelfile;
		
		@FindBy(xpath="//input[@id='mui-2']")
		public WebElement orderid;
		
		
		
		
		
	}

