package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import page.objects.LoginPageObject;

public class AbstractTest {
	WebDriver driver;
	
	public WebDriver OpenMultiBrowser(String browserName, String url) {
		 if(browserName.equals("chrome")) {
			 System.setProperty("webdriver.chrome.driver", ".\\resource\\chromedriver.exe");
			 driver = new ChromeDriver();
		 }else if (browserName.equals("firefox")) {
			 driver = new FirefoxDriver();
			 
		 }else {
			 System.setProperty("webdriver.chrome.driver", ".\\resource\\chromedriver.exe");
			 ChromeOptions options = new ChromeOptions();
			 options.addArguments("headless");
			 options.addArguments("window-size=1920x1080");
			 driver = new ChromeDriver();
			 
		 }
		 
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
		
	}
	  public int randomNumber()
	  {
		  Random rand =new Random();
		  int n= rand.nextInt(999999)+1;
		  return n;
	  }

}
