package com.vision.freecrm.hybridframework.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vision.freecrm.hybridframework.pages.LoginPage;
import com.vision.freecrm.hybridframework.testbase.TestBase;

public class LoginPageTest extends TestBase{

	public LoginPage login;
	public WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		driver=browserFactory.browserSetUp(
				configDataProvider.getKey("browser"), 
				configDataProvider.getKey("qaUrl"));
		//login=PageFactory.initElements(driver,LoginPage.class );
		login=new LoginPage(driver);
	}
	
	/*@Test(dataProvider="getData")
	public void verifyLoginTest(String uname, String upass){
		
		login.verifyLogin(uname, upass);
		helper.captureScreenshots(driver,"crm_login");
	}
	
	@DataProvider
	public Object [][] getData(){		
		return excelDataProvider.getExcelData("login_smoke");
		}*/
	
	
	@Test(priority=1)
	public void verifyLoginPageTitleTest()
	{
		String actualTitle=login.verifyLoginPageTitle();
		System.out.println("actual title of the login page is :"+actualTitle);
		String expectedTitle="CRMPRO - CRM software for customer relationship management, sales, and support.";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	/*@Test(priority=2)
	public void verifyLoginTest(){
	
		login.verifyLogin(excelDataProvider.getStringCellData(1, 1, 0), 
				excelDataProvider.getStringCellData(1, 1, 1));		
		helper.captureScreenshots(driver,"freecrm_login");
	}*/
	
	@Test(priority=2)
	public void verifyLoginIntoAnApplicationTest()
	{
		login.verifyLoginIntoAnApplication(configDataProvider.
				getKey("uname"),
				configDataProvider.getKey("upass"));		
		
		//driver.switchTo().frame("mainpanel");
		
		helper.switchToIFrame(driver,"mainpanel");
		
		WebElement username=driver.findElement
				(By.xpath("//td[@align='left' and @class='headertext']"));
		
		String user=username.getText();
		
		System.out.println("logged in user name is :"+user);
		
		if(user.contains("Mayuri")){
			//Assert.assertTrue(userText.contains("Mayuri"));
			Assert.assertTrue(true);
		}
		else{
			Assert.assertTrue(false);
		}
		
	}
	
}
