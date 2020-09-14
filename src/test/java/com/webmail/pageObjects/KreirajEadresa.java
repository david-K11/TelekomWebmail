package com.webmail.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class KreirajEadresa {
	
	WebDriver ldriver;
	
	public KreirajEadresa(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how = How.XPATH, using="//*[@id=\"middle-wrapper\"]/div[2]/div/div[1]/div[2]/input")
	@CacheLookup
	WebElement txtCustomerName;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"middle-wrapper\"]/div[2]/div/div[3]/div[2]/input")
	@CacheLookup
	WebElement txtAddress;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"middle-wrapper\"]/div[2]/div/div[5]/div[2]/select")
	@CacheLookup
	WebElement ddmCity;

	@FindBy(how = How.XPATH, using = "//*[@id=\"middle-wrapper\"]/div[2]/div/div[7]/div[2]/input")
	@CacheLookup
	WebElement txtPhone;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"middle-wrapper\"]/div[2]/div/div[9]/div[2]/input")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"middle-wrapper\"]/div[2]/div/div[11]/div[2]/input")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"middle-wrapper\"]/div[2]/div/div[13]/div[2]/input")
	@CacheLookup
	WebElement txtConfirmPassword;
	
	@FindBy(how = How.PARTIAL_LINK_TEXT,using = "условите за користење")
	@CacheLookup
	WebElement linkUslovi;	
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"middle-wrapper\"]/div[2]/div/p[4]/input")
	@CacheLookup
	WebElement chkAgree;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"middle-wrapper\"]/div[2]/div/input")
	@CacheLookup
	WebElement btnSubmit;
	
	
	public void custName(String cname) {
		txtCustomerName.sendKeys(cname);
	}
	public void custAddress(String caddress) {
		txtAddress.sendKeys(caddress);
	}
	public  void custCity(String index) {
	      Select city = new Select(ddmCity);
	      city.selectByValue(index);  
	}
	public void custPhone (String cphone) {
		txtPhone.sendKeys(cphone);
	}
	public void custUserName(String uname) {
		txtUserName.sendKeys(uname);
	}
	public void custPassword(String cpassword) {
		txtPassword.sendKeys(cpassword);
	}
	public void custconfPassword(String ccpassword) {
		txtConfirmPassword.sendKeys(ccpassword);
	}
	public void custConditions() {
		linkUslovi.click();
	}
	public void custAgree() {
		chkAgree.click();
	}
	public void custSubmit() {
		btnSubmit.click();
	}
	
	
	
}