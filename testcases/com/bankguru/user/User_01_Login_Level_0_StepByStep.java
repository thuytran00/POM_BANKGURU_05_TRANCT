package com.bankguru.user;

import org.testng.annotations.Test;
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

public class User_01_Login_Level_0_StepByStep {
	WebDriver driver;
	WebDriverWait wait;
	private String userID, password, loginPageUrl;
	@BeforeClass
	  public void beforeClass() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 30);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/v4/");
	  }		  
  @Test
  public void TC_01_Register() {
	  //Get loginpage url
	  loginPageUrl = driver.getCurrentUrl();
	  //Click here link to open Register Page
	  driver.findElement(By.xpath("//a[text()='here']")).click();
	  wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='emailid']"))));
	  
	  //input random email
	  driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys("online05"+randomNumber()+"@gmail.com");
	  driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
	
	  //Get text of User and pass
	   userID = driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td")).getText();
	   password = driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td")).getText();
	   
	   
  }
  @Test
  public void TC_02_Login() {
	  //Open Loginpage
	  driver.get(loginPageUrl);
	  wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='uid']"))));
	  
	  driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(userID);
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
	  driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
	  
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
  }

}
