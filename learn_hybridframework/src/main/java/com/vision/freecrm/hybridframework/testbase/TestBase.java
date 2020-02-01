package com.vision.freecrm.hybridframework.testbase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import com.vision.freecrm.hybridframework.utility.BrowserFactory;
import com.vision.freecrm.hybridframework.utility.ConfigDataProvider;
import com.vision.freecrm.hybridframework.utility.ExcelDataProvider;
import com.vision.freecrm.hybridframework.utility.Helper;


public class TestBase {

	public ConfigDataProvider configDataProvider;	
	public BrowserFactory browserFactory;
	public ExcelDataProvider excelDataProvider;
	public Helper helper;
	
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
		browserFactory.quitBrowser();
	}

}
