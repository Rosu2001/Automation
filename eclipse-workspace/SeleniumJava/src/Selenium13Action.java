import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Selenium13Action {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");

		// Lecture - 86
		Actions a = new Actions(driver);
		WebElement move = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));

		// Lecture - 87
		// keyDown(keys.SHIFT) ---- Enter in capital letter by using shift button
		// doubleClick for selecting the text/element
		// contextClick for right click on the element
		a.moveToElement(driver.findElement(By.xpath("//input[@type='text']"))).click().keyDown(Keys.SHIFT)
				.sendKeys("hello").doubleClick();
		a.moveToElement(move).contextClick().build().perform();

	}

}