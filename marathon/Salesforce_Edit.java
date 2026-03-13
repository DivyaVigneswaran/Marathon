package marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Salesforce_Edit extends SalesForce_projectspecification {
	@BeforeClass
	public void setData() {
		filename = "SalesForce_Edit";
	}

	@Test(dataProvider = "getValue")
	public void create_salesforce(String name, String Desc) throws InterruptedException {
		// Click Opportunity tab
		WebElement opportunities = driver.findElement(By.xpath("//a[@title='Opportunities']"));
		driver.executeScript("arguments[0].click();", opportunities);

		// Search in the list
		driver.findElement(By.xpath("//input[@name='Opportunity-search-input']")).sendKeys(name, Keys.ENTER);

		// DropDown
		WebElement dropdown = driver.findElement(
				By.xpath("//button[@class='slds-button slds-button_icon-border slds-button_icon-x-small']"));
		driver.executeScript("arguments[0].click();", dropdown);

		// Click Edit
		driver.findElement(By.xpath("//a[@title='Edit']")).click();

		// Select Date
		// driver.findElement(By.xpath("//span[text()='14']")).click();

		// Stage
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		wait.until(ExpectedConditions.elementToBeClickable(
		        By.xpath("//button[@aria-label='Stage']"))).click();

		WebElement perceptionAnalysis = wait.until(ExpectedConditions.visibilityOfElementLocated(
		        By.xpath("//span[@title='Perception Analysis']")));

		driver.executeScript("arguments[0].click();", perceptionAnalysis);

		// Delivery and Installation
		WebElement delivery = driver.findElement(By.xpath("//button[@aria-label='Delivery/Installation Status']"));
		Actions act = new Actions(driver);
		act.scrollToElement(delivery).perform();
		driver.executeScript("arguments[0].click();", delivery);
		
		//Select In Progress
		driver.findElement(By.xpath("//span[@title='In progress']")).click();
		
		//Describtion
		driver.findElement(By.xpath("//textarea[@class='slds-textarea']")).sendKeys(Desc);

		// Save
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();

	}
}
