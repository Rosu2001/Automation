import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Selenium15Frames {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		// Lecture - 91 and 92 (Handle Frames)
		driver.get("https://jqueryui.com/droppable/");
		System.out.println(driver.findElements(By.tagName("iframe")).size());   // Return the count of frame available in page
		WebElement ele=driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(ele);
		driver.findElement(By.id("draggable")).click(); // To check it is clickable or not
		Actions a=new Actions(driver);
		WebElement source=driver.findElement(By.id("draggable"));
		WebElement destination=driver.findElement(By.id("droppable"));
		a.dragAndDrop(source, destination).build().perform();
		driver.switchTo().defaultContent();
	}
}
