package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RTTC58_DiscounttoproductPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class RTTC58_DiscountTo_ProductTest {

	private WebDriver driver;
	private String baseUrl;
	private RTTC58_DiscounttoproductPOM disctoProdPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private String today;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		disctoProdPOM = new RTTC58_DiscounttoproductPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test(priority=1)
	public void validLoginTest() {
		disctoProdPOM.sendUserName("admin");
		disctoProdPOM.sendPassword("admin@123");
		disctoProdPOM.clickLoginBtn(); 
		disctoProdPOM.clickMarketing();
		disctoProdPOM.clickCoupons();
		disctoProdPOM.clickAddnewbt();
		screenShot.captureScreenShot("RTTC58_Coupons page");
		disctoProdPOM.sendCouponsname("Diwali discount");
		disctoProdPOM.sendCodeText("Dwl");
		disctoProdPOM.sendDiscountText("10");
		disctoProdPOM.sendProductText("phone");
		disctoProdPOM.selectStartDate();
		disctoProdPOM.selectTodayDate();
		disctoProdPOM.selectEndDate("2019-03-22");
		System.out.println("dates are clicked");
		disctoProdPOM.clickSubmit();
		disctoProdPOM.clickLogout();
	
	}
}
