import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class Selenium24RelativeLocators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		
		// Lecture - 122 (Relative Locators)
		// Geting Name Label of the edit box by using above method
		WebElement nameBox=driver.findElement(By.xpath("(//input[@name='name'])[1]"));
		System.out.println(driver.findElement(with(By.tagName("label")).above(nameBox)).getText());
		
		// Lecture - 123
		WebElement checkBox=driver.findElement(By.cssSelector("[for='exampleCheck1']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(checkBox)).click();
		
		WebElement radiobtn=driver.findElement(By.id("inlineRadio1 "));
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(radiobtn)).getText());
		
		//Getting label by using driver anfd then using below method to access the field associated with it
		WebElement dobBox=driver.findElement(By.cssSelector("[for='dateofBirth']"));
		driver.findElement(with(By.tagName("input")).below(dobBox)).click();

	}

}
