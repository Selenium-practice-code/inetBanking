package com.inetbanking.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ExcelReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static Logger log = Logger.getLogger(TestBase.class.getName());
	public static Properties config = new Properties();
	public static FileInputStream fis;
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "/src/test/resources/testdata/testData.xlsx");

	@Parameters("browser")
	@BeforeClass
	public void setUp(String browsr) {

		if (driver == null) {

			PropertyConfigurator.configure("./src/test/resources/properties/log4j.properties");

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "/src/test/resources/properties/Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {

				config.load(fis);
				log.info("Config Properties File loaded");

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		// Declare the Browser and load using Config File
		if (browsr.equals("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			log.info("Chrome Browser Launched");

		} else if (browsr.equals("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			log.info("Firefox Browser Launched");

		} else if (browsr.equals("safari")) {

			driver = new SafariDriver();
			log.info("Safari Browser Launched");
		}

		driver.get(config.getProperty("siteURL"));
		log.info("Navigated to :-> " + config.getProperty("siteURL"));

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public boolean isAlertPresent() {

		try {
			driver.switchTo().alert();
			return true;

		} catch (NoAlertPresentException e) {

			return false;

		}
	}

	// Generate a RandomString For EmailID
	public String randomString() {

		String genratedSting = RandomStringUtils.randomAlphabetic(5);
		return genratedSting;

	}

	@AfterClass
	public void tearDown() {

		if (driver != null) {
			driver.quit();
		}

		log.info("Test Execution Completd !!!");
	}

}
