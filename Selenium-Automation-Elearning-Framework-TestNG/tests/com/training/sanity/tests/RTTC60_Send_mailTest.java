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
import com.training.pom.RTTC60_SendmailPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC60_Send_mailTest {
	private WebDriver driver;
	private String baseUrl;
	private RTTC60_SendmailPOM sendmailPOM;
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
		sendmailPOM = new RTTC60_SendmailPOM(driver); 
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
		sendmailPOM.sendUserName("admin");
		sendmailPOM.sendPassword("admin@123");
		sendmailPOM.clickLoginBtn(); 
		sendmailPOM.clickMarketing();
		sendmailPOM.clickMail();
		sendmailPOM.selectToList();
		sendmailPOM.sendSubjectAllCust("Holi wishes");
		sendmailPOM.sendMsgAllCust("Wish you all happy holi");
		System.out.println("Mail is sent to all cusotmer");
		sendmailPOM.clickSendButton();
		Thread.sleep(6000);
		screenShot.captureScreenShot("RTTC60-All customer default value");
		
		// Products list
		sendmailPOM.selectToListProd();
		Thread.sleep(4000);
		sendmailPOM.sendSubjectProd("Prod to be instock");
		Thread.sleep(6000);
		sendmailPOM.sendMsgProd("Verify the needed products are available in stock");
		Thread.sleep(6000);
		System.out.println("Mail is sent to Product list");
		sendmailPOM.clickSendButton();
		screenShot.captureScreenShot("RTTC60-Product default value");
		sendmailPOM.clickLogout();
	
	}
}
