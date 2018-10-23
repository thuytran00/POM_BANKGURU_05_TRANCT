package page.objects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import page.ui.HomePageUI;
import page.ui.LoginPageUI;
import page.ui.RegisterPageUI;
import page.ui.WithdrawPageUI;

public class WithdrawPageObject extends AbstractPage{
	
	WebDriver driver;
	public WithdrawPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
	

}
