import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class searchPagePOM extends mainPagePOM {
WebDriver driver;
	
	
	By searchTypeField = By.xpath("//*[@id=\"Search\"]/div/div[1]/form/input[1]");
	By searchContentField = By.xpath("//*[@id=\"Search\"]/div/div[2]/div/div[2]/div");
	By searchedItem = By.xpath("//*[@id=\"Search\"]/div/div[2]/div/div[2]/div/div/div/div/a/div");
	
	
	
	public searchPagePOM(WebDriver driver) {		
		this.driver = driver;		
	}
//	public void clickOnSearchLink() {
//		driver.findElement(searchLink).click();
//	}
//	
	
	public void searchAndClickOnItem(String itemName) {
		clickOnSearchLink(driver);
		driver.findElement(searchTypeField).sendKeys(itemName);
		
		Wait<WebDriver> wait = new WebDriverWait(driver,10).withMessage("There is no such item");	 
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchContentField));
        
        driver.findElement(searchedItem).click(); 
	}
	

}
