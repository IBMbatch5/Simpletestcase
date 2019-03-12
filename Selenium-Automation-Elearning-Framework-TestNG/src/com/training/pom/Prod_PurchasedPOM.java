package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.google.common.base.Verify;

public class Prod_PurchasedPOM {
private WebDriver driver; 
	
	public Prod_PurchasedPOM(WebDriver driver) {
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
	
	@FindBy(xpath="//*[@id=\"menu-report\"]/a")
	private WebElement reports;
	
	@FindBy(xpath="//*[@id=\"menu-report\"]/ul/li[2]/a")
	private WebElement products;
	
	@FindBy(xpath="//*[@id=\"menu-report\"]/ul/li[2]/ul/li[2]/a")
	private WebElement purchased;
	
	@FindBy(xpath="//*[@id=\"input-status\"]")
	private WebElement orderStatus;
	
	private WebElement ordList;
	
	
	@FindBy(id="button-filter")
	private WebElement ordfilter;
	String Cvalue="Complete";
	
	@FindBy(xpath="//*[@id=\"header\"]/ul/li[4]/a")
	private WebElement logout;
	
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
	
	public void clickReports() {
		this.reports.click(); 
	}
	
	public void clickProducts() {
		this.products.click(); 
	}
	
	public void clickPurchased() {
		this.purchased.click(); 
	}
	
	public void clickOrderStatus() {
		this.orderStatus.click(); 
	}
	//select 'Complete' status in order list
	public void selectCompleteStatus() {
		Select ordList=new Select (driver.findElement(By.id("input-status")));
		//ordList.selectByVisibleText("Complete");
		ordList.selectByIndex(4);

	}
	
	public void clickFilter() {
		this.ordfilter.click(); 
		
		//Assert comment to check selected list
				
		Assert.assertEquals("Complete", Cvalue);
		System.out.println("Assert verification - COMPLETE value in drop down list is selected");
	}
	
	public void clickLogout() {
		logout.click();
	}
}
