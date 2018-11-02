package live.pageObjects;

import org.openqa.selenium.WebDriver;

import page.objects.LoginPageObject;

//Quan ly tap trung nhung phan khoi tao cua page object
public class PageFactoryManager {
	private WebDriver driver;
	
	
	public static MyAccountPageObject getMyAccountPage(WebDriver driver) {
		return new MyAccountPageObject(driver);
	}
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	public static MyDashbboardPageObject getMyDashboardPage(WebDriver driver) {
		return new MyDashbboardPageObject(driver);
	}
	
}
