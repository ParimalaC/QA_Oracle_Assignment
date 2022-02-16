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
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class EconomicTimesMostReadArticles {

	private WebDriver driver;
	
	@FindBy(xpath = "//div[@data-id='1715249553']/a[text()='News']")
	private WebElement newsLink;
	
	@FindBy(xpath = "//div[contains(text(),'Most Read')]")
	private WebElement mostReadLink;
	
	@FindBy(tagName = "h1")
  private WebElement mostReadPageHeader;
	
	@FindBy(xpath= "//ul[@class='data']/li/a")
	private WebElement listHeadings;
	
	@FindBy(xpath="ul[@class='data']/li[1]/a")
	private WebElement firstLink;
	
	@FindBy(xpath="*[@class='comments open_cmnt']span[@class='cmnt_count hidden cmtDone']")
	private WebElement comments;
		
	public EconomicTimesMostReadArticles(WebDriver driver) {
		this.driver = driver;
	}

	public static EconomicTimesMostReadArticles getObject(WebDriver driver) {
		return PageFactory.initElements(driver, EconomicTimesMostReadArticles.class);
	}

	public  boolean selectMostRead(String expectedHeader) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(newsLink));
		Actions action = new Actions(driver);
        action.moveToElement(newsLink).build().perform();
		action.moveToElement(mostReadLink).click().build().perform();		
			PageFactory.initElements(driver, EconomicTimesMostReadArticles.class);
			if (!mostReadPageHeader.getText().equals(expectedHeader)) {
				System.out.println("Actual Header:" + mostReadPageHeader.getText() + "| Expected Header: " + expectedHeader);
				return false;
			}
			return true;
		}		
		public void printAllHeadings() {
	    WebDriverWait wait = new WebDriverWait(driver, 10);
		List<WebElement> headings = wait.until(ExpectedConditions.visibilityOfAllElements(listHeadings));
		for (WebElement links : headings) {
			System.out.println(links.getText());
		}
		}
		public boolean verifyMessageCount() {
			PageFactory.initElements(driver, EconomicTimesMostReadArticles.class);
			firstLink.click();
			System.out.println("===== Click " + firstLink.getText() + " firstLink=====");
		    String count =comments.getText();
		    if(Integer.parseInt(count)<=10) {
		    	return false;
		    }
		    return true;
		}
		
	
	 
	public  void endSession() {
		driver.close();
		driver.quit();
	}
}