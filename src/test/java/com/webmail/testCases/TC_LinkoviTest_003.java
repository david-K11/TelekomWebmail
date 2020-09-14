package com.webmail.testCases;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.webmail.pageObjects.LoginPage;

public class TC_LinkoviTest_003 extends BaseClass{
	
	@Test
	public void linkoviTest() throws InterruptedException, IOException {
		
		LoginPage lp = new LoginPage(driver);
		SoftAssert softly = new SoftAssert();
		
		
		//Upatstva
		lp.clickUpatstva();
		logger.info("Clicked on link:Upatstva");
		
		 ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		    driver.switchTo().window(tabs2.get(1));

		    
		    if(driver.getTitle().equals("Makedonski Telekom")) {	
		    	softly.assertTrue(true);
				logger.info("Link is working");
			}
			else {
				captureScreen(driver,"linkoviTest");
				softly.assertTrue(false);
				logger.info("Link is not working");
			}
		    	    
		    driver.close();
		    driver.switchTo().window(tabs2.get(0));
		    
		    driver.manage().deleteAllCookies();
		    
		    		    
		    //Nagoduvanja
			lp.clickNagoduvanja();
			logger.info("Clicked on link:Nagoduvanja");
			
				ArrayList<String> tabs3 = new ArrayList<String> (driver.getWindowHandles());
			    driver.switchTo().window(tabs3.get(1));
			    
			    
			    //PDF
			    	URL urlOfPdf = new URL(driver.getCurrentUrl());
			    	BufferedInputStream fileToParse = new BufferedInputStream(urlOfPdf.openStream());
			    	PDDocument document = PDDocument.load(fileToParse);
			    	String output = new PDFTextStripper().getText(document);

			    
				    if(output.contains("мобилни телефони")) {			
				    	softly.assertTrue(true);
						logger.info("Link is working");
					}
					else {
						captureScreen(driver,"linkoviTest");
						softly.assertTrue(false);
						logger.info("Link is not working");
					}	
			    	
				document.close();
			    	
			    driver.close();
			    driver.switchTo().window(tabs3.get(0));		    
			    driver.manage().deleteAllCookies();
			    
					    
			    //Kreirajte
				lp.clickKreirajte();
				logger.info("Clicked on link:Kreiraj");
				
				 ArrayList<String> tabs4 = new ArrayList<String> (driver.getWindowHandles());
			     driver.switchTo().window(tabs4.get(1));
				   	    
			    
				    
				    if(driver.getTitle().equals("Makedonski Telekom")) {			
				    	softly.assertTrue(true);
						logger.info("Link is working");
					}
					else {
						captureScreen(driver,"linkoviTest");
						softly.assertTrue(false);
						logger.info("Link is not working");
					}
				    
				    softly.assertAll();			    
				    driver.close();
				    driver.switchTo().window(tabs4.get(0));			    
	}	
	
}

