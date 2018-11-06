package live.pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import live.pageUIs.LiveMyDashBoardUI;
import page.ui.LoginPageUI;
import page.ui.RegisterPageUI;

public class TVPageObject extends AbstractPage{
	
	WebDriver driver;
	public TVPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
	
}
