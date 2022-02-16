package automation.suite.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import static org.junit.Assert.assertThat;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class EconomicTimesHome {

	private WebDriver driver;

	public EconomicTimesHome(WebDriver driver) {
		this.driver = driver;
	}

	public static EconomicTimesHome getObject(WebDriver driver) {
		 //TODO Auto-generated method stub
		return PageFactory.initElements(driver,EconomicTimesHome.class);
	}

	public static EconomicTimesHome navigateTo(WebDriver driver, String url) {
		driver.manage().deleteAllCookies();
		driver.navigate().to(url);
		driver.get(url);
		while ("Certificate Error: Navigation Blocked".equals(driver.getTitle())) {
			System.out.println("Certificate Error Found");
			driver.navigate().to("javascript:document.getElementById('overridelink').click()");
			driver.get(url);
			driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			
		}
		return PageFactory.initElements(driver, EconomicTimesHome.class);
	}

	public String getPageTitle() {
		return driver.getTitle().trim();
	}

	
	 
	public  void endSession() {
		driver.close();
		driver.quit();
	}
}