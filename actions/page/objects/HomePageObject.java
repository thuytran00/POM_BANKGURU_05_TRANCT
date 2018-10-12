package page.objects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import page.ui.HomePageUI;

public class HomePageObject extends AbstractPage {
	WebDriver driver;
	public HomePageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
	public boolean isHomepageDisplay() {
		waitForControlVisible(driver, HomePageUI.WELCOME_MESSAGE);
		return isControlDisplay(driver, HomePageUI.WELCOME_MESSAGE);
		
	}
}
