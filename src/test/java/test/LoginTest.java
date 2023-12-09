package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.BasePage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;

public class LoginTest {

	WebDriver driver;

	// Login Data
	String userName = "demo@codefios.com";
	String password = "abc123";
	String dashboardValidationText = "Dashboard";
	String alertUserValidationText = "Please enter your user name";
	String alertPasswordValidationText = "Please enter your password";
	

	@Test
	public void validUserShouldBeAbleToLogin() {

		driver = BrowserFactory.init();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(userName);
		loginPage.insertPassword(password);
		loginPage.clickOnSigninButton();
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardPage(dashboardValidationText);
		BrowserFactory.tearDown();
	}
	
	
}
