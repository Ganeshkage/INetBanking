package com.banking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	WebDriver ldriver;

	public AddCustomerPage(WebDriver rdriver) {
		this.ldriver = rdriver;

		PageFactory.initElements(rdriver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[normalize-space()='New Customer']") // "/html/body/div[3]/div/ul/li/[2]/a")
	WebElement lnkAddNewCustomer;

	@FindBy(how = How.NAME, using = "name")
	WebElement txtCustomerName;

	@FindBy(how = How.NAME, using = "rad1")
	WebElement rdGender;

	@FindBy(how = How.ID_OR_NAME, using = "dob")
	WebElement txtdob;

	@FindBy(how = How.NAME, using = "addr")
	WebElement txtaddress;

	@FindBy(how = How.NAME, using = "city")
	WebElement txtcity;

	@FindBy(how = How.NAME, using = "state") // input[@name='state']
	WebElement txtstate;

	@FindBy(how = How.NAME, using = "pinno")
	WebElement txtpinno;

	@FindBy(how = How.NAME, using = "telephoneno") // input[@name='telephoneno']
	WebElement txttelephoneno;

	@FindBy(how = How.NAME, using = "emailid")
	WebElement txtemailid;

	@FindBy(how = How.NAME, using = "password")
	WebElement txtpassword;

	@FindBy(how = How.NAME, using = "sub")
	WebElement btnSubmit;

	public void clickAddnewCustomer() {
		lnkAddNewCustomer.click();
	}

	public void customerName(String customerName) {
		txtCustomerName.sendKeys(customerName);
	}

	public void customerGender(String customerGender) {
		rdGender.click();
	}

	public void customerDob(String mm, String dd, String yy) {
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);

	}

	public void customerAddress(String customerAddress) {
		txtaddress.sendKeys(customerAddress);
	}

	public void customerCity(String customerCity) {
		txtcity.sendKeys(customerCity);
	}

	public void customerState(String customerState) {
		txtstate.sendKeys(customerState);
	}

	public void customerPinNo(String customerPinNo) {
		txtpinno.sendKeys(String.valueOf(customerPinNo));
	}

	public void customerTelephoneNo(String customerTelephoneNo) {
		txttelephoneno.sendKeys(String.valueOf(customerTelephoneNo));
	}

	public void customerEmailId(String customerEmailId) {
		txtemailid.sendKeys(customerEmailId);
	}

	public void customerPassword(String customerPassword) {
		txtpassword.sendKeys(customerPassword);
	}

	public void customerSubmit() {
		btnSubmit.click();
	}
}
