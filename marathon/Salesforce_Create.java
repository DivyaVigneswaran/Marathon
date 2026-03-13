package marathon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Salesforce_Create extends SalesForce_projectspecification {

	@BeforeClass
	public void setData() {
		filename="SalesForce";
	}
	@Test(dataProvider = "getValue")
	public void create_salesforce(String name, String Amount) {
		// Click Opportunity tab
		WebElement opportunities = driver.findElement(By.xpath("//a[@title='Opportunities']"));
		driver.executeScript("arguments[0].click();", opportunities);

		// New
		driver.findElement(By.xpath("//div[@title='New']")).click();

		// Opportunity Name
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(name);

		// Amount
		driver.findElement(By.xpath("//input[@name='Amount']")).sendKeys(Amount);

		// Chose the Close day
		driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
		driver.findElement(By.xpath("//button[@name='today']")).click();

		// Select Stage
		driver.findElement(By.xpath("//button[@aria-label='Stage']")).click();
		WebElement needsAnalysis=driver.findElement(By.xpath("//span[text()='Needs Analysis']"));
		driver.executeScript("arguments[0].click();", needsAnalysis);

		// Click Save
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
	}

}
