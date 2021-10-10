package com.inetbanking.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(xpath = "//input[@name='uid']")
	@CacheLookup
	private WebElement userID;

	@FindBy(xpath = "//input[@name='password']")
	@CacheLookup
	private WebElement passwrd;

	@FindBy(xpath = "//input[@name='btnLogin']")
	@CacheLookup
	private WebElement loginButton;

	@FindBy(xpath = "//a[normalize-space()='Log out']")
	@CacheLookup
	private WebElement logoutLink;

	@SuppressWarnings("unused")
	private WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void loginAsUser(String user, String pw) {

		userID.sendKeys(user);
		passwrd.sendKeys(pw);
		loginButton.click();

	}

	public void clickOnLogOut() {

		logoutLink.click();
	}
}
