package CucumberStepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Pages.HomePage;
import Pages.PageNavigation;
import io.cucumber.java.en.*;


public class NegativeSearchTestStepDefinitions {
	WebDriver driver;
	HomePage homePage;

	@Given("User opens Home Page")
	public void userOpensHomePage() {
		String browser = System.getProperty("browser");

		switch (browser) {
			case "Chrome":
				System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
				driver = new ChromeDriver();
				break;
			case "Firefox":
				System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
				driver = new FirefoxDriver();
				break;
			default:
				throw new IllegalStateException("This driver is not supported");
		}

		homePage = new HomePage(driver);
		PageNavigation.openPage(driver, "https://www.bookdepository.com/");
	}

	@And("User clicks on Search button without entering any search term")
	public void clickOnSearchButton() {
		homePage.clickOnSearchButton();
	}

	@Then("^User is redirected to Advanced Search page with the following URL ((?:http|https):\\/\\/[\\w+./?=&]+)$")
	public void verifyUserIsRedirectedToCorrectPage(String expectedURL) {
		Assert.assertEquals("Page URL is incorrect", expectedURL, driver.getCurrentUrl());
		driver.quit();
	}
}
