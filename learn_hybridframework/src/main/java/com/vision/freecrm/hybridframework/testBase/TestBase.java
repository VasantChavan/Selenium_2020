package com.vision.freecrm.hybridframework.testBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.vision.freecrm.hybridframework.PageObjects.HomePage;
import com.vision.freecrm.hybridframework.PageObjects.LoginPage;
import com.vision.freecrm.hybridframework.PageObjects.NewContactPage;
import com.vision.freecrm.hybridframework.Utility.BrowserFactory;
import com.vision.freecrm.hybridframework.Utility.ConfigDataProvider;
import com.vision.freecrm.hybridframework.Utility.ExcelDataProvider;
import com.vision.freecrm.hybridframework.Utility.Helper;


public class TestBase {

	public ConfigDataProvider configDataProvider;	
	public BrowserFactory browserFactory;
	public ExcelDataProvider excelDataProvider;
	public Helper helper;
	
	public LoginPage login;
	public WebDriver driver;
	public HomePage homepage;
	public NewContactPage newContactsPage;
	
	@BeforeMethod
	public void setUp()
	{
		driver=browserFactory.browserSetUp(
				configDataProvider.getKey("browser"), 
				configDataProvider.getKey("qaUrl"));
		//login=PageFactory.initElements(driver,LoginPage.class );
		 login=new LoginPage(driver);
		 homepage=login.verifyLoginIntoAnApplication(configDataProvider.
					getKey("uname"),
					configDataProvider.getKey("upass"));
		 helper.switchToIFrame(driver, "mainpanel");
		 newContactsPage = homepage.navigateToNewContactsPage();
	}
	
	@BeforeSuite
	public void init() {
		
		helper=new Helper();
		excelDataProvider=	new ExcelDataProvider();
		configDataProvider=new ConfigDataProvider();
		browserFactory=new BrowserFactory();
			/*driver = BrowserFactory.browserSetUp("chrome", 
				"https://www.crmpro.com/");*/
	}
	
	@AfterMethod
	public void tearDown(){
		//browserFactory.quitBrowser();
	}

}
