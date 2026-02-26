package marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Decathlon {

	public static void main(String[] args) throws InterruptedException {
		// Launch the browser
		ChromeDriver driver = new ChromeDriver();

		// Maximize the window
		driver.manage().window().maximize();

		// Launch the URL
		driver.get("https://www.decathlon.in/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

		driver.findElement(By.xpath("//span[@class='index-module_type__E-SaG']")).click();

		driver.findElement(By.xpath("//span[text()='Shoes For Men']")).click();
		driver.findElement(By.xpath("//span[text()='Running (41)	']")).click();

		// Click on the Gender filter dropdown
		driver.findElement(By.xpath("//span[@class='aisRefinementListLabelText']")).click();

		// Click on the Sort By dropdown
		driver.findElement(By.xpath("//span[text()='Most Relevant']")).click();

		//Select High DIscount 
		driver.findElement(By.xpath("//a[text()='Highest Discount']")).click();
		Thread.sleep(4000);

		// From the filtered results, click on the first available product
		driver.findElement(By.xpath("//span[@class='text-14 lg:text-16 font-semibold']")).click();
		
		//Select Size 
		WebElement findElement = driver.findElement(By.xpath("//div[contains(text(),'8.5')]"));
		driver.executeScript("arguments[0].click();", findElement);

		// Add to cart
		Thread.sleep(5000);
		WebElement clickBelow = driver.findElement(By.xpath("//span[text()='ADD TO CART']"));
		driver.executeScript("arguments[0].click();", clickBelow);
		
		//Verify that the product is successfully added to the cart
		String cart = driver.findElement(By.xpath("//a[@aria-label='cart']/div/div/div")).getText();

		int cartNumber = Integer.parseInt(cart);

		if (cartNumber > 0) {
			System.out.println("Total " + cartNumber + " in the cart");

		} else {
			System.out.println("No products added in the car");
		}

	}

}