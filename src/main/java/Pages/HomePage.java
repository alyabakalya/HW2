package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

		@FindBy(xpath = "//input[@name='searchTerm']")
		WebElement searchInputField;

		@FindBy(xpath = "//button[@aria-label='Search']")
		WebElement searchButton;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public Pages.HomePage enterSearchTerm(String searchTerm) {
			sendValueToInputField(searchInputField, searchTerm);
			return this;
		}

		public void clickOnSearchButton() {
			clickElement(searchButton);
		}
	}

