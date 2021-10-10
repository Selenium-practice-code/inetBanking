package com.inetbanking.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomerPage {

	@FindBy(xpath = "//a[normalize-space()='New Customer']")
	@CacheLookup
	private WebElement clickNewCustLink;

	@FindBy(xpath = "//input[@name='name']")
	@CacheLookup
	private WebElement enterCustName;

	@FindBy(name = "rad1")
	@CacheLookup
	private WebElement genderRadioBtn;

	@FindBy(xpath = "//input[@id='dob']")
	@CacheLookup
	private WebElement enterDob;

	@FindBy(xpath = "//textarea[@name='addr']")
	@CacheLookup
	private WebElement enterAddress;

	@FindBy(xpath = "//input[@name='city']")
	@CacheLookup
	private WebElement enterCity;

	@FindBy(xpath = "//input[@name='state']")
	@CacheLookup
	private WebElement enterState;

	@FindBy(xpath = "//input[@name='pinno']")
	@CacheLookup
	private WebElement enterPin;

	@FindBy(xpath = "//input[@name='telephoneno']")
	@CacheLookup
	private WebElement enterMobileNo;

	@FindBy(xpath = "//input[@name='emailid']")
	@CacheLookup
	private WebElement enterEmailID;

	@FindBy(xpath = "//input[@name='password']")
	@CacheLookup
	private WebElement enterPassword;

	@FindBy(xpath = "//input[@name='sub']")
	@CacheLookup
	private WebElement clickSubmitBtn;

	@FindBy(xpath = "//input[@name='res']")
	@CacheLookup
	private WebElement clickResetBtn;

	@SuppressWarnings("unused")
	private WebDriver driver;

	public AddNewCustomerPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickAddNewCustomer() {

		clickNewCustLink.click();
	}

	public void custName(String cName) {

		enterCustName.sendKeys(cName);
	}

	public void custGender(String cGender) {

		genderRadioBtn.click();
	}

	public void custDob(String dd, String mm, String yy) {

		enterDob.sendKeys(dd);
		enterDob.sendKeys(mm);
		enterDob.sendKeys(yy);
	}

	public void custAddress(String address) {

		enterAddress.sendKeys(address);
	}

	public void custCity(String city) {

		enterCity.sendKeys(city);

	}

	public void custState(String state) {

		enterState.sendKeys(state);
	}

	public void custPinNo(String pinNo) {

		enterPin.sendKeys(pinNo);
	}

	public void custMobileNo(String mobileNo) {

		enterMobileNo.sendKeys(mobileNo);
	}

	public void custEmailId(String emailID) {

		enterEmailID.sendKeys(emailID);
	}

	public void custPassword(String pw) {

		enterPassword.sendKeys(pw);
	}

	public void clickOnSumbitBtn() {

		clickSubmitBtn.click();
	}

	public void clickOnResetBtn() {

		clickResetBtn.click();
	}

}
