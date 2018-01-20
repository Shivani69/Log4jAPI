package com.tests;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class LoginTest {

	WebDriver driver;
	Logger log = Logger.getLogger(LoginTest.class);
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C://Drivers//ChromeDriver//chromedriver.exe");
		   driver =new ChromeDriver();
		   log.info("launching chrome driver");
		   driver.manage().window().maximize();
		   driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://www.freecrm.com");
			log.info("entering application url");
	}
	 @Test(priority=1)
	 public void freeCrmTitleTest(){
	  String title = driver.getTitle();
	   Assert.assertEquals(title, "#1 Free CRM for Any Business: Online Customer Relationship Software");
	 }
	
	 @Test(priority=2)
	 public void freeCRMLogoImageTest() {
	    boolean b = driver.findElement(By.xpath("//img[contains(@class,'img-responsive')]")).isDisplayed();
	    Assert.assertTrue(b);
	 }
	 
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
