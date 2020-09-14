package com.webmail.testCases;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.webmail.pageObjects.KreirajEadresa;
import com.webmail.pageObjects.LoginPage;

public class TC_KreirajEadresa_004 extends BaseClass{
	
	
	@Test
	public void KreirajEsmetka() throws InterruptedException, IOException {
		
		LoginPage lp = new LoginPage(driver);
		
		lp.clickKreirajte();
		logger.info("Clicked on link");
		
		 ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		    driver.switchTo().window(tabs2.get(1));
		   	    
		    
		    if(driver.getTitle().equals("Makedonski Telekom")) {			
				Assert.assertTrue(true);
				logger.info("Link is working");
			}
			else {
				captureScreen(driver,"KreirajEsmetka");
				Assert.assertTrue(false);
				logger.info("Link is not working");
			}
		  
		   KreirajEadresa ka = new KreirajEadresa(driver);
		   ka.custName("David Kuzmanovski");
		   logger.info("Name and Surname are entered");
		   ka.custAddress("Oktomvriska 45");
		   logger.info("Adress is entered");
		   ka.custCity("Куманово");
		   logger.info("City is entered");
		   ka.custPhone("078123456");
		   logger.info("Phone number is entered");
		   
		   String custusername = randomestring();
		   
		   ka.custUserName(custusername);
		   logger.info("Username is entered");
		   
		   String custpass = randomestring() + randomeNum();
		   System.out.println(custpass);
		   
		   ka.custPassword(custpass);
		   logger.info("Password is entered");
		   ka.custconfPassword(custpass);
		   logger.info("Password is confirmed");
		   ka.custAgree();
		   logger.info("I Agree is checked");
		   
//		   ka.custSubmit();  the site is live now so the submit button is disabled
	   
		    if(driver.getPageSource().contains("Успешно е испратено барање за емаил адреса.")) {			
				Assert.assertTrue(true);
				logger.info("Request for Email successfully sent.");
			}
			else {
				captureScreen(driver,"KreirajEsmetka");
				Assert.assertTrue(false);
				logger.info("Request for Email is not sent.");
			}
		    
	}
}

