package page.objects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import page.ui.LoginPageUI;
import page.ui.RegisterPageUI;

public class RegisterPageObject extends AbstractPage{
	
	WebDriver driver;
	public RegisterPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
	public void inputToEmailTextbox(String email) {
		waitForControlVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
	}
	public void clickSubmitButton() {
		waitForControlVisible(driver, RegisterPageUI.SUBMIT_BUTTON);
		clickToElement(driver, RegisterPageUI.SUBMIT_BUTTON);
	}
	public String getUserID() {
		waitForControlVisible(driver, RegisterPageUI.USER_ID_TEXT);
		return getTextElement(driver, RegisterPageUI.USER_ID_TEXT);
	}
	public String getPassword() {
		waitForControlVisible(driver, RegisterPageUI.PASSWORD_TEXT);
		return getTextElement(driver, RegisterPageUI.PASSWORD_TEXT);
	}

}
