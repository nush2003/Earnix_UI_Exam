import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class skinnyTiesPagePOM {
WebDriver driver;
	
	By itemPrice = By.xpath("//*[@id=\"shopify-section-product-template\"]/section/div[1]/div[2]/div/div/div/div[1]/span");
	By itemDescription = By.xpath("//*[@id=\"shopify-section-product-template\"]/section/div[1]/div[2]/div/div/div/div[2]/div[1]");
	
	String itemPrice2;
	
	
	public skinnyTiesPagePOM(WebDriver driver) {		
		this.driver = driver;		
	}
	
	public void writeItemDef(String def) {
		By definition = null;
			
		switch(def) {
			case "price":
				definition = itemPrice;				
			    break;
			case "description":
				definition = itemDescription;				
			    break;
		}		
		System.out.println("The " + def + " is: " + driver.findElement(definition).getText());
	}
	
	public void compareItemPrice(int priceToCompare) {
		
		int price = Integer.parseInt(driver.findElement(itemPrice).getText().replace("$", ""));
		
		
		Assert.assertTrue("Verification Failed: The price of item is not greater then " + priceToCompare, price>priceToCompare); 
	}
	
	

}
