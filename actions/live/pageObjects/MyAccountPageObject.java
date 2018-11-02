package live.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import commons.AbstractPage;
import page.ui.LoginPageUI;

public class MyAccountPageObject extends AbstractPage {
	WebDriver driver;
	
	
 public MyAccountPageObject(WebDriver mappingDriver) {
		
		driver = mappingDriver;
	}
 public MyAccountPageObject(WebDriver mappingDrive, WebDriverWait wait) {
		
		driver = mappingDrive;
	}

/*ACTION IN PAGE
	- Input username
	- Input password
	- Click SUBMIT button
	- Click 'here' link
	*/
	public String getLoginPageUrl() {
		return getCurrentPageUrl(driver);
	}
	
	public void inputToUserIDTextbox(String userName) {
		waitForControlVisible(driver, LoginPageUI.USERID_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.USERID_TEXTBOX, userName);
	}
	
	public void inputToPasswordTextbox(String password) {
		waitForControlVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}
	
	public HomePageObject clickToLoginButton() {
		waitForControlVisible(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		//return new HomePageObject(driver);
		return PageFactoryManager.getHomePage(driver);
	}
	public RegisterPageObject clickHereLink() {
		waitForControlVisible(driver, LoginPageUI.HERE_LINK);
		clickToElement(driver, LoginPageUI.HERE_LINK);
		return PageFactoryManager.getRegisterPage(driver);
	}
	
	
}
