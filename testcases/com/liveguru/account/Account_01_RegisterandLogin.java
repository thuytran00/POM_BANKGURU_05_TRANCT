package com.liveguru.account;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import live.pageObjects.HomePageObject;
import live.pageObjects.MyAccountPageObject;
import live.pageObjects.MyDashbboardPageObject;
import live.pageObjects.PageFactoryManager;
import live.pageObjects.RegisterPageObject;



public class Account_01_RegisterandLogin extends AbstractTest {
	WebDriver driver;
	private HomePageObject homePage;
	private MyAccountPageObject myAccountPage;
	private RegisterPageObject register;
	private String lastname,firstName,email, password;
	private MyDashbboardPageObject myDashboard;
	
	@Parameters({ "browser", "url" })
	
	@BeforeClass
	  public void beforeClass(String browsername, String urlName) {
		driver = OpenMultiBrowser(browsername, urlName);
		
		firstName="Automation";
		lastname="Testing Online";
		password="123123";
		email="auto05"+randomNumber()+"@gmail.com";
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
