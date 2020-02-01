package com.vision.freecrm.hybridframework.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vision.freecrm.hybridframework.Utility.Helper;

public class HomePage {

	 WebDriver driver;
	
	@FindBy(xpath="//a[text()='Contacts']")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[text()='New Contact']")
	WebElement newContactsLink;
	
	@FindBy(xpath="//td[@align='left' and @class='headertext']")
	WebElement loggedUserName;
	
	
	public HomePage(WebDriver driver){
				this.driver=driver;
				PageFactory.initElements(driver, this);
	}
	
	public String verifyloggedUserName(){
	return loggedUserName.getText();		
	}
	// i frame name : mainpanel
	public NewContactPage navigateToNewContactsPage(){			
		Helper.mouseHoverAndClickActions(driver, 
				contactsLink,newContactsLink);
		//newContactsLink.click();
		return new NewContactPage(driver);	
	}
}
