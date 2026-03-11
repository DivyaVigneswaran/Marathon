package marathon;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TataCliq_Mar6 {

	public static void main(String[] args) throws InterruptedException, IOException {
		// Launch the Browser
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Load the URL
		driver.get("https://www.tatacliq.com/");

		// Click Brands
		WebElement Brands = driver.findElement(By.xpath("//div[text()='Brands']"));
		Actions act = new Actions(driver);
		act.moveToElement(Brands).perform();

		// Watch and Accessories
		Thread.sleep(200);
		WebElement WatchandAccessories = driver.findElement(By.xpath("//div[text()='Watches & Accessories']"));
		act.moveToElement(WatchandAccessories).perform();

		// Select First option from the 'Featured brands
		// Thread.sleep(5000);
		WebElement Casio = driver.findElement(By.xpath("//div[text()='Casio']"));
		act.moveToElement(Casio).perform();
		Casio.click();

		// Sort By new Arrival
		WebElement dropDown = driver.findElement(By.className("SelectBoxDesktop__hideSelect"));
		Select sel = new Select(dropDown);
		sel.selectByVisibleText("New Arrivals");

		// Filter by Clicking Men
		driver.findElement(By.xpath("(//div[@class='FilterDesktop__newFilCheckbox'])[1]")).click();

		// Print All Watch Prices
		// List<WebElement> WatchPrice =
		// driver.findElements(By.xpath("//div[contains(@class,'ProductDescription__priceHolder')]"));
		// String firstWatchPrice = WatchPrice.get(0).getText();
		// for (WebElement price : WatchPrice)
		// System.out.println(price.getText());

		Thread.sleep(6000);
		// click on the first watch
		WebElement firstWatch = driver.findElement(By.xpath("(//div[@class='ProductModule__dummyDiv'])"));
		firstWatch.click();

		// switch to product window
		Set<String> openedWindowIDs = driver.getWindowHandles();
		List<String> openedWindowIDsList = new ArrayList<>(openedWindowIDs);
		driver.switchTo().window(openedWindowIDsList.get(1));

		// Print the Price
		WebElement WatchPrice2 = driver.findElement(By.xpath("//div[@class='ProductDetailsMainCard__price']"));
		String WP2 = WatchPrice2.getText();
		System.out.println("Price of the Price is " + WP2);

		// Add to Cart
		WebElement AddTOCart = driver.findElement(By.xpath("(//div[@class='Button__base'])[3]"));
		act.scrollToElement(AddTOCart).perform();
		AddTOCart.click();

		// Get theCart Count
		String cartCount = driver.findElement(By.xpath("//span[@class='DesktopHeader__cartCount']")).getText();
		System.out.println("Cart Count: " + cartCount);

		// Click Cart
		driver.findElement(By.xpath("//div[@class='DesktopHeader__myBagShow']")).click();

		// To get the SCreenshot
		File screenshotAs = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		File target = new File("./data/TataCliq.png");
		FileUtils.copyFile(screenshotAs, target);

		// Close Child Window
		driver.close();

		// Switch to Parent Window
		driver.switchTo().window(openedWindowIDsList.get(0));
		driver.close();

	}

}
