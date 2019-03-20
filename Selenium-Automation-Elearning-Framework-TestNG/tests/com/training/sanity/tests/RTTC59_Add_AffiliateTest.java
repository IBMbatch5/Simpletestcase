package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RTTC59_AddaffiliatePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC59_Add_AffiliateTest {
	private WebDriver driver;
	private String baseUrl;
	private RTTC59_AddaffiliatePOM addaffiliatePOM;
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
		addaffiliatePOM = new RTTC59_AddaffiliatePOM(driver); 
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
	public void validLoginTest() throws InterruptedException {
		addaffiliatePOM.sendUserName("admin");
		addaffiliatePOM.sendPassword("admin@123");
		addaffiliatePOM.clickLoginBtn(); 
		addaffiliatePOM.clickMarketing();
		addaffiliatePOM.clickAffiliates();
		addaffiliatePOM.clickAddbt();
		addaffiliatePOM.sendFirstName("Firstname");
		addaffiliatePOM.sendLastName("Lastname");
		addaffiliatePOM.sendEmail("emailtest@gmail.com");
		addaffiliatePOM.sendTelephone("9197581413");
		addaffiliatePOM.sendTrackingcode("abcd123");
		addaffiliatePOM.sendAffPassword("password");
		addaffiliatePOM.sendConfPassword("password");
		addaffiliatePOM.sendAddress1("Address1");
		addaffiliatePOM.sendAddress2("Address2");
		addaffiliatePOM.sendCity("Chennai");
		addaffiliatePOM.sendPostcode("600015");
		addaffiliatePOM.selectCountry();
		addaffiliatePOM.selectZone();
		addaffiliatePOM.clickPaymentDetails();
		addaffiliatePOM.sendChequePayeeName("Cheque");
		addaffiliatePOM.clickSaveButton();
		screenShot.captureScreenShot("RTTC59-Affiliates added");
		addaffiliatePOM.clickLogout();
					
	}
}
