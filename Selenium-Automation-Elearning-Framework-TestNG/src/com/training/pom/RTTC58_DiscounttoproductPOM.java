package com.training.pom;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RTTC58_DiscounttoproductPOM {
private WebDriver driver; 
String Tdydate;
String SucMsg;

	
	public RTTC58_DiscounttoproductPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="username")
	private WebElement userName; 
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//*[@id=\"button-menu\"]")
	private WebElement buttonMenu;
	
	@FindBy(xpath="//li[@id='menu-marketing']")
	private WebElement marketing;
	
	@FindBy(xpath="//*[@id=\"menu-marketing\"]/ul/li[3]/a")
	private WebElement coupons;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div/a")
	private WebElement addnewbt;
	
	@FindBy(id="input-name")
	private WebElement couponsname; 
	
	@FindBy(id="input-code")
	private WebElement code;
	
	@FindBy(id="input-discount")
	private WebElement discounttext; 
	
	@FindBy(id="input-product")
	private WebElement producttext;
	
	//startdate
	@FindBy(xpath="//div[10]//div[1]//div[1]//span[1]//button[1]")
	private WebElement startdate;
	
	
	//todaydateselection
		@FindBy(xpath="/html/body/div[2]/div/div[1]/table/tbody/tr[4]/td[2]")
		private WebElement todaydate;
	
	//enddate
	@FindBy(xpath="//input[@id='input-date-end']")
	//div[11]//div[1]//div[1]//span[1]//button[1]")
	private WebElement enddate;
	
	//logout path
	@FindBy(xpath="//*[@id=\"header\"]/ul/li[4]/a")
	private WebElement logout;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement submit;
	
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	public void clickButtonMenu() {
		this.buttonMenu.click(); 
	}
	
	public void clickMarketing() {
		this.marketing.click(); 
	}
	
	public void clickCoupons() {
		this.coupons.click(); 
	}
	
	public void clickAddnewbt() {
		this.addnewbt.click(); 
		
	}
	
	public void sendCouponsname(String CN) {
		this.couponsname.clear();
		this.couponsname.sendKeys(CN);
	}
	
	public void sendCodeText(String CD) {
		this.code.clear(); 
		this.code.sendKeys(CD); 
	}
	
	public void sendDiscountText(String DT) {
		this.discounttext.clear();
		this.discounttext.sendKeys(DT);
	}
	
	public void sendProductText(String PT) {
		this.producttext.clear(); 
		this.producttext.sendKeys(PT); 
	}
	
	//Startdate
	public void selectStartDate() {
		this.startdate.click();
		System.out.println("start date selected");
		
	}
	
	public void selectTodayDate() {
		this.todaydate.click();
		
		//get the value of today's date
		String Tdydate = driver.findElement(By.xpath("//input[@id='input-date-start']")).getAttribute("Value");
		System.out.println("Today date is ="+Tdydate);
		}
	//To select end date
	public void selectEndDate(String ED) {
		this.enddate.clear(); 
		this.enddate.sendKeys(ED);
		//this.enddate.click(); 
		System.out.println("end date entered");
	}
	public void clickSubmit() {
		this.submit.click();
		//assert message
		SucMsg = driver.getPageSource();
		Assert.assertTrue(SucMsg.contains("Success"), "Success: You have modified coupons");
		System.out.println("Assert verified on success message");
	}
	
	//logout
	public void clickLogout() {
		logout.click();
	}
}
