package automation.suite;

import org.testng.annotations.Test;
import automation.suite.pages.EconomicTimesMostReadArticles;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class EconomicTimesTest extends BaseTest {
	private WebDriver driver;

	@Test
	public void verifyMostReadLinkTitle() throws InterruptedException {
		EconomicTimesMostReadArticles ET = EconomicTimesMostReadArticles.getObject(driver);
		String expectedHeader = "Most Read Business News";
	   Assert.assertEquals(ET.selectMostRead(expectedHeader), true, "Page header Mismatch");

	}

	@Test
	public void fetchHeadingsOfAllMostReadNews() {
		EconomicTimesMostReadArticles ET = EconomicTimesMostReadArticles.getObject(driver);
		ET.printAllHeadings();
	}
	
	@Test
	public void verifyMessageCountOfFirstArticle() {
		EconomicTimesMostReadArticles ET = EconomicTimesMostReadArticles.getObject(driver);
       Assert.assertEquals(ET.verifyMessageCount(), true, "messages less than 10");
       
        
        
		
	}

}
