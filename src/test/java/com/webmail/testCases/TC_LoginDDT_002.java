package com.webmail.testCases;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.webmail.pageObjects.LoginPage;
import com.webmail.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass{
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws IOException {
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		logger.info("user name provided");
		lp.setPassword(pwd);
		logger.info("password provided");
		lp.clickSubmit();
		
		
		if(driver.getTitle().equals("Login")) {
			
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}
		else {
			captureScreen(driver,"loginDDT");
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
		
}

	
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException{
		
		String path = System.getProperty("user.dir") + "/src/test/java/com/webmail/testData/LoginData.xlsx";
		
		int rownum = XLUtils.getRowCount(path, "Sheet1" );
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][] = new String [rownum][colcount];
		
		for(int i=1; i<=rownum; i++) {
			for(int j=0; j<colcount; j++) {
				
				logindata[i-1][j] = XLUtils.getCellData(path, "Sheet1", i,j);
			}
		}
		return logindata;
	}
	
}
