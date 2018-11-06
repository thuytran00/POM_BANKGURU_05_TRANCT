package com.liveguru.account;

import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import live.pageObjects.HomePageObject;
import live.pageObjects.MobilePageObject;
import live.pageObjects.MyAccountPageObject;
import live.pageObjects.MyDashbboardPageObject;
import live.pageObjects.PageFactoryManager;
import live.pageObjects.RegisterPageObject;
import live.pageObjects.TVPageObject;



public class Account_01_RegisterandLogin extends AbstractTest {
	WebDriver driver;
	private HomePageObject homePage;
	private MyAccountPageObject myAccountPage;
	private RegisterPageObject register;
	private String lastname,firstName,email, password;
	private MyDashbboardPageObject myDashboard;
	private MobilePageObject mobilePage;
	private String xperiaImageName, xperiaTitle, xperiaPrice, iphoneImageName, iphoneTitle, iphonePrice, samsungImageName, samsungTitle,samsungPrice;
	private TVPageObject tvPage;
		// TODO Auto-generated method 
	
	@Parameters({ "browser", "url" })
	
	@BeforeClass
	  public void beforeClass(String browsername, String urlName) {
		driver = OpenMultiBrowser(browsername, urlName);
		
		firstName="Automation";
		lastname="Testing Online";
		password="123123";
		email="auto05"+randomNumber()+"@gmail.com";
		
		xperiaImageName="Xperia";
		xperiaTitle="Sony Xperia";
		xperiaPrice="$100.00";
		iphoneImageName="IPhone";	
		iphoneTitle="IPhone";
		iphonePrice="$500.00";
		samsungImageName="Samsung Galaxy";
		samsungTitle="Samsung Galaxy";
		samsungPrice="$130.00";
//homePage = new HomePageObject(driver);
		homePage = PageFactoryManager.getHomePage(driver);
	  }		  
  @Test
  public void TC_01_Register() {
	 myAccountPage = homePage.openMyAccountPage(driver);
	 myAccountPage.clickToDynamicButton(driver, "Create an Account");
	 register = new RegisterPageObject(driver);
	register.sendKeytoDynamicTextbox(driver, "firstname", firstName);
	register.sendKeytoDynamicTextbox(driver, "lastname", lastname);
	register.sendKeytoDynamicTextbox(driver, "email_address", email);
	register.sendKeytoDynamicTextbox(driver, "password", password);
	register.sendKeytoDynamicTextbox(driver, "confirmation", password);
	
	//register.clickToDynamicButton(driver, "Register");
	
	register.clickToRegisterButton();
	myDashboard = new MyDashbboardPageObject(driver);
	homePage = myDashboard.openLogoutPage(driver);
	 
  }
  @Test
  public void TC_02_Login() {
	  
	  myAccountPage=homePage.openMyAccountPage(driver);
	  myAccountPage.sendKeytoDynamicTextbox(driver, "email", email);
	  myAccountPage.sendKeytoDynamicTextbox(driver, "pass", password);
	  myAccountPage.clickToDynamicButton(driver, "Login");
	  myDashboard = PageFactoryManager.getMyDashboardPage(driver);
myDashboard.isMyDashboarDisplayed();
	  }
  @Test
  public void TC_03_CheckProductDetail() {
	  //Open Mobile page
	 mobilePage = (MobilePageObject) myAccountPage.openDynamicLiveGurupage(driver,"Mobile");
	 
	 //Check Sony/Iphone/Samsung (detail)
	 //Xperia
 mobilePage.isDynamicProductImageDisplay(driver, xperiaImageName);
mobilePage.isDynamicProductNameDisplay(driver, xperiaTitle);
mobilePage.isDynamicProductPriceDisplay(driver, xperiaTitle, xperiaPrice);
mobilePage.isDynamicProductAddToCartDisplay(driver, xperiaTitle);
mobilePage.isDynamicProductAddToWishlistOrCompareButton(driver, xperiaTitle, "Add to Wishlist");
mobilePage.isDynamicProductAddToWishlistOrCompareButton(driver, xperiaTitle, "Add to Compare");

	//Iphone
mobilePage.isDynamicProductImageDisplay(driver, iphoneImageName);
mobilePage.isDynamicProductNameDisplay(driver, iphoneTitle);
mobilePage.isDynamicProductPriceDisplay(driver, iphoneTitle, iphonePrice);
mobilePage.isDynamicProductAddToCartDisplay(driver, iphoneTitle);
mobilePage.isDynamicProductAddToWishlistOrCompareButton(driver, iphoneTitle, "Add to Wishlist");
mobilePage.isDynamicProductAddToWishlistOrCompareButton(driver, iphoneTitle, "Add to Compare");

		//Samsung
mobilePage.isDynamicProductImageDisplay(driver, samsungImageName);
mobilePage.isDynamicProductNameDisplay(driver, samsungTitle);
mobilePage.isDynamicProductPriceDisplay(driver, samsungTitle, samsungPrice);
mobilePage.isDynamicProductAddToCartDisplay(driver, samsungTitle);
mobilePage.isDynamicProductAddToWishlistOrCompareButton(driver, samsungTitle, "Add to Wishlist");
mobilePage.isDynamicProductAddToWishlistOrCompareButton(driver, samsungTitle, "Add to Compare");

		 
		 tvPage=(TVPageObject) mobilePage.openDynamicLiveGurupage(driver, "TV");
		 
		 //LG
		 tvPage.isDynamicProductImageDisplay(driver, "LG LCD");
		 tvPage.isDynamicProductNameDisplay(driver, "LG LCD");
		 tvPage.isDynamicProductPriceDisplay(driver, "LG LCD", "$615.00");
		 tvPage.isDynamicProductAddToCartDisplay(driver, "LG LCD");
		 tvPage.isDynamicProductAddToWishlistOrCompareButton(driver, "LG LCD", "Add to Wishlist");
		 tvPage.isDynamicProductAddToWishlistOrCompareButton(driver, "LG LCD", "Add to Compare");
				 
	  }
  public int randomNumber()
  {
	  Random rand =new Random();
	  int n= rand.nextInt(999999)+1;
	  return n;
  }

  @AfterClass
  public void afterClass() {
  }

}
