import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class mainPagePOM {
	//WebDriver driver;
	
	By searchLink = By.xpath("//*[@id=\"section-header\"]/div/div[3]/nav/ul/li[1]/a");
	By menuPatternLink = By.xpath("//*[@id=\"section-header\"]/div/div[1]/nav/ul/li[5]/a");
	By menuPatternRetroLink = By.xpath("//*[@id=\"section-header\"]/div/div[1]/nav/ul/li[5]/div/ul/li[3]/a");
	By tieBarsLink = By.xpath("//*[@id=\"section-header\"]/div/div[1]/nav/ul/li[6]/a");
	
	

	
	public void clickOnSearchLink(WebDriver driver) {
		driver.findElement(searchLink).click();
	}
	
	public void clickOnPatternRetroLink(WebDriver driver){
		Actions action = new Actions(driver);		
		action.moveToElement(driver.findElement(menuPatternLink)).build().perform();
		
		driver.findElement(menuPatternRetroLink).click();
	}
	
	public void clickOnTieBarsLink(WebDriver driver) {
		driver.findElement(tieBarsLink).click();
	}
	
	
}
