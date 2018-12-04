package com.bankguru.user;

import org.testng.annotations.Test;

import commons.AbstractPage;
import commons.AbstractTest;
import page.objects.HomePageObject;
import page.objects.LoginPageObject;
import page.objects.RegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class User_01_Login_Level_2_PageObjectBasic extends AbstractTest {
	WebDriver driver;
	WebDriverWait wait;
	private String userID, password, loginPageUrl,emailAddress;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private HomePageObject homePage;
	
@Parameters({"browser","url"})	
@BeforeClass
public void beforeClass(String browserName, String urlName) {
	
	driver=	OpenMultiBrowser(browserName, urlName);
	emailAddress = "automation05" + randomNumber()+"@gmail.com";
	loginPage =  new LoginPageObject(driver);
	registerPage = new RegisterPageObject(driver);
	
	
	  }		  
  @Test
  public void TC_01_Register() {
	  loginPageUrl = loginPage.getLoginPageUrl();
	  loginPage.clickHereLink();
	  registerPage = new RegisterPageObject(driver);
	  registerPage.inputToEmailTextbox(emailAddress);
	  registerPage.clickSubmitButton();
	  userID = registerPage.getUserID();
	  password=registerPage.getPassword();
	
  }
  @Test(enabled=false)
  public void TC_02_Login() {
	  
	 registerPage.openAnyUrl(driver, loginPageUrl);
	 loginPage = new LoginPageObject(driver);
	  loginPage.inputToUserIDTextbox("mngr152676");
	  loginPage.inputToPasswordTextbox("qEtEvUd");
	  loginPage.clickToLoginButton();
	  homePage = new HomePageObject(driver);
	  Assert.assertTrue(homePage.isHomepageDisplay());
	 
	 
  }
  
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
