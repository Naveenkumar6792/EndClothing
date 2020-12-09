package endclothing.qa.base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ReusableLibrary {

	public void clickElement(WebElement element) {
		element.click();
	}

	public void enterText(WebElement element, String text) {
		element.sendKeys(text);
	}

	public void selectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public void selectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void selectByVisibleText(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}

	public String getElementText(WebElement element) {
		String text = element.getText();
		return text;
	}
}
