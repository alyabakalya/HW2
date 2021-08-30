package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
public class BasePage {
	public BasePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public BasePage clickElement(WebElement element) {
		element.click();
		return this;
	}

	public BasePage sendValueToInputField(WebElement element, String value) {
		element.sendKeys(value);
		return this;
	}
}
