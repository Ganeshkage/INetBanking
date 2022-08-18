package com.banking.testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.banking.utilities.ReadConfig;


public class BaseClass {

	ReadConfig readConfig = new ReadConfig();

	public String baseUrl = readConfig.getApplicationUrl();
	public String username = readConfig.getUsername();
	public String password = readConfig.getPassword();
	WebDriver driver;

	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {
		logger = Logger.getLogger("eBanking");
		PropertyConfigurator.configure("log4j.properties");

		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "//Drivers//chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		} else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "//Drivers//chromedriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		} else if (br.equals("edge")) {
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "//Drivers//chromedriver.exe");

			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/screenshots/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("ScreenShot Taken...");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
