package commons;

import java.util.List;
import live.pageUIs.*;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.jboss.netty.util.Timeout;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import live.pageObjects.MyAccountPageObject;
import live.pageObjects.RegisterPageObject;
import page.objects.DeleteAccountPageObject;
import page.objects.EditCustomerPageObject;
import page.objects.HomePageObject;
import page.objects.LoginPageObject;
import page.objects.NewCustomerPageObject;
import page.objects.PageFactoryManager;
import page.objects.WithdrawPageObject;
import page.ui.AbstractPageUI;
import live.pageUIs.*;
public class AbstractPage {
	WebDriver driver;
//	public AbstractPage(WebDriver driver_) {
//		driver = driver_;
//	}
	public void openAnyUrl(WebDriver driver, String url) {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(longTimeout, TimeUnit.SECONDS);
		
	}
	public LoginPageObject openLoginPage( String url) {
		openAnyUrl(driver, url);
		return new LoginPageObject(driver);
		
	}
	public void getPageTitle(WebDriver driver) {
		driver.getTitle();
	}
	
	public String getCurrentPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	public void backToPreviousPage(WebDriver driver) {
		driver.navigate().back();
	}
	
	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	public void clickToElement(WebDriver driver, String locator) {
		WebElement element =driver.findElement(By.xpath(locator));
		element.click();
	}
	public void clickToElement(WebDriver driver, String locator,String value) {
		locator = String.format(locator, value);
		WebElement element =driver.findElement(By.xpath(locator));
		element.click();
	}
	public void sendKeyToElement(WebDriver driver, String locator, String value) {
		WebElement element =driver.findElement(By.xpath(locator));
		element.clear();
		element.sendKeys(value);
	}
	public void sendKeyToElement(WebDriver driver, String locator, String inputValue, String... values) {
		locator = String.format(locator, (Object[]) values);
		WebElement element =driver.findElement(By.xpath(locator));
		element.clear();
		element.sendKeys(inputValue);
	}
	
	public void selectItemInDefaultDropdown(WebDriver driver, String locator, String item) {
		Select select = new Select(driver.findElement(By.xpath(locator)));
		select.deselectByVisibleText(item);
	}
	
	public void selectItemInCustomDropDown(WebDriver driver,String dropdown, String valueItem, String listItems){
		
		WebElement dropdownElement = driver.findElement(By.xpath(dropdown));
		WebDriverWait wait = new WebDriverWait(driver, longTimeout);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", dropdownElement);
		dropdownElement.click();
		List <WebElement>allItems=driver.findElements(By.xpath(listItems));
		wait.until(ExpectedConditions.visibilityOfAllElements(allItems));
		for(WebElement item : allItems) {
					
			if(item.getText().trim().equals(valueItem)) {
				//scroll
				((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", item);
				
				item.click();
				break;
			}
			
		}
	}
	
	public String getFirstItemSelected(WebDriver driver,String locator) {
		Select select = new Select(driver.findElement(By.xpath(locator)));
		return select.getFirstSelectedOption().getText();
	}
	
	public String getAttibuteValue(WebDriver driver,String locator, String attributeName) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getAttribute(attributeName);
	}
	
	public String getTextElement(WebDriver driver,String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getText();
	}
	
	public int getSizeElement(WebDriver driver,String locator) {
		List <WebElement> elements = driver.findElements(By.xpath(locator));
		return elements.size();
	}
	
	public void checkToCheckbox(WebDriver driver,String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		if(!element.isSelected()) {
			element.click();		
		}
	}
	
	public void uncheckToCheckbox(WebDriver driver,String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		if(element.isSelected()) {
			element.click();			
		}
	}
	
	public boolean isControlDisplay(WebDriver driver,String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();
	}
	public boolean isControlDisplay(WebDriver driver,String locator, String value) {
		locator = String.format(locator, value);
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();
	}
	public void isControlEnable(WebDriver driver,String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.isEnabled();
	}
	
	public void isControlSelected(WebDriver driver,String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.isSelected();
	}
	
	public void acceptToAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public void cancelToAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}
	
	public void getTextAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.getText();
	}
	
	public void sendkeyToAlert(WebDriver driver, String text) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(text);
	}
	
	public void switchToChildWindowByTitle(WebDriver driver, String expectedTitle) {
  		//Get all current window
  		Set <String> allWindows = driver.getWindowHandles();
  		
  		//Duyet tat ca cas windows/tabs
  		for(String runWindow : allWindows) {
  			//switch vao tung window
  			driver.switchTo().window(runWindow);
  			//get ra title da switch qua
  			String actualTitle=driver.getTitle();
  			//Kiem tra title hien tai vaf mong muon
  			if(actualTitle.equals(expectedTitle)) {
  			//	driver.switchTo().window(runWindow);
  				break;
  			}
  		}
  	}
	
	public void switchToChildWindowGUID(WebDriver driver, String ID) {
  		//Get all current window
  		Set <String> allWindows = driver.getWindowHandles();
  		
  		//Duyet tat ca cas windows/tabs
  		for(String runWindow : allWindows) {
  			
  			if(runWindow.equals(ID)) {
  				driver.switchTo().window(runWindow);
  				break;
  			}
  		}
  	}
	
	//Dong tat ca window ngoai tru parent window
  	public boolean closeAllWithoutParentWindows(WebDriver driver, String parentGUID) {
  		//Get all current window
  		Set <String> allWindows = driver.getWindowHandles();
  		
  		//Duyet tat ca cas windows/tabs
  		for(String runWindow : allWindows) {
  			
   			//Kiem tra title hien tai vaf mong muon
  			if(!runWindow.equals(parentGUID)) {
  				driver.switchTo().window(runWindow);
  				driver.close();
  			}
  		}
  		driver.switchTo().window(parentGUID);
  		//kiem tra xem con dung 1 window hay ko
  		if(driver.getWindowHandles().size()==1)
  			return true;
  		else
  			return false;
  	}
  	public void switchToIframe(WebDriver driver, String locator) {
  		//switch to iframe
	 
	  WebElement iframe=driver.findElement(By.xpath(locator));
	  driver.switchTo().frame(iframe);
  	}
  	
  	public void hoverToElement(WebDriver driver, String locator) {
  	  WebElement element=driver.findElement(By.xpath(locator));
	  Actions action = new Actions(driver);
	  action.moveToElement(element);
  	}
  	
  	public void doubleClickToElement(WebDriver driver, String locator) {
  	  WebElement element=driver.findElement(By.xpath(locator));
  	  Actions action = new Actions(driver);
  	  action.doubleClick(element);
    }
  	
  	public void rightClick(WebDriver driver, String locator) {
    	  WebElement element=driver.findElement(By.xpath(locator));
    	  Actions action = new Actions(driver);
    	  action.contextClick(element);
      }
  	
  	public void dragAndDrop(WebDriver driver, String locator1, String locator2) {
    	  WebElement element=driver.findElement(By.xpath(locator1));
    	  WebElement target=driver.findElement(By.xpath(locator2));
    	  Actions action = new Actions(driver);
    	  action.dragAndDrop(element, target);
      }
  	
  	public void keyPress(WebDriver driver, String locator, Keys keyname) {
  		WebElement element = driver.findElement(By.xpath(locator));
  		Actions action =  new Actions(driver);
  		action.sendKeys(element,keyname);
    }
  	
  	public void uploadFile(WebDriver driver, String filename) {
  		String proDir = System.getProperty("user.dir");
  		String filePath= proDir+"\\images\\"+filename;
  		WebElement element = driver.findElement(By.xpath("//input[@type='file']"));
  		element.sendKeys(filePath);
  		
    }
  	
  	public void uploadFile(WebDriver driver, String filename1, String filename2) {
  		String proDir = System.getProperty("user.dir");
  		String filePath1= proDir+"\\images\\"+filename1;
  		String filePath2= proDir+"\\images\\"+filename2;
  		String summaryfile="\""+filePath1+"\" \""+filePath2+"\"";
  		WebElement element = driver.findElement(By.xpath("//input[@type='file']"));
  		element.sendKeys(summaryfile);
  		
    }
  	
  	public void waitForControlVisible(WebDriver driver, String locator) {
  		//WebElement element=driver.findElement(By.xpath(locator));
  		By byElement = By.xpath(locator);
  		WebDriverWait wait = new WebDriverWait(driver, timeOut);
  		wait.until(ExpectedConditions.visibilityOfElementLocated(byElement));
  	}
  	public void waitForControlVisible(WebDriver driver, String locator,String value) {
  		locator = String.format(locator, value);
  		//WebElement element=driver.findElement(By.xpath(locator));
  		By byElement = By.xpath(locator);
  		WebDriverWait wait = new WebDriverWait(driver, timeOut);
  		wait.until(ExpectedConditions.visibilityOfElementLocated(byElement));
  	}
  	public void waitForControlInvisible(WebDriver driver, String locator) {
  		//WebElement element=driver.findElement(By.xpath(locator));
  		By byElement = By.xpath(locator);
  		WebDriverWait wait = new WebDriverWait(driver, timeOut);
  		wait.until(ExpectedConditions.invisibilityOfElementLocated(byElement));
  	}
  	
  	
  	public void waitForControlPresence(WebDriver driver, String locator) {
  		//WebElement element=driver.findElement(By.xpath(locator));
  		By byElement = By.xpath(locator);
  		WebDriverWait wait = new WebDriverWait(driver, timeOut);
  		wait.until(ExpectedConditions.presenceOfElementLocated(byElement));
  	}
  	
  	public void waitForControlClickable(WebDriver driver, String locator) {
  		//WebElement element=driver.findElement(By.xpath(locator));
  		By byElement = By.xpath(locator);
  		WebDriverWait wait = new WebDriverWait(driver, timeOut);
  		wait.until(ExpectedConditions.elementToBeClickable(byElement));
  	}
  	
  	public void waitForAlertPresent(WebDriver driver, String locator) {
  		WebElement element=driver.findElement(By.xpath(locator));
  		//By byElement = By.xpath(locator);
  		WebDriverWait wait = new WebDriverWait(driver, timeOut);
  		wait.until(ExpectedConditions.alertIsPresent());
  	}
  	private int timeOut = 30;
  	public HomePageObject openHomePage(WebDriver driver) {
  	
  		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PAGE_LINK,"Manager");
  		clickToElement(driver, AbstractPageUI.DYNAMIC_PAGE_LINK);
  		return PageFactoryManager.openHomepage(driver);
  	}
  	public NewCustomerPageObject openNewCustomerPage(WebDriver driver) {
  		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PAGE_LINK,"New Customer");
  		clickToElement(driver, AbstractPageUI.DYNAMIC_PAGE_LINK,"New Customer");
  		return PageFactoryManager.openNewCustomerPage(driver);
  	}
  	public WithdrawPageObject openWithdrawPage(WebDriver driver) {
  		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PAGE_LINK,"Withdrawal");
  		clickToElement(driver, AbstractPageUI.DYNAMIC_PAGE_LINK,"Withdrawal");
  		return PageFactoryManager.openWithdrawPage(driver);
  	}
  	public EditCustomerPageObject openEditCustomerPage(WebDriver driver) {
  		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PAGE_LINK,"Edit Customer");
  		clickToElement(driver, AbstractPageUI.DYNAMIC_PAGE_LINK,"Edit Customer");
  		return PageFactoryManager.openEditCustomerPage(driver);
  	}
  	public DeleteAccountPageObject openDeletePage(WebDriver driver) {
  		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PAGE_LINK,"Delete Account");
  		clickToElement(driver, AbstractPageUI.DYNAMIC_PAGE_LINK,"Delete Account");
  		return PageFactoryManager.openDeleteAccountPage(driver);
  	}
  	private int longTimeout =30;
  	private int shortTimeout =10;
  	
  	/*LIVE GURU PAGE*/
  	public MyAccountPageObject openMyAccountPage(WebDriver driver) {
  		waitForControlVisible(driver, LoginPageUI.ACCOUNT_LINK,"My Account");
  		clickToElement(driver, LoginPageUI.ACCOUNT_LINK,"My Account");
  		return live.pageObjects.PageFactoryManager.getMyAccountPage(driver);
  	}
  	public AbstractPage clickToDynamicButton(WebDriver driver, String titleName) {
  		waitForControlVisible(driver, live.pageUIs.AbstractPageUI.DYNAMIC_BUTTON,titleName);
  		clickToElement(driver, live.pageUIs.AbstractPageUI.DYNAMIC_BUTTON,titleName);
  		return null;
  		//return live.pageObjects.PageFactoryManager.getRegisterPage(driver);
  	}
  	public void sendKeytoDynamicTextbox(WebDriver driver, String textboxName, String value) {
  		waitForControlVisible(driver, live.pageUIs.AbstractPageUI.DYNAMIC_TEXTBOX_RADIO_CHECKBOX,textboxName);
  		sendKeyToElement(driver, live.pageUIs.AbstractPageUI.DYNAMIC_TEXTBOX_RADIO_CHECKBOX,value,textboxName);
  		//return null;
  		//return live.pageObjects.PageFactoryManager.getRegisterPage(driver);
  	}
  	public live.pageObjects.HomePageObject openLogoutPage(WebDriver driver) {
  		waitForControlVisible(driver, live.pageUIs.AbstractPageUI.DYNAMIC_HEADER_LABEL_TEXT,"Account");
  		clickToElement(driver, live.pageUIs.AbstractPageUI.DYNAMIC_HEADER_LABEL_TEXT, "Account");
  		waitForControlVisible(driver, live.pageUIs.AbstractPageUI.DYNAMIC_HEADER_LINK,"Log Out");
  		clickToElement(driver, live.pageUIs.AbstractPageUI.DYNAMIC_HEADER_LINK,"Log Out");
  		//return null;
  		return live.pageObjects.PageFactoryManager.getHomePage(driver);
  	}
}
