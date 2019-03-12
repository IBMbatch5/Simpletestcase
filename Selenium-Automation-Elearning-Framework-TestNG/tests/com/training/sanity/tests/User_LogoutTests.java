package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.LogoutPOM;
import com.training.pom.User_LogoutPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class User_LogoutTests {

	private WebDriver driver;
	private String baseUrl;
	private User_LogoutPOM userPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		userPOM = new User_LogoutPOM(driver); 
		baseUrl = properties.getProperty("baseURL1");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		driver.getPageSource();
	}
	
	
	@Test
	public void validLoginTest() {
		
		userPOM.clickAccountLogin();
				
		//userPOM.clickAccountMenu();
		//screenShot.captureScreenShot("RTTC30-User login page");
		
		userPOM.sendEmail("sobi.smiley@yahoo.in");
				
		userPOM.sendPassword("oviyaa14");
				
		userPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("RTTC30-User Dashboard");
	
		userPOM.Logout();
		screenShot.captureScreenShot("RTTC30-Logged out");
		
		//get the page source to check the line display
		String logoutpage = driver.getPageSource();
		Assert.assertTrue(logoutpage.contains("You have been logged off your account"));
		System.out.println("You have been logged off your account. It is now safe to leave the computer");
	}
		
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
}


