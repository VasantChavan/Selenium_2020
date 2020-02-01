package com.vision.freecrm.hybridframework.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vision.freecrm.hybridframework.pages.HomePage;
import com.vision.freecrm.hybridframework.pages.LoginPage;
import com.vision.freecrm.hybridframework.testbase.TestBase;

public class HomePageTest extends TestBase {

	public WebDriver driver;
	LoginPage login;
	HomePage homepage;
	
	@BeforeMethod
	public void setUp(){
		driver=browserFactory.browserSetUp(
				configDataProvider.getKey("browser"), 
				configDataProvider.getKey("qaUrl"));
		//login=PageFactory.initElements(driver,LoginPage.class );
		login=new LoginPage(driver);
		homepage=login.verifyLoginIntoAnApplication(
				excelDataProvider.getStringCellData(1, 1, 0), 
				excelDataProvider.getStringCellData(1, 1, 1));
	}
	
	@Test(priority=1)
	public void verifyloggedUserNameTest(){
		
		helper.switchToIFrame(driver, "mainpanel");
		String uname=homepage.verifyloggedUserName();
		
		if(uname.contains("Mayuri")){
			Assert.assertTrue(true);
		}
		else{
			Assert.assertTrue(false);
		}
	}
	@Test(priority=2)
	public void navigatetoNewContactsPageTest(){
		helper.switchToIFrame(driver, "mainpanel");
		homepage.navigateToNewContactsPage();
	}
		
}  
