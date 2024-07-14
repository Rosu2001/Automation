import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium10AddToCart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();

		String[] itemsNeeded = { "Brocolli", "Cucumber" };
		Thread.sleep(3000);
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		int j=0;
		
		for (int i = 0; i < products.size(); i++) {
			String[] name = products.get(i).getText().split("-"); // Get all the name of vegetable present
			// We have to remove - 1 kg by using split method to compare the variable
			// (Brocolli - 1 Kg to Brocolli)
			// name[0]=Brocolli , name[1]=- 1 kg (We will get space in name[0] so we have to remove it
			String formattedName=name[0].trim();

			// Convert array to arraylist
			List<String> itemsNeededList = Arrays.asList(itemsNeeded);
			
			if (itemsNeededList.contains(formattedName)) {
				// Click Add to cart
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if (j==itemsNeeded.length)
					break;
			}
		}

	}

}
