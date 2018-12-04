package com.liveguru.account;

import java.io.IOException;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import commons.AbstractTest;
import live.pageObjects.HomePageObject;
import live.pageObjects.MobilePageObject;
import live.pageObjects.MyAccountPageObject;
import live.pageObjects.MyDashbboardPageObject;
import live.pageObjects.PageFactoryManager;
import live.pageObjects.RegisterPageObject;
import live.pageObjects.TVPageObject;
import testData.Account;
import testData.GetAccountData;

public class Account_02_RegisterandLogin_jackson extends AbstractTest {
	WebDriver driver;
	private HomePageObject homePage;
	private MyAccountPageObject myAccountPage;
	private RegisterPageObject register;
	private String  email, password;
	private MyDashbboardPageObject myDashboard;
	private MobilePageObject mobilePage;
	private String xperiaImageName, xperiaTitle, xperiaPrice, iphoneImageName, iphoneTitle, iphonePrice,
			samsungImageName, samsungTitle, samsungPrice;
	private TVPageObject tvPage;
	private GetAccountData account;
	// TODO Auto-generated method

	@Parameters({ "browser", "url", "account" })

	@BeforeClass
	public void beforeClass(String browsername, String urlName, String accountData) throws JsonParseException, JsonMappingException, IOException {
		driver = OpenMultiBrowser(browsername, urlName);
		account = GetAccountData.get(accountData);
		email = Account.Register.EMAIL + randomNumber() + "@gmail.com";
		homePage = PageFactoryManager.getHomePage(driver);
	}

	@Test
	public void TC_01_Register() {
		log.info("Register - Step 01: Open My Account Page");
		myAccountPage = homePage.openMyAccountPage(driver);

		log.info("Register - Step 02: Click Create an Account button");
		myAccountPage.clickToDynamicButton(driver, "Create an Account");
		register = new RegisterPageObject(driver);

		log.info("Register - Step 03: Input to Firstname Textbox");
		register.sendKeytoDynamicTextbox(driver, "firstname", account.getFirstName());
		register.sendKeytoDynamicTextbox(driver, "lastname", account.getLastName());
		register.sendKeytoDynamicTextbox(driver, "email_address", account.getEmail()+ randomNumber() + "@gmail.com");
		register.sendKeytoDynamicTextbox(driver, "password", account.getPassword());
		register.sendKeytoDynamicTextbox(driver, "confirmation", account.getPassword());

		// register.clickToDynamicButton(driver, "Register");

		register.clickToRegisterButton();
		myDashboard = new MyDashbboardPageObject(driver);
		homePage = myDashboard.openLogoutPage(driver);

	}

	@Test(enabled=false)
	public void TC_02_Login() {

		myAccountPage = homePage.openMyAccountPage(driver);
		myAccountPage.sendKeytoDynamicTextbox(driver, "email", email);
		myAccountPage.sendKeytoDynamicTextbox(driver, "pass", password);
		myAccountPage.clickToDynamicButton(driver, "Login");
		myDashboard = PageFactoryManager.getMyDashboardPage(driver);
		myDashboard.isMyDashboarDisplayed();
	}

	@Test(enabled=false)
	public void TC_03_CheckProductDetail() {
		// Open Mobile page
		mobilePage = (MobilePageObject) myAccountPage.openDynamicLiveGurupage(driver, "Mobile");

		// Check Sony/Iphone/Samsung (detail)
		// Xperia
		mobilePage.isDynamicProductImageDisplay(driver, xperiaImageName);
		mobilePage.isDynamicProductNameDisplay(driver, xperiaTitle);
		mobilePage.isDynamicProductPriceDisplay(driver, xperiaTitle, xperiaPrice);
		mobilePage.isDynamicProductAddToCartDisplay(driver, xperiaTitle);
		mobilePage.isDynamicProductAddToWishlistOrCompareButton(driver, xperiaTitle, "Add to Wishlist");
		mobilePage.isDynamicProductAddToWishlistOrCompareButton(driver, xperiaTitle, "Add to Compare");

		// Iphone
		mobilePage.isDynamicProductImageDisplay(driver, iphoneImageName);
		mobilePage.isDynamicProductNameDisplay(driver, iphoneTitle);
		mobilePage.isDynamicProductPriceDisplay(driver, iphoneTitle, iphonePrice);
		mobilePage.isDynamicProductAddToCartDisplay(driver, iphoneTitle);
		mobilePage.isDynamicProductAddToWishlistOrCompareButton(driver, iphoneTitle, "Add to Wishlist");
		mobilePage.isDynamicProductAddToWishlistOrCompareButton(driver, iphoneTitle, "Add to Compare");

		// Samsung
		mobilePage.isDynamicProductImageDisplay(driver, samsungImageName);
		mobilePage.isDynamicProductNameDisplay(driver, samsungTitle);
		mobilePage.isDynamicProductPriceDisplay(driver, samsungTitle, samsungPrice);
		mobilePage.isDynamicProductAddToCartDisplay(driver, samsungTitle);
		mobilePage.isDynamicProductAddToWishlistOrCompareButton(driver, samsungTitle, "Add to Wishlist");
		mobilePage.isDynamicProductAddToWishlistOrCompareButton(driver, samsungTitle, "Add to Compare");

		tvPage = (TVPageObject) mobilePage.openDynamicLiveGurupage(driver, "TV");

		// LG
		tvPage.isDynamicProductImageDisplay(driver, "LG LCD");
		tvPage.isDynamicProductNameDisplay(driver, "LG LCD");
		tvPage.isDynamicProductPriceDisplay(driver, "LG LCD", "$615.00");
		tvPage.isDynamicProductAddToCartDisplay(driver, "LG LCD");
		tvPage.isDynamicProductAddToWishlistOrCompareButton(driver, "LG LCD", "Add to Wishlist");
		tvPage.isDynamicProductAddToWishlistOrCompareButton(driver, "LG LCD", "Add to Compare");

	}

	@AfterClass
	public void afterClass() {
	}

}
