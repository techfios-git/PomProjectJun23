package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;

public class AddCustomerTest {

	WebDriver driver;
	
	// Login Data
	String userName = "demo@codefios.com";
	String password = "abc123";
	String dashboardValidationText = "Dashboard";
	String alertUserValidationText = "Please enter your user name";
	String alertPasswordValidationText = "Please enter your password";
	String addCustomerHeaderValidationText = "New Customer";
	String fullName = "Selenium";
	String companyName = "Techfios";
	String emailAddress = "test@gmail.com";
	String phoneNum = "1234567";
	String countryName = "Algeria";

	@Test
	public void userShouldBeAbleToAddNewCustomer() {

		driver = BrowserFactory.init();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(userName);
		loginPage.insertPassword(password);
		loginPage.clickOnSigninButton();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardPage(dashboardValidationText);
		dashboardPage.clickOnCustomerMenuButton();
		dashboardPage.clickOnAddCustomerMenuButton();
		
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.validateAddCustomerPage(addCustomerHeaderValidationText);
		addCustomerPage.insertFullName(fullName);
		addCustomerPage.selectCompany(companyName);
		addCustomerPage.insertEmail(emailAddress);
	}

}
