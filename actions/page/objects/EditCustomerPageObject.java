package page.objects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import page.ui.LoginPageUI;
import page.ui.RegisterPageUI;

public class EditCustomerPageObject extends AbstractPage{
	
	WebDriver driver;
	public EditCustomerPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
	

}
