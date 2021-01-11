import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;

public class tieBarsPagePOM extends mainPagePOM{
	WebDriver driver;
	int allTiesPrice = 0;	
	
	
	By tieBarsList = By.xpath("//*[@id=\"shopify-section-collection-template\"]/section/div[3]/div[1]/div[2]/div/div/div");
		
	
	
	public tieBarsPagePOM(WebDriver driver) {		
		this.driver = driver;		
	}
	
	public void printTheSumOfTiePrices(){		
		
		clickOnTieBarsLink(driver);	
		List<WebElement> tieList =driver.findElements(tieBarsList);
		
		
		for (WebElement el : tieList) {			
			String text = el.findElement(By.xpath("./div/div/div/div/span")).getAttribute("innerHTML");
			allTiesPrice += Integer.parseInt(text.replace("$", ""));			
		}	
		
		System.out.println("The sum of all the displayed product's prices  is: " + allTiesPrice);		 
	}
	
	public void compareTheSumOfAllProductPrices(double numToCompare) {
		
		Assert.assertTrue("Verification Failed: The total sum of all product's prices is not greater then " + numToCompare, allTiesPrice>numToCompare); 
		
	}


}
