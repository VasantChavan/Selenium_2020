package com.vision.freecrm.hybridframework.testcases;

import org.testng.annotations.Test;

import com.vision.freecrm.hybridframework.testBase.TestBase;

public class NewContactsPageTest extends TestBase {

	@Test
	public void createNewAccountsTest()
	{
		//helper.switchToIFrame(driver, "mainpanel");
		newContactsPage.createNewAccounts();
		
	}
}
