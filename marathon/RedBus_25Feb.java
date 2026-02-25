package marathon;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RedBus_25Feb {

	public static void main(String[] args) throws InterruptedException {

		// Launch the browser
		ChromeDriver driver = new ChromeDriver();

		// Launch the URL
		driver.get("https://www.redbus.in/");

		// Maximize the window
		driver.manage().window().maximize();
		
		//Select Source City
		driver.findElement(By.xpath("//input[@id='srcinput']")).sendKeys("Hyderabad");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	
		driver.findElement(By.xpath("//div[text()='Hyderabad']")).click();
		

		//Select Destination city
		driver.findElement(By.xpath("//input[@id='destinput']")).sendKeys("Bangalore");

		driver.findElement(By.xpath("//div[text()='Bangalore']")).click();

		//Select Date
		driver.findElement(By.xpath("//button[text()='Tomorrow']")).click();

		//CLick Search
		driver.findElement(By.xpath("//button[@aria-label='Search buses']")).click();
		Thread.sleep(3000);
		
		//Print the Total number of buss displayed
		String findElement = driver.findElement(By.xpath("//span[@class='subtitle___66e96d']")).getText();
		System.out.println("Total Number of Buses Dispalyed are " + findElement);

		// Select AC FIlter
		driver.findElement(By.xpath("//div[@aria-label='AC (194)']")).click();

		// Select High Rated Buses
		driver.findElement(By.xpath("//div[contains(text(), 'High Rated Buses')]")).click();

		// Display Bus Prices
		List<WebElement> busPrices = driver.findElements(By.xpath("//p[@class='finalFare___0b90fc']"));
		// Adding all busprices into List Integer
		List<Integer> bPrices = new ArrayList<>();

		for (WebElement e : busPrices) {
			int buspr = Integer.parseInt(e.getText().replaceAll("[^0-9.]", "")); // replacing NOT a digit
			bPrices.add(buspr);
		}
		Collections.sort(bPrices); // Sorting the order

		System.out.println("Lowest Bus Price is " + bPrices.get(0));
		System.out.println("Title Page is " + driver.getTitle());

	}
}