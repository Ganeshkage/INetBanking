package com.banking.testcases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.banking.pageobjects.AddCustomerPage;
import com.banking.pageobjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {

	@Test
	public void addNewCustomer() throws InterruptedException, IOException {

		// driver.get(baseUrl);
		logger.info("Enterd URL");

		LoginPage lp = new LoginPage(driver);

		lp.setUserName(username);
		logger.info("Entered Username");
		lp.setPassword(password);
		logger.info("Entered Password");
		lp.clickSubmit();
		logger.info("Submited");

		Thread.sleep(3000);

		AddCustomerPage addCustomer = new AddCustomerPage(driver);

		logger.info("Providing Custome Detailes...");
		addCustomer.clickAddnewCustomer();
		addCustomer.customerName("KrishaSudama");
		addCustomer.customerGender("male");
		addCustomer.customerDob("10", "10", "1990");

		Thread.sleep(3000);

		addCustomer.customerAddress("India");
		addCustomer.customerCity("Hyderabad");
		addCustomer.customerState("Maharashtraa");
		addCustomer.customerPinNo("5000070");
		addCustomer.customerTelephoneNo("7085646897");

		String email = randomeString() + "@gmail.com";
		addCustomer.customerEmailId(email);
		addCustomer.customerPassword("Salarjungama");
		addCustomer.customerSubmit();
		
		Thread.sleep(3000);
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");

		if (res == true) {
			logger.info("My Test case is passed...");
			Assert.assertTrue(true);
		} else {
			logger.info("My TestCase is failed..");
			captureScreen(driver, "AddNewCustomer");
			logger.info("ScreenShot Taken...");
			Assert.assertTrue(false);
		}
	}

	public String randomeString() {
		String generatedString = RandomStringUtils.randomAlphabetic(8);
		return generatedString;
	}

	public String randomeNumber() {
		String generatedNumber = RandomStringUtils.randomNumeric(5);
		return generatedNumber;
	}
}
