package page.objects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import page.ui.HomePageUI;
import page.ui.LoginPageUI;
import page.ui.NewCustomerPageUI;
import page.ui.RegisterPageUI;

public class NewCustomerPageObject extends AbstractPage{
	
	WebDriver driver;
	public NewCustomerPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
	

}
