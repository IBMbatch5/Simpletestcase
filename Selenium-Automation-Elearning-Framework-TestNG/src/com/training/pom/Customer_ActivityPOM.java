package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Customer_ActivityPOM {
private WebDriver driver; 
JavascriptExecutor js=(JavascriptExecutor) driver;
	
	public Customer_ActivityPOM(WebDriver driver) {
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
	
	@FindBy(xpath="//*[@id=\"menu-report\"]/ul/li[3]/a")
	private WebElement customers;
	
	@FindBy(xpath="//*[@id=\"menu-report\"]/ul/li[3]/ul/li[2]/a")
	private WebElement custActiv;
	
	@FindBy(id="input-customer")
	private WebElement custEntry;
	
	private WebElement ordList;
	
	@FindBy(id="button-filter")
	private WebElement ordfilter;
	
		
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
	
	public void clickCustomers() {
		this.customers.click(); 
	}
	
	public void clickCustOnline() {
		this.custActiv.click();
	}
	
	public void sendCustomerName(String custEntry) {
		this.custEntry.clear(); 
		this.custEntry.sendKeys(custEntry);
	}
	
	
	public void clickFilter() {
		this.ordfilter.click();
			
	}
	
	public void clickLogout() {
		logout.click();
	}
}
