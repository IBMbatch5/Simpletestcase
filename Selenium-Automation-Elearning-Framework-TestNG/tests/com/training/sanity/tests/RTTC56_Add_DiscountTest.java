package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RTTC56_AdddiscountPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC56_Add_DiscountTest {
	private WebDriver driver;
	private String baseUrl;
	private RTTC56_AdddiscountPOM adddiscPOM;
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
		adddiscPOM = new RTTC56_AdddiscountPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		driver.get(baseUrl);
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test(priority=1)
	public void validLoginTest() throws InterruptedException {
		adddiscPOM.sendUserName("admin");
		adddiscPOM.sendPassword("admin@123");
		adddiscPOM.clickLoginBtn(); 
		adddiscPOM.clickButtonMenu();
		adddiscPOM.clickCatalog();
		adddiscPOM.clickProducts();
		adddiscPOM.clickEdit();
		System.out.println("Add product page is displayed");
		screenShot.captureScreenShot("RTTC56-Add products page");
		adddiscPOM.clickDatatab();
		adddiscPOM.sendDataQuantity("45");
		System.out.println("45 value is entered");
		adddiscPOM.clickDiscounttab();
		adddiscPOM.clickDiscAddbt();
		System.out.println("Add button in discount tab is clicked");
		adddiscPOM.sendDiscQuantity("1");
		System.out.println("Discount Quantity is entered");
		adddiscPOM.sendPrice("50");
		System.out.println("Discount price is entered");
		
		//Get Today's number
        today = getCurrentDay();
        System.out.println("Today's date="+today);
         
        // datepickers
        driver.findElement(By.xpath("//td[5]//div[1]//span[1]//button[1]")).click();
             		//html[1]/body[1]/div[5]")).click();
        System.out.println("Calendar is selected");
         
        //This is from date picker table
        WebElement dateWidgetFrom = driver.findElement(By.xpath("//html[1]/body[1]/div[5]/div[1]/div[1]/table[1]/tbody[1]"));
        //  /html[1]/body[1]/div[5]/div[1]/div[1]/table[1]/tbody[1]/tr[4]/td[4]  -- to today date
        // until before to table rows/column tr/td --- /html[1]/body[1]/div[5]/div[1]/div[1]/table[1]/tbody[1]
        System.out.println("Today date is selected");
         
        //columns of the from date picker table
        List<WebElement> columns = dateWidgetFrom.findElements(By.tagName("td"));
       
        for (WebElement cell: columns) {
                        
            //Select Today's Date
           if (cell.getText().equals(today)) {
                cell.click();
                break;
            }
          }
         
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       	    
        System.out.println("start date is entered");
        adddiscPOM.sendEndDate("2019-03-22");
        System.out.println("End date is entered");
        adddiscPOM.clickSaveButton();
        System.out.println("Save button clicked");
        screenShot.captureScreenShot("RTTC56-Discount added");
        adddiscPOM.clickLogout();
    }
     
	//Get The Current Day
	private String getCurrentDay (){
	//Create a Calendar Object
	Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
	
	//Get Current Day as a number
	int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
	System.out.println("Today Int: " + todayInt +"\n");
	
	//Integer to String Conversion
	String todayStr = Integer.toString(todayInt);
	System.out.println("Today Str: " + todayStr + "\n");
	
	return todayStr;
	}
}
