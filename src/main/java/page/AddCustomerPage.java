package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddCustomerPage extends BasePage{
	
WebDriver driver;
	
	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/section/div/div[2]/div/div[1]/div[1]/div/div/header/div/strong") WebElement addCustomerHeaderElement;
	@FindBy(how = How.XPATH, using = "//*[@id=\"general_compnay\"]/div[1]/div/input") WebElement fullNameElement;
	@FindBy(how = How.XPATH, using = "//*[@id=\"general_compnay\"]/div[2]/div/select") WebElement companyElement;
	@FindBy(how = How.XPATH, using = "//*[@id=\"general_compnay\"]/div[3]/div/input") WebElement emailElement;

	
	public void validateAddCustomerPage(String addCustomerHeaderText) {
		validateElement(addCustomerHeaderElement, addCustomerHeaderText, "Add Customer Page is not available!!");
	}
	
	public void insertFullName(String fullName) {
		fullNameElement.sendKeys(fullName + generateRandomNum(999));
	}
	
	public void selectCompany(String company) {
		selectFromDropDown(companyElement, company);
	}
	
	public void insertEmail(String email) {
		emailElement.sendKeys(generateRandomNum(999) + email);
	}
	
}
