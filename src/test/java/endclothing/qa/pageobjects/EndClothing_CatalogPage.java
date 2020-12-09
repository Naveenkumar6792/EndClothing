package endclothing.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import endclothing.qa.base.Property;
import endclothing.qa.base.ReusableLibrary;

public class EndClothing_CatalogPage {

	private WebDriver driver;
	Property prop = new Property();
	ReusableLibrary lib = new ReusableLibrary();

	@FindBy(css = "div[class*='PlpContainer__PlpGrid'] > a:nth-child(1) span[class*='ProductCard__ProductName']")
	private WebElement productSelection;
	@FindBy(css = "div[class*='SizeSelector__SizeGrid'] > div:nth-child(3)")
	private WebElement sizeSelection;
	@FindBy(xpath = "//div[contains(text(),'Add To Cart')]")
	private WebElement addToCart;
	@FindBy(xpath = "//a[contains(text(),'Checkout Securely')]")
	private WebElement checkoutSecurely;

	public EndClothing_CatalogPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void selectProduct() {
		lib.clickElement(productSelection);
		lib.clickElement(sizeSelection);
	}

	public void clickAddToCart() {
		lib.clickElement(addToCart);
	}

	public void clickCheckoutSecurely() {
		lib.clickElement(checkoutSecurely);
	}

}