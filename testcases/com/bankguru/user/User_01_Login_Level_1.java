package com.bankguru.user;

import org.testng.annotations.Test;

import commons.AbstractPage;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class User_01_Login_Level_1 {
	WebDriver driver;
	private String userID, password, loginPageUrl;
	private AbstractPage abstractPage;
	@BeforeClass
	  public void beforeClass() {
		driver = new FirefoxDriver();
		abstractPage = new AbstractPage();
		abstractPage.openAnyUrl(driver, "http://demo.guru99.com/v4/");
		
	  }		  
  @Test
  public void TC_01_Register() {
	  //Get loginpage url
	  loginPageUrl = abstractPage.getCurrentPageUrl(driver);
	  //Click here link to open Register Page
	  abstractPage.clickToElement(driver, "//a[text()='here']");
	  //driver.findElement(By.xpath("//a[text()='here']")).click();
	  abstractPage.waitForControlVisible(driver, "//input[@name='emailid']");
	  //input random email
	  driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys("online05"+randomNumber()+"@gmail.com");
	  abstractPage.clickToElement(driver, "//input[@name='btnLogin']");
	  //driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
	
	  //Get text of User and pass
	   //userID = driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td")).getText();
	   userID = abstractPage.getTextElement(driver, "//td[text()='User ID :']/following-sibling::td");
	   password=abstractPage.getTextElement(driver, "//td[text()='Password :']/following-sibling::td");
	   //password = driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td")).getText();
	   
	   
  }
  @Test
  public void TC_02_Login() {
	  //Open Loginpage
	  //driver.get(loginPageUrl);
	  abstractPage.openAnyUrl(driver, loginPageUrl);
	  abstractPage.waitForControlVisible(driver, "//input[@name='uid']");
	  abstractPage.sendKeyToElement(driver, "//input[@name='uid']", userID);
	  abstractPage.sendKeyToElement(driver, "//input[@name='password']", password);
	  abstractPage.clickToElement(driver, "//input[@name='btnLogin']");
	  //driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(userID);
	  //driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
	  //driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
	  
	  Assert.assertTrue(driver.findElement(By.xpath("//marquee[text()=\"Welcome To Manager's Page of Guru99 Bank\"]")).isDisplayed());
  }
  public int randomNumber()
  {
	  Random rand =new Random();
	  int n= rand.nextInt(999999)+1;
	  return n;
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
