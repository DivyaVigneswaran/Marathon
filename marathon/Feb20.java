package marathon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Feb20 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.pvrcinemas.com/");
		
		//Cinema under Quick Book
		driver.findElement(By.className("cinemas-inactive")).click();
		WebElement findElement = driver.findElement(By.xpath("//span[text()='Select Cinema']"));
		driver.executeScript("arguments[0].click();", findElement);
		
		//Select Cinema
		driver.findElement(By.xpath("//span[text()='INOX Chennai Citi Centre,Dr. R. K. Salai Chennai']")).click();
		
		//Select Date
		driver.findElement(By.xpath("//span[text()='Tomorrow']")).click();
		
		//Select Movie
		driver.findElement(By.xpath("//li[@class='p-dropdown-item'][2]")).click();
		
		//Select Time
		driver.findElement(By.xpath("//span[text()='03:50 PM'][1]")).click();
		
		//Click Book
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
		
		//Accept Terms and Conditions
		driver.findElement(By.xpath("//button[text()='Accept']")).click();
		
		//Select Seat
		driver.findElement(By.xpath("//span[@id='CL.Club|F:1']")).click();
		
		//Click Proceed
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
		
		//Print the Selected seat
		String text = driver.findElement(By.xpath("//div[@class='seat-number']//p")).getText();
		System.out.println("Seat No. : "+text);
		
		Thread.sleep(4000);
		
		//Print the Grand Total
		String text2 = driver.findElement(By.xpath("//div[@class='grand-tota col-md-3']")).getText();
		System.out.println("Grand total is " +text2);

		//Click Continue
		driver.findElement(By.xpath("//button[text()='Continue']")).click();
		Thread.sleep(5000);
		
		//Popup close
		driver.findElement(By.xpath("(//i[@class='pi pi-times'])[2]")).click();
		
		//Current Page title.
		String title = driver.getTitle();
		System.out.println("Current Page Title is :" + title);
		
		driver.close();
		
		
		
		
		
	}

}
