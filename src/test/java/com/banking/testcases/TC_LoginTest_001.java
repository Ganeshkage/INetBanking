package com.banking.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.banking.pageobjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws IOException {
		driver.get(baseUrl);
		logger.info("Enterd URL");

		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Enterd Username");
		
		lp.setPassword(password);
		logger.info("Enterd Password");

		lp.clickSubmit();
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Login Test Passed");

		} else {
			captureScreen(driver,"LoginTest");
			Assert.assertTrue(false);
			
			logger.info("Login Test Failed");
		}

	}
	

}
