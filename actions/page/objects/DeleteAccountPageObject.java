package page.objects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import page.ui.LoginPageUI;
import page.ui.RegisterPageUI;

public class DeleteAccountPageObject extends AbstractPage{
	
	WebDriver driver;
	public DeleteAccountPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
	

}
