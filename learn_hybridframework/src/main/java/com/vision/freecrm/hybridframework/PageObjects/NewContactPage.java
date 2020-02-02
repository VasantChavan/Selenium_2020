package com.vision.freecrm.hybridframework.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vision.freecrm.hybridframework.Utility.Helper;

public class NewContactPage {

	WebDriver driver;
	
	@FindBy(name="title")
	WebElement titleDD;
	
	@FindBy(id="first_name")
	WebElement fname;
	
	@FindBy(id="surname")
	WebElement lname;
	
	@FindBy(name="suffix")
	WebElement suffixDD;
	
	@FindBy(xpath="//*[@id='contactForm']/table/tbody/tr[1]/td/input[2]")
	WebElement saveBtn;
	
	
	public NewContactPage(WebDriver ldriver){
			this.driver=ldriver;
			PageFactory.initElements(driver, this);
	}
	
	
	public void createNewAccounts()
	{
		Helper.selectDropDown(titleDD, 3);
		fname.clear();
		fname.sendKeys("Vivek");
		lname.clear();
		lname.sendKeys("Ramarao");
		Helper.selectDropDown("PhD",suffixDD);
		saveBtn.click();
		
	}
}
