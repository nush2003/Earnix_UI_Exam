import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class retroSkinnyTiesPagePOM extends mainPagePOM{
	WebDriver driver;
	double allTiesSize = 0;
	
	
	By retroSkinnyTiesList = By.xpath("//*[@id=\"shopify-section-collection-template\"]/section/div[3]/div[1]/div[2]/div/div/div");
	
	
	
	
	public retroSkinnyTiesPagePOM(WebDriver driver) {		
		this.driver = driver;		
	}
	
	public void printTheSumOfTiesSize(){		
		
		clickOnPatternRetroLink(driver);			
		List<WebElement> tiesList =driver.findElements(retroSkinnyTiesList);
		
		for (WebElement el : tiesList) {			
			String text = el.findElement(By.xpath("./div/div/div/h2/a")).getAttribute("innerHTML");
			allTiesSize += Double.parseDouble(text.substring(0, text.indexOf("\"")));			
		}	
		
		System.out.println("The sum of all the displayed product's sizes is: " + allTiesSize);		 
	}
	
	public void compareTheSumOfAllProductsSize(double numToCompare) {
		
		Assert.assertTrue("Verification Failed: The total sum of all product's sizes sis not greater then " + numToCompare, allTiesSize>numToCompare); 
		
	}


}
