package marathon;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SalesForce_Delete extends SalesForce_projectspecification {

	@BeforeClass
	public void setData() {
		filename = "SalesForce_Delete";
	}

	@Test(dataProvider = "getValue")
	public void delete_salesforce(String name, String Desc) throws InterruptedException {
		// Click Opportunity tab
		WebElement opportunities = driver.findElement(By.xpath("//a[@title='Opportunities']"));
		driver.executeScript("arguments[0].click();", opportunities);

		// Search in the list
		driver.findElement(By.xpath("//input[@name='Opportunity-search-input']")).sendKeys(name, Keys.ENTER);

		// DropDown
		WebElement dropdown = driver.findElement(
				By.xpath("//button[@class='slds-button slds-button_icon-border slds-button_icon-x-small']"));
		driver.executeScript("arguments[0].click();", dropdown);

		// Click Delete
		Thread.sleep(3000);
		WebElement delete=driver.findElement(By.xpath("//div[text()='Delete']")); //div[text()='Delete']
		driver.executeScript("arguments[0].click();", delete);
		driver.findElement(By.xpath("//span[text()='Delete']")).click();

	}
}
