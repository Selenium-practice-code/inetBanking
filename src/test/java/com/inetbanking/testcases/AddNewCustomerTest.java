package com.inetbanking.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.base.TestBase;
import com.inetbanking.pages.AddNewCustomerPage;
import com.inetbanking.pages.LoginPage;

public class AddNewCustomerTest extends TestBase {

	LoginPage loginPage;
	AddNewCustomerPage addNewCustomerPage;

	@Test
	public void addNewCustomerTest() {

		loginPage = new LoginPage(driver);
		loginPage.loginAsUser(config.getProperty("userName"), config.getProperty("password"));
		log.info("Login As User");

		log.info("Enter New Customer Details");
		addNewCustomerPage = new AddNewCustomerPage(driver);
		addNewCustomerPage.clickAddNewCustomer();
		addNewCustomerPage.custName("Sumit");
		addNewCustomerPage.custGender("male");
		addNewCustomerPage.custDob("04", "12", "1995");
		addNewCustomerPage.custAddress("Civil Lines");
		addNewCustomerPage.custCity("Jhansi");
		addNewCustomerPage.custState("UP");
		addNewCustomerPage.custPinNo("284003");
		addNewCustomerPage.custMobileNo("8574898789");

		String email = randomString() + "@gmail.com";
		addNewCustomerPage.custEmailId(email);
		addNewCustomerPage.custPassword("abcdef");
		addNewCustomerPage.clickOnSumbitBtn();

		// Validation
		log.info("Validation...");
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");

		if (res == true) {

			Assert.assertTrue(true);

		} else {

			Assert.assertTrue(false);

		}
	}

}
