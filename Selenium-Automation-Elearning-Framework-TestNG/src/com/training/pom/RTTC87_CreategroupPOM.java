package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RTTC87_CreategroupPOM {private WebDriver driver; 
JavascriptExecutor js=(JavascriptExecutor) driver;


public RTTC87_CreategroupPOM(WebDriver driver) {
	this.driver = driver; 
	PageFactory.initElements(driver, this);
}


@FindBy(name="username")
private WebElement userName; 

@FindBy(name="password")
private WebElement lnpassword;

@FindBy(xpath="//button[@type='submit']")
private WebElement loginBtn; 

@FindBy(xpath="//*[@id=\"button-menu\"]")
private WebElement buttonMenu;

@FindBy(xpath="//*[@id=\"menu-customer\"]/a")
private WebElement customer;

@FindBy(xpath="//*[@id=\"menu-customer\"]/ul/li[2]/a")
private WebElement custgroup;

@FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div/a")
private WebElement addcustgrp;

@FindBy(name="customer_group_description[1][name]")
private WebElement groupname;

@FindBy(name="customer_group_description[1][description]")
private WebElement description;

@FindBy(xpath="//input[@value='1']")
private WebElement apprnewcust;

@FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div/button")
private WebElement savebtgrp;

// need to click on customer menu again -call customer method for that in test file

@FindBy(xpath="//*[@id=\"menu-customer\"]/ul/li[1]/a")
private WebElement customers;

@FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div/a")
private WebElement customersaddbt;

@FindBy(id="input-customer-group")
private WebElement custgrpdw;

@FindBy(id="input-firstname")
private WebElement firstname;

@FindBy(id="input-lastname")
private WebElement lastname;

@FindBy(id="input-email")
private WebElement email;

@FindBy(id="input-telephone")
private WebElement telephone;

@FindBy(id="input-password")
private WebElement password;

@FindBy(id="input-confirm")
private WebElement confirmpassword;

// include save button method in test file

	
@FindBy(xpath="//*[@id=\"header\"]/ul/li[4]/a")
private WebElement logout;


public void sendUserName(String userName) {
	this.userName.clear();
	this.userName.sendKeys(userName);
}

public void sendLnPassword(String lnpassword) {
	this.lnpassword.clear(); 
	this.lnpassword.sendKeys(lnpassword); 
}

public void clickLoginBtn() {
	this.loginBtn.click(); 
}

public void clickButtonMenu() {
	this.buttonMenu.click(); 
}

public void clickCustomer() {
	this.customer.click();
}

public void clickCustomergroup() {
	this.custgroup.click(); 
}

public void clickCustgrAddbt() {
	this.addcustgrp.click();
}

public void sendgroupname(String groupname) {
	this.groupname.clear(); 
	this.groupname.sendKeys(groupname);
}

public void senddescription(String description) {
	this.description.clear(); 
	this.description.sendKeys(description);
}


public void selectAppropriate() {
	this.apprnewcust.click();
		
}

public void clickSavebt() {
	this.savebtgrp.click();
		
}

public void clickCustomers() {
	this.customers.click();
		
}

public void clickCustAddbt() {
	this.customersaddbt.click();
			
}

//select the drop down value by visible text
public void selectCustgrpdw() {
	Select customergroup = new Select(driver.findElement(By.id("input-customer-group")));
	customergroup.selectByVisibleText("privileged customer");
	System.out.println("Privileged customer is selected");
		
}

public void sendFirstname(String firstname) {
	this.firstname.clear(); 
	this.firstname.sendKeys(firstname);
}

public void sendLastname(String lastname) {
	this.lastname.clear(); 
	this.lastname.sendKeys(lastname);
}

public void sendEmail(String email) {
	this.email.clear(); 
	this.email.sendKeys(email);
}

public void sendTelephone(String telephone) {
	this.telephone.sendKeys(telephone);
}

public void sendPassword(String password) {
	this.password.clear(); 
	this.password.sendKeys(password);
}

public void sendConfirmPassword(String confirmpassword) {
	this.confirmpassword.clear(); 
	this.confirmpassword.sendKeys(confirmpassword);
}

public void clickLogout() {
	logout.click();
}



}
