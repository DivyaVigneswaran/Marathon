package marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class amazonSearch {

	public static void main(String[] args) {
		
		//Launch Browser
		ChromeDriver driver = new ChromeDriver();

		//Maximize the browser
		driver.manage().window().maximize();
		
		//Launch the browser
		driver.get("https://www.amazon.in/");
		
		//wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//"Bags for boys" in the search box
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Bags for boys");
		
		//Select the searched suggestion 
		driver.findElement(By.xpath("//div[@class='s-suggestion-container']/div[1]")).click();
		
		//total number of search results displayed
		String findElement = driver.findElement(By.xpath("//h2[@class='a-size-base a-spacing-small a-spacing-top-small a-text-normal']")).getText();
		System.out.println("Total number of search results displayed are :" + findElement);
		
		//Select "New Arrivals"
		WebElement findElement2 = driver.findElement(By.xpath("//select[@name='s']"));
		Select drop=new Select(findElement2);
		drop.selectByVisibleText("Newest Arrivals");
		
		//print the first product name
		String findElement3 = driver.findElement(By.xpath("//h2[@class='a-size-mini s-line-clamp-1'][1]/span")).getText();
		System.out.println("Product Name :"+ findElement3 );
		
		//print the first product Price
		String findElement4 = driver.findElement(By.xpath("//span[@class='a-price-whole'][1]")).getText();
		System.out.println("Product Discounted Price :"+ findElement4);
		
		//Page Title
		String title = driver.getTitle();
		System.out.println("Title of the page is : " + title);
		
		driver.close();
		
		
		

	}

}
