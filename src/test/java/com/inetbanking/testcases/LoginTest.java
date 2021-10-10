package com.inetbanking.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.Hashtable;

import com.aventstack.extentreports.Status;
import com.inetbanking.base.TestBase;
import com.inetbanking.listeners.CustomListeners;
import com.inetbanking.pages.LoginPage;
import com.inetbanking.utilities.TestUtil;

public class LoginTest extends TestBase {

	LoginPage loginPage;

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void loginTest(Hashtable<String, String> data) {

		loginPage = new LoginPage(driver);
		loginPage.loginAsUser(data.get("username"), data.get("password"));
		log.info("Enter UserID :-> " + data.get("username") + " Enter Password :-> " + data.get("password"));
		CustomListeners.testReport.get().log(Status.INFO,
				"Enter UserID :-> " + data.get("username") + " Enter Password :-> " + data.get("password"));

		if (isAlertPresent() == true) {

			driver.switchTo().alert().accept(); // Close Alert
			driver.switchTo().defaultContent();
			AssertJUnit.assertTrue(false);
			log.warn("Login Failed");

		} else {

			AssertJUnit.assertTrue(true);
			log.info("Login Passed");
			loginPage.clickOnLogOut();
			driver.switchTo().alert().accept(); // Close LogOut Alert
			driver.switchTo().defaultContent();
		}

	}

}
