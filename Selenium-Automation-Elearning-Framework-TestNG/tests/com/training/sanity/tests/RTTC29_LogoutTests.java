package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.LogoutPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC29_LogoutTests {

	private WebDriver driver;
	private String baseUrl;
	private LogoutPOM logoutPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	
	@Test(priority=1)
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@Test(priority=2)
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		logoutPOM = new LogoutPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@Test(priority=5)
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test(priority=3)
	public void validLoginTest() {
		logoutPOM.sendUserName("admin");
		screenShot.captureScreenShot("RTTC29-Username entered");
		logoutPOM.sendPassword("admin@123");
		screenShot.captureScreenShot("RTTC29-Password entered");
		screenShot.captureScreenShot("Login Page");
		logoutPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("RTTC29-Admin Dashboard");
	}
	
	@Test(priority=4)
	public void LogoutTest() {
		logoutPOM.clickLogout(); 
		screenShot.captureScreenShot("RTTC29-Admin Homepage");
		
		//assertion to check the logout page
		String Pagetitle = driver.getTitle();
		//System.out.println("Page title = "+Pagetitle);
		Assert.assertEquals("Administration", Pagetitle);
		System.out.println("Assert verification - Logout successfull");
	}
	
}


