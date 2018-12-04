package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.junit.Assert;
import org.openqa.jetty.log.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import page.objects.LoginPageObject;

public class AbstractTest {
	WebDriver driver;
	protected final Log log;
	protected AbstractTest() {
		log = LogFactory.getLog(getClass());
	}
	public WebDriver OpenMultiBrowser(String browserName, String url) {
		 
		if(browserName.equals("chrome")) {
			 
			 //System.setProperty("webdriver.chrome.driver", ".\\resource\\chromedriver.exe");
			 WebDriverManager.chromedriver().setup();
			 DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			 ChromeOptions options = new ChromeOptions();
			 options.addArguments("--incognito");
			 options.addArguments("--disable-extensions");
			 options.addArguments("disable-infobars");
			 options.addArguments("start-maximized");
			 capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			 
			 driver = new ChromeDriver(capabilities);
			 
		 }else if (browserName.equals("firefox")) {
			 WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
			 
		 }else if (browserName.equals("chromeheadless")) {
			 WebDriverManager.chromedriver().setup();
			 ChromeOptions options = new ChromeOptions();
			 options.addArguments("headless");
			 options.addArguments("window-size=1920x1080");
			
			 driver = new ChromeDriver(options);
		 }else if (browserName.equals("ie")) {
			 WebDriverManager.iedriver().setup();
			 DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			 capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			 capabilities.setCapability(CapabilityType.ELEMENT_SCROLL_BEHAVIOR, true);
			 capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
			 capabilities.setCapability("ignoreProtectedModeSettings", true);
			 capabilities.setCapability("ignoreZoomSetting", true);
			 capabilities.setCapability("requireWindowFocus", true);
			 capabilities.setJavascriptEnabled(true);
			 capabilities.setCapability("enableElementCacheCleanup", true);
			 capabilities.setBrowserName("internet explorer");
			 capabilities.setPlatform(org.openqa.selenium.Platform.ANY);
			 driver=new InternetExplorerDriver(capabilities);
		 }
		 else {
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
	  public static int randomNumber()
	  {
		  Random rand =new Random();
		  int n= rand.nextInt(999999)+1;
		  return n;
	  }
	  private boolean checkPassed(boolean condition) {
		  boolean pass =true;
		  try {
			  if(condition == true)
				log.info("==PASS==");
			  else
				  log.info("==FAILED==");
			  Assert.assertTrue(condition);
			
		  }catch(Throwable e) {
			  pass=false;
			  Reporter.getCurrentTestResult().setThrowable(e);
		  }
		  return pass;
	  }
	  private boolean checkFailed(boolean condition) {
		  boolean pass = true;
		  try {
			  
			  Assert.assertTrue(condition);
			
		  }catch(Throwable e) {
			  pass=false;
			  Reporter.getCurrentTestResult().setThrowable(e);
		  }
		  return pass;
	  }
	  protected boolean verifyTrue(boolean condition) {
		  return checkPassed(condition);
	  }
}
