import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Selenium23TableSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Lecture -116 (Perform web table sorting using selenium and java stream)
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
//		Click on column
		driver.findElement(By.xpath("//tr/th[1]")).click();
//		capture all webelement into list
		List<WebElement> elementList = driver.findElements(By.xpath("//tr/td[1]"));
//		 capture text of all webelements into new (original) list
		List<String> originalList = elementList.stream().map(s -> s.getText()).collect(Collectors.toList());
//		sort on the list ---> sorted list
		List<String> newList = originalList.stream().sorted().collect(Collectors.toList());
//		Compare original list and new list
		Assert.assertTrue(originalList.equals(newList));

		// Lecture -117 (stream mapper - build custom selenium method)
//		scan the coln name with getText -> If Beans ->print price of rice
/* 		It will only search for element which is present on the first page, but if it will present on
		next page ---- We have to click nextpage button and search the element ??????    */
		
		// Lecture -118 ( If element is not present on first page ---- Pagination concept )
		List<String> price;
		do {
			List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
			price = rows.stream().filter(s -> s.getText().contains("Rice")).map(s -> getPriceVeggie(s))
				.collect(Collectors.toList());
			price.forEach(a -> System.out.print(a));
			if(price.size()<1) {
				driver.findElement(By.cssSelector("[aria-label='Next']")).click();
			}
		} 
		while(price.size()<1);
		
		
		// Lecture - 120 ( Filter web table using Java Streams)
//		Search the name in the search box and check all the element got is matched with the same name or not
		driver.findElement(By.id("search-field")).sendKeys("Rice");
		List<WebElement> veggies=driver.findElements(By.xpath("//tr/td[1]"));
		List<WebElement> filterList=veggies.stream().filter(veggie->veggie.getText().contains("Rice")).collect(Collectors.toList());
		Assert.assertEquals(veggies.size(), filterList.size());
	}

	private static String getPriceVeggie(WebElement s) {
		// TODO Auto-generated method stub
		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceValue;
	}

}
