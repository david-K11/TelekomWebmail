package com.webmail.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver){
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id="usrField")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(id="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(name="submitName")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(linkText ="Упатства")
	@CacheLookup
	WebElement linkUpatstva;
	
	@FindBy(linkText = "Нагодувања за мобилен телефон")
	@CacheLookup
	WebElement linkNagoduvanja;
	
	@FindBy(linkText = "Креирајте бесплатна е-адреса")
	@CacheLookup
	WebElement linkKreirajte;
	
	public void setUserName(String uname) {
		txtUserName.sendKeys(uname);
	}
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	public void clickSubmit() {
		btnLogin.click();
	}
	
	public void clickUpatstva() {
		linkUpatstva.click();
	}
	public void clickNagoduvanja() {
		linkNagoduvanja.click();
	}
	public void clickKreirajte() {
		linkKreirajte.click();
	}
	
}
