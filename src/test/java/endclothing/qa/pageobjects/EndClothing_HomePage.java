package endclothing.qa.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import endclothing.qa.base.Property;
import endclothing.qa.base.ReusableLibrary;

public class EndClothing_HomePage {

	private WebDriver driver;
	Property prop = new Property();
	ReusableLibrary lib = new ReusableLibrary();

	@FindBy(css = "button[class*='AccountButton__AccountTrigger']")
	private WebElement userIcon;
	@FindBy(id = "email")
	private WebElement emailField;
	@FindBy(css = "div[class*='AnimatedLoader__LoadedItemContainer']")
	private WebElement continueButton;
	@FindBy(id = "password")
	private WebElement passwordField;
	@FindBy(css = "button[class*='SearchButton__SearchButton']")
	private WebElement searchIcon;
	@FindBy(css = "input[class*='Autosuggest__SearchBar']")
	private WebElement searchField;
	

	public EndClothing_HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void loginToApplication(String username, String password) {
//		userIcon.click();
		lib.enterText(emailField, username);
		lib.clickElement(continueButton);
		lib.enterText(passwordField, password);
		lib.clickElement(continueButton);
	}

	public void searchProduct(String product) {
		lib.clickElement(searchIcon);
		lib.enterText(searchField, product);
		searchField.sendKeys(Keys.ENTER);
	}

}