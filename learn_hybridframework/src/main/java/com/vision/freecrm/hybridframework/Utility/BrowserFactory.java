package com.vision.freecrm.hybridframework.Utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {

	public  WebDriver driver;

	public WebDriver browserSetUp(String bname, String url) {

		if (bname.equals("firefox")) {

			driver = new FirefoxDriver();
		} else if (bname.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver.exe");

			driver = new ChromeDriver();
		}

		else if (bname.equals("ie")) {

			System.setProperty("webdriver.ie.driver", ".//Drivers//IEDriverServer.exe");

			driver = new InternetExplorerDriver();
		}

		else {
			System.out.println("not compatible with broswer..");
		}

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get(url);

		return driver;
		
	}
	
	public void quitBrowser(){
		
		driver.quit();
	}
}
