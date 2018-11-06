package live.pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import live.pageUIs.LiveMyDashBoardUI;
import page.ui.HomePageUI;

public class MyDashbboardPageObject extends AbstractPage {
	WebDriver driver;
	public MyDashbboardPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
	public boolean isHomepageDisplay() {
		waitForControlVisible(driver, HomePageUI.WELCOME_MESSAGE);
		return isControlDisplay(driver, HomePageUI.WELCOME_MESSAGE);
		
	}
	public boolean isMyDashboarDisplayed() {
		waitForControlVisible(driver, LiveMyDashBoardUI.MY_DASH_BOARD_LABEL);
		return isControlDisplay(driver, LiveMyDashBoardUI.MY_DASH_BOARD_LABEL);
	}
	
	
}
