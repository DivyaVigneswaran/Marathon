package marathon;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import week6.day16.ReadValuesFromExcel;

public class SalesForce_projectspecification {
	RemoteWebDriver driver;
	String filename;

	@Parameters({ "url", "username", "passWord" })
	@BeforeMethod
	public void postcondition(String URL, String Username, String Password) {

		// Launch Browser
		ChromeOptions options = new ChromeOptions();
		options.addArguments("user-data-dir=/Users/vigneswaranmurugesan/SeleniumProfile");
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Login to https://login.salesforce.com
		driver.get(URL);
		driver.findElement(By.id("username")).sendKeys(Username);
		driver.findElement(By.id("password")).sendKeys(Password);
		driver.findElement(By.id("Login")).click();
		// Click toggle
		WebDriverWait wait = new WebDriverWait((WebDriver) driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='App Launcher']"))).click();

		// Click View All
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		// Click Sales
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
	}

	@AfterMethod
	public void postcondition() {
		driver.close();

	}

	@DataProvider(name = "getValue")
	public String[][] fetchData() throws IOException {

		return ReadValuesFromExcel.getValue(filename);
	}
}
