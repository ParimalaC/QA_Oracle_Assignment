package automation.suite;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import automation.suite.pages.EconomicTimesHome;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
private WebDriver driver;

@BeforeSuite
public void setUp() {
	WebDriverManager.chromedriver().clearResolutionCache();
	WebDriverManager.chromedriver().clearDriverCache();
	WebDriverManager.chromedriver().forceDownload().setup();
	ChromeOptions c_options = new ChromeOptions();
	c_options.addArguments("disable-infobars");
	c_options.addArguments("start-maximized");
	c_options.addArguments("enable-automation");
	c_options.addArguments("--no-sandbox");
	c_options.addArguments("--disable-dev-shm-usage");
	c_options.addArguments("--disable-browser-side-navigation");
	c_options.addArguments("--disable-gpu");
	c_options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
	c_options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	c_options.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);

	driver = new ChromeDriver(c_options);
}
	@BeforeTest
	public void navigateToEconomicTimes() {
		String url="https://economictimes.indiatimes.com/";
		EconomicTimesHome Et = EconomicTimesHome.navigateTo(driver,url);
		String expectedTitle = "Business News Today: Read Latest Business news, India Business News Live, Share Market & Economy News | The Economic Times";
		Assert.assertEquals(Et.getPageTitle(),expectedTitle);
		
	}
	@AfterTest
	public void endSession() {
		driver.close();
		driver.quit();
		
	}

}
