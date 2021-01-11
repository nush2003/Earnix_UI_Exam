import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class mainTest extends mainPagePOM{
	static WebDriver driver;
	skinnyTiesPagePOM skinnyTiesPage = new skinnyTiesPagePOM(driver);
	retroSkinnyTiesPagePOM retroSkinnyTiesPage = new retroSkinnyTiesPagePOM(driver);
	searchPagePOM searchPage = new searchPagePOM(driver);
	tieBarsPagePOM tieBarsPage = new tieBarsPagePOM(driver);
	
	@BeforeClass
	public static void initDriver() {
		
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "\\Drivers\\chromedriver.exe");
		Map<String, Object> prefs = new HashMap<String, Object>();
		// Pass the argument 1 to allow and 2 to block
		prefs.put("profile.default_content_setting_values.cookies", 2);
		prefs.put("network.cookie.cookieBehavior", 2);
		prefs.put("profile.block_third_party_cookies", true);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
			
	}
  @Test
  public void part1() {
	  System.out.println("-----------------Test \"part1\"-----------------");
	  driver.get("https://skinnyties.com/");
	  searchPage.searchAndClickOnItem("BLACK POPLIN SKINNY TIE");
	  skinnyTiesPage.writeItemDef("price");
	  skinnyTiesPage.writeItemDef("description");
	  skinnyTiesPage.compareItemPrice(10); 
  }
  
  @Test
  public void part2() throws InterruptedException {
	  System.out.println("-----------------Test \"part2\"-----------------");
	  driver.get("https://skinnyties.com/");
	  retroSkinnyTiesPage.printTheSumOfTiesSize();
	  retroSkinnyTiesPage.compareTheSumOfAllProductsSize(4);
	  
	  driver.get("https://skinnyties.com/");
	  tieBarsPage.printTheSumOfTiePrices();
	  tieBarsPage.compareTheSumOfAllProductPrices(20);	  
	  
	 
  }
  
  
  @AfterClass
	public static void tearDown() {
		driver.quit();
	}
	
}
