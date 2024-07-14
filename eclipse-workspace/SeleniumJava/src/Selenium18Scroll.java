import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Selenium18Scroll {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		// Lecture - 100 (Handle scroll)
		JavascriptExecutor js=(JavascriptExecutor)driver; //Knowledge of driver will be placed on js object
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");
		
		// Lecture - 101 (Calculate amount value from table)
		List<WebElement> values=driver.findElements(By.xpath("//div[@class='tableFixHead']/table/tbody/tr/td[4]"));
		int sum=0;
		for(int i=0;i<values.size();i++) {
			sum=sum + Integer.parseInt(values.get(i).getText());		
		}
		System.out.println(sum);
		
		// Lecture 103 (parse string and get the count from web page and compare the value)
		System.out.println(driver.findElement(By.xpath("//div[@class='totalAmount']")).getText());
		String val=driver.findElement(By.xpath("//div[@class='totalAmount']")).getText();
		String[] arr=val.split(" ");
		int total=Integer.parseInt(arr[3]);
		Assert.assertEquals(sum, total);
		
	}
}
