package CucumberStepDefinitions;

import static org.assertj.core.api.SoftAssertions.assertSoftly;
import java.util.List;
import Pages.*;
import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SearchForProductStepDefinitions {
	WebDriver driver;
	HomePage homePage;

	@When("I open the Initial home page")
	public void openInitialPage() {
		String browser = System.getProperty("browser");

		switch (browser) {
			case "Chrome":
				driver = new ChromeDriver();
				System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
				break;
			case "Firefox":
				driver = new FirefoxDriver();
				System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
				break;
			default:
				throw new IllegalStateException("This driver is not supported");
		}

		homePage = new HomePage(driver);
		PageNavigation.openPage(driver, "https://www.bookdepository.com/");
	}

	@And("^I search for ([\\w\\s]+)$")
	public void searchForProduct(String searchTerm) {
		homePage.enterSearchTerm(searchTerm).clickOnSearchButton();
	}

	@And("Search results are not empty")
	public void verifyThatSearchResultsAreNotEmpty() {
		List<WebElement> books = driver.findElements(By.xpath("//div[@class='book-item']"));
		assertSoftly(softAssertions -> {
			softAssertions.assertThat(books).isNotEmpty();
		});
		driver.quit();
	}
}