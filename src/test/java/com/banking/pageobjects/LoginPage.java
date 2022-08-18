package com.banking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;

	public LoginPage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(name = "uid")//input[@name='uid']
	WebElement txtUserName;

	@FindBy(name = "password")//input[@name='password']
	WebElement txtPassword;

	@FindBy(name = "btnLogin")//input[@name='btnLogin']
	WebElement btnLogin;

	@FindBy(xpath = "//a[normalize-space()='Log out']")
	WebElement lnkLogout;

	public void setUserName(String uname) {
		txtUserName.clear();
		txtUserName.sendKeys(uname);
	}

	public void setPassword(String pwd) {
		txtPassword.clear();
		txtPassword.sendKeys(pwd);
	}

	public void clickSubmit() {
		btnLogin.click();

	}

	public void clickLogout() {
		lnkLogout.click();
	}

}
